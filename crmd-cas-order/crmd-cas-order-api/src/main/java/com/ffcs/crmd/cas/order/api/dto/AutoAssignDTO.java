package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

/**
 * Created by qn_guo on 2016/3/12.
 */
public class AutoAssignDTO extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;


    private Long staffId;

    private String staffName;
    /**
     * 分配前工单量
     */
    private int amountBefore = 0;
    /**
     * 分配后工单量
     */
    private int amountAfter = 0;
    /**
     * 团队名称.
     */
    private String orgName;
    /**
     * 未接收工单量.
     */
    private int unAcceptOrderAmount;

    /**
     * 团队id
     */
    private Long orgId;

    /**
     * 区域标识C4
     */
    private Long regionCd;
    /**
     * 区域标识C3
     */
    private Long areaId;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getUnAcceptOrderAmount() {
        return unAcceptOrderAmount;
    }

    public void setUnAcceptOrderAmount(int unAcceptOrderAmount) {
        this.unAcceptOrderAmount = unAcceptOrderAmount;
    }
}
