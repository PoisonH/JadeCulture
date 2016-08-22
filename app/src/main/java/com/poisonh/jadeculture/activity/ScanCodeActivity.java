package com.poisonh.jadeculture.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.poisonh.jadeculture.R;
import com.poisonh.jadeculture.base.BaseActivity;
import com.poisonh.jadeculture.utils.CommonTitleBuilder;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * 类说明：
 * 作者：PoisonH on 2016/8/20 16:17
 * 邮箱：PoisonH@163.com
 */

public class ScanCodeActivity extends BaseActivity
{
    private CaptureFragment captureFragment;

    @Override
    protected void init(Bundle savedInstanceState)
    {
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.layout_scancode_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.scancode_framelayout, captureFragment).commit();
    }

    @Override
    protected int onLoadLayout()
    {
        return R.layout.layout_activity_scancode;
    }

    @Override
    protected void initCommonTitle()
    {
        new CommonTitleBuilder(this).setCommonTitleGone().build();
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback()
    {
        /**
         * 解析成功
         * @param mBitmap
         * @param result
         */
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result)
        {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
//            SecondActivity.this.setResult(RESULT_OK, resultIntent);
//            SecondActivity.this.finish();
        }

        /**
         * 解析失败
         */
        @Override
        public void onAnalyzeFailed()
        {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
//            SecondActivity.this.setResult(RESULT_OK, resultIntent);
//            SecondActivity.this.finish();
        }
    };

}
