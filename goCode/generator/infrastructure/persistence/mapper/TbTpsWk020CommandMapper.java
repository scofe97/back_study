package org.okestro.tps.api.infrastructure.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Mapper
public interface TbTpsWk020CommandMapper {
    void createCompnDtlBsc(TbTpsWk020 createModel);

    void updateCompnDtlBsc(TbTpsWk020 updateModel);

    void deleteCompnDtlBsc(List<TbTpsWk020> deleteModelList);
}
