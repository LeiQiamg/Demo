package com.hello.demo.controller;

/**
 * 用户处理器
 * @author leiqiang
 * @date 2021/4/25
 */

import com.hello.demo.entity.dbo.Person;
import com.hello.demo.entity.dto.PersonDto;
import com.hello.demo.entity.dto.RestBody;
import com.hello.demo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/person")
@RestController
//@RefreshScope
public class PersonController {

    private final PersonService personService;
    @Value("${nacos.config}")
    private String nacosConfig;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("test")
    public RestBody test(Integer age) {
        System.out.println(nacosConfig);
        List<PersonDto> datas = personService.test(age);
        return RestBody.success(datas);
    }

    @GetMapping("page")
    public RestBody page(Integer currentPage, Integer pagesize) {
        List<Person> personDtoList = personService.pageList(currentPage, pagesize);
        return RestBody.success(personDtoList);
    }
}
