package org.okestro.tps.api;

import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoCreateRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoUpdateRequest;

import java.util.List;

public interface PplnMapngInfoCommandService {

    void createPplnMapngInfo(PplnMapngInfoCreateRequest request, String userId);
    void updatePplnMapngInfo(PplnMapngInfoUpdateRequest request, String userId);
    void deletePplnMapngInfo(List<PplnMapngInfoSelectRequest> requests);
}
