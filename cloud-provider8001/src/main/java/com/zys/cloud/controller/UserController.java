package com.zys.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/user/get")
    @HystrixCommand(defaultFallback = "getFallBack")
    public String get() {
        int i = 10 / 0;
        return "我是服务提供者，端口：" + port;
    }

    //回调方法
    public String getFallBack() {
        return "当前访问人数较多，请稍后再试";
    }


}