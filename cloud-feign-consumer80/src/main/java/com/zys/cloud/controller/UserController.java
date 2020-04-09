package com.zys.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zys.cloud.entity.User;
import com.zys.cloud.serivce.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "globalFallBack")
public class UserController {

    @Resource
    private UserClientService userClientService;

    @GetMapping("/get/{id}")
//    @HystrixCommand(fallbackMethod = "hystrix_get")
    //未指定fallback，就使用默认的
//    @HystrixCommand
    public User getUser(@PathVariable("id") long id){
        User user=userClientService.getUser(id);
        //数据为空就抛出异常
        if(user==null){
            throw new RuntimeException("抱歉，未查询到数据");
        }
        return user;
    }
    //服务熔断
    public User hystrix_get(@PathVariable("id")long id){
        User user=new User();
        user.setId(id);
        user.setName("抱歉，未查询到数据");
        user.setPhone(new Date().toString());
        return user;
    }

    @PostMapping("/add")
    public int addUser(User user){
        return userClientService.addUser(user);
    }

    //设置全局的fallback
    public User globalFallBack(){
        User user=new User();
        user.setName("服务器维护中，请稍后再试！");
        user.setPhone(new Date().toString());
        return user;
    }

}
