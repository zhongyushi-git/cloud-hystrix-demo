package com.zys.cloud.controller;

import com.zys.cloud.service.UserServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class TestController {

    @Resource
    private UserServiceClient userServiceClient;

    @GetMapping("/get")
    public String get() {
        return userServiceClient.get();
    }

}