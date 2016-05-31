package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.bean.casbean.presaleordercommit.PreSaleOrderInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.intf.api.dto.*;
import com.ffcs.crmd.cas.order.api.dto.*;
import com.ffcs.crmd.cas.order.api.vo.CancelPreOrderVo;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderFacade extends ICrmdBaseFacade {
    /**
     *
     * @param preSaleOrderId
     * @return
     */
    PreSaleOrderDTO getById(Long preSaleOrderId, Long shardingId);

    /**
     * 查询预受理订单
     * @author YULIYAO 2016/1/12
     * return 
     */
    public PageInfo queryPreSaleOrder(PreSaleOrderVo preSaleOrderVo);

    /**
     * 通过预受理编号查询预受理单ID
     * @author YULIYAO 2016/4/1
     * return
     */
    public List<Long> queryExtCustOrderIdByNo(String preOrderNumber);

    /**
     * 补收款
     * @author YULIYAO 2016/1/15
     * return 
     */
    public boolean reFee(Long preOrderId, List<AttrValueDTO> attrValueDTOList);

    /**
     * 撤销
     * @author YULIYAO 2016/1/16
     * return 
     */
    public String cancel(PreSaleOrderVo vo);

    /**
     *
     * @param preOrderNumber
     * @param orgId
     * @param staffPositionId
     * @return
     */
    RetVo callIntfPreFeeQuery(String preOrderNumber, Long orgId, Long staffPositionId);

    /**
     * 费用收费
     * @author YULIYAO 2016/1/25
     * return
     */
    public RetVo pay(PreSaleOrderDTO preSaleOrderDTO, Long staffPositionId, Long orgId,
        Long areaId);

    /**
     * 预受理订单状态查询。
     * @param inDto
     * @return
     */
    QueryPreOrderStatusOutDTO queryPreOrderStatus(QueryPreOrderStatusInDTO inDto);

    /**
     *
     * @param preOrderNumber
     * @param orgId
     * @param staffPositionId
     * @return
     */
    Long getRemainPreFeeFromHb(String preOrderNumber, Long orgId, Long staffPositionId);

    /**
     * 状态通知。
     * @param preSaleOrderDTO
     * @param statusCd
     * @return
     */
    RetVo stateChange(PreSaleOrderDTO preSaleOrderDTO, String statusCd);

    /**
     * 状态通知pad。
     * @param preSaleOrderDTO
     * @return
     */
    RetVo sendStateChangeToPad(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 归档处理。
     * @param preSaleOrderDTO
     * @return
     */
    RetVo completePreOrder(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * P单关联查询。
     * @param inDTO
     * @return
     */
    QueryPreSaleOrderIsRelationOutDTO queryPreSaleOrderIsRelation(
        QueryPreSaleOrderIsRelationInDTO inDTO);
	/**
     *
     * @param preOrderNumber
     * @param dropDesc
     * @param dropResult
     * @return
     */
    RetVo saveDropPreSaleOrder(String preOrderNumber, String dropDesc, String dropResult);

    /**
     *
     * @param preSaleOrderDTO
     * @return
     */
    int remove(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 判断关联的二表订单中是否存在竣工的订单.
     * @return
     */
    boolean existCompleteOrder(String preOrderNumber, Long extCustOrderId);

    /**
     * 判断关联的订单中，是否存在预受理状态的订单.
     * @param preOrderNumber
     * @return
     */
    boolean existsPreSaleOrder(String preOrderNumber,Long extCustOrderId);

    /**
     * 根据P单，查询类型去获取订单或历史订单列表。
     * @param preOrderNumber
     * @param qryType
     * @return
     */
    QueryCustOrderOutDTO queryCustOrder(String preOrderNumber,Long extCustOrderId, String qryType);

    /**
     * 获取p单全部关联的订单Ids.
     * @param preOrderNumber
     * @return
     */
    String getExtCustOrderIds(String preOrderNumber);

    /**
     * 接口修改工单池接收员工和接收团队.
     * @param preOrderNumber
     * @param receiveStaffId
     * @param receiveOrgId
     * @param remark
     * @return
     */
    RetVo intfModPreSaleOrderPool(String preOrderNumber, String receiveStaffId, String receiveOrgId, String remark);

    /**
     * 预受理订单是否有费用。
     * @param preOrderNumber
     * @return
     */
    RetVo orderHasFee(String preOrderNumber);

    /**
     * 发送短信
     * @author YULIYAO 2016/3/1
     * 0：实时发送（任意时间调用接口立刻发送到用户终端）
     * 1：非作息时间发送（8:00-12:30
     * return
     */
    RetVo sentMsg(String phoneNumber, String msgContent, long type);

    /**
     *
     * @param customerOrderDTO
     * @return
     */
    RetVo convertToModOrder(CustomerOrderDTO customerOrderDTO);
	/**
     * 预受理账务处理完成通知.
     * @param preOrderNumber
     * @param reqType
     * @return
     */
    RetVo preCompletePayment(String preOrderNumber, Long reqType);

    /**
     * p单撤销验证。
     * @param orgId
     * @param staffPositionId
     * @param preOrderNumber
     * @return
     */
    RetVo validateInParam(Long orgId, Long staffPositionId, String preOrderNumber);

    /**
     * p单撤销查询预受理订单信息拼接。
     * @param orgId
     * @param staffPositionId
     * @param preOrderNumber
     * @return
     */
    RetVo buildPreOrder(Long lantId, Long orgId, Long staffPositionId, String preOrderNumber);

    /**
     * 向计费发起撤销.
     * @param orgId
     * @param latnId
     * @param staffPositionId
     * @param vpreOrder
     * @param customerOrders
     * @param preSaleOrderDTO
     * @return
     */
    RetVo doPreFeeCancel(Long orgId, String latnId, Long staffPositionId,
                         com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.PreOrder vpreOrder,
                         List<com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder> customerOrders,
                         PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 接口撤销p单相关信息处理。
     * @param preSaleOrderDTO
     * @param staffPositionId
     * @return
     */
	RetVo saveOrderCancel(PreSaleOrderDTO preSaleOrderDTO,
			Long staffPositionId, Long amount, String retCode,
			String cancelReason);

    /**
     * 预受理过程属性历史表保存。
     * @param preSaleOrderDTO
     * @param eventId
     * @param staff
     */
    void saveProcHis(PreSaleOrderDTO preSaleOrderDTO, Long eventId, StaffDTO staff, String cancelReason);

    /**
     * 根据订单Id获取p单。
     * @param map
     * @return
     */
    RetVo queryPreSaleOrder(Map map);

    /**
     * 订单确认通知集中受理处理P单相关信息。
     * @param isNeedPay
     * @param extCustOrderId
     * @param inDTO
     * @return
     */
    RetVo preSaleOrderDeal(boolean isNeedPay, Long extCustOrderId, PreSaleOrderDealInDTO inDTO);

    /**
     * 预受理订单保存
     * @param inDTO
     * @return
     */
    RetVo savePreSaleOrder(PreSaleOrderInfo info);

    /**
     * 工单池提交。
     * @param inDTO
     * @return
     */
    RetVo savePreSaleOrderPool(PreSaleOrderPoolInDTO inDTO);

    /**
     * intfPreOrder提交。
     * @param inDTO
     * @return
     */
    RetVo saveIntfPreOrder(List<IntfPreOrderInDTO> inDTO);

    /**
     * 保存，根据ID是否存在判断新增或者个性
     * @param intfPreOrderDTO
     * @return
     */
    int saveIntfPreOrder(IntfPreOrderDTO intfPreOrderDTO);

    /**
     * 查询超时统计
     * @author YULIYAO 2016/3/10
     * return
     */
    List<OrderOverTimeStatDTO> queryOrderOverTimeStat(int procCount, int model);

    /**
     * 查询轮询泉州工单池自动发送
     * @param procCount
     * @param model
     * @param perSize
     * @return
     */
    List<IntfPreOrderDTO> queryIntfOrderWaitSent(int procCount, int model, int perSize);

    /**
     * 查询同编码比当前对象ID小的数据，返回最小的id
     * @author YULIYAO 2016/3/11
     * return
     */
    Long getRelaIntfPreOrderId(IntfPreOrderDTO intfPreOrderDTO);

    /**
     * 获取报文
     * @author YULIYAO 2016/3/12
     * return
     */
    String getIntfPreOrderText(Long intfPreOrderId);
    /**
     * 查询过程信息。
     * @param preOrderNumber
     * @return
     */
    RetVo queryPreOrderFlow(String preOrderNumber);

    /**
     * 根据P单查询状态接口增加：当前集中受理人员、联系电话、团队名称.
     * @param preOrderNumber
     * @return
     */
    RetVo queryPreOrderInfo(String preOrderNumber);

    PreSaleOrderDTO getFirstPreSaleOrder(String preOrderNumber);
    
    /**
     * 从预受理单历史表获取第一张单
     * @author YULIYAO 2016/3/24
     * return 
     */
    PreSaleOrderHisDTO getFirstPreSaleOrderHis(String preOrderNumber);


    /**
     * 保存
     * @author YULIYAO 2016/3/16
     * return
     */
    int save(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 订单查询中相关p单信息获取。
     * @param extCustOrderId
     * @return
     */
    RetVo queryPreOrderForOrder(Long extCustOrderId);

    void createPreProc(Long preSaleOrderId, Long shardingId, Long staffId,
        List<AttrValueDTO> attrValueDTOs, Long eventId, String attrDesc);

    /**
     * 保存处理过程及属性历史表
     * @author YULIYAO 2016/3/18
     * return
     */
    void createPreProcHis(Long preSaleOrderId, Long shardingId, Long staffId,
        List<AttrValueDTO> attrValueDTOs, Long eventId, String attrDesc);

    /**
     * 根据正式单ID查询预受理订单，取第一条
     * @author YULIYAO 2016/3/22
     * return 
     */
    PreSaleOrderDTO getByExtCustOrderId(String customerOrderId);

    /**
     * 根据正式单编号查询预受理订单历史表，取第一条
     * @author YULIYAO 2016/3/22
     * return
     */
    PreSaleOrderHisDTO getHisByCustOrderNumber(String custOrderNumber);

    /**
     * 删除预受理订单历史数据
     * @author YULIYAO 2016/3/24
     * return 
     */
    int deletePreOrderHis(PreSaleOrderHisDTO hisDTO);
    /**
     * preSaleOrderCommit处理.
     *
     * @param _inParam
     * @return
     */
    public RetVo preSaleOrderCommit(com.ffcs.crmd.cas.bean.casbean.presaleordercommit.InParam _inParam);
    /**
     * 获取工单池信息.
     * @param preOrderId
     * @return
     */
    public PreSaleOrderPoolDTO getPreSaleOrderByPreOrderId(Long preOrderId);

    /**
     * 查询已竣工的预受理单，供轮洵调用
     * @author YULIYAO 2016/4/1
     * return 
     */
    List<PreSaleOrderDTO> queryCompleteOrderAuto(int model, int procCount, int diffDate);

    /**
     * /**
     * 根据销售员工/销售团队查询回退单列表
     * @author YULIYAO 2016/4/6
     * return
     */
    PageInfo queryReturnList(Long saleOrgId, Long saleStaffId, int currentPage, int perPageNum);
    /**
     * 根据P单号查询预受理单信息
     * @param preOrderNumber
     * @return
     */
    RetVo queryPreSaleOrder(String preOrderNumber);

    /**
     * 集团单省内缴费归档处理
     * @author YULIYAO 2016/4/7
     * return
     */
    PageInfo queryCompleteGroupOrderAuto(int model, int procCount, int perSize);

    /**
     * 根据销售员工/销售团队查询回退单列表.
     * @param saleStaffId
     * @param saleOrgId
     * @param beginDate
     * @param endDate
     * @param currentPage
     * @param perPageNum
     * @return
     */
    PageInfo getPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId,String statusCd, String beginDate, String endDate, int currentPage, int perPageNum);

    /**
     * 根据ID获取历史表
     * @param preSaleOrderId
     * @return
     */
    PreSaleOrderHisDTO getHisById(Long preSaleOrderId);
    /**
     * 根据销售员工/销售团队查询回退单列表.
     * @param saleStaffId
     * @param saleOrgId
     * @param beginDate
     * @param endDate
     * @param currentPage
     * @param perPageNum
     * @return
     */
    PageInfo getHisPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId,String statusCd, String beginDate, String endDate, int currentPage, int perPageNum);

    /**
     * @param saleStaffId
     * @param saleOrgId
     * @param beginDate
     * @param endDate
     * @return
     */
    public Map<String, Object> getPreOrderStatusAndStatusNumber(String saleStaffId, String saleOrgId,
			String beginDate, String endDate);
    /**
     * 根据P订单号获取关联的最新FJ订单ID.
     * 
     * @param preOrderNumber
     * @return
     */
    String getLastCustOrderIdByPreOrderNbr(String preOrderNumber);

    /**
     * 是否显示机器人受理按钮
     * @author YULIYAO 2016/4/19
     * return
     */
    boolean isShowRobotBtn(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 机器人受理按钮响应
     * @author YULIYAO 2016/4/19
     * return
     */
    void autoGen(PreSaleOrderDTO preSaleOrderDTO);
    /**
     * 工单池回退.
     * 
     * @param preOrderNumber
     * @param handleStaffId
     * @param reason
     * @param srcFlag--pool:工单接收界面退单--audit:退单稽核界面退单，默认pool
     * @return
     */
    RetVo returnToPreSale(String preOrderNumber, Long handleStaffId, String reason, String srcFlag, String reasonType);
    /**
     * 预销售订单调用计费页面后续处理.
     * @param preSaleOrderDTO
     * @return
     * @author Luxb
     * 2016年4月30日 Luxb
     */
    RetVo preSaleOrderPayDeal(PreSaleOrderDTO preSaleOrderDTO);
    /**
     * 判断P订单是否可以撤销.
     * 
     * @param preOrderNumber
     * @param orgIdStr
     * @return
     */
    RetVo checkCouldCancelForIntf(String preOrderNumber, String orgIdStr);
    /**
     * 接口撤销P订单.
     * 
     * @param cancelPreOrderVo
     * @return
     */
    RetVo cancelPreOrder(CancelPreOrderVo cancelPreOrderVo);

    /**
     * 根据预受理订单ID删除预受理订单历史记录
     * @author YULIYAO 2016/5/16
     * return 
     */
    int deletePreOrderHisByOrderId(Long preOrderId, Long shardingId);
}
