package org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;

import java.time.LocalDateTime;

@Builder
public record cdMrgCelCompnDtlResponse(
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
    
        @Schema(description = "등록일시")
        LocalDateTime regDt,
    
        @Schema(description = "등록자아이디")
        String rgtrId
    
) {
    public static cdMrgCelCompnDtlResponse from(TbTpsWk02c tbTpsWk02c) {
        return cdMrgCelCompnDtlResponse.builder()
            .compnCd(tbTpsWk02c.getCompnCd())
            .compnVsrn(tbTpsWk02c.getCompnVsrn())
            .mergeTrgtBrnchCd(tbTpsWk02c.getMergeTrgtBrnchCd())
            .taskAuthrtUseYn(tbTpsWk02c.getTaskAuthrtUseYn())
            .taskAuthrtCd(tbTpsWk02c.getTaskAuthrtCd())
            .prcrId(tbTpsWk02c.getPrcrId())
            .regDt(tbTpsWk02c.getRegDt())
            .rgtrId(tbTpsWk02c.getRgtrId())
            .build();
    }
}