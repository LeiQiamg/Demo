package com.hello.demo.entity.dto;

import lombok.Data;

/**
 * 接口通用返回
 * @author leiqiang
 * @date 2021/4/23
 */
@Data
public class ResultBody<T> {

    private Integer code;
    private T result;
    private String message;
}
