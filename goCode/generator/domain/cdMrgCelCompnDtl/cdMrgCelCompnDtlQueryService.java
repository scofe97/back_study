package org.okestro.tps.api;

import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.response.cdMrgCelCompnDtlResponse;

import java.util.List;

public interface cdMrgCelCompnDtlQueryService {
    List<cdMrgCelCompnDtlResponse> selectcdMrgCelCompnDtlList();

    cdMrgCelCompnDtlResponse selectcdMrgCelCompnDtl(cdMrgCelCompnDtlSelectRequest selectRequest);
}
