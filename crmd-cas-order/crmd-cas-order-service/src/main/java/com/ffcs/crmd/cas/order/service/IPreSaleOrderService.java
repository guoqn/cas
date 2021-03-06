package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CompleteOrderInfo;
import com.ffcs.crmd.cas.bean.casbean.presaleordercommit.PreSaleOrderInfo;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.api.dto.IntfPreOrderDTO;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.order.entity.*;
import com.ffcs.crmd.cas.order.vo.OrderOverTimeStatVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderService extends ICrmdGenericService<PreSaleOrder, Long> {

	/**
	 * 查询预受理订单,分页
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
	 * 补收款
	 *
	 * @author YULIYAO 2016/1/15 return
	 */
	public void submitReFee(Long preOrderId, List<AttrValue> attrValues, Long staffId);

	/**
	 * 查询历史预受理订单。
	 * 
	 * @param param
	 * @return
	 */
	List<PreSaleOrderHis> queryPreSaleOrderHisList(Map param);

	/**
	 * 预受理订单项查询。
	 * 
	 * @param preOrderId
	 * @return
	 */
	List<PreSaleOrderItem> queryPreSaleOrderItems(Long preOrderId);

	/**
	 * 根据P订单号获取第一张P订单.
	 * 
	 * @param preOrderNumber
	 * @return
	 */
	PreSaleOrder queryFirstPreOrderByOrderNumber(String preOrderNumber);

	/**
	 * 查询超时统计
	 * 
	 * @author YULIYAO 2016/3/10 return
	 */
	List<OrderOverTimeStatVo> queryOrderOverTimeStat(int procCount, int model);

	/**
	 * 根据P订单号获取第一张历史P订单
	 * 
	 * @param preOrderNumber
	 * @return
	 */
	PreSaleOrderHis queryFirstPreSaleOrderHisByOrderNumber(String preOrderNumber);

	/**
	 * 根据P订单号获取关联的最新的正式订单的ID，仅从pre_sale_order一表查询.
	 * 
	 * @param preOrderNumber
	 * @return
	 */
	String getLastCustOrderIdByPreOrderNbr(String preOrderNumber);

	/**
	 * 查询轮询泉州工单池自动发送
	 * 
	 * @param procCount
	 * @param model
	 * @param perSize
	 * @return
	 */
	List<IntfPreOrder> queryIntfOrderWaitSent(int procCount, int model, int perSize);

	/**
	 * 查询同编码比当前对象ID小的数据，返回最小的id
	 * 
	 * @author YULIYAO 2016/3/11 return
	 */
	List<IntfPreOrderDTO> queryIntfPreOrder(Map param);

	/**
	 * 通过订单id去获取P单。
	 * 
	 * @param extCustOrderId
	 * @return
	 */
	PreSaleOrder getPreSaleOrderByExtOrderId(Long extCustOrderId);
	/**
	 * 根据订单ID获取对应的PRE_SALE_ORDER记录.
	 * @param extCustOrderId
	 * @return
	 */
	PreSaleOrder getSelfPreSaleOrderByExtOrderId(Long extCustOrderId);

	/**
	 * 通过订单id去获取历史P单.
	 * 
	 * @param extCustOrderId
	 * @return
	 */
	AbsCrmdBaseEntity getPreSaleOrderHisByExtOrderId(Long extCustOrderId);

	/**
	 * 预受理账务处理通知。
	 * 
	 * @param preSaleOrderDTO
	 * @param reqType
	 * @return
	 */
	RetVo announceCharge(PreSaleOrder preSaleOrder, Long reqType);

	/**
	 * 预受理订单重送保存.
	 * 
	 * @param preSaleOrder
	 * @param orderPool
	 * @param attrs
	 * @param vos
	 */
	void savePreSaleOrderForReSend(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool, List<PreSaleOrderAttr> attrs,
			List<PreSaleOrderProcVo> vos, StaffDTO staffDTO);

	/**
	 * 缴费完成保存数据.
	 * 
	 * @param preSaleOrder
	 * @param items
	 * @param attrsForSave
	 * @param attrsForRemove
	 * @param staffDTO
	 */
	void savePreForCompletePayment(PreSaleOrder preSaleOrder, List<PreSaleAcctItem> items,
			List<PreSaleOrderAttr> attrsForSave, List<PreSaleOrderAttr> attrsForRemove, StaffDTO staffDTO);

	/**
	 * 正常订单确认时保存，包括省内接口订单和集团接口订单.
	 *
	 * @param preSaleOrder
	 * @param orderPool
	 * @param newPreSaleOrder
	 * @param staffDTO
	 */
	void savePreForNormalCommit(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool, PreSaleOrder newPreSaleOrder,
			StaffDTO staffDTO);

	/**
	 * 撤销竣工移到二表.
	 *
	 * @param preSaleOrder
	 * @param staffDTO
	 */
	void removePreForCancelComplete(PreSaleOrder preSaleOrder, StaffDTO staffDTO, List<PreSaleOrderProcVo> preSaleOrderProcVos);

	/**
	 * 撤销竣工保存.
	 * 
	 * @param preSaleOrder
	 * @param orderPool
	 * @param staffDTO
	 */
	void savePreForCancelComplete(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool, StaffDTO staffDTO, List<PreSaleOrderProcVo> preSaleOrderProcVos);

	/**
	 * 查询已竣工的预受理单，供轮洵调用
	 * 
	 * @author YULIYAO 2016/4/1 return
	 */
	List<PreSaleOrder> queryCompleteOrderAuto(Map map);

	/**
	 * 根据销售员工/销售团队查询回退单列表
	 * 
	 * @author YULIYAO 2016/4/6 return
	 */
	PageInfo queryReturnList(Map param, int currentPage, int perPageNum);

	/**
	 * 集团单省内缴费归档处理
	 * 
	 * @author YULIYAO 2016/4/7 return
	 */
	PageInfo queryCompleteGroupOrderAuto(int model, int procCount, int perSize);

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
	PageInfo getPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd, String beginDate,
			String endDate, int currentPage, int perPageNum);

	/**
	 * 根据销售员工/销售团队查询回退单列表 - 历史
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @param currentPage
	 * @param perPageNum
	 * @return
	 */
	PageInfo getHisPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd, String beginDate,
			String endDate, int currentPage, int perPageNum);

	/**
	 * 状态和状态数量(1和2表)
	 * 
	 * @param saleStaffId
	 * @param saleOrgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Map<String, Object> getPreOrderStatusAndStatusNumber(String saleStaffId, String saleOrgId,
			String beginDate, String endDate);
	/**
	 * 退单时数据更新.
	 * 
	 * @param preSaleOrder
	 * @param orderPool
	 * @param staffDTO
	 * @param procVos
	 * @param eventId
	 */
	public void savePreSaleOrderForReturn(PreSaleOrder preSaleOrder,
			PreSaleOrderPool orderPool, StaffDTO staffDTO,
			List<PreSaleOrderProcVo> procVos, Long eventId);
	/**
	 * 接口撤销P订单保存，不包含通知移动客户端的处理.
	 * 
	 * @param preSaleOrder
	 * @param cancelFlag -- 撤销标识
							1：表示撤销P订单
							其他值或者空表示不撤销P订单，仅仅将P单标识为已结单，而不做撤销
	 * @param staffDTO -- 撤销员工
	 * @param staffPositionId -- 撤销员工岗位ID
	 * @param cancelReason -- 撤销原因
	 * @param amount -- 退款金额
	 */
	public void saveCancelPreOrder(PreSaleOrder preSaleOrder,
			String cancelFlag, StaffDTO staffDTO, Long staffPositionId,
			String cancelReason, Long amount);
	/**
     * 预受理费用项处理.
     * @param preSaleOrder
     * @param msg
     * @author Luxb
     * 2016年4月30日 Luxb
     */
	void cancelOrderForAcctItem(PreSaleOrder preSaleOrder, String msg);

	/**
	 * 甩单保存预受理单信息
	 * @author YULIYAO 2016/5/19
	 * return 
	 */
	void savePreSaleOrder(PreSaleOrderInfo info);

	/**
	 * 
	 * @author YULIYAO 2016/5/19
	 * return 
	 */
	PreSaleOrder saveCompleteOrderInfo(CompleteOrderInfo orderInfo);
}
