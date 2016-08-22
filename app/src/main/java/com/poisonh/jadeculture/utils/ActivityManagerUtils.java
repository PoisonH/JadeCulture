package com.poisonh.jadeculture.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * 类说明：Activity管理类
 * 作者：PoisonH on 2016/8/20 13:10
 * 邮箱：PoisonH@163.com
 */

public class ActivityManagerUtils
{
    private static Stack<Activity> activityStack;
    private static ActivityManagerUtils instance;

    private ActivityManagerUtils()
    {
        if (activityStack == null)
        {
            activityStack = new Stack<>();
        }
    }

    /**
     * 单个实例
     */
    public static ActivityManagerUtils getInstance()
    {
        if (instance == null)
        {
            instance = new ActivityManagerUtils();
        }
        return instance;
    }

    /**
     * add Activity to activityStack
     */
    public void addActivity(Activity activity)
    {
        activityStack.add(activity);
    }

    /**
     * finish当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity()
    {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * finish 指定的Activity
     */
    public void finishActivity(Activity activity)
    {
        if (activity != null)
        {
            activityStack.remove(activity);
        }
    }

    /**
     * finish 指定类名的Activity
     */
    public void finishActivity(Class<?> cls)
    {
        for (Activity activity : activityStack)
        {
            if (activity.getClass().equals(cls))
            {
                finishActivity(activity);
            }
        }
    }

    /**
     * finish all Activity
     */
    private static void finishAllActivity()
    {
        for (Activity activity : activityStack)
        {
            activity.finish();
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public static void AppExit()
    {
        try
        {
            finishAllActivity();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
