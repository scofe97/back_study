package org.okestro.tps.api..dto.request;

import lombok.Builder;
import org.okestro.tps.api..model.TbTpsWk027;

@Builder
public record IntrfcPreInfoStng12CreateRequest(
) {
    public TbTpsWk027 toModel(String userId) {
        return TbTpsWk027.builder()
                .rgtrId(userId)
                .mdfrId(userId)
                .build();
    }
}
