package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlCreateRequest;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlSelectRequest;
import org.okestro.tps.api.application.sltmDtl.dto.request.SltmDtlUpdateRequest;
import org.okestro.tps.api.domain.sltmDtl.SltmDtlCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmDtlCommandServiceImpl implements SltmDtlCommandService {

    private final TbTpsWk022CommandService commandService;

    @Override
    @Transactional
    public void createSltmDtl(SltmDtlCreateRequest createRequest, String userId) {
        commandService.createSltmDtl(createRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void updateSltmDtl(SltmDtlUpdateRequest updateRequest, String userId) {
        commandService.updateSltmDtl(updateRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void deleteSltmDtl(List<SltmDtlSelectRequest> deleteRequests) {
        commandService.deleteSltmDtl(deleteRequests.stream()
                .map(SltmDtlSelectRequest::toModel)
                .toList());
    }
}
