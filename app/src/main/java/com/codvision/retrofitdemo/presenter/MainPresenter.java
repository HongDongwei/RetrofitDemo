package com.codvision.retrofitdemo.presenter;

import android.content.Context;


import com.codvision.retrofitdemo.base.BaseEntry;
import com.codvision.retrofitdemo.base.BaseObserver;
import com.codvision.retrofitdemo.bean.Login;
import com.codvision.retrofitdemo.module.MainContract;
import com.codvision.retrofitdemo.utils.MainUtil;
import com.codvision.retrofitdemo.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class MainPresenter implements MainContract.presenter {

    private Context context;
    private MainContract.View view;

    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 登录
     *
     * @param user
     * @param pwd
     * @param code
     */
    @Override
    public void userLogin(String user, String pwd, String code) {
        Map<String, String> map = new HashMap<>();
        map.put("username", user);
        map.put("password", pwd);
        RetrofitUtil.getInstance().initRetrofit().userLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Login>(context, MainUtil.loadLogin) {
                    @Override
                    protected void onSuccees(BaseEntry<Login> t) throws Exception {
                        if (t.isSuccess()) {
                            view.setContent("Hello---->" + t.getData().getName());
                        } else {
                            view.setContent("----->" + t.getMessage());
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setContent("失败了----->" + e.getMessage());
                    }
                });
    }

    /**
     * 注册
     *
     * @param user
     * @param pwd
     */
    @Override
    public void userRegister(String user, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("username", user);
        map.put("password", pwd);
        RetrofitUtil.getInstance().initRetrofit().userRegister(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Login>(context, MainUtil.loadRegister) {
                    @Override
                    protected void onSuccees(BaseEntry<Login> t) throws Exception {
                        if (t.isSuccess()) {
                            view.setContent("Hello---->" + t.getData().getName());
                        } else {
                            view.setContent("----->" + t.getMessage());
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setContent("失败了----->" + e.getMessage());
                    }
                });
    }
}
