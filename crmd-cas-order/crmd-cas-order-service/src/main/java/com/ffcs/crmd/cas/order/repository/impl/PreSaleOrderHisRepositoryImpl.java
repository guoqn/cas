package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderHisRepository;

@Repository("preSaleOrderHisRepository")
public class PreSaleOrderHisRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderHis, Long>
    implements IPreSaleOrderHisRepository {

    public PreSaleOrderHisRepositoryImpl() {
        super(PreSaleOrderHis.class);
    }

}
