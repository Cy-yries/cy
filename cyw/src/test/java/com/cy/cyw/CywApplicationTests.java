package com.cy.cyw;

import com.cy.cyw.utils.PoiUtils;
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
    public void test_1(){

        try {
            File file  = new File("C:\\Users\\28587\\Desktop\\xlsxToFile.xlsx");
            //PoiUtils.fileToWorkbook(file);
            PoiUtils.fileToData(file,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
