package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderProcAttrService extends ICrmdGenericService<PreSaleOrderProcAttr, Long> {

    /**
     * 查询预受理单处理过程属性
     * @author YULIYAO 2016/1/20
     * return 
     */
    public List<PreSaleOrderProcAttr> queryPreSaleOrderProcAttr(Map param);

    /**
     * 根据第一张P订单ID获取最新的退单原因.
     * @param param
     * @author Luxb 2016-1-25
     * @return
     */
    PreSaleOrderProcAttr queryLastBackProcAttr(Map param);
}
