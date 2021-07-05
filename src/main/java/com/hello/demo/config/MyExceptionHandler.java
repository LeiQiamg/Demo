package com.hello.demo.config;

import com.hello.demo.entity.dto.RestBody;
import com.hello.demo.ienum.CommonEnum;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义全局异常处理配置类
 * @author leiqiang
 * @date 2021/4/25
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestBody exceptionHandler(Exception e) {
        logger.error("未知异常", e);
        return RestBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理自定义异常机制
     * @param httpServletRequest
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public RestBody myExceptionHandlerT(HttpServletRequest httpServletRequest, MyException e) {
        logger.error("发生业务异常!原因是:{}", e.getMessage());
        return RestBody.error(e.getErrorCode(), e.getErrorMessage());
    }

    /**
     * 空指针异常处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public RestBody exceptionHandler(HttpServletRequest request, NullPointerException e) {
        logger.error("发空指针异常,原因:{}", e.getMessage());
        return RestBody.error(CommonEnum.BODY_NOT_MATCH);
    }
}
