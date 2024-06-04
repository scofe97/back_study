package org.okestro.tps.api.application.compnDtlBsc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscCreateRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscSelectRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscUpdateRequest;
import org.okestro.tps.api.domain.compnDtlBsc.CompnDtlBscCommandService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/compnDtlBsc/v1")
@Tag(name = "컴포넌트기본 Command API", description = "TB_TPS_WK_020")
public class CompnDtlBscCommandController {

    private final CompnDtlBscCommandService commandService;

    @Operation(summary = "컴포넌트기본 생성", description = "컴포넌트기본 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createCompnDtlBsc(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody CompnDtlBscCreateRequest createRequest) {
        commandService.createCompnDtlBsc(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "컴포넌트기본 수정", description = "컴포넌트기본 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updateCompnDtlBsc(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody CompnDtlBscUpdateRequest updateRequest) {
        commandService.updateCompnDtlBsc(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "컴포넌트기본 제거", description = "컴포넌트기본 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deleteCompnDtlBsc(@RequestBody List<CompnDtlBscSelectRequest> deleteRequests) {
        commandService.deleteCompnDtlBsc(deleteRequests);
        return TpsResponse.success(null);
    }
}
