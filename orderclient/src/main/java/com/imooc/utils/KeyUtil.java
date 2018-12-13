package com.imooc.utils;

import java.util.Random;

/**
 * Created by MySelf on 2018/12/12.
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * 在并发下任然可能重复，需要加synchronized 多线程
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        //生成6位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static synchronized String getMobookKey(Integer tagNum){
        Random random = new Random();
        //生成6为随机数
        Integer number = random.nextInt(900000) + 100000;
        return "MS"+"0"+String.valueOf(tagNum)+String.valueOf(number);
    }

}
