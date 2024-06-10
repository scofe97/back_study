package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.response.SltmCompnDtlResponse;

import java.util.List;

public interface SltmCompnDtlQueryService {
    List<SltmCompnDtlResponse> selectSltmCompnDtlList();

    SltmCompnDtlResponse selectSltmCompnDtl(SltmCompnDtlSelectRequest selectRequest);
}
