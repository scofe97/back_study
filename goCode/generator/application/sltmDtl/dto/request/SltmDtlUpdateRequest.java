package org.okestro.tps.api.application.sltmDtl.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

import java.time.LocalDateTime;

public record SltmDtlUpdateRequest(
        @Schema(description = "콤포넌트일련번호")
        Integer compnSn,
        
        @Schema(description = "단계명")
        String stepNm,
        
        @Schema(description = "업무권한사용여부")
        String taskAuthrtUseYn,
        
        @Schema(description = "업무권한코드")
        String taskAuthrtCd,
        
        @Schema(description = "결재자아이디")
        String aprvrId,
        
        @Schema(description = "결재자관계코드")
        String aprvrRelCd,
        
) {
    public TbTpsWk022 toModel(String userId) {
        return TbTpsWk022.builder()
                .compnSn(this.compnSn)
                .stepNm(this.stepNm)
                .taskAuthrtUseYn(this.taskAuthrtUseYn)
                .taskAuthrtCd(this.taskAuthrtCd)
                .aprvrId(this.aprvrId)
                .aprvrRelCd(this.aprvrRelCd)
                .mdfrId(userId)
                .build();
    }
}