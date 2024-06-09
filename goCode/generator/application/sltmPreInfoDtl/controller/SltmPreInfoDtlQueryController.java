package org.okestro.tps.api.application.sltmPreInfoDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlSelectRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.response.SltmPreInfoDtlResponse;
import org.okestro.tps.api.domain.sltmPreInfoDtl.SltmPreInfoDtlQueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sltmPreInfoDtl/v1")
@Tag(name = "결재사전정보상세 Query API", description = "TB_TPS_WK_022")
public class SltmPreInfoDtlQueryController {
    private final SltmPreInfoDtlQueryService queryService;

    @Operation(summary = "결재사전정보상세 리스트 조회", description = "결재사전정보상세의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectSltmPreInfoDtlList() {
        List<SltmPreInfoDtlResponse> responseList = queryService.selectSltmPreInfoDtlList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "결재사전정보상세 단건 조회", description = "결재사전정보상세의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select//{compnSn}")
    public TpsResponse<?> selectSltmPreInfoDtl(@PathVariable("compnSn") Integer compnSn
    ) {
        SltmPreInfoDtlSelectRequest selectRequest = SltmPreInfoDtlSelectRequest.builder().compnSn(compnSn)
            .build();
        SltmPreInfoDtlResponse response = queryService.selectSltmPreInfoDtl(selectRequest);
        return TpsResponse.success(response);
    }
}
