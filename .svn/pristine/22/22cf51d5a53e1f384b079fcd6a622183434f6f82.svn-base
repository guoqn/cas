package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemAttrService;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderService;


@ShardingBean
@Table(name = "PRE_SALE_ACCT_ITEM")
public class PreSaleAcctItem extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "PRE_ACCT_ITEM_ID")
	private Long preAcctItemId;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "ACCT_ITEM_TYPE")
	private String acctItemType;

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
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "PRE_ORDER_ID")
	private Long preOrderId;

	/**
	 * 
	 */
	@Column(name = "PRE_ORDER_ITEM_ID")
	private Long preOrderItemId;

	/**
	 * 
	 */
	@Column(name = "ACCT_SO_NUMBER")
	private String acctSoNumber;

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


	public void setPreAcctItemId(Long preAcctItemId){
		this.preAcctItemId = preAcctItemId;
	}

	public Long getPreAcctItemId(){
		return this.preAcctItemId;
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

	public void setAcctItemType(String acctItemType){
		this.acctItemType = acctItemType;
	}

	public String getAcctItemType(){
		return this.acctItemType;
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

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setPreOrderId(Long preOrderId){
		this.preOrderId = preOrderId;
	}

	public Long getPreOrderId(){
		return this.preOrderId;
	}

	public void setPreOrderItemId(Long preOrderItemId){
		this.preOrderItemId = preOrderItemId;
	}

	public Long getPreOrderItemId(){
		return this.preOrderItemId;
	}

	public void setAcctSoNumber(String acctSoNumber){
		this.acctSoNumber = acctSoNumber;
	}

	public String getAcctSoNumber(){
		return this.acctSoNumber;
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
		this.statusDate = DateUtils.dateToTimestamp(DateUtils.getNowDate());
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
		return preAcctItemId;
	}

	public void setId(Long id) {
		this.preAcctItemId = id;
	}
	
	public PreSaleAcctItem() {
		super();
    }

    public PreSaleAcctItem(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IPreSaleAcctItemRepository repository() {
		return (IPreSaleAcctItemRepository) RepositoryRegister.getInstance()
				.getRepository(PreSaleAcctItem.class);
	}
	
}
