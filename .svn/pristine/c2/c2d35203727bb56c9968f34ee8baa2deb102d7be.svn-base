package com.ffcs.crmd.cas.sys.entity;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.sys.repository.IStaffRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;



@Table(name = "STAFF")
public class Staff extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "STAFF_ID")
	private Long staffId;

	/**
	 * 
	 */
	@Column(name = "LAST_LOGIN_DATE")
	private Timestamp lastLoginDate;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * ?
	 */
	@Column(name = "STAFF_TYPE")
	private String staffType;

	/**
	 * 
	 */
	@Column(name = "CHANNEL_ID")
	private Long channelId;

	/**
	 * 
	 */
	@Column(name = "PARTY_ID")
	private Long partyId;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "ID_CODE")
	private String idCode;

	/**
	 * ?
	 */
	@Column(name = "STAFF_CODE")
	private String staffCode;

	/**
	 * 
	 */
	@Column(name = "STAFF_NBR")
	private String staffNbr;

	/**
	 * 
	 */
	@Column(name = "DEV_ORG_ID")
	private Long devOrgId;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * ?
	 */
	@Column(name = "STAFF_DESC")
	private String staffDesc;

	/**
	 * 
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "STAFF_NAME")
	private String staffName;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "SALES_CODE")
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

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
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

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setStaffDesc(String staffDesc){
		this.staffDesc = staffDesc;
	}

	public String getStaffDesc(){
		return this.staffDesc;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	public String getStaffName(){
		return this.staffName;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setSalesCode(String salesCode){
		this.salesCode = salesCode;
	}

	public String getSalesCode(){
		return this.salesCode;
	}


	public Long getId() {
		return staffId;
	}

	public void setId(Long id) {
		this.staffId = id;
	}
	
	public Staff() {
		super();
    }

    public Staff(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IStaffRepository repository() {
		return (IStaffRepository) RepositoryRegister.getInstance()
				.getRepository(Staff.class);
	}
	
}
