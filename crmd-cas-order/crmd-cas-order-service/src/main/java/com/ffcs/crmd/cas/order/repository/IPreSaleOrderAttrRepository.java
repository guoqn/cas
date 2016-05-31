package com.ffcs.crmd.cas.order.repository;


import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttrHis;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderAttrRepository extends ICrmdBaseRepository<PreSaleOrderAttr,Long>  {

    /**
     * 查询预受理单属性
     * @author YULIYAO 2016/1/26
     * return 
     */
    public List<PreSaleOrderAttr> queryPreSaleOrderAttr(Map map);

    /**
     * 查询预受理单属性
     * @author YULIYAO 2016/1/26
     * return
     */
    List<PreSaleOrderAttrHis> queryPreSaleOrderAttrHis(Map map);
}
