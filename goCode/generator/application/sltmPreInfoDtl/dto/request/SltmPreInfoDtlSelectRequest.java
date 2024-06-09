package org.okestro.tps.api.application.sltmPreInfoDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Builder
public record SltmPreInfoDtlSelectRequest(
        @Schema(description = "콤포넌트일련번호")
        @NotBlank(message = "{field.notBlank}")
        Integer compnSn,
        
        @Schema(description = "단계명")
        @NotBlank(message = "{field.notBlank}")
        String stepNm
        
) {
    public static SltmPreInfoDtlSelectRequest from(
        Integer compnSn,
        String stepNm
    ) {
        return SltmPreInfoDtlSelectRequest.builder()
                .compnSn(compnSn)
                .stepNm(stepNm)
                .build();
    }

    public TbTpsWk022 toModel() {
        return TbTpsWk022.builder()
                .compnSn(this.compnSn)
                .stepNm(this.stepNm)
                .build();
    }
}
