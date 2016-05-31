package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItemHis;
import com.ffcs.crmd.cas.order.repository.IIsaleAcctItemHisRepository;

@Repository("isaleAcctItemHisRepository")
public class IsaleAcctItemHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<IsaleAcctItemHis, Long>
    implements IIsaleAcctItemHisRepository {

    public IsaleAcctItemHisRepositoryImpl() {
        super(IsaleAcctItemHis.class);
    }

}
