package com.codefishing.onedemo.framework.config;

import com.codefishing.onedemo.framework.filter.AuthFilter;
import com.codefishing.onedemo.framework.realm.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Liwncy
 * @Date 2020/9/26 21:38
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

  @Bean("securityManager")
  public SecurityManager securityManager(AuthRealm authRealm) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(authRealm);
    securityManager.setRememberMeManager(null);
    return securityManager;
  }

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
    shiroFilter.setSecurityManager(securityManager);
    //oauth过滤
    Map<String, Filter> filters = new HashMap<>();
    filters.put("auth", new AuthFilter());
    shiroFilter.setFilters(filters);
    Map<String, String> filterMap = new LinkedHashMap<>();
    filterMap.put("/webjars/**", "anon");
    filterMap.put("/druid/**", "anon");
    filterMap.put("/sys/login", "anon");
    filterMap.put("/swagger/**", "anon");
    filterMap.put("/v2/api-docs", "anon");
    filterMap.put("/swagger-ui.html", "anon");
    filterMap.put("/swagger-resources/**", "anon");
    filterMap.put("/**", "auth");
    shiroFilter.setFilterChainDefinitionMap(filterMap);

    return shiroFilter;
  }

  @Bean("lifecycleBeanPostProcessor")
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }
}
