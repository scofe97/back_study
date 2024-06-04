package org.okestro.tps.api.domain.compnDtlBsc;

import org.okestro.tps.api.application.compnDtlBsc.dto.response.CompnDtlBscResponse;

import java.util.List;

public interface CompnDtlBscQueryService {
    List<CompnDtlBscResponse> selectCompnDtlBscList();

    CompnDtlBscResponse selectCompnDtlBsc(CompnDtlBscSelectRequest selectRequest);
}
