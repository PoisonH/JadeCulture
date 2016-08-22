package com.poisonh.jadeculture.base;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 类说明：
 * 作者：PoisonH on 2016/8/20 15:17
 * 邮箱：PoisonH@163.com
 */

public class BaseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        configureInternet();
    }

    /**
     * 网络配置
     */
    private void configureInternet()
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
