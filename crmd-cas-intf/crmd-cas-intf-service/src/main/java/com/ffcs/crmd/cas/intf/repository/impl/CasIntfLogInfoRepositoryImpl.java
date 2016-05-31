package com.ffcs.crmd.cas.intf.repository.impl;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogInfo;
import com.ffcs.crmd.cas.intf.repository.ICasIntfLogInfoRepository;
import org.springframework.stereotype.Repository;

@Repository("casIntfLogInfoRepository")
public class CasIntfLogInfoRepositoryImpl extends AbsCrmdBaseRepositoryImpl<CasIntfLogInfo, Long>
    implements ICasIntfLogInfoRepository {

    public CasIntfLogInfoRepositoryImpl() {
        super(CasIntfLogInfo.class);
    }

}
