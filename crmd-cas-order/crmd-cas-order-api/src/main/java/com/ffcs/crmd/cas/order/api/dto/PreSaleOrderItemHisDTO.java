package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.sql.Timestamp;


public class PreSaleOrderItemHisDTO  extends CrmdBaseDTO  {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long hisId;

	/**
	 * 
	 */
	private String statusChangeReason;

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
	private String attrParam2;

	/**
	 * 
	 */
	private String orderItemCd;

	/**
	 * 
	 */
	private Long orderItemObjId;

	/**
	 * 
	 */
	private String orderItemObjType;

	/**
	 * 
	 */
	private Long attrId;

	/**
	 * 
	 */
	private Long shardingId;

	/**
	 * 
	 */
	private Long serviceOfferId;

	/**
	 * 
	 */
	private String reason;

	/**
	 * 
	 */
	private String priority;

	/**
	 * 
	 */
	private String javaCode;

	/**
	 * 
	 */
	private Timestamp handleTime;

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
	private Long superItemId;

	/**
	 * 
	 */
	private String attrValue;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 
	 */
	private String preHandleFlag;

	/**
	 * 
	 */
	private Long classId;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
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

	public void setOrderItemCd(String orderItemCd){
		this.orderItemCd = orderItemCd;
	}

	public String getOrderItemCd(){
		return this.orderItemCd;
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

	public void setPreOrderItemId(Long preOrderItemId){
		this.preOrderItemId = preOrderItemId;
	}

	public Long getPreOrderItemId(){
		return this.preOrderItemId;
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

	public void setClassId(Long classId){
		this.classId = classId;
	}

	public Long getClassId(){
		return this.classId;
	}


}
