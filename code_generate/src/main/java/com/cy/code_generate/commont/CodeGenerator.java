package com.cy.code_generate.commont;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.cy.code_generate.config.CodeGenerateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CodeGenerator
 * @Author Yin
 * @Date 2021/2/3 10:58
 * @Version 1.0
 **/
@Component
@Slf4j
public class CodeGenerator {

    public static void codeGenerator() {

        log.debug("vvv=-|配置参数|-=vvv");
        log.debug("DIR_PATH_SRC:{}", CodeGenerateConfig.DIR_PATH_SRC);
        log.debug("MAPPER_PATH:{}", CodeGenerateConfig.MAPPER_PATH);
        log.debug("AUTHOR:{}", CodeGenerateConfig.AUTHOR);
        log.debug("URL:{}", CodeGenerateConfig.URL);
        log.debug("DRIVER_CLASS_NAME:{}", CodeGenerateConfig.DRIVER_CLASS_NAME);
        log.debug("USERNAME:{}", CodeGenerateConfig.USERNAME);
        log.debug("PASSWORD:{}", CodeGenerateConfig.PASSWORD);
        log.debug("MODEL_NAME:{}", CodeGenerateConfig.MODEL_NAME);
        log.debug("PACKAGE_NAME:{}", CodeGenerateConfig.PACKAGE_NAME);
        log.debug("INCLUDE_TABLE:{}", CodeGenerateConfig.INCLUDE_TABLE);


        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(CodeGenerateConfig.DIR_PATH_SRC);
        gc.setAuthor(CodeGenerateConfig.AUTHOR);
        gc.setFileOverride(true);
        gc.setIdType(IdType.AUTO);
        //gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(CodeGenerateConfig.URL);
        dsc.setDriverName(CodeGenerateConfig.DRIVER_CLASS_NAME);
        dsc.setUsername(CodeGenerateConfig.USERNAME);
        dsc.setPassword(CodeGenerateConfig.PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(CodeGenerateConfig.MODEL_NAME);
        pc.setParent(CodeGenerateConfig.PACKAGE_NAME);
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return CodeGenerateConfig.MAPPER_PATH + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setChainModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(false);
        strategy.setInclude(CodeGenerateConfig.INCLUDE_TABLE);
        strategy.setEnableSqlFilter(true);
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
