package com.hello.demo.service;

import com.hello.demo.entity.dto.PersonDto;
import com.hello.demo.mapper.master.Person01Mapper;
import com.hello.demo.mapper.slave.Person02Mapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 多数据源测试
 * @author leiqiang
 * @date 2021/5/6
 */
@Service
public class DataSourceDemoService {

    private final Person01Mapper person01Mapper;
    private final Person02Mapper person02Mapper;

    public DataSourceDemoService(Person01Mapper person01Mapper, Person02Mapper person02Mapper) {
        this.person01Mapper = person01Mapper;
        this.person02Mapper = person02Mapper;
    }

    public Map<String, List<PersonDto>> getTestData(Integer age) {
        List<PersonDto> test = person01Mapper.test(age);
        List<PersonDto> test1 = person02Mapper.test(age);
        HashMap<String, List<PersonDto>> hashMap = new HashMap<>();
        hashMap.put("master", test);
        hashMap.put("slave", test1);
        return hashMap;
    }
}
