package com.ffcs.crmd.cas.order.service.impl;

import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttrHis;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcAttrService;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcAttrRepository;

import java.util.List;
import java.util.Map;

@Service("preSaleOrderProcAttrService")
public class PreSaleOrderProcAttrServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderProcAttr, Long>
    implements IPreSaleOrderProcAttrService {

   	@Autowired
	IPreSaleOrderProcAttrRepository preSaleOrderProcAttrRepository;

	@Override
	public List<PreSaleOrderProcAttr> queryPreSaleOrderProcAttr(Map param) {
		return preSaleOrderProcAttrRepository
				.queryListByName("preSaleOrderRepository.queryPreSaleOrderProcAttr",
						PreSaleOrderProcAttr.class, param);
	}

	@Override
	public PreSaleOrderProcAttr queryLastBackProcAttr(Map param) {
		PreSaleOrderProcAttr preSaleOrderProcAttr = null;
		if (param.containsKey("his")) {
			param.remove("his");
			List<PreSaleOrderProcAttrHis> list = preSaleOrderProcAttrRepository
					.queryListByName("preSaleOrderRepository.queryLastBackProcAttrHis",
							PreSaleOrderProcAttrHis.class, param);
			if (list != null && list.size() > 0) {
				PreSaleOrderProcAttrHis preSaleOrderProcAttrHis = list.get(0);
				preSaleOrderProcAttr = new PreSaleOrderProcAttr();
				CrmBeanUtils.applyIf(preSaleOrderProcAttr,preSaleOrderProcAttrHis);
			}
		} else {
			List<PreSaleOrderProcAttr> list = preSaleOrderProcAttrRepository
					.queryListByName("preSaleOrderRepository.queryLastBackProcAttr",
							PreSaleOrderProcAttr.class, param);
			if (list != null && list.size() > 0) {
				preSaleOrderProcAttr = list.get(0);
			}
		}
		return preSaleOrderProcAttr;
	}
}
