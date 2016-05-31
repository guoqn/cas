package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

/**
 * Created by YULIYAO on 2016/3/25.
 */
public class PreSaleOrderMaintanceDetailDTO  extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;
    /**
     * 正式订单号
     */
    private String custSoNumber;

    /**
     * 旧关联P单号
     */
    private String oldPreOrderNumber;

    /**
     * 要关联的P单号
     */
    private String targetPreOrderNumber;

    /**
     * 是否可以关联
     */
    private boolean isCanRelate;

    /**
     * 不能关联原因
     */
    private String canntRelReason;

    /**
     * 状态
     */
    private String statusCd;

    /**
     * 状态名称
     */
    private String statusCdName;

    /**
     * 用于保存正式单关联的预受理订单信息
     */
    private PreSaleOrderHisDTO preSaleOrderHisDTO;

    public String getCustSoNumber() {
        return custSoNumber;
    }

    public void setCustSoNumber(String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    public String getOldPreOrderNumber() {
        return oldPreOrderNumber;
    }

    public void setOldPreOrderNumber(String oldPreOrderNumber) {
        this.oldPreOrderNumber = oldPreOrderNumber;
    }

    public String getTargetPreOrderNumber() {
        return targetPreOrderNumber;
    }

    public void setTargetPreOrderNumber(String targetPreOrderNumber) {
        this.targetPreOrderNumber = targetPreOrderNumber;
    }

    public boolean isCanRelate() {
        return isCanRelate;
    }

    public void setCanRelate(boolean canRelate) {
        isCanRelate = canRelate;
    }

    public String getCanntRelReason() {
        return canntRelReason;
    }

    public void setCanntRelReason(String canntRelReason) {
        this.canntRelReason = canntRelReason;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCdName() {
        return statusCdName;
    }

    public void setStatusCdName(String statusCdName) {
        this.statusCdName = statusCdName;
    }

    public PreSaleOrderHisDTO getPreSaleOrderHisDTO() {
        return preSaleOrderHisDTO;
    }

    public void setPreSaleOrderHisDTO(
        PreSaleOrderHisDTO preSaleOrderHisDTO) {
        this.preSaleOrderHisDTO = preSaleOrderHisDTO;
    }
}
