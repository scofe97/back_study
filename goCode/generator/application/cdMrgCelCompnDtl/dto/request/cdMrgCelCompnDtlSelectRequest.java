package org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;

@Builder
public record cdMrgCelCompnDtlSelectRequest(
        @Schema(description = "콤포넌트코드")
        @NotBlank(message = "{field.notBlank}")
        String compnCd,
        
        @Schema(description = "콤포넌트버전")
        @NotBlank(message = "{field.notBlank}")
        Integer compnVsrn
        
) {
    public static cdMrgCelCompnDtlSelectRequest from(
        String compnCd,
        Integer compnVsrn
    ) {
        return cdMrgCelCompnDtlSelectRequest.builder()
                .compnCd(compnCd)
                .compnVsrn(compnVsrn)
                .build();
    }

    public TbTpsWk02c toModel() {
        return TbTpsWk02c.builder()
                .compnCd(this.compnCd)
                .compnVsrn(this.compnVsrn)
                .build();
    }
}
