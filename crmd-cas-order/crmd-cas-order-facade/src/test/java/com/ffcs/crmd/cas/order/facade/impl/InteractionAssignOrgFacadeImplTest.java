package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.order.api.dto.InteractionAssignOrgDTO;
import com.ffcs.crmd.cas.order.api.facade.IInteractionAssignOrgFacade;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by YULIYAO on 2016/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml" })
public class InteractionAssignOrgFacadeImplTest {

    @Autowired
    private IInteractionAssignOrgFacade interactionAssignOrgFacade;

    @Test
    public void testQueryAssignOrg() {
        InteractionAssignOrgVo vo = new InteractionAssignOrgVo();
//        vo.setOrgName("电信");
//        vo.setExecuteOrgName("华林");
        vo.setInteractionFlowId(2L);
        PageInfo pageInfo = interactionAssignOrgFacade.queryAssignOrg(vo);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testSave() {
        InteractionAssignOrgDTO dto = new InteractionAssignOrgDTO();
        dto.setOrgId(50043L);
        dto.setExecuteOrgId(50045L);
        dto.setShardingId(1L);
        dto.setInteractionFlowId(2L);
        interactionAssignOrgFacade.save(dto);
    }

    @Test
    public void testUpdate() {
        InteractionAssignOrgDTO dto = new InteractionAssignOrgDTO();
        dto.setInteractionAssignOrgId(4005L);
        dto.setOrgId(50086L);
        dto.setExecuteOrgId(50045L);
        dto.setCreateDate(new Timestamp(new Date().getTime()));
        dto.setInteractionFlowId(1L);
        dto.setShardingId(1L);
        interactionAssignOrgFacade.update(dto);
    }

    @Test
    public void testRemove() {
        InteractionAssignOrgDTO dto = new InteractionAssignOrgDTO();
        dto.setInteractionAssignOrgId(4004L);
        dto.setShardingId(1L);
        interactionAssignOrgFacade.remove(dto);
    }
}
