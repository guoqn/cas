package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class PreSaleOrderProcAttrVo  extends CrmdBaseConditionVo {
	
	private Long preOrderProcAttrId;

	/**
	 * ĩ
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private Long shardingId;

	/**
	 * 
	 */
	private Long attrValueId;

	/**
	 * 
	 */
	private String attrDesc;

	/**
	 * 
	 */
	private Long areaId;

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
	private Long attrId;

	/**
	 * 
	 */
	private Long preSaleOrderProcId;


	public void setPreOrderProcAttrId(Long preOrderProcAttrId){
		this.preOrderProcAttrId = preOrderProcAttrId;
	}

	public Long getPreOrderProcAttrId(){
		return this.preOrderProcAttrId;
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

	public void setAttrValueId(Long attrValueId){
		this.attrValueId = attrValueId;
	}

	public Long getAttrValueId(){
		return this.attrValueId;
	}

	public void setAttrDesc(String attrDesc){
		this.attrDesc = attrDesc;
	}

	public String getAttrDesc(){
		return this.attrDesc;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
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

	public void setAttrId(Long attrId){
		this.attrId = attrId;
	}

	public Long getAttrId(){
		return this.attrId;
	}

	public void setPreSaleOrderProcId(Long preSaleOrderProcId){
		this.preSaleOrderProcId = preSaleOrderProcId;
	}

	public Long getPreSaleOrderProcId(){
		return this.preSaleOrderProcId;
	}


}
