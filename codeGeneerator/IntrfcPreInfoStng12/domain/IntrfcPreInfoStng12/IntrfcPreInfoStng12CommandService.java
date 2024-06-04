package org.okestro.tps.api.;

import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12CreateRequest;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12SelectRequest;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.request.IntrfcPreInfoStng12UpdateRequest;

import java.util.List;

public interface IntrfcPreInfoStng12CommandService {

    void createIntrfcPreInfoStng12(IntrfcPreInfoStng12CreateRequest request, String userId);
    void updateIntrfcPreInfoStng12(IntrfcPreInfoStng12UpdateRequest request, String userId);
    void deleteIntrfcPreInfoStng12(List<IntrfcPreInfoStng12SelectRequest> requests);
}
