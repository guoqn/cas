package com.ffcs.crmd.cas.order.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc.InParam;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcAttrDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderProcFacade;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcService;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcForIntfVo;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("preSaleOrderProcFacade")
public class PreSaleOrderProcFacadeImpl extends CrmdBaseFacade implements IPreSaleOrderProcFacade {
    @Autowired
    IPreSaleOrderProcService preSaleOrderProcService;
    @Autowired
    private ICasSysFacade     casSysFacade;

    @Override
    public PageInfo queryPreSaleOrderProcPage(PreSaleOrderProcDTO preSaleOrderProcDTO,int pageNumber,int pageSize) {
        PreSaleOrderProc preSaleOrderProc = new PreSaleOrderProc();
        CrmBeanUtils.applyIf(preSaleOrderProc, preSaleOrderProcDTO);
        PageInfo pageInfo = preSaleOrderProcService.queryPreSaleOrderProcPageWithAttr(preSaleOrderProc,pageNumber,pageSize);
        if (pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size() > 0) {
            try {
                List<PreSaleOrderProcDTO> preSaleOrderProcDTOs = BeanUtils
                        .copyList(pageInfo.getList(), PreSaleOrderProcDTO.class);
                for (PreSaleOrderProcDTO dto : preSaleOrderProcDTOs) {
                    //受理员工
                    if (!StringUtils.isNullOrEmpty(dto.getStaffId())) {
                        dto.setStaffName(casSysFacade.getStaffNameById(dto.getStaffId()));
                    }
                    //受理状态
                    if (!StringUtils.isNullOrEmpty(dto.getStatusCd())) {
                        dto.setStatusCdName(CrmClassUtils
                                .getAttrValueNameByValue("PreSaleOrder",
                                        CasConstant.STATUS_CD.getValue(), dto.getStatusCd()));
                    }
                    //受理编号
                    if (!StringUtils.isNullOrEmpty(preSaleOrderProcDTO.getPreSaleOrderNum())) {
						dto.setPreSaleOrderNum(preSaleOrderProcDTO.getPreSaleOrderNum());
                    }
                    //动作
                    String eventName = getEventName(
                        dto.getCustomerInteractionEventId());
                    dto.setCustomerInteractionEventName(eventName);

                }
                pageInfo.setList(preSaleOrderProcDTOs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pageInfo;
    }

    /**
     * 获取预受理处理过程
     * @author YULIYAO 2016/4/7
     * return
     */
    @Override
    public PreSaleOrderProcDTO getById(Long preSaleOrderProcId) {
        PreSaleOrderProc preSaleOrderProc = preSaleOrderProcService
            .get(preSaleOrderProcId);
        PreSaleOrderProcDTO preSaleOrderProcDTO = new PreSaleOrderProcDTO();
        if (preSaleOrderProc != null) {
            CrmBeanUtils.applyIf(preSaleOrderProcDTO, preSaleOrderProc);
        }
        return preSaleOrderProcDTO;
    }

    /**
     * 获取最后一条退单属性
     * @author YULIYAO 2016/4/7
     * return
     */
    @Override
    public PreSaleOrderProcAttrDTO getLastBackProcAttr(Long preOrderId) {
        PreSaleOrderProcAttr preSaleOrderProcAttr = preSaleOrderProcService
            .getLastBackProcAttr(preOrderId);
        PreSaleOrderProcAttrDTO preSaleOrderProcAttrDTO = new PreSaleOrderProcAttrDTO();
        CrmBeanUtils.applyIf(preSaleOrderProcAttrDTO, preSaleOrderProcAttr);
        return preSaleOrderProcAttrDTO;
    }

    private String getEventName(Long customerInteractionEventId) {
        String eventName = null;
        if (StringUtils
            .isNullOrEmpty(customerInteractionEventId)||customerInteractionEventId == 0) {
            return eventName;
        }
        eventName = CrmClassUtils
            .getAttrValueNameByValue(CasConstant.PRE_SALE_ORDER_PROC.getValue(),
                CasConstant.INTERACTION_EVENT_ID.getValue(), ""+customerInteractionEventId);
        return eventName;

    }

	@Override
	public RetVo queryPreSaleOrderProcForIntf(InParam inParam) {
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("beginTime", inParam.getBeginTime());
		map.put("endTime", inParam.getEndTime());
		if(!StringUtils.isNullOrEmpty(inParam.getOrgId())){
			map.put("orgId", NumberUtils.toLong(inParam.getOrgId()));
		}
		if(!StringUtils.isNullOrEmpty(inParam.getAreaId())){
			map.put("areaId", NumberUtils.toLong(inParam.getAreaId()));
		}
		if(!StringUtils.isNullOrEmpty(inParam.getStaffId())){
			map.put("staffId", NumberUtils.toLong(inParam.getStaffId()));
		}
		List<PreSaleOrderProcForIntfVo> PreSaleOrderProcForIntfVos= preSaleOrderProcService.qryPreSaleOrderProcForIntf(map);
		RetVo retVo = new RetVo();
		if(PreSaleOrderProcForIntfVos != null &&  PreSaleOrderProcForIntfVos.size()>0){
			List<com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc.PreSaleOrderProc> PreSaleOrderProcs = CrmBeanUtils
					.copyList(PreSaleOrderProcForIntfVos,
							com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc.PreSaleOrderProc.class);
			retVo.setResult(true);
			retVo.setObject(PreSaleOrderProcs);
		}else{
			retVo.setResult(false);
		}
		return retVo;
	}

}
