package com.ffcs.crmd.cas.order.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderRepository;
import com.ffcs.crmd.cas.order.service.IAutoGenOrderAttachService;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@ShardingBean
@Table(name = "AUTO_GEN_ORDER")
public class AutoGenOrder extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "AUTO_GEN_ORDER_ID")
	private Long autoGenOrderId;

	/**
	 * ҵ
	 */
	@Column(name = "ACC_NBR")
	private String accNbr;

	/**
	 * ĩ
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "SEND_DATE")
	private Timestamp sendDate;

	/**
	 * 
	 */
	@Column(name = "ERR_CODE")
	private String errCode;

	/**
	 * 
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

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
	 * Ԥ
	 */
	@Column(name = "PRE_SALE_ORDER")
	private String preSaleOrder;

	/**
	 * 
	 */
	@Column(name = "PROD_OFFER_ID")
	private Long prodOfferId;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * ҵ
	 */
	@Column(name = "SCENE_FLAG")
	private String sceneFlag;

	/**
	 * ״̬ʱ
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
	@Column(name = "RESULT")
	private String result;

	/**
	 * ҵ
	 */
	@Column(name = "SCENE_TYPE")
	private String sceneType;

	/**
	 * 
	 */
	@Column(name = "CUST_ID")
	private Long custId;

	/**
	 * ״̬
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "RECEIVE_DATE")
	private Timestamp receiveDate;

	public void setAutoGenOrderId(Long autoGenOrderId){
		this.autoGenOrderId = autoGenOrderId;
	}

	public Long getAutoGenOrderId(){
		return this.autoGenOrderId;
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

	public void setSendDate(Timestamp sendDate){
		this.sendDate = sendDate;
	}

	public Timestamp getSendDate(){
		return this.sendDate;
	}

	public void setErrCode(String errCode){
		this.errCode = errCode;
	}

	public String getErrCode(){
		return this.errCode;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
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

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return this.result;
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

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
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

	public void setReceiveDate(Timestamp receiveDate){
		this.receiveDate = receiveDate;
	}

	public Timestamp getReceiveDate(){
		return this.receiveDate;
	}


	public Long getId() {
		return autoGenOrderId;
	}

	public void setId(Long id) {
		this.autoGenOrderId = id;
	}
	
	public AutoGenOrder() {
		super();
    }

    public AutoGenOrder(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IAutoGenOrderRepository repository() {
		return (IAutoGenOrderRepository) RepositoryRegister.getInstance()
				.getRepository(AutoGenOrder.class);
	}
}
