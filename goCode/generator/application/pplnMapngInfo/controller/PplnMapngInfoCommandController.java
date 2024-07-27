package org.okestro.tps.api.application.pplnMapngInfo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoCreateRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoUpdateRequest;
import org.okestro.tps.api.domain.pplnMapngInfo.PplnMapngInfoCommandService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pplnMapngInfo/v1")
@Tag(name = "파이프라인매핑정보 Command API", description = "TB_TPS_CM_052")
public class PplnMapngInfoCommandController {

    private final PplnMapngInfoCommandService pplnMapngInfoCommandService;

    @Operation(summary = "파이프라인매핑정보 생성", description = "파이프라인매핑정보 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createPplnMapngInfo(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody PplnMapngInfoCreateRequest createRequest) {
        commandService.createPplnMapngInfo(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "파이프라인매핑정보 수정", description = "파이프라인매핑정보 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updatePplnMapngInfo(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody PplnMapngInfoUpdateRequest updateRequest) {
        commandService.updatePplnMapngInfo(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "파이프라인매핑정보 제거", description = "파이프라인매핑정보 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deletePplnMapngInfo(@RequestBody List<PplnMapngInfoSelectRequest> deleteRequests) {
        commandService.deletePplnMapngInfo(deleteRequests);
        return TpsResponse.success(null);
    }
}
