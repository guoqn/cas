package com.ffcs.crmd.cas.order.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.InteractionFlowDTO;
import com.ffcs.crmd.cas.order.api.facade.IInteractionFlowFacade;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;
import com.ffcs.crmd.cas.order.service.IInteractionFlowService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("interactionFlowFacade")
public class InteractionFlowFacadeImpl extends CrmdBaseFacade implements IInteractionFlowFacade {

	@Autowired
	IInteractionFlowService interactionFlowService;

	@Override
	public int save(InteractionFlowDTO interactionFlowDTO) {
		InteractionFlow interactionFlow = new InteractionFlow(true);
		try {
			BeanUtils.applyIf(interactionFlow, interactionFlowDTO,false);
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionFlowService.save(interactionFlow);
	}

	@Override
	public int update(InteractionFlowDTO interactionFlowDTO) {
		InteractionFlow interactionFlow = new InteractionFlow();
		try {
			BeanUtils.applyIf(interactionFlow, interactionFlowDTO);
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionFlowService.update(interactionFlow);
	}

	@Override
	public int remove(InteractionFlowDTO interactionFlowDTO) {
		InteractionFlow interactionFlow = new InteractionFlow();
		try {
			BeanUtils.applyIf(interactionFlow, interactionFlowDTO);
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionFlowService.remove(interactionFlow);
	}

	@Override
	public PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo) {
		PageInfo pageInfo = interactionFlowService.queryFlowByName(interactionFlowVo);

		if (pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size() > 0) {
			try {
				List<InteractionFlowDTO> interactionFlowDTOList = BeanUtils
						.copyList(pageInfo.getList(), InteractionFlowDTO.class);
				for (InteractionFlowDTO interactionFlowDTO : interactionFlowDTOList) {
					//查询业务大类名称
					String groupName = CrmClassUtils
							.getAttrValueNameByValue(CasConstant.INTERACTION_FLOW.getValue(),
									CasConstant.CUST_ITEM_TYPE_GROUP.getValue(),
									interactionFlowDTO.getCustItemTypeGroup());
					interactionFlowDTO.setCustItemTypeGroupName(groupName);
					//查询状态名称
					String statusCdName = CrmClassUtils
							.getAttrValueNameByValue(InteractionFlow.class.getSimpleName(),
									CasConstant.STATUS_CD.getValue(), interactionFlowDTO.getStatusCd());
					interactionFlowDTO.setStatusCdName(statusCdName);
				}
				pageInfo.setList(interactionFlowDTOList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pageInfo;
	}

}
