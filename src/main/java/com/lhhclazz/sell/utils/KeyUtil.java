package com.lhhclazz.sell.utils;

import java.util.Random;

/**
 * 随机生成key
 */
public class KeyUtil {

    /**
     * 毫秒加随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
