package com.ffcs.crmd.cas.intf.facade.job;

import com.ctg.itrdc.platform.common.utils.type.ArrayUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.intf.api.facade.ICasToCrmFacade;
import com.ffcs.crmd.cas.order.api.dto.OrderOverTimeStatDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import com.ffcs.crmd.tsp.common.constant.TspAppConstant;
import com.ffcs.crmd.tsp.common.exception.TspJobExecutionException;
import com.ffcs.crmd.tsp.common.job.entity.TspJobDataMap;
import com.ffcs.crmd.tsp.task.job.api.IJobBatch;
import com.ffcs.crmd.tsp.task.job.api.IJobExecutionContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YULIYAO on 2016/3/9.
 * 订单超时发送短信
 */
public class OverTimeSentMsgJob implements IJobBatch<OrderOverTimeStatDTO> {

    private IPreSaleOrderFacade preSaleOrderFacade = ApplicationContextUtil.getBean("preSaleOrderFacade");

    private ICasToCrmFacade casToCrmFacade = ApplicationContextUtil.getBean("casToCrmFacade");

    @Override
    public void execute(IJobExecutionContext iJobExecutionContext) throws TspJobExecutionException {
        //先判断当前时间是否允许发送短信
        int curHour = DateUtils.getHour(new Date());
        String strHour = curHour < 10 ? "0" + curHour : "" + curHour;
        if (curHour >= 9 && curHour <= 20 && getConfigHours().contains(strHour)) {
            TspJobDataMap tspJobDataMap = iJobExecutionContext.getTspJobDataMap();
            //取模处理值
            int model = NumberUtils
                .nullToIntegerZero(tspJobDataMap.get(TspAppConstant.TSP_PARAM_MODEL_VALUE));
            //取模总数
            int procCount = NumberUtils.nullToIntegerZero(tspJobDataMap.get(TspAppConstant.TSP_PARAM_JOB_DETAIL_TOTAL));
            //取需要发送短信的数据
            List<OrderOverTimeStatDTO> orderOverTimeStatDTOList = preSaleOrderFacade
                .queryOrderOverTimeStat(procCount, model);
            iJobExecutionContext.addParam(orderOverTimeStatDTOList);
        }
    }

    @Override
    public void businessProcess(OrderOverTimeStatDTO orderOverTimeStatDTO)
        throws TspJobExecutionException {
        if (orderOverTimeStatDTO == null || StringUtils
            .isNullOrEmpty(orderOverTimeStatDTO.getStaffId())) {
            return;
        }
        //获取员工手机号
        String[] staffIds = { orderOverTimeStatDTO.getStaffId()+"" };
        RetVo retVo = casToCrmFacade.qryCustInfo(staffIds, "1");
        if (retVo != null && retVo.getResult()) {
            com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo[] partyContactInfos = (PartyContactInfo[]) retVo.getObject();
            if (ArrayUtils.isNotEmpty(partyContactInfos)) {
                com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo partyContactInfo = partyContactInfos[0];
                String staffPhone = partyContactInfo.getMobilePhone();
                if (!StringUtils.isNullOrEmpty(staffPhone)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (orderOverTimeStatDTO.getWaitDealCount() > 0) {
                        stringBuffer.append("有").append(orderOverTimeStatDTO.getWaitDealCount())
                            .append("张超时待受理，");
                    }
                    if (orderOverTimeStatDTO.getPartDealCount() > 0) {
                        stringBuffer.append("有").append(orderOverTimeStatDTO.getPartDealCount())
                            .append("张超时部分受理，");
                    }
                    if (stringBuffer.length() > 0) {
                        //发送短信
                        String msgContent =
                            "您提交的P订单，" + stringBuffer.substring(0, stringBuffer.length() - 1) + "。";
                        preSaleOrderFacade.sentMsg(staffPhone, msgContent, 1L);

                    }
                }
            }
        }

    }

    /**
     * 获取配置的发送短信的时间.
     *
     * @return
     * @author chenjw
     * 2014-7-22
     */
    private List<String> getConfigHours() {
        List<String> configHours = CrmClassUtils.getAttrValueList(
            CasConstant.JAVACODE_COM_DOMAIN_VALUE.getValue(),
            CasConstant.PAD_OVER_HOURS_SEND_MSG.getValue());
        // 未配置ATTR_VALUE，则取ATTR_SPEC上的默认值
        if (configHours == null || configHours.size() == 0) {
            configHours = new ArrayList<String>();
            AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(
                CasConstant.JAVACODE_COM_DOMAIN_VALUE.getValue(),
                CasConstant.PAD_OVER_HOURS_SEND_MSG.getValue());
            if (attrSpec != null && !StringUtils.isNullOrEmpty(attrSpec.getDefaultValue())) {
                String defaultValue = attrSpec.getDefaultValue();
                for (String eachValue : defaultValue.split("#")) {
                    if (!StringUtils.isNullOrEmpty(eachValue)) {
                        configHours.add(eachValue);
                    }
                }
            } else {
                // 默认早上9点
                configHours.add("9");
            }
        }
        return configHours;
    }

}
