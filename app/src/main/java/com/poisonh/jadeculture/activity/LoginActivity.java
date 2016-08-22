package com.poisonh.jadeculture.activity;

import android.os.Bundle;

import com.poisonh.jadeculture.R;
import com.poisonh.jadeculture.base.BaseActivity;
import com.poisonh.jadeculture.utils.CommonTitleBuilder;

/**
 * 类说明：登录界面
 * 作者：PoisonH on 2016/8/20 12:49
 * 邮箱：PoisonH@163.com
 */

public class LoginActivity extends BaseActivity
{
    @Override
    protected void init(Bundle savedInstanceState)
    {

    }

    @Override
    protected int onLoadLayout()
    {
        return 0;
    }

    @Override
    protected void initCommonTitle()
    {
        new CommonTitleBuilder(this)
                .setLeftImgBtnRes(R.mipmap.icon_delete_back)
                .setMiddleTitleText("登录")
                .build();
    }
}
