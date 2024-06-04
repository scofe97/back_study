package org.okestro.tps.api..controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api..dto.response.IntrfcPreInfoStng12Response;
import org.okestro.tps.api.domain.IntrfcPreInfoStng12.IntrfcPreInfoStng12QueryService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/intrfcPreInfoStng12/v1")
@Tag(name = "인터페이스사전정보 Query API", description = "TB_TPS_WK_027")
public class IntrfcPreInfoStng12QueryController {
    private final IntrfcPreInfoStng12QueryService queryService;

    @Operation(summary = "인터페이스사전정보 리스트 조회", description = "인터페이스사전정보의 전체 데이터를 가져오는 API입니다.")
    @GetMapping("/select")
    public TpsResponse<?> selectIntrfcPreInfoStng12List() {
        List<IntrfcPreInfoStng12Response> responseList = queryService.selectIntrfcPreInfoStng12List();
        return TpsResponse.success(responseList);
    }
}
