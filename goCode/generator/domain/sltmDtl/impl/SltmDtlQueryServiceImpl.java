package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlSelectRequest;
import org.okestro.tps.api.application.sltmDtl.dto.response.SltmDtlResponse;
import org.okestro.tps.api.domain.sltmDtl.SltmDtlQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmDtlQueryServiceImpl implements SltmDtlQueryService {

    private final TbTpsWk022QueryService queryService;

    @Override
    @Transactional(readOnly = true)
    public List<SltmDtlResponse> selectSltmDtlList() {
        return queryService.selectSltmDtlList()
                .stream()
                .map(SltmDtlResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SltmDtlResponse selectSltmDtl(SltmDtlSelectRequest selectRequest) {
        return SltmDtlResponse
                .from(queryService.selectSltmDtl(selectRequest.toModel()));
    }
}
