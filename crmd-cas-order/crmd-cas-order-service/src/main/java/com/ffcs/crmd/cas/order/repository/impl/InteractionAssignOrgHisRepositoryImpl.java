package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrgHis;
import com.ffcs.crmd.cas.order.repository.IInteractionAssignOrgHisRepository;

@Repository("interactionAssignOrgHisRepository")
public class InteractionAssignOrgHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<InteractionAssignOrgHis, Long>
    implements IInteractionAssignOrgHisRepository {

    public InteractionAssignOrgHisRepositoryImpl() {
        super(InteractionAssignOrgHis.class);
    }

}
