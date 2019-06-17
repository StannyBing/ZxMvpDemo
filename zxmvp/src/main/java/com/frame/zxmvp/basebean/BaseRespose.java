package com.frame.zxmvp.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class BaseRespose<T> implements Serializable {
    public String success;
    public String msg;

    public T obj;

    public boolean success() {
        return "1".equals(success);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "success='" + success + '\'' +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

}
