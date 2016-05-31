package com.ffcs.crmd.cas.base.utils.export;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ffcs.crmd.cas.base.utils.export.eventmodel.Excel2003Reader;
import com.ffcs.crmd.cas.base.utils.export.eventmodel.Excel2007Reader;
import com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.IExcelRowReader;
import com.ffcs.crmd.cas.base.utils.export.usermodel.intf.IExcelWriter;
import com.ffcs.crmd.cas.base.utils.export.usermodel.intf.impl.ExcelWriterImpl;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.ExhintConstant;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * excel POI工具类
 *
 * @author chenjy-ffcs
 */
public class ExcelUtil {

    /**
     * 用户模式：根据文件生成workbook
     * .
     *
     * @param file
     * @return
     * @author chenjy
     * 2016年1月14日 chenjy
     */
    public static Workbook genWorkbook(File file) {
        if (file == null) {
            return null;
        }
        InputStream inputStream = null;
        Workbook workbook = null;
        try {
            inputStream = new FileInputStream(file);
            String fileName = file.getName();
            if (fileName.endsWith(CasConstant.EXCEL03_EXTENSION.getValue())) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(CasConstant.EXCEL07_EXTENSION.getValue())) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                ExceptionUtils.throwEx(ExhintConstant.BUS10002.getValue());
            }
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
                }
            }
        }
        return workbook;
    }

    /**
     * 用户模式：根据文件流和文件名称生成workbook对象
     * .
     *
     * @param inputStream
     * @param fileName
     * @return
     * @author chenjy
     * 2016年1月14日 chenjy
     */
    public static Workbook genWorkbook(InputStream inputStream, String fileName) {

        if (inputStream == null) {
            return null;
        }
        if (StringUtils.isNullOrEmpty(fileName)) {
            return null;
        }
        Workbook workbook = null;
        try {
            if (fileName.endsWith(CasConstant.EXCEL03_EXTENSION.getValue())) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(CasConstant.EXCEL07_EXTENSION.getValue())) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                ExceptionUtils.throwEx(ExhintConstant.BUS10002.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
        }
        return workbook;
    }

    /**
     * 用户模式：根据参数生成workbook
     *
     * @param fileType 文件类型
     * @param title    sheet标题
     * @param headers  表头
     * @param fields   表中数据对象属性值（需要导出的字段）
     * @param dtos     表中数据对象list
     * @param pattren  日期格式
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Workbook genWorkbook(String fileType, String title, List<String> headers,
                                       List<String> fields, List dtos, String pattren) {

        if (!fileType.endsWith(CasConstant.EXCEL03_EXTENSION.getValue())
                && !fileType.endsWith(CasConstant.EXCEL07_EXTENSION.getValue())) {
            ExceptionUtils.throwEx(ExhintConstant.BUS10002.getValue());
        }
        IExcelWriter writer = new ExcelWriterImpl();
        return writer.exportExcel(fileType, title, headers, fields, dtos, pattren);

    }

    /**
     * 用户模式：文件下载生成文件流
     * .
     *
     * @param fileName 文件名称
     * @param fileType 文件后缀
     * @param title    sheet名称
     * @param headers  excel头部信息
     * @param fields   excel列对应的属性
     * @param dtos     excel导出的数据
     * @param pattren  日期格式
     * @return
     * @throws Exception
     * @author chenjy
     * 2016年1月4日 chenjy
     */
    @SuppressWarnings("rawtypes")
    public static ResponseEntity<byte[]> download(String fileName, String fileType, String title,
                                                  List<String> headers, List<String> fields, List dtos, String pattren) {
        try {
            Workbook workbook = ExcelUtil.genWorkbook(fileType, title, headers, fields, dtos,
                    pattren);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            workbook.write(os);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            httpHeaders.setContentDispositionFormData("attachment", new String(
                    (fileName + fileType).getBytes("gb2312"), "iso-8859-1"));
            return new ResponseEntity<byte[]>(os.toByteArray(), httpHeaders, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
        }
        return null;

    }

    /**
     * 用户模式：根据服务器下载的文件生成页面可下载的Excel
     * .
     *
     * @param content
     * @param fileName
     * @return
     * @author chenjy
     * 2016年1月16日 chenjy
     */
    public static ResponseEntity<byte[]> download(byte[] content, String fileName) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            httpHeaders.setContentDispositionFormData("attachment",
                    new String((fileName).getBytes("gb2312"), "iso-8859-1"));
            return new ResponseEntity<byte[]>(content, httpHeaders, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
        }
        return null;
    }

    /**
     * 事件模式：按行顺序读取excel
     *
     * @param rowReader
     * @param fileName
     * @param inputStream
     * @throws Exception
     */
    public static void readExcel(IExcelRowReader rowReader, String fileName,
                                 InputStream inputStream, int rowNum) {
        try {
            if (inputStream == null) {
                return;
            }
            if (StringUtils.isNullOrEmpty(fileName)) {
                return;
            }
            if (fileName.endsWith(CasConstant.EXCEL03_EXTENSION.getValue())) {
                Excel2003Reader excel03 = new Excel2003Reader(rowNum);
                excel03.setRowReader(rowReader);
                excel03.process(inputStream);
            } else if (fileName.endsWith(CasConstant.EXCEL07_EXTENSION.getValue())) {
                Excel2007Reader excel07 = new Excel2007Reader(rowNum);
                excel07.setRowReader(rowReader);
                excel07.process(inputStream);
            } else {
                ExceptionUtils.throwEx(ExhintConstant.BUS10002.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    ExceptionUtils.throwEx(ExhintConstant.SYS10001.getValue());
                }
            }
        }
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    public static String getStringCellValue(Cell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        return strCell;
    }
}
