package com.codefishing.onedemo.framework.bean.result;

import com.codefishing.onedemo.framework.constants.ResultStatusCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结构
 *
 * @author Pactera
 */
@Data
public class R<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  private Boolean success;

  private String code;

  private String message;

  private T data;

  /**
   * 构造器私有
   */
  private R() {
  }

  /**
   * 通用返回成功
   */
  public static R ok() {
    R r = new R();
    r.setSuccess(ResultStatusCode.OK.getSuccess());
    r.setCode(ResultStatusCode.OK.getCode());
    r.setMessage(ResultStatusCode.OK.getMsg());
    return r;
  }

  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static R failure() {
    R r = new R();
    r.setSuccess(ResultStatusCode.NG.getSuccess());
    r.setCode(ResultStatusCode.NG.getCode());
    r.setMessage(ResultStatusCode.NG.getMsg());
    return r;
  }

  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static R failure(String msg) {
    R r = new R();
    r.setSuccess(ResultStatusCode.NG.getSuccess());
    r.setCode(ResultStatusCode.NG.getCode());
    r.setMessage(msg);
    return r;
  }

  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static R failure(String code, String msg) {
    R r = new R();
    r.setSuccess(ResultStatusCode.NG.getSuccess());
    r.setCode(code);
    r.setMessage(msg);
    return r;
  }

  /**
   * 设置结果，形参为结果枚举
   *
   * @param result
   * @return
   */
  public static R setResult(ResultStatusCode result) {
    R r = new R();
    r.setSuccess(result.getSuccess());
    r.setCode(result.getCode());
    r.setMessage(result.getMsg());
    return r;
  }

  /**
   * 通用设置data
   *
   * @param value
   * @return
   */
  public R<T> data(T value) {
    this.data = value;
    return this;
  }

  /**
   * 自定义状态信息
   *
   * @param message
   * @return
   */
  public R message(String message) {
    this.setMessage(message);
    return this;
  }

  /**
   * 自定义状态码
   *
   * @param code
   * @return
   */
  public R code(String code) {
    this.setCode(code);
    return this;
  }

  /**
   * 自定义返回结果
   *
   * @param success
   * @return
   */
  public R success(Boolean success) {
    this.setSuccess(success);
    return this;
  }
}
