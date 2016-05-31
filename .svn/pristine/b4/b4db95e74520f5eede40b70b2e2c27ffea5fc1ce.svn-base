package com.ffcs.crmd.cas.sys.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeDTO;
import com.ffcs.crmd.cas.sys.api.dto.*;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/15
 * @功能说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:conf/spring/applicationContext*.xml",
        "classpath*:conf/spring/**/applicationContext*.xml" })
public class CasSysFacadeImplTest {
    @Resource
    ICasSysFacade casSysFacade;

    @Test
    public void qryBusiType() {
        List<SceneTypeDTO> sceneTypeDTOs = casSysFacade.qrySceneType("PreSaleOrder","sceneType");
        String jsonStr = JSONUtils.toJsonString(sceneTypeDTOs);
        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + jsonStr);
        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + sceneTypeDTOs.size());
    }

    @Test
    public void qryStaff() {
        StaffDTO staffDto = new StaffDTO();
        //staffDto.setStaffCode("fztest");
        staffDto.setStaffName("枢纽");
        //staffDto.setOrgId(50001L);
        PageInfo pageInfo = casSysFacade.qryStaff(staffDto);
        String jsonStr = JSONUtils.toJsonString(pageInfo);
        System.out.println("大小:" + pageInfo.getList().size());
        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + jsonStr);
    }

    @Test
    public void qryOrg() {
        OrganizationDTO orgDto = new OrganizationDTO();
        String orgName = "东街";
        orgDto.setOrgName(orgName);
        PageInfo pageInfo = casSysFacade.qryOrg(orgDto);
        String jsonStr = JSONUtils.toJsonString(pageInfo);
        System.out.println("大小:" + pageInfo.getList().size());
        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + jsonStr);
    }

    @Test
    public void qryOrgById() {
        OrganizationDTO dto = casSysFacade.getById(122L);
        System.out.println(JSON.toJSON(dto));
        String temp = "591000000014858";
        System.out.println(dto.getOrgCode()==temp);
        System.out.println("591000000014858"==dto.getOrgCode());
    }

    @Test
    public void qryOrgTree() {
        //50001
        Long orgId = 50001L;
        List<TreeNodeDTO> treeList = casSysFacade.qryOrgTree(orgId);
        String jsonStr = JSONUtils.toJsonString(treeList);
        System.out.println("大小:" + treeList.size());
        System.out.println("结果：>>>>>>>>>>>>>>>>>>\n" + jsonStr);
    }

    @Test
    public void testGetAttrValues() {
        List<AttrValueDTO> attrValueDTOList = casSysFacade.getAttrValues("InteractionFlow", "custItemTypeGroup");
        System.out.println(JSON.toJSON(attrValueDTOList));

    }

    @Test
    public void testQueryStaffList() {
        List<StaffDTO> staffs = casSysFacade.queryStaffList(2022982L);
        System.out.println(JSON.toJSON(staffs));
    }

    @Test
    public void testQueryRegionLeafToRoot() {
        List<CommonRegionDTO> commonRegionDTOs = casSysFacade.queryRegionLeafToRoot(11L);
        System.out.println(JSON.toJSON(commonRegionDTOs));
    }

    @Test
    public void testQueryStaffPosition() {
        StaffPositionDTO dto = new StaffPositionDTO();
        dto.setStaffId(49822L);
        dto.setOrgId(14388L);
        List<StaffPositionDTO> staffPositionDTOs = casSysFacade.queryStaffPosition(dto);
        System.out.println(JSON.toJSON(staffPositionDTOs));
    }

    @Test
    public void testQueryStaffNames() {
        Map map = casSysFacade.queryStaffNames(new HashSet<>(Arrays.asList(1L,49822L,49822L,51186L,51190L,1L)));
        if (map.containsKey(1)) {
            map.containsKey(1L);
            map.containsKey("1");
        }
        System.out.println(JSON.toJSON(map));
    }

    @Test
    public void testQueryOrgNames() {
        Map map = casSysFacade
            .queryOrgNames(new HashSet<>(Arrays.asList(109L, 122L, 143L, 143L, 203L, 109L)));
        System.out.println(JSON.toJSON(map));
    }

    @Test
    public void testQueryRegionNames() {
        Set set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        set.add(4L);
        set.add(5L);
        set.add(1L);
        set.add(3L);
        Map map = casSysFacade.queryRegionNames(set);
        System.out.println(JSON.toJSON(map));
    }
}
