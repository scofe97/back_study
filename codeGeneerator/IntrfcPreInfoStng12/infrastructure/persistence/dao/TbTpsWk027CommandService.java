package org.okestro.tps.api..dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api..mapper.TbTpsWk027CommandMapper;
import org.okestro.tps.api..model.TbTpsWk027;

@Service
@RequiredArgsConstructor
public class TbTpsWk027CommandService {

    private final TbTpsWk027CommandMapper commandMapper;

    public void createIntrfcPreInfoStng12(TbTpsWk027 createModel) {
        commandMapper.createIntrfcPreInfoStng12(createModel);
    }

    public void updateIntrfcPreInfoStng12(TbTpsWk027 updateModel) {
        commandMapper.updateIntrfcPreInfoStng12(updateModel);
    }

    public void deleteIntrfcPreInfoStng12(List<TbTpsWk027> deleteModels) {
        commandMapper.deleteIntrfcPreInfoStng12(deleteModels);
    }
}
