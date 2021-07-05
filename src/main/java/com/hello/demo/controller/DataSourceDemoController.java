package com.hello.demo.controller;

import com.hello.demo.entity.dto.PersonDto;
import com.hello.demo.entity.dto.RestBody;
import com.hello.demo.service.DataSourceDemoService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leiqiang
 * @date 2021/5/6
 */
@RequestMapping("dataSouarce")
@RestController
public class DataSourceDemoController {

    private final DataSourceDemoService dataSourceDemoService;

    public DataSourceDemoController(DataSourceDemoService dataSourceDemoService) {
        this.dataSourceDemoService = dataSourceDemoService;
    }

    @RequestMapping("/test")
    public RestBody testDataSource(Integer age) {
        Map<String, List<PersonDto>> data = dataSourceDemoService.getTestData(age);
        return RestBody.success(data);
    }
}
