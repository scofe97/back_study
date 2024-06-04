package org.okestro.tps.api.infrastructure.persistence.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk020CommandMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Service
@RequiredArgsConstructor
public class TbTpsWk020CommandService {

    private final TbTpsWk020CommandMapper commandMapper;

    public void createCompnDtlBsc(TbTpsWk020 createModel) {
        commandMapper.createCompnDtlBsc(createModel);
    }

    public void updateCompnDtlBsc(TbTpsWk020 updateModel) {
        commandMapper.updateCompnDtlBsc(updateModel);
    }

    public void deleteCompnDtlBsc(List<TbTpsWk020> deleteModels) {
        commandMapper.deleteCompnDtlBsc(deleteModels);
    }
}
