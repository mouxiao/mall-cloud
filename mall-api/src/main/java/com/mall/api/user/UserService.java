package com.mall.api.user;

import com.mall.commons.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@RestController
@RequestMapping(value = "/user")
public interface UserService {

    @RequestMapping(value = "getUserById/{userId}")
    public User getUserById(@PathVariable(value = "userId") Integer userId) throws Exception;
}
