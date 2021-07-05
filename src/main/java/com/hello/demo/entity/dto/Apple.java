package com.hello.demo.entity.dto;

import com.hello.demo.interfacedemo.FruitColor;
import com.hello.demo.interfacedemo.FruitColor.Color;
import com.hello.demo.interfacedemo.FruitName;
import com.hello.demo.interfacedemo.FruitProvider;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 苹果
 * @author leiqiang
 * @date 2021/4/23
 */
@Data
@Getter
@Setter
public class Apple {

    /**
     * 水果名称
     */
    @FruitName("苹果")
    private String appleName;
    /**
     * 水果颜色
     */
    @FruitColor(fruitColor = Color.GREEN)
    private String appleColor;
    /**
     * 水果供应商
     */
    @FruitProvider(id = 1, name = "水果集团", address = "浙江省杭州市")
    private String appleProvider;


    public static void main(String[] args) {

        System.out.println(new Apple());
    }
}
