package com.hello.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hello.demo.entity.dbo.Person;
import com.hello.demo.entity.dto.PersonDto;
import com.hello.demo.mapper.PersonMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 用户业务
 * @author leiqiang
 * @date 2021/4/25
 */
@Service
public class PersonService {

    private final PersonMapper personMapper;

    public PersonService(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    /**
     * 测试查询数据列表
     * @return
     */
    public List<PersonDto> test(Integer age) {
        return personMapper.test(age);
    }

    public List<Person> pageList(Integer currentPage, Integer pagesize) {
        return personMapper.selectPage(new Page<>(currentPage, pagesize), null).getRecords();
    }
}
