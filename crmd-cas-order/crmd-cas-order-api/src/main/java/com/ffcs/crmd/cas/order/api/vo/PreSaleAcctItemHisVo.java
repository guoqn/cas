package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class PreSaleAcctItemHisVo  extends CrmdBaseConditionVo {
	
	private Long hisId;

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
	 * 
	 */
	private Long preAcctItemId;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
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

	public void setAcctItemType(String acctItemType){
		this.acctItemType = acctItemType;
	}

	public String getAcctItemType(){
		return this.acctItemType;
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

	public void setPreOrderItemId(Long preOrderItemId){
		this.preOrderItemId = preOrderItemId;
	}

	public Long getPreOrderItemId(){
		return this.preOrderItemId;
	}

	public void setAcctSoNumber(String acctSoNumber){
		this.acctSoNumber = acctSoNumber;
	}

	public String getAcctSoNumber(){
		return this.acctSoNumber;
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

	public void setPreAcctItemId(Long preAcctItemId){
		this.preAcctItemId = preAcctItemId;
	}

	public Long getPreAcctItemId(){
		return this.preAcctItemId;
	}


}
