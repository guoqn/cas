package com.ffcs.crmd.cas.order.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolAmountDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderPoolFacade;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderPoolVo;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 预受理工单池 controller
 * Created by qn_guo on 2016/1/27.
 */
@Controller
@RequestMapping("/order/preSaleOrderPool")
@ResponseBody
public class PreSaleOrderPoolController extends CrmdBaseController {

    @Autowired
    private IPreSaleOrderFacade preSaleOrderFacade;
    @Autowired
    private ICasSysFacade casSysFacade;
    @Autowired
    private IPreSaleOrderPoolFacade preSaleOrderPoolFacade;

    /**
     * 预受理工单池查询
     *
     * @param preSaleOrderPoolVo
     * @return
     */
    @RequestMapping("/qryPreSaleOrderPools")
    public RetVo qryPreSaleOrderPools(@RequestBody PreSaleOrderPoolVo preSaleOrderPoolVo) {
        try {
            RetVo retVo = new RetVo(true);
            if (StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getFromQryBtn())){
                return retVo;
            }
            PreSaleOrderPoolDTO poolDto = new PreSaleOrderPoolDTO();
            //暂时没有登陆信息
            Long areaId = CasSessionContext.getContext().getAreaId();
            Long orgId = CasSessionContext.getContext().getOrgId();
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getRegionType())) {
                if (CasConstant.REGION_TYPE_C3.getValue()
                        .equals(preSaleOrderPoolVo.getRegionType())) {
                    preSaleOrderPoolVo.setAreaId(preSaleOrderPoolVo.getCommonRegionId());
                    preSaleOrderPoolVo.setRegionCd(null);
                } else if (CasConstant.REGION_TYPE_C4.getValue()
                        .equals(preSaleOrderPoolVo.getRegionType())) {
                    preSaleOrderPoolVo.setRegionCd(preSaleOrderPoolVo.getCommonRegionId());
                    preSaleOrderPoolVo.setAreaId(null);
                }
            }
            //预受理员工
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getCreateStaff())) {
                preSaleOrderPoolVo.setCreateStaff(preSaleOrderPoolVo.getCreateStaff());
            }
            BeanUtils.applyIf(poolDto, preSaleOrderPoolVo);
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getBeginTime())) {
                poolDto.setBeginTime(DateUtils.dateToTimestamp(
                        DateUtils.str2Date(preSaleOrderPoolVo.getBeginTime())));
            }
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getEndTime())) {
                poolDto.setEndTime(DateUtils.dateToTimestamp(
                        DateUtils.str2Date(preSaleOrderPoolVo.getEndTime())));
            }
            //受理类型
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getSceneType())) {
                poolDto.setSceneTypeList(
                        TransUtil.getStrListbyStr(preSaleOrderPoolVo.getSceneType()));
            }
            //工单池状态
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getStatus())) {
                String status = preSaleOrderPoolVo.getStatus();
                if (!preSaleOrderPoolVo.getStatus().endsWith(",")) {
                    status = preSaleOrderPoolVo.getStatus() + ",";
                }
                poolDto.setStatusCdList(TransUtil.getStrListbyStr(status));
            }
            //如果是预受理接收  那么要将登陆的工号设置为接收员工
            if (poolDto.getStatusCdList() != null
                    && poolDto.getStatusCdList().size() > 0) {
                if (CasConstant.PRE_POOL_STATUS_CD_ACCEPTED.getValue()
                        .equals(poolDto.getStatusCdList().get(0))) {
                    if ("rec".equals(preSaleOrderPoolVo.getFrom())) {
                        poolDto.setStaffId(CasSessionContext.getContext().getStaffId());
                    }
                }
            }
            //转换订单编号
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolVo.getPreOrderNumber())) {
                String value = preSaleOrderPoolVo.getPreOrderNumber();
                if (value.startsWith("P") || value.startsWith("O2O")) {
                    poolDto.setPreOrderNbr(value);
                } else {
                    poolDto.setCustSoNumber(preSaleOrderPoolVo.getPreOrderNumber());
                }
            }

            PageInfo pageInfo = preSaleOrderPoolFacade.queryPreSaleOrderPool(poolDto, areaId, orgId,
                    preSaleOrderPoolVo.getAcrossOrgDTO());
            if (pageInfo == null || pageInfo.getList() == null) {
                pageInfo = new PageInfo();
            }
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
    @RequestMapping("/queryAllBoxListForPreSaleOrderPool")
    public RetVo queryAllBoxListForPreSaleOrderPool() {
        try {
            RetVo retVo = new RetVo(true);
            //状态
            Map<String, List<AttrValueDTO>> mapBoxList = new HashMap<String, List<AttrValueDTO>>();
            List<AttrValueDTO> statusCdList = casSysFacade.getAttrValues("PreSaleOrderPool", "statusCd");
            mapBoxList.put("statusCdList", statusCdList);
            //业务类型
            List<AttrValueDTO> serviceTypeList = casSysFacade.getAttrValues(
                    "PreSaleOrder", "serviceType");
            mapBoxList.put("serviceTypeList", serviceTypeList);
            //受理类型
            List<AttrValueDTO> sceneTypeDTOs = casSysFacade.getAttrValues("PreSaleOrder", "sceneType");
            mapBoxList.put("sceneTypeList", sceneTypeDTOs);
            //工单来源
            List<AttrValueDTO> preOrderSrcs = casSysFacade.getAttrValues("PreSaleOrder", "preOrderSrc");
            mapBoxList.put("preOrderSrcs", preOrderSrcs);
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
     * 查询工单池数量
     *
     * @return
     */
    @RequestMapping("/queryPreSaleOrderPoolAmount")
    public RetVo queryPreSaleOrderPoolAmount(@RequestBody AcrossOrgDTO acrossOrgDTO) {
        try {
            RetVo retVo = new RetVo(true);
            PreSaleOrderPoolAmountDTO amountDTO = preSaleOrderPoolFacade
                    .queryPreSaleOrderPoolAmount(acrossOrgDTO);
            retVo.setObject(amountDTO);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 派单
     *
     * @return
     */
    @RequestMapping("/accept")
    public RetVo accept(@RequestBody PreSaleOrderPoolDTO preSaleOrderPoolDTO) {
        try {
            RetVo retVo = new RetVo(true);
            if (!StringUtils.isNullOrEmpty(preSaleOrderPoolDTO.getAcceptStaffId())) {
                preSaleOrderPoolDTO.setStaffId(preSaleOrderPoolDTO.getAcceptStaffId());
            }
            preSaleOrderPoolDTO.setAcceptOrgId(CasSessionContext.getContext().getOrgId());
            int result = preSaleOrderPoolFacade.savePreSaleOrderPoolAccept(preSaleOrderPoolDTO);
            if (result < 1) {
                retVo.setResult(false);
            }
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 设置为部分受理
     *
     * @param preSaleOrderPoolDTO
     * @return
     */
    @RequestMapping("/returnToAccept")
    public RetVo returnToAccept(@RequestBody PreSaleOrderPoolDTO preSaleOrderPoolDTO) {
        try {
            RetVo retVo = new RetVo(true);
            int result = preSaleOrderPoolFacade.returnToAccept(preSaleOrderPoolDTO);
            if (result < 1) {
                retVo.setResult(false);
            }
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 批量派单
     *
     * @return
     */
    @RequestMapping("/batchAccepts")
    public RetVo batchAccepts(@RequestBody PreSaleOrderPoolDTO preSaleOrderPoolDTO) {
        try {
            RetVo retVo = new RetVo(true);
            int result = 0;
            if (preSaleOrderPoolDTO.getSelectData() != null &&
                    preSaleOrderPoolDTO.getSelectData().size() > 0) {
                result = preSaleOrderPoolFacade.savePreSaleOrderPoolAcceptBatch(
                        preSaleOrderPoolDTO.getSelectData(),
                        StringUtils.strnull(preSaleOrderPoolDTO.getAcceptStaffId()));
            }
            if (result < 1) {
                retVo.setResult(false);
                retVo.setMsgTitle("当前选择的记录中，不存在可指派的工单！" +
                        "可指派的工单状态包括未接收、已接收和锁定！并且派单对象不能是当前接收员工！");
            }
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 发送短信
     *
     * @param preSaleOrderPoolDTO
     * @return
     */
    @RequestMapping("/sendMessage")
    public RetVo sendMessage(@RequestBody PreSaleOrderPoolDTO preSaleOrderPoolDTO) {
        try {
            RetVo retVo = preSaleOrderFacade.sentMsg(preSaleOrderPoolDTO.getMobilePhone(),
                    preSaleOrderPoolDTO.getMessageValue(), 1L);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 单独对附件上传大小限制
     *
     * @return
     */
    @RequestMapping("/qryUploadLimit")
    public RetVo qryUploadLimit() {
        RetVo retVo = new RetVo(true);
        String attrValue =
                casSysFacade.getAttrValueByName("PageClass", "uploadConf", "uploadMaxsize4PreCenter");
        retVo.setObject(attrValue);
        return retVo;
    }

    /**
     * 附件上传
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadFile")
    public void uploadFile(MultipartRequest request, HttpServletResponse response,
                           @RequestParam("preOrderId") String preOrderId) throws IOException {
        RetVo retVo = new RetVo(true);
        response.setContentType("text/html;charset=utf-8");
        try {
            if (StringUtils.isNullOrEmpty(preOrderId)) {
                ExceptionUtils.throwEx("您选中的记录的preOrderId为空!");
            }
            MultipartFile[] multipartFiles = new MultipartFile[1];
            //我试了一下虽然每个文件是分别上传的 但此处还要用Map来获取
            Map<String, MultipartFile> fileMap = request.getFileMap();

            for (String key : fileMap.keySet()) {
                MultipartFile mFile = fileMap.get(key);
                String attrValue =
                        casSysFacade.getAttrValueByName("PageClass", "uploadConf", "uploadMaxsize4PreCenter");
                int fileSize = (NumberUtils.toInt(mFile.getSize()))/1024;
                if (fileSize > NumberUtils.toInt(attrValue)) {
                    ExceptionUtils.throwEx("上传的附件必须小于" + (NumberUtils.toInt(attrValue) / (1024)) + "M文件");
                }
                mFile.getName();
                mFile.getOriginalFilename();
                mFile.getSize();
                multipartFiles[0] = mFile;
                //业务操作代码 begin
                //业务操作代码 end
            }
            String name = multipartFiles[0].getOriginalFilename();
            InputStream in = multipartFiles[0].getInputStream();
            byte b[] = null;
            try {
                b = new byte[in.available()];
                in.read(b);
            } catch (IOException e) {
                e.printStackTrace();
                retVo = new RetVo(false);
                response.getWriter().write(JSONUtils.toJsonString(retVo));
                response.getWriter().flush();
            }
            preSaleOrderPoolFacade.uploadFiles(NumberUtils.toLong(preOrderId), name, b);
        } catch (Exception e) {
            e.printStackTrace();
            retVo.setMsgTitle(e.getMessage());
            retVo.setResult(false);
        } finally {
            response.getWriter().write(JSONUtils.toJsonString(retVo));
            response.getWriter().flush();
        }
    }
}


