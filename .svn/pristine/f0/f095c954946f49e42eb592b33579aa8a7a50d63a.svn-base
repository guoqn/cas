package com.ffcs.crmd.cas.base.utils.export.eventmodel;

import com.ffcs.crmd.cas.base.utils.export.eventmodel.intf.IExcelRowReader;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder.SheetRecordCollectingListener;
import org.apache.poi.hssf.eventusermodel.*;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * POI 事件模式
 * 抽象Excel2003读取器，通过实现HSSFListener监听器，采用事件驱动模式解析excel2003
 * 中的内容，遇到特定事件才会触发，大大减少了内存的使用。
 */
public class Excel2003Reader implements HSSFListener {
    private int minColumns = -1;
    private POIFSFileSystem fs;
    private int lastRowNumber;
    private int lastColumnNumber;

    /**
     * Should we output the formula, or the value it has?
     */
    private boolean outputFormulaValues = true;

    /**
     * For parsing Formulas
     */
    private SheetRecordCollectingListener workbookBuildingListener;
    // excel2003工作薄
    private HSSFWorkbook stubWorkbook;

    // Records we pick up as we process
    private SSTRecord sstRecord;
    private FormatTrackingHSSFListener formatListener;

    // 表索引
    private int sheetIndex = -1;
    private BoundSheetRecord[] orderedBSRs;
    @SuppressWarnings("rawtypes")
    private ArrayList boundSheetRecords = new ArrayList();

    // For handling formulas with string results
    private int nextRow;
    private int nextColumn;
    private boolean outputNextStringRecord;
    // 当前行
    private int curRow = 0;
    //每次读取多少行
    private int rowNum = 1;

    // 每行的内容
    private List<String> dataList = new ArrayList<String>();

    //多行的数据
    private List<List<String>> rowList = new ArrayList<List<String>>();

    @SuppressWarnings("unused")
    private String sheetName;

    private IExcelRowReader reader;

    public Excel2003Reader(int rowNum) {
        if (rowNum > 1) {
            this.rowNum = rowNum;
        }
    }

    public void setRowReader(IExcelRowReader reader) {
        this.reader = reader;
    }

    /**
     * 遍历excel下所有的sheet
     *
     * @throws IOException
     */
    public void process(InputStream inputStream) throws IOException {
        try {
            this.fs = new POIFSFileSystem(inputStream);
            MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(this);
            formatListener = new FormatTrackingHSSFListener(listener);
            HSSFEventFactory factory = new HSSFEventFactory();
            HSSFRequest request = new HSSFRequest();
            if (outputFormulaValues) {
                request.addListenerForAllRecords(formatListener);
            } else {
                workbookBuildingListener = new SheetRecordCollectingListener(formatListener);
                request.addListenerForAllRecords(workbookBuildingListener);
            }
            factory.processWorkbookEvents(request, fs);
        } catch (BaseAppException e) {
            //已经封装好的业务异常直接往外抛
            throw e;
        } catch (Exception e) {
            ExceptionUtils.throwEx(e);
        }

    }

