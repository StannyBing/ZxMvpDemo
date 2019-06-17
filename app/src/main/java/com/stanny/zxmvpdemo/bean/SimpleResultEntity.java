package com.stanny.zxmvpdemo.bean;

/**
 * Created by Xiangb on 2017/9/13.
 * 功能：
 */

public class SimpleResultEntity {
    public String success;
    public String msg;
    public boolean success() {
        if ("1".equals(success)||"true".equals(success)){
            return true;
        }else {
            return false;
        }
    }
}
