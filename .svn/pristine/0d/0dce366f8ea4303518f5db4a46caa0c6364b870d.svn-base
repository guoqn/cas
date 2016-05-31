package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;

import java.util.List;

public interface IPreSaleOrderItemService extends ICrmdGenericService<PreSaleOrderItem, Long> {

    /**
     * 根据订单ID删除订单项
     * @author YULIYAO 2016/1/21
     * return 
     */
    public int removeItemByOrderId(Long preSaleOrderId, Long shardingId);

    /**
     *获取
     * @param preSaleOrderId
     * @return
     */
    List<PreSaleOrderItem> queryPreSaleOrderItems(Long preSaleOrderId);
}
