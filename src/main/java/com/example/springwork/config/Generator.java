package com.example.springwork.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.springwork.pojo.BasePojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {
    public static void main(String[] args) {
        // 构建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //生成代码
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//getProperty获取环境变量，通过属性名获取属性值，user.dir代表当前项目路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("jinyaxu");//作者
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);//加载配置
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/management?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.springwork");
        pc.setEntity("pojo");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        Map<String,String> pathInfo = new HashMap<>();
        pathInfo.put("xml_path",projectPath+"/src/main/resources/com/jyx/mapper");
        pathInfo.put("entity_path",projectPath+"/src/main/java/com/example/springwork/pojo");
        pathInfo.put("mapper_path",projectPath+"/src/main/java/com/example/springwork/mapper");
        pathInfo.put("service_path",projectPath+"/src/main/java/com/example/springwork/service");
        pathInfo.put("service_impl_path",projectPath+"/src/main/java/com/example/springwork/service/impl");
        pathInfo.put("controller_path",projectPath+"/src/main/java/com/example/springwork/controller");
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);
        // 策略配置：下划线转驼峰
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BasePojo.class);//继承父类
        strategy.setEntityLombokModel(true);//使用data注解
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");//不生成id，因为继承了父类
        strategy.setInclude("user");//表名
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //生成代码
        mpg.execute();
    }
}
