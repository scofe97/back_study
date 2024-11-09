package org.okestro.tps.api.application.cdMrgCelCompnDtl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlCreateRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlUpdateRequest;
import org.okestro.tps.api.domain.cdMrgCelCompnDtl.cdMrgCelCompnDtlCommandService;
import org.okestro.tps.core.dto.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cdMrgCelCompnDtl/v1")
@Tag(name = "코드병합취소콤포넌트상세 Command API", description = "TB_TPS_WK_02C")
public class cdMrgCelCompnDtlCommandController {

    private final cdMrgCelCompnDtlCommandService cdMrgCelCompnDtlCommandService;

    @Operation(summary = "코드병합취소콤포넌트상세 생성", description = "코드병합취소콤포넌트상세 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createcdMrgCelCompnDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody cdMrgCelCompnDtlCreateRequest createRequest) {
        cdMrgCelCompnDtlCommandService.createcdMrgCelCompnDtl(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "코드병합취소콤포넌트상세 수정", description = "코드병합취소콤포넌트상세 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updatecdMrgCelCompnDtl(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody cdMrgCelCompnDtlUpdateRequest updateRequest) {
        cdMrgCelCompnDtlCommandService.updatecdMrgCelCompnDtl(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "코드병합취소콤포넌트상세 제거", description = "코드병합취소콤포넌트상세 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deletecdMrgCelCompnDtl(@RequestBody List<cdMrgCelCompnDtlSelectRequest> deleteRequests) {
        cdMrgCelCompnDtlCommandService.deletecdMrgCelCompnDtl(deleteRequests);
        return TpsResponse.success(null);
    }
}
