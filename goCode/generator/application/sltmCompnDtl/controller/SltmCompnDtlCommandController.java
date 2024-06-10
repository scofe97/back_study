package org.okestro.tps.api.application.sltmCompnDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlCreateRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlUpdateRequest;
import org.okestro.tps.api.domain.sltmCompnDtl.SltmCompnDtlCommandService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sltmCompnDtl/v1")
@Tag(name = "결재사전정보상세 Command API", description = "TB_TPS_WK_022")
public class SltmCompnDtlCommandController {

    private final SltmCompnDtlCommandService commandService;

    @Operation(summary = "결재사전정보상세 생성", description = "결재사전정보상세 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createSltmCompnDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody SltmCompnDtlCreateRequest createRequest) {
        commandService.createSltmCompnDtl(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "결재사전정보상세 수정", description = "결재사전정보상세 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updateSltmCompnDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody SltmCompnDtlUpdateRequest updateRequest) {
        commandService.updateSltmCompnDtl(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "결재사전정보상세 제거", description = "결재사전정보상세 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deleteSltmCompnDtl(@RequestBody List<SltmCompnDtlSelectRequest> deleteRequests) {
        commandService.deleteSltmCompnDtl(deleteRequests);
        return TpsResponse.success(null);
    }
}
