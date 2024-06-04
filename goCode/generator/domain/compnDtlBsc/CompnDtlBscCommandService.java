package org.okestro.tps.api.domain.compnDtlBsc;

import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscCreateRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscSelectRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscUpdateRequest;

import java.util.List;

public interface CompnDtlBscCommandService {

    void createCompnDtlBsc(CompnDtlBscCreateRequest request, String userId);
    void updateCompnDtlBsc(CompnDtlBscUpdateRequest request, String userId);
    void deleteCompnDtlBsc(List<CompnDtlBscSelectRequest> requests);
}
