package org.okestro.tps.api..dto.response;

import lombok.Builder;
import org.okestro.tps.api..model.TbTpsWk027;

import java.time.LocalDateTime;

@Builder
public record IntrfcPreInfoStng12Response(
        LocalDateTime regDt,
        String rgtrId,
        LocalDateTime mdfcnDt,
        String mdfrId
) {
    public static IntrfcPreInfoStng12Response from(TbTpsWk027 intrfcPreInfoStng12) {
        return IntrfcPreInfoStng12Response.builder()
                .regDt(intrfcPreInfoStng12.getRegDt())
                .rgtrId(intrfcPreInfoStng12.getRgtrId())
                .mdfcnDt(intrfcPreInfoStng12.getMdfcnDt())
                .mdfrId(intrfcPreInfoStng12.getMdfrId())
                .build();
    }
}
