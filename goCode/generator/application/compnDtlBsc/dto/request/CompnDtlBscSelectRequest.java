package org.okestro.tps.api.application.compnDtlBsc.dto.request;

import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Builder
public record CompnDtlBscSelectRequest(
) {
    public TbTpsWk020 toModel() {
        return TbTpsWk020.builder()
                .build();
    }
}
