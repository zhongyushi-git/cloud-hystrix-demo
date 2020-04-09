package com.zys.cloud.serivce;

import com.zys.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientServiceFallBackFactory implements FallbackFactory<UserClientService> {
    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public User getUser(long id) {
                User user=new User();
                user.setId(id);
                user.setName("未查询到数据,服务降级-停止服务");
                return user;
            }

            @Override
            public int addUser(User user) {
                return 0;
            }
        };
    }
}
