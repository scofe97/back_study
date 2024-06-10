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

    public void createSltmCompnDtl(TbTpsWk022 createModel) {
        commandMapper.createSltmCompnDtl(createModel);
    }

    public void updateSltmCompnDtl(TbTpsWk022 updateModel) {
        commandMapper.updateSltmCompnDtl(updateModel);
    }

    public void deleteSltmCompnDtl(List<TbTpsWk022> deleteModels) {
        commandMapper.deleteSltmCompnDtl(deleteModels);
    }
}
