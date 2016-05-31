package com.ffcs.crmd.cas.intf.facade.job;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.intf.api.facade.ICasToPreOrderFacade;
import com.ffcs.crmd.cas.order.api.dto.IntfPreOrderDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import com.ffcs.crmd.tsp.common.constant.TspAppConstant;
import com.ffcs.crmd.tsp.common.exception.TspJobExecutionException;
import com.ffcs.crmd.tsp.common.job.entity.TspJobDataMap;
import com.ffcs.crmd.tsp.task.job.api.IJobBatch;
import com.ffcs.crmd.tsp.task.job.api.IJobExecutionContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 泉州工单池自动发送
 * Created by YULIYAO on 2016/3/11.
 */
public class IntfPreOrderJob implements IJobBatch<IntfPreOrderDTO> {

    private IPreSaleOrderFacade preSaleOrderFacade = ApplicationContextUtil
        .getBean("preSaleOrderFacade");

    private ICasToPreOrderFacade casToPreOrderFacade = ApplicationContextUtil
        .getBean("casToPreOrderFacade");

    @Override
    public void execute(IJobExecutionContext<IntfPreOrderDTO> iJobExecutionContext)
        throws TspJobExecutionException {
        //获取配置参数
        TspJobDataMap dataMap = iJobExecutionContext.getTspJobDataMap();
        int model = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_MODEL_VALUE));
        int procCount = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_JOB_DETAIL_TOTAL));
        //查询待发送的工单
        AttrSpec attrSpec = CrmClassUtils
            .getAttrSpecByCode(CasConstant.INTF_PRE_ORDER.getValue(),
                CasConstant.INTF_PRE_ORDER_PER_SIZE.getValue());
        int perSize = (attrSpec == null || StringUtils.isNullOrEmpty(attrSpec.getDefaultValue())) ?
            500 :
            NumberUtils.nullToIntegerZero(attrSpec.getDefaultValue());
        List<IntfPreOrderDTO> intfPreOrderDTOList = preSaleOrderFacade
            .queryIntfOrderWaitSent(procCount, model, perSize);
        if (CollectionUtils.isNotEmpty(intfPreOrderDTOList)) {
            iJobExecutionContext.addParam(intfPreOrderDTOList);
        }
    }

    @Override
    public void businessProcess(IntfPreOrderDTO intfPreOrderDTO) throws TspJobExecutionException {
        //查询是否有更早的单
        Long relaIntfPreOrderId = preSaleOrderFacade.getRelaIntfPreOrderId(intfPreOrderDTO);
        if (relaIntfPreOrderId != null && relaIntfPreOrderId != 0L) {
            intfPreOrderDTO.setStatusCd("70F");
            //当前时间加10分钟
            Date nextDealTime = DateUtils.addMinutes(new Date(), 10);
            intfPreOrderDTO.setNextDealTime(new Timestamp(nextDealTime.getTime()));
            intfPreOrderDTO.setStatusDate(new Timestamp(new Date().getTime()));
            intfPreOrderDTO.setUpdateDate(new Timestamp(new Date().getTime()));
            intfPreOrderDTO.setRemark("等待" + relaIntfPreOrderId);
            preSaleOrderFacade.saveIntfPreOrder(intfPreOrderDTO);
        } else {
            //配置信息检查
            //获取报文
            String contentText = preSaleOrderFacade
                .getIntfPreOrderText(intfPreOrderDTO.getIntfPreOrderId());
            if (StringUtils.isNullOrEmpty(contentText)) {
                ExceptionUtils.throwEx("报文为空!");
            }
            intfPreOrderDTO.setStatusCd("70B");
            preSaleOrderFacade.saveIntfPreOrder(intfPreOrderDTO);
            //发送
            Long beginTime = System.currentTimeMillis();
            RetVo retVo = casToPreOrderFacade
                .preSaleOrder(contentText);//(RetVO) m.invoke(bean, intfPreOrder.getTextContent());
            System.out.println(
                "IntfPreOrderJob_发送: " + intfPreOrderDTO.getPreOrderNumber() + "耗时: " + (
                    System.currentTimeMillis() - beginTime));

            if (retVo.getResult()) {
                intfPreOrderDTO.setStatusCd("70C");
                Long dealNum = intfPreOrderDTO.getDealNum() + 1L;
                intfPreOrderDTO.setDealNum(dealNum);
                intfPreOrderDTO.setStatusDate(new Timestamp(new Date().getTime()));
                intfPreOrderDTO.setUpdateDate(new Timestamp(new Date().getTime()));
                preSaleOrderFacade.saveIntfPreOrder(intfPreOrderDTO);
            } else {
                intfPreOrderDTO.setStatusCd("70E");
                Long dealNum = intfPreOrderDTO.getDealNum() + 1L;
                intfPreOrderDTO.setDealNum(dealNum);
                intfPreOrderDTO.setStatusDate(new Timestamp(new Date().getTime()));
                intfPreOrderDTO.setUpdateDate(new Timestamp(new Date().getTime()));
                String errMsg = StringUtils.substring(retVo.getMsgTitle(), 0, 2000);
                intfPreOrderDTO.setErrMsg(errMsg);
                preSaleOrderFacade.saveIntfPreOrder(intfPreOrderDTO);
            }
        }
    }
}
