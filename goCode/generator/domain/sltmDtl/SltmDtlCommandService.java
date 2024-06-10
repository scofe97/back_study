package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlCreateRequest;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlSelectRequest;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlUpdateRequest;

import java.util.List;

public interface SltmDtlCommandService {

    void createSltmDtl(SltmDtlCreateRequest request, String userId);
    void updateSltmDtl(SltmDtlUpdateRequest request, String userId);
    void deleteSltmDtl(List<SltmDtlSelectRequest> requests);
}
