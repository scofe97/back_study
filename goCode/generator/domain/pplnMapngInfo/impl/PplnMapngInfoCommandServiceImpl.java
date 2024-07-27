package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoCreateRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoSelectRequest;
import org.okestro.tps.api.application.pplnMapngInfo.dto.request.PplnMapngInfoUpdateRequest;
import org.okestro.tps.api.domain.pplnMapngInfo.PplnMapngInfoCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsCm052CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PplnMapngInfoCommandServiceImpl implements PplnMapngInfoCommandService {

    private final TbTpsCm052CommandService tbTpsCm052CommandService;

    @Override
    @Transactional
    public void createPplnMapngInfo(PplnMapngInfoCreateRequest createRequest, String userId) {
        tbTpsCm052CommandService.createPplnMapngInfo(createRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void updatePplnMapngInfo(PplnMapngInfoUpdateRequest updateRequest, String userId) {
        tbTpsCm052CommandService.updatePplnMapngInfo(updateRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void deletePplnMapngInfo(List<PplnMapngInfoSelectRequest> deleteRequests) {
        tbTpsCm052CommandService.deletePplnMapngInfo(deleteRequests.stream()
                .map(PplnMapngInfoSelectRequest::toModel)
                .toList());
    }
}
