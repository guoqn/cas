package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;

import java.util.List;

public interface IInteractionFlowService extends ICrmdGenericService<InteractionFlow, Long> {

    /**
     * 根据名称查询流程
     * @author YULIYAO 2016/1/5
     * return 
     */
    public PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo);

    List<InteractionFlow> queryFlowList(InteractionFlowVo interactionFlowVo);
}
