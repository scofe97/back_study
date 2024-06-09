package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.response.SltmPreInfoDtlResponse;
import org.okestro.tps.api.domain.sltmPreInfoDtl.SltmPreInfoDtlQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmPreInfoDtlQueryServiceImpl implements SltmPreInfoDtlQueryService {

    private final TbTpsWk022QueryService queryService;

    @Override
    @Transactional(readOnly = true)
    public List<SltmPreInfoDtlResponse> selectSltmPreInfoDtlList() {
        return queryService.selectSltmPreInfoDtlList()
                .stream()
                .map(SltmPreInfoDtlResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SltmPreInfoDtlResponse selectSltmPreInfoDtl(SltmPreInfoDtlSelectRequest selectRequest) {
        return SltmPreInfoDtlResponse
                .from(queryService.selectSltmPreInfoDtl(selectRequest.toModel()));
    }
}
