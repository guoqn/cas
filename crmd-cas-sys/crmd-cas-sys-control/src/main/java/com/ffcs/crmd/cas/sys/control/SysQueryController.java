package com.ffcs.crmd.cas.sys.control;

import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.PubConstant;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.sys.api.dto.AttrSpecDTO;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.cas.sys.vo.SysQueryVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/9
 * @功能说明：
 */

@Controller
@RequestMapping("/sys/sysQuery")
@ResponseBody
public class SysQueryController extends CrmdBaseController {

    @Autowired
    ICasSysFacade casSysFacade;

    /**
     * 获取受理类型
     * @param sysQueryVo
     * @return
     */
    @RequestMapping("/qrySceneType")
    public RetVo qrySceneType(@RequestBody SysQueryVo sysQueryVo) {
        try {
            RetVo retVo = new RetVo(true);
            retVo.setDataList(casSysFacade.qrySceneType(sysQueryVo.getClassCode(), sysQueryVo.getAttrSpecCode()));
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false);
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 获取CRM2地址
     *
     * @param urlCode
     * @return
     */
    @RequestMapping("/qryCrm2Url")
    public String qryCrm2Url(String urlCode) {
        AttrSpecDTO attrSpecDTO = casSysFacade.qryAttrSpecByCode(urlCode);
        if (attrSpecDTO != null) {
            return attrSpecDTO.getDefaultValue();
        }
        return "";
    }


    /**
     * 订单状态列表
     *
     * @return
     */
    @RequestMapping("/qryStatus")
    public RetVo qryStatus(@RequestBody SysQueryVo sysQueryVo) {
        try {
            RetVo retVo = new RetVo(true);
            List<AttrValueDTO> statusCdList
                    = casSysFacade.getAttrValues("PreSaleOrderPool", "statusCd");
            retVo.setDataList(statusCdList);
            return retVo;
        } catch (Exception e) {
            e.printStackTrace();
            RetVo retVo = new RetVo(false, e);
            retVo.setExceptions(null);
            return retVo;
        }
    }

}
