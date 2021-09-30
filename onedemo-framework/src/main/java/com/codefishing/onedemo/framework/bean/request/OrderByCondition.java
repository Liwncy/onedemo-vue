package com.codefishing.onedemo.framework.bean.request;

/**
 * 查询条件
 *
 * @author Pactera
 */
public class OrderByCondition {
  private String key;
  private OrderBy type;

  public enum OrderBy {
    /**
     * 关系
     */
    ASC, DESC;

    /**
     * 值对应的枚举
     *
     * @param value
     * @return
     */
    public static OrderBy resolve(String value) {
      for (OrderBy opt : OrderBy.values()) {
        if (opt.name().equals(value)) {
          return opt;
        }
      }
      return null;
    }
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public OrderBy getType() {
    return type;
  }

  public void setType(OrderBy type) {
    this.type = type;
  }
}
