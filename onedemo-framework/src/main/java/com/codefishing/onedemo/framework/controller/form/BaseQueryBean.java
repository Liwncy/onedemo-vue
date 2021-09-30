package com.codefishing.onedemo.framework.controller.form;

import cn.hutool.core.util.ObjectUtil;
import com.codefishing.onedemo.framework.bean.request.OrderByCondition;
import com.codefishing.onedemo.framework.bean.request.PagingInfo;
import com.codefishing.onedemo.framework.bean.request.QueryCondition;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础查询
 *
 * @author Pactera
 */
@Data
public class BaseQueryBean<T> extends BaseBean implements Serializable {

  // 分页信息
  private PagingInfo pagingInfo;
  // 结果数据行对象
  private T parentItem;
  // 查询条件
  private List<QueryCondition> queryConditions = new ArrayList<>();
  // 排序条件
  private List<OrderByCondition> orderByConditions = new ArrayList<>();
  // 导出字段 为空 -> 全项目导出
  private List<String> exportColumns = new ArrayList<>();

  /**
   * 分页信息做成
   *
   * @return
   */
  public Page<T> makePaging() {
    Page<T> info = PageHelper.startPage(pagingInfo.getCurrent(), pagingInfo.getSize());
    return info;
  }

  public void addQueryCondition(String key, String value) {
    addQueryConditionObject(key, value);
  }

  public void addQueryCondition(String key, Integer value) {
    addQueryConditionObject(key, value);
  }

  public void addQueryCondition(String key, Short value) {
    addQueryConditionObject(key, value);
  }

  public void addQueryCondition(String key, Double value) {
    addQueryConditionObject(key, value);
  }

  public void addQueryCondition(String key, BigDecimal value) {
    addQueryConditionObject(key, value);
  }

  public void addQueryConditionObject(String key, Object value) {
    if(ObjectUtil.isNotNull(value)){
      queryConditions.add(QueryCondition.createQueryCondition(key, value.toString()));
    }
  }
}
