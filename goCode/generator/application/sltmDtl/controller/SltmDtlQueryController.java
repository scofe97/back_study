package org.okestro.tps.api.application.sltmDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlSelectRequest;
import org.okestro.tps.api.application.sltmDtl.dto.response.SltmDtlResponse;
import org.okestro.tps.api.domain.sltmDtl.SltmDtlQueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sltmDtl/v1")
@Tag(name = "결재사전정보상세 Query API", description = "TB_TPS_WK_022")
public class SltmDtlQueryController {
    private final SltmDtlQueryService queryService;

    @Operation(summary = "결재사전정보상세 리스트 조회", description = "결재사전정보상세의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectSltmDtlList() {
        List<SltmDtlResponse> responseList = queryService.selectSltmDtlList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "결재사전정보상세 단건 조회", description = "결재사전정보상세의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select//{compnSn}")
    public TpsResponse<?> selectSltmDtl(
            @PathVariable("compnSn") Integer compnSn
    ) {
        SltmDtlSelectRequest selectRequest = SltmDtlSelectRequest.builder()
                                                            .compnSn(compnSn)
                                                            .build();
        SltmDtlResponse response = queryService.selectSltmDtl(selectRequest);
        return TpsResponse.success(response);
    }
}
