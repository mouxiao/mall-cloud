package com.mall.commons.entity;

import lombok.Data;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;

}
