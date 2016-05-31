package com.ffcs.crmd.cas.intf.facade;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo;
import com.ffcs.crmd.cas.intf.api.facade.ICasFacade;
import com.ffcs.crmd.cas.intf.api.facade.ICasToCrmFacade;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Writer;
import java.util.Date;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/2/16
 * @功能说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/spring/applicationContext*.xml",
        "classpath*:conf/spring/**/applicationContext*.xml"})
public class CasFacadeImplTest {
//    @Autowired
    ICasFacade casFacade;

    @Autowired
    private ICasToCrmFacade casToCrmFacade;


    @Test
    public void saveAutoGenOrder() {
        com.ffcs.crmd.cas.bean.casbean.autogenordersave.Root root = new com.ffcs.crmd.cas.bean.casbean.autogenordersave.Root();
        com.ffcs.crmd.cas.bean.casbean.comm.MsgHead msgHead = null;
        com.ffcs.crmd.cas.bean.casbean.autogenordersave.MsgBody msgBody = new com.ffcs.crmd.cas.bean.casbean.autogenordersave.MsgBody();

        com.ffcs.crmd.cas.bean.casbean.autogenordersave.InParam inParam = new com.ffcs.crmd.cas.bean.casbean.autogenordersave.InParam();
        com.ffcs.crmd.cas.bean.casbean.autogenordersave.AutoGenOrder autoGenOrder = new com.ffcs.crmd.cas.bean.casbean.autogenordersave.AutoGenOrder();
        msgHead = getReqMsgHeadByMsgType("saveAutoGenOrder");
        root.setMsgHead(msgHead);

        autoGenOrder.setPreOrderNumber("P201512220084325");
        autoGenOrder.setSceneType("112");
        autoGenOrder.setSceneFlag("");
        autoGenOrder.setProdOfferId("901525928");
        autoGenOrder.setAccNbr("201512221");
        autoGenOrder.setCustId("5146750286");
        autoGenOrder.setShardingId("3065705");
        autoGenOrder.setXmlMsg("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root><msgHead><time>20151222112430</time><from>CRM</from><to>PK</to><sysSign>CRM</sysSign><msgType>autoGenOrder</msgType><serial>20151222003143354780</serial></msgHead><msgBody><inParam><login><preSaleOrder>P201512220084325-N</preSaleOrder><custIdentityNum>2591631744820000</custIdentityNum><custAreaId>8350100</custAreaId><custAreaName>福州地区</custAreaName></login><cust><certType>1</certType><certTypeName>身份证</certTypeName><certNumber>350823198808184223</certNumber></cust><product><baseOfferName>乐享4G201407 229元-主套餐</baseOfferName><accNbr>201512221</accNbr><uim>8986111410591002341</uim><payment><paymentModeCd>2100</paymentModeCd><paymentModeName>预付费</paymentModeName></payment></product><customerOrder><devStaffCode>fztangml</devStaffCode><devOrgName>中国电信福州枢纽营业厅</devOrgName><remark></remark><preFeeAmount>0</preFeeAmount></customerOrder></inParam></msgBody></root>");
        autoGenOrder.setStatusCd("1299");

        inParam.setAutoGenOrder(autoGenOrder);
        msgBody.setInParam(inParam);
        root.setMsgBody(msgBody);
        String outxml = "";
        try {
            final Writer w = new java.io.StringWriter();
            org.exolab.castor.xml.Marshaller.marshal(root, w);
            final String inXml = ToGb2312.delNameSpace(w.toString());
//            outxml = casFacade.saveAutoGenOrder(inXml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + outxml);
    }

    @Test
    public void autoGenOrderComplete() {
        String inXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <msgHead>\n" +
                "        <from>PK</from>\n" +
                "        <msgType>autoGenOrderComplete</msgType>\n" +
                "        <serial>P201512220084325-N</serial>\n" +
                "        <sysSign>PK</sysSign>\n" +
                "        <time>20151222113144</time>\n" +
                "        <to>CRM</to>\n" +
                "    </msgHead>\n" +
                "<msgBody><inParam><preSaleOrder>P201512220084325-N</preSaleOrder><autoGenResult>N</autoGenResult><resultDesc>错误信息未定义,失败脚本为：null,界面错误信息：所填的费用不符合要求！传入费用为：0</resultDesc><errCode>Err-000</errCode></inParam></msgBody></root>";
        try {
//            String outXml = casFacade.autoGenOrderComplete(inXml);
//            System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + outXml);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryParty() {
        String inXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root><msgHead><time>20160331204722</time><from>CAS</from><to>CRM</to><sysSign></sysSign><msgType>queryParty</msgType><serial>20160331204722814</serial></msgHead><msgBody><inParam><CustId>2598899119</CustId></inParam></msgBody></root>";
        String[] custList = new String[2];
        custList[0] = "2598899119";
        custList[1] = "2598899119";
        RetVo retVo = casToCrmFacade.qryCustInfo(custList,"1");
        if (retVo.getResult()) {
            PartyContactInfo[] partyContactInfos = (PartyContactInfo[]) retVo.getObject();
            for (int i = 0; i < partyContactInfos.length; i++) {
                System.out.println(partyContactInfos[i].getObjId());
                System.out.println(partyContactInfos[i].getMobilePhone());
                System.out.println(partyContactInfos[i].getOfficePhone());
                System.out.println(partyContactInfos[i].getHomePhone());
            }
            System.out.println(JSON.toJSON(partyContactInfos));
        }
    }

    /**
     * test数量
     */
    @Test
    public void testPreOrdreCount() throws Exception {
        String inXml ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Root>\n" +
                "\t<msgHead>\n" +
                "\t\t<time>20151228162740</time>\n" +
                "\t\t<from>600105A070</from>\n" +
                "\t\t<to>CRM</to>\n" +
                "\t\t<sysSign>600105A070</sysSign>\n" +
                "\t\t<msgType>preSaleOrderCount</msgType>\n" +
                "\t\t<serial>20151228000000600019</serial>\n" +
                "\t</msgHead>\n" +
                "\t<msgBody>\n" +
                "\t\t<inParam>\n" +
                "\t\t\t<saleStaffId/>\n" +
                "\t\t\t<saleOrgId>50043</saleOrgId>\n" +
                "\t\t\t<beginDate>2015-12-28 18:00:00</beginDate>\n" +
                "\t\t\t<endDate>2016-02-11 18:00:00</endDate>\n" +
                "\t\t\t<currentPage>1</currentPage>\n" +
                "\t\t\t<perPageNum>4</perPageNum>\n" +
                "\t\t</inParam>\n" +
                "\t</msgBody>\n" +
                "</Root>\n";
        String outXml = casFacade.preSaleOrderCount(inXml);
        System.out.println(outXml);
    }

    /**
     * 报文头部拼装处理。
     *
     * @param msgType
     * @return
     */
    public com.ffcs.crmd.cas.bean.casbean.comm.MsgHead getReqMsgHeadByMsgType(String msgType) {
        final com.ffcs.crmd.cas.bean.casbean.comm.MsgHead head = new com.ffcs.crmd.cas.bean.casbean.comm.MsgHead();
        head.setFrom("CRM");
        head.setTo("CAS");
        head.setSysSign("");
        head.setSerial(TransUtil.getTransId());
        head.setMsgType(msgType);
        final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
        head.setTime(time);
        return head;
    }

    @Test
    public void testNoticeToDealOrder() {
        RetVo retVo = casToCrmFacade.noticeToDealOrder(1074948110L, "1");
        System.out.println(JSON.toJSON(retVo));
    }

}
