package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;

@Mapper
public interface TbTpsWk02cCommandMapper {
    void createcdMrgCelCompnDtl(TbTpsWk02c createModel);

    void updatecdMrgCelCompnDtl(TbTpsWk02c updateModel);

    void deletecdMrgCelCompnDtl(List<TbTpsWk02c> deleteModelList);
}
