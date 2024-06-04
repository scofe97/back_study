package org.okestro.tps.api.infrastructure.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk020;

@Mapper
public interface TbTpsWk020QueryMapper {
    List<TbTpsWk020> selectCompnDtlBscList();

    TbTpsWk020 selectCompnDtlBsc(TbTpsWk020 selectModel);
}
