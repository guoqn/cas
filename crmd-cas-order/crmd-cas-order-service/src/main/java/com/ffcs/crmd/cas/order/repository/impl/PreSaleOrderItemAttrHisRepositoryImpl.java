package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItemAttrHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemAttrHisRepository;

@Repository("preSaleOrderItemAttrHisRepository")
public class PreSaleOrderItemAttrHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderItemAttrHis, Long>
    implements IPreSaleOrderItemAttrHisRepository {

    public PreSaleOrderItemAttrHisRepositoryImpl() {
        super(PreSaleOrderItemAttrHis.class);
    }

}
