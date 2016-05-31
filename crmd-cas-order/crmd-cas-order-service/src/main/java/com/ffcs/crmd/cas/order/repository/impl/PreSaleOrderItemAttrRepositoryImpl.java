package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItemAttr;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemAttrRepository;

@Repository("preSaleOrderItemAttrRepository")
public class PreSaleOrderItemAttrRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderItemAttr, Long>
    implements IPreSaleOrderItemAttrRepository {

    public PreSaleOrderItemAttrRepositoryImpl() {
        super(PreSaleOrderItemAttr.class);
    }

}
