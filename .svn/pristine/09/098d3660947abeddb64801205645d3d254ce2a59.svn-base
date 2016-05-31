package com.ffcs.crmd.cas.order.repository.impl;

import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttrHis;
import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderAttrRepository;

import java.util.List;
import java.util.Map;

@Repository("preSaleOrderAttrRepository")
public class PreSaleOrderAttrRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderAttr, Long>
    implements IPreSaleOrderAttrRepository {

    public PreSaleOrderAttrRepositoryImpl() {
        super(PreSaleOrderAttr.class);
    }

    @Override
    public List<PreSaleOrderAttr> queryPreSaleOrderAttr(Map map) {
        return this
                .queryListByName("preSaleOrderRepository.queryPreSaleOrderAttr", PreSaleOrderAttr.class,
                        map);
    }

    @Override
    public List<PreSaleOrderAttrHis> queryPreSaleOrderAttrHis(Map map) {
        return this
                .queryListByName("preSaleOrderRepository.queryPreSaleOrderAttrHis", PreSaleOrderAttrHis.class,
                        map);
    }
}
