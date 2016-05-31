package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.sql.Timestamp;


public class AutoGenOrderHisDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long hisId;

	/**
	 * ҵ
	 */
	private String accNbr;

	/**
	 * ĩ
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private String errCode;

	/**
	 * 
	 */
	private Timestamp sendDate;

	/**
	 * 
	 */
	private Long shardingId;

	/**
	 * Ԥ
	 */
	private String preSaleOrder;

	/**
	 * 
	 */
	private Long prodOfferId;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * ҵ
	 */
	private String sceneFlag;

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
	private String result;

	/**
	 * 
	 */
	private Long autoGenOrderId;

	/**
	 * ҵ
	 */
	private String sceneType;

	/**
	 * 
	 */
	private Long custId;

	/**
	 * 
	 */
	private Timestamp receiveDate;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
	}

	public void setAccNbr(String accNbr){
		this.accNbr = accNbr;
	}

	public String getAccNbr(){
		return this.accNbr;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setErrCode(String errCode){
		this.errCode = errCode;
	}

	public String getErrCode(){
		return this.errCode;
	}

	public void setSendDate(Timestamp sendDate){
		this.sendDate = sendDate;
	}

	public Timestamp getSendDate(){
		return this.sendDate;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setPreSaleOrder(String preSaleOrder){
		this.preSaleOrder = preSaleOrder;
	}

	public String getPreSaleOrder(){
		return this.preSaleOrder;
	}

	public void setProdOfferId(Long prodOfferId){
		this.prodOfferId = prodOfferId;
	}

	public Long getProdOfferId(){
		return this.prodOfferId;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setSceneFlag(String sceneFlag){
		this.sceneFlag = sceneFlag;
	}

	public String getSceneFlag(){
		return this.sceneFlag;
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

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return this.result;
	}

	public void setAutoGenOrderId(Long autoGenOrderId){
		this.autoGenOrderId = autoGenOrderId;
	}

	public Long getAutoGenOrderId(){
		return this.autoGenOrderId;
	}

	public void setSceneType(String sceneType){
		this.sceneType = sceneType;
	}

	public String getSceneType(){
		return this.sceneType;
	}

	public void setCustId(Long custId){
		this.custId = custId;
	}

	public Long getCustId(){
		return this.custId;
	}

	public void setReceiveDate(Timestamp receiveDate){
		this.receiveDate = receiveDate;
	}

	public Timestamp getReceiveDate(){
		return this.receiveDate;
	}


}
