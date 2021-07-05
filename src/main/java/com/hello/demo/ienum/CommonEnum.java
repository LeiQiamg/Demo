package com.hello.demo.ienum;

import com.hello.demo.config.BaseErrorInfoInterface;

/**
 * 异常处理枚举
 * @author leiqiang
 * @date 2021/4/25
 */
public enum CommonEnum implements BaseErrorInfoInterface {
    SUCCESS("200", "返回成功"),
    BODY_NOT_MATCH("400", "请求的数据格式不符"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!");
    /**
     * 错误返回码
     */
    private String code;
    /**
     * 错误消息
     */
    private String message;

    CommonEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getResultCode() {
        return code;
    }

    @Override
    public String getResultMessage() {
        return message;
    }
}

