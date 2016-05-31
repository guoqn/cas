package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItemAttrHis;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderItemAttrHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemAttrHisRepository;

@Service("preSaleOrderItemAttrHisService")
public class PreSaleOrderItemAttrHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderItemAttrHis, Long>
    implements IPreSaleOrderItemAttrHisService {

   	@Autowired
	IPreSaleOrderItemAttrHisRepository preSaleOrderItemAttrHisRepository;
}
