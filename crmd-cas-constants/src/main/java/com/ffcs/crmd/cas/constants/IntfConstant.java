package com.ffcs.crmd.cas.constants;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 *
 */
public enum IntfConstant {
    /**
     * 返回成功.
     */
	RESULT_TRUE("0"),
	/**
     * 返回失败.
     */
	RESULT_FALSE("1"),


	/**
	 * 报文中的msgType节点：增量更新
	 */
	MSG_TYPE_INCREMENT_UPDATE("incrementUpdate"),

	/**
	 * 报文中的msgType节点：批量更新
	 */
	MSG_TYPE_BATCH_DATA_UPDATE("batchDataUpdate"),

	/**
	 * 报文中的msgType节点：4G批量更新
	 */
	MSG_TYPE_BATCH_DATA_UPDATE_4G("batchDataUpdate4G"),

	/**
	 * 报文中的msgType节点：自动算费
	 */
	MSG_TYPE_AUTO_ONE_PRICE_CALE("autoOnePriceCalc"),

	/**
	 * HB服务地址配置名
	 */
	HB_PL_WS_URL("HB_PL_WS_URL"),

	/**
	 * HB接口通用方法名
	 */
	WS_METHOD_NAME("executeMethod"),

	/**
	 * result节点
	 */
	XML_NODE_RESULT("result"),

	/**
	 * message节点
	 */
	XML_NODE_MESSAGE("message"),

	/**
	 * 接口RUL专用类.
	 */
	INTF_URL_CLASS("IntfUrlClass"),

	/**
	 * RET_TRUE String.
	 */
	RET_TRUE("TRUE"),

	/**
	 * 预受理缴费缴费方式 -- 翼支付.
	 */
	PRE_FEE_CHARGE_METHOD_YZF("150001"),
	/**
	 * 预受理处理过程交互事件标识 - 销账完成.
	 */
	PRE_PROC_EVENT_ID_PAYED("1001"),

	/**
	 * 预受理处理过程交互事件标识 - 手动撤销.
	 */
	PRE_PROC_EVENT_ID_CANCEL("1002"),

	/**
	 * 退单默认原因id
	 */
	GO_BACK_ATTR_ID("950021560"),
	/**
	 * 退单默认原因
	 */
	GO_BACK_ATTR_VALUE_NAME("Z01"),
	/**
	 * 撤销
	 */
	PRE_SALE_ACCT_ITEM_STATUS_CANCEL("5JD"),
	/**********************工单池记录状态*************************/
	/**
	 * 预受理订单池状态--已接收
	 */
	PRE_POOL_STATUS_CD_ACCEPTED("11000"),
	/**
	 * 预受理订单池状态--已处理
	 */
	PRE_POOL_STATUS_CD_DEALED("12000"),

	/**
	 * 预受理订单池状态--未接收
	 */
	PRE_POOL_STATUS_CD_NOT_ACCEPTED("10000"),
	/**
	 * 预受理工单池状态--锁定
	 */
	PRE_POOL_STATUS_CD_LOCK("13000"),
	PRE_POOL_STATUS_CD_GOBACKED("15000"),
	/**
	 * 自动处理表状态 - 竣工到历史表.
	 */
	AUTO_GEN_ORDER_STATUS_COMPLETE("1200"),
	/**
	 * 自动处理表状态 - 初始化创建.
	 */
	AUTO_GEN_ORDER_STATUS_CREATE("1299"),
	/**********************预受理订单状态*************************/
	/**
	 * 待收费
	 */
	PRE_SALE_ORDER_STATUS_CD_WAIT_FOR_PAY("101200"),
	/**
	 *部分受理(一个P订单关联多个FJ订单，部分FJ受理).
	 */
	PRE_SALE_ORDER_STATUS_CD_PART_DEAL("201400"),
	/**
	 * 待处理
	 */
	PRE_SALE_ORDER_STATUS_CD_WAIT_FOR_DEAL("200099"),
	/**
	 * 预受理
	 */
	PRE_SALE_ORDER_STATUS_CD_PREACCEPT("100098"),
	/**
	 * 处理完成.
	 */
	PRE_SALE_ORDER_STATUS_CD_COMPLETE("300000"),
	/**
	 * 部分竣工.
	 */
	PRE_SALE_ORDER_STATUS_CD_COMPLETING("301400"),
	/**
	 * 退费中
	 */
	PRE_SALE_ORDER_STATUS_CD_BACK_PAYING("401297"),

