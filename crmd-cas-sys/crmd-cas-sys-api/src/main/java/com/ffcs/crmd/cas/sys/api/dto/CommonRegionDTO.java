package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

public class CommonRegionDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	/**
	 * 
	 */
	private Long commonRegionId;

	/**
	 * 
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private String countyType;

	/**
	 * 
	 */
	private String regionType;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * 
	 */
	private String regionDesc;

	/**
	 * 
	 */
	private String regionName;

	/**
	 * 
	 */
	private String regionCode;

	/**
	 * 
	 */
	private Long upRegionId;

	/**
	 * 
	 */
	private Long defaultRegionId;

	private String fromQryBtn;

	private AcrossOrgDTO acrossOrgDTO;

	public AcrossOrgDTO getAcrossOrgDTO() {
		return acrossOrgDTO;
	}

	public void setAcrossOrgDTO(AcrossOrgDTO acrossOrgDTO) {
		this.acrossOrgDTO = acrossOrgDTO;
	}

	public String getFromQryBtn() {
		return fromQryBtn;
	}

	public void setFromQryBtn(String fromQryBtn) {
		this.fromQryBtn = fromQryBtn;
	}

	public void setCommonRegionId(Long commonRegionId) {
		this.commonRegionId = commonRegionId;
	}

	public Long getCommonRegionId() {
		return this.commonRegionId;
	}

	public void setRegionCd(Long regionCd) {
		this.regionCd = regionCd;
	}

	public Long getRegionCd() {
		return this.regionCd;
	}

	public void setCountyType(String countyType) {
		this.countyType = countyType;
	}

	public String getCountyType() {
		return this.countyType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public String getRegionType() {
		return this.regionType;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setRegionDesc(String regionDesc) {
		this.regionDesc = regionDesc;
	}

	public String getRegionDesc() {
		return this.regionDesc;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setUpRegionId(Long upRegionId) {
		this.upRegionId = upRegionId;
	}

	public Long getUpRegionId() {
		return this.upRegionId;
	}

	public void setDefaultRegionId(Long defaultRegionId) {
		this.defaultRegionId = defaultRegionId;
	}

	public Long getDefaultRegionId() {
		return this.defaultRegionId;
	}
}
