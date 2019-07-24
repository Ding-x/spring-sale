package com.dingx.sell.utils;

public class KeyUtil {
    public static synchronized String genUniquekey(){
        int number  = (int)(Math.random()*100000);

        return System.currentTimeMillis()+ String.valueOf(number);
    }
}
