package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class AttrSpecDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;


	/**
	 * 属性ID
	 */
	private Long attrId;

	/**
	 * 输入T1,关联T2,选择T3,自动编码属性T4,内存属性T5
	 */
	private String attrType;

	/**
	 * 县局标识
	 */
	private Long regionCd;

	/**
	 * 约束类型
	 */
	private String cnsTypeExtra;

	/**
	 * 唯一性
	 */
	private String isUnique;

	/**
	 * 
	 */
	private String extAttrCd;

	/**
	 * 结束值
	 */
	private String valueTo;

	/**
	 * 属性级别属性级别
	 */
	private String attrLevel;

	/**
	 * 是否可空
	 */
	private String isNullable;

	/**
	 * 属性值格式
	 */
	private String attrFormat;

	/**
	 * 起始值
	 */
	private String valueFrom;

	/**
	 * 编码对应生成类
	 */
	private String codeBuilder;

	/**
	 * 
	 */
	private Short mainmodDisvalid;

	/**
	 * 集团属性编码
	 */
	private String groupCd;

	/**
	 * 是否显示标识，-1--订单申请信息不显示，1--档案查询密码展示明文
	 */
	private String printExt;

	/**
	 * 是否多选值
	 */
	private Short isMultiValue;

	/**
	 * 是否打印
	 */
	private String isPrint;

	/**
	 * 扩展规则标识
	 */
	private String extRuleFlag;

	/**
	 * 
	 */
	private String mainextsoDisvalid;

	/**
	 * 属性顺序
	 */
	private Short attrSeq;

	/**
	 * 跨本地网打标
	 */
	private String extFlag;

	/**
	 * 归属类ID
	 */
	private String attrCd;

	/**
	 * 
	 */
	private String eventProcType;

	/**
	 * 割接状态
	 */
	private String isTrans;

	/**
	 * 公共区域管理标识
	 */
	private Long commonRegionId;

	/**
	 * 是否送计费系统
	 */
	private String hbPost;

	/**
	 * 属性值类型
	 */
	private String attrValueType;

	/**
	 * 竣工是否处理标志
	 */
	private String completeFlag;

	/**
	 * 
	 */
	private String supextsoDisvalid;

	/**
	 * 编码参数
	 */
	private String codeParam1;

	/**
	 * 属性名称
	 */
	private String attrName;

	/**
	 * 与外系统接口统一编码9位59+SEQ不足部分补零
	 */
	private String extAttrNbr;

	/**
	 * 属性描述
	 */
	private String attrDesc;

	/**
	 * 本地网标识
	 */
	private Long areaId;

	/**
	 * 关联类标识
	 */
	private Long refClassId;

	/**
	 * 属性编码规则
	 */
	private String attrSpecCodeRule;

	/**
	 * 管理级别10集团级，11省级
	 */
	private String manageGrade;

	/**
	 * 是否动态属性
	 */
	private Short isDanyAttr;

	/**
	 * 属性格式
	 */
	private String visibleFlag;

	/**
	 * 默认有效期
	 */
	private Long defaultTimePeriod;

	/**
	 * 新增生效方式
	 */
	private String effectiveType;

	/**
	 * 属主系统10CRM，11计费
	 */
	private String ownerSystem;

	/**
	 * 是否允许拷贝
	 */
	private String cnsType;

	/**
	 * 
	 */
	private Short maindelDisvalid;

	/**
	 * JAVA编码
	 */
	private String javaCode;

	/**
	 * 是否实例化
	 */
	private String isInstantiation;

	/**
	 * 变更生效方式
	 */
	private String modEffType;

	/**
	 * 属性长度
	 */
	private Long attrLength;

	/**
	 * 是否送pf系统
	 */
	private Long isPost;

	/**
	 * 默认值
	 */
	private String defaultValue;

	/**
	 * 
	 */
	private Short selfmodDisvalid;

	/**
	 * 属性编码扩展规则
	 */
	private String attrSpecExtRule;

	/**
	 * 归属类ID
	 */
	private Long classId;

	/**
	 * 失效方式
	 */
	private String expireType;


	public void setAttrId(Long attrId){
		this.attrId = attrId;
	}

	public Long getAttrId(){
		return this.attrId;
	}

	public void setAttrType(String attrType){
		this.attrType = attrType;
	}

	public String getAttrType(){
		return this.attrType;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setCnsTypeExtra(String cnsTypeExtra){
		this.cnsTypeExtra = cnsTypeExtra;
	}

	public String getCnsTypeExtra(){
		return this.cnsTypeExtra;
	}

	public void setIsUnique(String isUnique){
		this.isUnique = isUnique;
	}

	public String getIsUnique(){
		return this.isUnique;
	}

	public void setExtAttrCd(String extAttrCd){
		this.extAttrCd = extAttrCd;
	}

	public String getExtAttrCd(){
		return this.extAttrCd;
	}

	public void setValueTo(String valueTo){
		this.valueTo = valueTo;
	}

	public String getValueTo(){
		return this.valueTo;
	}

	public void setAttrLevel(String attrLevel){
		this.attrLevel = attrLevel;
	}

	public String getAttrLevel(){
		return this.attrLevel;
	}

	public void setIsNullable(String isNullable){
		this.isNullable = isNullable;
	}

	public String getIsNullable(){
		return this.isNullable;
	}

	public void setAttrFormat(String attrFormat){
		this.attrFormat = attrFormat;
	}

	public String getAttrFormat(){
		return this.attrFormat;
	}

	public void setValueFrom(String valueFrom){
		this.valueFrom = valueFrom;
	}

	public String getValueFrom(){
		return this.valueFrom;
	}

	public void setCodeBuilder(String codeBuilder){
		this.codeBuilder = codeBuilder;
	}

	public String getCodeBuilder(){
		return this.codeBuilder;
	}

	public void setMainmodDisvalid(Short mainmodDisvalid){
		this.mainmodDisvalid = mainmodDisvalid;
	}

	public Short getMainmodDisvalid(){
		return this.mainmodDisvalid;
	}

	public void setGroupCd(String groupCd){
		this.groupCd = groupCd;
	}

	public String getGroupCd(){
		return this.groupCd;
	}

	public void setPrintExt(String printExt){
		this.printExt = printExt;
	}

	public String getPrintExt(){
		return this.printExt;
	}

	public void setIsMultiValue(Short isMultiValue){
		this.isMultiValue = isMultiValue;
	}

	public Short getIsMultiValue(){
		return this.isMultiValue;
	}

	public void setIsPrint(String isPrint){
		this.isPrint = isPrint;
	}

	public String getIsPrint(){
		return this.isPrint;
	}

	public void setExtRuleFlag(String extRuleFlag){
		this.extRuleFlag = extRuleFlag;
	}

	public String getExtRuleFlag(){
		return this.extRuleFlag;
	}

	public void setMainextsoDisvalid(String mainextsoDisvalid){
		this.mainextsoDisvalid = mainextsoDisvalid;
	}

	public String getMainextsoDisvalid(){
		return this.mainextsoDisvalid;
	}

	public void setAttrSeq(Short attrSeq){
		this.attrSeq = attrSeq;
	}

	public Short getAttrSeq(){
		return this.attrSeq;
	}

	public void setExtFlag(String extFlag){
		this.extFlag = extFlag;
	}

	public String getExtFlag(){
		return this.extFlag;
	}

	public void setAttrCd(String attrCd){
		this.attrCd = attrCd;
	}

	public String getAttrCd(){
		return this.attrCd;
	}

	public void setEventProcType(String eventProcType){
		this.eventProcType = eventProcType;
	}

	public String getEventProcType(){
		return this.eventProcType;
	}

	public void setIsTrans(String isTrans){
		this.isTrans = isTrans;
	}

	public String getIsTrans(){
		return this.isTrans;
	}

	public void setCommonRegionId(Long commonRegionId){
		this.commonRegionId = commonRegionId;
	}

	public Long getCommonRegionId(){
		return this.commonRegionId;
	}

	public void setHbPost(String hbPost){
		this.hbPost = hbPost;
	}

	public String getHbPost(){
		return this.hbPost;
	}

	public void setAttrValueType(String attrValueType){
		this.attrValueType = attrValueType;
	}

	public String getAttrValueType(){
		return this.attrValueType;
	}

	public void setCompleteFlag(String completeFlag){
		this.completeFlag = completeFlag;
	}

	public String getCompleteFlag(){
		return this.completeFlag;
	}

	public void setSupextsoDisvalid(String supextsoDisvalid){
		this.supextsoDisvalid = supextsoDisvalid;
	}

	public String getSupextsoDisvalid(){
		return this.supextsoDisvalid;
	}

	public void setCodeParam1(String codeParam1){
		this.codeParam1 = codeParam1;
	}

	public String getCodeParam1(){
		return this.codeParam1;
	}

	public void setAttrName(String attrName){
		this.attrName = attrName;
	}

	public String getAttrName(){
		return this.attrName;
	}

	public void setExtAttrNbr(String extAttrNbr){
		this.extAttrNbr = extAttrNbr;
	}

	public String getExtAttrNbr(){
		return this.extAttrNbr;
	}

	public void setAttrDesc(String attrDesc){
		this.attrDesc = attrDesc;
	}

	public String getAttrDesc(){
		return this.attrDesc;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setRefClassId(Long refClassId){
		this.refClassId = refClassId;
	}

	public Long getRefClassId(){
		return this.refClassId;
	}

	public void setAttrSpecCodeRule(String attrSpecCodeRule){
		this.attrSpecCodeRule = attrSpecCodeRule;
	}

	public String getAttrSpecCodeRule(){
		return this.attrSpecCodeRule;
	}

	public void setManageGrade(String manageGrade){
		this.manageGrade = manageGrade;
	}

	public String getManageGrade(){
		return this.manageGrade;
	}

	public void setIsDanyAttr(Short isDanyAttr){
		this.isDanyAttr = isDanyAttr;
	}

	public Short getIsDanyAttr(){
		return this.isDanyAttr;
	}

	public void setVisibleFlag(String visibleFlag){
		this.visibleFlag = visibleFlag;
	}

	public String getVisibleFlag(){
		return this.visibleFlag;
	}

	public void setDefaultTimePeriod(Long defaultTimePeriod){
		this.defaultTimePeriod = defaultTimePeriod;
	}

	public Long getDefaultTimePeriod(){
		return this.defaultTimePeriod;
	}

	public void setEffectiveType(String effectiveType){
		this.effectiveType = effectiveType;
	}

	public String getEffectiveType(){
		return this.effectiveType;
	}

	public void setOwnerSystem(String ownerSystem){
		this.ownerSystem = ownerSystem;
	}

	public String getOwnerSystem(){
		return this.ownerSystem;
	}

	public void setCnsType(String cnsType){
		this.cnsType = cnsType;
	}

	public String getCnsType(){
		return this.cnsType;
	}

	public void setMaindelDisvalid(Short maindelDisvalid){
		this.maindelDisvalid = maindelDisvalid;
	}

	public Short getMaindelDisvalid(){
		return this.maindelDisvalid;
	}

	public void setJavaCode(String javaCode){
		this.javaCode = javaCode;
	}

	public String getJavaCode(){
		return this.javaCode;
	}

	public void setIsInstantiation(String isInstantiation){
		this.isInstantiation = isInstantiation;
	}

	public String getIsInstantiation(){
		return this.isInstantiation;
	}

	public void setModEffType(String modEffType){
		this.modEffType = modEffType;
	}

	public String getModEffType(){
		return this.modEffType;
	}

	public void setAttrLength(Long attrLength){
		this.attrLength = attrLength;
	}

	public Long getAttrLength(){
		return this.attrLength;
	}

	public void setIsPost(Long isPost){
		this.isPost = isPost;
	}

	public Long getIsPost(){
		return this.isPost;
	}

	public void setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue;
	}

	public String getDefaultValue(){
		return this.defaultValue;
	}

	public void setSelfmodDisvalid(Short selfmodDisvalid){
		this.selfmodDisvalid = selfmodDisvalid;
	}

	public Short getSelfmodDisvalid(){
		return this.selfmodDisvalid;
	}

	public void setAttrSpecExtRule(String attrSpecExtRule){
		this.attrSpecExtRule = attrSpecExtRule;
	}

	public String getAttrSpecExtRule(){
		return this.attrSpecExtRule;
	}

	public void setClassId(Long classId){
		this.classId = classId;
	}

	public Long getClassId(){
		return this.classId;
	}

	public void setExpireType(String expireType){
		this.expireType = expireType;
	}

	public String getExpireType(){
		return this.expireType;
	}


}
