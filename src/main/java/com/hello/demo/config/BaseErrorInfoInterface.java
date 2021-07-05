package com.hello.demo.config;

/**
 * 自定义异常信息接口类
 * @author leiqiang
 * @date 2021/4/25
 */
public interface BaseErrorInfoInterface {

    /**
     * 获取错误码
     */
    String getResultCode();

    /**
     * 获取错误信息
     */
    String getResultMessage();
}
