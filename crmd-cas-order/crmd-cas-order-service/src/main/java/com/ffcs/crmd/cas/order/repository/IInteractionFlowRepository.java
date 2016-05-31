package com.ffcs.crmd.cas.order.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;

import java.util.List;

public interface IInteractionFlowRepository extends ICrmdBaseRepository<InteractionFlow,Long>  {

    PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo);

    List<InteractionFlow> queryFlowList(InteractionFlowVo interactionFlowVo);
}
