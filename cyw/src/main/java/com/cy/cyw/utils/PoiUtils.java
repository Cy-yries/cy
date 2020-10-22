package com.cy.cyw.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

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
    public static Workbook fileToWorkbook(File file) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = null;
        if (isExcel2003(file.getName())) {
            workbook = new HSSFWorkbook(fileInputStream);
            //System.out.println("03");
        } else if (isExcel2007(file.getName())) {
            workbook = new XSSFWorkbook(fileInputStream);
            //System.out.println("07");
        } else {
            throw new Exception("不是excel");
        }
        //System.out.println(workbook);
        return workbook;
    }

    public static void fileToData(File file, Integer sheetAt) throws Exception {
        Workbook workbook = fileToWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetAt);

        for (Row row : sheet) {
            for (Cell cell : row) {
                //下面这几行应该是获取单元的位置比如：A1
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case BLANK:
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }


        }
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