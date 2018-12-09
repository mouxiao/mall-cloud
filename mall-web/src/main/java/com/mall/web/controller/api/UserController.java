package com.mall.web.controller.api;

import com.mall.commons.entity.User;
import com.mall.web.support.feign.user.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@RestController
@RequestMapping("/user")
@Api(value = "userApi", tags = {"订单服务"})
public class UserController {

    @Autowired
    private UserClient userClient;

    @ApiOperation(value = "根据用户ID获取用户信息", httpMethod = "GET", protocols ="http")
    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") Integer userId){
        return  userClient.getUserById(userId);
    }


}
