package com.zero.schedule.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zero.schedule.enums.MisfireType;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;

/**
 * Created by MaXuewen on 2018/7/19.
 */
@Data
@TableName("task_entity")
public class TaskEntity {

  /**
   * 任务ID
   * 唯一ID，没有实际意义
   */
  @TableId
  private long taskId;

  /**
   * 定时任务的唯一标识，相同的name，系统将视为同一个任务
   */
  @NotBlank(message = "任务名字不能为空")
  private String name;

  @NotBlank(message = "cronExpression不能为空")
  private String cronExpression;

  /**
   * 任务启动时间，默认是当前时间
   */
  private Date startAt = null;

  /**
   * 任务结束时间
   */
  private Date endAt= null;

  /**
   * 本次任务触发时，首先检查上次触发是否执行完成
   * 如果为true，调度器会启用一个线程去执行这个触发
   * 如果为false，调度器会忽略掉本次触发
   */
  private boolean allowParallelism = false;

  /**
   * 如果在指定的时间点没有触发，在未来的时间内是否触发错过的任务
   */
  private MisfireType misfireType = MisfireType.DO_NOTHING;

  /**
   * 创建人、负责人
   */
  private String founder;
}
