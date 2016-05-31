package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.InteractionFlowDTO;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;

public interface IInteractionFlowFacade extends ICrmdBaseFacade {

    /**
     * 保存
     * @author YULIYAO 2016/1/5
     * return 
     */
    public int save(InteractionFlowDTO interactionFlowDTO);

    /**
     * 修改
     * @author YULIYAO 2016/1/5
     * return 
     */
    public int update(InteractionFlowDTO interactionFlowDTO);

    /**
     * 删除
     * @author YULIYAO 2016/1/5
     * return 
     */
    public int remove(InteractionFlowDTO interactionFlowDTO);

    /**
     * 根据流程名称查询工单池流程
     * @author YULIYAO 2016/1/5
     * return 
     */
    public PageInfo queryFlowByName(InteractionFlowVo interactionFlowVo);

}
