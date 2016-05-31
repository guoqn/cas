package com.ffcs.crmd.cas.order.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.data.util.sqlparse.SqlDealUtil;
import com.ffcs.crmd.cas.order.api.dto.InteractionFlowDTO;
import com.ffcs.crmd.cas.order.api.facade.IInteractionFlowFacade;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
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
public class InteractionFlowFacadeImplTest {

    @Autowired
    private IInteractionFlowFacade interactionFlowFacade;

    @Test
    public void testSave() {
        InteractionFlowDTO interactionFlowDTO = new InteractionFlowDTO();
        interactionFlowDTO.setInteractionFlowName("状态测试");
        interactionFlowDTO.setStatusCd("1299");
        interactionFlowDTO.setRemark("备注");
        interactionFlowDTO.setShardingId(1L);
        int i = interactionFlowFacade.save(interactionFlowDTO);
        System.out.println(i);
    }

    @Test
    public void testQueryFlowByName() {
        InteractionFlowVo interactionFlowVo = new InteractionFlowVo();
        interactionFlowVo.setInteractionFlowName("地");
        PageInfo pageInfo = interactionFlowFacade.queryFlowByName(interactionFlowVo);
        System.out.println(JSON.toJSON(pageInfo));
    }

    @Test
    public void testUpdate() {
        InteractionFlowDTO interactionFlowDTO = new InteractionFlowDTO();
        interactionFlowDTO.setInteractionFlowId(0L);
        interactionFlowDTO.setInteractionFlowName("测试修改");
        int i = interactionFlowFacade.update(interactionFlowDTO);
        System.out.println(i);
    }

    @Test
    public void testDelete() {
        InteractionFlowDTO interactionFlowDTO = new InteractionFlowDTO();
        interactionFlowDTO.setInteractionFlowId(0L);
        int i = interactionFlowFacade.remove(interactionFlowDTO);
        System.out.println(i);
    }

    @Test
    public void getColumns() {
        System.out.println(SqlDealUtil.createColumn("auto_gen_order","ago"));
    }
}
