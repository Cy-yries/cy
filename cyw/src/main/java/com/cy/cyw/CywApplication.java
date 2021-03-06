package com.cy.cyw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cy.cyw.mapper")
public class CywApplication {

    public static void main(String[] args) {
        SpringApplication.run(CywApplication.class, args);
    }

}
