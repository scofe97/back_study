package org.okestro.tps.api..controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api..dto.request.IntrfcPreInfoStng12CreateRequest;
import org.okestro.tps.api..dto.request.IntrfcPreInfoStng12SelectRequest;
import org.okestro.tps.api..dto.request.IntrfcPreInfoStng12UpdateRequest;
import org.okestro.tps.api.domain.IntrfcPreInfoStng12.IntrfcPreInfoStng12CommandService;
import org.okestro.tps.common_lib.message.TpsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/intrfcPreInfoStng12/v1")
@Tag(name = "인터페이스사전정보 Command API", description = "TB_TPS_WK_027")
public class IntrfcPreInfoStng12CommandController {

    private final IntrfcPreInfoStng12CommandService commandService;

    @Operation(summary = "인터페이스사전정보 생성", description = "인터페이스사전정보 생성을 위한 API 입니다.")
    @PostMapping("/create")
    public TpsResponse<?> createIntrfcPreInfoStng12(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody IntrfcPreInfoStng12CreateRequest createRequest) {
        commandService.createIntrfcPreInfoStng12(createRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "인터페이스사전정보 수정", description = "인터페이스사전정보 수정을 위한 API 입니다.")
    @PostMapping("/update")
    public TpsResponse<?> updateIntrfcPreInfoStng12(@RequestHeader("userId") String userId,
                                                  @Valid @RequestBody IntrfcPreInfoStng12UpdateRequest updateRequest) {
        commandService.updateIntrfcPreInfoStng12(updateRequest, userId);
        return TpsResponse.success(null);
    }

    @Operation(summary = "인터페이스사전정보 제거", description = "인터페이스사전정보 삭제를 위한 API 입니다.")
    @PostMapping("/delete")
    public TpsResponse<?> deleteIntrfcPreInfoStng12(@RequestBody List<IntrfcPreInfoStng12SelectRequest> deleteRequests) {
        commandService.deleteIntrfcPreInfoStng12(deleteRequests);
        return TpsResponse.success(null);
    }
}
