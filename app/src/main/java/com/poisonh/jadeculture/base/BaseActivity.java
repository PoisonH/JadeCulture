package com.poisonh.jadeculture.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.poisonh.jadeculture.R;
import com.poisonh.jadeculture.receiver.NetStateReceiver;
import com.poisonh.jadeculture.utils.ActivityManagerUtils;
import com.poisonh.jadeculture.utils.NetWorkUtils;


/**
 * 类说明：所有Activity的基类
 * 作者：PoisonH on 2016/8/20 11:31
 * 邮箱：PoisonH@163.com
 */

public abstract class BaseActivity extends AppCompatActivity
{
    /**
     * 网络状态广播
     */
    private NetStateReceiver netStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityManagerUtils.getInstance().addActivity(this);
        if (NetWorkUtils.isConnectedByState(this))
        {
            setContentView(onLoadLayout());
        } else
        {
            setContentView(R.layout.layout_no_network);
        }
        registerReceiver();
        init(savedInstanceState);
        initCommonTitle();
    }


    /**
     * showToast
     */
    protected void showToast(String msg)
    {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * showLog
     */
    protected void showLog(String msg)
    {
        Log.d("PoisonH", "-----------" + getClass().getSimpleName() + "--------------->" + msg);
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityManagerUtils.getInstance().finishActivity(this);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        unRegisterReceiver();
    }

    /**
     * 注册广播
     */
    private void registerReceiver()
    {
        netStateReceiver = new NetStateReceiver();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netStateReceiver, mFilter);
    }

    /**
     * 注销广播
     */
    private void unRegisterReceiver()
    {

        if (netStateReceiver != null)
        {
            unregisterReceiver(netStateReceiver);
        }
    }

    /**
     * 加载布局文件
     *
     * @return 布局文件id
     */
    protected abstract int onLoadLayout();

    protected abstract void initCommonTitle();

    protected abstract void init(Bundle savedInstanceState);
}
