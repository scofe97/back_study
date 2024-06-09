package org.okestro.tps.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Mapper
public interface TbTpsWk022QueryMapper {
    List<TbTpsWk022> selectSltmPreInfoDtlList();

    TbTpsWk022 selectSltmPreInfoDtl(TbTpsWk022 selectModel);
}