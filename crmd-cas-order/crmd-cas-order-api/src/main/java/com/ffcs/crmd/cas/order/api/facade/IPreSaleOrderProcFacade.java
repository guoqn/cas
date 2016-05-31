package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcAttrDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

public interface IPreSaleOrderProcFacade extends ICrmdBaseFacade {

    /**
     * 查询预受理订单处理过程
     * @author YULIYAO 2016/1/13
     * return 
     */
    public PageInfo queryPreSaleOrderProcPage(PreSaleOrderProcDTO dto,int pageNumber,int pageSize);

    /**
     * 获取预受理处理过程
     * @author YULIYAO 2016/4/7
     * return 
     */
    PreSaleOrderProcDTO getById(Long preSaleOrderProcId);

    /**
     * 获取最后一条退单属性
     * @author YULIYAO 2016/4/7
     * return 
     */
    PreSaleOrderProcAttrDTO getLastBackProcAttr(Long preOrderId);
    /**
     * 工单处理情况清单接口
     * @param inParam
     * @return
     * @author linguanghao
     */
    RetVo queryPreSaleOrderProcForIntf(com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc.InParam inParam);
}
