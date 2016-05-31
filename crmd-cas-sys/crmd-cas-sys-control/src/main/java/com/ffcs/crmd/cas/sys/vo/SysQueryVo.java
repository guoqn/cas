package com.ffcs.crmd.cas.sys.vo;

import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/15
 * @功能说明：
 */
public class SysQueryVo extends CrmdBaseConditionVo {
    /**
     * 类code。
     */
    private String classCode;
    /**
     * 属性值code.
     */
    private String attrSpecCode;
    /**
     * 员工编码。
     */
    private String staffCode;
    /**
     * 员工名称。
     */
    private String staffName;
    /**
     * 数根节点。
     */
    private String id;
    /**
     * 团队名称。
     */
    private String orgName;

    /**
     * 登陆团队
     */
    private Long loginOrgId;
    /**
     * 登陆员工
     */
    private Long loginStaffId;
    /**
     * 登陆区域C3
     */
    private Long loginAreaId;
    /**
     * 登陆区域C4
     */
    private Long loginRegionCd;

    private String fromQryBtn;

    private AcrossOrgDTO acrossOrgDTO;

    public AcrossOrgDTO getAcrossOrgDTO() {
        return acrossOrgDTO;
    }

    public void setAcrossOrgDTO(AcrossOrgDTO acrossOrgDTO) {
        this.acrossOrgDTO = acrossOrgDTO;
    }

    public String getFromQryBtn() {
        return fromQryBtn;
    }

    public void setFromQryBtn(String fromQryBtn) {
        this.fromQryBtn = fromQryBtn;
    }

    public Long getLoginOrgId() {
        return loginOrgId;
    }

    public void setLoginOrgId(Long loginOrgId) {
        this.loginOrgId = loginOrgId;
    }

    public Long getLoginStaffId() {
        return loginStaffId;
    }

    public void setLoginStaffId(Long loginStaffId) {
        this.loginStaffId = loginStaffId;
    }

    public Long getLoginAreaId() {
        return loginAreaId;
    }

    public void setLoginAreaId(Long loginAreaId) {
        this.loginAreaId = loginAreaId;
    }

    public Long getLoginRegionCd() {
        return loginRegionCd;
    }

    public void setLoginRegionCd(Long loginRegionCd) {
        this.loginRegionCd = loginRegionCd;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getAttrSpecCode() {
        return attrSpecCode;
    }

    public void setAttrSpecCode(String attrSpecCode) {
        this.attrSpecCode = attrSpecCode;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
