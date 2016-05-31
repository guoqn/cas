package com.ffcs.crmd.cas.base.utils.export.usermodel.intf.impl;

import com.ffcs.crmd.cas.base.utils.export.usermodel.intf.IExcelWriter;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelWriterImpl implements IExcelWriter {
    /**
     * 
     * @param title
     *            表格标题名
     * @param headers
     *            表格列名
     * @param fields
     *            表格列对象字段
     * @param dtos
     *            需要导出的数据对象
     * @param pattern
     *            时间的输出格式，默认“yyyy-MM-dd HH:mm:ss”
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    public Workbook exportExcel(String fileType, String title, List<String> headers,
        List<String> fields, List dtos, String pattern) {
        Workbook workbook = null;
        try {
            
            if (CasConstant.EXCEL03_EXTENSION.getValue().equals(fileType)) {
                // 声明一个工作薄
                workbook = new HSSFWorkbook();
            } else if (CasConstant.EXCEL07_EXTENSION.getValue().equals(fileType)) {
                // 声明一个工作薄
                workbook = new SXSSFWorkbook(1000);
            }
            
            // 生成一个表格
            Sheet sheet = workbook.createSheet(title);
            
            // 产生表格标题行
            Row row = sheet.createRow(0);
            if (headers != null) {
                for (short i = 0; i < headers.size(); i++) {
                    Cell cell = row.createCell(i);
                    RichTextString text = getRichTextString(fileType, headers.get(i));
                    cell.setCellValue(text);
                }
            }
            
            if (dtos == null) {
                return workbook;
            }
            
            // 遍历集合数据，产生数据行
            Iterator it = dtos.iterator();
            int index = 0;
            
            List<String> methods = new ArrayList<String>();
            if (fields != null) {
                for (String field : fields) {
                    String getMethodName = "get" + field.substring(0, 1).toUpperCase()
                        + field.substring(1);
                    methods.add(getMethodName);
                }
            }
            
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                Object t = it.next();
                // 利用反射，根据fields属性的先后顺序，动态调用getXxx()方法得到属性值
                for (short i = 0; i < methods.size(); i++) {
                    Cell cell = row.createCell(i);
                    String getMethodName = methods.get(i);
                    
                    Class tCls = t.getClass();
                    Method getMethod;
                    getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    
                    Object value;
                    value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value == null) {
                        continue;
                    }
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        if (pattern == null || pattern.equals("")) {
                            pattern = "yyyy-MM-dd HH:mm:ss";
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            RichTextString richString = getRichTextString(fileType, textValue);
                            cell.setCellValue(richString);
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            ExceptionUtils.throwEx(e);
        }
        return workbook;
    }
    
    /**
     * bugfix－不同版本的excel获取单元格值
     * .
     * 
     * @param fileType
     * @param textValue
     * @return
     * @author wangxl-ffcs
     * 2016年1月5日 wangxl-ffcs
     */
    private RichTextString getRichTextString(String fileType, String textValue) {
        RichTextString text = null;
        if (CasConstant.EXCEL03_EXTENSION.getValue().equals(fileType)) {
            text = new HSSFRichTextString(textValue);
        } else if (CasConstant.EXCEL07_EXTENSION.getValue().equals(fileType)) {
            text = new XSSFRichTextString(textValue);
        }
        return text;
    }
}
