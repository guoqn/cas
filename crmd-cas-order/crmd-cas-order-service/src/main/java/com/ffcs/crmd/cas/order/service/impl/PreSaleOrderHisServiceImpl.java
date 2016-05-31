package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderHis;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderHisRepository;

import java.util.List;
import java.util.Map;

@Service("preSaleOrderHisService")
public class PreSaleOrderHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderHis, Long>
    implements IPreSaleOrderHisService {

   	@Autowired
	IPreSaleOrderHisRepository preSaleOrderHisRepository;

	/**
	 * 查询预受理订单历史表
	 * @author YULIYAO 2016/3/22
	 * return
	 */
	@Override
	public List<PreSaleOrderHis> queryPreSaleOrderHis(Map param) {
		return preSaleOrderHisRepository.queryListByName("preSaleOrderRepository.queryPreSaleOrderHis",PreSaleOrderHis.class,param);
	}
}
