package com.ffcs.crmd.cas.order.control;

import com.ffcs.crmd.cas.base.utils.export.ExcelUtil;
import com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.IExcelRowReader;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.control.CrmdBaseController;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderHisDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderMaintanceDetailDTO;
import com.ffcs.crmd.cas.order.api.facade.IPreSaleOrderMaintananceFacade;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderHisVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qn_guo on 2016/3/23.
 * 滚动需求_预受理订单维护
 */
@Controller
@RequestMapping("/order/maintanace")
@ResponseBody
public class PreSaleOrderMaintanaceController extends CrmdBaseController {

    @Autowired
    private IPreSaleOrderMaintananceFacade preSaleOrderMaintananceFacade;

    /**
     * 根据FJ正式单号查询原关联P单号
     *
     * @param preSaleOrderHisVo
     * @return
     */
    @RequestMapping("/qryPreSaleOrderSrel")
    public RetVo qryPreSaleOrderSrel(@RequestBody PreSaleOrderHisVo preSaleOrderHisVo) {
        try {
            RetVo retVo = new RetVo(true);
            PreSaleOrderHisDTO preSaleOrderHisDTO =
                    preSaleOrderMaintananceFacade.queryOrderRelPreOrder(
                            preSaleOrderHisVo.getCustOrderNum());
            retVo.setObject(preSaleOrderHisDTO);
            return retVo;
        } catch (Exception e) {
            RetVo retVo = new RetVo(false);
            e.printStackTrace();
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 关联新的P单号
     *
     * @param preSaleOrderHisDTO
     * @return
     */
    @RequestMapping("/connectNewPreOrder")
    public RetVo connectNewPreOrder(@RequestBody PreSaleOrderHisDTO preSaleOrderHisDTO) {
        try {
            RetVo retVo = new RetVo(true);
            boolean result = preSaleOrderMaintananceFacade
                    .connectNewPreOrder(preSaleOrderHisDTO,
                            preSaleOrderHisDTO.getNewPreOrderNumber(), preSaleOrderHisDTO.getOriginator());
            if (!result) {
                retVo.setResult(result);
                return retVo;
            }
            return retVo;
        } catch (Exception e) {
            RetVo retVo = new RetVo(false);
            e.printStackTrace();
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 批量查询单号
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping("batchQryPreOrders")
    public RetVo batchQryPreOrders(@RequestParam("uploadFile") MultipartFile multipartFile)
            throws FileNotFoundException, IOException, Exception {
        try {
            final RetVo retVo = new RetVo(true);
            IExcelRowReader reader = new IExcelRowReader() {

                @Override
                public void getRowList(int sheetNum, int rowNum, List<List<String>> rowList) {
                    List<List<String>> rowRet = new ArrayList<>();
                    rowRet.addAll(rowList);
                    retVo.setObject(rowRet);
                }

                @Override
                public void getHeaderList(int sheetNum, int rowNum, List<String> titleList) {

                }
            };
            ExcelUtil.readExcel(reader, multipartFile.getOriginalFilename(),
                    multipartFile.getInputStream(), 1000);
            if (retVo.getObject() == null) {
                return retVo;
            }
            @SuppressWarnings("unchecked")
            List<List<String>> datas = (List<List<String>>) retVo.getObject();
            if (datas == null || datas.size() < 1) {
                return retVo;
            }
            List<PreSaleOrderMaintanceDetailDTO> detailDTOs = new ArrayList<>();
            for (List<String> strings : datas) {
                if (strings != null && strings.size() > 0) {
                    PreSaleOrderMaintanceDetailDTO batchDto = new PreSaleOrderMaintanceDetailDTO();
                    batchDto.setCustSoNumber(strings.get(0));
                    batchDto.setTargetPreOrderNumber(strings.get(1));
                    detailDTOs.add(batchDto);
                }
            }
            //调用后端服务返回dto
            PreSaleOrderMaintanceDTO maintanceDTO =
                    preSaleOrderMaintananceFacade.checkBatchConnect(detailDTOs);
            retVo.setObject(maintanceDTO);
            return retVo;
        } catch (Exception e) {
            RetVo retVo = new RetVo(false);
            e.printStackTrace();
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 确认关联按钮
     *
     * @param maintanceDTO
     * @return
     */
    @RequestMapping("batchConnectPreOrders")
    public RetVo batchConnectPreOrders(
            @RequestBody PreSaleOrderMaintanceDTO maintanceDTO) {
        try {
            RetVo retVo = new RetVo(true);
            boolean result = preSaleOrderMaintananceFacade.batchConnect(
                    maintanceDTO.getPreSaleOrderMaintanceDetailDTOList(), maintanceDTO.getOriginator());
            retVo.setResult(result);
            return retVo;
        } catch (Exception e) {
            RetVo retVo = new RetVo(false);
            e.printStackTrace();
            retVo.setMsgTitle(e.getMessage());
            return retVo;
        }
    }

    /**
     * 导出模板
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/exportTemplate", method = RequestMethod.POST)
    public ResponseEntity<byte[]> exportTemplates() throws Exception {
        List dtos = new ArrayList();
        List<String> headers = new ArrayList<>();
        headers.add("要关联的FJ单号");
        headers.add("要关联的P单号");
        headers.add("(请保留模板的第一行中文)");
        List<String> fields = new ArrayList<String>();
        return ExcelUtil.download("批量关联导入模板", CasConstant.EXCEL07_EXTENSION.getValue(), "sheet1",
                headers, fields, dtos, "");
    }
}
