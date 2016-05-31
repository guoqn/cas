package com.ffcs.crmd.cas.order.entity;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderPoolRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@ShardingBean
@Table(name = "PRE_SALE_ORDER_POOL")
public class PreSaleOrderPool extends AbsCrmdBaseEntity<Long> implements Comparable{

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "PRE_SALE_ORDER_POOL_ID")
	private Long preSaleOrderPoolId;

	/**
	 * 
	 */
	@Column(name = "CUST_ORDER_ID")
	private Long custOrderId;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "IS_LEADER_ASSIGN")
	private String isLeaderAssign;

	/**
	 * 
	 */
	@Column(name = "ACCEPT_DATE")
	private Timestamp acceptDate;

	/**
	 * Ԥ
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 
	 */
	@Column(name = "PRIORITY")
	private Long priority;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "ACCEPT_ORG_ID")
	private Long acceptOrgId;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * Ԥ
	 */
	@Column(name = "PRE_ORDER_ID")
	private Long preOrderId;

	/**
	 * Ԥ
	 */
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * 
	 */
	@Column(name = "DTIMESTAMP")
	private Long dtimestamp;

	/**
	 * 
	 */
	@Column(name = "DVERSION")
	private Long dversion;

	/**
	 * Ԥ
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "STAFF_ID")
	private Long staffId;

	/**
	 * 
	 */
	@Column(name = "VERSION")
	private Long version;

	/**
	 * 
	 */
	@Column(name = "SCENE_TYPE")
	private String sceneType;

	/**
	 * ״̬
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * ҵ
	 */
	@Column(name = "SERVICE_TYPE")
	private String serviceType;

	/**
	 * 订单来源
	 */
	@Column(name = "PRE_ORDER_SRC")
	private String preOrderSrc;


	public void setPreSaleOrderPoolId(Long preSaleOrderPoolId){
		this.preSaleOrderPoolId = preSaleOrderPoolId;
	}

	public Long getPreSaleOrderPoolId(){
		return this.preSaleOrderPoolId;
	}

	public void setCustOrderId(Long custOrderId){
		this.custOrderId = custOrderId;
	}

	public Long getCustOrderId(){
		return this.custOrderId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setIsLeaderAssign(String isLeaderAssign){
		this.isLeaderAssign = isLeaderAssign;
	}

	public String getIsLeaderAssign(){
		return this.isLeaderAssign;
	}

	public void setAcceptDate(Timestamp acceptDate){
		this.acceptDate = acceptDate;
	}

	public Timestamp getAcceptDate(){
		return this.acceptDate;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setPriority(Long priority){
		this.priority = priority;
	}

	public Long getPriority(){
		return this.priority;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setAcceptOrgId(Long acceptOrgId){
		this.acceptOrgId = acceptOrgId;
	}

	public Long getAcceptOrgId(){
		return this.acceptOrgId;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setPreOrderId(Long preOrderId){
		this.preOrderId = preOrderId;
	}

	public Long getPreOrderId(){
		return this.preOrderId;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setDtimestamp(Long dtimestamp){
		this.dtimestamp = dtimestamp;
	}

	public Long getDtimestamp(){
		return this.dtimestamp;
	}

	public void setDversion(Long dversion){
		this.dversion = dversion;
	}

	public Long getDversion(){
		return this.dversion;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setVersion(Long version){
		this.version = version;
	}

	public Long getVersion(){
		return this.version;
	}

	public void setSceneType(String sceneType){
		this.sceneType = sceneType;
	}

	public String getSceneType(){
		return this.sceneType;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
		this.statusDate = DateUtils.dateToTimestamp(DateUtils.getNowDate());
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setServiceType(String serviceType){
		this.serviceType = serviceType;
	}

	public String getServiceType(){
		return this.serviceType;
	}

	public String getPreOrderSrc() {
		return preOrderSrc;
	}

	public void setPreOrderSrc(String preOrderSrc) {
		this.preOrderSrc = preOrderSrc;
	}

	public Long getId() {
		return preSaleOrderPoolId;
	}

	public void setId(Long id) {
		this.preSaleOrderPoolId = id;
	}
	
	public PreSaleOrderPool() {
		super();
    }

    public PreSaleOrderPool(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IPreSaleOrderPoolRepository repository() {
		return (IPreSaleOrderPoolRepository) RepositoryRegister.getInstance()
				.getRepository(PreSaleOrderPool.class);
	}

	@Override
	public int compareTo(Object o) {
		PreSaleOrderPool preSaleOrderPool = (PreSaleOrderPool) o;
		return this.getId().compareTo(preSaleOrderPool.getId());
	}
	/**
     * 获取退单人员名称.
     * 
     * @return
     * @author chenjw
     * 2014-5-16
     */
    public String getGoBackedStaffName() {
    	return this.getRemarkContent(IntfConstant.GO_BACK_TAG_STAFF_NAME.getValue());
    }
    /**
     * 获取退单人联系信息.
     * 
     * @return
     * @author chenjw
     * 2014-5-16
     */
    public String getGoBackedPhoneNumber() {
    	return this.getRemarkContent(IntfConstant.GO_BACK_TAG_PHONE_NUMBER.getValue());
    }
    /**
     * 获取退单原因.
     * 
     * @return
     * @author chenjw
     * 2014-5-16
     */
    public String getGoBackedReason() {
    	return this.getRemarkContent(IntfConstant.GO_BACK_TAG_REASON.getValue());
    }
    /**
     * 设置退单信息.
     * 
     * @param preSaleOrderPool
     * @param staffName
     * @param phoneNumber
     * @param goBackReason
     * @author chenjw
     * 2014-5-14
     */
    public void setGoBackContent(String staffName, String phoneNumber, String goBackReason) {
    	StringBuffer sbf = new StringBuffer();
    	sbf.append("<" + IntfConstant.GO_BACK_TAG.getValue() + ">");
    	sbf.append("<" + IntfConstant.GO_BACK_TAG_STAFF_NAME.getValue() + ">");
    	sbf.append(staffName);
    	sbf.append("</" + IntfConstant.GO_BACK_TAG_STAFF_NAME.getValue() + ">");
    	sbf.append("<" + IntfConstant.GO_BACK_TAG_PHONE_NUMBER.getValue() + ">");
    	sbf.append(phoneNumber);
    	sbf.append("</" + IntfConstant.GO_BACK_TAG_PHONE_NUMBER.getValue() + ">");
    	sbf.append("<" + IntfConstant.GO_BACK_TAG_REASON.getValue() + ">");
    	sbf.append(goBackReason);
    	sbf.append("</" + IntfConstant.GO_BACK_TAG_REASON.getValue() + ">");
    	sbf.append("</" + IntfConstant.GO_BACK_TAG.getValue() + ">");
    	this.setRemark(StringUtils.strnull(this.getRemark()) + sbf.toString());
    }
    /**
     * 清空退单信息.
     * 
     * @param remark
     * @param tagName
     * @return
     * @author chenjw
     * 2014-5-14
     */
    public void cleanGoBackContent() {
    	if (!StringUtils.isNullOrEmpty(this.getRemark())) {
    		String beginMark = "<" + IntfConstant.GO_BACK_TAG.getValue() + ">";
    		int beginIndex = -1;
    		beginIndex = this.getRemark().indexOf(beginMark);
    		if (beginIndex != -1) {
    			this.setRemark(this.getRemark().subSequence(0, beginIndex).toString());
    		}
    		
    	}
    }
    
    /**
     * 获取指定字段值.
     * 
     * @param remark
     * @param tagName
     * @author chenjw
     * 2014-5-14
     */
    public String getRemarkContent(String tagName) {
    	if(StringUtils.isNullOrEmpty(tagName) || StringUtils.isNullOrEmpty(remark)){
            return "";
        }
        int startIndex = -1;
        int endIndex = -1;
        final String str_maskStartStr = "<" + tagName + ">";
        final String str_maskEndStr = "</" + tagName + ">";
        
        if (remark != null) {
            startIndex = remark.indexOf(str_maskStartStr);
            endIndex = remark.indexOf(str_maskEndStr);
            if (startIndex != -1) {
                final int contentStart = remark.indexOf('>', startIndex) + 1;
                return remark.substring(contentStart, endIndex);
            }
        }
        return "";
    }
    /**
     * 获取退单信息.
     * 
     * @param remark
     * @param tagName
     * @return
     * @author chenjw
     * 2014-5-14
     */
    public String getGoBackContent() {
    	String tagName = IntfConstant.GO_BACK_TAG.getValue();
    	return this.getRemarkContent(tagName);
    }
}
