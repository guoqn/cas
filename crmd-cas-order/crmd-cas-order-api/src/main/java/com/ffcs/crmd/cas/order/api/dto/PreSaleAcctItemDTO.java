package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;

import java.util.List;

public class PreSaleAcctItemDTO extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    private Long preAcctItemId;

    /**
     *
     */
    private Long regionCd;

    /**
     *
     */
    private Long shardingId;

    /**
     *
     */
    private String acctItemType;

    /**
     *
     */
    private Long areaId;

    /**
     *
     */
    private Long preOrderId;

    /**
     *
     */
    private Long preOrderItemId;

    /**
     *
     */
    private String acctSoNumber;

    /**
     *
     */
    private Long dtimestamp;

    /**
     *
     */
    private Long dversion;

    /**
     * 属性值列表
     */
    private List<AttrValueDTO> attrValueDTOList;

    /**
     * 社采终端款
     */
    private String payResource;

    /**
     * 预存费用
     */
    private String payStore;

    /**
     * 普通现金
     */
    private String paySample;

    public String getPayResource() {
        return payResource;
    }

    public void setPayResource(String payResource) {
        this.payResource = payResource;
    }

    public String getPayStore() {
        return payStore;
    }

    public void setPayStore(String payStore) {
        this.payStore = payStore;
    }

    public String getPaySample() {
        return paySample;
    }

    public void setPaySample(String paySample) {
        this.paySample = paySample;
    }

    public void setPreAcctItemId(Long preAcctItemId) {
        this.preAcctItemId = preAcctItemId;
    }

    public Long getPreAcctItemId() {
        return this.preAcctItemId;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setAcctItemType(String acctItemType) {
        this.acctItemType = acctItemType;
    }

    public String getAcctItemType() {
        return this.acctItemType;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setPreOrderId(Long preOrderId) {
        this.preOrderId = preOrderId;
    }

    public Long getPreOrderId() {
        return this.preOrderId;
    }

    public void setPreOrderItemId(Long preOrderItemId) {
        this.preOrderItemId = preOrderItemId;
    }

    public Long getPreOrderItemId() {
        return this.preOrderItemId;
    }

    public void setAcctSoNumber(String acctSoNumber) {
        this.acctSoNumber = acctSoNumber;
    }

    public String getAcctSoNumber() {
        return this.acctSoNumber;
    }

    public void setDtimestamp(Long dtimestamp) {
        this.dtimestamp = dtimestamp;
    }

    public Long getDtimestamp() {
        return this.dtimestamp;
    }

    public void setDversion(Long dversion) {
        this.dversion = dversion;
    }

    public Long getDversion() {
        return this.dversion;
    }

    public List<AttrValueDTO> getAttrValueDTOList() {
        return attrValueDTOList;
    }

    public void setAttrValueDTOList(List<AttrValueDTO> attrValueDTOList) {
        this.attrValueDTOList = attrValueDTOList;
    }
}
