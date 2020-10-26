package com.cy.web.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ClassName NacosConfig
 * @Author Yin
 * @Date 2020/10/26 10:53
 * @Version 1.0
 **/
@Configuration
public class NacosConfig {

    @NacosInjected
    //使用该注解获取或注册实例
    private NamingService namingService;

    @PostConstruct
    //使用该注解的方法将会在依赖注入完成后被自动调用
    private void registerInstance() throws NacosException {
    namingService.registerInstance("demo","127.0.0.1", 8888);
    }

}
