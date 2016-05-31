package com.ffcs.crmd.cas.sys.repository.impl;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.sys.entity.AreaCode;
import com.ffcs.crmd.cas.sys.repository.IAreaCodeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("areaCodeRepository")
public class AreaCodeRepositoryImpl extends AbsCrmdBaseRepositoryImpl<AreaCode, Long>
    implements IAreaCodeRepository {

    public AreaCodeRepositoryImpl() {
        super(AreaCode.class);
    }

    @Override
    public List<AreaCode> queryAreaCode(Map params) {
        return this.queryListByName("commonRegionRepository.queryAreaCode", AreaCode.class, params);
    }

}
