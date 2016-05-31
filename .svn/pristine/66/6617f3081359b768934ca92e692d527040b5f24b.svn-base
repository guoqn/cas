package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.order.api.dto.OrgSceneTypeRelDTO;
import com.ffcs.crmd.cas.order.api.facade.IOrgSceneTypeRelFacade;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YULIYAO on 2016/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml" })
public class OrgSceneTypeRelFacadeImplTest {

    @Autowired
    private IOrgSceneTypeRelFacade orgSceneTypeRelFacade;

    @Test
    public void testQuery() {
        OrgSceneTypeRelVo vo = new OrgSceneTypeRelVo();
        vo.setOrgName("TEST8-23");
        vo.setSceneType("126");
        PageInfo pageInfo = orgSceneTypeRelFacade.queryOrgBySceneType(vo);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testSave() {
        OrgSceneTypeRelDTO dto = new OrgSceneTypeRelDTO();
      /*  dto.setOrgId(2296347L);
        dto.setSceneTypesm ("126 ,123,119,127,128");*/
        dto.setOrgId(2002981L);
        dto.setSceneTypes("126,123");
        orgSceneTypeRelFacade.save(dto);
    }

    @Test
    public void testUpdate() {
        OrgSceneTypeRelDTO dto = new OrgSceneTypeRelDTO();
        dto.setOrgId(2002981L);
        dto.setSceneTypes("119,127");
        orgSceneTypeRelFacade.update(dto);
    }

    @Test
    public void testRemove() {
        OrgSceneTypeRelDTO dto = new OrgSceneTypeRelDTO();
        dto.setOrgId(2002981L);
        orgSceneTypeRelFacade.remove(dto);
    }
}
