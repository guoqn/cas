package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrgHis;
import com.ffcs.crmd.cas.order.service.IInteractionAssignOrgHisService;
import com.ffcs.crmd.cas.order.repository.IInteractionAssignOrgHisRepository;

@Service("interactionAssignOrgHisService")
public class InteractionAssignOrgHisServiceImpl extends AbsCrmdGenericServiceImpl<InteractionAssignOrgHis, Long>
    implements IInteractionAssignOrgHisService {

   	@Autowired
	IInteractionAssignOrgHisRepository interactionAssignOrgHisRepository;
}
