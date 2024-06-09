package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk022QueryMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Service
@RequiredArgsConstructor
public class TbTpsWk022QueryService {

    private final TbTpsWk022QueryMapper queryMapper;

    public List<TbTpsWk022> selectSltmPreInfoDtlList() {
        return queryMapper.selectSltmPreInfoDtlList();
    }

    public TbTpsWk022 selectSltmPreInfoDtl(TbTpsWk022 selectModel) {
        return queryMapper.selectSltmPreInfoDtl(selectModel);
    }
}
