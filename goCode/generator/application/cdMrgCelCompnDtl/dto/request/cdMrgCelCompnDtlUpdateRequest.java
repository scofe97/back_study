package org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;

import java.time.LocalDateTime;

public record cdMrgCelCompnDtlUpdateRequest(
        @Schema(description = "콤포넌트코드")
        String compnCd,
        
        @Schema(description = "콤포넌트버전")
        Integer compnVsrn,
        
        @Schema(description = "병합대상브랜치코드")
        String mergeTrgtBrnchCd,
        
        @Schema(description = "업무권한사용여부")
        String taskAuthrtUseYn,
        
        @Schema(description = "업무권한코드")
        String taskAuthrtCd,
        
        @Schema(description = "처리자아이디")
        String prcrId,
        
) {
    public TbTpsWk02c toModel(String userId) {
        return TbTpsWk02c.builder()
                .compnCd(this.compnCd)
                .compnVsrn(this.compnVsrn)
                .mergeTrgtBrnchCd(this.mergeTrgtBrnchCd)
                .taskAuthrtUseYn(this.taskAuthrtUseYn)
                .taskAuthrtCd(this.taskAuthrtCd)
                .prcrId(this.prcrId)
                .build();
    }
}