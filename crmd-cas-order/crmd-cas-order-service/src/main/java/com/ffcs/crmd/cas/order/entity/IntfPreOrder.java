package com.ffcs.crmd.cas.order.entity;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;


@Table(name = "INTF_PRE_ORDER")
public class IntfPreOrder extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "INTF_PRE_ORDER_ID")
	private Long intfPreOrderId;

	/**
	 * 
	 */
	@Column(name = "NEXT_DEAL_TIME")
	private Timestamp nextDealTime;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "ERR_MSG")
	private String errMsg;

	/**
	 * ҵ
	 */
	@Column(name = "TEXT_TYPE")
	private String textType;

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
	 * P
	 */
	@Column(name = "PRE_ORDER_NUMBER")
	private String preOrderNumber;

	/**
	 * 
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * ͬ
	 */
	@Column(name = "CHANNEL_NBR")
	private String channelNbr;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "DEAL_NUM")
	private Long dealNum;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "DTIMESTAMP")
	private Long dtimestamp;

	/**
	 * 
	 */
	@Column(name = "DVERSION")
	private Long dversion;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	public void setIntfPreOrderId(Long intfPreOrderId){
		this.intfPreOrderId = intfPreOrderId;
	}

	public Long getIntfPreOrderId(){
		return this.intfPreOrderId;
	}

	public void setNextDealTime(Timestamp nextDealTime){
		this.nextDealTime = nextDealTime;
	}

	public Timestamp getNextDealTime(){
		return this.nextDealTime;
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

	public void setErrMsg(String errMsg){
		this.errMsg = errMsg;
	}

	public String getErrMsg(){
		return this.errMsg;
	}

	public void setTextType(String textType){
		this.textType = textType;
	}

	public String getTextType(){
		return this.textType;
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

	public void setPreOrderNumber(String preOrderNumber){
		this.preOrderNumber = preOrderNumber;
	}

	public String getPreOrderNumber(){
		return this.preOrderNumber;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setChannelNbr(String channelNbr){
		this.channelNbr = channelNbr;
	}

	public String getChannelNbr(){
		return this.channelNbr;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setDealNum(Long dealNum){
		this.dealNum = dealNum;
	}

	public Long getDealNum(){
		return this.dealNum;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
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

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
		this.statusDate = DateUtils.dateToTimestamp(new Date());
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}


	public Long getId() {
		return intfPreOrderId;
	}

	public void setId(Long id) {
		this.intfPreOrderId = id;
	}
	
	public IntfPreOrder() {
		super();
    }

    public IntfPreOrder(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IIntfPreOrderRepository repository() {
		return (IIntfPreOrderRepository) RepositoryRegister.getInstance()
				.getRepository(IntfPreOrder.class);
	}
	
}
