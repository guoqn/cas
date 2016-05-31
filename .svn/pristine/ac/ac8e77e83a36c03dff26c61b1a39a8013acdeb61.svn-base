package com.ffcs.crmd.cas.base.utils.export.eventmodel.intf;

import java.util.List;

/**
 * POI 事件模式行读取接口
 * 
 * @author chenjy-ffcs
 *
 */
public interface IExcelRowReader {
    
    /**
     * 业务实现方法(读取多行数据后具体要做的逻辑，比如插表)
     * 
     * @param sheetNum
     *            页号
     * @param rowNum
     *            行号
     * @param rowList
     *            多行的数据集合
     */
    public void getRowList(int sheetNum, int rowNum, List<List<String>> rowList);
    
    /**
     * 表格标题（默认只有一行）
     * .
     * 
     * @param sheetNum
     * @param rowNum
     * @param titleList
     * @author chenjy
     * 2016年1月13日 chenjy
     */
    public void getHeaderList(int sheetNum, int rowNum, List<String> titleList);
}
