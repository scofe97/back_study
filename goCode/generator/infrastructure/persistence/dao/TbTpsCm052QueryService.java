package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsCm052QueryMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TbTpsCm052QueryService {

    private final TbTpsCm052QueryMapper tbTpsCm052QueryMapper;

    @Transactional(readOnly = true)
    public List<TbTpsCm052> selectPplnMapngInfoList() {
        return tbTpsCm052QueryMapper.selectPplnMapngInfoList();
    }

    @Transactional(readOnly = true)
    public TbTpsCm052 selectPplnMapngInfo(TbTpsCm052 selectModel) {
        return tbTpsCm052QueryMapper.selectPplnMapngInfo(selectModel)
                .orElseThrow(() -> new TpsException(ErrorCodeGeneral.DATA_NOT_FOUND));
    }
}
