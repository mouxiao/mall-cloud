package com.mall.api.user.impl;

import com.mall.api.user.UserService;
import com.mall.api.user.mapper.UserMapper;
import com.mall.commons.entity.User;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer userId){
//        User user = new User();
//        user.setId(1);
//        user.setUsername("mouxiao");
//        user.setPassword("123456");
//        user.setAddress("浦东");
//        user.setPhone("13670044820");
        return userMapper.getUserById(userId);
    }



}
