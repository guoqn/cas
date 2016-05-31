package com.ffcs.crmd.cas.order.repository;


import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderItemRepository extends ICrmdBaseRepository<PreSaleOrderItem,Long>  {

    /**
     * 查询预受理订单项
     * @author YULIYAO 2016/1/21
     * return 
     */
    public List<PreSaleOrderItem> queryPreOrderItem(Map param);
}
