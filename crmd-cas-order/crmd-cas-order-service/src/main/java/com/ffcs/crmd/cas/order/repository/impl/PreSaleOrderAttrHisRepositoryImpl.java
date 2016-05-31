package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttrHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderAttrHisRepository;

@Repository("preSaleOrderAttrHisRepository")
public class PreSaleOrderAttrHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderAttrHis, Long>
    implements IPreSaleOrderAttrHisRepository {

    public PreSaleOrderAttrHisRepositoryImpl() {
        super(PreSaleOrderAttrHis.class);
    }

}
