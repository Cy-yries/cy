package com.cy.reptile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplate
 * @Author Yin
 * @Date 2020/11/17 17:57
 * @Version 1.0
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
