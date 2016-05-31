package com.ffcs.crmd.cas.intf.api.facade;

import com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.intf.api.dto.CheckRelIntfDepOrderInDTO;
import com.ffcs.crmd.cas.intf.api.dto.ISaleAcctItemInDTO;
import com.ffcs.crmd.cas.intf.api.dto.QueryCustOrderInDTO;
import com.ffcs.crmd.cas.intf.api.dto.SaveDocInfoInDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.List;
import java.util.Map;

/**
 * 调用crm.
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/16
 * @功能说明：
 */
public interface ICasToCrmFacade extends ICrmdBaseFacade {
    /**
     * 判断是否已经有关联Intf_Dep_Order.
     * @param inParamDto
     * @return
     * @throws Exception
     */
    RetVo checkRelIntfDepOrder(CheckRelIntfDepOrderInDTO inParamDto);

    /**
     * 移除订单接口映射记录。
     * @return
     * @throws Exception
     */
    RetVo removeCustOrderMap(String preOrderNumber);

    /**
     * 判断是否是拍照甩单，并且没有关联别的订单或者订单项.
     * @param extCustOrderId
     * @return
     * @throws Exception
     */
    RetVo checkPhotoNotReDeal(String extCustOrderId, String preOrderNumber);

    /**
     * 客户订单查询。
     * @param inParamDto
     * @return
     */
    RetVo queryCustomerOrder(QueryCustOrderInDTO inParamDto);

    /**
     * P单关联的订单是否自动算费，以及集团订单缴费完成通知接口。
     * @param preOrderNumber
     * @param extCustOrderId
     * @return
     */
    RetVo autoRelCustOrder(String preOrderNumber, Long extCustOrderId, List<ISaleAcctItemInDTO> dtos);

    /**
     * 判断p单关联的订单是否允许撤销.
     * @param custOrderId
     * @param orgId
     * @param staffPositionId
     * @param inDTOList
     * @return
     */
    RetVo checkCancel(String custOrderId, Long orgId, Long staffPositionId, CustomerOrder[] inDTOList);

    /**
     * 转变更单处理。
     * @param extCustOrderId
     * @return
     */
    RetVo convertToModOrder(Long extCustOrderId);

    /**
     * 继续受理
     * @param extCustOrderId
     * @return
     */
    RetVo continueAcceptConfirm(Long extCustOrderId);

    /**
     * 通道订单进行流程处理以及营业报表处理。
     * @param extCustOrderId
     * @param ifEnd
     * @return
     */
    RetVo noticeToDealOrder(Long extCustOrderId, String ifEnd);

    /**
     * 根据客户标识custId查找客户名称
     * 0:custId 1:staffId
     * @param custId
     * @return
     */
    RetVo qryCustInfo(String[] custId,String type);

    /**
     * P单与FJ单建立关联.
     * @param infos
     * @return
     */
    RetVo dealConnect(List<Map<String,String>> infos);
    /**
     * 附件上传
     * @param inDto
     * @return
     */
    RetVo saveDocInfo(SaveDocInfoInDTO inDto);

    /**
     * 根据订单流水号查询订单。
     * @param custSoNums
     * @return
     */
    RetVo queryCustOrderByNum(List<String> custSoNums);
}
