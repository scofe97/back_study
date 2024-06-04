package org.okestro.tps.api..mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.okestro.tps.api..model.TbTpsWk027;

@Mapper
public interface TbTpsWk027CommandMapper {
    void createIntrfcPreInfoStng12(TbTpsWk027 createModel);

    void updateIntrfcPreInfoStng12(TbTpsWk027 updateModel);

    void deleteIntrfcPreInfoStng12(List<TbTpsWk027> deleteModelList);
}
