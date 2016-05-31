package com.ffcs.crmd.cas.order.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrg;
import com.ffcs.crmd.cas.order.repository.IInteractionAssignOrgRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("interactionAssignOrgRepository")
public class InteractionAssignOrgRepositoryImpl extends AbsCrmdBaseRepositoryImpl<InteractionAssignOrg, Long>
    implements IInteractionAssignOrgRepository {

    public InteractionAssignOrgRepositoryImpl() {
        super(InteractionAssignOrg.class);
    }

    @Override
    public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo) {
        Map<String, Object> params = new HashMap<>();
        //流程ID
        if (!StringUtils.isNullOrEmpty(interactionAssignOrgVo.getInteractionFlowId())) {
            params.put("flowId", interactionAssignOrgVo.getInteractionFlowId());
        }
        //录单团队名称
        if (!StringUtils.isNullOrEmpty(interactionAssignOrgVo.getOrgName())) {
            params.put("orgName", interactionAssignOrgVo.getOrgName());
        }
        //二次受理团队名称
        if (!StringUtils.isNullOrEmpty(interactionAssignOrgVo.getExecuteOrgName())) {
            params.put("executeOrgName", interactionAssignOrgVo.getExecuteOrgName());
        }
        //流程列表
        if (!StringUtils.isNullOrEmpty(interactionAssignOrgVo.getFlowIds())) {
            params.put("flowIds", interactionAssignOrgVo.getFlowIds());
        }
        return this.queryPageInfoByName("interactionAssignOrgRepository.queryAssignOrg",
            InteractionAssignOrg.class, params, interactionAssignOrgVo.getPageNumber(),
            interactionAssignOrgVo.getPageSize());
    }

    @Override
    public List<InteractionAssignOrg> queryAllAssignOrgs(Map param) {
        return this.queryListByName("interactionAssignOrgRepository.queryAllAssignOrgs",
                InteractionAssignOrg.class, param);
    }
}
