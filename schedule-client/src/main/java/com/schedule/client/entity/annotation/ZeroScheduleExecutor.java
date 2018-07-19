package com.schedule.client.entity.annotation;

import com.zero.schedule.enums.IgnoreErrorType;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by MaXuewen on 2018/7/19.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ZeroScheduleExecutor {

  /**
   * 子任务的名字
   * @return
   */
  @AliasFor("value")
  String name();

  /**
   * @see com.zero.schedule.pojo.SubTaskEntity#enabled
   * @return
   */
  boolean enabled() default true;

  /**
   * @see com.zero.schedule.pojo.SubTaskEntity#ignoreError
   * @return
   */
  IgnoreErrorType ignoreError() default IgnoreErrorType.SUSPEND;

  /**
   * @see com.zero.schedule.pojo.SubTaskEntity#level
   */
  int level() default 0;
}
