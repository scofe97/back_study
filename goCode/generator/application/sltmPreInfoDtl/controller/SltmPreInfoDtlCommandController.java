package org.okestro.tps.api.application.sltmPreInfoDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlCreateRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlSelectRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlUpdateRequest;
import org.okestro.tps.api.domain.sltmPreInfoDtl.SltmPreInfoDtlCommandService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sltmPreInfoDtl/v1")
@Tag(name = "결재사전정보상세 Command API", description = "TB_TPS_WK_022")
public class SltmPreInfoDtlCommandController {

    private final SltmPreInfoDtlCommandService commandService;

    @Operation(summary = "결재사전정보상세 생성", description = "결재사전정보상세 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createSltmPreInfoDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody SltmPreInfoDtlCreateRequest createRequest) {
        commandService.createSltmPreInfoDtl(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "결재사전정보상세 수정", description = "결재사전정보상세 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updateSltmPreInfoDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody SltmPreInfoDtlUpdateRequest updateRequest) {
        commandService.updateSltmPreInfoDtl(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "결재사전정보상세 제거", description = "결재사전정보상세 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deleteSltmPreInfoDtl(@RequestBody List<SltmPreInfoDtlSelectRequest> deleteRequests) {
        commandService.deleteSltmPreInfoDtl(deleteRequests);
        return TpsResponse.success(null);
    }
}
