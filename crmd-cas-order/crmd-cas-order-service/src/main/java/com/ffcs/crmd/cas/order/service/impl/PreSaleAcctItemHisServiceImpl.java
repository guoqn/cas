package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemHis;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemHisRepository;

@Service("preSaleAcctItemHisService")
public class PreSaleAcctItemHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleAcctItemHis, Long>
    implements IPreSaleAcctItemHisService {

   	@Autowired
	IPreSaleAcctItemHisRepository preSaleAcctItemHisRepository;
}
