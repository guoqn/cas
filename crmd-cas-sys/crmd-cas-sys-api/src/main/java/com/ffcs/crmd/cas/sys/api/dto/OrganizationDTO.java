package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.util.List;

public class OrganizationDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long orgId;

	/**
	 * ?
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private Long partyId;

	/**
	 * 
	 */
	private String orgName;

	/**
	 * 
	 */
	private String orgType;

	/**
	 * 
	 */
	private String areaCode;

	/**
	 * 
	 */
	private String orgLevel;

	/**
	 * 
	 */
	private Long orgSeq;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * ODS
	 */
	private String channelType;

	/**
	 * 
	 */
	private Long groupOrgId;

	/**
	 * 
	 */
	private String orgSubType;

	/**
	 * 
	 */
	private String orgContent;

	/**
	 * 
	 */
	private String orgSort;

	/**
	 * 
	 */
	private String townFlag;

	/**
	 * 
	 */
	private Long orgScale;

	/**
	 * 
	 */
	private String orgNameEn;

	/**
	 * 
	 */
	private String principal;

	/**
	 * 
	 */
	private Long commonRegionId;

	/**
	 * 
	 */
	private Long staffId;

	/**
	 * 
	 */
	private Long parentOrgId;

	/**
	 * 
	 */
	private String groupOrgCode;

	/**
	 * 
	 */
	private String ctgChannelNbr;

	/**
	 * 
	 */
	private String orgCode;

	/**
	 * 
	 */
	private String orgDuty;

	/**
	 * 团队关联的业务类型列表
	 */
	private List OrgSceneTypeRelDtos;

	/**
	 * 团队关联的业务类型名称汇总，以|组装
	 */
	private String sceneTypeNames;

	private Long oldOrgId;  //用来区分是新增还是修改

	/**
	 * 团队ID列表
	 */
	private List<Long> orgIds;

	private String fromQryBtn;

	public String getFromQryBtn() {
		return fromQryBtn;
	}

	public void setFromQryBtn(String fromQryBtn) {
		this.fromQryBtn = fromQryBtn;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
		this.oldOrgId = orgId;
	}

	public Long getOldOrgId() {
		return oldOrgId;
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

	public void setOrgDuty(String orgDuty){
		this.orgDuty = orgDuty;
	}

	public String getOrgDuty(){
		return this.orgDuty;
	}

	public List getOrgSceneTypeRelDtos() {
		return OrgSceneTypeRelDtos;
	}

	public void setOrgSceneTypeRelDtos(List orgSceneTypeRelDtos) {
		OrgSceneTypeRelDtos = orgSceneTypeRelDtos;
	}

	public String getSceneTypeNames() {
		return sceneTypeNames;
	}

	public void setSceneTypeNames(String sceneTypeNames) {
		this.sceneTypeNames = sceneTypeNames;
	}

	public void setOldOrgId(Long oldOrgId) {
		this.oldOrgId = oldOrgId;
	}

	public List<Long> getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(List<Long> orgIds) {
		this.orgIds = orgIds;
	}
}
