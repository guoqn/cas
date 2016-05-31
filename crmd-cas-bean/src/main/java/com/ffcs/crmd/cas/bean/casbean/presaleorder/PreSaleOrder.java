/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.presaleorder;

/**
 * 预受理订单信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrder implements java.io.Serializable {

    /**
     * 预受理订单Id
     */
    private long preOrderId;

    /**
     * Keeps track of whether primitive field preOrderId has been
     * set already.
     */
    private boolean haspreOrderId;

    /**
     * 客户事件Id
     */
    private long customerInteractionEventId;

    /**
     * Keeps track of whether primitive field
     * customerInteractionEventId has been set already.
     */
    private boolean hascustomerInteractionEventId;

    /**
     * 员工ID
     */
    private long staffId;

    /**
     * Keeps track of whether primitive field staffId has been set
     * already.
     */
    private boolean hasstaffId;

    /**
     * 客户Id
     */
    private long custId;

    /**
     * Keeps track of whether primitive field custId has been set
     * already.
     */
    private boolean hascustId;

    /**
     * 预受理订单流水
     */
    private java.lang.String preOrderNumber;

    /**
     * 受理类型
     */
    private java.lang.String sceneType;

    /**
     * 锁定状态
     */
    private java.lang.String lockedStatus;

    /**
     * 锁定员工
     */
    private long lockedStaff;

    /**
     * Keeps track of whether primitive field lockedStaff has been
     * set already.
     */
    private boolean haslockedStaff;

    /**
     * 锁定时间
     */
    private java.lang.String lockedTime;

    /**
     * 客户订单类型
     */
    private java.lang.String orderType;

    /**
     * 经办人
     */
    private java.lang.String handlePeopleName;

    /**
     * 优先级
     */
    private java.lang.String priority;

    /**
     * 受理时间
     */
    private java.lang.String acceptTime;

    /**
     * 归属本地网标识
     */
    private long lanId;

    /**
     * Keeps track of whether primitive field lanId has been set
     * already.
     */
    private boolean haslanId;

    /**
     * 备注
     */
    private java.lang.String remark;

    /**
     * 预受理标志
     */
    private java.lang.String preHandleFlag;

    /**
     * 预约时间
     */
    private java.lang.String bookTime;

    /**
     * 渠道标识
     */
    private long channelId;

    /**
     * Keeps track of whether primitive field channelId has been
     * set already.
     */
    private boolean haschannelId;

    /**
     * 受理团队
     */
    private long orgId;

    /**
     * Keeps track of whether primitive field orgId has been set
     * already.
     */
    private boolean hasorgId;

    /**
     * 订单来源
     */
    private java.lang.String orderFrom;

    /**
     * 正式单标示
     */
    private long extCustOrderId;

    /**
     * Keeps track of whether primitive field extCustOrderId has
     * been set already.
     */
    private boolean hasextCustOrderId;

    /**
     * 联系人名称
     */
    private java.lang.String contactName;

    /**
     * 联系人电话
     */
    private java.lang.String contactPhone;

    /**
     * 是否最后一张单
     */
    private java.lang.String ifEnd;

    /**
     * 序列
     */
    private long seq;

    /**
     * Keeps track of whether primitive field seq has been set
     * already.
     */
    private boolean hasseq;

    /**
     * 工单来源
     */
    private java.lang.String preOrderSrc;

    /**
     * 产品
     */
    private java.lang.String prodType;

    /**
     * 动作
     */
    private java.lang.String actionType;

    /**
     * 业务类型
     */
    private java.lang.String serviceType;

    /**
     * P单当前状态编码
     */
    private java.lang.String statusCd;

    /**
     * 状态时间
     */
    private java.lang.String statusDate;

    /**
     * 区域Id
     */
    private long areaId;

    /**
     * Keeps track of whether primitive field areaId has been set
     * already.
     */
    private boolean hasareaId;

    /**
     * 区域
     */
    private long regionCd;

    /**
     * Keeps track of whether primitive field regionCd has been set
     * already.
     */
    private boolean hasregionCd;

    /**
     * 创建员工
     */
    private long createStaff;

    /**
     * Keeps track of whether primitive field createStaff has been
     * set already.
     */
    private boolean hascreateStaff;

    /**
     * 修改员工
     */
    private long updateStaff;

    /**
     * Keeps track of whether primitive field updateStaff has been
     * set already.
     */
    private boolean hasupdateStaff;

    /**
     * 正式订单流水
     */
    private java.lang.String custSoNumber;

    /**
     * 客户名称
     */
    private java.lang.String custName;

    /**
     * 甩单员工联系号码
     */
    private java.lang.String mobilePhone;

    /**
     * 批量单数量
     */
    private java.lang.String batchAmount;

    /**
     * 发展员工
     */
    private java.lang.String devStaff;

    /**
     * 发展团队
     */
    private java.lang.String devTeam;

    public PreSaleOrder() {
        super();
    }

    /**
     */
    public void deleteAreaId() {
        this.hasareaId= false;
    }

    /**
     */
    public void deleteChannelId() {
        this.haschannelId= false;
    }

    /**
     */
    public void deleteCreateStaff() {
        this.hascreateStaff= false;
    }

    /**
     */
    public void deleteCustId() {
        this.hascustId= false;
    }

    /**
     */
    public void deleteCustomerInteractionEventId() {
        this.hascustomerInteractionEventId= false;
    }

    /**
     */
    public void deleteExtCustOrderId() {
        this.hasextCustOrderId= false;
    }

    /**
     */
    public void deleteLanId() {
        this.haslanId= false;
    }

    /**
     */
    public void deleteLockedStaff() {
        this.haslockedStaff= false;
    }

    /**
     */
    public void deleteOrgId() {
        this.hasorgId= false;
    }

    /**
     */
    public void deletePreOrderId() {
        this.haspreOrderId= false;
    }

    /**
     */
    public void deleteRegionCd() {
        this.hasregionCd= false;
    }

    /**
     */
    public void deleteSeq() {
        this.hasseq= false;
    }

    /**
     */
    public void deleteStaffId() {
        this.hasstaffId= false;
    }

    /**
     */
    public void deleteUpdateStaff() {
        this.hasupdateStaff= false;
    }

    /**
     * Returns the value of field 'acceptTime'. The field
     * 'acceptTime' has the following description: 受理时间
     * 
     * @return the value of field 'AcceptTime'.
     */
    public java.lang.String getAcceptTime() {
        return this.acceptTime;
    }

    /**
     * Returns the value of field 'actionType'. The field
     * 'actionType' has the following description: 动作
     * 
     * @return the value of field 'ActionType'.
     */
    public java.lang.String getActionType() {
        return this.actionType;
    }

    /**
     * Returns the value of field 'areaId'. The field 'areaId' has
     * the following description: 区域Id
     * 
     * @return the value of field 'AreaId'.
     */
    public long getAreaId() {
        return this.areaId;
    }

    /**
     * Returns the value of field 'batchAmount'. The field
     * 'batchAmount' has the following description: 批量单数量
     * 
     * @return the value of field 'BatchAmount'.
     */
    public java.lang.String getBatchAmount() {
        return this.batchAmount;
    }

    /**
     * Returns the value of field 'bookTime'. The field 'bookTime'
     * has the following description: 预约时间
     * 
     * @return the value of field 'BookTime'.
     */
    public java.lang.String getBookTime() {
        return this.bookTime;
    }

    /**
     * Returns the value of field 'channelId'. The field
     * 'channelId' has the following description: 渠道标识
     * 
     * @return the value of field 'ChannelId'.
     */
    public long getChannelId() {
        return this.channelId;
    }

    /**
     * Returns the value of field 'contactName'. The field
     * 'contactName' has the following description: 联系人名称
     * 
     * @return the value of field 'ContactName'.
     */
    public java.lang.String getContactName() {
        return this.contactName;
    }

    /**
     * Returns the value of field 'contactPhone'. The field
     * 'contactPhone' has the following description: 联系人电话
     * 
     * @return the value of field 'ContactPhone'.
     */
    public java.lang.String getContactPhone() {
        return this.contactPhone;
    }

    /**
     * Returns the value of field 'createStaff'. The field
     * 'createStaff' has the following description: 创建员工
     * 
     * @return the value of field 'CreateStaff'.
     */
    public long getCreateStaff() {
        return this.createStaff;
    }

    /**
     * Returns the value of field 'custId'. The field 'custId' has
     * the following description: 客户Id
     * 
     * @return the value of field 'CustId'.
     */
    public long getCustId() {
        return this.custId;
    }

    /**
     * Returns the value of field 'custName'. The field 'custName'
     * has the following description: 客户名称
     * 
     * @return the value of field 'CustName'.
     */
    public java.lang.String getCustName() {
        return this.custName;
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 正式订单流水
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Returns the value of field 'customerInteractionEventId'. The
     * field 'customerInteractionEventId' has the following
     * description: 客户事件Id
     * 
     * @return the value of field 'CustomerInteractionEventId'.
     */
    public long getCustomerInteractionEventId() {
        return this.customerInteractionEventId;
    }

    /**
     * Returns the value of field 'devStaff'. The field 'devStaff'
     * has the following description: 发展员工
     * 
     * @return the value of field 'DevStaff'.
     */
    public java.lang.String getDevStaff() {
        return this.devStaff;
    }

    /**
     * Returns the value of field 'devTeam'. The field 'devTeam'
     * has the following description: 发展团队
     * 
     * @return the value of field 'DevTeam'.
     */
    public java.lang.String getDevTeam() {
        return this.devTeam;
    }

    /**
     * Returns the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 正式单标示
     * 
     * @return the value of field 'ExtCustOrderId'.
     */
    public long getExtCustOrderId() {
        return this.extCustOrderId;
    }

    /**
     * Returns the value of field 'handlePeopleName'. The field
     * 'handlePeopleName' has the following description: 经办人
     * 
     * @return the value of field 'HandlePeopleName'.
     */
    public java.lang.String getHandlePeopleName() {
        return this.handlePeopleName;
    }

    /**
     * Returns the value of field 'ifEnd'. The field 'ifEnd' has
     * the following description: 是否最后一张单
     * 
     * @return the value of field 'IfEnd'.
     */
    public java.lang.String getIfEnd() {
        return this.ifEnd;
    }

    /**
     * Returns the value of field 'lanId'. The field 'lanId' has
     * the following description: 归属本地网标识
     * 
     * @return the value of field 'LanId'.
     */
    public long getLanId() {
        return this.lanId;
    }

    /**
     * Returns the value of field 'lockedStaff'. The field
     * 'lockedStaff' has the following description: 锁定员工
     * 
     * @return the value of field 'LockedStaff'.
     */
    public long getLockedStaff() {
        return this.lockedStaff;
    }

    /**
     * Returns the value of field 'lockedStatus'. The field
     * 'lockedStatus' has the following description: 锁定状态
     * 
     * @return the value of field 'LockedStatus'.
     */
    public java.lang.String getLockedStatus() {
        return this.lockedStatus;
    }

    /**
     * Returns the value of field 'lockedTime'. The field
     * 'lockedTime' has the following description: 锁定时间
     * 
     * @return the value of field 'LockedTime'.
     */
    public java.lang.String getLockedTime() {
        return this.lockedTime;
    }

    /**
     * Returns the value of field 'mobilePhone'. The field
     * 'mobilePhone' has the following description: 甩单员工联系号码
     * 
     * @return the value of field 'MobilePhone'.
     */
    public java.lang.String getMobilePhone() {
        return this.mobilePhone;
    }

    /**
     * Returns the value of field 'orderFrom'. The field
     * 'orderFrom' has the following description: 订单来源
     * 
     * @return the value of field 'OrderFrom'.
     */
    public java.lang.String getOrderFrom() {
        return this.orderFrom;
    }

    /**
     * Returns the value of field 'orderType'. The field
     * 'orderType' has the following description: 客户订单类型
     * 
     * @return the value of field 'OrderType'.
     */
    public java.lang.String getOrderType() {
        return this.orderType;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 受理团队
     * 
     * @return the value of field 'OrgId'.
     */
    public long getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'preHandleFlag'. The field
     * 'preHandleFlag' has the following description: 预受理标志
     * 
     * @return the value of field 'PreHandleFlag'.
     */
    public java.lang.String getPreHandleFlag() {
        return this.preHandleFlag;
    }

    /**
     * Returns the value of field 'preOrderId'. The field
     * 'preOrderId' has the following description: 预受理订单Id
     * 
     * @return the value of field 'PreOrderId'.
     */
    public long getPreOrderId() {
        return this.preOrderId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理订单流水
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'preOrderSrc'. The field
     * 'preOrderSrc' has the following description: 工单来源
     * 
     * @return the value of field 'PreOrderSrc'.
     */
    public java.lang.String getPreOrderSrc() {
        return this.preOrderSrc;
    }

    /**
     * Returns the value of field 'priority'. The field 'priority'
     * has the following description: 优先级
     * 
     * @return the value of field 'Priority'.
     */
    public java.lang.String getPriority() {
        return this.priority;
    }

    /**
     * Returns the value of field 'prodType'. The field 'prodType'
     * has the following description: 产品
     * 
     * @return the value of field 'ProdType'.
     */
    public java.lang.String getProdType() {
        return this.prodType;
    }

    /**
     * Returns the value of field 'regionCd'. The field 'regionCd'
     * has the following description: 区域
     * 
     * @return the value of field 'RegionCd'.
     */
    public long getRegionCd() {
        return this.regionCd;
    }

    /**
     * Returns the value of field 'remark'. The field 'remark' has
     * the following description: 备注
     * 
     * @return the value of field 'Remark'.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     * Returns the value of field 'sceneType'. The field
     * 'sceneType' has the following description: 受理类型
     * 
     * @return the value of field 'SceneType'.
     */
    public java.lang.String getSceneType() {
        return this.sceneType;
    }

    /**
     * Returns the value of field 'seq'. The field 'seq' has the
     * following description: 序列
     * 
     * @return the value of field 'Seq'.
     */
    public long getSeq() {
        return this.seq;
    }

    /**
     * Returns the value of field 'serviceType'. The field
     * 'serviceType' has the following description: 业务类型
     * 
     * @return the value of field 'ServiceType'.
     */
    public java.lang.String getServiceType() {
        return this.serviceType;
    }

    /**
     * Returns the value of field 'staffId'. The field 'staffId'
     * has the following description: 员工ID
     * 
     * @return the value of field 'StaffId'.
     */
    public long getStaffId() {
        return this.staffId;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: P单当前状态编码
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Returns the value of field 'statusDate'. The field
     * 'statusDate' has the following description: 状态时间
     * 
     * @return the value of field 'StatusDate'.
     */
    public java.lang.String getStatusDate() {
        return this.statusDate;
    }

    /**
     * Returns the value of field 'updateStaff'. The field
     * 'updateStaff' has the following description: 修改员工
     * 
     * @return the value of field 'UpdateStaff'.
     */
    public long getUpdateStaff() {
        return this.updateStaff;
    }

    /**
     * Method hasAreaId.
     * 
     * @return true if at least one AreaId has been added
     */
    public boolean hasAreaId() {
        return this.hasareaId;
    }

    /**
     * Method hasChannelId.
     * 
     * @return true if at least one ChannelId has been added
     */
    public boolean hasChannelId() {
        return this.haschannelId;
    }

    /**
     * Method hasCreateStaff.
     * 
     * @return true if at least one CreateStaff has been added
     */
    public boolean hasCreateStaff() {
        return this.hascreateStaff;
    }

    /**
     * Method hasCustId.
     * 
     * @return true if at least one CustId has been added
     */
    public boolean hasCustId() {
        return this.hascustId;
    }

    /**
     * Method hasCustomerInteractionEventId.
     * 
     * @return true if at least one CustomerInteractionEventId has
     * been added
     */
    public boolean hasCustomerInteractionEventId() {
        return this.hascustomerInteractionEventId;
    }

    /**
     * Method hasExtCustOrderId.
     * 
     * @return true if at least one ExtCustOrderId has been added
     */
    public boolean hasExtCustOrderId() {
        return this.hasextCustOrderId;
    }

    /**
     * Method hasLanId.
     * 
     * @return true if at least one LanId has been added
     */
    public boolean hasLanId() {
        return this.haslanId;
    }

    /**
     * Method hasLockedStaff.
     * 
     * @return true if at least one LockedStaff has been added
     */
    public boolean hasLockedStaff() {
        return this.haslockedStaff;
    }

    /**
     * Method hasOrgId.
     * 
     * @return true if at least one OrgId has been added
     */
    public boolean hasOrgId() {
        return this.hasorgId;
    }

    /**
     * Method hasPreOrderId.
     * 
     * @return true if at least one PreOrderId has been added
     */
    public boolean hasPreOrderId() {
        return this.haspreOrderId;
    }

    /**
     * Method hasRegionCd.
     * 
     * @return true if at least one RegionCd has been added
     */
    public boolean hasRegionCd() {
        return this.hasregionCd;
    }

    /**
     * Method hasSeq.
     * 
     * @return true if at least one Seq has been added
     */
    public boolean hasSeq() {
        return this.hasseq;
    }

    /**
     * Method hasStaffId.
     * 
     * @return true if at least one StaffId has been added
     */
    public boolean hasStaffId() {
        return this.hasstaffId;
    }

    /**
     * Method hasUpdateStaff.
     * 
     * @return true if at least one UpdateStaff has been added
     */
    public boolean hasUpdateStaff() {
        return this.hasupdateStaff;
    }

    /**
     * Sets the value of field 'acceptTime'. The field 'acceptTime'
     * has the following description: 受理时间
     * 
     * @param acceptTime the value of field 'acceptTime'.
     */
    public void setAcceptTime(final java.lang.String acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * Sets the value of field 'actionType'. The field 'actionType'
     * has the following description: 动作
     * 
     * @param actionType the value of field 'actionType'.
     */
    public void setActionType(final java.lang.String actionType) {
        this.actionType = actionType;
    }

    /**
     * Sets the value of field 'areaId'. The field 'areaId' has the
     * following description: 区域Id
     * 
     * @param areaId the value of field 'areaId'.
     */
    public void setAreaId(final long areaId) {
        this.areaId = areaId;
        this.hasareaId = true;
    }

    /**
     * Sets the value of field 'batchAmount'. The field
     * 'batchAmount' has the following description: 批量单数量
     * 
     * @param batchAmount the value of field 'batchAmount'.
     */
    public void setBatchAmount(final java.lang.String batchAmount) {
        this.batchAmount = batchAmount;
    }

    /**
     * Sets the value of field 'bookTime'. The field 'bookTime' has
     * the following description: 预约时间
     * 
     * @param bookTime the value of field 'bookTime'.
     */
    public void setBookTime(final java.lang.String bookTime) {
        this.bookTime = bookTime;
    }

    /**
     * Sets the value of field 'channelId'. The field 'channelId'
     * has the following description: 渠道标识
     * 
     * @param channelId the value of field 'channelId'.
     */
    public void setChannelId(final long channelId) {
        this.channelId = channelId;
        this.haschannelId = true;
    }

    /**
     * Sets the value of field 'contactName'. The field
     * 'contactName' has the following description: 联系人名称
     * 
     * @param contactName the value of field 'contactName'.
     */
    public void setContactName(final java.lang.String contactName) {
        this.contactName = contactName;
    }

    /**
     * Sets the value of field 'contactPhone'. The field
     * 'contactPhone' has the following description: 联系人电话
     * 
     * @param contactPhone the value of field 'contactPhone'.
     */
    public void setContactPhone(final java.lang.String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * Sets the value of field 'createStaff'. The field
     * 'createStaff' has the following description: 创建员工
     * 
     * @param createStaff the value of field 'createStaff'.
     */
    public void setCreateStaff(final long createStaff) {
        this.createStaff = createStaff;
        this.hascreateStaff = true;
    }

    /**
     * Sets the value of field 'custId'. The field 'custId' has the
     * following description: 客户Id
     * 
     * @param custId the value of field 'custId'.
     */
    public void setCustId(final long custId) {
        this.custId = custId;
        this.hascustId = true;
    }

    /**
     * Sets the value of field 'custName'. The field 'custName' has
     * the following description: 客户名称
     * 
     * @param custName the value of field 'custName'.
     */
    public void setCustName(final java.lang.String custName) {
        this.custName = custName;
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 正式订单流水
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    /**
     * Sets the value of field 'customerInteractionEventId'. The
     * field 'customerInteractionEventId' has the following
     * description: 客户事件Id
     * 
     * @param customerInteractionEventId the value of field
     * 'customerInteractionEventId'.
     */
    public void setCustomerInteractionEventId(final long customerInteractionEventId) {
        this.customerInteractionEventId = customerInteractionEventId;
        this.hascustomerInteractionEventId = true;
    }

    /**
     * Sets the value of field 'devStaff'. The field 'devStaff' has
     * the following description: 发展员工
     * 
     * @param devStaff the value of field 'devStaff'.
     */
    public void setDevStaff(final java.lang.String devStaff) {
        this.devStaff = devStaff;
    }

    /**
     * Sets the value of field 'devTeam'. The field 'devTeam' has
     * the following description: 发展团队
     * 
     * @param devTeam the value of field 'devTeam'.
     */
    public void setDevTeam(final java.lang.String devTeam) {
        this.devTeam = devTeam;
    }

    /**
     * Sets the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 正式单标示
     * 
     * @param extCustOrderId the value of field 'extCustOrderId'.
     */
    public void setExtCustOrderId(final long extCustOrderId) {
        this.extCustOrderId = extCustOrderId;
        this.hasextCustOrderId = true;
    }

    /**
     * Sets the value of field 'handlePeopleName'. The field
     * 'handlePeopleName' has the following description: 经办人
     * 
     * @param handlePeopleName the value of field 'handlePeopleName'
     */
    public void setHandlePeopleName(final java.lang.String handlePeopleName) {
        this.handlePeopleName = handlePeopleName;
    }

    /**
     * Sets the value of field 'ifEnd'. The field 'ifEnd' has the
     * following description: 是否最后一张单
     * 
     * @param ifEnd the value of field 'ifEnd'.
     */
    public void setIfEnd(final java.lang.String ifEnd) {
        this.ifEnd = ifEnd;
    }

    /**
     * Sets the value of field 'lanId'. The field 'lanId' has the
     * following description: 归属本地网标识
     * 
     * @param lanId the value of field 'lanId'.
     */
    public void setLanId(final long lanId) {
        this.lanId = lanId;
        this.haslanId = true;
    }

    /**
     * Sets the value of field 'lockedStaff'. The field
     * 'lockedStaff' has the following description: 锁定员工
     * 
     * @param lockedStaff the value of field 'lockedStaff'.
     */
    public void setLockedStaff(final long lockedStaff) {
        this.lockedStaff = lockedStaff;
        this.haslockedStaff = true;
    }

    /**
     * Sets the value of field 'lockedStatus'. The field
     * 'lockedStatus' has the following description: 锁定状态
     * 
     * @param lockedStatus the value of field 'lockedStatus'.
     */
    public void setLockedStatus(final java.lang.String lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    /**
     * Sets the value of field 'lockedTime'. The field 'lockedTime'
     * has the following description: 锁定时间
     * 
     * @param lockedTime the value of field 'lockedTime'.
     */
    public void setLockedTime(final java.lang.String lockedTime) {
        this.lockedTime = lockedTime;
    }

    /**
     * Sets the value of field 'mobilePhone'. The field
     * 'mobilePhone' has the following description: 甩单员工联系号码
     * 
     * @param mobilePhone the value of field 'mobilePhone'.
     */
    public void setMobilePhone(final java.lang.String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Sets the value of field 'orderFrom'. The field 'orderFrom'
     * has the following description: 订单来源
     * 
     * @param orderFrom the value of field 'orderFrom'.
     */
    public void setOrderFrom(final java.lang.String orderFrom) {
        this.orderFrom = orderFrom;
    }

    /**
     * Sets the value of field 'orderType'. The field 'orderType'
     * has the following description: 客户订单类型
     * 
     * @param orderType the value of field 'orderType'.
     */
    public void setOrderType(final java.lang.String orderType) {
        this.orderType = orderType;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 受理团队
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final long orgId) {
        this.orgId = orgId;
        this.hasorgId = true;
    }

    /**
     * Sets the value of field 'preHandleFlag'. The field
     * 'preHandleFlag' has the following description: 预受理标志
     * 
     * @param preHandleFlag the value of field 'preHandleFlag'.
     */
    public void setPreHandleFlag(final java.lang.String preHandleFlag) {
        this.preHandleFlag = preHandleFlag;
    }

    /**
     * Sets the value of field 'preOrderId'. The field 'preOrderId'
     * has the following description: 预受理订单Id
     * 
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderId(final long preOrderId) {
        this.preOrderId = preOrderId;
        this.haspreOrderId = true;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理订单流水
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'preOrderSrc'. The field
     * 'preOrderSrc' has the following description: 工单来源
     * 
     * @param preOrderSrc the value of field 'preOrderSrc'.
     */
    public void setPreOrderSrc(final java.lang.String preOrderSrc) {
        this.preOrderSrc = preOrderSrc;
    }

    /**
     * Sets the value of field 'priority'. The field 'priority' has
     * the following description: 优先级
     * 
     * @param priority the value of field 'priority'.
     */
    public void setPriority(final java.lang.String priority) {
        this.priority = priority;
    }

    /**
     * Sets the value of field 'prodType'. The field 'prodType' has
     * the following description: 产品
     * 
     * @param prodType the value of field 'prodType'.
     */
    public void setProdType(final java.lang.String prodType) {
        this.prodType = prodType;
    }

    /**
     * Sets the value of field 'regionCd'. The field 'regionCd' has
     * the following description: 区域
     * 
     * @param regionCd the value of field 'regionCd'.
     */
    public void setRegionCd(final long regionCd) {
        this.regionCd = regionCd;
        this.hasregionCd = true;
    }

    /**
     * Sets the value of field 'remark'. The field 'remark' has the
     * following description: 备注
     * 
     * @param remark the value of field 'remark'.
     */
    public void setRemark(final java.lang.String remark) {
        this.remark = remark;
    }

    /**
     * Sets the value of field 'sceneType'. The field 'sceneType'
     * has the following description: 受理类型
     * 
     * @param sceneType the value of field 'sceneType'.
     */
    public void setSceneType(final java.lang.String sceneType) {
        this.sceneType = sceneType;
    }

    /**
     * Sets the value of field 'seq'. The field 'seq' has the
     * following description: 序列
     * 
     * @param seq the value of field 'seq'.
     */
    public void setSeq(final long seq) {
        this.seq = seq;
        this.hasseq = true;
    }

    /**
     * Sets the value of field 'serviceType'. The field
     * 'serviceType' has the following description: 业务类型
     * 
     * @param serviceType the value of field 'serviceType'.
     */
    public void setServiceType(final java.lang.String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Sets the value of field 'staffId'. The field 'staffId' has
     * the following description: 员工ID
     * 
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final long staffId) {
        this.staffId = staffId;
        this.hasstaffId = true;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: P单当前状态编码
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Sets the value of field 'statusDate'. The field 'statusDate'
     * has the following description: 状态时间
     * 
     * @param statusDate the value of field 'statusDate'.
     */
    public void setStatusDate(final java.lang.String statusDate) {
        this.statusDate = statusDate;
    }

    /**
     * Sets the value of field 'updateStaff'. The field
     * 'updateStaff' has the following description: 修改员工
     * 
     * @param updateStaff the value of field 'updateStaff'.
     */
    public void setUpdateStaff(final long updateStaff) {
        this.updateStaff = updateStaff;
        this.hasupdateStaff = true;
    }

}
