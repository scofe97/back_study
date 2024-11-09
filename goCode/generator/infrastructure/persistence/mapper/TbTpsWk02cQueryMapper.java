package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;

@Mapper
public interface TbTpsWk02cQueryMapper {
    List<TbTpsWk02c> selectcdMrgCelCompnDtlList();

    Optional<TbTpsWk02c> selectcdMrgCelCompnDtl(TbTpsWk02c selectModel);
}
