package com.schedule.client.core;

import com.zero.schedule.exceptions.ScheduleException;

/**
 * Created by MaXuewen on 2018/7/18.
 */
public interface ScheduleTask {

  /**
   * 具体的定时任务任务逻辑
   * @throws ScheduleException
   */
  void execute() throws ScheduleException;
}
