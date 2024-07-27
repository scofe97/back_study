package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;

@Mapper
public interface TbTpsCm052QueryMapper {
    List<TbTpsCm052> selectPplnMapngInfoList();

    Optional<TbTpsCm052> selectPplnMapngInfo(TbTpsCm052 selectModel);
}
