package com.ffcs.crmd.cas.sys.entity;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.sys.repository.IOrganizationRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;



@Table(name = "ORGANIZATION")
public class Organization extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * ?
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "PARTY_ID")
	private Long partyId;

	/**
	 * 
	 */
	@Column(name = "ORG_NAME")
	private String orgName;

	/**
	 * 
	 */
	@Column(name = "ORG_TYPE")
	private String orgType;

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
	@Column(name = "AREA_CODE")
	private String areaCode;

	/**
	 * 
	 */
	@Column(name = "ORG_LEVEL")
	private String orgLevel;

	/**
	 * 
	 */
	@Column(name = "ORG_SEQ")
	private Long orgSeq;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * ???
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * ODS
	 */
	@Column(name = "CHANNEL_TYPE")
	private String channelType;

	/**
	 * 
	 */
	@Column(name = "GROUP_ORG_ID")
	private Long groupOrgId;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "ORG_SUB_TYPE")
	private String orgSubType;

	/**
	 * 
	 */
	@Column(name = "ORG_CONTENT")
	private String orgContent;

	/**
	 * 
	 */
	@Column(name = "ORG_SORT")
	private String orgSort;

	/**
	 * 
	 */
	@Column(name = "TOWN_FLAG")
	private String townFlag;

	/**
	 * 
	 */
	@Column(name = "ORG_SCALE")
	private Long orgScale;

	/**
	 * 
	 */
	@Column(name = "ORG_NAME_EN")
	private String orgNameEn;

	/**
	 * 
	 */
	@Column(name = "PRINCIPAL")
	private String principal;

	/**
	 * 
	 */
	@Column(name = "COMMON_REGION_ID")
	private Long commonRegionId;

	/**
	 * 
	 */
	@Column(name = "STAFF_ID")
	private Long staffId;

	/**
	 * ??
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "PARENT_ORG_ID")
	private Long parentOrgId;

	/**
	 * 
	 */
	@Column(name = "GROUP_ORG_CODE")
	private String groupOrgCode;

	/**
	 * 
	 */
	@Column(name = "CTG_CHANNEL_NBR")
	private String ctgChannelNbr;

	/**
	 * 
	 */
	@Column(name = "ORG_CODE")
	private String orgCode;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "ORG_DUTY")
	private String orgDuty;


	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setPartyId(Long partyId){
		this.partyId = partyId;
	}

	public Long getPartyId(){
		return this.partyId;
	}

	public void setOrgName(String orgName){
		this.orgName = orgName;
	}

	public String getOrgName(){
		return this.orgName;
	}

	public void setOrgType(String orgType){
		this.orgType = orgType;
	}

	public String getOrgType(){
		return this.orgType;
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

	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}

	public String getAreaCode(){
		return this.areaCode;
	}

	public void setOrgLevel(String orgLevel){
		this.orgLevel = orgLevel;
	}

	public String getOrgLevel(){
		return this.orgLevel;
	}

	public void setOrgSeq(Long orgSeq){
		this.orgSeq = orgSeq;
	}

	public Long getOrgSeq(){
		return this.orgSeq;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setChannelType(String channelType){
		this.channelType = channelType;
	}

	public String getChannelType(){
		return this.channelType;
	}

	public void setGroupOrgId(Long groupOrgId){
		this.groupOrgId = groupOrgId;
	}

	public Long getGroupOrgId(){
		return this.groupOrgId;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setOrgSubType(String orgSubType){
		this.orgSubType = orgSubType;
	}

	public String getOrgSubType(){
		return this.orgSubType;
	}

	public void setOrgContent(String orgContent){
		this.orgContent = orgContent;
	}

	public String getOrgContent(){
		return this.orgContent;
	}

	public void setOrgSort(String orgSort){
		this.orgSort = orgSort;
	}

	public String getOrgSort(){
		return this.orgSort;
	}

	public void setTownFlag(String townFlag){
		this.townFlag = townFlag;
	}

	public String getTownFlag(){
		return this.townFlag;
	}

	public void setOrgScale(Long orgScale){
		this.orgScale = orgScale;
	}

	public Long getOrgScale(){
		return this.orgScale;
	}

	public void setOrgNameEn(String orgNameEn){
		this.orgNameEn = orgNameEn;
	}

	public String getOrgNameEn(){
		return this.orgNameEn;
	}

	public void setPrincipal(String principal){
		this.principal = principal;
	}

	public String getPrincipal(){
		return this.principal;
	}

	public void setCommonRegionId(Long commonRegionId){
		this.commonRegionId = commonRegionId;
	}

	public Long getCommonRegionId(){
		return this.commonRegionId;
	}

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setParentOrgId(Long parentOrgId){
		this.parentOrgId = parentOrgId;
	}

	public Long getParentOrgId(){
		return this.parentOrgId;
	}

	public void setGroupOrgCode(String groupOrgCode){
		this.groupOrgCode = groupOrgCode;
	}

	public String getGroupOrgCode(){
		return this.groupOrgCode;
	}

	public void setCtgChannelNbr(String ctgChannelNbr){
		this.ctgChannelNbr = ctgChannelNbr;
	}

	public String getCtgChannelNbr(){
		return this.ctgChannelNbr;
	}

	public void setOrgCode(String orgCode){
		this.orgCode = orgCode;
	}

	public String getOrgCode(){
		return this.orgCode;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setOrgDuty(String orgDuty){
		this.orgDuty = orgDuty;
	}

	public String getOrgDuty(){
		return this.orgDuty;
	}


	public Long getId() {
		return orgId;
	}

	public void setId(Long id) {
		this.orgId = id;
	}
	
	public Organization() {
		super();
    }

    public Organization(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IOrganizationRepository repository() {
		return (IOrganizationRepository) RepositoryRegister.getInstance()
				.getRepository(Organization.class);
	}
	
}
