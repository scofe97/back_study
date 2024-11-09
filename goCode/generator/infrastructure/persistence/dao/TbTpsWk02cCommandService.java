package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk02cCommandMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TbTpsWk02cCommandService {

    private final TbTpsWk02cCommandMapper tbTpsWk02cCommandMapper;

    @Transactional
    public void createcdMrgCelCompnDtl(TbTpsWk02c createModel) {
        tbTpsWk02cCommandMapper.createcdMrgCelCompnDtl(createModel);
    }

    @Transactional
    public void updatecdMrgCelCompnDtl(TbTpsWk02c updateModel) {
        tbTpsWk02cCommandMapper.updatecdMrgCelCompnDtl(updateModel);
    }

    @Transactional
    public void deletecdMrgCelCompnDtl(List<TbTpsWk02c> deleteModels) {
        tbTpsWk02cCommandMapper.deletecdMrgCelCompnDtl(deleteModels);
    }
}
