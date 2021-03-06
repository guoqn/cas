package com.ffcs.crmd.cas.intf.api.facade;

import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.intf.api.dto.SendMessageInDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/19
 * @功能说明：
 */
public interface ICasToSmsFacade extends ICrmdBaseFacade {
    /**
     * 短信发送。
     * @param inParam
     * @return
     */
    RetVo sendMessage(SendMessageInDTO inParam);
}
