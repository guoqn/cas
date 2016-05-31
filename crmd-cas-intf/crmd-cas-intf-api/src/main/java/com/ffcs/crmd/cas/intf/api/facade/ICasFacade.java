package com.ffcs.crmd.cas.intf.api.facade;

import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/16
 * @功能说明：
 */
public interface ICasFacade extends ICrmdBaseFacade {
    /**
     * 工单池状态查询.
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrderStatus(String inXml) throws Exception;

    /**
     * 查询P订单是否有关联.
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrderIsRelation(String inXml) throws Exception;

    /**
     * 普坤自动信息保存。
     * @param inXml
     * @return
     * @throws Exception
     */
    String saveAutoGenOrder(String inXml) throws Exception;

    /**
     * 普坤自动化受理结果接收接口.
     * @param inXml
     * @return
     * @throws Exception
     */
    String autoGenOrderComplete(String inXml) throws Exception;

    /**
     * 将预受理工单从销售人员回到二次受理人员.
     * @param inXml
     * @return
     * @throws Exception
     */
    String dropPreSaleOrderToCrm(String inXml) throws Exception;

    /**
     * CRM对外提供的派单接口.
     * @param inXml
     * @return
     * @throws Exception
     */
    String modPreSaleOrder(String inXml) throws Exception;

    /**
     *关联预受理订单，并且存在未销帐或者已销帐的预受理费用项.
     * @param inXml
     * @return
     * @throws Exception
     */
    String preSaleOrderHasFee(String inXml) throws Exception;

    /**
     * 预受理账务处理完成通知.
     * @param inXml
     * @return
     * @throws Exception
     */
    String preCompletePayment(String inXml) throws Exception;

    /**
     * PAD调用CRM撤销P订单以及关联的FJ订单.
     * @param inXml
     * @return
     * @throws Exception
     */
    String cancelOrderCommit(String inXml) throws Exception;

    /**
     * PAD调用CRM撤销P订单以及关联的FJ订单时查询。
     * @param inXml
     * @return
     * @throws Exception
     */
    String cancelOrderQuery(String inXml) throws Exception;

    /**
     * 获取p单信息。
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrder(String inXml) throws Exception;

    /**
     * 订单确认通知P单处理。
     * @param inXml
     * @return
     * @throws Exception
     */
    String preSaleOrderDeal(String inXml) throws Exception;

    /**
     * CRM订单确认所需P单信息获取。
     * @param inXml
     * @return
     * @throws Exception
     */
    String preOrderCommitCheck(String inXml) throws Exception;

    /**
     * 预受理订单提交。
     * @param inXml
     * @return
     * @throws Exception
     */
    String preSaleOrderCommit(String inXml) throws Exception;

    /**
     * 预受理工单池提交。
     * @param inXml
     * @return
     * @throws Exception
     */
    String preSaleOrderPoolCommit(String inXml) throws Exception;

    /**
     * intfPreOrder提交。
     * @param inXml
     * @return
     * @throws Exception
     */
    String intfPreOrderCommit(String inXml) throws Exception;

    /**
     * 查询预受理处理过程.
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrderFlow(String inXml) throws Exception;

    /**
     * 根据P单查询状态接口增加：当前集中受理人员、联系电话、团队名称.
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrderInfo(String inXml) throws Exception;

    /**
     * 订单查询中p单相关信息获取。
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreOrderForOrder(String inXml) throws Exception;

    /**
     * 根据销售员工/销售团队查询回退单列表
     * @author YULIYAO 2016/4/6
     * return
     */
    String queryReturnList(String inXml) throws Exception;
    /**
     * 根据P单号查询预受理单信息
     * @param inXml
     * @return
     * @throws Exception
     */
    String queryPreSaleOrder(String inXml) throws Exception;

    /**
     * 根据销售员工/销售团队和日期范围查询预受理单统计及清单.
     * @return
     * @throws Exception
     */
    String preSaleOrderCount(String inXml) throws Exception;
    /**
     * 工单池回退接口.
     * 
     * @param inXml
     * @return
     * @throws Exception
     */
    String returnToPreSale(String inXml) throws Exception;

    String queryintAssignOrg(String inXml) throws Exception;
    /**
     * 判断P单是否可以撤销接口.
     * 
     * @param inXml
     * @return
     * @throws Exception
     */
    String checkCouldCancel(String inXml) throws Exception;
    /**
     * 撤销P订单接口.
     * 
     * @param inXml
     * @return
     * @throws Exception
     */
    String cancelPreOrder(String inXml) throws Exception;
    /**
     * 工单处理情况清单接口
     * @param inXml
     * @return
     * @throws Exception
     * @author linguanghao
     */
    String qryPreSaleOrderProc(String inXml) throws Exception;
    /**
     * 超时预警清单接口
     * @param inXml
     * @return
     * @throws Exception
     * @author linguanghao
     */
    String qryPreSaleOrderOverTimeList(String inXml) throws Exception;
}
