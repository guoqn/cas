package com.ffcs.crmd.cas.order.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.dto.OrgSceneTypeRelDTO;
import com.ffcs.crmd.cas.order.api.facade.IOrgSceneTypeRelFacade;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 团队关联类型页面controller
 * Created by qn_guo on 2016/1/13.
 */
@Controller
@RequestMapping("/order/orgSceneTypeRel")
@ResponseBody
public class OrgSceneTypeRelController extends CrmdBaseController {
    @Autowired
    private IOrgSceneTypeRelFacade orgSceneTypeRelFacade;
    @Autowired
    private ICasSysFacade casSysFacade;

    /**
     * 团队关联类型查询
     *
     * @param orgSceneTypeRelVo
     * @return
     */
    @RequestMapping("/qryOrgSceneTypeRel")
    public RetVo qryOrgSceneTypeRel(@RequestBody OrgSceneTypeRelVo orgSceneTypeRelVo) {
        try {
            RetVo retVo = new RetVo(true);
            //请后期的维护人员改vo--DTO
            orgSceneTypeRelVo.setRegionId(null);
            orgSceneTypeRelVo.setOrgId(null);
            orgSceneTypeRelVo.setStaffId(null);
            orgSceneTypeRelVo.setAreaId(CasSessionContext.getContext().getAreaId());
            PageInfo pageInfo = orgSceneTypeRelFacade.queryOrgBySceneType(orgSceneTypeRelVo);
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception ex) {
            ex.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(ex.getMessage());
            return retVo;
        }
    }

    /**
     * 删除关联团队类型
     *
     * @param orgSceneTypeRelDTO
     * @return
     */
    @RequestMapping("/delOrgSceneTypeRel")
    public RetVo delOrgSceneTypeRel(@RequestBody OrgSceneTypeRelDTO orgSceneTypeRelDTO) {
        try {
            RetVo retVo = new RetVo(true);
            int i = orgSceneTypeRelFacade.remove(orgSceneTypeRelDTO);
            if (i < 1) {
                retVo.setResult(false);
            }
            return retVo;
        } catch (Exception ex) {
            ex.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(ex.getMessage());
            return retVo;
        }
    }

    /**
     * 保存关联团队类型
     *
     * @param orgSceneTypeRelDTO
     * @return
     */
    @RequestMapping("/saveOrgSceneTypeOrg")
    public RetVo saveOrgSceneTypeOrg(@RequestBody OrgSceneTypeRelDTO orgSceneTypeRelDTO) {
        try {
            if (!StringUtils.isNullOrEmpty(orgSceneTypeRelDTO.getSceneTypes())) {
                String scenTypes = orgSceneTypeRelDTO.getSceneTypes().substring(0, orgSceneTypeRelDTO.getSceneTypes().length() - 1);
                orgSceneTypeRelDTO.setSceneTypes(scenTypes);
            }
            RetVo retVo = new RetVo(true);
            if (StringUtils.isNullOrEmpty(orgSceneTypeRelDTO.getOldOrgId())) {
               orgSceneTypeRelFacade.save(orgSceneTypeRelDTO);
            } else {
               orgSceneTypeRelFacade.update(orgSceneTypeRelDTO);
            }
            return retVo;
        } catch (Exception ex) {
            ex.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(ex.getMessage());
            return retVo;
        }
    }

    /**
     * 关联团队业务类型
     *
     * @return
     */
    @RequestMapping("/qryCheckBoxForOrgSceneTypeRel")
    public RetVo qryCheckBoxForOrgSceneTypeRel() {
        try {
            RetVo retVo = new RetVo(true);
            Map<String, List<AttrValueDTO>> mapBoxList = new HashMap<String, List<AttrValueDTO>>();
            List<AttrValueDTO> sceneTypeCheckList = casSysFacade.getAttrValues("PreSaleOrder", "sceneType");
            mapBoxList.put("sceneTypeCheckList", sceneTypeCheckList);
            retVo.setObject(mapBoxList);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }
}
