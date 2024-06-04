package org.okestro.tps.api.domain.compnDtlBsc.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.compnDtlBsc.dto.response.CompnDtlBscResponse;
import org.okestro.tps.api.domain.compnDtlBsc.CompnDtlBscQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk020QueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompnDtlBscQueryServiceImpl implements CompnDtlBscQueryService {

    private final TbTpsWk020QueryService queryService;

    @Override
    public List<CompnDtlBscResponse> selectCompnDtlBscList() {
        return queryService.selectCompnDtlBscList()
                .stream()
                .map(CompnDtlBscResponse::from)
                .toList();
    }

    @Override
    public CompnDtlBscResponse selectCompnDtlBsc(CompnDtlBscSelectRequest selectRequest) {
        return CompnDtlBscResponse
                .from(queryService.selectCompnDtlBsc(selectRequest.toModel()));
    }
}
