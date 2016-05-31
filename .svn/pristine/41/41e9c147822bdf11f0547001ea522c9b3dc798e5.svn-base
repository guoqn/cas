package com.ffcs.crmd.cas.order.entity;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderAttachHisRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@ShardingBean
@Table(name = "AUTO_GEN_ORDER_ATTACH_HIS")
public class AutoGenOrderAttachHis extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 历史表主键
	 */
	@Id
	@Column(name = "HIS_ID")
	private Long hisId;

	/**
	 * 末梢县局
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 报错截图
	 */
	@Column(name = "PIC")
	private String pic;

	/**
	 * 送普坤报文
	 */
	@Column(name = "XML_MSG")
	private String xmlMsg;

	/**
	 * 创建员工
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 最后修改时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 本地网标识
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 状态时间
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
	 * 修改人
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 主键ID
	 */
	@Column(name = "AUTO_GEN_ORDER_ID")
	private Long autoGenOrderId;

	/**
	 * 状态
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;


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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getXmlMsg() {
		return xmlMsg;
	}

	public void setXmlMsg(String xmlMsg) {
		this.xmlMsg = xmlMsg;
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

	public void setAutoGenOrderId(Long autoGenOrderId){
		this.autoGenOrderId = autoGenOrderId;
	}

	public Long getAutoGenOrderId(){
		return this.autoGenOrderId;
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


	public Long getId() {
		return hisId;
	}

	public void setId(Long id) {
		this.hisId = id;
	}
	
	public AutoGenOrderAttachHis() {
		super();
    }

    public AutoGenOrderAttachHis(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IAutoGenOrderAttachHisRepository repository() {
		return (IAutoGenOrderAttachHisRepository) RepositoryRegister.getInstance()
				.getRepository(AutoGenOrderAttachHis.class);
	}
	
}
