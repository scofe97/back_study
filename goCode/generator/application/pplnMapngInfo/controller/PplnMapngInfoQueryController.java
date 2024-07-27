package org.okestro.tps.api.application.pplnMapngInfo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.response.PplnMapngInfoResponse;
import org.okestro.tps.api.domain.pplnMapngInfo.PplnMapngInfoQueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pplnMapngInfo/v1")
@Tag(name = "파이프라인매핑정보 Query API", description = "TB_TPS_CM_052")
public class PplnMapngInfoQueryController {
    private final PplnMapngInfoQueryService pplnMapngInfoQueryService;

    @Operation(summary = "파이프라인매핑정보 리스트 조회", description = "파이프라인매핑정보의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectPplnMapngInfoList() {
        List<PplnMapngInfoResponse> responseList = queryService.selectPplnMapngInfoList();
        return TpsResponse.success(responseList);
    }


    @Operation(summary = "파이프라인매핑정보 단건 조회", description = "파이프라인매핑정보의 특정 데이터를 가져오는 API입니다.")
    @GetMapping("/select/{wrkflwExcnNo}/{wrkflwInptNo}")
    public TpsResponse<?> selectPplnMapngInfo(
            @PathVariable("wrkflwExcnNo") String wrkflwExcnNo,
            @PathVariable("wrkflwInptNo") Integer wrkflwInptNo
    ) {
        PplnMapngInfoSelectRequest selectRequest = PplnMapngInfoSelectRequest.builder()
                                                            .wrkflwExcnNo(wrkflwExcnNo)
                                                            .wrkflwInptNo(wrkflwInptNo)
                                                            .build();
        PplnMapngInfoResponse response = queryService.selectPplnMapngInfo(selectRequest);
        return TpsResponse.success(response);
    }
}
