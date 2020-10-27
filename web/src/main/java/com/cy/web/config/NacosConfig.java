package com.cy.web.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * @ClassName NacosConfig
 * @Author Yin
 * @Date 2020/10/26 10:53
 * @Version 1.0
 **/
@Configuration
public class NacosConfig {

    @NacosInjected
    //使用该注解可注入NamingService和ConfigService
    private NamingService namingService;
    @NacosInjected
    private ConfigService configService;

    /*@PostConstruct
    //使用该注解的方法将会在构造函数完成后被自动调用
    private void registerInstance() throws NacosException {
        //注册服务实例
        namingService.registerInstance("demo", "127.0.0.1", 8888);
    }*/

    @PreDestroy
    //使用该注解的方法将会在servlet卸载完成后被自动调用
    private void deregisterInstance() throws NacosException {
        //注销服务实例
        namingService.deregisterInstance("demo", "127.0.0.1", 8888);
    }


}
