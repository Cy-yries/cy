package com.cy.cyw.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PoiUtils
 * @Author Yin
 * @Date 2020/10/15 17:57
 * @Version 1.0
 **/
public class PoiUtils {
    /*
    文件转为workbook对象
    * */
    public static Workbook excelToWorkbook(File file) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = null;
        if (isExcel2003(file.getName())) {
            workbook = new HSSFWorkbook(fileInputStream);
        } else if (isExcel2007(file.getName())) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else {
            throw new Exception("不是excel");
        }
        return workbook;
    }

    /*
     * 输出excel
     * */
    public static void excelToDataPrint(File file, Integer sheetAt, Boolean flag) throws Exception {
        Workbook workbook = excelToWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetAt);

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (flag) {
                    //获取并输出单元的位置和值
                    try {
                        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                        System.out.print(cellRef.formatAsString());
                        System.out.print(" - ");
                    } catch (Exception e) {
                        System.out.println("CellReference错误");
                        e.printStackTrace();
                    }
                    getCellValue(cell, true);
                } else {
                    getCellValue(cell, true);
                }
            }
        }
    }

    /*
     * 重载
     * */
    public static void excelToDataPrint(File file, Integer sheetAt) throws Exception {
        excelToDataPrint(file, sheetAt, false);
    }

    /*
     * 获取某两列的键值map
     * */
    public static Map excelDataToMapColumn(File file, Integer sheetAt, Integer oneIndex, Integer twoIndex) throws Exception {
        Map<String, String> map = new HashMap<>();
        Workbook workbook = excelToWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetAt);

        for (Row row : sheet) {
            String one = "";
            String two = "";
            for (Cell cell : row) {
                if (cell.getColumnIndex() == oneIndex) {
                    one = getCellValue(cell);
                }
                if (cell.getColumnIndex() == twoIndex) {
                    two = getCellValue(cell);
                }
            }
            map.put(one, two);
        }

      /*  Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            System.out.println( entry);
        }*/

        return map;
    }


    public static Map excelDataToMap(File file, Integer sheetAt) throws Exception {

        Map<String, String> map = new HashMap<>();
        Workbook workbook = excelToWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetAt);

        for (Row row : sheet) {
            for (Cell cell : row) {

            }
        }
        return map;
    }






    /*
    获取单元格的值 String
    * */
    public static String getCellValue(Cell cell, Boolean flag) {
        String str = "";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                str = String.valueOf(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    str = String.valueOf(cell.getDateCellValue());
                } else {
                    str = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                str = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                str = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                break;
            default:
        }
        if (flag) {
            System.out.println(str);
        }
        return str;
    }

    /*
     重载
    * */
    public static String getCellValue(Cell cell) {
        return getCellValue(cell, false);
    }


    // 判断是否是03的excel:xls
    private static boolean isExcel2003(String fileName) {
        return fileName.matches("^.+\\.(?i)(xls)$");
    }

    // 判断是否是07的excel:xlsx
    private static boolean isExcel2007(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }
}