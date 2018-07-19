package com.zero.schedule.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by MaXuewen on 2018/7/19.
 */
public enum IgnoreErrorType implements IEnum {
  IGNORE, //忽略
  SUSPEND;   //中断

  public Serializable getValue() {
    return this.name();
  }
}
