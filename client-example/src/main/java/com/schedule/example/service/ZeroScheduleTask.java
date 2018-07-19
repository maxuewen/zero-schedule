package com.schedule.example.service;

import com.schedule.client.entity.annotation.ZeroSchedule;
import com.schedule.client.entity.annotation.ZeroScheduleExecutor;

/**
 * Created by MaXuewen on 2018/7/19.
 */
@ZeroSchedule(name = "ZeroScheduleDemo", cronExpression = "0 0/1 * * * ?")
public class ZeroScheduleTask {

  @ZeroScheduleExecutor(name = "DemoScheduleTask")
  public void execute() {
    System.out.println("Scheduled task are being executed");
  }
}
