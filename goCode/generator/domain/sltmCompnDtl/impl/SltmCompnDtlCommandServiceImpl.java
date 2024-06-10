package org.okestro.tps.api.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlCreateRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlSelectRequest;
import org.okestro.tps.api.application.sltmCompnDtl.dto.request.SltmCompnDtlUpdateRequest;
import org.okestro.tps.api.domain.sltmCompnDtl.SltmCompnDtlCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk022CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SltmCompnDtlCommandServiceImpl implements SltmCompnDtlCommandService {

    private final TbTpsWk022CommandService commandService;

    @Override
    @Transactional
    public void createSltmCompnDtl(SltmCompnDtlCreateRequest createRequest, String userId) {
        commandService.createSltmCompnDtl(createRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void updateSltmCompnDtl(SltmCompnDtlUpdateRequest updateRequest, String userId) {
        commandService.updateSltmCompnDtl(updateRequest.toModel(userId));
    }

    @Override
    @Transactional
    public void deleteSltmCompnDtl(List<SltmCompnDtlSelectRequest> deleteRequests) {
        commandService.deleteSltmCompnDtl(deleteRequests.stream()
                .map(SltmCompnDtlSelectRequest::toModel)
                .toList());
    }
}
