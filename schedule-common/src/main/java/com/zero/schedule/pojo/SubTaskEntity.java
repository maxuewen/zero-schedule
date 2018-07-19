package com.zero.schedule.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zero.schedule.enums.IgnoreErrorType;

import lombok.Data;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * Created by MaXuewen on 2018/7/19.
 */
@Data
@TableName("sub_task_entity")
public class SubTaskEntity {
  /**
   * 子任务ID
   * 唯一ID，没有实际意义
   */
  @TableId("sub_task_id")
  private long subTaskId;

  /**
   * 任务ID
   * @see TaskEntity#taskId
   */
  private long taskId;

  /**
   * 子任务名字
   */
  @NotBlank(message = "子任务名称不能为空")
  private String name;

  /**
   * spring cloud中的服务名，即在eureka中注册的名字，如 CLIENT-EXAMPLE
   *
   * 注: 如果当前是非spring cloud环境，也可以使用ip+端口的方式，如 HTTP://127.0.0.1:8080
   */
  @NotBlank(message = "服务名不能为空")
  private String serverName;

  /**
   * 定时任务服务端调用客户端时会携带该参数
   */
  private String param;

  /**
   * 是否启动当前子任务
   */
  private boolean enabled = true;

  /**
   * 当某一个子任务报错时，是否继续执行剩下的任务
   */
  private IgnoreErrorType ignoreError = IgnoreErrorType.SUSPEND;

  /**
   * 当前子任务的的层级
   * 服务端将会从任务中最小的子任务开始调用，同一层平行调用，level大的层需要等到level小的层执行完成才开始调用
   */
  @Range(min = 0, max = 9999, message = "level字段不符合要求")
  private int level = 0;

  /**
   * 任务实体类在spring容器中注册的name值
   */
  @NotBlank(message = "BeanName不能为空")
  private String beanName;

  /**
   * 要执行的方法的名字
   */
  @NotBlank(message = "MethodName不能为空")
  private String methodName;
}
