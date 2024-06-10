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

    public void createSltmDtl(TbTpsWk022 createModel) {
        commandMapper.createSltmDtl(createModel);
    }

    public void updateSltmDtl(TbTpsWk022 updateModel) {
        commandMapper.updateSltmDtl(updateModel);
    }

    public void deleteSltmDtl(List<TbTpsWk022> deleteModels) {
        commandMapper.deleteSltmDtl(deleteModels);
    }
}
