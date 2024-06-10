package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlCreateRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlUpdateRequest;

import java.util.List;

public interface SltmCompnDtlCommandService {

    void createSltmCompnDtl(SltmCompnDtlCreateRequest request, String userId);
    void updateSltmCompnDtl(SltmCompnDtlUpdateRequest request, String userId);
    void deleteSltmCompnDtl(List<SltmCompnDtlSelectRequest> requests);
}
