package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPoolHis;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderPoolHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderPoolHisRepository;

@Service("preSaleOrderPoolHisService")
public class PreSaleOrderPoolHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderPoolHis, Long>
    implements IPreSaleOrderPoolHisService {

   	@Autowired
	IPreSaleOrderPoolHisRepository preSaleOrderPoolHisRepository;
}
