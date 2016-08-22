package com.poisonh.jadeculture.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 类说明：网络状态广播
 * 作者：PoisonH on 2016/8/20 14:21
 * 邮箱：PoisonH@163.com
 */

public class NetStateReceiver extends BroadcastReceiver
{
    private ConnectivityManager mConnectivityManager;

    private NetworkInfo netInfo;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION))
        {

            mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            netInfo = mConnectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isAvailable())
            {
                if (netInfo.getType() == ConnectivityManager.TYPE_WIFI)
                {
                    Log.d("NetState", "TYPE_WIFI");

                } else if (netInfo.getType() == ConnectivityManager.TYPE_ETHERNET)
                {
                    //有线网络
                    Log.d("NetState", "TYPE_ETHERNET");

                } else if (netInfo.getType() == ConnectivityManager.TYPE_MOBILE)
                {
                    //3g网络
                    Log.d("NetState", "TYPE_MOBILE");

                }
            } else
            {
                //网络断开
                Log.d("NetState", "网络断开");
            }
        }

    }
}
