package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.IntfPreOrderAttach;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderAttachRepository;

@Repository("intfPreOrderAttachRepository")
public class IntfPreOrderAttachRepositoryImpl extends AbsCrmdBaseRepositoryImpl<IntfPreOrderAttach, Long>
    implements IIntfPreOrderAttachRepository {

    public IntfPreOrderAttachRepositoryImpl() {
        super(IntfPreOrderAttach.class);
    }

}
