package com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.impl;


import com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.IExcelRowReader;

import java.util.List;

/**
 * POI 事件模式行读取实现类例子 （开发时具体的实现类放在具体的模块下面）
 * @author chenjy-ffcs
 *
 */
public class ExcelRowReaderImpl implements IExcelRowReader {
    
    @Override
    public void getRowList(int sheetNum, int rowNum, List<List<String>> rowList) {
    }
    
    @Override
    public void getHeaderList(int sheetNum, int rowNum, List<String> titleList) {
    }
    
}
