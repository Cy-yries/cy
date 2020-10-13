package com.cy.nacos_config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName NacosConfigController
 * @Author Yin
 * @Date 2020/10/13 16:02
 * @Version 1.0
 **/

@Controller
@RequestMapping("config")
public class NacosConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping("get")
    @ResponseBody
    public boolean get() {
        return useLocalCache;

    }
}