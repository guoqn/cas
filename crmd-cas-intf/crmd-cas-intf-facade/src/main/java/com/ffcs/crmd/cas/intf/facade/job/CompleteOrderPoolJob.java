package com.ffcs.crmd.cas.intf.facade.job;

import com.ctg.itrdc.platform.common.utils.type.ArrayUtils;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.bean.crmbean.querycustorder.CustomerOrder;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.intf.api.dto.QueryCustOrderInDTO;
import com.ffcs.crmd.cas.intf.api.dto.QueryCustOrderOutDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICasToCrmFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.cas.sys.api.dto.StaffPositionDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import com.ffcs.crmd.tsp.common.constant.TspAppConstant;
import com.ffcs.crmd.tsp.common.exception.TspJobExecutionException;
import com.ffcs.crmd.tsp.common.job.entity.TspJobDataMap;
import com.ffcs.crmd.tsp.task.job.api.IJobBatch;
import com.ffcs.crmd.tsp.task.job.api.IJobExecutionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预受理工单池受理完成的订单自动归档.
 * 工单池记录状态如果是处理完成，则判断关联的正式订单，如果关联的正式订单都不在一表，则自动归档.
 * Created by YULIYAO on 2016/3/31.
 */
public class CompleteOrderPoolJob implements IJobBatch<PreSaleOrderDTO>{

    private int perDealSize = 100;

    private IPreSaleOrderFacade preSaleOrderFacade = ApplicationContextUtil
        .getBean("preSaleOrderFacade");
    private ICasToCrmFacade casToCrmFacade = ApplicationContextUtil.getBean("casToCrmFacade");
    private ICasSysFacade casSysFacade = ApplicationContextUtil.getBean("CasSysFacade");

