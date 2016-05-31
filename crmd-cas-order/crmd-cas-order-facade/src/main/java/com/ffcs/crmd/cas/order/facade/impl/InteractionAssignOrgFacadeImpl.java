package com.ffcs.crmd.cas.order.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.InteractionAssignOrgDTO;
import com.ffcs.crmd.cas.order.api.facade.IInteractionAssignOrgFacade;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrg;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;
import com.ffcs.crmd.cas.order.service.IInteractionAssignOrgService;
import com.ffcs.crmd.cas.order.service.IInteractionFlowService;
import com.ffcs.crmd.cas.sys.api.dto.CommonRegionDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("interactionAssignOrgFacade")
public class InteractionAssignOrgFacadeImpl extends CrmdBaseFacade implements IInteractionAssignOrgFacade {
   	@Autowired
	IInteractionAssignOrgService interactionAssignOrgService;
	@Autowired
	IInteractionFlowService      iInteractionFlowService;
	@Autowired
	private ICasSysFacade casSysFacade;

	@Override
	public int save(InteractionAssignOrgDTO interactionAssignOrgDTO) {
		InteractionAssignOrg interactionAssignOrg = new InteractionAssignOrg(true);
		try {
			BeanUtils.applyIf(interactionAssignOrg, interactionAssignOrgDTO, false);
			interactionAssignOrg.setStatusCd(CasConstant.STATUS_CD_VAILID.getValue());
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionAssignOrgService.save(interactionAssignOrg);
	}

	@Override
	public int update(InteractionAssignOrgDTO interactionAssignOrgDTO) {
		InteractionAssignOrg interactionAssignOrg = new InteractionAssignOrg();
		try {
			BeanUtils.applyIf(interactionAssignOrg, interactionAssignOrgDTO, false);
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionAssignOrgService.update(interactionAssignOrg);
	}

	@Override
	public int remove(InteractionAssignOrgDTO interactionAssignOrgDTO) {
		InteractionAssignOrg interactionAssignOrg = new InteractionAssignOrg();
		try {
			BeanUtils.applyIf(interactionAssignOrg, interactionAssignOrgDTO, false);
		} catch (Exception e) {
			ExceptionUtils.throwEx(e);
		}
		return interactionAssignOrgService.remove(interactionAssignOrg);
	}

	@Override
	public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo) {
		List<Long> flows = new ArrayList<>();
		if (!StringUtils.isNullOrEmpty(interactionAssignOrgVo.getAreaId())) {
			InteractionFlowVo flowVo = new InteractionFlowVo();
			flowVo.setAreaId(interactionAssignOrgVo.getAreaId());
			List<InteractionFlow> interactionFlows = iInteractionFlowService.queryFlowList(flowVo);
			if (CollectionUtils.isEmpty(interactionFlows)) {
				return new PageInfo();
			}
			for (InteractionFlow interactionFlow : interactionFlows) {
				flows.add(interactionFlow.getInteractionFlowId());
			}
			interactionAssignOrgVo.setFlowIds(flows);
		}
		PageInfo pageInfo = interactionAssignOrgService.queryAssignOrg(interactionAssignOrgVo);
		if (pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size() > 0) {
			try {
				List<InteractionAssignOrgDTO> interactionAssignOrgDTOList = CrmBeanUtils
						.copyList(pageInfo.getList(), InteractionAssignOrgDTO.class);
				for (InteractionAssignOrgDTO dto : interactionAssignOrgDTOList) {
					if (!StringUtils.isNullOrEmpty(dto.getOrgId())) {
						//查询团队名称
						dto.setOrgName(casSysFacade.getNameById(dto.getOrgId()));
					}
					if (!StringUtils.isNullOrEmpty(dto.getExecuteOrgId())) {
						dto.setExecuteOrgName(casSysFacade.getNameById(dto.getExecuteOrgId()));
					}
					//查询三级区域名称
					if (!StringUtils.isNullOrEmpty(dto.getCommonRegionId())) {
						CommonRegionDTO commonRegionDTO = casSysFacade
								.getCommonRegionById(dto.getCommonRegionId());
						dto.setCommonRegionName(
								commonRegionDTO == null ? null : commonRegionDTO.getRegionName());
					}
					//查询四级区域名称
					if (!StringUtils.isNullOrEmpty(dto.getCfourRegionId())) {
						CommonRegionDTO commonRegionDTO = casSysFacade
								.getCommonRegionById(dto.getCfourRegionId());
						dto.setCfourRegionName(
								commonRegionDTO == null ? null : commonRegionDTO.getRegionName());
					}
				}
				pageInfo.setList(interactionAssignOrgDTOList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pageInfo;
	}

	@Override
	public List<InteractionAssignOrgDTO> queryAllAssignOrgs(InteractionAssignOrgDTO interactionAssignOrgDTO) {
		List<InteractionAssignOrg> orgs = interactionAssignOrgService.queryAllAssignOrgs(interactionAssignOrgDTO.getAreaId());
		List<InteractionAssignOrgDTO> dtos = null;
		if (orgs != null && orgs.size() >0) {
			dtos = new ArrayList<InteractionAssignOrgDTO>();
			for (InteractionAssignOrg org : orgs) {
				InteractionAssignOrgDTO dto = new InteractionAssignOrgDTO();
				CrmBeanUtils.applyIf(dto,org);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	/**
	 * 接口查询团队配置
	 * @author YULIYAO 2016/4/29
	 * return
	 */
	@Override
	public List<InteractionAssignOrgDTO> queryAssignOrgIntf(Long execusteOrgId, List<String> regionCds) {
		if (execusteOrgId == null || execusteOrgId == 0 || CollectionUtils.isEmpty(regionCds)) {
			return null;
		}
		Map param = new HashMap<>();
		param.put("execusteOrgId", execusteOrgId);
		param.put("regionCds", regionCds);
		List<InteractionAssignOrg> interactionAssignOrgs = interactionAssignOrgService
				.queryAssignOrgIntf(param);
		if (CollectionUtils.isNotEmpty(interactionAssignOrgs)) {
			return CrmBeanUtils.copyList(interactionAssignOrgs, InteractionAssignOrgDTO.class);
		}
		return null;
	}
}
