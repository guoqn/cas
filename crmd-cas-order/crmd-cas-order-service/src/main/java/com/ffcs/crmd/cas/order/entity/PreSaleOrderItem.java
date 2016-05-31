package com.ffcs.crmd.cas.order.entity;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemRepository;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;


@ShardingBean
@Table(name = "PRE_SALE_ORDER_ITEM")
public class PreSaleOrderItem extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "PRE_ORDER_ITEM_ID")
	private Long preOrderItemId;

	/**
	 * 
	 */
	@Column(name = "STATUS_CHANGE_REASON")
	private String statusChangeReason;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

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
	@Column(name = "ATTR_PARAM2")
	private String attrParam2;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "ORDER_ITEM_CD")
	private String orderItemCd;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "ORDER_ITEM_OBJ_ID")
	private Long orderItemObjId;

	/**
	 * 
	 */
	@Column(name = "ORDER_ITEM_OBJ_TYPE")
	private String orderItemObjType;

	/**
	 * 
	 */
	@Column(name = "ATTR_ID")
	private Long attrId;

	/**
	 * 
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "SERVICE_OFFER_ID")
	private Long serviceOfferId;

	/**
	 * 
	 */
	@Column(name = "REASON")
	private String reason;

	/**
	 * 
	 */
	@Column(name = "PRIORITY")
	private String priority;

	/**
	 * 
	 */
	@Column(name = "JAVA_CODE")
	private String javaCode;

	/**
	 * 
	 */
	@Column(name = "HANDLE_TIME")
	private Timestamp handleTime;

	/**
	 * 
	 */
	@Column(name = "PRE_ORDER_ID")
	private Long preOrderId;

	/**
	 * 
	 */
	@Column(name = "SUPER_ITEM_ID")
	private Long superItemId;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE")
	private String attrValue;

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
	 * 
	 */
	@Column(name = "PRE_HANDLE_FLAG")
	private String preHandleFlag;

	/**
	 * 
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "CLASS_ID")
	private Long classId;


	public void setPreOrderItemId(Long preOrderItemId){
		this.preOrderItemId = preOrderItemId;
	}

	public Long getPreOrderItemId(){
		return this.preOrderItemId;
	}

	public void setStatusChangeReason(String statusChangeReason){
		this.statusChangeReason = statusChangeReason;
	}

	public String getStatusChangeReason(){
		return this.statusChangeReason;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
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

	public void setAttrParam2(String attrParam2){
		this.attrParam2 = attrParam2;
	}

	public String getAttrParam2(){
		return this.attrParam2;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setOrderItemCd(String orderItemCd){
		this.orderItemCd = orderItemCd;
	}

	public String getOrderItemCd(){
		return this.orderItemCd;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setOrderItemObjId(Long orderItemObjId){
		this.orderItemObjId = orderItemObjId;
	}

	public Long getOrderItemObjId(){
		return this.orderItemObjId;
	}

	public void setOrderItemObjType(String orderItemObjType){
		this.orderItemObjType = orderItemObjType;
	}

	public String getOrderItemObjType(){
		return this.orderItemObjType;
	}

	public void setAttrId(Long attrId){
		this.attrId = attrId;
	}

	public Long getAttrId(){
		return this.attrId;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setServiceOfferId(Long serviceOfferId){
		this.serviceOfferId = serviceOfferId;
	}

	public Long getServiceOfferId(){
		return this.serviceOfferId;
	}

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getReason(){
		return this.reason;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return this.priority;
	}

	public void setJavaCode(String javaCode){
		this.javaCode = javaCode;
	}

	public String getJavaCode(){
		return this.javaCode;
	}

	public void setHandleTime(Timestamp handleTime){
		this.handleTime = handleTime;
	}

	public Timestamp getHandleTime(){
		return this.handleTime;
	}

	public void setPreOrderId(Long preOrderId){
		this.preOrderId = preOrderId;
	}

	public Long getPreOrderId(){
		return this.preOrderId;
	}

	public void setSuperItemId(Long superItemId){
		this.superItemId = superItemId;
	}

	public Long getSuperItemId(){
		return this.superItemId;
	}

	public void setAttrValue(String attrValue){
		this.attrValue = attrValue;
	}

	public String getAttrValue(){
		return this.attrValue;
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

	public void setPreHandleFlag(String preHandleFlag){
		this.preHandleFlag = preHandleFlag;
	}

	public String getPreHandleFlag(){
		return this.preHandleFlag;
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

	public void setClassId(Long classId){
		this.classId = classId;
	}

	public Long getClassId(){
		return this.classId;
	}


	public Long getId() {
		return preOrderItemId;
	}

	public void setId(Long id) {
		this.preOrderItemId = id;
	}
	
	public PreSaleOrderItem() {
		super();
    }

    public PreSaleOrderItem(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IPreSaleOrderItemRepository repository() {
		return (IPreSaleOrderItemRepository) RepositoryRegister.getInstance()
				.getRepository(PreSaleOrderItem.class);
	}
	
}
