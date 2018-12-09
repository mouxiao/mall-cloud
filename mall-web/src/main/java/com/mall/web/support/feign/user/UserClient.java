package com.mall.web.support.feign.user;

import com.mall.commons.entity.User;
import com.mall.web.support.feign.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mouxiao
 * @remark feigin调用用户服务
 * @date 2018/12/4 0004
 */
@FeignClient(name = "mall-api",
        fallback = UserClient.UserFallBack.class,
//        fallbackFactory = UserClient.UserFallBackFactory.class,// 如果配置了 fallback 那么 fallbackFactory 将会无效
        configuration = FeignConfiguration.class)
public interface UserClient {

    /**
     * springmvc契约方式
     */
//    @GetMapping(value = "user/getUserById/{userId}")
//    public User getUserById(@PathVariable("userId") Integer userId);

    /**
     * feign契约方式
     * 需要注入 Contract
     * @param userId
     * @return
     */
    @RequestLine("GET /user/getUserById/{userId}")
    public User getUserById(@Param("userId") Integer userId);
    /**
     * feign调用失败后，回调
     */
    class UserFallBack implements UserClient{
        @Override
        public User getUserById(Integer userId) {
            return null;
        }
    }

    class UserFallBackFactory implements FallbackFactory<UserClient>{

        @Override
        public UserClient create(Throwable throwable) {
           return new UserClient(){
               @Override
               public User getUserById(Integer userId) {
                   return new User();
               }
           };
        }
    }

}