	/**
	 * 撤销中
	 */
	PRE_SALE_ORDER_STATUS_CD_CANCELING("401299"),

	/**
	 * 撤销竣工
	 */
	PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE("401200"),

	/**
	 * 撤销异常
	 */
	PRE_SALE_ORDER_STATUS_CD_CANCEL_ERROR("400000"),

	/**
	 * 受理异常
	 */
	PRE_SALE_ORDER_STATUS_CD_DEAL_ERROR("400098"),

	/**
	 * 在途（名称变更为“全部受理”）.
	 */
	PRE_SALE_ORDER_STATUS_CD_ON_WAY("200000"),

	/******************移动客户端预受理订单状态********************/
	/**
	 * 移动客户端预受理订单状态--代补缴费（结束状态：订单撤销后的状态（含预受理单取消））
	 */
	MOBI_PRE_ORDER_STATUS_CD_GIVE("200080"),
	/**
	 * 移动客户端预受理订单状态--已收费（客户缴费后的状态（有费用的预受理单，在缴费后转正式单之前））
	 */
	MOBI_PRE_ORDER_STATUS_CD_PAYED("100400"),
	/**
	 * 移动客户端预受理订单状态--已转正（客户完成业务办理（含缴费）后的状态）
	 */
	MOBI_PRE_ORDER_STATUS_CD_CONVERTED("200000"),
	/**
	 * 部分转正.
	 */
	MOBI_PRE_ORDER_STATUS_CD_CONVERTING("200001"),
	/**
	 * 移动客户端预受理订单状态--已竣工（结束状态：订单竣工后的状态）
	 */
	MOBI_PRE_ORDER_STATUS_CD_COMPLETED("300000"),
	/**
	 * 部分竣工.
	 */
	MOBI_PRE_ORDER_STATUS_CD_COMPLETING("300001"),
	/**
	 * 移动客户端预受理订单状态--已撤单（结束状态：订单撤销后的状态（含预受理单取消））
	 */
	MOBI_PRE_ORDER_STATUS_CD_REMOVED("401200"),
	/****************预受理处理过程交互事件标识********************/
	/**
	 *  - 设置为部分受理.
	 */
	PRE_PROC_EVENT_ID_SET_PART("1012"),

	/**
	 * HB服务地址配置名
	 */
	HB_WS_URL("HB_WS_URL"),
	/**
	 * 短厅(SMS) 服务地址配置名.
	 */
	SMS_WS_URL("SMS_WS_URL"),
	/**
	 * 标准接口方法名
	 */
	NOR_WS_METHOD_NAME("exchange"),
	/**
     * 通用接口方法名
     */
	EXECUTE_WS_METHOD_NAME("execute"),
	/**
	 * 短信发送.
	 */
	MSG_TYPE_SM_POST("smPost"),
	/**
	 * O2O平台.
	 */
	O2O_WS_URL("O2O_WS_URL"),
	/**
	 * 移动客户端。
	 */
	MOBILESALE_WS_URL("MOBILESALE_WS_URL"),
	/**
	 * CRM系统。
	 */
	CRM_WS_URL("CRM_WS_URL"),

	/**
	 * 泉州工单池接口服务地址配置名
	 */
	PRE_ORDER_WS_URL("PRE_ORDER_WS_URL"),
	/**
	 * 大数据服务地址配置名
	 */
	CRM_MCSS_WS_URL("CRM_MCSS_WS_URL"),

	/**
	 *移动终端（Pad）系统编码.
	 */
	PAD_SYSTEM_CODE("211"),
	/**
	 * O2O渠道编码.
	 */
	CHANNEL_CODE_O2O("600105A103"),
	/**
	 * 预受理账务处理通知
	 */
	MSG_TYPE_PRE_ANNOUNCE_CHARGE("preAnnounceCharge"),
	/**
	 * 计费预受理缴费界面地址配置名
	 */
	HB_PRE_SALE_PAY_URL("HB_PRE_SALE_PAY_URL"),
	/**
	 * 账务处理通知，处理类型，销帐
	 */
	ANNOUNCE_CHARGE_REQ_TYPE_0("0"),

