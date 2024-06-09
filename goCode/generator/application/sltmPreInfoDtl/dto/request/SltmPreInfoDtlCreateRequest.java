package org.okestro.tps.api.application.sltmPreInfoDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

public record SltmPreInfoDtlCreateRequest(
        @Schema(description = "업무권한사용여부")
        @NotBlank(message = "{field.notBlank}")
        String taskAuthrtUseYn,
        
        @Schema(description = "업무권한코드")
        @NotBlank(message = "{field.notBlank}")
        String taskAuthrtCd,
        
        @Schema(description = "결재자아이디")
        @NotBlank(message = "{field.notBlank}")
        String aprvrId,
        
        @Schema(description = "결재자관계코드")
        @NotBlank(message = "{field.notBlank}")
        String aprvrRelCd,
        
        @Schema(description = "등록일시")
        @NotNull(message = "{field.notNull}")
        LocalDateTime regDt,
        
        @Schema(description = "등록자아이디")
        @NotBlank(message = "{field.notBlank}")
        String rgtrId,
        
        @Schema(description = "수정일시")
        @NotNull(message = "{field.notNull}")
        LocalDateTime mdfcnDt,
        
        @Schema(description = "수정자아이디")
        @NotBlank(message = "{field.notBlank}")
        String mdfrId
        
) {
    public TbTpsWk022 toModel(String userId) {
        return TbTpsWk022.builder()
                .taskAuthrtUseYn(this.taskAuthrtUseYn)
                .taskAuthrtCd(this.taskAuthrtCd)
                .aprvrId(this.aprvrId)
                .aprvrRelCd(this.aprvrRelCd)
                .regDt(this.regDt)
                .rgtrId(this.rgtrId)
                .mdfcnDt(this.mdfcnDt)
                .mdfrId(this.mdfrId)
                .build();
    }
}
