package com.ffcs.crmd.cas.intf.facade.job;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.facade.ICasToCrmFacade;
import com.ffcs.crmd.cas.order.api.dto.AutoGenOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;
import com.ffcs.crmd.cas.order.api.facade.IAutoGenOrderFacade;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderPoolFacade;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import com.ffcs.crmd.tsp.common.constant.TspAppConstant;
import com.ffcs.crmd.tsp.common.exception.TspJobExecutionException;
import com.ffcs.crmd.tsp.common.job.entity.TspJobDataMap;
import com.ffcs.crmd.tsp.task.job.api.IJobBatch;
import com.ffcs.crmd.tsp.task.job.api.IJobExecutionContext;

/**
 * Created by YULIYAO on 2016/3/16.
 */
public class ActiveAutoOrderJob implements IJobBatch<AutoGenOrderDTO>{

    private IAutoGenOrderFacade autoGenOrderFacade = ApplicationContextUtil
        .getBean("autoGenOrderFacade");

    private IPreSaleOrderFacade preSaleOrderFacade = ApplicationContextUtil
        .getBean("preSaleOrderFacade");

    private IPreSaleOrderPoolFacade preSaleOrderPoolFacade = ApplicationContextUtil
        .getBean("preSaleOrderPoolFacade");

    private ICasToCrmFacade casToCrmFacade = ApplicationContextUtil.getBean("casToCrmFacade");

    @Override
    public void execute(IJobExecutionContext<AutoGenOrderDTO> iJobExecutionContext)
        throws TspJobExecutionException {
        //获取配置参数
        TspJobDataMap dataMap = iJobExecutionContext.getTspJobDataMap();
        int model = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_MODEL_VALUE));
        int procCount = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_JOB_DETAIL_TOTAL));
        //查询普坤受理成功的自动受理单
        AutoGenOrderDTO autoGenOrderDTO = new AutoGenOrderDTO();
        autoGenOrderDTO.setStatusCd(CasConstant.AUTO_GEN_ORDER_STATUS_GEN_SUC.getValue());
        autoGenOrderDTO.setPageNumber(1);
        autoGenOrderDTO.setPageSize(getPerSize());
        autoGenOrderDTO.setModelCount(procCount);
        autoGenOrderDTO.setModel(model);
        PageInfo pageInfo = autoGenOrderFacade.queryAutoGenOrderPage(autoGenOrderDTO);
        if (pageInfo != null && CollectionUtils.isNotEmpty(pageInfo.getList())) {
            iJobExecutionContext.addParam(pageInfo.getList());
        }
    }

    @Override
    public void businessProcess(AutoGenOrderDTO autoGenOrderDTO) throws TspJobExecutionException {
        //获取第一个PRE_SALE_ORDER记录
        PreSaleOrderDTO preSaleOrderDTO = preSaleOrderFacade
            .getFirstPreSaleOrder(autoGenOrderDTO.getPreSaleOrder());
        if (preSaleOrderDTO != null) {
            //调接口，判断关联订单是否为预受理状态，是则启动流程，并保存营业日报信息
            RetVo retVo = casToCrmFacade
                .noticeToDealOrder(preSaleOrderDTO.getExtCustOrderId(), preSaleOrderDTO.getIfEnd());
            //关联订单处于预受理状态  1-预受理状态
            if ("1".equals(retVo.getObject())) {
                if (!retVo.getResult() && "11".equals(retVo.getRetCode())) {//启动流程失败
                    autoGenOrderDTO
                        .setStatusCd(CasConstant.AUTO_GEN_ORDER_STATUS_ACTIVE_FAIL.getValue());
                    autoGenOrderDTO.setResult(retVo.getResult()
                        + "------启动预受理订单流程异常：" + retVo.getMsgTitle());
                    autoGenOrderFacade.save(autoGenOrderDTO);
                } else {
                    // 流程启动成功
                    autoGenOrderDTO
                        .setStatusCd(CasConstant.AUTO_GEN_ORDER_STATUS_COMPLETE.getValue());
                    autoGenOrderFacade.save(autoGenOrderDTO);
                    // 移到历史表
                    autoGenOrderFacade.remove(autoGenOrderDTO);
                    // 如果有最后一张单标识
                    if (!StringUtils.isNullOrEmpty(preSaleOrderDTO.getIfEnd())) {
                        // P单状态标识为在途
                        preSaleOrderDTO
                            .setStatusCd(CasConstant.PRE_SALE_ORDER_STATUS_CD_ON_WAY.getValue());
                        // 通知移动客户端在途
                        sendStateChangeToPad(preSaleOrderDTO,
                            CasConstant.PRE_SALE_ORDER_STATUS_CD_ON_WAY.getValue());
                        // 保存
                        preSaleOrderFacade.save(preSaleOrderDTO);
                        // 工单池记录保存为已处理
                        PreSaleOrderPoolDTO orderPoolDTO = preSaleOrderPoolFacade
                            .getByPreOrderId(preSaleOrderDTO.getPreOrderId());
                        if (orderPoolDTO != null) {
                            orderPoolDTO
                                .setStatusCd(CasConstant.PRE_POOL_STATUS_CD_DEALED.getValue());
                            preSaleOrderPoolFacade.save(orderPoolDTO);
                        }
                    } else {
                        // 不是最后一张单，设置P订单状态为部分受理，同时通知移动客户端部分转正
                        preSaleOrderDTO
                            .setStatusCd(CasConstant.PRE_SALE_ORDER_STATUS_CD_PART_DEAL.getValue());
                        sendStateChangeToPad(preSaleOrderDTO,
                            CasConstant.PRE_SALE_ORDER_STATUS_CD_PART_DEAL.getValue());
                        preSaleOrderFacade.save(preSaleOrderDTO);
                    }
                }
            }
        } else {
            autoGenOrderDTO.setStatusCd(IntfConstant.AUTO_GEN_ORDER_STATUS_COMPLETE.getValue());
            autoGenOrderFacade.save(autoGenOrderDTO);
            autoGenOrderFacade.remove(autoGenOrderDTO);
        }
    }

    private void sendStateChangeToPad(PreSaleOrderDTO preSaleOrderDTO,String sendStatusCd) {
        if (!StringUtils.isNullOrEmpty(sendStatusCd)) {
            // O2O系统只通知竣工状态
            if (CasConstant.CHANNEL_CODE_O2O.getValue().equals(preSaleOrderDTO.getOrderFrom())) {
                if (CasConstant.MOBI_PRE_ORDER_STATUS_CD_COMPLETED.getValue().equals(sendStatusCd)) {
                    preSaleOrderFacade.stateChange(preSaleOrderDTO, sendStatusCd);
                }
            } else {
                preSaleOrderFacade.stateChange(preSaleOrderDTO, sendStatusCd);
            }
        }
    }

    private int getPerSize() {
        int perSize = NumberUtils.toInt(IntfConstant.DEFAULT_CIRCLE_PER_SIZE.getValue());
        AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(IntfConstant.UI_META_CLASSSNAME.getValue(),
            IntfConstant.ATTR_SPEC_ORDER_DEAL_PER_SIZE.getValue());
        if (attrSpec != null && !StringUtils.isNullOrEmpty(attrSpec.getDefaultValue())) {
            perSize = NumberUtils.toInt(attrSpec.getDefaultValue());
        }
        return perSize;
    }

}
