package com.ffcs.crmd.cas.order.control;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.base.utils.export.ExcelUtil;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.dto.PreSaleAcctItemDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderProcFacade;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by qn_guo on 2016/1/18.
 * 预受理缴费
 */
@Controller
@RequestMapping("/order/preSaleOrder")
@ResponseBody
public class PreSaleOrderController extends CrmdBaseController {
    @Autowired
    private IPreSaleOrderFacade preSaleOrderFacade;
    @Autowired
    private ICasSysFacade casSysFacade;
    @Autowired
    private IPreSaleOrderProcFacade preSaleOrderProcFacade;

    /**
     * 预受理查询
     *
     * @param preSaleOrderVo
     * @return
     */
    @RequestMapping("/qryPreSaleOrders")
    public RetVo qryPreSaleOrders(@RequestBody PreSaleOrderVo preSaleOrderVo) {
        try {
            RetVo retVo = new RetVo(true);
            if (StringUtils.isNullOrEmpty(preSaleOrderVo.getFromQryBtn())){
                return retVo;
            }
/*            if (StringUtils.isNullOrEmpty(preSaleOrderVo.getOrgId())){
                preSaleOrderVo.setOrgId(CasSessionContext.getContext().getOrgId());
            }*/
            //暂时没有登陆信息
            if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getCommonRegionStr())) {
                preSaleOrderVo.setCommmonRegionIds(TransUtil.getListbyStr(preSaleOrderVo.getCommonRegionStr()));
            }
            //只查询第一张单的数据
            preSaleOrderVo.setSeq(1L);
            preSaleOrderVo.setQueryPayFlag(true);
            PageInfo pageInfo = preSaleOrderFacade.queryPreSaleOrder(preSaleOrderVo);
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 初始化下拉框
     *
     * @return
     */
    @RequestMapping("/queryAllBoxListForPreSaleOrder")
    public RetVo queryAllBoxListForPreSaleOrder() {
        try {
            RetVo retVo = new RetVo(true);
            //状态
            Map<String, List<AttrValueDTO>> mapBoxList = new HashMap<String, List<AttrValueDTO>>();
            List<AttrValueDTO> statusCdList = casSysFacade.getAttrValues(
                    "PreSaleOrder", "statusCd");
            mapBoxList.put("statusCdList", statusCdList);
            //撤销原因
            List<AttrValueDTO> backReasonList = casSysFacade.getAttrValues(
                    "PreSaleOrderProc", "backReasonList");
            mapBoxList.put("backReasonList", backReasonList);
            retVo.setObject(mapBoxList);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 受理过程
     *
     * @param preSaleOrderProcVo
     * @return
     */
    @RequestMapping("/qryPreSaleOrderProc")
    public RetVo qryPreSaleOrderProc(@RequestBody PreSaleOrderProcVo preSaleOrderProcVo) {
        try {
            RetVo retVo = new RetVo(true);
            PreSaleOrderProcDTO dto = new PreSaleOrderProcDTO();
            CrmBeanUtils.applyIf(dto, preSaleOrderProcVo);
            PageInfo pageInfo = preSaleOrderProcFacade
                    .queryPreSaleOrderProcPage(dto, preSaleOrderProcVo.getPageNumber(),
                            preSaleOrderProcVo.getPageSize());
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 补收款
     *
     * @param preSaleAcctItemDTO
     * @return
     */
    @RequestMapping("/reFee")
    public RetVo reFee(@RequestBody PreSaleAcctItemDTO preSaleAcctItemDTO) {
        try {
            RetVo retVo = new RetVo(true);
            List<AttrValueDTO> valueDTOList = new ArrayList<>();
            //社会终端款
            if (!StringUtils.isNullOrEmpty(preSaleAcctItemDTO.getPayResource())) {
                AttrValueDTO dto = new AttrValueDTO();
                dto.setAttrId(950001640L);
                dto.setAttrValue(preSaleAcctItemDTO.getPayResource());
                valueDTOList.add(dto);
            }
            //预存费用
            if (!StringUtils.isNullOrEmpty(preSaleAcctItemDTO.getPayStore())) {
                AttrValueDTO dto = new AttrValueDTO();
                dto.setAttrId(950001638L);
                dto.setAttrValue(preSaleAcctItemDTO.getPayStore());
                valueDTOList.add(dto);
            }
            //普通现金
            if (!StringUtils.isNullOrEmpty(preSaleAcctItemDTO.getPaySample())) {
                AttrValueDTO dto = new AttrValueDTO();
                dto.setAttrId(950001639L);
                dto.setAttrValue(preSaleAcctItemDTO.getPaySample());
                valueDTOList.add(dto);
            }
            boolean restult = preSaleOrderFacade.reFee(preSaleAcctItemDTO.getPreOrderId(), valueDTOList);
            retVo.setResult(restult);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 归档处理
     *
     * @param preSaleOrderDTO
     * @return
     */
    @RequestMapping("/archIve")
    public RetVo archIve(@RequestBody PreSaleOrderDTO preSaleOrderDTO) {
        try {
            RetVo retVo = new RetVo(true);
            retVo = preSaleOrderFacade.completePreOrder(preSaleOrderDTO);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 撤销
     *
     * @param preSaleOrderVo
     * @return
     */
    @RequestMapping("/cancelPreOrder")
    public RetVo cancelPreOrder(@RequestBody PreSaleOrderVo preSaleOrderVo) {
        try {
            RetVo retVo = new RetVo(true);
            AttrValueDTO attrValueDTO = new AttrValueDTO();
            attrValueDTO.setAttrId(950022696L);
            if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getCancelReasonId())) {
                attrValueDTO.setAttrValueId(NumberUtils.toLong(preSaleOrderVo.getCancelReasonId()));
                attrValueDTO.setAttrValue(preSaleOrderVo.getCancelReasonValue());
            }
            preSaleOrderVo.setAttrValueDTO(attrValueDTO);
            String result = preSaleOrderFacade.cancel(preSaleOrderVo);
            retVo.setObject(result);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 费用收取地址
     *
     * @return
     */
    @RequestMapping("/qryHbPreSaleUrl")
    public RetVo qryHbPreSaleUrl(@RequestBody PreSaleOrderDTO preSaleOrderDTO) {
        try {
            RetVo retVo = new RetVo(true);
            Long staffPositionId = CasSessionContext.getContext().getStaffPositionId();
            Long orgId = CasSessionContext.getContext().getOrgId();
            Long areaId = CasSessionContext.getContext().getAreaId();
            retVo = preSaleOrderFacade.pay(preSaleOrderDTO, staffPositionId, orgId, areaId);//传staffpositionId  orgId areaId
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 导出excel操作
     *
     * @param exportData
     * @return
     */
    @RequestMapping(value = "/downloadPOrderList", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadPOrderList(@RequestParam("exportData") String exportData, HttpServletResponse response) {
        PreSaleOrderVo preSaleOrderVo = JSON.parseObject(exportData,
                PreSaleOrderVo.class);
        if (StringUtils.isNullOrEmpty(preSaleOrderVo.getOrgId())){
            preSaleOrderVo.setOrgId(CasSessionContext.getContext().getOrgId());
        }

        if (!StringUtils.isNullOrEmpty(preSaleOrderVo.getCommonRegionStr())) {
            preSaleOrderVo.setCommmonRegionIds(TransUtil.getListbyStr(preSaleOrderVo.getCommonRegionStr()));
        }
        if ("1".equals(preSaleOrderVo.getIsExport())) {
            preSaleOrderVo.setPageSize(2000);
        }
        PageInfo pageInfo = preSaleOrderFacade.queryPreSaleOrder(preSaleOrderVo);
        if (pageInfo != null && pageInfo.getList() != null
                && pageInfo.getList().size() > 0) {
            List<String> headers = new ArrayList<String>();
            headers.add("受理单号");
            headers.add("客户名称");
            headers.add("业务类型");
            headers.add("预受理员工");
            headers.add("预受理团队");
            headers.add("预受理时间");
            headers.add("实际受理时间");
            headers.add("状态");
            List<String> fields = new ArrayList<String>();

            fields.add("preOrderNumber");
            fields.add("custName");
            fields.add("sceneTypeName");
            fields.add("staffName");
            fields.add("orgName");
            fields.add("createDate");
            fields.add("realAcceptTime");
            fields.add("statusCdName");
            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            return ExcelUtil.download("清单导出_" + DateUtils.getCurDate(),
                    CasConstant.EXCEL07_EXTENSION.getValue(), "库存清单", headers, fields,
                    pageInfo.getList(), "");
        }
        return null;
    }

    /**
     * 机器人受理
     * @param preSaleOrderDTO
     * @return
     */
    @RequestMapping("/robotAccept")
    public RetVo robotAccept(@RequestBody PreSaleOrderDTO preSaleOrderDTO) {
        try {
            RetVo retVo = new RetVo(true);
            preSaleOrderFacade.autoGen(preSaleOrderDTO);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 是否展示机器人受理按钮
     * @param preSaleOrderDTO
     * @return
     */
    @RequestMapping("/isShowRobotBtn")
    public RetVo isShowRobotBtn(@RequestBody PreSaleOrderDTO preSaleOrderDTO) {
        try {
            RetVo retVo = new RetVo(true);
            boolean result = preSaleOrderFacade.isShowRobotBtn(preSaleOrderDTO);
            retVo.setResult(result);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }
    
    /**
     * 预受理缴费后续处理。
     * @param preSaleOrderDTO
     * @return
     */
    @RequestMapping("/updatePreSaleOrder")
    public RetVo updatePreSaleOrder(@RequestBody PreSaleOrderDTO preSaleOrderDTO) {
        try {
        	RetVo retVo = new RetVo(true);
            this.preSaleOrderFacade.preSaleOrderPayDeal(preSaleOrderDTO);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }
}
