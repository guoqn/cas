package com.ffcs.crmd.cas.dat.facade.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.dat.api.facade.IPreSaleOrderProcDatFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcRepository;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
@Service("preSaleOrderProcDatFacade")
public class PreSaleOrderProcDatFacadeImpl implements IPreSaleOrderProcDatFacade {
	
	IPreSaleOrderProcRepository preSaleOrderProcRepository = ApplicationContextUtil
			.getBean("preSaleOrderProcRepository");

	@Override
	public List<PreSaleOrderProcDTO> queryPreSaleOrderProc(PreSaleOrderProc proc) {
		
		List<PreSaleOrderProc> preSaleOrderProcs = preSaleOrderProcRepository.queryPreSaleOrderProc(proc);
		return CrmBeanUtils.copyList(preSaleOrderProcs, PreSaleOrderProcDTO.class);
	}

}
