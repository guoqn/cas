package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

public class OrgSceneTypeRelDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;


	/**
	 * 记录销售品订单项标识
	 */
	private Long orgSceneTypeRelId;

	/**
	 * 县局标识
	 */
	private Long regionCd;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 订单项类型分为：01=客户订单项、02=账户订单项、03=销售品订单项、04=产品订单项
	 */
	private String sceneTypeName;

	/**
	 * 本地网标识
	 */
	private Long areaId;

	/**
	 * 记录销售品订单项标识
	 */
	private Long orgId;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 *
	 */
	private String sceneType;

	/**
	 * 组织名称
	 */
	private String orgName;

	/**
	 * 二次受理团队名称列表
	 */
	private String executeOrgNames;

	/**
	 * 业务类型，多值，接收界面新增传来的多选框值，以逗号隔开
	 */
	private String sceneTypes;

	/**
	 * 是否选中
	 */
	private boolean checked;

	private Long oldOrgId;

	public Long getOldOrgId() {
		return oldOrgId;
	}

	public void setOldOrgId(Long oldOrgId) {
		this.oldOrgId = oldOrgId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setOrgSceneTypeRelId(Long orgSceneTypeRelId){
		this.orgSceneTypeRelId = orgSceneTypeRelId;
	}

	public Long getOrgSceneTypeRelId(){
		return this.orgSceneTypeRelId;
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

	public void setSceneTypeName(String sceneTypeName){
		this.sceneTypeName = sceneTypeName;
	}

	public String getSceneTypeName(){
		return this.sceneTypeName;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
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

	public void setSceneType(String sceneType){
		this.sceneType = sceneType;
	}

	public String getSceneType(){
		return this.sceneType;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getExecuteOrgNames() {
		return executeOrgNames;
	}

	public void setExecuteOrgNames(String executeOrgNames) {
		this.executeOrgNames = executeOrgNames;
	}

	public String getSceneTypes() {
		return sceneTypes;
	}

	public void setSceneTypes(String sceneTypes) {
		this.sceneTypes = sceneTypes;
	}
}
