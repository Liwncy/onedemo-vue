package com.codefishing.onedemo.framework.vo;

import lombok.Data;

import java.util.List;

/**
 * 通用Table结果VO
 *
 * @author Pactera
 */
@Data
public class QueryListResultVo {
  /**
   * 当前页
   */
  int pi;
  /**
   * Per page
   */
  int ps;
  /**
   * 总件数
   */
  long total;
  /**
   * 数据
   */
  List data;
}
