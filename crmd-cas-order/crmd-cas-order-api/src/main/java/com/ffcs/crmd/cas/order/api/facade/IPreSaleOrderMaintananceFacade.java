package com.ffcs.crmd.cas.order.api.facade;

import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderHisDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDetailDTO;

import java.util.List;

/**
 * Created by YULIYAO on 2016/3/21.
 */
public interface IPreSaleOrderMaintananceFacade extends ICrmdBaseFacade {

    /**
     * 根据正式单单号查询订单关联的预受理单
     * 返回值:PreSaleOrderHisDTO中
     *  1.ExtCustOrderId为null则表示此正式单号不存在
     *  2.HisId为null则表示预受理在用表
     *  3.HisId不为null则表示在历史表
     * @author YULIYAO 2016/3/22
     * return
     */
    PreSaleOrderHisDTO queryOrderRelPreOrder(String custOrderNumber);

    /**
     * 将正式单与新的预受理单建立关联
     * @author YULIYAO 2016/3/22
     * return
     */
    boolean connectNewPreOrder(PreSaleOrderHisDTO hisDTO, String preOrderNumber, String originator);

    /**
     * 批量导入要关联的单号，做关联前判断，并返回检验结果
     * @author YULIYAO 2016/3/25
     * return
     */
    PreSaleOrderMaintanceDTO checkBatchConnect(
        List<PreSaleOrderMaintanceDetailDTO> orderMaintanceDTOs);

    /**
     * 批量关联
     * @author YULIYAO 2016/3/28
     * return
     */
    boolean batchConnect(List<PreSaleOrderMaintanceDetailDTO> detailDTOs,
        String originator);

}
