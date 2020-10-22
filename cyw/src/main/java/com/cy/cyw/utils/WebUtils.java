package com.cy.cyw.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @ClassName WebUtils
 * @Author Yin
 * @Date 2020/10/22 9:08
 * @Version 1.0
 **/
public class WebUtils {

    private RestTemplate restTemplate;

    /*将资源路径转为本地文件
     * */
    public static void urlToFile(RestTemplate restTemplate, String url, String path, String fileName) {
        // url = "http://1301915397.vod2.myqcloud.com/e5ac1d89vodcq1301915397/5d8a59c35285890808489882396/5z5yXOFxtaMA.jpg";
        path = "C:\\Users\\28587\\Desktop\\xlsxToFile\\";
        String pathName = path + fileName;
        try {
            Resource forObject = restTemplate.getForObject(url, Resource.class);
            InputStream inputStream = forObject.getInputStream();
            int index;
            byte[] bytes = new byte[1024];
            FileOutputStream downloadFile = new FileOutputStream(new File(pathName));
            while ((index = inputStream.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            inputStream.close();
            downloadFile.close();
            System.out.println("downloadFile = " + downloadFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void urlToFile(){

    }

    /*将xlsx表格转为本地文件
    第一列 文件名
    第二列 文件路径
     * */
    public static void xlsxToFile(RestTemplate restTemplate,String openPath,Integer sheetNum) throws InvalidFormatException, IOException {
        if (sheetNum==null){
            sheetNum=0;
        }
        if (openPath==null){
            openPath = "C:\\Users\\28587\\Desktop\\xlsxToFile.xlsx";
        }
        OPCPackage pkg = OPCPackage.open(openPath);
        XSSFWorkbook excel = new XSSFWorkbook(pkg);

        XSSFSheet sheet0 = excel.getSheetAt(sheetNum);

        String url = "";
        String fileName = "";

        for (Iterator rowIterator = sheet0.iterator(); rowIterator.hasNext(); ) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            int i=0;
            for (Iterator iterator = row.cellIterator(); iterator.hasNext(); ) {
                XSSFCell cell = (XSSFCell) iterator.next();

                String cellStr = "";
                if (cell.getCellTypeEnum() == CellType.STRING) cellStr = cell.getStringCellValue();
                else if (cell.getCellTypeEnum()  == CellType.NUMERIC) cellStr = cell.getNumericCellValue() + "";
                else if (cell.getCellTypeEnum() == CellType.FORMULA) cellStr = cell.getCellFormula();
                //System.out.println("fileName = " + fileName);
                if (i==0){
                    fileName=cellStr;
                    i++;
                }else{
                    url=cellStr;
                    fileName+=url.substring(url.lastIndexOf('.'));
                    WebUtils.urlToFile(restTemplate,url,"",fileName);
                    i=0;
                }
            }
            System.out.println("fileName = " + fileName);
            System.out.println("url = " + url);

        }


    }

    public static void xlsxToZip(RestTemplate restTemplate,String openPath,Integer sheetNum) throws InvalidFormatException, IOException {
        if (openPath==null){
            openPath = "C:\\Users\\28587\\Desktop\\xlsxToFile.xlsx";
        }
        if (sheetNum == null) {
            sheetNum = 0;
        }
        OPCPackage pkg = OPCPackage.open(openPath);
        XSSFWorkbook excel = new XSSFWorkbook(pkg);

        XSSFSheet sheet0 = excel.getSheetAt(sheetNum);

        String url = "";
        String fileName = "";

        for (Iterator rowIterator = sheet0.iterator(); rowIterator.hasNext(); ) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            int i = 0;
            for (Iterator iterator = row.cellIterator(); iterator.hasNext(); ) {
                XSSFCell cell = (XSSFCell) iterator.next();

                String cellStr = "";
                if (cell.getCellTypeEnum() == CellType.STRING) cellStr = cell.getStringCellValue();
                else if (cell.getCellTypeEnum() == CellType.NUMERIC) cellStr = cell.getNumericCellValue() + "";
                else if (cell.getCellTypeEnum() == CellType.FORMULA) cellStr = cell.getCellFormula();
                //System.out.println("fileName = " + fileName);
                if (i == 0) {
                    fileName = cellStr;
                    i++;
                } else {
                    url = cellStr;
                    fileName += url.substring(url.lastIndexOf('.'));
                    WebUtils.urlToFile(restTemplate, url, "", fileName);
                    i = 0;
                }
            }
            System.out.println("fileName = " + fileName);
            System.out.println("url = " + url);

        }
        FileUtils.toZip();
        FileUtils.deleteDir();
    }
}
