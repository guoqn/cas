package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttrHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcAttrHisRepository;

@Repository("preSaleOrderProcAttrHisRepository")
public class PreSaleOrderProcAttrHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderProcAttrHis, Long>
    implements IPreSaleOrderProcAttrHisRepository {

    public PreSaleOrderProcAttrHisRepositoryImpl() {
        super(PreSaleOrderProcAttrHis.class);
    }

}
