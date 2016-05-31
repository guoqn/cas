package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemAttrRepository;

import java.util.List;
import java.util.Map;

@Repository("preSaleAcctItemAttrRepository")
public class PreSaleAcctItemAttrRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleAcctItemAttr, Long>
    implements IPreSaleAcctItemAttrRepository {

    public PreSaleAcctItemAttrRepositoryImpl() {
        super(PreSaleAcctItemAttr.class);
    }

    @Override
    public List<PreSaleAcctItemAttr> queryPreSaleAcctItemAttr(Map param) {
        return this.queryListByName("preSaleOrderRepository.queryPreSaleAcctItemAttr", PreSaleAcctItemAttr.class,
                param);
    }
}
