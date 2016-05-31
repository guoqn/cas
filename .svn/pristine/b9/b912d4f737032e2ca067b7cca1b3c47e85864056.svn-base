package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IIsaleAcctItemHisRepository;


@ShardingBean
@Table(name = "ISALE_ACCT_ITEM_HIS")
public class IsaleAcctItemHis extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "HIS_ID")
	private Long hisId;

	/**
	 * ĩ
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
	@Column(name = "EXT_ACCT_ITEM_ID")
	private String extAcctItemId;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

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
	 * ״̬
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "ISALE_ACCT_ITEM_ID")
	private Long isaleAcctItemId;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * ʵ
	 */
	@Column(name = "REAL_AMOUNT")
	private Long realAmount;

	/**
	 * 
	 */
	@Column(name = "SALE_SERIAL")
	private String saleSerial;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
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

	public void setExtAcctItemId(String extAcctItemId){
		this.extAcctItemId = extAcctItemId;
	}

	public String getExtAcctItemId(){
		return this.extAcctItemId;
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
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setIsaleAcctItemId(Long isaleAcctItemId){
		this.isaleAcctItemId = isaleAcctItemId;
	}

	public Long getIsaleAcctItemId(){
		return this.isaleAcctItemId;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setRealAmount(Long realAmount){
		this.realAmount = realAmount;
	}

	public Long getRealAmount(){
		return this.realAmount;
	}

	public void setSaleSerial(String saleSerial){
		this.saleSerial = saleSerial;
	}

	public String getSaleSerial(){
		return this.saleSerial;
	}


	public Long getId() {
		return hisId;
	}

	public void setId(Long id) {
		this.hisId = id;
	}
	
	public IsaleAcctItemHis() {
		super();
    }

    public IsaleAcctItemHis(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IIsaleAcctItemHisRepository repository() {
		return (IIsaleAcctItemHisRepository) RepositoryRegister.getInstance()
				.getRepository(IsaleAcctItemHis.class);
	}
	
}
