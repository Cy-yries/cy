package com.cy.cyw;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class CywApplicationTests {

    private final RestTemplate restTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    public void test_1() {
        try {
            File file = new File("C:\\Users\\28587\\Desktop\\xlsxToFile.xlsx");
            //PoiUtils.fileToWorkbook(file);
            //PoiUtils.excelToDataPrint(file,0,true);
            //PoiUtils.excelDataToMapColumn(file,0,0,1);
            /*List list = PoiUtils.excelDataToMapList(file, 0);
            System.out.println("list = " + list);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
