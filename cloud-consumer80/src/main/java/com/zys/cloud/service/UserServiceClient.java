package com.zys.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//指定微服务名称
@FeignClient(value = "cloud-consul-provider")
public interface UserServiceClient {

    @GetMapping("/user/get")
    String get();
}
