package com.hello.demo;

import java.util.Objects;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author leiqiang
 * @date 2021/5/20
 */
public class MyTest {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
