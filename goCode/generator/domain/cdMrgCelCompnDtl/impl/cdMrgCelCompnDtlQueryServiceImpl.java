package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.response.cdMrgCelCompnDtlResponse;
import org.okestro.tps.api.domain.cdMrgCelCompnDtl.cdMrgCelCompnDtlQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk02cQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class cdMrgCelCompnDtlQueryServiceImpl implements cdMrgCelCompnDtlQueryService {

    private final TbTpsWk02cQueryService tbTpsWk02cQueryService;

    @Override
    @Transactional(readOnly = true)
    public List<cdMrgCelCompnDtlResponse> selectcdMrgCelCompnDtlList() {
        return tbTpsWk02cQueryService.selectcdMrgCelCompnDtlList()
                .stream()
                .map(cdMrgCelCompnDtlResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public cdMrgCelCompnDtlResponse selectcdMrgCelCompnDtl(cdMrgCelCompnDtlSelectRequest selectRequest) {
        return cdMrgCelCompnDtlResponse
                .from(tbTpsWk02cQueryService.selectcdMrgCelCompnDtl(selectRequest.toModel()));
    }
}
