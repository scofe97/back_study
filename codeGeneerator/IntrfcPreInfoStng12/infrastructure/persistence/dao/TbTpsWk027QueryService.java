package org.okestro.tps.api..dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api..mapper.TbTpsWk027QueryMapper;
import org.okestro.tps.api..model.TbTpsWk027;

@Service
@RequiredArgsConstructor
public class TbTpsWk027QueryService {

    private final TbTpsWk027QueryMapper queryMapper;

    public List<TbTpsWk027> selectIntrfcPreInfoStng12List() {
        return queryMapper.selectIntrfcPreInfoStng12List();
    }

    public TbTpsWk027 selectIntrfcPreInfoStng12() {
        return queryMapper.selectIntrfcPreInfoStng12();
    }
}
