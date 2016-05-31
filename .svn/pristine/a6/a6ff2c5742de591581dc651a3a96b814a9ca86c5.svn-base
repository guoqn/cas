package com.ffcs.crmd.cas.order.repository.impl;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItem;
import com.ffcs.crmd.cas.order.repository.IIsaleAcctItemRepository;

import java.util.List;
import java.util.Map;

@Repository("isaleAcctItemRepository")
public class IsaleAcctItemRepositoryImpl extends AbsCrmdBaseRepositoryImpl<IsaleAcctItem, Long>
    implements IIsaleAcctItemRepository {

    public IsaleAcctItemRepositoryImpl() {
        super(IsaleAcctItem.class);
    }

    @Override
    public List<IsaleAcctItem> queryISaleAcctItem(Map param) {
        return this
            .queryListByName("preSaleOrderRepository.queryISaleAcctItem", IsaleAcctItem.class,
                param);
    }
}
