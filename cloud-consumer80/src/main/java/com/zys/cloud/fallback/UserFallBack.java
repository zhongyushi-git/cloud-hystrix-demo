package com.zys.cloud.fallback;

import com.zys.cloud.service.UserServiceClient;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserServiceClient {
    @Override
    public String get() {
        return "服务提供方不可用，请稍后再试";
    }
}
