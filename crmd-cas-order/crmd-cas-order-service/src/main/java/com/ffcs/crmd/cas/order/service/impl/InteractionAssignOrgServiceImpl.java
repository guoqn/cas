package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrg;
import com.ffcs.crmd.cas.order.service.IInteractionAssignOrgService;
import com.ffcs.crmd.cas.order.repository.IInteractionAssignOrgRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("interactionAssignOrgService")
public class InteractionAssignOrgServiceImpl extends AbsCrmdGenericServiceImpl<InteractionAssignOrg, Long>
    implements IInteractionAssignOrgService {

   	@Autowired
	IInteractionAssignOrgRepository interactionAssignOrgRepository;

	@Override
	public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo) {
		return interactionAssignOrgRepository.queryAssignOrg(interactionAssignOrgVo);
	}

	@Override
	public List<InteractionAssignOrg> queryAllAssignOrgs(Long areaId) {
		Map param = new HashMap();
		if (areaId != null) {
			param.put("areaId", areaId);
		}
		return interactionAssignOrgRepository.queryAllAssignOrgs(param);
	}

	@Override
	public List<InteractionAssignOrg> queryAssignOrgIntf(Map param) {
		return interactionAssignOrgRepository.queryListByName("interactionAssignOrgRepository.queryAssignOrgIntf",InteractionAssignOrg.class, param);
	}
}
