package com.ffcs.crmd.cas.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.IntfPreOrder;
import com.ffcs.crmd.cas.order.entity.IntfPreOrderAttach;
import com.ffcs.crmd.cas.order.service.IIntfPreOrderService;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderRepository;

@Service("intfPreOrderService")
public class IntfPreOrderServiceImpl extends AbsCrmdGenericServiceImpl<IntfPreOrder, Long>
    implements IIntfPreOrderService {

   	@Autowired
	IIntfPreOrderRepository intfPreOrderRepository;
   	@Override
   	public List<IntfPreOrder> queryIntfPreOrder(Map param) {
   		return intfPreOrderRepository.queryIntfPreOrder(param);
   	}
}
