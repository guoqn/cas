package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class IntfPreOrderAttachDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;


	/**
	 * 序列号，主键字段
	 */
	private Long intfPreOrderId;

	/**
	 * 县局标识
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private Long shardingId;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 同步报文
	 */
	private String textContent;

	/**
	 * 本地网标识
	 */
	private Long areaId;


	public void setIntfPreOrderId(Long intfPreOrderId){
		this.intfPreOrderId = intfPreOrderId;
	}

	public Long getIntfPreOrderId(){
		return this.intfPreOrderId;
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

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}


}
