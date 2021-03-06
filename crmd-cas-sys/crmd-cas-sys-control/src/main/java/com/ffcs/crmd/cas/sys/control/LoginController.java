package com.ffcs.crmd.cas.sys.control;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.base.api.LoginDTO;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.JspUtil;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderPoolFacade;
import com.ffcs.crmd.cas.sys.api.dto.CommonRegionDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面继承登录
 *
 * @author LAIYONGMIN-PC
 */
@Controller
@RequestMapping("/sys/loginCtrl")
@ResponseBody
public class LoginController extends CrmdBaseController {

    private static final ILogger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ICasSysFacade casSysFacade;
    @Autowired
    IPreSaleOrderPoolFacade preSaleOrderPoolFacade;

    /**
     * 简易登录，CRM嵌套页面使用
     *
     * @param loginInfo
     */
    @RequestMapping("/login")
    public RetVo login(@RequestParam("loginInfo") String loginInfo) {
        RetVo ret = new RetVo(true);
        LoginDTO loginDTO = JSON.parseObject(loginInfo,
                LoginDTO.class);
        try {
            if (loginDTO != null) {
                if (!StringUtils.isNullOrEmpty(loginDTO.getOrgId())) {
                    String orgName = casSysFacade.getNameById(
                            NumberUtils.toLong(loginDTO.getOrgId()));
                    CasSessionContext.getContext().setOrgName(loginDTO.getOrgName());
                    CasSessionContext.getContext().setOrgId(NumberUtils.toLong(loginDTO.getOrgId()));
                    loginDTO.setOrgName(orgName);
                }

                if (!StringUtils.isNullOrEmpty(loginDTO.getStaffId())) {
                    String staffName = casSysFacade.getStaffNameById(
                            NumberUtils.toLong(loginDTO.getStaffId()));
                    CasSessionContext.getContext().setStaffName(staffName);
                    CasSessionContext.getContext().setStaffId(NumberUtils.toLong(loginDTO.getStaffId()));
                    loginDTO.setStaffName(staffName);
                }
                if (!StringUtils.isNullOrEmpty(loginDTO.getRegionCd())) {
                    CommonRegionDTO commonRegionDTO = casSysFacade.getCommonRegionById(
                            NumberUtils.toLong(loginDTO.getRegionCd()));
                    if (commonRegionDTO != null) {
                        CasSessionContext.getContext().setRegionName(commonRegionDTO.getRegionName());
                        CasSessionContext.getContext().setRegionId(NumberUtils.toLong(loginDTO.getRegionCd()));
                        loginDTO.setRegionName(commonRegionDTO.getRegionName());
                        loginDTO.setRegionType(commonRegionDTO.getRegionType());
                    }
                }
                //设置区域
                if(!StringUtils.isNullOrEmpty(loginDTO.getAreaId())) {
                    CasSessionContext.getContext().setAreaId(NumberUtils.toLong(loginDTO.getAreaId()));
                }

                if(!StringUtils.isNullOrEmpty(loginDTO.getStaffPositionId())) {
                    CasSessionContext.getContext().setStaffPositionId(NumberUtils.toLong(loginDTO.getStaffPositionId()));
                }

                if(!StringUtils.isNullOrEmpty(loginDTO.getChannelCode())) {
                    CasSessionContext.getContext().setChannelCode(loginDTO.getChannelCode());
                }

                if (!StringUtils.isNullOrEmpty(loginDTO.getAreaId())
                        && !StringUtils.isNullOrEmpty(loginDTO.getOrgId())) {
                    List<Long> orgAssignOrg = new ArrayList<>();
                    List<Long> c4AssignOrg = new ArrayList<>();
                    List<Long> c3AssignOrg = new ArrayList<>();
                    AcrossOrgDTO acrossOrgDTO = preSaleOrderPoolFacade.getAcrossOrgInit(
                            NumberUtils.toLong(loginDTO.getAreaId()), NumberUtils.toLong(loginDTO.getOrgId()));
                    if (acrossOrgDTO != null) {
                        boolean assignOrgFlag = false;
                        if (((acrossOrgDTO.getC4AssignOrg() != null && acrossOrgDTO.getC4AssignOrg().size() > 0)
                                || (acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0))
                                && (acrossOrgDTO.getOrgAssignOrg() == null || acrossOrgDTO.getOrgAssignOrg().size() == 0)) {
                            /**
                             * 1）区域控件展现的文字为“所有”，代码值为空
                             * 2）团队控件展现的文字为“所有”，代码值为空
                             * 3）预受理员工控件中的团队设置为空
                             */
                            loginDTO.setC3c4Assign("1");
                            assignOrgFlag = true;
                        } else if (acrossOrgDTO.getOrgAssignOrg() != null && acrossOrgDTO.getOrgAssignOrg().size() > 0
                                && (acrossOrgDTO.getC4AssignOrg() == null || acrossOrgDTO.getC4AssignOrg().size() == 0)
                                && (acrossOrgDTO.getC3AssignOrg() == null || acrossOrgDTO.getC3AssignOrg().size() == 0)) {
                            /**
                             * 1）区域控件展现的文字为“所有”，代码值为空，并且置灰
                             * 2）团队控件展现的文字为“所有”，代码值为空
                             * 3）预受理员工控件中的团队设置为空
                             */
                            loginDTO.setOrgAssign("1");
                            assignOrgFlag = true;
                        } else if (acrossOrgDTO.getOrgAssignOrg() != null && acrossOrgDTO.getOrgAssignOrg().size() > 0
                                && ((acrossOrgDTO.getC4AssignOrg() != null && acrossOrgDTO.getC4AssignOrg().size() > 0)
                                || (acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0))) {
                            /**
                             * 1）区域控件展现的文字为“所有”，代码值为空
                             * 2）团队控件展现的文字为“所有”，代码值为空
                             * 3）预受理员工控件中的团队设置为空
                             */
                            loginDTO.setC3c4orgAssign("1");
                            assignOrgFlag = true;
                        } else if ((acrossOrgDTO.getOrgAssignOrg() == null || acrossOrgDTO.getOrgAssignOrg().size() == 0)
                                && (acrossOrgDTO.getC4AssignOrg() == null || acrossOrgDTO.getC4AssignOrg().size() == 0)
                                && (acrossOrgDTO.getC3AssignOrg() == null || acrossOrgDTO.getC3AssignOrg().size() == 0)) {
                            if ((acrossOrgDTO.getNotInOrgAssignOrg() == null
                                    || !acrossOrgDTO.getNotInOrgAssignOrg().contains(NumberUtils
                                    .toLong(loginDTO.getOrgId())))
                                    && (acrossOrgDTO.getNotInC4AssignOrg() == null
                                    || !acrossOrgDTO.getNotInC4AssignOrg().contains(NumberUtils.toLong(loginDTO.getRegionCd())))
                                    && (acrossOrgDTO.getNotInC3AssignOrg() == null
                                    || !acrossOrgDTO.getNotInC3AssignOrg().contains(NumberUtils.toLong(loginDTO.getAreaId())))) {
                                /**
                                 * 1）区域控件展现的文字为“所有”，代码值为空
                                 * 2）团队控件设置为当前登陆的团队
                                 * 3）预受理员工控件中的团队设置为当前登陆的团队，此时这个控件只能查询当前团队下的员工
                                 */
                                loginDTO.setNotC3c4orgAssign("1");
                                assignOrgFlag = true;
                            }
                        }
                        /**
                         * 如果以上条件都不满足，
                         * 1）区域控件展现的文字为“未配置”，代码值为空，并且置灰
                         * 2）团队控件展现的文字为“未配置”，代码值为空，并且置灰
                         * 3）员工控制置灰
                         */
                        if (!assignOrgFlag) {
                            loginDTO.setNotConfigured("1");
                        }
                        loginDTO.setAcrossOrgDTO(acrossOrgDTO);
                    }
                }
                CasSessionContext.getContext().setLoginDetail(loginDTO);
                /*SessionContext.getSession()
                        .setAttribute(CasConstant.CAS_LOGIN_INFO.getValue(), loginDTO);*/
                System.out.println(JSON.toJSONString(loginDTO.getAcrossOrgDTO()));
                ret.setRetCode("登录");
                ret.setDetailMsg("hostIp:" + JspUtil.getHostIp());
                ret.setObject(loginDTO);
            } else {
                LOGGER.info("没有获取到登录信息，设置缓存失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.setResult(false);
            ret.setMsgTitle(e.getMessage());
        }
        return ret;
    }

}
