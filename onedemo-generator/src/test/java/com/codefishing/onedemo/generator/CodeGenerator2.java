package com.codefishing.onedemo.generator;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator2 {


  public void genCodeByModule() {
    String moduleName = "SM";
    //String tablesName = "SM.*";
    String tablesName = "SM_DLMAST_CDC";
    String serviceType = "service";
    genCode(moduleName, tablesName);
  }


  public void genBasicPage() {

  }

  public void genCode(String moduleName, String... tablesName) {
    // 需要构建一个 代码自动生成器 对象
    AutoGenerator mpg = new AutoGenerator();
    // 配置策略
    // 1、全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    String basicPath = projectPath + "/src/main/java/";

    gc.setOutputDir(basicPath);
    gc.setAuthor("pms");
    gc.setIdType(IdType.INPUT);
    gc.setOpen(false);
    gc.setFileOverride(true);
    gc.setKotlin(false); // 是否生成 kotlin 代码
    gc.setEntityName("%sEntity");
    gc.setServiceName("%sService");
    gc.setDateType(DateType.ONLY_DATE);
    gc.setSwagger2(false);
    mpg.setGlobalConfig(gc);
    // 2、设置数据源
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:db2://10.110.37.158:50400/PMSDEV:currentSchema=PMS;");
    dsc.setDriverName("com.ibm.db2.jcc.DB2Driver");
    dsc.setUsername("pmsadm");
    dsc.setPassword("GHac@2021");

    mpg.setDataSource(dsc);
    // 3、包的配置
    PackageConfig pc = new PackageConfig();
    String lowCaseModuleName = moduleName.toLowerCase();
    String systemName = "pms/";
    String parent = "com/pactera/";
    String entity = "entity/" + lowCaseModuleName;
    String mapper = "mapper/" + lowCaseModuleName;
    String service = "repository/" + lowCaseModuleName;
    String serviceImpl = "repository/" + lowCaseModuleName + "/impl";
    String controller = "controller/" + lowCaseModuleName;
    pc.setModuleName("pms");
    pc.setParent("com.pactera");
    pc.setEntity("entity." + lowCaseModuleName);// 实体类
    pc.setMapper("mapper." + lowCaseModuleName);
    pc.setXml("resources.mapper." + lowCaseModuleName);
    pc.setService("repository." + lowCaseModuleName);
    pc.setServiceImpl("repository." + lowCaseModuleName + ".impl");
    pc.setController("controller." + lowCaseModuleName);
    // 设置不同类文件生成的路径
    Map<String, String> pathMap = new HashMap();
    String entityPath = basicPath + parent + systemName + entity;
    pathMap.put(ConstVal.ENTITY_PATH, entityPath);
    String mapperPath = basicPath + parent + systemName + mapper;
    pathMap.put(ConstVal.MAPPER_PATH, mapperPath);
    String servicePath = basicPath + parent + systemName + service;
    pathMap.put(ConstVal.SERVICE_PATH, servicePath);
    String serviceImplPath = basicPath + parent + systemName + serviceImpl;
    pathMap.put(ConstVal.SERVICE_IMPL_PATH, serviceImplPath);
    String controllerPath = basicPath + parent + systemName + controller;
    pathMap.put(ConstVal.CONTROLLER_PATH, controllerPath);
    pathMap.put(ConstVal.XML_PATH, projectPath + "/src/main/resources/mapper/" + lowCaseModuleName);
    pc.setPathInfo(pathMap);
    mpg.setPackageInfo(pc);

    // 4、策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setInclude(tablesName);// 设置要映射的表名,可以是多个参数
    //strategy.setTablePrefix(moduleName);
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
    strategy.setSuperEntityClass("com.pactera.pms.entity.BaseEntity");
    // 自定义实体，公共字段
    // 自定义 mapper 父类
    strategy.setSuperEntityColumns(new String[]{"SYS_CREATE_USER_CD", "SYS_CREATE_TIME", "SYS_UPDATE_USER_CD",
      "SYS_UPDATE_TIME", "SYS_VERSION", "SYS_IS_DELETED"});
    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    String templatePath = "";

    // 自定义controller的代码模板
    String controller_ext = "/com/codefishing/onedemo/generator/resources/template/controller_ext.java.vm";
    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    /*
     * focList.add(new FileOutConfig(controller_ext) {
     *
     * @Override public String outputFile(TableInfo tableInfo) { // 自定义输出文件名 +
     * pc.getModuleName() String expand = controllerPath+"1"; String entityFile =
     * String.format((expand + File.separator + "%s" + ".java"),
     * tableInfo.getControllerName()); return entityFile; } });
     */


    String entity_ext = "/com/codefishing/onedemo/generator/resources/template/entity_ext.java.vm";
    // 自定义配置会被优先输出
    /*
     * focList.add(new FileOutConfig(entity_ext) {
     *
     * @Override public String outputFile(TableInfo tableInfo) { // 自定义输出文件名 +
     * pc.getModuleName() String expand = entityPath; String entityFile =
     * String.format((expand + File.separator + "%s" + ".java"),
     * tableInfo.getEntityName()); return entityFile; } });
     */
    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    templateConfig.setController(controller_ext);
    templateConfig.setEntity(entity_ext);
    mpg.setTemplate(templateConfig);
    String vo = "Vo";
    templatePath = "/template/" + vo + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return basicPath + "com/pactera/pms/vo/" + lowCaseModuleName + "/" + toBasicName(tableInfo) + vo + ".java";
      }
    });

    String commonBean = "CommonBean";
    templatePath = "/template/" + commonBean + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return controllerPath + "/form/" + toBasicName(tableInfo) + commonBean + ".java";
      }
    });

    String queryBean = "QueryBean";
    templatePath = "/template/" + queryBean + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return controllerPath + "/form/" + toBasicName(tableInfo) + queryBean + ".java";
      }
    });


    String converter = "Converter";
    templatePath = "/template/" + converter + ".java.vm";
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 + pc.getModuleName()
        return basicPath + "com/pactera/pms/converter/" + lowCaseModuleName + "/" + toBasicName(tableInfo) + converter + ".java";
      }
    });

//		String detailPage = "detailPage";
//		templatePath = "/template/" + detailPage + ".ts.vm";
//		// 自定义配置会被优先输出
//		focList.add(new FileOutConfig(templatePath) {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				// 自定义输出文件名 + pc.getModuleName()
//				return projectPath + "/ghac-pms-front/src/app/shared/biz-schema/SF/" + toBasicName(tableInfo) + ".ts";
//			}
//		});
//
//		String listPage = "listPage";
//		templatePath = "/template/" + listPage + ".ts.vm";
//		// 自定义配置会被优先输出
//		focList.add(new FileOutConfig(templatePath) {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				// 自定义输出文件名 + pc.getModuleName()
//				return projectPath + "/ghac-pms-front/src/app/shared/biz-schema/SQ/" + toBasicName(tableInfo) + ".ts";
//			}
//		});


    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);
    mpg.setStrategy(strategy);
    mpg.execute();// 执行

  }

  private String toBasicName(TableInfo tableInfo) {
    tableInfo.setControllerName(StrUtil.removePrefix(tableInfo.getControllerName(), "Sm"));
    return StrUtil.removePrefix(tableInfo.getServiceName().replace("Service", ""), "Sm");
  }
}
