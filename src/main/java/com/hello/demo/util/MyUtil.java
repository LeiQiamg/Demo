package com.hello.demo.util;

/**
 * @author leiqiang
 * @date 2021/4/22
 */
public class MyUtil {

  /*  public static <Y, K> List<K> listConversion(Page<Y> pageSource, Class<K> b) {
        List<K> collect = pageSource.getRecords().stream().map(c -> {
            K vo = null;
            try {
                vo = b.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtil.copyProperties(c, vo);
            return vo;
        }).collect(Collectors.toList());
        return collect;    }*/
}
