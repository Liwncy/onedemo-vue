package com.codefishing.onedemo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseVo {
  private String sysCreateUserCd;
  private Date sysCreateTime;

  private String sysUpdateUserCd;

  private Date sysUpdateTime;

  private Integer sysVersion=0;
}
