package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;
import java.sql.Timestamp;


public class StaffDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long staffId;

	/**
	 * 
	 */
	private Timestamp lastLoginDate;

	/**
	 * 
	 */
	private Long regionCd;

	/**
	 * ?
	 */
	private String staffType;

	/**
	 * 
	 */
	private Long channelId;

	/**
	 * 
	 */
	private Long partyId;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * 
	 */
	private String idCode;

	/**
	 * ?
	 */
	private String staffCode;

	/**
	 * 
	 */
	private String staffNbr;

	/**
	 * 
	 */
	private Long devOrgId;

	/**
	 * 
	 */
	private Long orgId;

	/**
	 * ?
	 */
	private String staffDesc;

	/**
	 * 
	 */
	private String staffName;

	/**
	 * 
	 */
	private String salesCode;


	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setLastLoginDate(Timestamp lastLoginDate){
		this.lastLoginDate = lastLoginDate;
	}

	public Timestamp getLastLoginDate(){
		return this.lastLoginDate;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setStaffType(String staffType){
		this.staffType = staffType;
	}

	public String getStaffType(){
		return this.staffType;
	}

	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}

	public Long getChannelId(){
		return this.channelId;
	}

	public void setPartyId(Long partyId){
		this.partyId = partyId;
	}

	public Long getPartyId(){
		return this.partyId;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setIdCode(String idCode){
		this.idCode = idCode;
	}

	public String getIdCode(){
		return this.idCode;
	}

	public void setStaffCode(String staffCode){
		this.staffCode = staffCode;
	}

	public String getStaffCode(){
		return this.staffCode;
	}

	public void setStaffNbr(String staffNbr){
		this.staffNbr = staffNbr;
	}

	public String getStaffNbr(){
		return this.staffNbr;
	}

	public void setDevOrgId(Long devOrgId){
		this.devOrgId = devOrgId;
	}

	public Long getDevOrgId(){
		return this.devOrgId;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setStaffDesc(String staffDesc){
		this.staffDesc = staffDesc;
	}

	public String getStaffDesc(){
		return this.staffDesc;
	}

	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	public String getStaffName(){
		return this.staffName;
	}

	public void setSalesCode(String salesCode){
		this.salesCode = salesCode;
	}

	public String getSalesCode(){
		return this.salesCode;
	}


}
