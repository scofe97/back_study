package org.okestro.tps.api..mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api..model.TbTpsWk027;

@Mapper
public interface TbTpsWk027QueryMapper {
    List<TbTpsWk027> selectIntrfcPreInfoStng12List();

    TbTpsWk027 selectIntrfcPreInfoStng12();
}
