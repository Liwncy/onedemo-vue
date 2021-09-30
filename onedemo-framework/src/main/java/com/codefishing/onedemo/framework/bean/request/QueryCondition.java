package com.codefishing.onedemo.framework.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询条件
 *
 * @author Pactera
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryCondition {

  private String key;
  private String value;
  private Operator operator;
  private Where where = Where.AND;


  public enum Operator {
    /**
     * 查询类型 GTLTE  选择有库存的时候大于等于，选择无库存的时候小于等于
     */
    EQ, NEQ, LIKE, LIKELEFT, LIKERIGHT, GT, LT, GTE, LTE, IN, NOTNULL, ISNULL, ISEMPTY, NOTEMPTY, GTLTE,
    ;

    /**
     * 值对应的枚举 Created by yls on 2018/5/21.
     *
     * @param value
     * @return
     */
    public static Operator resolve(String value) {
      for (Operator opt : Operator.values()) {
        if (opt.name().equals(value)) {
          return opt;
        }
      }
      return null;
    }
  }

  public enum Where {
    /**
     * 关系
     */
    AND, OR;

    /**
     * 值对应的枚举
     *
     * @param value
     * @return
     */
    public static Where resolve(String value) {
      for (Where opt : Where.values()) {
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Where getWhere() {
    return where;
  }

  public void setWhere(Where where) {
    this.where = where;
  }

  public static QueryCondition createQueryCondition(String key, String value) {
    return createQueryCondition(key, value, Operator.EQ);
  }

  public static QueryCondition createQueryCondition(String key, String value, Operator operator) {
    return new QueryCondition(key, value, operator, Where.AND);
  }
}
