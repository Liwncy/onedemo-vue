package com.codefishing.onedemo.generator.service.impl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.codefishing.onedemo.generator.controller.from.GenFrom;
import com.codefishing.onedemo.generator.service.IGenSimpleService;
import com.codefishing.onedemo.generator.util.MPGeneratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务 服务层实现
 *
 * @author Liwncy
 */
@Service
public class GenSimpleServiceImpl implements IGenSimpleService {

  private static final Logger log = LoggerFactory.getLogger(GenSimpleServiceImpl.class);


  /**
   * 生成代码（默认路径）
   *
   * @param from 表名称
   */
  @Override
  public void generatorCode(GenFrom from) {
    List<String> tableNames = from.getTableNames();
    String modelName = from.getModelName(), tableName = from.getTableName();
    tableNames.add(tableName);

    // 需要构建一个 代码自动生成器 对象
    AutoGenerator mpg = new AutoGenerator();
    // 配置策略
    // 1、全局配置
    GlobalConfig gc = MPGeneratorUtils.getGlobalDefaultConfig();
    mpg.setGlobalConfig(gc);
    // 2、设置数据源
    DataSourceConfig dsc = MPGeneratorUtils.getDataSourceDefaultConfig();
    mpg.setDataSource(dsc);
    // 3、包的配置
    PackageConfig pc = MPGeneratorUtils.getPackageDefaultConfig(modelName);
    mpg.setPackageInfo(pc);

    // 4、策略配置
    // 4.1 基本配置
    StrategyConfig strategy = MPGeneratorUtils.getStrategyDefaultConfig(tableNames);
    // 4.2 配置模板路径
    TemplateConfig templateConfig = MPGeneratorUtils.getTemplateDefaultConfig();
    mpg.setTemplate(templateConfig);
    // 4.3 自定义配置
    InjectionConfig cfg = MPGeneratorUtils.getInjectionDefaultConfig(modelName);
    mpg.setCfg(cfg);
    mpg.setStrategy(strategy);

    mpg.execute();// 执行

  }
}