    @Override
    public void execute(IJobExecutionContext<PreSaleOrderDTO> iJobExecutionContext)
        throws TspJobExecutionException {
        List<PreSaleOrderDTO> targetList = new ArrayList<>();
        //获取配置参数
        TspJobDataMap dataMap = iJobExecutionContext.getTspJobDataMap();
        int model = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_MODEL_VALUE));
        int procCount = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_JOB_DETAIL_TOTAL));
        int diffDate = NumberUtils.nullToIntegerZero(dataMap.get("diffDate"));    //取几天之内的预受理单
        //1.查询处理完成的预受理单，然后调接口查询是否已经不在一表
        List<PreSaleOrderDTO> preSaleOrderDTOList = preSaleOrderFacade.queryCompleteOrderAuto(model,procCount,diffDate);
        //为避免数据量太大，分批次调接口，一次100条
        if (CollectionUtils.isNotEmpty(preSaleOrderDTOList)) {
            for(int i=0;i<preSaleOrderDTOList.size()/perDealSize+1;i++) {
                List<PreSaleOrderDTO> batchList = new ArrayList<>();
                if (i < preSaleOrderDTOList.size()/perDealSize) {
                    batchList = preSaleOrderDTOList
                        .subList(i * perDealSize, (i + 1) * perDealSize);
                } else if (preSaleOrderDTOList.size() % perDealSize != 0) {
                    batchList = preSaleOrderDTOList
                        .subList(i * perDealSize, preSaleOrderDTOList.size());
                }
                List<PreSaleOrderDTO> notInUseList = queryIntfNotInUse(batchList);
                if (CollectionUtils.isNotEmpty(notInUseList)) {
                    targetList.addAll(notInUseList);
                }
            }
        }
        //2.并发处理归档
        if (CollectionUtils.isNotEmpty(targetList)) {
            iJobExecutionContext.addParam(targetList);
        }


    }

    @Override
    public void businessProcess(PreSaleOrderDTO preSaleOrderDTO) throws TspJobExecutionException {
        // 没有预收费用才自动归档
        StaffPositionDTO staffPositionDTO = new StaffPositionDTO();
        staffPositionDTO.setStaffId(preSaleOrderDTO.getStaffId());
        staffPositionDTO.setOrgId(preSaleOrderDTO.getOrgId());
        List<StaffPositionDTO> staffPositionDTOs = casSysFacade.queryStaffPosition(staffPositionDTO);
        Long staffPositionId = 0L;
        if (CollectionUtils.isNotEmpty(staffPositionDTOs)) {
            staffPositionId = staffPositionDTOs.get(0).getStaffPositionId();
        }
        Long remainPreFee = preSaleOrderFacade
            .getRemainPreFeeFromHb(preSaleOrderDTO.getPreOrderNumber(),
                preSaleOrderDTO.getOrgId(), staffPositionId);
        if (remainPreFee == null || remainPreFee <= 0) {
            // 标识为已处理
            preSaleOrderDTO.setIfEnd("1");
            preSaleOrderDTO.setRemark("自动归档");
            preSaleOrderDTO.setStatusCd(CasConstant.PRE_SALE_ORDER_STATUS_CD_COMPLETE.getValue());
            preSaleOrderFacade.save(preSaleOrderDTO);
            // 通知移动客户端
            preSaleOrderFacade.sendStateChangeToPad(preSaleOrderDTO);
            preSaleOrderFacade.remove(preSaleOrderDTO);
        }
    }

    /**
     * 调接口查询不在在用表的预受理单
     * 通过预受理单编号查出所有extCustOrderId，批量一性次查询
     * @author YULIYAO 2016/3/31
     * return
     */
    private List<PreSaleOrderDTO> queryIntfNotInUse(List<PreSaleOrderDTO> batchList) {
        List<PreSaleOrderDTO> resultList = new ArrayList<>();
        List<Long> extCustOrderIds = new ArrayList<>();
        Map orderId2preMap = new HashMap<>();    //用于保存extCustOrderId对应的preSaleOrderDTO
        //1.组装要调接口查询的正式单ID，临时保存正式单ID对应的预受理单DTO
        if (CollectionUtils.isNotEmpty(batchList)) {
            for (PreSaleOrderDTO preSaleOrderDTO : batchList) {
                List<Long> tempCustOrderIds = preSaleOrderFacade.queryExtCustOrderIdByNo(preSaleOrderDTO.getPreOrderNumber());
                if (CollectionUtils.isNotEmpty(tempCustOrderIds)) {
                    for (Long custOrderId : tempCustOrderIds) {
                        orderId2preMap.put(custOrderId + "", preSaleOrderDTO);
                    }
                    extCustOrderIds.addAll(tempCustOrderIds);
                }
            }
        }
        //2.调接口查询是否关联在用表正式单，保存在inUserList
        List<PreSaleOrderDTO> inUserList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(extCustOrderIds)) {
            QueryCustOrderInDTO in = new QueryCustOrderInDTO();
            in.setQryType("0");
            in.setExtCustOrderId(list2String(extCustOrderIds));
            RetVo retVo = casToCrmFacade.queryCustomerOrder(in);
            if (retVo.getResult()) {
                QueryCustOrderOutDTO outDTO = (QueryCustOrderOutDTO) retVo.getObject();
                if (ArrayUtils.isNotEmpty(outDTO.getCustomerOrder())) {
                    for (CustomerOrder customerOrder : outDTO.getCustomerOrder()) {
                        if (orderId2preMap.containsKey(customerOrder.getCustomerOrderId())) {
                            inUserList
                                .add((PreSaleOrderDTO)orderId2preMap.get(customerOrder.getCustomerOrderId()));
                        }
                    }
                }
            }
        }
        //3.扣除在在用表的预受理单
        return CollectionUtils.subtract(batchList, inUserList);
    }

    /**
     * 将list以逗号分隔
     * @author YULIYAO 2016/4/1
     * return 
     */
    private static String list2String(List<Long> extCustOrderIds) {
        StringBuffer idBuffer = new StringBuffer();
        if (CollectionUtils.isNotEmpty(extCustOrderIds)) {
            for (Long custOrderId : extCustOrderIds) {
                idBuffer.append(custOrderId).append(",");
            }
        }
        return idBuffer.substring(0, idBuffer.lastIndexOf(","));
    }

}
