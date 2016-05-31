package com.ffcs.crmd.cas.order.api.vo;

import java.sql.Timestamp;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class PreSaleOrderProcHisVo  extends CrmdBaseConditionVo {
	

	/**
	 * 预销售订单处理过程标识
	 */
	private Long hisId;

	/**
	 * 
	 */
	private String realCustSoNumber;

	/**
	 * 县局标识
	 */
	private Long regionCd;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 本地网标识
	 */
	private Long areaId;

	/**
	 * 记录客户订单标识
	 */
	private Long preOrderId;

	/**
	 * 受理时间
	 */
	private Timestamp acceptTime;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 员工ID
	 */
	private Long staffId;

	/**
	 * 记录经办人
	 */
	private String handlePeopleName;

	/**
	 * 记录客户交互事件标识
	 */
	private Long customerInteractionEventId;

	/**
	 * 预销售订单处理过程标识
	 */
	private Long preSaleOrderProcId;

	/**
	 * 除了维护本省数据，还可能保存集团或者它省的数据，这里填写全国统一的本地网标识；
	 */
	private Long lanId;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
	}

	public void setRealCustSoNumber(String realCustSoNumber){
		this.realCustSoNumber = realCustSoNumber;
	}

	public String getRealCustSoNumber(){
		return this.realCustSoNumber;
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

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setPreOrderId(Long preOrderId){
		this.preOrderId = preOrderId;
	}

	public Long getPreOrderId(){
		return this.preOrderId;
	}

	public void setAcceptTime(Timestamp acceptTime){
		this.acceptTime = acceptTime;
	}

	public Timestamp getAcceptTime(){
		return this.acceptTime;
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

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setHandlePeopleName(String handlePeopleName){
		this.handlePeopleName = handlePeopleName;
	}

	public String getHandlePeopleName(){
		return this.handlePeopleName;
	}

	public void setCustomerInteractionEventId(Long customerInteractionEventId){
		this.customerInteractionEventId = customerInteractionEventId;
	}

	public Long getCustomerInteractionEventId(){
		return this.customerInteractionEventId;
	}

	public void setPreSaleOrderProcId(Long preSaleOrderProcId){
		this.preSaleOrderProcId = preSaleOrderProcId;
	}

	public Long getPreSaleOrderProcId(){
		return this.preSaleOrderProcId;
	}

	public void setLanId(Long lanId){
		this.lanId = lanId;
	}

	public Long getLanId(){
		return this.lanId;
	}


}
