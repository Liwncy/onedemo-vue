package com.codefishing.onedemo.framework.constants;

/**
 * 返回状态
 *
 * @author Pactera
 */
public enum ResultStatusCode {
  /**
   * OK
   */
  OK(true, "200", "操作成功"),
  PromptMessage(false, "201", "错误信息"),
  READONLY(true, "250", "只读处理"),
  NG(false, "ERROR", "操作失败"),
  HTTP_ERROR_100(false, "100", "1XX错误"),
  HTTP_ERROR_300(false, "300", "3XX错误"),
  HTTP_ERROR_400(false, "400", "4XX错误"),
  HTTP_ERROR_500(false, "500", "5XX错误"),
  MQ_SERVER_ERROR(false, "900", "MQ服务器队列异常: {}"),
  SIGN_ERROR(false, "120", "签名错误"),
  TIME_OUT(false, "130", "访问超时"),
  KICK_OUT(false, "300", "您已经在其他地方登录，请重新登录！"),
  BAD_REQUEST(false, "407", "参数解析失败"),
  INVALID_TOKEN(false, "401", "无效的授权码"),
  INVALID_CLIENT_CODE(false, "402", "无效的密钥"),
  REQUEST_NOT_FOUND(false, "404", "访问地址不存在！"),
  METHOD_NOT_ALLOWED(false, "405", "不支持当前请求方法"),
  REPEAT_REQUEST_NOT_ALLOWED(false, "406", "请求重复提交"),
  SYSTEM_ERR(false, "500", "服务器运行异常"),
  NOT_EXIST_USER_OR_ERROR_PWD(false, "10000", "该用户不存在或密码错误"),
  NOT_PARAM_USER_OR_ERROR_PWD(false, "10006", "用户名或密码为空"),
  LOGINED_IN(false, "10001", "该用户已登录"),
  NOT_EXIST_BUSINESS(false, "10002", "该商家不存在"),
  SHIRO_ERROR(false, "10003", "登录异常"),
  UNAUTHO_ERROR(false, "10004", "您没有该权限"),
  REDIS_ERROR(false, "10006", "redis异常"),
  REDIS_CONNECT_ERROR(false, "10007", "redis连接异常"),
  BIND_PHONE(false, "10010", "请绑定手机号"),
  UPLOAD_ERROR(false, "20000", "上传文件异常"),
  INVALID_CAPTCHA(false, "30005", "无效的验证码"),
  USER_FROZEN(false, "40000", "该用户已被冻结"),
  DEALER_CODE_REDO_OK(false, "50000", "当前店重投成功"),
  DEALER_CODE_REDO_LOCKED(false, "50001", "当前店重投运行中"),
  DEALER_CODE_REDO_RELEASE_FAIL(false, "50002", "当前店重投解锁失败"),
  CHECK_SERVER(false, "60000", "服务器校验通过"),
  FILE_UPLOAD_FAIL_001(false, "202", "暂不支持上传该类型文件"),
  FILE_UPLOAD_FAIL_002(false, "202", "未获取到上传文件,请重新上传");

  public Boolean getSuccess() {
    return success;
  }

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  private Boolean success;
  private String code;
  private String msg;

  /**
   * @param code
   * @param msg
   */
  ResultStatusCode(boolean success, String code, String msg) {
    this.success = success;
    this.code = code;
    this.msg = msg;
  }

}
