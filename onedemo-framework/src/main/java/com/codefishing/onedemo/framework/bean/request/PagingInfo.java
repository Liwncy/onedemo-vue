package com.codefishing.onedemo.framework.bean.request;

import lombok.Data;

/**
 * 分页信息
 *
 * @author Pactera
 */
@Data
public class PagingInfo {
  private int current = 1;
  private int size = 20;
}
