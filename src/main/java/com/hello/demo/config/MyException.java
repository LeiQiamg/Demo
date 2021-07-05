package com.hello.demo.config;

import lombok.Data;

/**
 * 自定义异常类
 * @author leiqiang
 * @date 2021/4/25
 */
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 错误编码
     */
    protected String errorCode;
    /**
     * 错误消息
     */
    protected String errorMessage;

    public MyException() {
        super();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getResultCode());
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMessage = errorInfoInterface.getResultMessage();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode(), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMessage = errorInfoInterface.getResultMessage();
    }

    public MyException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public MyException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public MyException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
        String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
