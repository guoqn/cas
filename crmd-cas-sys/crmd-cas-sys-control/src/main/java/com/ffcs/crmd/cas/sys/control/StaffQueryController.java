package com.ffcs.crmd.cas.sys.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.cas.sys.vo.SysQueryVo;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/staffQuery")
@ResponseBody
public class StaffQueryController extends CrmdBaseController {

    @Autowired
    ICasSysFacade casSysFacade;

    /**
     * 查询团队信息.
     *
     * @return
     * @author Luxb
     * 2016年1月4日 Luxb
     */
    @RequestMapping("/qryStaffInfo")
    public RetVo qryStaffInfo(@RequestBody SysQueryVo sysQueryVo) {
        PageInfo pageInfo = null;
        try {
            RetVo retVo = new RetVo(true);
            if (StringUtils.isNullOrEmpty(sysQueryVo.getFromQryBtn())){
                return retVo;
            }
            StaffDTO staffDTO = new StaffDTO();
            if (StringUtils.isNullOrEmpty(sysQueryVo.getOrgId()) || 0L == sysQueryVo.getOrgId()) {
                ExceptionUtils.throwEx("预受理团队为空,请先选择预受理团队!");
            } else {
                staffDTO.setOrgId(sysQueryVo.getOrgId());
            }
            staffDTO.setStaffCode(sysQueryVo.getStaffCode());
            staffDTO.setStaffName(sysQueryVo.getStaffName());
            staffDTO.setPageNumber(sysQueryVo.getPageNumber());
            staffDTO.setPageSize(sysQueryVo.getPageSize());
            pageInfo = casSysFacade.qryStaff(staffDTO);
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

}
