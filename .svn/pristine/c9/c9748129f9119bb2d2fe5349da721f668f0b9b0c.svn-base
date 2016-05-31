package com.ffcs.crmd.cas.order.service;

import java.util.List;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttrHis;

public interface IPreSaleOrderAttrService extends ICrmdGenericService<PreSaleOrderAttr, Long> {

    /**
     * 根据预受理单ID和属性ID查询预受理单属性
     * @author YULIYAO 2016/1/26
     * return 
     */
    public PreSaleOrderAttr getByOrderAndAttrId(Long preOrderId, Long attrId);

    /**
     * 根据预受理单ID和属性ID查询预受理单属性
     * @author YULIYAO 2016/1/26
     * return
     */
     PreSaleOrderAttrHis getHisByOrderAndAttrId(Long preOrderId, Long attrId);
     /**
      * 移除P订单属性.
      * 
      * @param preOrderId
      * @return
      */
     public int removeByOrderId(Long preOrderId);
     /**
      * 获取P订单属性.
      * 
      * @param preOrderId
      * @return
      */
     public List<PreSaleOrderAttr> getAttrsByOrderId(Long preOrderId);
}
