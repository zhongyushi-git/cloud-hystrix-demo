package com.zys.cloud.service;

import com.zys.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//添加注解，指定微服务名称
//@FeignClient(value="CLOUD-PROVIDER")
@FeignClient(value="CLOUD-PROVIDER",fallbackFactory = UserClientServiceFallBackFactory.class)
public interface UserClientService {

    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable("id")long id);

    @PostMapping("/user/add")
    int addUser(User user);
}
