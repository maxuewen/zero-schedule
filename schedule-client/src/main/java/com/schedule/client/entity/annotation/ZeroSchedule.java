package com.schedule.client.entity.annotation;

import com.zero.schedule.enums.MisfireType;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于创建一个定时任务，在当前类的内部通过ZeroScheduleExecutor注解获取子任务
 *
 * @see ZeroScheduleExecutor
 * Created by MaXuewen on 2018/7/19.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ZeroSchedule {

  /**
   * 定时任务的唯一标识，相同的name，系统将视为同一个任务
   * @return
   */
  @AliasFor("value")
  String name();

  /**
   * cron 表达式
   * @return
   */
  String cronExpression();

  /**
   * @see com.zero.schedule.pojo.TaskEntity#allowParallelism
   */
  boolean allowParallelism() default false;

  /**
   * 如果在指定的时间点没有触发，在未来的时间内是否触发错过的任务
   */
  MisfireType misfireType() default MisfireType.DO_NOTHING;

  /**
   * 创建人、负责人
   * @return
   */
  String founder() default "";
}
