package com.cy.web.cyTest;

import com.cy.web.utils.PoiUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CyTests
 * @Author Yin
 * @Date 2020/10/4 18:10
 * @Version 1.0
 **/

public class CyTests {

    @Test
    public void demo_1() throws IOException {
        String path = "C:\\Users\\28587\\Documents\\WeChat Files\\wxid_tfq5gayl6ix122\\FileStorage\\File\\2020-10\\综合报表(1).xlsx";
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        List<String[]> readExcel = PoiUtils.readExcel(inputStream, file.getName(), 4, 0);
        System.out.println("readExcel = " + readExcel);
        for (String[] strings : readExcel) {
            System.out.println();
            System.out.println(Arrays.toString(strings));
        }

    }

    @Test
    public static void demo_2() {
        //Unifiedorder unifiedorder = new Unifiedorder();
       // System.out.println("unifiedorder = " + unifiedorder);
    }

    public static void main(String[] args) throws NoSuchFieldException {
    
    }
}




