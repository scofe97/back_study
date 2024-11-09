package org.okestro.tps.api;

import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlCreateRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlUpdateRequest;

import java.util.List;

public interface cdMrgCelCompnDtlCommandService {

    void createcdMrgCelCompnDtl(cdMrgCelCompnDtlCreateRequest request, String userId);
    void updatecdMrgCelCompnDtl(cdMrgCelCompnDtlUpdateRequest request, String userId);
    void deletecdMrgCelCompnDtl(List<cdMrgCelCompnDtlSelectRequest> requests);
}
