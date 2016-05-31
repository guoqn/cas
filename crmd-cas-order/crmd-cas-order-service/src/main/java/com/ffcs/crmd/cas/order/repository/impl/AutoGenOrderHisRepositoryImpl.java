package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrderHis;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderHisRepository;

@Repository("autoGenOrderHisRepository")
public class AutoGenOrderHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<AutoGenOrderHis, Long>
    implements IAutoGenOrderHisRepository {

    public AutoGenOrderHisRepositoryImpl() {
        super(AutoGenOrderHis.class);
    }

}