	/**
	 * 账务处理通知，处理类型，撤销/退款
	 */
	ANNOUNCE_CHARGE_REQ_TYPE_2("2"),

	/**
	 * 账务处理通知，处理类型，补收款
	 */
	ANNOUNCE_CHARGE_REQ_TYPE_3("3"),
	/**
	 * 正常费用
	 */
	PRE_SALE_ACCT_ITEM_TYPE_NORMAL("100"),
	/**
	 * 补收款
	 */
	PRE_SALE_ACCT_ITEM_TYPE_RE_FEE("101"),
	/**
	 * 未销帐
	 */
	PRE_SALE_ACCT_ITEM_STATUS_NO_PAY("5JA"),
	/**
	 * 缴费
	 */
	 PRE_SALE_ACCT_ITEM_STATUS_PAY("5JB"),

	/**
	 * 退费
	 */
	PRE_SALE_ACCT_ITEM_STATUS_REPAY("5JC"),
	/**
	 * 预存费用。
	 */
	PRE_ACCT_ATTR_SPEC_ID("950001638"),
	/**
	 * 普通现金.
	 */
	CASH_ACCT_ATTR_SPEC_ID("950001639"),
	/**
	 * 社采终端款.
	 */
	PRE_RES_ACCT_ATTR_SPEC_ID("950001640"),
	/**
	 * 不打印凭单和发票
	 */
	PRE_SALE_ACCT_ITEM_PRINT_NONE("00A"),

	/**
	 * 打印凭单
	 */
	PRE_SALE_ACCT_ITEM_PRINT_VOUCHER("00B"),

	/**
	 * 打印发票
	 */
	PRE_SALE_ACCT_ITEM_PRINT_INVOICE("00C"),

	/**
	 * 计费端预受理费用未缴费标识.
	 */
	PRE_FEE_STATE_WAIT_FOR_PAY("5SA"),
	/**
	 * 计费端预受理费用已缴费标识或者已支出标识.
	 */
	PRE_FEE_STATE_PAYED("5SB"),
	/**
	 * 接口关闭。
	 */
	INTF_WS_CLOSED("CLOSED"),
	

    /**
     * 接口服务状态-开启.
     */
    INTF_SERVICE_STATUS_OPEN("0"),
    
    /**
     * 接口服务状态-关闭.
     */
    INTF_SERVICE_STATUS_CLOSE("1"),

	/**
	 * 轮询每次处理的记录数.
	 */
	DEFAULT_CIRCLE_PER_SIZE("20"),

	/**
	 * 界面专用类.
	 */
	UI_META_CLASSSNAME("PageClass"),

	/**
	 * 订单轮询每次处理记录数量的attspec的javaCode.
	 */
	ATTR_SPEC_ORDER_DEAL_PER_SIZE("orderDealPerSize"),
	/**
	 * 查询预受理单异常
	 */
	PRE_SALE_ORDER_COUNT_FAIL("1"),
	/**
	 * 查询预受理单报文内容异常
	 */
	ERROR_ID_ABNORMAL_CONNTENT("1"),
	/**
     * 接口服务状态-模拟.
     */
    INTF_SERVICE_STATUS_SIMU("2"),
    /**
     * 退单标签.
     */
    GO_BACK_TAG("goback"),
    GO_BACK_TAG_STAFF_NAME("staffname"),
    GO_BACK_TAG_PHONE_NUMBER("phonenumber"),
    GO_BACK_TAG_REASON("gobackreason"),
    /**
     * 工单接收界面退单.
     */
    PRE_PROC_EVENT_ID_POOL_RET("1008"),
    /**
     * 退单稽核界面退单.
     */
    PRE_PROC_EVENT_ID_AUDIT_RET("1009");


	/**
	 * 常量值.
	 */
	private String value;

	/**
	 * 构造方法.
	 */
	private IntfConstant(String value) {
		this.value = value;
	}

	/**
	 * 获取常量值.
	 */
	public String getValue() {
		return this.value;
	}


	public static IntfConstant getByCode(String code) {
		if (!StringUtils.isNullOrEmpty(code)) {
			IntfConstant[] values = IntfConstant.values();
			for (int i = 0; i < values.length; i++) {
				if (code.equals(values[i].value)) {
					return values[i];
				}
			}
		}
		return null;
	}

}
