package com.cy.code_generate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * @ClassName CodeGenerateConfig
 * @Author Yin
 * @Date 2021/2/3 9:53
 * @Version 1.0
 **/
@Configuration
@PropertySource(value = "classpath:code_generate.yml", factory = YamlPropertySourceFactory.class)
public class CodeGenerateConfig {
    @Value("${spring.datasource.data-password}")
    private String password;
    @Value("${spring.datasource.data-username}")
    private String username;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;


    @Value("${code-generate.author:cy}")
    private String author;
    @Value("${code-generate.dirPath:code}")
    private String dirPath;
    @Value("${code-generate.modelName:#{null}}")
    private String modelName;
    @Value("${code-generate.packageName:#{null}}")
    private String packageName;
    @Value("${code-generate.includeTable:#{null}}")
    private String[] includeTable;

    public static String PASSWORD;
    public static String USERNAME;
    public static String DRIVER_CLASS_NAME;
    public static String URL;
    public static String AUTHOR;
    public static String DIR_PATH_SRC;
    public static String MAPPER_PATH;
    public static String MODEL_NAME;
    public static String PACKAGE_NAME;
    public static String[] INCLUDE_TABLE;

    @PostConstruct
    public void initStaticValue() {
        PASSWORD = this.password;
        USERNAME = this.username;
        DRIVER_CLASS_NAME = this.driverClassName;
        URL = this.url;

        AUTHOR = this.author;
        DIR_PATH_SRC = this.dirPath + "\\src\\main\\java";
        MAPPER_PATH = this.dirPath + "\\src\\main\\resources\\mapper\\";
        MODEL_NAME = this.modelName;
        PACKAGE_NAME = this.packageName;
        INCLUDE_TABLE = this.includeTable;
    }

}
