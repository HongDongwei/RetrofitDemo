package com.codvision.retrofitdemo.base;


import com.codvision.retrofitdemo.utils.MainUtil;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class BaseEntry<T> {

    private int code;
    private String message;
    private T data;

    public boolean isSuccess(){
        return getCode()== MainUtil.SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
