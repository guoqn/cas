package com.ffcs.crmd.cas.constants;

/**
 * 公共枚举常量类.
 *
 * @author huangchuanmao 2015-11-04
 */
/**
 * 功能说明:
 *
 * @author LAIYONGMIN
 * 
 * @Date 2015年12月1日 下午7:32:18
 *
 *
 *       版本号 | 作者 | 修改时间 | 修改内容
 *
 */
public enum PubConstant {
	/**
	 * 状态-有效.
	 */
	STATUS_CD_VAILID("1000"),

	/**
	 * 状态-无效.
	 */
	STATUS_CD_INVAILID("1100"),

	/**
	 * 状态-新增.
	 */
	CREATE("1299"),

	/**
	 * 区域-福建省.
	 */
	COMMON_REGION_ID_FJ("1"),

	/**
	 * PRODUCT-产品功能分类：接入类产品
	 */
	PROD_FUNC_TYPE_101("101", "接入类产品"),
	/**
	 * PRODUCT-产品功能分类：功能类产品
	 */
	PROD_FUNC_TYPE_102("102", "功能类产品"),

	/**
	 * PRODUCT-产品规格标识：移动语音
	 */
	PRODUCT_ID_800000002("800000002", "移动语音"),

	IBS_OFFER_TYPE_10010("10010", "单接入类销售品"),

	RET_RESULT_SUCCESS("0", "成功"),

	RET_RESULT_FAIL("1", "失败"),
	/**
	 * PROD_OFFER-销售品分类：基础销售品
	 */
	OFFER_TYPE_10("10", "基础销售品"),
	/**
	 * PROD_OFFER-销售品分类：套餐销售品
	 */
	OFFER_TYPE_11("11", "套餐销售品"),
	/**
	 * PROD_OFFER-销售品分类：可选包销售品
	 */
	OFFER_TYPE_12("12", "可选包"),
	/**
	 * PROD_OFFER-销售品分类：促销销售品
	 */
	OFFER_TYPE_13("13", "促销"),
	/**
	 * PROD_OFFER-销售品子类：接入类基础销售品
	 */
	OFFER_SUB_TYPE_T01("T01", "接入类基础销售品"),
	/**
	 * PROD_OFFER-销售品子类：功能类基础销售品
	 */
	OFFER_SUB_TYPE_T02("T02", "功能类基础销售品"),
	/**
	 * PROD_OFFER-销售品子类：可选类销售品
	 */
	OFFER_SUB_TYPE_T04("T04", "可选类销售品"),
	/**
	 * PROD_OFFER-销售品子类：可选群组类销售品
	 */
	OFFER_SUB_TYPE_T05("T05", "可选群组类销售品"),
	/**
	 * ATTR_SPEC-属性类型：输入型
	 */
	ATTR_TYPE_T1("T1", "输入型"),
	/**
	 * ATTR_SPEC-属性类型：关联型
	 */
	ATTR_TYPE_T2("T2", "关联型"),
	/**
	 * ATTR_SPEC-属性类型：选择型
	 */
	ATTR_TYPE_T3("T3", "选择型"),
	/**
	 * PROD_INST_ATTR：产品实例属性：短号
	 */
	ATTR_ID_800000566("800000566", "短号"),
	/**
	 * PROD_OFFER_INST_ATTR：销售品实例属性：备注
	 */
	ATTR_ID_800015094("800015094", "备注"),
	/**
	 * PRODUCT_RELATION-产品关系：关系类型
	 */
	RELATION_TYPE_CD_100690("100690", "组合关联程控"),

	/**
	 * 接入类产品
	 */
	PROD_FUN_CD_ACCESS("101", "接入类产品"),

	/**
	 * 禁止选择
	 */
	OFFER_PRODUCT_REL_RULE_TYPE_FORBID("13", "禁止选择"),

	OP_TYPE_10("10", "新装"),

	COMPLETE_FLAG_NO_SAVE("P", "一次性属性"),

	PASSWORD("******", "密文格式"),

	/**
	 * attrSpec表中的isPrint字段打印标志-不打印.
	 */
	PRINT_FLAG_NO_PRINT("0"),

	/**
	 * attrSpec表中的isPrint字段打印标志-打印.
	 */
	PRINT_FLAG_PRINT("1"),

	/**
	 * attrSpec表中的isPrint字段打印标志-暗码打印.
	 */
	PRINT_FLAG_PASSWORD("2"),

	/**
	 * attrSpec表中的isPrint字段打印标志-勾选框打印.
	 */
	PRINT_FLAG_CHECK_BOX("3"),

	/**
	 * attrSpec表中的isPrint字段月使用费标志.
	 */
	PRINT_FLAG_MONEY("4"),

	/**
	 * attrSpec表中的isPrint字段折扣标志.
	 */
	PRINT_FLAG_DISCOUNT("5"),

	/**
	 * attrSpec表中的isPrint字段可逆密码标志.
	 */
	PRINT_FLAG_BACK_PASSWORD("6"),

	/**
	 * attrSpec表中的isPrint字段分钟标志
	 */
	PRINT_FLAG_MINUTE("7"),

	/**
	 * 多值属性，取值分割符.
	 */
	ATTR_VALUES_SEPARATOR("&%#&"),

	/**
	 * 银行账号虚拟类class_id.
	 */
	OFFER_BANK_ACCOUNT_CLASS_ID("2001"),

	PUB_TEST("", ""),

	SPLIT_SEPERATOR("_"),
	/**
	 * 确认当前登陆CRM2的地址
	 */
	CRM2_URL("CRM2_URL"),
	/**
	 * attrSpec表中print_ext字段
	 */
	ATTR_SPEC_PRINT_EXT_1("1");

	/**
	 * 常量值.
	 */
	private String value;

	private String name;

	/**
	 * 构造方法.
	 */
	private PubConstant(String value) {
		this.value = value;
	}

	/**
	 * 构造方法.
	 */
	private PubConstant(String value, String name) {
		this.value = value;
		this.name = name;
	}

	/**
	 * 获取常量值.
	 */
	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
