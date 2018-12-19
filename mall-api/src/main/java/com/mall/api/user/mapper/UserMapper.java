package com.mall.api.user.mapper;

import com.mall.commons.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/19 0019 22:01
 */
@Mapper
public interface UserMapper {

    @Results(id = "userResult", value = {
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "username", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD")
    })
    @Select("select * from user where id = #{id} ")
    public User getUserById(@Param(value = "id") Integer id);

}
