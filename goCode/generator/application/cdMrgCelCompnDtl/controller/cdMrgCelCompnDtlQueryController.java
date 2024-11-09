package org.okestro.tps.api.application.cdMrgCelCompnDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.response.cdMrgCelCompnDtlResponse;
import org.okestro.tps.api.domain.cdMrgCelCompnDtl.cdMrgCelCompnDtlQueryService;
import org.okestro.tps.core.dto.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cdMrgCelCompnDtl/v1")
@Tag(name = "코드병합취소콤포넌트상세 Query API", description = "TB_TPS_WK_02C")
public class cdMrgCelCompnDtlQueryController {
    private final cdMrgCelCompnDtlQueryService cdMrgCelCompnDtlQueryService;

    @Operation(summary = "코드병합취소콤포넌트상세 리스트 조회", description = "코드병합취소콤포넌트상세의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectcdMrgCelCompnDtlList() {
        List<cdMrgCelCompnDtlResponse> responseList = cdMrgCelCompnDtlQueryService.selectcdMrgCelCompnDtlList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "코드병합취소콤포넌트상세 단건 조회", description = "코드병합취소콤포넌트상세의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select/{compnCd}/{compnVsrn}")
    public TpsResponse<?> selectcdMrgCelCompnDtl(
            @PathVariable("compnCd") String compnCd,
            @PathVariable("compnVsrn") Integer compnVsrn
    ) {
        cdMrgCelCompnDtlSelectRequest selectRequest = cdMrgCelCompnDtlSelectRequest.builder()
                                                            .compnCd(compnCd)
                                                            .compnVsrn(compnVsrn)
                                                            .build();
        cdMrgCelCompnDtlResponse response = cdMrgCelCompnDtlQueryService.selectcdMrgCelCompnDtl(selectRequest);
        return TpsResponse.success(response);
    }
}
