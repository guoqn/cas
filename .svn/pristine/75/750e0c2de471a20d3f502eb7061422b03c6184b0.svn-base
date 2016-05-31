package com.ffcs.crmd.cas.order.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.IntfPreOrder;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderRepository;

@Repository("intfPreOrderRepository")
public class IntfPreOrderRepositoryImpl extends AbsCrmdBaseRepositoryImpl<IntfPreOrder, Long>
    implements IIntfPreOrderRepository {

    public IntfPreOrderRepositoryImpl() {
        super(IntfPreOrder.class);
    }
    @Override
    public List<IntfPreOrder> queryIntfPreOrder(Map param) {
    	return this.queryListByName("preSaleOrderRepository.queryIntfPreOrder", IntfPreOrder.class, param);
    }
}
