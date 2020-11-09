package com.cy.cyw;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@EnableConfigurationProperties
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class CywApplicationTests {
    private final RestTemplate restTemplate;
    private final CodeGenerator codeGenerator;
    @Test
    void contextLoads() {

    }
    @Test
    public void test_1() {
        System.out.println(codeGenerator);
    }

}
