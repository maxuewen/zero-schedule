package com.schedule.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MaXuewen on 2018/7/18.
 */
@RestController
@RequestMapping("/example")
public class TestController {


  @GetMapping("/get")
  public String getString() {
    return "";
  }
}
