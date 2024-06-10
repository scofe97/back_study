package org.okestro.tps.api.application.sltmCompnDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Builder
public record SltmCompnDtlSelectRequest(
        @Schema(description = "콤포넌트일련번호")
        @NotBlank(message = "{field.notBlank}")
        Integer compnSn
        
) {
    public static SltmCompnDtlSelectRequest from(
        Integer compnSn
    ) {
        return SltmCompnDtlSelectRequest.builder()
                .compnSn(compnSn)
                .build();
    }

    public TbTpsWk022 toModel() {
        return TbTpsWk022.builder()
                .compnSn(this.compnSn)
                .build();
    }
}
