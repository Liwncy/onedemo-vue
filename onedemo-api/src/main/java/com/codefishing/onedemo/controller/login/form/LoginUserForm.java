package com.codefishing.onedemo.controller.login.form;


import lombok.Data;

/**
 * 登录用户信息
 * @author wenhao.li
 */
@Data
public class LoginUserForm {
  private String userCd;
  private String password;
  private String captcha;
}
