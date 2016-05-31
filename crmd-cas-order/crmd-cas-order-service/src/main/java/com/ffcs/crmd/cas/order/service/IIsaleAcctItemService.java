package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItem;

public interface IIsaleAcctItemService extends ICrmdGenericService<IsaleAcctItem, Long> {

    /**
     *
     * @author YULIYAO 2016/1/21
     * return 
     */
    public int removeBySerail(String saleSerial);
}
