package com.mall.api.user.impl;

import com.mall.api.user.UserService;
import com.mall.commons.entity.User;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUserById(Integer userId){
        User user = null;
        user.setId(1);
        user.setUsername("mouxiao");
        user.setPassword("123456");
        user.setAddress("浦东");
        user.setPhone("13670044820");
        return user;
    }



}
