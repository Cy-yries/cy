package com.cy.cyw;

import com.cy.cyw.utils.WebUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName OtherTests
 * @Author Yin
 * @Date 2020/10/22 14:18
 * @Version 1.0
 **/

@SpringBootTest
public class OtherTests {

    @Resource
    private RestTemplate restTemplate;


    @Test
    public void xlsxTest() throws IOException, InvalidFormatException {
        //  WebUtils.xlsxToFile(restTemplate,null,null);
        WebUtils.xlsxToZip(restTemplate, null, null);
    }



}
