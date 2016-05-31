package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class AreaCodeDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long areaCodeId;

	/**
	 * 
	 */
	private Long regionId;

	/**
	 * 
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private String areaNbr;

	/**
	 * 
	 */
	private String areaCode;

	/**
	 * 
	 */
	private Long areaId;


	public void setAreaCodeId(Long areaCodeId){
		this.areaCodeId = areaCodeId;
	}

	public Long getAreaCodeId(){
		return this.areaCodeId;
	}

	public void setRegionId(Long regionId){
		this.regionId = regionId;
	}

	public Long getRegionId(){
		return this.regionId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setAreaNbr(String areaNbr){
		this.areaNbr = areaNbr;
	}

	public String getAreaNbr(){
		return this.areaNbr;
	}

	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}

	public String getAreaCode(){
		return this.areaCode;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}


}
