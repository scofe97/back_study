package org.okestro.tps.api;

import org.okestro.tps.api.application.sltmPreInfoDtl.dto.response.SltmPreInfoDtlResponse;

import java.util.List;

public interface SltmPreInfoDtlQueryService {
    List<SltmPreInfoDtlResponse> selectSltmPreInfoDtlList();

    SltmPreInfoDtlResponse selectSltmPreInfoDtl(SltmPreInfoDtlSelectRequest selectRequest);
}
