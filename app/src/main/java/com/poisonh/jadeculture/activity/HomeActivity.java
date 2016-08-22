package com.poisonh.jadeculture.activity;

import android.os.Bundle;

import com.poisonh.jadeculture.R;
import com.poisonh.jadeculture.base.BaseActivity;
import com.poisonh.jadeculture.utils.CommonTitleBuilder;

/**
 * 类说明：首页
 * 作者：PoisonH on 2016/8/20 11:31
 * 邮箱：PoisonH@163.com
 */

public class HomeActivity extends BaseActivity
{

    @Override
    protected void init(Bundle savedInstanceState)
    {

    }

    @Override
    protected int onLoadLayout()
    {
        return R.layout.layout_activity_home;
    }

    @Override
    protected void initCommonTitle()
    {
        new CommonTitleBuilder(this)
                .setLeftImgBtnRes(R.mipmap.icon_delete_back)
                .setMiddleTitleText("首页")
                .build();
    }
}
