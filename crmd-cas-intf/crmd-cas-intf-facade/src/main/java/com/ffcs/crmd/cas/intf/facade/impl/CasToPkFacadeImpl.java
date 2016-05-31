package com.ffcs.crmd.cas.intf.facade.impl;

import com.ctg.itrdc.event.utils.Constants;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.bean.smsbean.comm.MsgHead;
import com.ffcs.crmd.cas.bean.smsbean.smpost.InParam;
import com.ffcs.crmd.cas.bean.smsbean.smpost.MsgBody;
import com.ffcs.crmd.cas.bean.smsbean.smpost.Root;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.dto.SendMessageInDTO;
import com.ffcs.crmd.cas.intf.api.dto.SendMessageOutDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICasToPkFacade;
import com.ffcs.crmd.cas.intf.api.facade.ICasToSmsFacade;
import com.ffcs.crmd.cas.intf.facade.client.PkClient;
import com.ffcs.crmd.cas.intf.facade.client.SmsClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

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
@Service("casToPkFacade")
public class CasToPkFacadeImpl implements ICasToPkFacade {
    @Autowired
    private PkClient pkClient;

    @Override
    public RetVo autoGenOrder(String inXml) {
        try {
            RetVo retVO = new RetVo();
            retVO.setResult(true);

            String outXml = pkClient.call("autoGenOrder", inXml);

            final com.ffcs.crmd.cas.bean.casbean.autogenorder.Root respRoot = (com.ffcs.crmd.cas.bean.casbean.autogenorder.Root) Unmarshaller.
                    unmarshal(com.ffcs.crmd.cas.bean.casbean.autogenorder.Root.class,
                            new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
            com.ffcs.crmd.cas.bean.casbean.autogenorder.OutParam outParam = respRoot.getMsgBody().getOutParam();
            if ("1".equals(outParam.getResult()) && outParam.getError() != null) {
                retVO.setResult(false);
                retVO.setMsgTitle(outParam.getError().getMessage());
                return retVO;
            }
            return retVO;
        } catch (Exception e) {
            return WsUtil.getErrorMsg(e);
        }
    }
}
