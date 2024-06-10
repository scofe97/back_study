package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Mapper
public interface TbTpsWk022CommandMapper {
    void createSltmDtl(TbTpsWk022 createModel);

    void updateSltmDtl(TbTpsWk022 updateModel);

    void deleteSltmDtl(List<TbTpsWk022> deleteModelList);
}
