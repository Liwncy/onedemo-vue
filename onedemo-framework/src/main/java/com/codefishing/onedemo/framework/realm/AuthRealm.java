package com.codefishing.onedemo.framework.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Liwncy
 * @Date 2020/9/26 21:38
 * @Version 1.0
 */
@Component
public class AuthRealm extends AuthorizingRealm {

//  @Autowired
//  private ShiroService shiroService;

  /**
   * 授权 获取用户的角色和权限 todo
   *@param  principals
   *@return org.apache.shiro.authz.AuthorizationInfo
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//    //1. 从 PrincipalCollection 中来获取登录用户的信息 todo
//    User user = (User) principals.getPrimaryPrincipal();
//    //Integer userId = user.getUserId();
//    //2.添加角色和权限 todo
//    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//    for (Role role : user.getRoles()) {
//      //2.1添加角色
//      simpleAuthorizationInfo.addRole(role.getRoleName());
//      for (Permission permission : role.getPermissions()) {
//        //2.1.1添加权限
//        simpleAuthorizationInfo.addStringPermission(permission.getPermission());
//      }
//    }
//    return simpleAuthorizationInfo;
    return new SimpleAuthorizationInfo();
  }

  /**
   * 认证 判断token的有效性
   *@param  token
   *@return org.apache.shiro.authc.AuthenticationInfo
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//    //获取token，既前端传入的token todo
//    String accessToken = (String) token.getPrincipal();
//    //1. 根据accessToken，查询用户信息
//    SysToken tokenEntity = shiroService.findByToken(accessToken);
//    //2. token失效
//    if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
//      throw new IncorrectCredentialsException("token失效，请重新登录");
//    }
//    //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
//    User user = shiroService.findByUserId(tokenEntity.getUserId());
//    //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
//    if (user == null) {
//      throw new UnknownAccountException("用户不存在!");
//    }
//    //5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
//    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());
//    return info;
    return new SimpleAuthenticationInfo();
  }
}
