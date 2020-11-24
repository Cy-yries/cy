package com.cy.reptile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName Reptlite
 * @Author Yin
 * @Date 2020/11/17 17:48
 * @Version 1.0
 **/
@SpringBootTest
public class Reptile {
    @Resource
    private RestTemplate restTemplate;
    @Test
    void reptile() {
        String forObject = restTemplate.getForObject("", String.class);
        System.out.println("forObject = " + forObject);
    }
}
