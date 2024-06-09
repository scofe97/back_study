package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk022CommandMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Service
@RequiredArgsConstructor
public class TbTpsWk022CommandService {

    private final TbTpsWk022CommandMapper commandMapper;

    public void createSltmPreInfoDtl(TbTpsWk022 createModel) {
        commandMapper.createSltmPreInfoDtl(createModel);
    }

    public void updateSltmPreInfoDtl(TbTpsWk022 updateModel) {
        commandMapper.updateSltmPreInfoDtl(updateModel);
    }

    public void deleteSltmPreInfoDtl(List<TbTpsWk022> deleteModels) {
        commandMapper.deleteSltmPreInfoDtl(deleteModels);
    }
}