    /**
     * HSSFListener 监听方法，处理 Record
     */
    @SuppressWarnings("unchecked")
    public void processRecord(Record record) {
        int thisRow = -1;
        int thisColumn = -1;
        String thisStr = null;
        String value = null;
        switch (record.getSid()) {
            case BoundSheetRecord.sid:
                boundSheetRecords.add(record);
                break;
            case BOFRecord.sid:
                BOFRecord br = (BOFRecord) record;
                if (br.getType() == BOFRecord.TYPE_WORKSHEET) {
                    // 如果有需要，则建立子工作薄
                    if (workbookBuildingListener != null && stubWorkbook == null) {
                        stubWorkbook = workbookBuildingListener.getStubHSSFWorkbook();
                    }

                    sheetIndex++;
                    if (orderedBSRs == null) {
                        orderedBSRs = BoundSheetRecord.orderByBofPosition(boundSheetRecords);
                    }
                    sheetName = orderedBSRs[sheetIndex].getSheetname();
                }
                break;

            case SSTRecord.sid:
                sstRecord = (SSTRecord) record;
                break;

            case BlankRecord.sid:
                BlankRecord brec = (BlankRecord) record;
                thisRow = brec.getRow();
                thisColumn = brec.getColumn();
                thisStr = "";
                dataList.add(thisColumn, thisStr);
                break;
            case BoolErrRecord.sid: // 单元格为布尔类型
                BoolErrRecord berec = (BoolErrRecord) record;
                thisRow = berec.getRow();
                thisColumn = berec.getColumn();
                thisStr = berec.getBooleanValue() + "";
                dataList.add(thisColumn, thisStr);
                break;

            case FormulaRecord.sid: // 单元格为公式类型
                FormulaRecord frec = (FormulaRecord) record;
                thisRow = frec.getRow();
                thisColumn = frec.getColumn();
                if (outputFormulaValues) {
                    if (Double.isNaN(frec.getValue())) {
                        // Formula result is a string
                        // This is stored in the next record
                        outputNextStringRecord = true;
                        nextRow = frec.getRow();
                        nextColumn = frec.getColumn();
                    } else {
                        thisStr = formatListener.formatNumberDateCell(frec);
                    }
                } else {
                    thisStr = '"' + HSSFFormulaParser.toFormulaString(stubWorkbook,
                            frec.getParsedExpression()) + '"';
                }
                dataList.add(thisColumn, thisStr);
                break;
            case StringRecord.sid:// 单元格中公式的字符串
                if (outputNextStringRecord) {
                    // String for formula
                    StringRecord srec = (StringRecord) record;
                    thisStr = srec.getString();
                    thisRow = nextRow;
                    thisColumn = nextColumn;
                    outputNextStringRecord = false;
                }
                break;
            case LabelRecord.sid:
                LabelRecord lrec = (LabelRecord) record;
                thisRow = lrec.getRow();
                thisColumn = lrec.getColumn();
                value = lrec.getValue().trim();
                value = value.equals("") ? " "
                        : value;
                this.dataList.add(thisColumn, value);
                break;
            case LabelSSTRecord.sid: // 单元格为字符串类型
                LabelSSTRecord lsrec = (LabelSSTRecord) record;
                thisRow = lsrec.getRow();
                thisColumn = lsrec.getColumn();
                if (sstRecord == null) {
                    dataList.add(thisColumn, " ");
                } else {
                    value = sstRecord.getString(lsrec.getSSTIndex()).toString().trim();
                    value = value.equals("") ? " "
                            : value;
                    dataList.add(thisColumn, value);
                }
                break;
            case NumberRecord.sid: // 单元格为数字类型
                NumberRecord numrec = (NumberRecord) record;
                thisRow = numrec.getRow();
                thisColumn = numrec.getColumn();
                value = formatListener.formatNumberDateCell(numrec).trim();
                value = value.equals("") ? " "
                        : value;
                // 向容器加入列值
                dataList.add(thisColumn, value);
                break;
            default:
                break;
        }

        // 遇到新行的操作
        if (thisRow != -1 && thisRow != lastRowNumber) {
            lastColumnNumber = -1;
        }

        // 空值的操作
        if (record instanceof MissingCellDummyRecord) {
            MissingCellDummyRecord mc = (MissingCellDummyRecord) record;
            thisRow = mc.getRow();
            thisColumn = mc.getColumn();
            dataList.add(thisColumn, CasConstant.BLANK.getValue());
        }

        // 更新行和列的值
        if (thisRow > -1)
            lastRowNumber = thisRow;
        if (thisColumn > -1)
            lastColumnNumber = thisColumn;

        // 行结束时的操作
        if (record instanceof LastCellOfRowDummyRecord) {
            if (minColumns > 0) {
                // 列值重新置空
                if (lastColumnNumber == -1) {
                    lastColumnNumber = 0;
                }
            }
            lastColumnNumber = -1;

            if (curRow == 0) {

                reader.getHeaderList(sheetIndex, curRow, dataList);

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
                reader.getRowList(sheetIndex, curRow, rowList);
                this.rowList.clear();
            }
            curRow++;

        }
        //已经读到本页结尾
        if (record instanceof WindowTwoRecord) {
            if (rowList != null && rowList.size() > 0) {
                List<String> dataList = new ArrayList<String>();
                for (String data : this.dataList) {
                    dataList.add(data);
                }
                this.dataList.clear();
                this.rowList.add(dataList);
                reader.getRowList(sheetIndex, curRow, rowList);
                this.rowList.clear();
            }
        }
    }
}
