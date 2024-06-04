package org.okestro.tps.api.application.compnDtlBsc.dto.response;

import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

import java.time.LocalDateTime;

@Builder
public record CompnDtlBscResponse(
        LocalDateTime regDt,
        String rgtrId,
        LocalDateTime mdfcnDt,
        String mdfrId
) {
    public static CompnDtlBscResponse from(TbTpsWk020 compnDtlBsc) {
        return CompnDtlBscResponse.builder()
                .regDt(compnDtlBsc.getRegDt())
                .rgtrId(compnDtlBsc.getRgtrId())
                .mdfcnDt(compnDtlBsc.getMdfcnDt())
                .mdfrId(compnDtlBsc.getMdfrId())
                .build();
    }
}
