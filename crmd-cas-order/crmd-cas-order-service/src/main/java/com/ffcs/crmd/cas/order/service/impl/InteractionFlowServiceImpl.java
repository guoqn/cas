package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;
import com.ffcs.crmd.cas.order.repository.IInteractionFlowRepository;
import com.ffcs.crmd.cas.order.service.IInteractionFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("interactionFlowService")
public class InteractionFlowServiceImpl extends AbsCrmdGenericServiceImpl<InteractionFlow, Long>
    implements IInteractionFlowService {

   	@Autowired
	IInteractionFlowRepository interactionFlowRepository;

	@Override
	public PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo) {
		return interactionFlowRepository.queryFlowByName(interactionFlowVo);
	}

	@Override
	public List<InteractionFlow> queryFlowList(InteractionFlowVo interactionFlowVo) {
		return interactionFlowRepository.queryFlowList(interactionFlowVo);
	}
}
