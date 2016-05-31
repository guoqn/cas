package com.ffcs.crmd.cas.order.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.AutoGenOrder;

import java.util.List;
import java.util.Map;

public interface IAutoGenOrderRepository extends ICrmdBaseRepository<AutoGenOrder,Long>  {

    /**
     * 查询自动处理订单
     * @author YULIYAO 2016/1/21
     * return 
     */
    public List<AutoGenOrder> queryAutoGenOrder(Map param);

    PageInfo queryAutoGenOrder(Map param, int pageNumber, int pageSize);
}
