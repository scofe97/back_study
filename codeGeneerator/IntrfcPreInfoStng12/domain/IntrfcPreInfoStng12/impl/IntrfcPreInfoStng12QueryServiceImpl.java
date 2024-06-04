package org.okestro.tps.api..impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.okestro.tps.api.application.IntrfcPreInfoStng12.dto.response.IntrfcPreInfoStng12Response;
import org.okestro.tps.api.domain.IntrfcPreInfoStng12.IntrfcPreInfoStng12QueryService;
import org.okestro.tps.api.infrastructure.persistence.dao.TbTpsWk027QueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IntrfcPreInfoStng12QueryServiceImpl implements IntrfcPreInfoStng12QueryService {

    private final TbTpsWk027QueryService queryService;

    @Override
    public List<IntrfcPreInfoStng12Response> selectIntrfcPreInfoStng12List() {
        return queryService.selectIntrfcPreInfoStng12List()
                .stream()
                .map(IntrfcPreInfoStng12Response::from)
                .toList();
    }

    @Override
    public IntrfcPreInfoStng12Response selectIntrfcPreInfoStng12() {
        return IntrfcPreInfoStng12Response
                .from(queryService.selectIntrfcPreInfoStng12());
    }
}
