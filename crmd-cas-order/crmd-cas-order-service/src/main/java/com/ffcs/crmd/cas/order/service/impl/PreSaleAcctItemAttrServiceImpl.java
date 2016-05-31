package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemAttrService;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemAttrRepository;

import java.util.List;
import java.util.Map;

@Service("preSaleAcctItemAttrService")
public class PreSaleAcctItemAttrServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleAcctItemAttr, Long>
    implements IPreSaleAcctItemAttrService {

   	@Autowired
	IPreSaleAcctItemAttrRepository preSaleAcctItemAttrRepository;

	@Override
	public List<PreSaleAcctItemAttr> queryPreSaleAcctItemAttr(Map param) {
		return preSaleAcctItemAttrRepository.queryPreSaleAcctItemAttr(param);
	}
}
