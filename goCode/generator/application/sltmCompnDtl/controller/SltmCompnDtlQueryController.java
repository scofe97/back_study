package org.okestro.tps.api.application.sltmCompnDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.response.SltmCompnDtlResponse;
import org.okestro.tps.api.domain.sltmCompnDtl.SltmCompnDtlQueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sltmCompnDtl/v1")
@Tag(name = "결재사전정보상세 Query API", description = "TB_TPS_WK_022")
public class SltmCompnDtlQueryController {
    private final SltmCompnDtlQueryService queryService;

    @Operation(summary = "결재사전정보상세 리스트 조회", description = "결재사전정보상세의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectSltmCompnDtlList() {
        List<SltmCompnDtlResponse> responseList = queryService.selectSltmCompnDtlList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "결재사전정보상세 단건 조회", description = "결재사전정보상세의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select/{compnSn}")
    public TpsResponse<?> selectSltmCompnDtl(
            @PathVariable("compnSn") Integer compnSn
    ) {
        SltmCompnDtlSelectRequest selectRequest = SltmCompnDtlSelectRequest.builder()
                                                            .compnSn(compnSn)
                                                            .build();
        SltmCompnDtlResponse response = queryService.selectSltmCompnDtl(selectRequest);
        return TpsResponse.success(response);
    }
}
