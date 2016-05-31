package com.ffcs.crmd.cas.sys.api.dto;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.sql.Timestamp;


public class AttrValueDTO extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    private Long attrValueId;

    /**
     * 属性值顺序
     */
    private Short attrValueSeq;

    /**
     *
     */
    private Long regionCd;

    /**
     *
     */
    private String attrDesc;

    /**
     *
     */
    private Long areaId;

    /**
     * 属性规格值格式(正则表达式),用于属性值生成、合法性效验
     */
    private String attrFormat;

    /**
     * 管理级别10集团级，11省级
     */
    private String manageGrade;

    /**
     * 集团属性值编码
     */
    private String groupCd;

    /**
     * 失效时间
     */
    private Timestamp expDate;

    /**
     *
     */
    private String maxValue;

    /**
     *
     */
    private String attrValueName;

    /**
     * 业务对象属性规格业务编码
     */
    private Long attrId;

    /**
     * 是否割接
     */
    private String isTrans;

    /**
     * 生效时间
     */
    private Timestamp effDate;

    /**
     * 上级属性值
     */
    private Long parentValueId;

    /**
     * 记录属性值。
     */
    private String attrValue;

    /**
     * 属性规格值长度
     */
    private Long attrLength;

    /**
     *
     */
    private String attrValueType;

    /**
     *
     */
    private String minValue;

    /**
     * 标识.
     */
    private String id;
    /**
     * 名称.
     */
    private String text;

    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getAttrValueId() {
        return this.attrValueId;
    }

    public void setAttrValueSeq(Short attrValueSeq) {
        this.attrValueSeq = attrValueSeq;
    }

    public Short getAttrValueSeq() {
        return this.attrValueSeq;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    public String getAttrDesc() {
        return this.attrDesc;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setAttrFormat(String attrFormat) {
        this.attrFormat = attrFormat;
    }

    public String getAttrFormat() {
        return this.attrFormat;
    }

    public void setManageGrade(String manageGrade) {
        this.manageGrade = manageGrade;
    }

    public String getManageGrade() {
        return this.manageGrade;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getGroupCd() {
        return this.groupCd;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public Timestamp getExpDate() {
        return this.expDate;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMaxValue() {
        return this.maxValue;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName;
        this.text = attrValueName;
    }

    public String getAttrValueName() {
        return this.attrValueName;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans;
    }

    public String getIsTrans() {
        return this.isTrans;
    }

    public void setEffDate(Timestamp effDate) {
        this.effDate = effDate;
    }

    public Timestamp getEffDate() {
        return this.effDate;
    }

    public void setParentValueId(Long parentValueId) {
        this.parentValueId = parentValueId;
    }

    public Long getParentValueId() {
        return this.parentValueId;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
        this.id = attrValue;
    }

    public String getAttrValue() {
        return this.attrValue;
    }

    public void setAttrLength(Long attrLength) {
        this.attrLength = attrLength;
    }

    public Long getAttrLength() {
        return this.attrLength;
    }

    public void setAttrValueType(String attrValueType) {
        this.attrValueType = attrValueType;
    }

    public String getAttrValueType() {
        return this.attrValueType;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMinValue() {
        return this.minValue;
    }


}
