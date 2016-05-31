package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItemHis;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderItemHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemHisRepository;

@Service("preSaleOrderItemHisService")
public class PreSaleOrderItemHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderItemHis, Long>
    implements IPreSaleOrderItemHisService {

   	@Autowired
	IPreSaleOrderItemHisRepository preSaleOrderItemHisRepository;
}
