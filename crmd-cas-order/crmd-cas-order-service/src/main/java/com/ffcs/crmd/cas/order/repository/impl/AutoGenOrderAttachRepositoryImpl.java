package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrderAttach;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderAttachRepository;

@Repository("autoGenOrderAttachRepository")
public class AutoGenOrderAttachRepositoryImpl extends AbsCrmdBaseRepositoryImpl<AutoGenOrderAttach, Long>
    implements IAutoGenOrderAttachRepository {

    public AutoGenOrderAttachRepositoryImpl() {
        super(AutoGenOrderAttach.class);
    }

}
