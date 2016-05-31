package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.intf.api.dto.QueryPreOrderStatusInDTO;
import com.ffcs.crmd.cas.intf.api.dto.QueryPreOrderStatusOutDTO;
import com.ffcs.crmd.cas.order.api.dto.IntfPreOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.OrderOverTimeStatDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderFacade;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderProcFacade;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderItemService;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YULIYAO on 2016/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml" })
public class PreSaleOrderFacadeImplTest {

    @Autowired
    private IPreSaleOrderFacade preSaleOrderFacade;

    @Autowired
    private IPreSaleOrderProcFacade preSaleOrderProcFacade;

    @Autowired
    private IPreSaleOrderItemService preSaleOrderItemService;

    @Test
    public void testQueryPreSaleOrder() {
        PreSaleOrderVo vo = new PreSaleOrderVo();
        vo.setPreOrderNumber("P201403310009650");
        /*vo.setBeginTime("2013-03-26");
        vo.setEndTime("2013-03-27");*/
        List<Long> commonRegionIds = new ArrayList<>();
        commonRegionIds.add(7L);
        commonRegionIds.add(8L);
        commonRegionIds.add(9L);
        commonRegionIds.add(11L);
        commonRegionIds.add(25L);
        vo.setCommmonRegionIds(commonRegionIds);
        vo.setStaffId(49822L);
        vo.setOrgId(50043L);
        vo.setPageSize(10);
//        vo.setStatusCd("300000");
        Date first = new Date();
        System.out.println(first);
        PageInfo pageInfo = preSaleOrderFacade.queryPreSaleOrder(vo);
        Date second = new Date();
        System.out.println(DateUtils.calculateDateDiff(second,first));
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testQueryPreSaleOrderProcPage() {
        PreSaleOrderProcDTO dto = new PreSaleOrderProcDTO();
        dto.setPreOrderId(1L);
        PageInfo pageInfo = preSaleOrderProcFacade.queryPreSaleOrderProcPage(dto,1,10);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testReFee() {
        List<AttrValueDTO> attrValues = new ArrayList<>();
        AttrValueDTO attrValueDTO = new AttrValueDTO();
        attrValueDTO.setAttrId(950001638L);
        attrValueDTO.setAttrValue("80000");
        AttrValueDTO attrValueDTO1 = new AttrValueDTO();
        attrValueDTO1.setAttrId(950001639L);
        attrValueDTO1.setAttrValue("90000");
        attrValues.add(attrValueDTO);
        attrValues.add(attrValueDTO1);
        preSaleOrderFacade.reFee(1L,attrValues);
    }

    @Test
    public void testCheckHasYZFPreFee() {
        PreSaleOrderDTO preSaleOrderDTO = new PreSaleOrderDTO();
        preSaleOrderDTO.setPreOrderId(6866079L);
        preSaleOrderDTO.setStaffId(7010734L);
        preSaleOrderDTO.setCustId(36983563L);
//        preSaleOrderDTO.setPreOrderNumber("P201510090020081");
        preSaleOrderDTO.setPreOrderNumber("P201601184268162");
        preSaleOrderDTO.setSceneType("106");
        preSaleOrderDTO.setOrderType("102");
        preSaleOrderDTO.setOrderFrom("600105A070");
        preSaleOrderDTO.setExtCustOrderId(998243670L);
//        boolean result = preSaleOrderFacade.checkHasYZFPreFee(preSaleOrderDTO);
//        System.out.println(result);
    }

    @Test
    public void testCallIntfPreFeeQuery() {
        String preOrderNumber = "P201403310009650";
        Long orgId = 72099L;
        Long staffPositionId = 0L;
        preSaleOrderFacade.callIntfPreFeeQuery(preOrderNumber,orgId,staffPositionId);
    }

    @Test
    public void testCancel() {
        PreSaleOrderVo vo = new PreSaleOrderVo();
        vo.setPreOrderId(130L);
        vo.setCancelReason("撤销不需要原因");
        vo.setOrgId(50086L);
        AttrValueDTO attrValueDTO = new AttrValueDTO();
        attrValueDTO.setAttrId(950022696L);
        attrValueDTO.setAttrValue("A01_不符合业务办理规则");
        attrValueDTO.setAttrValueId(950021553L);
        vo.setAttrValueDTO(attrValueDTO);
        preSaleOrderFacade.cancel(vo);
    }

    @Test
    public void testRemoveItem() {
        preSaleOrderItemService.removeItemByOrderId(40L,40L);
    }

    @Test
    public void testQeryPreOrderStatus() {
        QueryPreOrderStatusInDTO dto = new QueryPreOrderStatusInDTO();
        dto.setPreOrderNumber("P201504030055216");
        QueryPreOrderStatusOutDTO outDto = preSaleOrderFacade.queryPreOrderStatus(dto);
        System.out.println(JSON.toJSON(outDto));
    }

    @Test
    public void testQeryPreOrderStatusHis() {
        QueryPreOrderStatusInDTO dto = new QueryPreOrderStatusInDTO();
        dto.setPreOrderNumber("P201504290063112");
        QueryPreOrderStatusOutDTO outDto = preSaleOrderFacade.queryPreOrderStatus(dto);
        System.out.println(JSON.toJSON(outDto));
    }

    @Test
    public void testPay() {
        PreSaleOrderDTO preSaleOrderDTO = new PreSaleOrderDTO();
        preSaleOrderDTO.setPreOrderId(6866079L);
        preSaleOrderDTO.setStaffId(7010734L);
        preSaleOrderDTO.setCustId(36983563L);
        //        preSaleOrderDTO.setPreOrderNumber("P201510090020081");
        preSaleOrderDTO.setPreOrderNumber("P201601184268162");
        preSaleOrderDTO.setSceneType("106");
        preSaleOrderDTO.setOrderType("102");
        preSaleOrderDTO.setOrderFrom("600105A070");
        preSaleOrderDTO.setExtCustOrderId(998243670L);
        RetVo retVo = preSaleOrderFacade.pay(preSaleOrderDTO, 0L, 0L, 1L);
        System.out.println(JSON.toJSON(retVo));
    }

    @Test
    public void testCompletePreOrder() {
        PreSaleOrderDTO preSaleOrderDTO = new PreSaleOrderDTO();
        preSaleOrderDTO.setPreOrderId(1L);
        preSaleOrderDTO.setShardingId(1L);
        preSaleOrderDTO.setStaffId(49822L);
        preSaleOrderDTO.setCustId(28541301L);
        //        preSaleOrderDTO.setPreOrderNumber("P201510090020081");
        preSaleOrderDTO.setPreOrderNumber("P201403310009650");
        preSaleOrderDTO.setSceneType("106");
        preSaleOrderDTO.setOrderType("102");
        preSaleOrderDTO.setOrderFrom("600105A070");
        RetVo retVo = preSaleOrderFacade.completePreOrder(preSaleOrderDTO);
        System.out.println(JSON.toJSON(retVo));
    }

    @Test
    public void testOverTimeOrderSentMsg() {
        List<OrderOverTimeStatDTO> orderOverTimeStatDTOs = preSaleOrderFacade
            .queryOrderOverTimeStat(1, 0);
        System.out.println(JSON.toJSON(orderOverTimeStatDTOs));
    }

    @Test
    public void testQueryIntfOrderWaitSent() {
        List<IntfPreOrderDTO> intfPreOrderDTOs = preSaleOrderFacade
            .queryIntfOrderWaitSent(1, 0, 500);
        System.out.println(JSON.toJSON(intfPreOrderDTOs));

    }

    @Test
    public void testGetFirstPreSaleOrder() {
        PreSaleOrderDTO preSaleOrderDTO = preSaleOrderFacade.getFirstPreSaleOrder("P123412");
        System.out.println(JSON.toJSON(preSaleOrderDTO));
    }

    @Test
    public void testRemovePreOrder() {
        PreSaleOrderDTO preSaleOrderDTO = preSaleOrderFacade.getById(5686L,5686L);
        System.out.println(preSaleOrderFacade.remove(preSaleOrderDTO));
    }

    @Test
    public void testQueryCompleteOrderAuto() {
        List<PreSaleOrderDTO> preSaleOrderDTOs = preSaleOrderFacade
            .queryCompleteOrderAuto(0, 1, 100);
        System.out.println(JSON.toJSON(preSaleOrderDTOs));
    }

    @Test
    public void testQueryReturnList() {
        PageInfo pageInfo = preSaleOrderFacade.queryReturnList(0L, 95393L, 1, 10);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testQueryCompleteGroupOrderAuto() {
        PageInfo pageInfo = preSaleOrderFacade.queryCompleteGroupOrderAuto(0, 1, 100);
        System.out.println(JSON.toJSON(pageInfo));

    }
}
