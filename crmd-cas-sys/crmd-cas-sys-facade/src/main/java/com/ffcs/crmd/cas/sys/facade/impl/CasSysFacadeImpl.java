package com.ffcs.crmd.cas.sys.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.base.utils.PageUtil;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeDTO;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeStateDTO;
import com.ffcs.crmd.cas.sys.api.dto.*;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.cas.sys.entity.*;
import com.ffcs.crmd.cas.sys.service.*;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.service.IAttrValueService;
import com.ffcs.crmd.platform.meta.service.ISysClassService;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("CasSysFacade")
public class CasSysFacadeImpl implements ICasSysFacade {
    @Autowired
    ISysClassService sysClassService;

    @Autowired
    IStaffService staffService;

    @Autowired
    IOrganizationService organizationService;

    @Autowired
    IAttrValueService attrValueService;
    @Autowired
    ICommonRegionService commonRegionService;
    @Autowired
    private IAreaCodeService areaCodeService;
    @Autowired
    private IStaffPositionService staffPositionService;

    @Override
    public List<SceneTypeDTO> qrySceneType(String className, String propertyName) {
        List<SceneTypeDTO> sceneTypeDTOs = null;
        List<AttrValue> values = CrmClassUtils.getAttrValues(className, propertyName);
        if (values != null && values.size() > 0) {
            sceneTypeDTOs = new ArrayList<SceneTypeDTO>();
            for (AttrValue attrValue : values) {
                SceneTypeDTO sceneTypeDto = new SceneTypeDTO();
                sceneTypeDto.setSceneType(attrValue.getAttrValue());
                sceneTypeDto.setSceneTypeName(attrValue.getAttrValueName());
                sceneTypeDTOs.add(sceneTypeDto);
            }
        }
        return sceneTypeDTOs;
    }

