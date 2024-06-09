package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlCreateRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlSelectRequest;
import org.okestro.tps.api.application.sltmPreInfoDtl.dto.request.SltmPreInfoDtlUpdateRequest;
import org.okestro.tps.api.domain.sltmPreInfoDtl.SltmPreInfoDtlCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmPreInfoDtlCommandServiceImpl implements SltmPreInfoDtlCommandService {

    private final TbTpsWk022CommandService commandService;

    @Override
    @Transactional
    public void createSltmPreInfoDtl(SltmPreInfoDtlCreateRequest createRequest, String userId) {
        commandService.createSltmPreInfoDtl(createRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void updateSltmPreInfoDtl(SltmPreInfoDtlUpdateRequest updateRequest, String userId) {
        commandService.updateSltmPreInfoDtl(updateRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void deleteSltmPreInfoDtl(List<SltmPreInfoDtlSelectRequest> deleteRequests) {
        commandService.deleteSltmPreInfoDtl(deleteRequests.stream()
                .map(SltmPreInfoDtlSelectRequest::toModel)
                .toList());
    }
}
