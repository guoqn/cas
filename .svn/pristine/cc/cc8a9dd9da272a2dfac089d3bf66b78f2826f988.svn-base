package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDetailDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderMaintananceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YULIYAO on 2016/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml" })
public class PreSaleOrderMaintananceFacadeImplTest {

    @Autowired
    private IPreSaleOrderMaintananceFacade maintananceFacade;

    @Test
    public void test() {
        PreSaleOrderMaintanceDetailDTO detailDTO = new PreSaleOrderMaintanceDetailDTO();
        detailDTO.setCustSoNumber("FJ2015072080826416");
        detailDTO.setTargetPreOrderNumber("P20150718001995");
        PreSaleOrderMaintanceDetailDTO detailDTO1 = new PreSaleOrderMaintanceDetailDTO();
        detailDTO1.setCustSoNumber("FJ2015072080826450");
        detailDTO1.setTargetPreOrderNumber("P20150719001998");
        List<PreSaleOrderMaintanceDetailDTO> detailDTOs = Arrays.asList(detailDTO,detailDTO1);
        PreSaleOrderMaintanceDTO maintanceDTO = maintananceFacade.checkBatchConnect(detailDTOs);
        System.out.println(JSON.toJSON(maintanceDTO));

    }
}
