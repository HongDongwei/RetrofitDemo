package com.codvision.retrofitdemo.utils;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class InterceptorUtil {

    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w(MainUtil.logger, "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }
}
