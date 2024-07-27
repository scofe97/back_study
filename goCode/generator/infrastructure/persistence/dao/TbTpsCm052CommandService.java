package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsCm052CommandMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TbTpsCm052CommandService {

    private final TbTpsCm052CommandMapper tbTpsCm052CommandMapper;

    @Transactional
    public void createPplnMapngInfo(TbTpsCm052 createModel) {
        tbTpsCm052CommandMapper.createPplnMapngInfo(createModel);
    }

    @Transactional
    public void updatePplnMapngInfo(TbTpsCm052 updateModel) {
        tbTpsCm052CommandMapper.updatePplnMapngInfo(updateModel);
    }

    @Transactional
    public void deletePplnMapngInfo(List<TbTpsCm052> deleteModels) {
        tbTpsCm052CommandMapper.deletePplnMapngInfo(deleteModels);
    }
}
