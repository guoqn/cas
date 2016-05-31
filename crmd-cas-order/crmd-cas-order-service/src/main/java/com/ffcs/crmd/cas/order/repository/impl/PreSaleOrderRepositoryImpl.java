package com.ffcs.crmd.cas.order.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderRepository;
import com.ffcs.crmd.cas.order.vo.OrderOverTimeStatVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderCountVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("preSaleOrderRepository")
public class PreSaleOrderRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrder, Long>
		implements IPreSaleOrderRepository {

	public PreSaleOrderRepositoryImpl() {
		super(PreSaleOrder.class);
	}

	@Override
	public PageInfo queryPreSaleOrder(PreSaleOrderVo preSaleOrderVo) {
		Map params = new HashMap();
		// 查询条件：预受理编号
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getPreOrderNumber())) {
			params.put("preOrderNumber", preSaleOrderVo.getPreOrderNumber());
		}
		// 查询条件：受理时间-开始时间
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getBeginTime())) {
			params.put("beginTime", preSaleOrderVo.getBeginTime());
		}
		// 查询条件：受理时间-结束时间
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getEndTime())) {
			params.put("endTime", preSaleOrderVo.getEndTime());
		}
		// 查询条件：区域
		if (preSaleOrderVo.getCommmonRegionIds() != null && preSaleOrderVo.getCommmonRegionIds().size() > 0) {
			params.put("commonRegionIds", preSaleOrderVo.getCommmonRegionIds());
		}
		// 查询条件：预受理员工
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getStaffId())) {
			params.put("staffId", preSaleOrderVo.getStaffId());
		}
		// 查询条件：预受理团队
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getOrgId())) {
			params.put("orgId", preSaleOrderVo.getOrgId());
		}
		// 查询条件：状态
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getStatusCd())) {
			params.put("statusCd", preSaleOrderVo.getStatusCd());
		}
		// 查询条件：正式单编码
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getCustSoNumber())) {
			params.put("custSoNumber", preSaleOrderVo.getCustSoNumber());
		}
		// 查询条件：seq
		if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getSeq())) {
			params.put("seq", preSaleOrderVo.getSeq());
		}
		return this.queryPageInfoByName("preSaleOrderRepository.queryPreSaleOrder", PreSaleOrder.class, params,
				preSaleOrderVo.getPageNumber(), preSaleOrderVo.getPageSize());
	}

	@Override
	public List<PreSaleOrder> queryPreSaleOrderList(Map param) {
		return this.queryListByName("preSaleOrderRepository.queryPreSaleOrder", PreSaleOrder.class, param);
	}

	@Override
	public List<PreSaleOrderHis> queryPreSaleOrderHisList(Map param) {
		return this.queryListByName("preSaleOrderRepository.queryPreSaleOrderHis", PreSaleOrderHis.class, param);
	}

	/**
	 * 查询超时统计
	 * 
	 * @author YULIYAO 2016/3/10 return
	 */
	@Override
	public List<OrderOverTimeStatVo> queryOrderOverTimeStat(int procCount, int model) {
		List param = new ArrayList();
		param.add(procCount);
		param.add(model);
		return this.jdbcFindListByName("preSaleOrderRepository.queryOrderOverTimeStat", OrderOverTimeStatVo.class,
				param);
	}

	@Override
	public PreSaleOrder getLastCustOrderIdByPreOrderNbr(Map param) {
		PreSaleOrder preSaleOrder = null;
		List<PreSaleOrder> list = this.queryListByName("preSaleOrderRepository.getLastCustOrderIdByPreOrderNbr",
				PreSaleOrder.class, param);
		if (list != null && list.size() > 0) {
			preSaleOrder = list.get(0);
		}
		return preSaleOrder;
	}

	@Override
	public PageInfo getPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd,
			String beginDate, String endDate, int currentPage, int perPageNum) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(saleStaffId)) {
			params.put("saleStaffId", saleStaffId);
		}
		if (!StringUtils.isNullOrEmpty(saleOrgId)) {
			params.put("saleOrgId", saleOrgId);
		}
		if (!StringUtils.isNullOrEmpty(beginDate)) {
			params.put("beginDate", beginDate);
		}
		if (!StringUtils.isNullOrEmpty(endDate)) {
			params.put("endDate", endDate);
		}
		if (!StringUtils.isNullOrEmpty(statusCd)) {
			params.put("statusCd", statusCd);
		}
		return this.queryPageInfoByName("preSaleOrderRepository.getPreOrderByDevStaffAndDevTeam", PreSaleOrder.class,
				params, currentPage, perPageNum);
	}

	@Override
	public PageInfo getHisPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd,
			String beginDate, String endDate, int currentPage, int perPageNum) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(saleStaffId)) {
			params.put("saleStaffId", saleStaffId);
		}
		if (!StringUtils.isNullOrEmpty(saleOrgId)) {
			params.put("saleOrgId", saleOrgId);
		}
		if (!StringUtils.isNullOrEmpty(beginDate)) {
			params.put("beginDate", beginDate);
		}
		if (!StringUtils.isNullOrEmpty(endDate)) {
			params.put("endDate", endDate);
		}
		if (!StringUtils.isNullOrEmpty(statusCd)) {
			params.put("statusCd", statusCd);
		}
		return this.queryPageInfoByName("preSaleOrderRepository.getHisPreOrderByDevStaffAndDevTeam",
				PreSaleOrderHis.class, params, currentPage, perPageNum);
	}

	@Override
	public List<PreSaleOrderCountVo> qryPreOrderStatusAndNumGroupByStatus(String saleStaffId, String saleOrgId,
			String beginDate, String endDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(saleStaffId)) {
			params.put("saleStaffId", saleStaffId);
		}
		if (!StringUtils.isNullOrEmpty(saleOrgId)) {
			params.put("saleOrgId", saleOrgId);
		}
		if (!StringUtils.isNullOrEmpty(beginDate)) {
			params.put("beginDate", beginDate);
		}
		if (!StringUtils.isNullOrEmpty(endDate)) {
			params.put("endDate", endDate);
		}
		return this.queryListByName("preSaleOrderRepository.qryPreOrderStatusAndNumGroupByStatus",
				PreSaleOrderCountVo.class, params);
	}

	@Override
	public List<PreSaleOrderCountVo> qryHisPreOrderStatusAndNumGroupByStatus(String saleStaffId, String saleOrgId,
			String beginDate, String endDate) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(saleStaffId)) {
			params.put("saleStaffId", saleStaffId);
		}
		if (!StringUtils.isNullOrEmpty(saleOrgId)) {
			params.put("saleOrgId", saleOrgId);
		}
		if (!StringUtils.isNullOrEmpty(beginDate)) {
			params.put("beginDate", beginDate);
		}
		if (!StringUtils.isNullOrEmpty(endDate)) {
			params.put("endDate", endDate);
		}
		return this.queryListByName("preSaleOrderRepository.qryHisPreOrderStatusAndNumGroupByStatus",
				PreSaleOrderCountVo.class, params);
	}

}