    @Override
    public PageInfo<StaffDTO> qryStaff(StaffDTO staffDTO) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (!StringUtils.isNullOrEmpty(staffDTO.getOrgId())
                && staffDTO.getOrgId() != 0L) {// 团队ID
            params.put("org_id", staffDTO.getOrgId());
        }
        if (!StringUtils.isNullOrEmpty(staffDTO.getStaffName())) {// 員工名稱
            params.put("staff_name", "%" + staffDTO.getStaffName() + "%");
        }
        if (!StringUtils.isNullOrEmpty(staffDTO.getStaffCode())) {// 員工名稱
            params.put("staff_code", staffDTO.getStaffCode());
        }
        PageInfo pageInfo = staffService.qryStaff(params, staffDTO.getPageNumber(), staffDTO.getPageSize());
        //非空判断
        if (pageInfo != null && pageInfo.getList() != null
                && pageInfo.getList().size() > 0) {
            List staffDTOs = CrmBeanUtils.copyList(
                    pageInfo.getList(), StaffDTO.class);
            pageInfo.setList(staffDTOs);
        }
        return pageInfo == null ? new PageInfo<>() : pageInfo;
    }

    @Override
    public String getStaffNameById(Long staffId) {
        Staff staff = staffService.get(staffId);
        return staff == null ? null : staff.getStaffName();
    }


    @Override
    public PageInfo qryOrg(OrganizationDTO organizationDTO) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (!StringUtils.isNullOrEmpty(organizationDTO.getOrgId())
                && organizationDTO.getOrgId() != 0L) {// 团队ID
            params.put("org_id", organizationDTO.getOrgId());
        }
        if (!StringUtils.isNullOrEmpty(organizationDTO.getOrgName())) {// 团队名称
            params.put("org_name", "%" + organizationDTO.getOrgName() + "%");
        }
        if (CollectionUtils.isNotEmpty(organizationDTO.getOrgIds())) {//团队ID列表
            params.put("orgIds", organizationDTO.getOrgIds());
        }
        if (!StringUtils.isNullOrEmpty(organizationDTO.getParentOrgId())) {
            params.put("parent_org_id", organizationDTO.getParentOrgId());
            params.put("clickOrgId",organizationDTO.getParentOrgId());
        }
        PageInfo<Organization> pageInfo = organizationService.qryOrg(params,
                organizationDTO.getPageNumber(), organizationDTO.getPageSize());
        //非空判断
        if (pageInfo != null && pageInfo.getList() != null
                && pageInfo.getList().size() > 0) {
            List organizationDTOs = CrmBeanUtils.copyList(
                    pageInfo.getList(), OrganizationDTO.class);

            pageInfo.setList(organizationDTOs);
        }

        return pageInfo == null ? new PageInfo<>() : pageInfo;
    }

    @Override
    public List<TreeNodeDTO> qryOrgTree(Long orgId) {
        List<TreeNodeDTO> listTreeNodeDTO = new ArrayList<TreeNodeDTO>();

        if (orgId == null) {
            orgId = 0L;
        }
        List<Organization> organizationList = organizationService.qryOrgTree(orgId);
        if (organizationList != null && organizationList.size() > 0) {
            listTreeNodeDTO = convertOrgToTreeNode(organizationList, orgId + "");
        }

        return listTreeNodeDTO;
    }

    @Override
    public OrganizationDTO getById(Long orgId) {
        Organization organization = organizationService.get(orgId);
        OrganizationDTO organizationDTO = new OrganizationDTO();
        try {
            BeanUtils.applyIf(organizationDTO, organization);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organizationDTO;
    }

    @Override
    public String getNameById(Long orgId) {
        Organization organization = organizationService.get(orgId);
        return organization == null ? null : organization.getOrgName();
    }

    public List<TreeNodeDTO> convertOrgToTreeNode(List<Organization> organizationList, String parentTeamId) {
        List<TreeNodeDTO> listTreeNodeDTO = new ArrayList<TreeNodeDTO>();
        for (Organization organization : organizationList) {
            TreeNodeDTO treeNodeDTO = new TreeNodeDTO();
            treeNodeDTO.setId(StringUtils.strnull(organization.getOrgId()));
            // 父节点为#
            treeNodeDTO.setParent(parentTeamId);
            treeNodeDTO.setText(organization.getOrgName());
            TreeNodeStateDTO treeNodeStateDTO = new TreeNodeStateDTO();
            treeNodeStateDTO.setOpened(false);
            treeNodeStateDTO.setSelected(false);
            treeNodeStateDTO.setLoaded(false);
            treeNodeDTO.setState(treeNodeStateDTO);
            listTreeNodeDTO.add(treeNodeDTO);
        }
        return listTreeNodeDTO;
    }

    /**
     * 根据类code，属性code获取属性值列表.
     *
     * @author YULIYAO 2016/1/12
     * return
     */
    public List<AttrValueDTO> getAttrValues(String className, String propertyName) {
        List<AttrValue> attrValues = CrmClassUtils.getAttrValues(className, propertyName);
        try {
            List<AttrValueDTO> attrValueDTOs = BeanUtils.copyList(attrValues, AttrValueDTO.class);
            return attrValueDTOs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CommonRegionDTO getCommonRegionById(Long commonRegionId) {
        CommonRegionDTO commonRegionDTO = new CommonRegionDTO();
        CommonRegion commonRegion = commonRegionService.get(commonRegionId);
        if (commonRegion != null) {
            CrmBeanUtils.applyIf(commonRegionDTO, commonRegion);
        }
        return commonRegionDTO;
    }


    @Override
    public String getCommonRegionNameById(Long commonRegionId) {
        CommonRegion commonRegion = commonRegionService.get(commonRegionId);
        return commonRegion == null ? "" : commonRegion.getRegionName();
    }

    public List<CommonRegionDTO> queryRegionLeafToRoot(Long commonRegionId) {
        List<CommonRegionDTO> commonRegionDTOs = new ArrayList<>();
        CommonRegionDTO commonRegionDTO = getCommonRegionById(commonRegionId);
        if (commonRegionDTO != null) {
            commonRegionDTOs.add(commonRegionDTO);
            //如果有上级团队，则递归查询，没有则返回
            if (!StringUtils.isNullOrEmpty(commonRegionDTO.getUpRegionId())) {
                commonRegionDTOs.addAll(queryRegionLeafToRoot(commonRegionDTO.getUpRegionId()));
            }
        }
        return commonRegionDTOs;
    }

    @Override
    public List<CommonRegionDTO> queryRegionRootToLeaf(Long commonRegionId) {
        List<CommonRegionDTO> commonRegionDTOs = new ArrayList<>();
        List<CommonRegion> crLists = commonRegionService.queryCommonRegionByUpRegionId(commonRegionId);
        if (crLists != null) {
            for (CommonRegion commonRegion : crLists) {
                CommonRegionDTO dto = new CommonRegionDTO();
                CrmBeanUtils.applyIf(dto, commonRegion);
                //如果有上级团队，则递归查询，没有则返回
                if (!StringUtils.isNullOrEmpty(commonRegion.getCommonRegionId())) {
                    commonRegionDTOs.addAll(queryRegionRootToLeaf(commonRegion.getCommonRegionId()));
                }
                commonRegionDTOs.add(dto);
            }
        }
        return commonRegionDTOs;
    }

    @Override
    public StaffDTO getStaffById(Long staffId) {
        StaffDTO staffDTO = new StaffDTO();
        Staff staff = staffService.get(staffId);
        if (staff != null) {
            CrmBeanUtils.applyIf(staffDTO, staff);
        }
        return staffDTO;
    }

    /**
     * 批量查询员工名称
     * @author YULIYAO 2016/5/17
     * return Map
     */
    @Override
    public Map<Long, String> queryStaffNames(Set<Long> staffIds) {
        Map resultMap = new HashMap();
        if (CollectionUtils.isNotEmpty(staffIds)) {
            List<Long> staffIdList = new ArrayList<>(staffIds);
            Map param = new HashMap();
            param.put("staffIds", staffIdList);
            List<Staff> staffs = staffService.qryStaffList(param);
            if (CollectionUtils.isNotEmpty(staffs)) {
                for (Staff staff : staffs) {
                    resultMap.put(staff.getStaffId(), staff.getStaffName());
                }
            }

        }
        return resultMap;
    }


    @Override
    public String getOutSysUrlByCode(String code) {
        return CrmClassUtils.getOutSysUrlByCode(code);
    }

    @Override
    public AreaCodeDTO getAreaCodeByRegionId(Long regionId) {
        AreaCodeDTO areaCodeDTO = new AreaCodeDTO();
        AreaCode areaCode = areaCodeService.getAreaCodeByRegionId(regionId);
        if (areaCode == null) {
            ExceptionUtils.throwEx("数据异常，areaCode为空!");
        }
        CrmBeanUtils.applyIf(areaCodeDTO, areaCode);
        return areaCodeDTO;
    }

    @Override
    public List<StaffDTO> queryStaffList(Long orgId) {
        Map param = new HashMap();
        param.put("orgId", orgId);
        List<Staff> staffs = staffService.qryStaffList(param);
        List<StaffDTO> staffDTOs = null;
        if (staffs != null && staffs.size() > 0) {
            staffDTOs = new ArrayList<StaffDTO>();
            for (Staff staff : staffs) {
                StaffDTO staffDTO = new StaffDTO();
                CrmBeanUtils.applyIf(staffDTO, staff);
                staffDTOs.add(staffDTO);
            }
        }
        return staffDTOs;
    }


    /**
     * 根据区域ID获取C3级区域编码.
     *
     * @param areaId
     * @return
     * @author renl
     * 2012-9-7 renl
     */
    @Override
    public String getLatnIdByAreaId(final Long areaId) {
        //2012-07-14 刘壮飞  送计费要送C3级别编码 12378   省推广本地网用测单_泉州_问题单_QZ000999_台商区工号受理业务报错
        AreaCodeDTO areaCodeDTO = getC3AreaCodeByCommonRegionId(areaId);
        if (areaCodeDTO == null) {
            ExceptionUtils.throwEx("订单区域信息（areaId=" + areaId + "）不合法，请确认！");
        }
        if (CrmClassUtils.hasSwitch(CasConstant.CALL_FZ_HB_SWITCH.getValue())) { //全省上线前写死
            return "591";
        } else {
            return areaCodeDTO.getAreaNbr();
        }
    }

    /**
     * 根据区域ID获取C3级
     *
     * @author YULIYAO 2016/3/4
     * return
     */
    @Override
    public AreaCodeDTO getC3AreaCodeByCommonRegionId(Long commonRegionId) {
        AreaCodeDTO areaCodeDTO = null;
        Long c3RegionId = 0L;
        List<CommonRegionDTO> commonRegionDTOs = queryRegionLeafToRoot(commonRegionId);
        if (CollectionUtils.isNotEmpty(commonRegionDTOs)) {
            for (CommonRegionDTO commonRegionDTO : commonRegionDTOs) {
                if (CasConstant.REGION_TYPE_C3.getValue().equals(commonRegionDTO.getRegionType())) {
                    c3RegionId = commonRegionDTO.getCommonRegionId();
                    break;
                }
            }
        }
        if (c3RegionId != 0) {
            areaCodeDTO = getAreaCodeByRegionId(c3RegionId);
        }
        return areaCodeDTO;
    }


    /**
     * 查询岗位
     *
     * @author YULIYAO 2016/3/4
     * return
     */
    @Override
    public List<StaffPositionDTO> queryStaffPosition(StaffPositionDTO staffPositionDTO) {
        List<StaffPositionDTO> staffPositionDTOs = new ArrayList<>();
        Map param = new HashMap();
        //参数：员工ID
        if (!StringUtils.isNullOrEmpty(staffPositionDTO.getStaffId())) {
            param.put("staffId", staffPositionDTO.getStaffId());
        }
        //参数：团队ID
        if (!StringUtils.isNullOrEmpty(staffPositionDTO.getOrgId())) {
            param.put("orgId", staffPositionDTO.getOrgId());
        }
        List<StaffPosition> staffPositions = staffPositionService.queryStaffPosition(param);
        return CrmBeanUtils.copyList(staffPositions, StaffPositionDTO.class);
    }

    @Override
    public StaffPositionDTO getStaffPositionByStaffIdAndOrgId(Long staffId, Long orgId) {
        Map param = new HashMap();
        if (staffId == null || staffId == 0 || orgId == null || orgId == 0) {
            return null;
        }
        param.put("staffId", staffId);
        param.put("orgId", orgId);
        List<StaffPosition> staffPositions = staffPositionService.queryStaffPosition(param);
        if (CollectionUtils.isNotEmpty(staffPositions)) {
            StaffPositionDTO staffPositionDTO = new StaffPositionDTO();
            CrmBeanUtils.applyIf(staffPositionDTO, staffPositions.get(0));
            return staffPositionDTO;
        }
        return null;
    }

    @Override
    public AttrSpecDTO qryAttrSpecByCode(String javaCode) {
        AttrSpecDTO attrSpecDTO = new AttrSpecDTO();
        try {
            AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode("PageClass", javaCode);
            if (attrSpec != null) {
                BeanUtils.applyIf(attrSpecDTO, attrSpec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attrSpecDTO;
    }

    @Override
    public String getAttrValueByName(String className, String javaCode, String attrValueName) {
        return CrmClassUtils.getAttrValueByName(className, javaCode, attrValueName);
    }

    /**
     * 批量查询团队名称
     * @author YULIYAO 2016/5/17
     * return Map
     */
    @Override
    public Map<Long, String> queryOrgNames(Set<Long> orgIds) {
        Map resultMap = new HashMap();
        if (CollectionUtils.isNotEmpty(orgIds)) {
            List orgIdList = new ArrayList<>(orgIds);
            Map param = new HashMap();
            param.put("orgIds", orgIdList);
            List<Organization> organizations = organizationService.queryOrganization(param);
            if (CollectionUtils.isNotEmpty(organizations)) {
                for (Organization organization : organizations) {
                    resultMap.put(organization.getOrgId(), organization.getOrgName());
                }
            }
        }
        return resultMap;
    }

    /**
     * 根据主键获取岗位
     *
     * @author YULIYAO 2016/5/4
     * return
     */
    @Override
    public StaffPositionDTO getStaffPositionById(Long staffPositionId) {
        StaffPosition staffPosition = staffPositionService.get(staffPositionId);
        if (staffPosition != null) {
            StaffPositionDTO staffPositionDTO = new StaffPositionDTO();
            CrmBeanUtils.applyIf(staffPositionDTO, staffPosition);
            return staffPositionDTO;
        }
        return null;
    }

    @Override
    public PageInfo qryOrganizaztionPageInfoByIdsAndParams(AcrossOrgDTO acrossOrgDTO,
                                                           OrganizationDTO organizationDTO, int currentPage, int perPageCount) {
        if (acrossOrgDTO == null) {
            return null;
        }
        if ((acrossOrgDTO.getC3AssignOrg() == null || acrossOrgDTO.getC3AssignOrg().size() == 0)
                && (acrossOrgDTO.getC4AssignOrg() == null || acrossOrgDTO.getC4AssignOrg().size() == 0)
                && (acrossOrgDTO.getOrgAssignOrg() == null || acrossOrgDTO.getOrgAssignOrg().size() == 0)) {
            return null;
        }
        // 先判断团队-团队配置
        Map<String, Object> param = new HashMap<String, Object>();
        if (acrossOrgDTO.getOrgAssignOrg() != null && acrossOrgDTO.getOrgAssignOrg().size() > 0) {
            param.put("orgAssignOrg", acrossOrgDTO.getOrgAssignOrg());
            if (acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0) {
                param.put("unionAll_1", "1");
            }
        }
        // 再判断团队-本地网配置
        if (acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0) {
            Map<Long, Long> map = new HashMap<Long, Long>();
            List<Long> acList = acrossOrgDTO.getC3AssignOrg();
            for (Long ll : acList) {
                map.put(ll, ll);
                List<CommonRegionDTO> dtos = queryRegionRootToLeaf(ll);
                for (CommonRegionDTO commonRegionDTO : dtos) {
                    map.put(commonRegionDTO.getCommonRegionId(), commonRegionDTO.getCommonRegionId());
                }
            }

            if (acrossOrgDTO.getNotInC4AssignOrg() != null && acrossOrgDTO.getNotInC4AssignOrg().size() > 0) {
                List<Long> acList2 = acrossOrgDTO.getNotInC4AssignOrg();
                for (Long ll : acList2) {
                    if (map.containsKey(ll)) {
                        map.remove(ll);
                    }
                    List<CommonRegionDTO> dtos = queryRegionRootToLeaf(ll);
                    for (CommonRegionDTO commonRegionDTO : dtos) {
                        if (map.containsKey(commonRegionDTO.getCommonRegionId())) {
                            map.remove(commonRegionDTO.getCommonRegionId());
                        }
                    }
                }
            }
            if (map.keySet() != null && map.keySet().size() > 0) {
                List<Long> c3AssignOrg = new ArrayList<Long>();
                c3AssignOrg.addAll(map.values());
                param.put("c3AssignOrg", c3AssignOrg);
                param.put("C3AssignOrgStart", "1");
            }
            if (acrossOrgDTO.getNotInOrgAssignOrg() != null && acrossOrgDTO.getNotInOrgAssignOrg().size() > 0) {
                param.put("notInOrgAssignOrg", acrossOrgDTO.getNotInOrgAssignOrg());
                param.put("C3AssignOrgEnd", "1");
            }
        }

    	/*if (acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0) {
            List<Long> c3AssignOrg = new ArrayList<Long>();
    		List<Long> acList = acrossOrgDTO.getC3AssignOrg();
    		for (Long ll : acList) {
    			List<CommonRegionDTO> dtos = queryRegionRootToLeaf(ll);
    			for (CommonRegionDTO commonRegionDTO : dtos) {
    				c3AssignOrg.add(commonRegionDTO.getCommonRegionId());
				}
			}
            c3AssignOrg.addAll(acList);
    		param.put("c3AssignOrg", c3AssignOrg);
    	}
    	if (acrossOrgDTO.getNotInC4AssignOrg() != null && acrossOrgDTO.getNotInC4AssignOrg().size() > 0) {
    		List<Long> notInC4AssignOrg = new ArrayList<Long>();
    		List<Long> acList = acrossOrgDTO.getNotInC4AssignOrg();
    		for (Long ll : acList) {
    			List<CommonRegionDTO> dtos = queryRegionRootToLeaf(ll);
    			for (CommonRegionDTO commonRegionDTO : dtos) {
    				notInC4AssignOrg.add(commonRegionDTO.getCommonRegionId());
				}
			}
            notInC4AssignOrg.addAll(acList);
    		param.put("notInC4AssignOrg", notInC4AssignOrg);
    	}*/

        // 再判断团队-区域配置
        if (acrossOrgDTO.getC4AssignOrg() != null && acrossOrgDTO.getC4AssignOrg().size() > 0) {
            if ((acrossOrgDTO.getC3AssignOrg() != null && acrossOrgDTO.getC3AssignOrg().size() > 0)
                    || (acrossOrgDTO.getOrgAssignOrg() != null && acrossOrgDTO.getOrgAssignOrg().size() > 0)) {
                param.put("unionAll_2", "1");
            }
            List<Long> c4AssignOrg = new ArrayList<Long>();
            List<Long> acList = acrossOrgDTO.getC4AssignOrg();
            for (Long ll : acList) {
                c4AssignOrg.add(ll);
                List<CommonRegionDTO> dtos = queryRegionRootToLeaf(ll);
                for (CommonRegionDTO commonRegionDTO : dtos) {
                    c4AssignOrg.add(commonRegionDTO.getCommonRegionId());
                }
            }
            param.put("c4AssignOrg", c4AssignOrg);
            param.put("c4AssignOrgStart", "1");

            if (acrossOrgDTO.getNotInOrgAssignOrg() != null && acrossOrgDTO.getNotInOrgAssignOrg().size() > 0) {
                param.put("notInOrgAssignOrg2", acrossOrgDTO.getNotInOrgAssignOrg());
            }
        }
        if (organizationDTO != null) {
            // 团队类型
            if (!StringUtils.isNullOrEmpty(organizationDTO.getOrgType())) {
                param.put("orgType", organizationDTO.getOrgType());
            }
            // 团队名称
            if (!StringUtils.isNullOrEmpty(organizationDTO.getOrgName())) {
                param.put("orgName", "%" + organizationDTO.getOrgName() + "%");
            }
        }
        PageInfo<Organization> pageInfo = organizationService
                .qryOrganizaztionPageInfoByIdsAndParams(param, currentPage, perPageCount);
        if (pageInfo != null && pageInfo.getList() != null
                && pageInfo.getList().size() > 0) {
            List organizationDTOs = CrmBeanUtils.copyList(
                    pageInfo.getList(), OrganizationDTO.class);
            pageInfo.setList(organizationDTOs);
        }
        return pageInfo == null ? new PageInfo<>() : pageInfo;
    }

    @Override
    public List<TreeNodeDTO> qryOrgRoot(Long orgId) {
        List<TreeNodeDTO> listTreeNodeDTO = new ArrayList<>();
        Organization organization = organizationService.get(orgId);
        TreeNodeDTO treeNodeDTO = new TreeNodeDTO();
        treeNodeDTO.setId(StringUtils.strnull(organization.getOrgId() + ""));
        // 父节点为#
        treeNodeDTO.setParent("#");
        treeNodeDTO.setText(organization.getOrgName());
        TreeNodeStateDTO treeNodeStateDTO = new TreeNodeStateDTO();
        treeNodeStateDTO.setOpened(false);
        treeNodeStateDTO.setSelected(false);
        treeNodeStateDTO.setLoaded(false);
        treeNodeDTO.setState(treeNodeStateDTO);
        listTreeNodeDTO.add(treeNodeDTO);
        return listTreeNodeDTO;
    }

    /**
     * 根据id递归查询上级
     *
     * @param orgId
     * @return
     */
    public List<OrganizationDTO> queryOrgLeafToRoot(Long orgId) {
        List<OrganizationDTO> organizationDTOs = new ArrayList<>();
        OrganizationDTO organizationDTO = getById(orgId);
        if (organizationDTO != null) {
            organizationDTOs.add(organizationDTO);
            //如果有上级团队，则递归查询，没有则返回
            if (!StringUtils.isNullOrEmpty(organizationDTO.getParentOrgId()) && organizationDTO.getParentOrgId()!=0) {
                organizationDTOs.addAll(queryOrgLeafToRoot(organizationDTO.getParentOrgId()));
            }
        }
        return organizationDTOs;
/*        OrganizationDTO result  = new OrganizationDTO();
        OrganizationDTO organizationDTO = getById(orgId);
        if (organizationDTO != null) {
            //如果有上级团队，则递归查询，没有则返回
            if (!StringUtils.isNullOrEmpty(organizationDTO.getParentOrgId())){
                if (CasSessionContext.getOrgId().equals(organizationDTO.getParentOrgId()) ) {
                    result = queryOrgLeafToRoot(organizationDTO.getParentOrgId());
                }
            }
        }
        return result;*/
    }

    @Override
    public PageInfo qryByName(OrganizationDTO organizationDTO) {
        PageInfo pageInfo = new PageInfo();
        Map<String, Object> params = new HashMap<String, Object>();
        if (!StringUtils.isNullOrEmpty(organizationDTO.getOrgName())) {// 团队名称
            params.put("org_name", "%" + organizationDTO.getOrgName() + "%");
        }
        List<Organization> organizations = organizationService.qryOrgList(params);
        //非空判断
        if (CollectionUtils.isNotEmpty(organizations)) {
            List<OrganizationDTO> organizationDTOs = CrmBeanUtils.copyList(
                    organizations, OrganizationDTO.class);
            List<OrganizationDTO> resultList = new ArrayList();
            for (OrganizationDTO organizationDTO1 : organizationDTOs) {
                List<OrganizationDTO> rootDtos = queryOrgLeafToRoot(organizationDTO1.getOrgId());
                List<Long> rootIds = dtoToIdList(rootDtos);
                if (rootIds.contains(CasSessionContext.getContext().getOrgId())) {
                    resultList.add(organizationDTO1);
                }
                //如果达到查询条数则跳出循环
                if (resultList.size() >= organizationDTO.getPageNumber() * organizationDTO.getPageSize()) {
                    break;
                }
            }
            if (CollectionUtils.isNotEmpty(resultList)) {
                pageInfo = PageUtil.list2PageInfo(resultList, organizationDTOs.size(),organizationDTO.getPageNumber(), organizationDTO.getPageSize());
            }
        }
        return pageInfo == null ? new PageInfo<>() : pageInfo;
    }

    /**
     * 批量查询区域名称
     * @author YULIYAO 2016/5/17
     * return
     */
    public Map queryRegionNames(Set<Long> regionIds) {
        Map resultMap = new HashMap();
        if (CollectionUtils.isNotEmpty(regionIds)) {
            List regionIdList = new ArrayList<>(regionIds);
            Map param = new HashMap();
            param.put("commonRegionIds", regionIdList);
            List<CommonRegion> commonRegions = commonRegionService.queryCommonRegion(param);
            if (CollectionUtils.isNotEmpty(commonRegions)) {
                for (CommonRegion commonRegion : commonRegions) {
                    resultMap.put(commonRegion.getCommonRegionId(), commonRegion.getRegionName());
                }
            }
        }
        return resultMap;
    }

    private List<Long> dtoToIdList(List<OrganizationDTO> organizationDTOLits) {
        List<Long> idList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(organizationDTOLits)) {
            for (OrganizationDTO organizationDTO : organizationDTOLits) {
                idList.add(organizationDTO.getOrgId());
            }
        }
        return idList;
    }


    @Override
    public List<CommonRegionDTO> queryC3C4RegionRootToLeaf(Long commonRegionId) {
        List<CommonRegionDTO> commonRegionDTOs = new ArrayList<>();
        List<CommonRegion> crLists = commonRegionService.queryCommonRegionByUpRegionId(commonRegionId);
        if (crLists != null) {
            for (CommonRegion commonRegion : crLists) {
                CommonRegionDTO dto = new CommonRegionDTO();
                CrmBeanUtils.applyIf(dto, commonRegion);
                //如果有上级团队，则递归查询，没有则返回
                if (!StringUtils.isNullOrEmpty(commonRegion.getCommonRegionId())
                        && (CasConstant.REGION_TYPE_C2.getValue().equals(commonRegion.getRegionType())
                            ||CasConstant.REGION_TYPE_C3.getValue().equals(commonRegion.getRegionType()))) {
                    commonRegionDTOs.addAll(queryC3C4RegionRootToLeaf(commonRegion.getCommonRegionId()));
                }
                commonRegionDTOs.add(dto);
            }
        }
        return commonRegionDTOs;
    }

}
