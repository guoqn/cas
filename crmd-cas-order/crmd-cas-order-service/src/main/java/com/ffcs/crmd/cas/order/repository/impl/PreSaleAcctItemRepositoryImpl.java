package com.ffcs.crmd.cas.order.repository.impl;

import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;
import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItem;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemRepository;

import java.util.List;
import java.util.Map;

@Repository("preSaleAcctItemRepository")
public class PreSaleAcctItemRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleAcctItem, Long>
    implements IPreSaleAcctItemRepository {

    public PreSaleAcctItemRepositoryImpl() {
        super(PreSaleAcctItem.class);
    }
}
