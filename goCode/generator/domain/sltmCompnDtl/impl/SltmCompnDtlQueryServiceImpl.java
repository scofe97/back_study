package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.response.SltmCompnDtlResponse;
import org.okestro.tps.api.domain.sltmCompnDtl.SltmCompnDtlQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmCompnDtlQueryServiceImpl implements SltmCompnDtlQueryService {

    private final TbTpsWk022QueryService queryService;

    @Override
    @Transactional(readOnly = true)
    public List<SltmCompnDtlResponse> selectSltmCompnDtlList() {
        return queryService.selectSltmCompnDtlList()
                .stream()
                .map(SltmCompnDtlResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SltmCompnDtlResponse selectSltmCompnDtl(SltmCompnDtlSelectRequest selectRequest) {
        return SltmCompnDtlResponse
                .from(queryService.selectSltmCompnDtl(selectRequest.toModel()));
    }
}
