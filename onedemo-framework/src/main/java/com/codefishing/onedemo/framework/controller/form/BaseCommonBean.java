package com.codefishing.onedemo.framework.controller.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Pactera
 */
@Data
public class BaseCommonBean implements Serializable {

  private String sysCreateUserCd;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date sysCreateTime;

  private String sysUpdateUserCd;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date sysUpdateTime;

  @Version
  @TableField(value = "SYS_VERSION")
  private int sysVersion = 0;
  /**
   * NEW,MODIFY
   */
  private String beanStatus = "NEW";

  private boolean needLock = false;
}
