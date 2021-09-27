package com.codefishing.onedemo.framework.bean.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义AuthenticationToken类
 * @Author Liwncy
 * @Date 2020/9/26 21:38
 * @Version 1.0
 */
public class AuthToken extends UsernamePasswordToken {

  private String token;

  public AuthToken(String token) {
    this.token = token;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}
