package org.okestro.tps.api.infrastructure.persistence.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk020QueryMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Service
@RequiredArgsConstructor
public class TbTpsWk020QueryService {

    private final TbTpsWk020QueryMapper queryMapper;

    public List<TbTpsWk020> selectCompnDtlBscList() {
        return queryMapper.selectCompnDtlBscList();
    }

    public TbTpsWk020 selectCompnDtlBsc(TbTpsWk020 selectModel) {
        return queryMapper.selectCompnDtlBsc();
    }
}
