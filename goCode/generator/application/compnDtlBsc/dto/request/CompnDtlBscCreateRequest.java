package org.okestro.tps.api.application.compnDtlBsc.dto.request;

import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Builder
public record CompnDtlBscCreateRequest(
) {
    public TbTpsWk020 toModel(String userId) {
        return TbTpsWk020.builder()
                .rgtrId(userId)
                .mdfrId(userId)
                .build();
    }
}
