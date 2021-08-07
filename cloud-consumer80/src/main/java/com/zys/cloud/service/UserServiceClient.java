package com.zys.cloud.service;

import com.zys.cloud.fallback.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//指定微服务名称
@FeignClient(value = "cloud-consul-provider", fallback = UserFallBack.class)
public interface UserServiceClient {

    @GetMapping("/user/get")
    String get();
}
