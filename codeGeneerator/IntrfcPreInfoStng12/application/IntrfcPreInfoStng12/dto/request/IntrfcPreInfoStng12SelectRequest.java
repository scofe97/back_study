package org.okestro.tps.api..dto.request;

import lombok.Builder;
import org.okestro.tps.api..model.TbTpsWk027;

@Builder
public record IntrfcPreInfoStng12SelectRequest(
) {
    public TbTpsWk027 toModel() {
        return TbTpsWk027.builder()
                .build();
    }
}
