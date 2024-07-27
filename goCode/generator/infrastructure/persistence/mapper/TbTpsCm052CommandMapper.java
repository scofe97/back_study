package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;

@Mapper
public interface TbTpsCm052CommandMapper {
    void createPplnMapngInfo(TbTpsCm052 createModel);

    void updatePplnMapngInfo(TbTpsCm052 updateModel);

    void deletePplnMapngInfo(List<TbTpsCm052> deleteModelList);
}
