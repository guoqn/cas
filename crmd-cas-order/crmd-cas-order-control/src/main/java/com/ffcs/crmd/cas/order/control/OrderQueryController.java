package com.ffcs.crmd.cas.order.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.dto.InteractionAssignOrgDTO;
import com.ffcs.crmd.cas.order.api.dto.InteractionFlowDTO;
import com.ffcs.crmd.cas.order.api.facade.IInteractionAssignOrgFacade;
import com.ffcs.crmd.cas.order.api.facade.IInteractionFlowFacade;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;
import com.ffcs.crmd.cas.order.api.vo.InteractionFlowVo;
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
 * 工单池配置
 * Created by qn_guo on 2016/1/9.
 */
@Controller
@RequestMapping("/order/orderQuery")
@ResponseBody
public class OrderQueryController extends CrmdBaseController {

    @Autowired
    private IInteractionFlowFacade interactionFlowFacade;
    @Autowired
    private IInteractionAssignOrgFacade interactionAssignOrgFacade;
    @Autowired
    private ICasSysFacade casSysFacade;

    /**
     * 根据流程名称查询流程
     *
     * @param interactionFlowVo
     * @return
     */
    @RequestMapping("/qryInterActionFlowList")
    public RetVo qryInterActionFlowList(@RequestBody InteractionFlowVo interactionFlowVo) {
        try {
            RetVo retVo = new RetVo(true);
            interactionFlowVo.setAreaId(CasSessionContext.getContext().getAreaId());
            PageInfo pageInfo = interactionFlowFacade.queryFlowByName(interactionFlowVo);
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 根据流程条件和ID查询团队
     *
     * @param interactionAssignOrgVo
     * @return
     */
    @RequestMapping("/qryInterActionAssignOrgs")
    public RetVo qryInterActionAssignOrgs(@RequestBody InteractionAssignOrgVo interactionAssignOrgVo) {
        try {
            RetVo retVo = new RetVo(true);
            interactionAssignOrgVo.setAreaId(CasSessionContext.getContext().getAreaId());
            PageInfo pageInfo = interactionAssignOrgFacade.queryAssignOrg(interactionAssignOrgVo);
            retVo.setPageInfo(pageInfo);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 初始化下拉框
     *
     * @return
     */
    @RequestMapping("/queryAllBoxListForInteractionFlow")
    public RetVo queryAllBoxListForInteractionFlow() {
        try {
            RetVo retVo = new RetVo(true);
            Map<String, List<AttrValueDTO>> mapBoxList = new HashMap<String, List<AttrValueDTO>>();
            List<AttrValueDTO> custItemTypeGroupList = casSysFacade.getAttrValues("InteractionFlow", "custItemTypeGroup");
            mapBoxList.put("custItemTypeGroupList", custItemTypeGroupList);
            List<AttrValueDTO> statusCdList = casSysFacade.getAttrValues("CrmEntityImpl", "statusCd");
            mapBoxList.put("statusCdList", statusCdList);
            retVo.setObject(mapBoxList);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 删除流程
     *
     * @param interactionFlowDTO
     * @return
     */
    @RequestMapping("/delInteractionFlow")
    public RetVo delInteractionFlow(@RequestBody InteractionFlowDTO interactionFlowDTO) {
        interactionFlowDTO.setShardingId(1L);
        try {
            RetVo retVo = new RetVo(true);

            int i = interactionFlowFacade.remove(interactionFlowDTO);
            if (i < 1) retVo.setResult(false);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 判断删除流程是有存在转派团队
     * @param interactionAssignOrgVo
     * @return
     */
    @RequestMapping("/qryAssignOrgCount")
    public RetVo qryAssignOrgCount(@RequestBody InteractionAssignOrgVo interactionAssignOrgVo) {
        try {
            RetVo retVo = new RetVo(true);
            PageInfo pageInfo = interactionAssignOrgFacade.queryAssignOrg(interactionAssignOrgVo);
            if (pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size() > 0) {
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
     * 保存流程
     *
     * @param interactionFlowDTO
     * @return
     */
    @RequestMapping("/saveInteractionFlow")
    public RetVo saveInteractionFlow(@RequestBody InteractionFlowDTO interactionFlowDTO) {
        try {
            int i = 0;
            RetVo retVo = new RetVo(true);
            interactionFlowDTO.setShardingId(1L);
            interactionFlowDTO.setCustItemTypeGroup("pre_sale_order_pool");
            if (StringUtils.isNullOrEmpty(interactionFlowDTO.getInteractionFlowId())) {
                i = interactionFlowFacade.save(interactionFlowDTO); //新增
            } else {
                i = interactionFlowFacade.update(interactionFlowDTO);  //修改
            }
            if (i < 1) retVo.setResult(false);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 删除受理团队
     *
     * @param interactionAssignOrgDTO
     * @return
     */
    @RequestMapping("/delInteractionAssignOrg")
    public RetVo delInteractionAssignOrg(@RequestBody InteractionAssignOrgDTO interactionAssignOrgDTO) {
        try {
            interactionAssignOrgDTO.setShardingId(1L);
            RetVo retVo = new RetVo(true);
            int i = interactionAssignOrgFacade.remove(interactionAssignOrgDTO);
            if (i < 1) retVo.setResult(false);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 保存受理团队
     *
     * @param interactionAssignOrgDTO
     * @return
     */
    @RequestMapping("/saveInteractionAssignOrg")
    public RetVo saveInteractionAssignOrg(@RequestBody InteractionAssignOrgDTO interactionAssignOrgDTO) {
        try {
            int i = 0;
            RetVo retVo = new RetVo(true);
            interactionAssignOrgDTO.setShardingId(1L);
            if (StringUtils.isNullOrEmpty(interactionAssignOrgDTO.getInteractionAssignOrgId())) {
                i = interactionAssignOrgFacade.save(interactionAssignOrgDTO); //新增
            } else {
                i = interactionAssignOrgFacade.update(interactionAssignOrgDTO);  //修改
            }
            if (i < 1) {
                retVo.setResult(false);
            }
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }
}
