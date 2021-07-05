package com.hello.demo.entity.dto;

import com.alibaba.fastjson.JSONObject;
import com.hello.demo.config.BaseErrorInfoInterface;
import com.hello.demo.ienum.CommonEnum;
import lombok.Data;

/**
 * 自定义返回结果
 * @author leiqiang
 * @date 2021/4/25
 */
@Data
public class RestBody {

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public RestBody() {
    }

    public RestBody(BaseErrorInfoInterface errorInfoInterface) {
        this.code = errorInfoInterface.getResultCode();
        this.message = errorInfoInterface.getResultMessage();
    }

    /**
     * 成功
     */
    public static RestBody success() {
        return success(null);
    }

    /**
     * 成功带数据
     * @param data
     * @return
     */
    public static RestBody success(Object data) {
        RestBody resultBody = new RestBody();
        resultBody.setCode(CommonEnum.SUCCESS.getResultCode());
        resultBody.setMessage(CommonEnum.SUCCESS.getResultMessage());
        resultBody.setResult(data);
        return resultBody;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static RestBody error(String code, String message) {
        RestBody restBody = new RestBody();
        restBody.setCode(code);
        restBody.setMessage(message);
        return restBody;
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static RestBody error(String message) {
        RestBody restBody = new RestBody();
        restBody.setMessage(message);
        restBody.setCode("-1");
        return restBody;
    }

    /**
     * 失败
     * @return
     */
    public static RestBody error(CommonEnum commonEnum) {
        RestBody restBody = new RestBody();
        restBody.setMessage(commonEnum.getResultMessage());
        restBody.setCode("-1");
        return restBody;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
