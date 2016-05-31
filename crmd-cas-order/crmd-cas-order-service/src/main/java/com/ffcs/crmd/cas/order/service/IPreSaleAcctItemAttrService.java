package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;

import java.util.List;
import java.util.Map;

public interface IPreSaleAcctItemAttrService extends ICrmdGenericService<PreSaleAcctItemAttr, Long> {
    /**
     *
     * @param param
     * @return
     */
    List<PreSaleAcctItemAttr> queryPreSaleAcctItemAttr(Map param);
}
