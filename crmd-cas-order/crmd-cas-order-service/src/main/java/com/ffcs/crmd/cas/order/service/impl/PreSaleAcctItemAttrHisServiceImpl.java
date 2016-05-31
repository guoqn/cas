package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttrHis;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemAttrHisService;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemAttrHisRepository;

@Service("preSaleAcctItemAttrHisService")
public class PreSaleAcctItemAttrHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleAcctItemAttrHis, Long>
    implements IPreSaleAcctItemAttrHisService {

   	@Autowired
	IPreSaleAcctItemAttrHisRepository preSaleAcctItemAttrHisRepository;
}
