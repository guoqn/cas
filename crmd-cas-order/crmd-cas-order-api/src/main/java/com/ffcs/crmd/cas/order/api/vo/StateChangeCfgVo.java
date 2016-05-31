package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class StateChangeCfgVo  extends CrmdBaseConditionVo {
	
	private Long stateChangeCfgId;

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
	private String textType;

	/**
	 * Ŀ
	 */
	private String destChannelNbr;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * 
	 */
	private String executeMethod;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;


	public void setStateChangeCfgId(Long stateChangeCfgId){
		this.stateChangeCfgId = stateChangeCfgId;
	}

	public Long getStateChangeCfgId(){
		return this.stateChangeCfgId;
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

	public void setTextType(String textType){
		this.textType = textType;
	}

	public String getTextType(){
		return this.textType;
	}

	public void setDestChannelNbr(String destChannelNbr){
		this.destChannelNbr = destChannelNbr;
	}

	public String getDestChannelNbr(){
		return this.destChannelNbr;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setExecuteMethod(String executeMethod){
		this.executeMethod = executeMethod;
	}

	public String getExecuteMethod(){
		return this.executeMethod;
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


}
