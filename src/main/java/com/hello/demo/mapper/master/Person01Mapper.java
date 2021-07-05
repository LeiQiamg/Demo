package com.hello.demo.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.demo.entity.dto.PersonDto;
import com.hello.demo.entity.master.Person;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户dao
 * @author leiqiang
 * @date 2021/4/25
 */
public interface Person01Mapper extends BaseMapper<Person> {

     List<PersonDto> test(@Param("age") Integer age);
}
