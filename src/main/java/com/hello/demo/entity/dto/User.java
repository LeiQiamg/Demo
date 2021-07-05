package com.hello.demo.entity.dto;

import lombok.Data;

/**
 * 用户类
 * @author leiqiang
 * @date 2021/4/23
 */
@Data
public class User {

    private Integer id;
    private String userName;
    private String password;

    public User(Integer id, String userName, String password) {

        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
