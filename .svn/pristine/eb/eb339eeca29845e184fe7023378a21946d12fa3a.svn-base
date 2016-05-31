package com.ffcs.crmd.cas.dat.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.order.repository.impl.PreSaleOrderProcRepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;
@Repository("preSaleOrderProcRepositoryProxy")
public class PreSaleOrderProcProxyRepositoryImpl extends PreSaleOrderProcRepositoryImpl {
	public PreSaleOrderProcProxyRepositoryImpl(){
		super();
	}
	@Override
	public List<PreSaleOrderProc> queryPreSaleOrderProc(PreSaleOrderProc proc) {
		List<PreSaleOrderProcDTO> preSaleOrderProcDtos = DataServiceUtils.callService("$preSaleOrderProcDatFacade",
				"queryPreSaleOrderProc", proc);
		return CrmBeanUtils.copyList(preSaleOrderProcDtos, PreSaleOrderProc.class);
	}
}
