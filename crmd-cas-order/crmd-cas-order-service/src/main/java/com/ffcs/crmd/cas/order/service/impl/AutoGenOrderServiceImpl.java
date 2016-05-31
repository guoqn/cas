package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrder;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderRepository;
import com.ffcs.crmd.cas.order.service.IAutoGenOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("autoGenOrderService")
public class AutoGenOrderServiceImpl extends AbsCrmdGenericServiceImpl<AutoGenOrder, Long>
    implements IAutoGenOrderService {

   	@Autowired
	IAutoGenOrderRepository autoGenOrderRepository;

	@Override
	public int removeAutoGenOrder(String preOrderNumber) {
		AutoGenOrder autoGenOrder = getOrderByPreOrderNumber(preOrderNumber);
		if (autoGenOrder != null) {
			autoGenOrder.setStatusCd(IntfConstant.AUTO_GEN_ORDER_STATUS_COMPLETE.getValue());
			return autoGenOrder.remove();
		}
		return 0;
	}

	@Override
	public AutoGenOrder getOrderByPreOrderNumber(String preOrderNumber) {
		if (!StringUtils.isNullOrEmpty(preOrderNumber)) {
			Map param = new HashMap();
			param.put("preSaleOrder", preOrderNumber);
			List<AutoGenOrder> orders = autoGenOrderRepository.queryAutoGenOrder(param);
			if (orders != null && orders.size() > 0) {
				return orders.get(0);
			}
		}
		return null;
	}

	@Override
	public List<AutoGenOrder> queryAutoGenOrder(Map param) {
		return autoGenOrderRepository.queryAutoGenOrder(param);
	}

	@Override
	public PageInfo queryAutoGenOrder(Map param, int pageNumber, int pageSize) {
		return autoGenOrderRepository.queryAutoGenOrder(param, pageSize, pageNumber);
	}

	/**
	 * 轮洵查询：创建状态，关联的P单为待受理，关联的工单池接收员工为空或者是接口工号
	 * @author YULIYAO 2016/3/15
	 * return
	 */
	@Override
	public PageInfo queryAutoGenOrderSentPk(int modelCount, int model, int pageSize) {
		List param = new ArrayList();
		param.add(CasConstant.CREATE.getValue());
		param.add(modelCount);
		param.add(model);
		param.add(1);
		param.add(CasConstant.INTF_STAFF_ID.getValue());
		param.add(CasConstant.PRE_SALE_ORDER_STATUS_CD_WAIT_FOR_DEAL.getValue());
		return autoGenOrderRepository
				.jdbcFindPageInfoByName("preSaleOrderRepository.queryAutoGenOrderSentPk", AutoGenOrder.class, param, 1, pageSize);
	}
}
