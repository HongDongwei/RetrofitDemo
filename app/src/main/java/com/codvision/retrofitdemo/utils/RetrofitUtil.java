package com.codvision.retrofitdemo.utils;

import com.codvision.retrofitdemo.ApiAddress;
import com.codvision.retrofitdemo.app.MyApp;
import com.codvision.retrofitdemo.network.AllApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class RetrofitUtil {
    /**
     * 超时时间
     */
    private static volatile RetrofitUtil mInstance;
    private AllApi allApi;

    /**
     * 单例封装
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit
     */
    public AllApi initRetrofit() {
        if (allApi == null) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(MyApp.initOKHttp())
                    // 设置请求的域名
                    .baseUrl(ApiAddress.api)
                    // 设置解析转换工厂，用自己定义的
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            allApi = mRetrofit.create(AllApi.class);
        }
        return allApi;
    }
}
