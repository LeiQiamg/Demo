package com.hello.demo.util;

import com.hello.demo.entity.dto.Apple;
import com.hello.demo.interfacedemo.FruitColor;
import com.hello.demo.interfacedemo.FruitName;
import com.hello.demo.interfacedemo.FruitProvider;
import java.lang.reflect.Field;

/**
 * 水果注解处理器
 * @author leiqiang
 * @date 2021/4/23
 */
public class FruitInfoUtil {

    private static <T> void loadProperty(T t) throws IllegalAccessException {
        Class<?> clazz = t.getClass();
        configField(clazz, t);
    }

    /**
     * 通过注解为属性赋值
     * @param clazz 类
     * @param t 实例
     * @param <T> 该实例泛型
     */
    private static <T> void configField(Class<?> clazz, T t) throws IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                field.setAccessible(true);
                field.set(t, fruitColor.fruitColor().toString());
            } else if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                field.setAccessible(true);
                field.set(t, fruitName.value());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                field.setAccessible(true);
                field.set(t, "供应商信息:" + fruitProvider.id() + fruitProvider.name() + fruitProvider.address());
            }
        }
    }

    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = "水果名称: ";
        String strFruitColor = "水果颜色: ";
        String strFruitProvice = "供应商信息: ";

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvice =
                    strFruitProvice + "供应商编号:" + fruitProvider.id() + "供应商名称:" + fruitProvider.name() + "供应商地址:"
                        + fruitProvider.address();
                System.out.println(strFruitProvice);
            }

        }

    }

    public static void main(String[] args) throws IllegalAccessException {
        FruitInfoUtil.getFruitInfo(Apple.class);
        Apple apple = new Apple();
        FruitInfoUtil.loadProperty(apple);
        System.out.println(apple);
    }
}
