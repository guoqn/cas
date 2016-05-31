package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class OrgSceneTypeRelVo  extends CrmdBaseConditionVo {
	

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
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 团队名称
	 */
	private String orgName;

	/**
	 * 记录客户订单标识
	 */
	private String sceneType;

	/**
	 * 受理类型，多值
	 */
	private String sceneTypes;

	/**
	 * 状态
	 */
	private String statusCd;

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

	public String getSceneTypes() {
		return sceneTypes;
	}

	public void setSceneTypes(String sceneTypes) {
		this.sceneTypes = sceneTypes;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
}
