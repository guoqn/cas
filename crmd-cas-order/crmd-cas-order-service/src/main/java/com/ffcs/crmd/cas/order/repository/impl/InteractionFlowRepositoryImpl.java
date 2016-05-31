package com.ffcs.crmd.cas.order.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
import com.ffcs.crmd.cas.order.entity.InteractionFlow;
import com.ffcs.crmd.cas.order.repository.IInteractionFlowRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("interactionFlowRepository")
public class InteractionFlowRepositoryImpl extends AbsCrmdBaseRepositoryImpl<InteractionFlow, Long>
    implements IInteractionFlowRepository {

    public InteractionFlowRepositoryImpl() {
        super(InteractionFlow.class);
    }

    @Override
    public PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo) {
        Map params = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(interactionFlowVo.getInteractionFlowName())) {
            params.put("interactionFlowName", interactionFlowVo.getInteractionFlowName());
        }
        if (!StringUtils.isNullOrEmpty(interactionFlowVo.getAreaId())){
            params.put("areaId", interactionFlowVo.getAreaId());
        }
        return this
            .queryPageInfoByName("interactionFlowRepository.queryFlowByName", InteractionFlow.class,
                params, interactionFlowVo.getPageNumber(),
                interactionFlowVo.getPageSize());
    }

    @Override
    public List<InteractionFlow> queryFlowList(InteractionFlowVo interactionFlowVo) {
        Map params = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(interactionFlowVo.getInteractionFlowName())) {
            params.put("interactionFlowName", interactionFlowVo.getInteractionFlowName());
        }
        if (!StringUtils.isNullOrEmpty(interactionFlowVo.getAreaId())){
            params.put("areaId", interactionFlowVo.getAreaId());
        }
        return this.queryListByName("interactionFlowRepository.queryFlowByName", InteractionFlow.class,params);
    }
}
