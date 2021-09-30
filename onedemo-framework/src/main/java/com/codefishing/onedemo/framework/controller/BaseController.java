package com.codefishing.onedemo.framework.controller;

import cn.hutool.json.JSONUtil;
import com.codefishing.onedemo.framework.bean.result.R;
import com.codefishing.onedemo.framework.controller.form.BaseBean;
import com.codefishing.onedemo.framework.controller.form.BaseCommonBean;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author ruoyi
 */
public class BaseController<Q extends BaseBean, F extends BaseCommonBean> {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final static String SYS_INVALID_REQUEST_PATH = "无效路径:";

  /**
   * 列表查询
   *
   * @param queryBean
   * @return
   */
  @PostMapping("/list")
  public R queryList(@RequestBody Q queryBean) throws Exception {
    queryListValidate(queryBean);
    List list = doQueryList(queryBean);
    return R.ok().data(list);
  }

  /**
   * 列表查询实现
   *
   * @param queryBean
   * @return
   */
  protected List<?> doQueryList(Q queryBean) throws Exception {
    StringBuilder stringBuilder = new StringBuilder("QUERY-LIST ");
    stringBuilder.append(JSONUtil.toJsonStr(queryBean));
    throw new Exception(SYS_INVALID_REQUEST_PATH + stringBuilder.toString());
  }

  /**
   * 泛用复杂查询
   *
   * @param queryBean
   * @return
   */
  @PostMapping("/page")
  public R queryPageList(@RequestBody Q queryBean) throws Exception {
    queryListValidate(queryBean);
    PageInfo pageInfo = doQueryPageList(queryBean);
    return R.ok().data(pageInfo);
  }

  /**
   * 泛用复杂查询校验
   *
   * @param queryBean
   * @return
   */
  protected void queryListValidate(Q queryBean) throws Exception {
  }

  /**
   * 复杂查询分页实现
   *
   * @param queryBean
   * @return
   */
  protected PageInfo<?> doQueryPageList(Q queryBean) throws Exception {
    StringBuilder stringBuilder = new StringBuilder("QUERY-PAGE-LIST ");
    stringBuilder.append(JSONUtil.toJsonStr(queryBean));
    throw new Exception(SYS_INVALID_REQUEST_PATH + stringBuilder.toString());
  }

  /**
   * 泛用明细查询
   *
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public R view(@PathVariable("id") String id) throws Exception {
    Object data = doView(id);
    return R.ok().data(data);
  }

  /**
   * 明细查询实现
   *
   * @param pk
   * @return
   */
  protected Object doView(String pk) throws Exception {
    StringBuilder stringBuilder = new StringBuilder("VIEW ");
    stringBuilder.append(pk);
    throw new Exception(SYS_INVALID_REQUEST_PATH + stringBuilder.toString());
  }

  /**
   * 泛用明细查询
   *
   * @param id
   * @return
   */
  @PostMapping("/save")
  public R view(@RequestBody F commandForm) throws Exception {
    saveValidate(commandForm);
    Object rtn = doSave(commandForm);
    return R.ok().data(rtn);
  }

  /**
   * 泛用保存校验
   *
   * @param commandForm
   * @return
   */
  protected void saveValidate(F commandForm) throws Exception {
  }

  /**
   * 保存实现
   *
   * @param commandForm
   */
  protected Object doSave(F commandForm) throws Exception {
    StringBuilder stringBuilder = new StringBuilder("SAVE ");
    stringBuilder.append(JSONUtil.toJsonStr(commandForm));
    throw new Exception(SYS_INVALID_REQUEST_PATH + stringBuilder.toString());
  }

  /**
   * 泛用多件删除
   *
   * @param ids
   * @return
   */
  @DeleteMapping("/{ids}")
  public R delete(@PathVariable("ids") String ids) throws Exception {
    List<String> idArray = Arrays.asList(ids.split(","));
    deleteValidate(idArray);
    boolean result = doDelete(idArray);
    return R.ok();
  }

  /**
   * 泛用修改校验
   *
   * @param ids
   * @return
   */
  protected void deleteValidate(List<String> ids) throws Exception {
  }

  /**
   * 删除实现
   *
   * @param ids
   */
  protected boolean doDelete(List<String> ids) throws Exception {
    StringBuilder stringBuilder = new StringBuilder("DELETE ");
    stringBuilder.append(ids.toString());
    throw new Exception(SYS_INVALID_REQUEST_PATH+stringBuilder.toString());
  }
}
