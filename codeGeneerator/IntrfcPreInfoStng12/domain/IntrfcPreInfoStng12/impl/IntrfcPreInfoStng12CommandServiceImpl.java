package org.okestro.tps.api..impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12CreateRequest;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12SelectRequest;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12UpdateRequest;
import org.okestro.tps.api.domain.IntrfcPreInfoStng12.IntrfcPreInfoStng12CommandService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk027CommandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IntrfcPreInfoStng12CommandServiceImpl implements IntrfcPreInfoStng12CommandService {
    private final TbTpsWk027CommandService commandService;

    public void createIntrfcPreInfoStng12(IntrfcPreInfoStng12CreateRequest createRequest, String userId) {
        commandService.createIntrfcPreInfoStng12(createRequest.toModel(userId));
    }

    public void updateIntrfcPreInfoStng12(IntrfcPreInfoStng12UpdateRequest updateRequest, String userId) {
        commandService.updateIntrfcPreInfoStng12(updateRequest.toModel(userId));
    }

    public void deleteIntrfcPreInfoStng12(List<IntrfcPreInfoStng12SelectRequest> deleteRequests) {
        commandService.deleteIntrfcPreInfoStng12(deleteRequests.stream()
                .map(IntrfcPreInfoStng12SelectRequest::toModel)
                .toList());
    }
}
