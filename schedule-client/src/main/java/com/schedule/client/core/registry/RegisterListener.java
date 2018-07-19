package com.schedule.client.core.registry;

import com.schedule.client.entity.annotation.ZeroSchedule;
import com.zero.schedule.pojo.SubTaskEntity;
import com.zero.schedule.pojo.TaskEntity;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * Created by MaXuewen on 2018/7/18.
 */
@Slf4j
@Component
public class RegisterListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private volatile ApplicationContext context;

  private RestTemplate restTemplate;

  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    restTemplate = new RestTemplateBuilder()
        .setConnectTimeout(1000)
        .setReadTimeout(1000)
        .build();
    new Thread(this::register).start();
  }

  /**
   * 任务的注册逻辑
   */
  private void register() {
    Map<String, Object> taskBeans = context.getBeansWithAnnotation(ZeroSchedule.class);
    List<TaskEntity> taskEntities = new ArrayList<>();
    List<SubTaskEntity> subTaskEntities = new ArrayList<>();

    if (taskBeans == null || taskBeans.isEmpty()) {
      log.info("项目中没有找到定时任务");
      return;
    }

    taskBeans.forEach((key, bean) -> {

    });

    EurekaInstanceConfigBean eurekaInstanceConfigBean = null;

    try {
      eurekaInstanceConfigBean = (EurekaInstanceConfigBean)context.getBean(EurekaInstanceConfigBean.class);
      eurekaInstanceConfigBean.getVirtualHostName();
      eurekaInstanceConfigBean.getIpAddress();
      eurekaInstanceConfigBean.getNonSecurePort();


      String property = context.getEnvironment().getProperty("server.port", "8080");
    } catch (Exception e) {
//      TODO: 在后续版本中提供非Spring Cloud下的负载均衡。
      log.info("当前项目是非Spring Cloud项目，任务调度将失去负载均衡的能力。");

      String port = context.getEnvironment().getProperty("server.port", "8080");

    }
  }
}
