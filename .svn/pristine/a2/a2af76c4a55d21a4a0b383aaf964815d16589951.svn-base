package com.ffcs.crmd.cas.base.utils.export.eventmodel;

import com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.IExcelRowReader;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * POI 事件模式
 * 抽象Excel2007读取器，excel2007的底层数据结构是xml文件，采用SAX的事件驱动的方法解析
 * xml，需要继承DefaultHandler，在遇到文件内容时，事件会触发，这种做法可以大大降低 内存的耗费，特别使用于大数据量的文件。
 * 
 */
public class Excel2007Reader extends DefaultHandler {
    // 共享字符串表
    private SharedStringsTable sst;
    // 上一次的内容
    private String             lastContents;
    private boolean            nextIsString;
    
    private int                sheetIndex = -1;
    //每行的数据
    private List<String>       dataList   = new ArrayList<String>();
    //多行的数据
    private List<List<String>> rowList    = new ArrayList<List<String>>();
    
    // 当前行
    private int                curRow     = 0;
    // 当前列
    private int                curCol     = 0;
    //每次读取多少行
    private int                rowNum     = 1;
    
    // 日期标志
    private boolean            dateFlag;
    
    private boolean            isTElement;
    
    private IExcelRowReader    rowReader;
    
    public Excel2007Reader(int rowNum) {
        if (rowNum > 1) {
            this.rowNum = rowNum;
        }
        
    }
    
    public void setRowReader(IExcelRowReader rowReader) {
        this.rowReader = rowReader;
    }
    
    /**
     * 只遍历一个电子表格，其中sheetId为要遍历的sheet索引，从1开始，1-3
     * 
     * @param filename
     * @param sheetId
     * @throws Exception
     */
    public void processOneSheet(String filename, int sheetId) {
        try {
            OPCPackage pkg = OPCPackage.open(filename);
            XSSFReader r = new XSSFReader(pkg);
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            
            // 根据 rId# 或 rSheet# 查找sheet
            InputStream sheet2 = r.getSheet("rId" + sheetId);
            sheetIndex++;
            InputSource sheetSource = new InputSource(sheet2);
            parser.parse(sheetSource);
            sheet2.close();
        } catch (BaseAppException e) {
            //已经封装好的业务异常直接往外抛
            throw e;
        } catch (Exception e) {
            ExceptionUtils.throwEx(e);
        }
        
    }
    
    /**
     * 遍历工作簿中所有的电子表格
     * 
     * @param inputStream
     * @throws Exception
     */
    public void process(InputStream inputStream) {
        try {
            OPCPackage pkg = OPCPackage.open(inputStream);
            XSSFReader r = new XSSFReader(pkg);
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            Iterator<InputStream> sheets = r.getSheetsData();
            while (sheets.hasNext()) {
                curRow = 0;
                sheetIndex++;
                InputStream sheet = sheets.next();
                InputSource sheetSource = new InputSource(sheet);
                parser.parse(sheetSource);
                sheet.close();
            }
        } catch (BaseAppException e) {
            //已经封装好的业务异常直接往外抛
            throw e;
        } catch (Exception e) {
            ExceptionUtils.throwEx(e);
        }
        
    }
    
    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
        this.sst = sst;
        parser.setContentHandler(this);
        return parser;
    }
    
    public void startElement(String uri, String localName, String name, Attributes attributes)
        throws SAXException {
        
        // c => 单元格
        if ("c".equals(name)) {
            // 如果下一个元素是 SST 的索引，则将nextIsString标记为true
            String cellType = attributes.getValue("t");
            if ("s".equals(cellType)) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
            // 日期格式
            String cellDateType = attributes.getValue("s");
            if (cellDateType != null && cellType != null && !"s".equals(cellType)) {
                dateFlag = true;
            } else {
                dateFlag = false;
            }
            
        }
        // 当元素为t时
        if ("t".equals(name)) {
            isTElement = true;
        } else {
            isTElement = false;
        }
        
        // 置空
        lastContents = "";
    }
    
    public void endElement(String uri, String localName, String name) {
        
        // 根据SST的索引值的到单元格的真正要存储的字符串
        // 这时characters()方法可能会被调用多次
        if (nextIsString) {
            try {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
            } catch (Exception e) {
                
            }
        }
        // t元素也包含字符串
        if (isTElement) {
            String value = lastContents.trim();
            dataList.add(curCol, value);
            curCol++;
            isTElement = false;
            // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
            // 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符
        } else if ("v".equals(name)) {
            String value = lastContents.trim();
            value = value.equals("") ? CasConstant.BLANK.getValue()
                : value;
            // 日期格式处理
            if (dateFlag) {
                Date date = HSSFDateUtil.getJavaDate(Double.valueOf(value));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                value = dateFormat.format(date);
            }
            
            dataList.add(curCol, value);
            curCol++;
        } else {
            // 如果标签名称为 row ，这说明已到行尾
            if (name.equals("row")) {
                if (curRow == 0) {
                    rowReader.getHeaderList(sheetIndex, curRow, this.dataList);
                    
                    this.dataList.clear();
                } else if (curRow % rowNum != 0) {
                    List<String> dataList = new ArrayList<String>();
                    for (String data : this.dataList) {
                        dataList.add(data);
                    }
                    this.dataList.clear();
                    this.rowList.add(dataList);
                } else {
                    List<String> dataList = new ArrayList<String>();
                    for (String data : this.dataList) {
                        dataList.add(data);
                    }
                    this.dataList.clear();
                    this.rowList.add(dataList);
                    
                    // 每rowNum 行结束时， 调用getRowDatas() 方法
                    rowReader.getRowList(sheetIndex, curRow, this.rowList);
                    this.rowList.clear();
                    
                }
                curRow++;
                curCol = 0;
            }
            //已经读到本页结尾
            if (name.equals("sheetData") && curRow > 0) {
                List<String> dataList = new ArrayList<String>();
                for (String data : this.dataList) {
                    dataList.add(data);
                }
                this.dataList.clear();
                this.rowList.add(dataList);
                
                rowReader.getRowList(sheetIndex, curRow, this.rowList);
                this.rowList.clear();
                curCol = 0;
            }
            
        }
        
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 得到单元格内容的值
        lastContents += new String(ch, start, length);
    }
}
