package com.codvision.retrofitdemo.network;

import com.codvision.retrofitdemo.app.MyApp;
import com.codvision.retrofitdemo.utils.SharePreferencesUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */

public class CookieReadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie", SharePreferencesUtils.getString(MyApp.myApp, "cookiess", ""));
        return chain.proceed(builder.build());
    }
}
