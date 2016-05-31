package com.ffcs.crmd.cas.order.api.vo;

import java.sql.Timestamp;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class PreSaleOrderHisVo extends CrmdBaseConditionVo {

    private Long hisId;

    /**
     *
     */
    private Long regionCd;

    /**
     *
     */
    private Long areaId;

    /**
     *
     */
    private Long lockedStaff;

    /**
     *
     */
    private String orderFrom;

    /**
     *
     */
    private String sceneType;

    /**
     *
     */
    private Long custId;

    /**
     *
     */
    private Long customerInteractionEventId;

    /**
     * ҵ
     */
    private String serviceType;

    /**
     *
     */
    private Long extCustOrderId;

    /**
     *
     */
    private String orderType;

    /**
     *
     */
    private Long shardingId;

    /**
     *
     */
    private String actionType;

    /**
     *
     */
    private String priority;

    /**
     *
     */
    private Long seq;

    /**
     *
     */
    private Long preOrderId;

    /**
     *
     */
    private Timestamp acceptTime;

    /**
     *
     */
    private Long orgId;

    /**
     *
     */
    private Long channelD;

    /**
     *
     */
    private String lockedStatus;

    /**
     *
     */
    private Long dtimestamp;

    /**
     *
     */
    private Long dversion;

    /**
     * Ա
     */
    private Long staffId;

    /**
     *
     */
    private String prodType;

    /**
     * ԤԼʱ
     */
    private Timestamp bookTime;

    /**
     *
     */
    private String handlePeopleName;

    /**
     *
     */
    private Timestamp lockedTime;

    /**
     *
     */
    private String preHandleFlag;

    /**
     *
     */
    private String ifEnd;

    /**
     *
     */
    private Long lanId;

    /**
     * 正式订单编号
     */
    private String custOrderNum;
    /**
     * 旧P单号
     */
    private String preOrderNumber;
    /**
     * 要关联的P单号
     */
    private String newPreOrderNumber;

    public String getCustOrderNum() {
        return custOrderNum;
    }

    public void setCustOrderNum(String custOrderNum) {
        this.custOrderNum = custOrderNum;
    }

    public String getNewPreOrderNumber() {
        return newPreOrderNumber;
    }

    public void setNewPreOrderNumber(String newPreOrderNumber) {
        this.newPreOrderNumber = newPreOrderNumber;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public Long getHisId() {
        return this.hisId;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setLockedStaff(Long lockedStaff) {
        this.lockedStaff = lockedStaff;
    }

    public Long getLockedStaff() {
        return this.lockedStaff;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getOrderFrom() {
        return this.orderFrom;
    }

    public void setSceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getSceneType() {
        return this.sceneType;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getCustId() {
        return this.custId;
    }

    public void setCustomerInteractionEventId(Long customerInteractionEventId) {
        this.customerInteractionEventId = customerInteractionEventId;
    }

    public Long getCustomerInteractionEventId() {
        return this.customerInteractionEventId;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void setExtCustOrderId(Long extCustOrderId) {
        this.extCustOrderId = extCustOrderId;
    }

    public Long getExtCustOrderId() {
        return this.extCustOrderId;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPreOrderNumber(String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    public String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getSeq() {
        return this.seq;
    }

    public void setPreOrderId(Long preOrderId) {
        this.preOrderId = preOrderId;
    }

    public Long getPreOrderId() {
        return this.preOrderId;
    }

    public void setAcceptTime(Timestamp acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Timestamp getAcceptTime() {
        return this.acceptTime;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setChannelD(Long channelD) {
        this.channelD = channelD;
    }

    public Long getChannelD() {
        return this.channelD;
    }

    public void setLockedStatus(String lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    public String getLockedStatus() {
        return this.lockedStatus;
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

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStaffId() {
        return this.staffId;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdType() {
        return this.prodType;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }

    public Timestamp getBookTime() {
        return this.bookTime;
    }

    public void setHandlePeopleName(String handlePeopleName) {
        this.handlePeopleName = handlePeopleName;
    }

    public String getHandlePeopleName() {
        return this.handlePeopleName;
    }

    public void setLockedTime(Timestamp lockedTime) {
        this.lockedTime = lockedTime;
    }

    public Timestamp getLockedTime() {
        return this.lockedTime;
    }

    public void setPreHandleFlag(String preHandleFlag) {
        this.preHandleFlag = preHandleFlag;
    }

    public String getPreHandleFlag() {
        return this.preHandleFlag;
    }

    public void setIfEnd(String ifEnd) {
        this.ifEnd = ifEnd;
    }

    public String getIfEnd() {
        return this.ifEnd;
    }

    public void setLanId(Long lanId) {
        this.lanId = lanId;
    }

    public Long getLanId() {
        return this.lanId;
    }


}
