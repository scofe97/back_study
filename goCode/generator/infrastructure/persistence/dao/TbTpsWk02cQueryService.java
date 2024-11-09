package org.okestro.tps.api.dao;

import lombok.RequiredArgsConstructor;
import org.okestro.tps.core.message.exception.ErrorCodeGeneral;
import org.okestro.tps.core.message.exception.TpsException;
import org.springframework.stereotype.Service;
import java.util.List;
import org.okestro.tps.api.infrastructure.persistence.mapper.TbTpsWk02cQueryMapper;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk02c;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TbTpsWk02cQueryService {

    private final TbTpsWk02cQueryMapper tbTpsWk02cQueryMapper;

    @Transactional(readOnly = true)
    public List<TbTpsWk02c> selectcdMrgCelCompnDtlList() {
        return tbTpsWk02cQueryMapper.selectcdMrgCelCompnDtlList();
    }

    @Transactional(readOnly = true)
    public TbTpsWk02c selectcdMrgCelCompnDtl(TbTpsWk02c selectModel) {
        return tbTpsWk02cQueryMapper.selectcdMrgCelCompnDtl(selectModel)
                .orElseThrow(() -> new TpsException(ErrorCodeGeneral.DATA_NOT_FOUND));
    }
}
