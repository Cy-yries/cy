package com.cy.cy_pay;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class CyPayApplicationTests {

    private final RestTemplate restTemplate;

    @Test
    void contextLoads() {

    }

}
