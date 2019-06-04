package com.codvision.retrofitdemo.utils;

import android.util.Log;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class MainUtil {
    public static String logger = "logger";
    private static boolean isPrintLog = true; //是否打开日志打印

    //日志打印
    public static void printLogger(String logTxt) {
        if (isPrintLog) {
            Log.d(logger, logTxt);
        }
    }


    public static int SUCCESS_CODE = 200;//成功的code

    public static String loadTxt = "正在加载";
    public static String loadLogin = "正在登录";
    public static String loadRegister = "正在注册";
}
