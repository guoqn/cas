package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class IsaleAcctItemVo  extends CrmdBaseConditionVo {
	
	private Long isaleAcctItemId;

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
	private String extAcctItemId;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * ʵ
	 */
	private Long realAmount;

	/**
	 * 
	 */
	private String saleSerial;


	public void setIsaleAcctItemId(Long isaleAcctItemId){
		this.isaleAcctItemId = isaleAcctItemId;
	}

	public Long getIsaleAcctItemId(){
		return this.isaleAcctItemId;
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

	public void setExtAcctItemId(String extAcctItemId){
		this.extAcctItemId = extAcctItemId;
	}

	public String getExtAcctItemId(){
		return this.extAcctItemId;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
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

	public void setRealAmount(Long realAmount){
		this.realAmount = realAmount;
	}

	public Long getRealAmount(){
		return this.realAmount;
	}

	public void setSaleSerial(String saleSerial){
		this.saleSerial = saleSerial;
	}

	public String getSaleSerial(){
		return this.saleSerial;
	}


}
