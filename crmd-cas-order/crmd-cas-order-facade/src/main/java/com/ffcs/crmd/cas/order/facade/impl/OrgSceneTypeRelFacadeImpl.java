package com.ffcs.crmd.cas.order.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.OrgSceneTypeRelDTO;
import com.ffcs.crmd.cas.order.api.facade.IOrgSceneTypeRelFacade;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;
import com.ffcs.crmd.cas.order.entity.OrgSceneTypeRel;
import com.ffcs.crmd.cas.order.service.IOrgSceneTypeRelService;
import com.ffcs.crmd.cas.sys.api.dto.OrganizationDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orgSceneTypeRelFacade")
public class OrgSceneTypeRelFacadeImpl extends CrmdBaseFacade implements IOrgSceneTypeRelFacade {
   	@Autowired
	IOrgSceneTypeRelService orgSceneTypeRelService;
	@Autowired
	private ICasSysFacade casSysFacade;

	/**
	 * 新增
	 * 先判断团队是否已经关联业务类型，否，则插入
	 * @author YULIYAO 2016/1/15
	 * return
	 */
	@Override
	public int save(OrgSceneTypeRelDTO orgSceneTypeRelDTO) {
		int result = 0;
		//切割解析传进来的业务类型
		String sceneTypes = orgSceneTypeRelDTO.getSceneTypes();
		if (!StringUtils.isNullOrEmpty(sceneTypes)) {
			String[] typeArr = sceneTypes.split(",");
			//遍历插入团队关联
			if (typeArr != null && typeArr.length > 0) {
				for(int i=0;i<typeArr.length;i++) {
					//判断是否已经存在
					OrgSceneTypeRelVo vo = new OrgSceneTypeRelVo();
					vo.setOrgId(orgSceneTypeRelDTO.getOrgId());
					vo.setSceneType(typeArr[i]);
					List<OrgSceneTypeRel> orgSceneTypeRels = orgSceneTypeRelService
							.queryOrgSceneTypeRel(vo);
					if (orgSceneTypeRels == null || orgSceneTypeRels.size() == 0) {
						OrgSceneTypeRel orgSceneTypeRel = new OrgSceneTypeRel(true);
						orgSceneTypeRel.setSceneType(typeArr[i]);
						//主数据获取类型名称
						String sceneTypeName = CrmClassUtils
								.getAttrValueNameByValue(CasConstant.PRE_SALE_ORDER.getValue(),
										CasConstant.SCENE_TYPE.getValue(), typeArr[i]);
						orgSceneTypeRel.setSceneTypeName(sceneTypeName);
						orgSceneTypeRel.setOrgId(orgSceneTypeRelDTO.getOrgId());
						orgSceneTypeRel.setStatusCd(CasConstant.STATUS_CD_VAILID.getValue());
						result += orgSceneTypeRelService.save(orgSceneTypeRel);
					}
				}
			}
		}

		return result;
	}

	@Override
	public int remove(OrgSceneTypeRelDTO orgSceneTypeRelDTO) {
		int result = 0;
		//先取出团队关联的类型列表，再逐一删除
		OrgSceneTypeRelVo vo = new OrgSceneTypeRelVo();
		vo.setOrgId(orgSceneTypeRelDTO.getOrgId());
		List<OrgSceneTypeRel> orgSceneTypeRels = orgSceneTypeRelService.queryOrgSceneTypeRel(vo);
		if (orgSceneTypeRels != null) {
			for (OrgSceneTypeRel orgSceneTypeRel : orgSceneTypeRels) {
				result += orgSceneTypeRelService.remove(orgSceneTypeRel);
			}
		}
		return result;
	}

	@Override
	public int update(OrgSceneTypeRelDTO orgSceneTypeRelDTO) {
		//先删除旧关联，再新增新关联
		remove(orgSceneTypeRelDTO);
		return save(orgSceneTypeRelDTO);
	}

	/**
	 * 先查出符合条件的团队
	 * 再根据团队查询关联的所有类型
	 * @author YULIYAO 2016/1/11
	 * return
	 */
	@Override
	public PageInfo queryOrgBySceneType(OrgSceneTypeRelVo orgSceneTypeRelVo) {
		List<OrganizationDTO> orgSceneTypeRelDTOList = new ArrayList<OrganizationDTO>();
		//查出业务类型
		List<OrgSceneTypeRel> orgSceneTypeRels = orgSceneTypeRelService
				.queryOrgSceneTypeRel(orgSceneTypeRelVo);
		if (CollectionUtils.isEmpty(orgSceneTypeRels)) {
			return new PageInfo();
		}
		List<Long> orgIds = new ArrayList<Long>();
		if (CollectionUtils.isNotEmpty(orgSceneTypeRels)) {
			for (OrgSceneTypeRel orgSceneTypeRel : orgSceneTypeRels) {
				orgIds.add(orgSceneTypeRel.getOrgId());
			}
		}
		OrganizationDTO orgDTOParam = new OrganizationDTO();
		orgDTOParam.setOrgName(orgSceneTypeRelVo.getOrgName());
		orgDTOParam.setOrgIds(orgIds);
		orgDTOParam.setPageSize(orgSceneTypeRelVo.getPageSize());
		orgDTOParam.setPageNumber(orgSceneTypeRelVo.getPageNumber());
		PageInfo pageInfo = casSysFacade.qryOrg(orgDTOParam);
		if (pageInfo != null && pageInfo.getList() != null) {
			for (int i = 0; i < pageInfo.getList().size(); i++) {
				OrganizationDTO organizationDTO = (OrganizationDTO) pageInfo.getList().get(i);
				//查询团队关联的业务类型，并且以|组装成string返回
				OrgSceneTypeRelVo relVo = new OrgSceneTypeRelVo();
				relVo.setOrgId(organizationDTO.getOrgId());
				List<OrgSceneTypeRelDTO> relDTOs = queryOrgSceneTypeRel(relVo);
				//以|组装业务类型名称
				StringBuffer sceneTypeBuffer = new StringBuffer();
				if (relDTOs != null) {
					for(int j=0;j<relDTOs.size();j++) {
						if (j == 0) {
							sceneTypeBuffer.append(relDTOs.get(j).getSceneTypeName());
						} else {
							sceneTypeBuffer.append(" | ")
									.append(relDTOs.get(j).getSceneTypeName());
						}
						relDTOs.get(j).setChecked(true); //添加选中
					}
					organizationDTO.setSceneTypeNames(sceneTypeBuffer.toString());
				}
				organizationDTO.setOrgSceneTypeRelDtos(relDTOs);  //位置下移
				orgSceneTypeRelDTOList.add(organizationDTO);
			}
			pageInfo.setList(orgSceneTypeRelDTOList);
		}
		return pageInfo;
	}

	public List<OrgSceneTypeRelDTO> queryOrgSceneTypeRel(OrgSceneTypeRelVo vo) {
		List<OrgSceneTypeRelDTO> orgSceneTypeRelDTOs = new ArrayList<OrgSceneTypeRelDTO>();
		List<OrgSceneTypeRel> orgSceneTypeRels = orgSceneTypeRelService
				.queryOrgSceneTypeRel(vo);
		try {
			orgSceneTypeRelDTOs = BeanUtils.copyList(orgSceneTypeRels, OrgSceneTypeRelDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgSceneTypeRelDTOs;
	}
}
