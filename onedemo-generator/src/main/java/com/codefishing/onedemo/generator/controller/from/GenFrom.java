package com.codefishing.onedemo.generator.controller.from;

import lombok.Data;

import java.util.List;

@Data
public class GenFrom {

  private String tableName;
  private String modelName;
  private List<String> tableNames;

}
