package com.ffcs.crmd.cas.intf.facade.job;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.order.api.dto.AutoGenOrderDTO;
import com.ffcs.crmd.cas.order.api.facade.IAutoGenOrderFacade;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.tsp.common.constant.TspAppConstant;
import com.ffcs.crmd.tsp.common.exception.TspJobExecutionException;
import com.ffcs.crmd.tsp.common.job.entity.TspJobDataMap;
import com.ffcs.crmd.tsp.task.job.api.IJobBatch;
import com.ffcs.crmd.tsp.task.job.api.IJobExecutionContext;

import java.util.List;

/**
 * Created by YULIYAO on 2016/3/14.
 * 普坤自动化受理--CRM送普坤轮询实现类.
 */
public class AutoGenOrderJob implements IJobBatch<AutoGenOrderDTO> {

    private IAutoGenOrderFacade autoGenOrderFacade = ApplicationContextUtil
        .getBean("autoGenOrderFacade");

    @Override
    public void execute(IJobExecutionContext<AutoGenOrderDTO> iJobExecutionContext)
        throws TspJobExecutionException {
        //获取配置参数
        TspJobDataMap dataMap = iJobExecutionContext.getTspJobDataMap();
        int model = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_MODEL_VALUE));
        int procCount = NumberUtils.nullToIntegerZero(dataMap.get(TspAppConstant.TSP_PARAM_JOB_DETAIL_TOTAL));
        //查询创建状态的自动受理单
        List<AutoGenOrderDTO> autoGenOrderDTOList = autoGenOrderFacade
            .queryAutoGenOrderSentPk(procCount,model,getPerSize());
        if (CollectionUtils.isNotEmpty(autoGenOrderDTOList)) {
            iJobExecutionContext.addParam(autoGenOrderDTOList);
        }
    }

    @Override
    public void businessProcess(AutoGenOrderDTO autoGenOrderDTO) throws TspJobExecutionException {
        autoGenOrderFacade.sendToPk(autoGenOrderDTO);
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
