package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.order.api.dto.AutoAssignDTO;
import com.ffcs.crmd.cas.order.api.dto.CustomerOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolAmountDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderPoolFacade;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
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
@ContextConfiguration(locations = {"classpath*:conf/spring/applicationContext*.xml",
        "classpath*:conf/spring/applicationContext*.xml"})
public class PreSaleOrderPoolFacadeImplTest {

    {
        String initOrg = "{\"c4AssignOrg\":[11],\"c3AssignOrg\":[1],\"notInC3AssignOrg\":[],\"notInC4AssignOrg\":[11],\"notInOrgAssignOrg\":[217128,217128],\"orgAssignOrg\":[217128],\"sceneTypes\":[]}";
        acrossOrgDTO = JSONUtils.jsonToObject(initOrg, AcrossOrgDTO.class);
    }
    @Autowired
    private IPreSaleOrderPoolFacade preSaleOrderPoolFacade;

    private AcrossOrgDTO acrossOrgDTO;


    @Test
    public void testSavePreSaleOrderPoolAccept() {
        PreSaleOrderPoolDTO preSaleOrderPoolDTO = new PreSaleOrderPoolDTO();
        preSaleOrderPoolDTO.setSceneType("106");
        preSaleOrderPoolDTO.setVersion(0L);
        preSaleOrderPoolDTO.setPreSaleOrderPoolId(330714L);
        preSaleOrderPoolDTO.setCreateStaff(49822L);
        preSaleOrderPoolDTO.setRegionCd(623L);
        preSaleOrderPoolDTO.setAreaId(2L);
        preSaleOrderPoolDTO.setStatusDate(DateUtils.dateToTimestamp(new Date()));
        preSaleOrderPoolDTO.setCreateDate(DateUtils.dateToTimestamp(new Date()));
        preSaleOrderPoolDTO.setShardingId(3066233L);
        preSaleOrderPoolDTO.setPreOrderId(3066233L);
        preSaleOrderPoolDTO.setCustOrderId(695761757L);
        preSaleOrderPoolDTO.setStaffId(51201L);
        preSaleOrderPoolDTO.setOrgId(50043L);
        preSaleOrderPoolDTO.setIsLeaderAssign("1");
        preSaleOrderPoolDTO.setStatusCd(IntfConstant.PRE_POOL_STATUS_CD_ACCEPTED.getValue());
        int result = preSaleOrderPoolFacade.savePreSaleOrderPoolAccept(preSaleOrderPoolDTO);
        System.out.println(JSON.toJSON(result));
    }

    @Test
    public void testCompletePool() {
        PreSaleOrderPoolDTO preSaleOrderPoolDTO = preSaleOrderPoolFacade.getByPreOrderId(6695162L);
        boolean result = preSaleOrderPoolFacade.completePool(preSaleOrderPoolDTO);
        System.out.println(result);

    }

