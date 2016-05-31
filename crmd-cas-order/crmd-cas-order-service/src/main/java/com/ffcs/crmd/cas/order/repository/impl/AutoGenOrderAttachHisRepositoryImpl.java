package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrderAttachHis;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderAttachHisRepository;

@Repository("autoGenOrderAttachHisRepository")
public class AutoGenOrderAttachHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<AutoGenOrderAttachHis, Long>
    implements IAutoGenOrderAttachHisRepository {

    public AutoGenOrderAttachHisRepositoryImpl() {
        super(AutoGenOrderAttachHis.class);
    }

}
