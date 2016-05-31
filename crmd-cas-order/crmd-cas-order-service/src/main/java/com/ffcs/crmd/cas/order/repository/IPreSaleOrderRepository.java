package com.ffcs.crmd.cas.order.repository;

import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderHis;
import com.ffcs.crmd.cas.order.vo.OrderOverTimeStatVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderCountVo;

public interface IPreSaleOrderRepository extends ICrmdBaseRepository<PreSaleOrder, Long> {

	/**
	 * 查询预受理订单，分页
	 * 
	 * @author YULIYAO 2016/1/12 return
	 */
	public PageInfo queryPreSaleOrder(PreSaleOrderVo preSaleOrderVo);

	/**
	 * 查询预受理订单
	 * 
	 * @author YULIYAO 2016/1/12 return
	 */
	public List<PreSaleOrder> queryPreSaleOrderList(Map param);

	/**
	 * 查询历史预受理订单.
	 * 
	 * @param param
	 * @return
	 */
	List<PreSaleOrderHis> queryPreSaleOrderHisList(Map param);

	/**
	 * 查询超时统计
	 * 
	 * @author YULIYAO 2016/3/10 return
	 */
	List<OrderOverTimeStatVo> queryOrderOverTimeStat(int procCount, int model);

	/**
	 * 根据P订单号获取关联的最新的正式订单的ID，仅从pre_sale_order一表查询.
	 * 
	 * @param param
	 * @return
	 */
	PreSaleOrder getLastCustOrderIdByPreOrderNbr(Map param);

	/**
	 * 根据销售员工/销售团队查询回退单列表
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @param currentPage
	 * @param perPageNum
	 * @return
	 */
	PageInfo getPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId,String statusCd, String beginDate, String endDate,
			int currentPage, int perPageNum);

	/**
	 * 根据销售员工/销售团队查询回退单列表 --历史
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @param currentPage
	 * @param perPageNum
	 * @return
	 */
	PageInfo getHisPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId,String statusCd, String beginDate, String endDate,
			int currentPage, int perPageNum);

	/**
	 * 不传入状态时，统计P单状态和状态数量
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<PreSaleOrderCountVo> qryPreOrderStatusAndNumGroupByStatus(String saleStaffId, String saleOrgId,
			String beginDate, String endDate);

	/**
	 * 不传入状态时，统计P单状态和状态数量
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<PreSaleOrderCountVo> qryHisPreOrderStatusAndNumGroupByStatus(String saleStaffId, String saleOrgId,
			String beginDate, String endDate);
}
