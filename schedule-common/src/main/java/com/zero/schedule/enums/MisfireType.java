package com.zero.schedule.enums;

/**
 * Created by MaXuewen on 2018/7/19.
 */
public enum MisfireType {

  //忽略所有错过的任务(就当没有发生)，继续按照cron表达式执行
  DO_NOTHING,
  //执行所有错过的任务，之后按照cron表达式执行
  IGNORE_MISFIRE_POLICY
}
