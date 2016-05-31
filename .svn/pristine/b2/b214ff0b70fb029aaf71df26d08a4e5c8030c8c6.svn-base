package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItem;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;

import java.util.List;

public interface IPreSaleAcctItemService extends ICrmdGenericService<PreSaleAcctItem, Long> {

    /**
     * 查询预受理单账目项
     * @author YULIYAO 2016/1/20
     * return 
     */
    public List<PreSaleAcctItem> queryPreSaleAcctItem(PreSaleAcctItem acctItem);

    /**
     * 删除预受理单关联的所有账目项
     * @author YULIYAO 2016/1/20
     * return 
     */
    public int removeByOrderId(Long preOrderId);
    /**
     * 预受理费用项处理.
     * @param preSaleOrder
     * @author Luxb
     * 2016年4月30日 Luxb
     */
    void cancelOrderForAcctItem(PreSaleOrder preSaleOrder);
    /**
     * 移除.
     * 
     */
    public int remove(PreSaleAcctItem acctItem);
}
