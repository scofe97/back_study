package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlCreateRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlSelectRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlUpdateRequest;

import java.util.List;

public interface SltmPreInfoDtlCommandService {

    void createSltmPreInfoDtl(SltmPreInfoDtlCreateRequest request, String userId);
    void updateSltmPreInfoDtl(SltmPreInfoDtlUpdateRequest request, String userId);
    void deleteSltmPreInfoDtl(List<SltmPreInfoDtlSelectRequest> requests);
}
