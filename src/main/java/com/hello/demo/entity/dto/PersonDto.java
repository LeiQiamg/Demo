package com.hello.demo.entity.dto;

import lombok.Data;

/**
 * 人员dto
 * @author leiqiang
 * @date 2021/4/25
 */
@Data
public class PersonDto {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