    @Test
    public void testQueryPreSaleOrderPool() {
        PreSaleOrderPoolDTO dto = new PreSaleOrderPoolDTO();
        //        dto.setPreOrderNbr("P201310220005672"); //预受理单号
        dto.setPageNumber(1);
        dto.setPageSize(10);
//        dto.setServiceType("101");
//        dto.setPreOrderSrc("1200001");
        dto.setCustSoNumber("FJ20131112425596251");
        PageInfo pageInfo = preSaleOrderPoolFacade
            .queryPreSaleOrderPool(dto, 2L, 50043L, acrossOrgDTO);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testQueryPreSaleOrderPoolAmount() {
        Long areaId = 2L;
        Long orgId = 50043L;
        PreSaleOrderPoolAmountDTO amountDTO = preSaleOrderPoolFacade
                .queryPreSaleOrderPoolAmount(acrossOrgDTO);
        System.out.println(JSON.toJSON(amountDTO));
    }

    @Test
    public void testGetPreSaleOrderPoolAmount() {
        PreSaleOrderPoolDTO dto = new PreSaleOrderPoolDTO();
        dto.setStatusCd(CasConstant.PRE_POOL_STATUS_CD_NOT_ACCEPTED.getValue());
        List<String> sceneTypes = new ArrayList<>();
        sceneTypes.add("101");
        sceneTypes.add("102");
        sceneTypes.add("103");
        sceneTypes.add("104");
        sceneTypes.add("105");
        sceneTypes.add("106");
        sceneTypes.add("107");
        sceneTypes.add("108");
        sceneTypes.add("109");
        sceneTypes.add("110");
        dto.setSceneTypeList(sceneTypes);
        Long areaId = 2L;
        Long orgId = 50043L;
        int amount = preSaleOrderPoolFacade.getPreSaleOrderPoolAmount(dto, acrossOrgDTO);
        System.out.println(amount);
    }

    @Test
    public void testQueryPreSaleOrderPoolReceiveAmount() {
        PreSaleOrderPoolDTO dto = new PreSaleOrderPoolDTO();
        dto.setStatusCd(CasConstant.PRE_POOL_STATUS_CD_NOT_ACCEPTED.getValue());
        List<String> sceneTypes = new ArrayList<>();
        sceneTypes.add("101");
        sceneTypes.add("102");
        sceneTypes.add("103");
        sceneTypes.add("104");
        sceneTypes.add("105");
        sceneTypes.add("106");
        sceneTypes.add("107");
        sceneTypes.add("108");
        sceneTypes.add("109");
        sceneTypes.add("110");
        dto.setSceneTypeList(sceneTypes);
        Long areaId = 2L;
        Long orgId = 50043L;
        Long staffId = 51186L;
        PreSaleOrderPoolAmountDTO amountDTO = preSaleOrderPoolFacade
                .queryPreSaleOrderPoolReceiveAmount(acrossOrgDTO, orgId, staffId);
        System.out.println(JSON.toJSON(amountDTO));
    }

    @Test
    public void testQueryCustomerOrder() {
        List<CustomerOrderDTO> customerOrderDTOs = preSaleOrderPoolFacade.queryCustomerOrder("P0000000124");
        System.out.println(JSON.toJSON(customerOrderDTOs));
    }

    @Test
    public void testGoBack() {
        PreSaleOrderPoolDTO preSaleOrderPoolDTO = new PreSaleOrderPoolDTO();
        String staffName = "阮航";
        String staffPhone = "18350027124";
        String backReason = "A01_不符合业务办理规则";
        preSaleOrderPoolDTO.setPreOrderNbr("P0000000124");
        preSaleOrderPoolDTO.setPreSaleOrderPoolId(973L);
        preSaleOrderPoolDTO.setPreOrderId(1960L);
        preSaleOrderPoolDTO.setShardingId(1960L);
        AttrValueDTO attrValueDTO = new AttrValueDTO();
        attrValueDTO.setAttrValueId(950021553L);
        attrValueDTO.setAttrId(950022696L);
        attrValueDTO.setAttrValue("A01");
        String result = preSaleOrderPoolFacade
                .goBack(preSaleOrderPoolDTO,attrValueDTO, staffName, staffPhone, backReason);
        System.out.println(result);
    }

    @Test
    public void testAcceptOrder() {
        Long staffId = 49822L;
        Long orgId = 50043L;
        Long areaId = 2L;
        boolean result = preSaleOrderPoolFacade.acceptOrder(staffId, orgId, areaId,acrossOrgDTO);
        System.out.println(result);
    }

    @Test
    public void testContinueAccept() {
        Long custOrderId = 149513131L;
        String url = preSaleOrderPoolFacade.continueAccept(custOrderId);
        System.out.println(url);
    }

    @Test
    public void testQryPreOrderDistribute() {
        Long staffId = 49822L;
        Long areaId = 2L;
        Long orgId = 50043L;
        List<AutoAssignDTO> autoAssignDTOs =
            preSaleOrderPoolFacade.qryPreOrderDistribute(staffId);
        System.out.println(JSON.toJSON(autoAssignDTOs));
    }

    @Test
    public void testGetAcrossOrgInit() {
        Long areaId = 3L;
        Long orgId = 70233L;
        AcrossOrgDTO acrossOrgDTO = preSaleOrderPoolFacade.getAcrossOrgInit(areaId, orgId);
        System.out.println(JSON.toJSON(acrossOrgDTO));

    }

    @Test
    public void testQueryInitPoolRegion() {
        String initOrg = "{\"c4AssignOrg\":[11],\"c3AssignOrg\":[1],\"notInC3AssignOrg\":[],\"notInC4AssignOrg\":[11],\"notInOrgAssignOrg\":[217128,217128],\"orgAssignOrg\":[217128],\"sceneTypes\":[]}";
        AcrossOrgDTO acrossOrgDTO = JSONUtils.jsonToObject(initOrg, AcrossOrgDTO.class);
        PageInfo pageInfo = preSaleOrderPoolFacade.queryInitPoolRegion(acrossOrgDTO, null, 1, 5);
        System.out.println(JSON.toJSON(pageInfo));
    }

}
