package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.response.PplnMapngInfoResponse;
import org.okestro.tps.api.domain.pplnMapngInfo.PplnMapngInfoQueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsCm052QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PplnMapngInfoQueryServiceImpl implements PplnMapngInfoQueryService {

    private final TbTpsCm052QueryService tbTpsCm052QueryService;

    @Override
    @Transactional(readOnly = true)
    public List<PplnMapngInfoResponse> selectPplnMapngInfoList() {
        return tbTpsCm052QueryService.selectPplnMapngInfoList()
                .stream()
                .map(PplnMapngInfoResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PplnMapngInfoResponse selectPplnMapngInfo(PplnMapngInfoSelectRequest selectRequest) {
        return PplnMapngInfoResponse
                .from(tbTpsCm052QueryService.selectPplnMapngInfo(selectRequest.toModel()));
    }
}
