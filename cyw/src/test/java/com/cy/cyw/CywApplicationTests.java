package com.cy.cyw;

import com.cy.cyw.utils.WebUtils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class CywApplicationTests {

    private final RestTemplate restTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    public void test_1() throws IOException, InvalidFormatException {
      //  WebUtils.xlsxToFile(restTemplate,null,null);
        WebUtils.xlsxToZip(restTemplate, null, null);
    }

}
