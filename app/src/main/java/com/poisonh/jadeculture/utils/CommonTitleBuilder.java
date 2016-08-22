package com.poisonh.jadeculture.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.poisonh.jadeculture.R;

/**
 * 类说明：TitleBuilder 标题栏封装
 * 作者：PoisonH on 2016/8/20 11:36
 * 邮箱：PoisonH@163.com
 */
public class CommonTitleBuilder
{

    /**
     * title栏根布局
     */
    private View mCommonTitle;
    private ImageButton mCommontitleLeftImgBtn;
    private TextView mCommontitleMiddleTxt;
    private ImageButton mCommontitRightImgBtn;

    /**
     * 第一种  初始化方式
     * 这里是直接引用进文件的初始化方式
     *
     * @param context
     */
    public CommonTitleBuilder(Activity context)
    {

        mCommonTitle = context.findViewById(R.id.arl_commontitle_layout);
        mCommontitleLeftImgBtn = (ImageButton) mCommonTitle.findViewById(R.id.ib_commontitle_left_imgbtn);
        mCommontitleMiddleTxt = (TextView) mCommonTitle.findViewById(R.id.tv_commontitle_middle_title);
        mCommontitRightImgBtn = (ImageButton) mCommonTitle.findViewById(R.id.ib_commontitle_right_imgbtn);

    }

    /**
     * 第二种初始化方式
     * 这里是比如你用代码创建布局的时候使用
     *
     * @param context
     */
    public CommonTitleBuilder(View context)
    {
        mCommonTitle = context.findViewById(R.id.arl_commontitle_layout);
        mCommontitleLeftImgBtn = (ImageButton) mCommonTitle.findViewById(R.id.ib_commontitle_left_imgbtn);
        mCommontitleMiddleTxt = (TextView) mCommonTitle.findViewById(R.id.tv_commontitle_middle_title);
        mCommontitRightImgBtn = (ImageButton) mCommonTitle.findViewById(R.id.ib_commontitle_right_imgbtn);

    }

    /**
     * 设置标题栏title文字大小
     */

    public CommonTitleBuilder setMiddleTitleSize(float size)
    {
        mCommontitleMiddleTxt.setTextSize(size);
        return this;
    }

    /**
     * 设置标题栏title显示文字
     *
     * @param text
     * @return
     */
    public CommonTitleBuilder setMiddleTitleText(String text)
    {
        mCommontitleMiddleTxt.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        mCommontitleMiddleTxt.setText(text);
        return this;
    }

    /**
     * 设置标题栏左边图片按钮icon
     *
     * @param resId
     * @return
     */
    public CommonTitleBuilder setLeftImgBtnRes(int resId)
    {
        mCommontitleLeftImgBtn.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        mCommontitleLeftImgBtn.setImageResource(resId);
        return this;
    }

    /**
     * 设置标题栏左边图片按钮的点击事件
     */
    public CommonTitleBuilder setLeftImgBtnListener(View.OnClickListener listener)
    {
        if (mCommontitleLeftImgBtn.getVisibility() == View.VISIBLE)
        {
            mCommontitleLeftImgBtn.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 设置标题栏右边图片按钮icon
     *
     * @param resId
     * @return
     */
    public CommonTitleBuilder setRightImgBtnRes(int resId)
    {
        mCommontitRightImgBtn.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        mCommontitRightImgBtn.setImageResource(resId);
        return this;
    }


    /**
     * 设置标题栏右边图片按钮的点击事件
     */
    public CommonTitleBuilder setRightImgBtnListener(View.OnClickListener listener)
    {
        if (mCommontitRightImgBtn.getVisibility() == View.VISIBLE)
        {
            mCommontitRightImgBtn.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 设置标题栏不可见
     *
     * @return
     */
    public CommonTitleBuilder setCommonTitleGone()
    {
        if (mCommonTitle.getVisibility()==View.VISIBLE)
        {
            mCommonTitle.setVisibility(View.GONE);
        }
        return this;
    }

    /**
     * 构建标题栏
     *
     * @return
     */
    public View build()
    {
        return mCommonTitle;
    }

}
