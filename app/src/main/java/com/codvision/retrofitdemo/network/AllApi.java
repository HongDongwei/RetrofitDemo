package com.codvision.retrofitdemo.network;


import com.codvision.retrofitdemo.ApiAddress;
import com.codvision.retrofitdemo.base.BaseEntry;
import com.codvision.retrofitdemo.bean.Login;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public interface AllApi {

    /**
     * 登录
     */
    @POST(ApiAddress.userLogin)
    Observable<BaseEntry<Login>> userLogin(@Body Map<String, String> maps);

    /**
     * 注册
     */
    @POST(ApiAddress.userRegister)
    Observable<BaseEntry<Login>> userRegister(@Body Map<String, String> maps);
}
