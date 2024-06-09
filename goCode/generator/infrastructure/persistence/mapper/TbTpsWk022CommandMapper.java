package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Mapper
public interface TbTpsWk022CommandMapper {
    void createSltmPreInfoDtl(TbTpsWk022 createModel);

    void updateSltmPreInfoDtl(TbTpsWk022 updateModel);

    void deleteSltmPreInfoDtl(List<TbTpsWk022> deleteModelList);
}
