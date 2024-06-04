package org.okestro.tps.api.application.compnDtlBsc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.response.CompnDtlBscResponse;
import org.okestro.tps.api.domain.compnDtlBsc.CompnDtlBscQueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/compnDtlBsc/v1")
@Tag(name = "컴포넌트기본 Query API", description = "TB_TPS_WK_020")
public class CompnDtlBscQueryController {
    private final CompnDtlBscQueryService queryService;

    @Operation(summary = "컴포넌트기본 리스트 조회", description = "컴포넌트기본의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectCompnDtlBscList() {
        List<CompnDtlBscResponse> responseList = queryService.selectCompnDtlBscList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "컴포넌트기본 단건 조회", description = "컴포넌트기본의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select/{id}")
    public TpsResponse<?> selectCompnDtlBsc(@PathVariable String id) {
        CompnDtlBscSelectRequest selectRequest = CompnDtlBscSelectRequest.builder()
            .build();
        CompnDtlBscResponse response = queryService.selectCompnDtlBsc(selectRequest);
        return TpsResponse.success(response);
    }
}
