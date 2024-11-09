package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlCreateRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlSelectRequest;
import org.okestro.tps.api.application.cdMrgCelCompnDtl.dto.request.cdMrgCelCompnDtlUpdateRequest;
import org.okestro.tps.api.domain.cdMrgCelCompnDtl.cdMrgCelCompnDtlCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk02cCommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class cdMrgCelCompnDtlCommandServiceImpl implements cdMrgCelCompnDtlCommandService {

    private final TbTpsWk02cCommandService tbTpsWk02cCommandService;

    @Override
    @Transactional
    public void createcdMrgCelCompnDtl(cdMrgCelCompnDtlCreateRequest createRequest, String userId) {
        tbTpsWk02cCommandService.createcdMrgCelCompnDtl(createRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void updatecdMrgCelCompnDtl(cdMrgCelCompnDtlUpdateRequest updateRequest, String userId) {
        tbTpsWk02cCommandService.updatecdMrgCelCompnDtl(updateRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void deletecdMrgCelCompnDtl(List<cdMrgCelCompnDtlSelectRequest> deleteRequests) {
        tbTpsWk02cCommandService.deletecdMrgCelCompnDtl(deleteRequests.stream()
                .map(cdMrgCelCompnDtlSelectRequest::toModel)
                .toList());
    }
}
