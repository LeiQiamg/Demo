package com.hello.demo.controller;

import com.hello.demo.config.MyException;
import com.hello.demo.entity.dto.RestBody;
import com.hello.demo.entity.dto.ResultBody;
import com.hello.demo.entity.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 * @author leiqiang
 * @date 2021/4/23
 */
@RequestMapping("/api")
@RestController
public class UserRestController {

    @GetMapping("/user")
    public ResultBody findByUser(User user) {
        int id = 10 / 0;
        System.out.println("用户查询接口请求参数:" + user.toString());
        ResultBody<List<User>> listResultBody = new ResultBody<>();
        ArrayList<User> arrayList = new ArrayList<User>();
        arrayList.add(new User(1, "123", "123"));
        arrayList.add(new User(2, "root", "root"));
        listResultBody.setResult(arrayList);
        listResultBody.setCode(200);
        System.out.println("用户查询接口返回参数:" + listResultBody);
        return listResultBody;
    }

    @PostMapping("/insert")
    public RestBody insertUser(User user) {
        if (user.getUserName() == null) {
            throw new MyException("400", "用户名称不能为空");
        }
        return RestBody.success("新增成功!");
    }

    @PostMapping("/testMyException")
    public RestBody testMyException() {
        String str = null;
        if (str.equals("test")) {
            System.out.println("测试成功");
        }
        return RestBody.success("测试成功!");
    }

    @PostMapping("/testOtherException")
    public RestBody testOtherException() {
        int i = 10 / 0;
        return RestBody.success("测试成功!");
    }
}
