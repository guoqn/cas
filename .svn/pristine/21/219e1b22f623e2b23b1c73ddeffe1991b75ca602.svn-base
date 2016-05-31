package com.ffcs.crmd.cas.intf.facade.impl;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.bean.padbean.MOBILE_SERVICE_REQ;
import com.ffcs.crmd.cas.bean.padbean.MOBILE_SERVICE_RSP;
import com.ffcs.crmd.cas.bean.padbean.QRY_BODY;
import com.ffcs.crmd.cas.bean.padbean.QRY_TYPE;
import com.ffcs.crmd.cas.bean.padbean.REFLASH_PRE_SALE_ORD_REQ;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.dto.StatusChangeNoticeInDTO;
import com.ffcs.crmd.cas.intf.api.dto.StatusChangeNoticeOutDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICasToPadFacade;
import com.ffcs.crmd.cas.intf.facade.client.O2OClient;
import com.ffcs.crmd.cas.intf.facade.client.PadClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/21
 * @功能说明：
 */
@Service("casToPadFacade")
public class CasToPadFacadeImpl implements ICasToPadFacade {

    @Autowired
    O2OClient o2oClient;
    @Autowired
    PadClient padClient;

    @Override
    public RetVo statusChangeNotice(StatusChangeNoticeInDTO inDTO, String orderFrom) {
        try {
            String msgType = "REFLASH_PRE_SALE_ORD_REQ";
            MOBILE_SERVICE_REQ reqRoot = new MOBILE_SERVICE_REQ();
            // 构造消息头字符串，利用OcsBaseVo的功能，修改To字段
            QRY_TYPE ocsMsgHead = getQryType(msgType);

            // 构造消息体字符串
            QRY_BODY msgBody = new QRY_BODY();
            REFLASH_PRE_SALE_ORD_REQ inParam = new REFLASH_PRE_SALE_ORD_REQ();
            CrmBeanUtils.applyIf(inParam, inDTO);

            msgBody.setREFLASH_PRE_SALE_ORD_REQ(inParam);
            reqRoot.setQRY_BODY(msgBody);
            reqRoot.setQRY_TYPE(ocsMsgHead);
            Writer stringWriter = new StringWriter();
            Marshaller.marshal(reqRoot, stringWriter);
            String inXml = ToGb2312.delNameSpace(stringWriter.toString());

            String outXml = "";
            if (IntfConstant.CHANNEL_CODE_O2O.getValue().equals(orderFrom)) {
                outXml = o2oClient.call(msgType, inXml);
            } else {
                outXml = padClient.call(msgType, inXml);
            }
            RetVo retVo = new RetVo();

            if (outXml == null) {
                retVo.setResult(false);
                retVo.setMsgTitle("移动客户端接口关闭");
                return retVo;
            }
            MOBILE_SERVICE_RSP rspRoot = (MOBILE_SERVICE_RSP) Unmarshaller
                    .unmarshal(MOBILE_SERVICE_RSP.class,
                            new StringReader(outXml));
            
            
            retVo.setResult(true);
            if (IntfConstant.RESULT_FALSE.getValue().equals(rspRoot.getRESULT())) {
            	retVo.setResult(false);
            	retVo.setRetCode(rspRoot.getERROR().getID());
            	retVo.setMsgTitle(rspRoot.getERROR().getMESSAGE());
            } else {
            	StatusChangeNoticeOutDTO outDto = new StatusChangeNoticeOutDTO();
            	CrmBeanUtils.applyIf(outDto,rspRoot);
                retVo.setObject(outDto);
            }
            return retVo;
        } catch (Exception e) {
            return WsUtil.getErrorMsg(e);
        }
    }

    /**
     * 报文头获取。
     * @param Type
     * @return
     */
    public static QRY_TYPE getQryType(String Type) {
        final QRY_TYPE head = new QRY_TYPE();
        head.setTYPE(Type);
        head.setSYSTEM_CODE(IntfConstant.PAD_SYSTEM_CODE.getValue());
        final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
        head.setREQ_TIME(time);
        return head;
    }
}
