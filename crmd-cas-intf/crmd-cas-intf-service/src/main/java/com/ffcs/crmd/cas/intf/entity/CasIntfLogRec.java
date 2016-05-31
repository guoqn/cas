package com.ffcs.crmd.cas.intf.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.intf.repository.ICasIntfLogRecRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

@Table(name = "CAS_INTF_LOG_REC")
public class CasIntfLogRec extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 序列号，主键字段
	 */
	@Id
	@Column(name = "CAS_INTF_LOG_REC_ID")
	private Long casIntfLogRecId;

	/**
	 * 修改员工
	 */
	@Column(name = "RSP_TRAN_ID")
	private String rspTranId;

	/**
	 * 
	 */
	@Column(name = "CONSUME_TIMESTAMP")
	private Long consumeTimestamp;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 县局标识
	 */
	@Column(name = "CLIENT_MSG")
	private String clientMsg;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 创建员工
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 备注信息
	 */
	@Column(name = "RESULT_MESSAGE")
	private String resultMessage;

	/**
	 * 处理次数
	 */
	@Column(name = "RESPONSER")
	private String responser;

	/**
	 * 下次处理时间
	 */
	@Column(name = "RSP_DATE")
	private Timestamp rspDate;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 修改日期
	 */
	@Column(name = "REQ_TRAN_ID")
	private String reqTranId;

	/**
	 * 错误信息
	 */
	@Column(name = "RESULT")
	private Long result;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 记录状态时间。
	 */
	@Column(name = "SERVICE_CD")
	private String serviceCd;

	/**
	 * 同步外系统编码
	 */
	@Column(name = "REQUESTER")
	private String requester;

	/**
	 * 记录创建时间。
	 */
	@Column(name = "METHOD_NAME")
	private String methodName;

	/**
	 * 本地网标识
	 */
	@Column(name = "SERVER_MSG")
	private String serverMsg;

	/**
	 * 
	 */
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * P单号
	 */
	@Column(name = "MSG_TYPE")
	private String msgType;

	/**
	 * 业务类型
	 */
	@Column(name = "REQ_DATE")
	private Timestamp reqDate;

	/**
	 * 
	 */
	@Column(name = "TENANT_ID")
	private Long tenantId;

	/**
	 * 记录状态CD。
	 */
	@Column(name = "RESULT_CD")
	private String resultCd;

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


	public void setCasIntfLogRecId(Long casIntfLogRecId){
		this.casIntfLogRecId = casIntfLogRecId;
	}

	public Long getCasIntfLogRecId(){
		return this.casIntfLogRecId;
	}

	public void setRspTranId(String rspTranId){
		this.rspTranId = rspTranId;
	}

	public String getRspTranId(){
		return this.rspTranId;
	}

	public void setConsumeTimestamp(Long consumeTimestamp){
		this.consumeTimestamp = consumeTimestamp;
	}

	public Long getConsumeTimestamp(){
		return this.consumeTimestamp;
	}

	@Override
	public Long getAreaId() {
		return null;
	}

	@Override
	public void setAreaId(Long areaId) {

	}

	@Override
	public void setRegionCd(Long regionCd) {

	}

	@Override
	public Long getRegionCd() {
		return null;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setClientMsg(String clientMsg){
		this.clientMsg = clientMsg;
	}

	public String getClientMsg(){
		return this.clientMsg;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setResultMessage(String resultMessage){
		this.resultMessage = resultMessage;
	}

	public String getResultMessage(){
		return this.resultMessage;
	}

	public void setResponser(String responser){
		this.responser = responser;
	}

	public String getResponser(){
		return this.responser;
	}

	public void setRspDate(Timestamp rspDate){
		this.rspDate = rspDate;
	}

	public Timestamp getRspDate(){
		return this.rspDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setReqTranId(String reqTranId){
		this.reqTranId = reqTranId;
	}

	public String getReqTranId(){
		return this.reqTranId;
	}

	public void setResult(Long result){
		this.result = result;
	}

	public Long getResult(){
		return this.result;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setServiceCd(String serviceCd){
		this.serviceCd = serviceCd;
	}

	public String getServiceCd(){
		return this.serviceCd;
	}

	public void setRequester(String requester){
		this.requester = requester;
	}

	public String getRequester(){
		return this.requester;
	}

	public void setMethodName(String methodName){
		this.methodName = methodName;
	}

	public String getMethodName(){
		return this.methodName;
	}

	public void setServerMsg(String serverMsg){
		this.serverMsg = serverMsg;
	}

	public String getServerMsg(){
		return this.serverMsg;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setMsgType(String msgType){
		this.msgType = msgType;
	}

	public String getMsgType(){
		return this.msgType;
	}

	public void setReqDate(Timestamp reqDate){
		this.reqDate = reqDate;
	}

	public Timestamp getReqDate(){
		return this.reqDate;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
	}

	public void setResultCd(String resultCd){
		this.resultCd = resultCd;
	}

	public String getResultCd(){
		return this.resultCd;
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
		return casIntfLogRecId;
	}

	public void setId(Long id) {
		this.casIntfLogRecId = id;
	}
	
	public CasIntfLogRec() {
		super();
    }

    public CasIntfLogRec(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static ICasIntfLogRecRepository repository() {
		return (ICasIntfLogRecRepository) RepositoryRegister.getInstance()
				.getRepository(CasIntfLogRec.class);
	}
	
}
