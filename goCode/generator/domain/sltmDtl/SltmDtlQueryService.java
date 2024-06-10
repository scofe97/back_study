package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlSelectRequest;
import org.okestro.tps.api.application.sltmDtl.dto.response.SltmDtlResponse;

import java.util.List;

public interface SltmDtlQueryService {
    List<SltmDtlResponse> selectSltmDtlList();

    SltmDtlResponse selectSltmDtl(SltmDtlSelectRequest selectRequest);
}
