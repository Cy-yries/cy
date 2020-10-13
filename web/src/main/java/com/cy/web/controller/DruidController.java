package com.cy.web.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DruidController
 * @Author Yin
 * @Date 2020/10/7 19:40
 * @Version 1.0
 **/
//druid 监控接口
@Controller
public class DruidController {
    @RestController
    public class DruidStatController {
        @GetMapping("/druid/stat")
        public Object druidStat(){
            // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
            return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        }
    }

}
