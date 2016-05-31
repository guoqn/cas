package com.ffcs.crmd.cas.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.IntfPreOrder;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderRepository;

public interface IIntfPreOrderService extends ICrmdGenericService<IntfPreOrder, Long> {
	/**
	 * 
	 * @return
	 */
	List<IntfPreOrder> queryIntfPreOrder(Map param);
}
