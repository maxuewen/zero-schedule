package com.schedule.client.configuration;

import com.schedule.client.entity.pojo.ScheduleProperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.crypto.interfaces.PBEKey;

/**
 * 自动配置类
 * Created by MaXuewen on 2018/7/18.
 */
@Configuration
@ComponentScan("com.schedule.client")
@ConditionalOnProperty(name = "schedule", havingValue = "true")
public class ZeroScheduleAutoConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "schedule")
  public ScheduleProperties setScheduleProperties() {
    return new ScheduleProperties();
  }
}
