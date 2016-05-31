package com.ffcs.crmd.cas.order.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import com.ffcs.crmd.cas.order.entity.InteractionAssignOrg;

import java.util.List;
import java.util.Map;

public interface IInteractionAssignOrgRepository extends ICrmdBaseRepository<InteractionAssignOrg,Long>  {

    /**
     *
     * @author YULIYAO 2016/1/8
     * return 
     */
    public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo);

    /**
     * 获取工单池转派团队列表。
     * @param param
     * @return
     */
    List<InteractionAssignOrg> queryAllAssignOrgs(Map param);
}
