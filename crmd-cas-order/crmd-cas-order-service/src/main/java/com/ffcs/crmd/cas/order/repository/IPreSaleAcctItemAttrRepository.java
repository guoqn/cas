package com.ffcs.crmd.cas.order.repository;


import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;

import java.util.List;
import java.util.Map;

public interface IPreSaleAcctItemAttrRepository extends ICrmdBaseRepository<PreSaleAcctItemAttr,Long>  {
    /**
     * 获取账目项属性。
     * @param map
     * @return
     */
    List<PreSaleAcctItemAttr> queryPreSaleAcctItemAttr(Map map);

}
