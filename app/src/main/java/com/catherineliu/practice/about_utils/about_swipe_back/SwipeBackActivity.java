package com.catherineliu.practice.about_utils.about_swipe_back;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class SwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase, View.OnClickListener {
    //    返回的对象
    public SwipeBackActivityHelper mHelper;

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mHelper != null)
            mHelper.onPostCreate();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        if (mHelper != null)
            return mHelper.getSwipeBackLayout();
        else return null;
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

}
