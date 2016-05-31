package com.ffcs.crmd.cas.intf.api.facade;

import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.intf.api.dto.PreAnnounceChargeInDTO;
import com.ffcs.crmd.cas.intf.api.dto.PreFeeQueryInDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

public interface ICrmdToHbFacade extends ICrmdBaseFacade {
	/**
	 * 预受理费用信息查询
	 * @param inParam
	 * @return 2015-11-2 LINGUANGHAO
	 */
	RetVo preFeeQuery(PreFeeQueryInDTO inParam);

	/**
	 * 账务处理通知.
	 * @param inDto
	 * @param reqType
     * @return
     */
	RetVo announceCharge(PreAnnounceChargeInDTO inDto, Long reqType);

	/**
	 * 预受理订单撤销。
	 * @param inParam
	 * @return
     */
	RetVo preFeeCancel(com.ffcs.crmd.cas.bean.hbbean.prefeecancel.InParam inParam);
}
