package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.sql.Timestamp;


public class StaffPositionDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long staffPositionId;

	/**
	 * 
	 */
	private Timestamp expireDate;

	/**
	 * 
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private Timestamp effectDate;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * 
	 */
	private String orgRelCd;

	/**
	 * 
	 */
	private Long orgId;

	/**
	 * 
	 */
	private String priType;

	/**
	 * 
	 */
	private Long staffId;

	/**
	 * crm1.0ԭtf.tfid
	 */
	private Long oldPositionId;

	/**
	 * 
	 */
	private Long positionId;


	public void setStaffPositionId(Long staffPositionId){
		this.staffPositionId = staffPositionId;
	}

	public Long getStaffPositionId(){
		return this.staffPositionId;
	}

	public void setExpireDate(Timestamp expireDate){
		this.expireDate = expireDate;
	}

	public Timestamp getExpireDate(){
		return this.expireDate;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setEffectDate(Timestamp effectDate){
		this.effectDate = effectDate;
	}

	public Timestamp getEffectDate(){
		return this.effectDate;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setOrgRelCd(String orgRelCd){
		this.orgRelCd = orgRelCd;
	}

	public String getOrgRelCd(){
		return this.orgRelCd;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setPriType(String priType){
		this.priType = priType;
	}

	public String getPriType(){
		return this.priType;
	}

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setOldPositionId(Long oldPositionId){
		this.oldPositionId = oldPositionId;
	}

	public Long getOldPositionId(){
		return this.oldPositionId;
	}

	public void setPositionId(Long positionId){
		this.positionId = positionId;
	}

	public Long getPositionId(){
		return this.positionId;
	}


}
