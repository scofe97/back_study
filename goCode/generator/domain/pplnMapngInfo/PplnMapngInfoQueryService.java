package org.okestro.tps.api;

import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.response.PplnMapngInfoResponse;

import java.util.List;

public interface PplnMapngInfoQueryService {
    List<PplnMapngInfoResponse> selectPplnMapngInfoList();

    PplnMapngInfoResponse selectPplnMapngInfo(PplnMapngInfoSelectRequest selectRequest);
}
