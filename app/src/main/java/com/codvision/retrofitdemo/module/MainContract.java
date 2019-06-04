package com.codvision.retrofitdemo.module;

import android.graphics.Bitmap;
/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
import com.codvision.retrofitdemo.base.BasePresenter;
import com.codvision.retrofitdemo.base.BaseView;

/**
 * Created by sxy on 2019/5/8 13:50
 * todo
 */

public interface MainContract {
    interface View extends BaseView<presenter> {
        void setContent(String content);  //设置内容
    }

    interface presenter extends BasePresenter{


        void userLogin(String user,String pwd,String code); //登录

        void userRegister(String user,String pwd); //注册
    }
}