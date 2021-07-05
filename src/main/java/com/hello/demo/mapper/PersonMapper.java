package com.hello.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.demo.entity.dbo.Person;
import com.hello.demo.entity.dto.PersonDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户dao
 * @author leiqiang
 * @date 2021/4/25
 */
public interface PersonMapper extends BaseMapper<Person> {

    List<PersonDto> test(@Param("age") Integer age);
}
