package com.devi.tool.util.excel;

import com.devi.tool.util.CalendarUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel工具类 Excel工具类，通过POI操作
 * <p>
 * [功能详细描述]
 * <p>
 */
public class ExcelUtil {
    /**
     * 最大导出限制50W条,针对200
     */
    public static final long MAX_EXP_COUNT_50W = 500000l;

    /**
     * 最大导出限制6W条,针对2003
     */
    public static final long MAX_EXP_COUNT_6W = 60000l;

    /**
     * 最大导入限制2000条
     */
    public static final int MAX_IMP_COUNT_2K = 2000;

    private static final String SEPARATOR = ".";

    public static String getFileName(String fileName, MsOfficeVersion officeVersion) {
        if (fileName.contains(SEPARATOR + officeVersion.getSuffix())) {
            return fileName;
        } else {
            return fileName + SEPARATOR + officeVersion.getSuffix();
        }
    }

    /**
     * 设置单元格的值，以及单元格格式（只有日期才设置格式）
     *
     * @param cell 单元格
     * @param dateformatStyle 日期单元格格式
     * @param alignStyle 水平位置格式
     * @param value 值
     */
    private static void setCell(Cell cell, CellStyle dateformatStyle, CellStyle alignStyle, Object value) {
        if (null == value) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue("");
        } else if (value instanceof String) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(value.toString());
        } else if (value instanceof Integer) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(((Integer) value).intValue());
        } else if (value instanceof Double) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(((Double) value).doubleValue());
        } else if (value instanceof Short) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(((Short) value).shortValue());
        } else if (value instanceof Date) {
            cell.setCellStyle(dateformatStyle);
            cell.setCellValue(((Date) value));
        } else if (value instanceof Long) {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(((Long) value).longValue());
        } else {
            cell.setCellStyle(alignStyle);
            cell.setCellValue(value.toString());
        }
    }

    /**
     * 将数据写入excel2007及以上，支持大量数据写入，超过固定内存刷新数据到磁盘。
     *
     * @param list
     * @param fieldNames
     * @param titleNames
     * @param rowBegin
     * @param outExcelFileName
     * @param sheetName
     * @return
     * @throws Exception
     */
    public static String writeToExcelFile(List<Map<String, Object>> list, String[] fieldNames, String[] titleNames,
                                          int rowBegin, String outExcelFileName, String sheetName) throws Exception {
        String outFileName = getFileName(outExcelFileName.trim(), MsOfficeVersion.Office2007);
        File outFile = new File(outFileName);
        if (!outFile.exists()) {
            if (outFile.getParentFile() != null && !outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            outFile.createNewFile();
        }
        FileOutputStream out = null;
        try {
            Workbook wb = new SXSSFWorkbook(100);
            SXSSFSheet sh = (SXSSFSheet) wb.createSheet(sheetName);
            sh.setRandomAccessWindowSize(100);
            int columnLength = fieldNames.length;
            Row row = sh.createRow(0);
            // 写入标题
            for (int cellnum = 0; cellnum < columnLength; cellnum++) {
                Cell cell = row.createCell(cellnum);
                cell.setCellValue((titleNames[cellnum]).toString());
            }
            // 写入字段
            row = sh.createRow(1);
            for (int cellnum = 0; cellnum < columnLength; cellnum++) {
                Cell cell = row.createCell(cellnum);
                cell.setCellValue((fieldNames[cellnum]).toString());
            }
            // 写入正文内容
            if (!list.isEmpty()) {
                int rowLength = list.size();

                for (int i = 0; i < rowLength; i++) {
                    row = sh.createRow(i + rowBegin);
                    Map<String, Object> m = list.get(i);
                    for (int cellnum = 0; cellnum < columnLength; cellnum++) {
                        Cell cell = row.createCell(cellnum);
                        String value = "";
                        if (null != m.get(fieldNames[cellnum])) {
                            value = transType(fieldNames, m, cellnum);
                        }

                        cell.setCellValue(value);
                    }
                }
                out = new FileOutputStream(outFile);
                wb.write(out);
            }
            return outFile.getAbsolutePath();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 将数据写入excel2007及以上，支持大量数据写入，超过固定内存刷新数据到磁盘。 同样的数据结构多个sheet页面
     *
     * @param fieldNames
     * @param titleNames
     * @param rowBegin
     * @param colBegin
     * @param outExcelFileName
     * @param datePattern
     * @return
     * @throws Exception
     */
    public static String writeToExcelFile(List<List<Map<String, Object>>> lists, String[] fieldNames,
                                          String[] titleNames, int rowBegin, int colBegin, String outExcelFileName, String[] sheetNames,
                                          String datePattern) throws Exception {
        String outFileName = getFileName(outExcelFileName.trim(), MsOfficeVersion.Office2007);
        File outFile = new File(outFileName);

        try {
            Workbook wb = null;
            if (outFile.exists()) {
                InputStream fs = new FileInputStream(outFile); // 获取存在的excel文件
                wb = new SXSSFWorkbook(new XSSFWorkbook(fs));
            } else {
                wb = new SXSSFWorkbook(100);
            }

            for (int sheetIndex = 0; sheetIndex < sheetNames.length; sheetIndex++) {
                String sheetName = sheetNames[sheetIndex];
                SXSSFSheet sh = null;
                if (wb.getSheetIndex(sheetName) >= 0) {
                    wb.removeSheetAt(wb.getSheetIndex(sheetName));
                    // sh=(SXSSFSheet) wb.getSheet(sheetName);
                    sh = (SXSSFSheet) wb.createSheet(sheetName);
                } else {
                    sh = (SXSSFSheet) wb.createSheet(sheetName);
                }

                sh.setRandomAccessWindowSize(100);
                int columnLength = fieldNames.length;
                Row row = sh.createRow(0);
                for (int cellnum = 0; cellnum < columnLength; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    cell.setCellValue((titleNames[cellnum]).toString());
                }
                List<Map<String, Object>> list = lists.get(sheetIndex);
                if (!list.isEmpty()) {
                    int rowLength = list.size();
                    for (int i = 0; i < rowLength; i++) {
                        row = sh.createRow(i + rowBegin);
                        Map<String, Object> m = list.get(i);
                        for (int cellnum = 0; cellnum < columnLength; cellnum++) {
                            Cell cell = row.createCell(cellnum);
                            String value = "";
                            if (null != m.get(fieldNames[cellnum])) {
                                value = transType(fieldNames, m, cellnum);
                            }
                            cell.setCellValue(value);
                        }
                    }
                }
            }
            FileOutputStream out = new FileOutputStream(outFile);
            wb.write(out);
            out.close();
            return outFile.getAbsolutePath();
        } finally {
        }
    }
    
    /**
     * excel追加数据
     *
     * @param dataInfos 需要显示的数据集合
     * @return excel对象
     */
    public static void exportExcelAppend(XSSFSheet sheet, List<List<String>> dataInfos) {
        int start = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < dataInfos.size(); i++) {
            Row row = sheet.createRow(i + start);
            List<String> datas = dataInfos.get(i);
            for (int j = 0; j < datas.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(datas.get(j));
            }
        }
    }

    public static String writeToExcelFile(String filePath, String title, List<String> headers,
                                          List<List<String>> dataInfos) throws Exception {
        XSSFWorkbook wb = exportExcel(title, headers, dataInfos);
        String outFileName = getFileName(filePath, MsOfficeVersion.Office2007);
        File outFile = new File(outFileName);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(outFile);
            wb.write(out);
            return outFile.getAbsolutePath();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * @param title 表格标题名
     * @param headers 表格属性列名数组
     * @param dataInfos 需要显示的数据集合
     * @return excel对象
     */
    public static XSSFWorkbook exportExcel(String title, List<String> headers, List<List<String>> dataInfos) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(title);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell;
        for (int i = 0; i < headers.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(headers.get(i));
        }

        for (int i = 0; i < dataInfos.size(); i++) {
            row = sheet.createRow(i + 1);
            List<String> datas = dataInfos.get(i);
            for (int j = 0; j < datas.size(); j++) {
                cell = row.createCell(j);
                cell.setCellValue(datas.get(j));
            }
        }
        return workbook;
    }

    /**
     * 上传文件，将Excel文件转换成list
     *
     * @param request
     * @param fileKey
     * @return
     * @throws Exception <br>
     * @author hzchendawei<br>
     * @taskId <br>
     */
    public static List<Map<String, Object>> uploadExcelToList(HttpServletRequest request, String fileKey)
            throws Exception {
        return uploadExcelToList(request, fileKey, null);
    }

    /**
     * 上传文件，将Excel文件转换成list
     *
     * @param request
     * @param fileKey
     * @param keyGen
     * @return
     * @throws Exception <br>
     * @author hzchendawei<br>
     * @taskId <br>
     */
    public static List<Map<String, Object>> uploadExcelToList(HttpServletRequest request, String fileKey,
                                                              IKeyGen keyGen) throws Exception {
        List<Map<String, Object>> excelContents = new ArrayList<Map<String, Object>>();
        // 强制类型转换
        DefaultMultipartHttpServletRequest uploadRequest = (DefaultMultipartHttpServletRequest) request;
        MultiValueMap<String, MultipartFile> fileMap = uploadRequest.getMultiFileMap();
        List<MultipartFile> fileItems = fileMap.get(fileKey);
        List<String> keys;
        XSSFWorkbook xwb = null;
        try {
            for (MultipartFile item : fileItems) {
                // 构造 XSSFWorkbook 对象，strPath 传入文件路径
                xwb = new XSSFWorkbook(item.getInputStream());
                Map<String, Object> tempMap;
                for (int index = 0; index < xwb.getNumberOfSheets(); index++) {
                    XSSFSheet sheet = xwb.getSheetAt(index);
                    // 定义 row、cell
                    XSSFRow row;
                    String cell;
                    int startRow = sheet.getFirstRowNum();
                    int endRow = sheet.getPhysicalNumberOfRows();
                    if (endRow == startRow) {
                        continue;
                    }
                    row = sheet.getRow(startRow);
                    int startCell = row.getFirstCellNum();
                    int endCell = row.getPhysicalNumberOfCells();
                    keys = getExcelKey(row, startCell, endCell, keyGen);
                    // 循环输出表格中的内容
                    for (int i = startRow + 1; i < endRow; i++) {
                        row = sheet.getRow(i);
                        if (row == null) {
                            continue;
                        }
                        tempMap = new HashMap<String, Object>();
                        for (int j = startCell; j < endCell; j++) {
                            // 通过 row.getCell(j).toString() 获取单元格内容，
                            if (row.getCell(j) != null) {
                                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                                cell = getStringCellValue(row.getCell(j)).trim();
                            } else {
                                cell = "";
                            }
                            tempMap.put(keys.get(j), cell);
                        }
                        if (!tempMap.isEmpty()) {
                            excelContents.add(tempMap);
                        }
                    }
                }
            }
        } finally {
            if (xwb != null) {
                xwb.close();
            }
        }
        return excelContents;
    }

    public static List<Map<String, Object>> uploadExcelToList(File item, IKeyGen keyGen) throws IOException {
        InputStream in = null;
        XSSFWorkbook xwb = null;
        try {
            List<Map<String, Object>> excelContents = new ArrayList<Map<String, Object>>();
            in = new FileInputStream(item);
            xwb = new XSSFWorkbook(in);
            Map<String, Object> tempMap;
            List<String> keys;
            XSSFSheet sheet = xwb.getSheetAt(0);
            // 定义 row、cell
            XSSFRow row;
            String cell;
            int startRow = sheet.getFirstRowNum();
            int endRow = sheet.getPhysicalNumberOfRows();
            row = sheet.getRow(startRow);
            int startCell = row.getFirstCellNum();
            int endCell = row.getPhysicalNumberOfCells();
            keys = getExcelKey(row, startCell, endCell, keyGen);
            // 循环输出表格中的内容
            for (int i = startRow + 1; i < endRow; i++) {
                row = sheet.getRow(i);
                tempMap = new HashMap<String, Object>();
                for (int j = startCell; j < endCell; j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    if (row.getCell(j) != null) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        cell = getStringCellValue(row.getCell(j)).trim();
                    } else {
                        cell = "";
                    }
                    tempMap.put(keys.get(j), cell);
                }
                if (!tempMap.isEmpty()) {
                    excelContents.add(tempMap);
                }
            }
            return excelContents;
        } finally {
            if (in != null) {
                in.close();
            }
            if (xwb != null) {
                xwb.close();
            }
        }
    }

    /**
     * 收集上传的Excel信息，该方法仅允许在controller中使用
     * 
     * @param item
     * @param keyGen
     * @return
     * @throws IOException
     */
    public static List<Map<String, Object>> uploadMultipartExcelToList(MultipartFile item, IKeyGen keyGen)
            throws IOException {
        List<Map<String, Object>> excelContents = new ArrayList<Map<String, Object>>();
        XSSFWorkbook xwb = null;
        try {
            xwb = new XSSFWorkbook(item.getInputStream());
            Map<String, Object> tempMap;
            List<String> keys;
            XSSFSheet sheet = xwb.getSheetAt(0);
            // 定义 row、cell
            XSSFRow row;
            String cell;
            int startRow = sheet.getFirstRowNum();
            int endRow = sheet.getPhysicalNumberOfRows();
            row = sheet.getRow(startRow);
            int startCell = row.getFirstCellNum();
            int endCell = row.getPhysicalNumberOfCells();
            keys = getExcelKey(row, startCell, endCell, keyGen);
            // 循环输出表格中的内容
            for (int i = startRow + 1; i < endRow; i++) {
                row = sheet.getRow(i);
                tempMap = new HashMap<String, Object>();
                for (int j = startCell; j < endCell; j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    if (row.getCell(j) != null) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        cell = getStringCellValue(row.getCell(j)).trim();
                    } else {
                        cell = "";
                    }
                    tempMap.put(keys.get(j), cell);
                }
                if (!tempMap.isEmpty()) {
                    excelContents.add(tempMap);
                }
            }
        } finally {
            if (xwb != null) {
                xwb.close();
            }
        }
        return excelContents;
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        String strCell = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                DecimalFormat df = new DecimalFormat("0");
                strCell = df.format(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 获取key
     *
     * @param startRow
     * @param startCell
     * @param endCell <br>
     * @return
     * @author chendawei<br>
     * @taskId <br>
     */
    private static List<String> getExcelKey(XSSFRow startRow, int startCell, int endCell, IKeyGen keyGen) {
        List<String> keys = new ArrayList<String>();
        String sourceKey;
        for (int j = startCell; j < endCell; j++) {
            sourceKey = startRow.getCell(j).toString().trim();
            if (keyGen != null) {
                // 若要严格校验模板此处判断下抛异常
                keys.add(keyGen.genNewKey(sourceKey.toUpperCase()));
            } else {
                keys.add(sourceKey);
            }

        }
        return keys;
    }

    /**
     * 生成key的映射
     *
     * @author hzchendawei<br>
     * @version 1.0<br>
     * @taskId <br>
     * @CreateDate 2016-1-11 <br>
     */
    public static interface IKeyGen {
        String genNewKey(String oldKey);
    }

    private static String transType(String[] fieldNames, Map<String, Object> m, int cellnum) {
        String value;
        if (m.get(fieldNames[cellnum]) instanceof Date) {
            value = CalendarUtil.toDateTimeStr((Date) m.get(fieldNames[cellnum]), "yyyy-MM-dd HH:mm:ss");
        } else {
            value = m.get(fieldNames[cellnum]).toString();
            if (value.contains("&lt;")) {
                value = value.replace("&lt;", "<");
                value = value.replace("&gt;", ">");
            }
        }
        return value;
    }

}