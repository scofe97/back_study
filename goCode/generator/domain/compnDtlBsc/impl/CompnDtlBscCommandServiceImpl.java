package org.okestro.tps.api.domain.compnDtlBsc.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscCreateRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscSelectRequest;
import org.okestro.tps.api.application.compnDtlBsc.dto.request.CompnDtlBscUpdateRequest;
import org.okestro.tps.api.domain.compnDtlBsc.CompnDtlBscCommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk020CommandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompnDtlBscCommandServiceImpl implements CompnDtlBscCommandService {
    private final TbTpsWk020CommandService commandService;

    public void createCompnDtlBsc(CompnDtlBscCreateRequest createRequest, String userId) {
        commandService.createCompnDtlBsc(createRequest.toModel(userId));
    }

    public void updateCompnDtlBsc(CompnDtlBscUpdateRequest updateRequest, String userId) {
        commandService.updateCompnDtlBsc(updateRequest.toModel(userId));
    }

    public void deleteCompnDtlBsc(List<CompnDtlBscSelectRequest> deleteRequests) {
        commandService.deleteCompnDtlBsc(deleteRequests.stream()
                .map(CompnDtlBscSelectRequest::toModel)
                .toList());
    }
}
