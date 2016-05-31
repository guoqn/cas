package com.ffcs.crmd.cas.base.utils.export.usermodel.intf;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * 用户模式 excel 构造器
 * @author chenjy-ffcs
 *
 */
public interface IExcelWriter {
    @SuppressWarnings("rawtypes")
    public Workbook exportExcel(String fileType, String title, List<String> headers,
                                List<String> fields, List dtos, String pattern);
}
