package com.codefishing.onedemo.generator.controller;

import com.codefishing.onedemo.framework.bean.result.R;
import com.codefishing.onedemo.framework.controller.BaseController;
import com.codefishing.onedemo.framework.controller.form.BaseCommonBean;
import com.codefishing.onedemo.framework.controller.form.BaseQueryBean;
import com.codefishing.onedemo.generator.controller.from.GenFrom;
import com.codefishing.onedemo.generator.service.IGenSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 代码生成 操作处理
 *
 * @author Liwncy
 */
@RestController
@RequestMapping("/tool/genSimple")
public class GenSimpleController extends BaseController<BaseQueryBean, BaseCommonBean> {

  @Autowired
  private IGenSimpleService genSimpleService;

  /**
   * 生成代码（自定义路径）
   */
  //@PreAuthorize("@ss.hasPermi('tool:gen:code')")
  //@Log(title = "代码生成", businessType = BusinessType.GENCODE)
  @PostMapping("/genCode")
  public R genCode(GenFrom from) {
    genSimpleService.generatorCode(from);
    return R.ok();
  }

  @Override
  protected boolean doDelete(List<String> ids) throws Exception {
    throw new Exception("");
  }
}
