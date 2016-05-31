package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemRepository;

import java.util.List;
import java.util.Map;

@Repository("preSaleOrderItemRepository")
public class PreSaleOrderItemRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderItem, Long>
    implements IPreSaleOrderItemRepository {

    public PreSaleOrderItemRepositoryImpl() {
        super(PreSaleOrderItem.class);
    }

    @Override
    public List<PreSaleOrderItem> queryPreOrderItem(Map param) {
        return this
            .queryListByName("preSaleOrderRepository.queryPreOrderItem", PreSaleOrderItem.class,
                param);
    }
}
