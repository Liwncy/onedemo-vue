package com.codefishing.onedemo.generator.util;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * MP代码生成工具类
 *
 * @author Liwncy
 */
public class MPGeneratorUtils {

  /**
   * 项目空间路径
   */
  private static final String PROJECT_PATH = System.getProperty("user.dir");
  private static final String OUT_ENTITY_PATH = "/onedemo-entity";
  private static final String OUT_API_PATH = "/onedemo-api";
  private static final String BASIC_PATH = "/src/main/java/";

  /**
   * 默认全局变量
   *
   * @return
   */
  public static GlobalConfig getGlobalDefaultConfig() {
    GlobalConfig gc = new GlobalConfig();

    gc.setOutputDir(BASIC_PATH);
    gc.setAuthor("Liwncy");
    gc.setIdType(IdType.INPUT);
    gc.setOpen(false);
    gc.setFileOverride(true);
    gc.setKotlin(false); // 是否生成 kotlin 代码
    gc.setEntityName("%sEntity");
    gc.setServiceName("%sService");
    gc.setDateType(DateType.ONLY_DATE);
    gc.setSwagger2(false);
    return gc;
  }

  /**
   * 默认数据源
   *
   * @return
   */
  public static DataSourceConfig getDataSourceDefaultConfig() {
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://localhost:3306/onedemo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
    dsc.setDriverName("com.mysql.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("123456");
    return dsc;
  }

  /**
   * 默认包配置
   *
   * @param moduleName
   * @return
   */
  public static PackageConfig getPackageDefaultConfig(String moduleName) {
    PackageConfig pc = new PackageConfig();
    String lowCaseModuleName = moduleName.toLowerCase();
    String parent = "com/codefishing/";
    String module = "onedemo/";
    String entity = "entity/" + lowCaseModuleName;
    String mapper = "mapper/" + lowCaseModuleName;
    String service = "service/" + lowCaseModuleName;
    String serviceImpl = "service/" + lowCaseModuleName + "/impl";
    String controller = "controller/" + lowCaseModuleName;
    pc.setModuleName("onedemo");
    pc.setParent("com.codefishing");
    pc.setEntity("entity." + lowCaseModuleName);// 实体类
    pc.setMapper("mapper." + lowCaseModuleName);
    pc.setXml("resources.mapper." + lowCaseModuleName);
    pc.setService("repository." + lowCaseModuleName);
    pc.setServiceImpl("repository." + lowCaseModuleName + ".impl");
    pc.setController("controller." + lowCaseModuleName);
    // 设置不同类文件生成的路径
    String entityModulePath = PROJECT_PATH + OUT_ENTITY_PATH + BASIC_PATH;
    String apiModulePath = PROJECT_PATH + OUT_API_PATH + BASIC_PATH;
    Map<String, String> pathMap = new HashMap();
    String entityPath = entityModulePath + parent + module + entity;
    pathMap.put(ConstVal.ENTITY_PATH, entityPath);
    String controllerPath = apiModulePath + parent + module + controller;
    pathMap.put(ConstVal.CONTROLLER_PATH, controllerPath);
    String servicePath = entityModulePath + parent + module + service;
    pathMap.put(ConstVal.SERVICE_PATH, servicePath);
    String serviceImplPath = entityModulePath + parent + module + serviceImpl;
    pathMap.put(ConstVal.SERVICE_IMPL_PATH, serviceImplPath);
    String mapperPath = entityModulePath + parent + module + mapper;
    pathMap.put(ConstVal.MAPPER_PATH, mapperPath);
    String xmlPath = PROJECT_PATH + OUT_ENTITY_PATH + "/src/main/resources/mapper/" + lowCaseModuleName;
    pathMap.put(ConstVal.XML_PATH, xmlPath);
    pc.setPathInfo(pathMap);
    return pc;
  }

  /**
   * 策略配置
   *
   * @param tableNames
   * @return
   */
  public static StrategyConfig getStrategyDefaultConfig(List<String> tableNames) {
    StrategyConfig strategy = new StrategyConfig();
    strategy.setInclude(tableNames.toArray(new String[0]));// 设置要映射的表名,可以是多个参数
    // 表前缀
    // strategy.setTablePrefix(moduleName);
    // strategy.setEnableSqlFilter(false);
    // 表名生成策略 underline_to_camel转驼峰命名，no_change默认的没变化
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 列名生成策略 underline_to_camel转驼峰命名，no_change默认的没变化
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setRestControllerStyle(true);
    // URLlocalhost:8080/hello_id_2
    strategy.setControllerMappingHyphenStyle(false);// localhost:8080/hello_id_2
    strategy.setEntityLombokModel(true);// 自动lombok；


    // 自定义实体父类
    strategy.setSuperEntityClass("com.codefishing.onedemo.entity.BaseEntity");
    // 自定义实体，公共字段
    // 自定义 mapper 父类
//    strategy.setSuperEntityColumns(new String[]{"SYS_CREATE_USER_CD", "SYS_CREATE_TIME", "SYS_UPDATE_USER_CD",
//      "SYS_UPDATE_TIME", "SYS_VERSION", "SYS_IS_DELETED"});
    return strategy;
  }

  /**
   * 自定义模版配置
   *
   * @return
   */
  public static TemplateConfig getTemplateDefaultConfig() {
    // 自定义controller的代码模板
    String controller_ext = "/template/java/controller_ext.java.vm";
    String entity_ext = "/template/java/entity_ext.java.vm";
    TemplateConfig templateConfig = new TemplateConfig();
    templateConfig.setController(controller_ext);
    templateConfig.setEntity(entity_ext);
    return templateConfig;
  }

  /**
   * 自定义配置
   *
   * @return
   */
  public static InjectionConfig getInjectionDefaultConfig(String modelName) {
    String lowCaseModuleName = modelName.toLowerCase();
    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    String templatePath = "";
    String apiModulePath = PROJECT_PATH + OUT_API_PATH + BASIC_PATH;
    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();

    String vo = "Vo";
    templatePath = "/template/java/" + vo + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return apiModulePath + "com/codefishing/onedemo/vo/" + lowCaseModuleName + "/" + toBasicName(tableInfo) + vo + ".java";
      }
    });

    String commonBean = "CommonBean";
    templatePath = "/template/java/" + commonBean + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return apiModulePath + "com/codefishing/onedemo/controller/" + lowCaseModuleName + "/form/" + toBasicName(tableInfo) + commonBean + ".java";
      }
    });

    String queryBean = "QueryBean";
    templatePath = "/template/java/" + queryBean + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return apiModulePath + "com/codefishing/onedemo/controller/" + lowCaseModuleName + "/form/" + toBasicName(tableInfo) + queryBean + ".java";
      }
    });

    cfg.setFileOutConfigList(focList);
    return cfg;
  }

  public static String toBasicName(TableInfo tableInfo) {
    String tablePrefix = tableInfo.getName().split("_")[0];
    String upTP = tablePrefix.substring(0, 1).toUpperCase() + tablePrefix.substring(1);
    tableInfo.setControllerName(StrUtil.removePrefix(tableInfo.getControllerName(), upTP));
    return StrUtil.removePrefix(tableInfo.getServiceName().replace("Service", ""), upTP);
  }
}
