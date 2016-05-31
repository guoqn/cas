package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrg;

import java.util.List;
import java.util.Map;

public interface IInteractionAssignOrgService extends ICrmdGenericService<InteractionAssignOrg, Long> {

    /**
     *
     * @param interactionAssignOrgVo
     * @return
     */
    public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo);

    /**
     * 获取转派团队列表信息。
     * @param areaId
     * @return
     */
    List<InteractionAssignOrg> queryAllAssignOrgs(Long areaId);

    List<InteractionAssignOrg> queryAssignOrgIntf(Map param);
}
