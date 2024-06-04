package org.okestro.tps.api.;

import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.response.IntrfcPreInfoStng12Response;

import java.util.List;

public interface IntrfcPreInfoStng12QueryService {
    List<IntrfcPreInfoStng12Response> selectIntrfcPreInfoStng12List();

    IntrfcPreInfoStng12Response selectIntrfcPreInfoStng12();
}
