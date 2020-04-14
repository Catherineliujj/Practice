package com.catherineliu.practice.about_base;

import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.view.MenuItem;
import android.view.View;

import com.catherineliu.practice.about_utils.AppManager;
import com.catherineliu.practice.about_utils.about_status_bar.StatusBarUtil;

/**
 * BaseActivity
 */
public abstract class BaseActivity extends BaseActivityForResult implements View.OnClickListener {

    @Override
    protected void initBeforeContentView() {
        super.initBeforeContentView();

    }
    @SuppressWarnings("unchecked")
    public final <E extends View> E getView (int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }
//        protected boolean isSupportSwipeBack() {
//        return true;
//    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    public void onBackPressed() {
        AppManager.getAppManager().finishActivity(this);

        overridePendingTransition(0,0);
    }

    /**
     * 设置状态栏颜色
     *
     * @param color
     */
    protected void setStatusBarColor(@ColorInt int color) {
        setStatusBarColor(color, 0);
    }

    /**
     * 设置状态栏颜色
     *
     * @param color
     * @param statusBarAlpha 透明度
     */
    public void setStatusBarColor(@ColorInt int color, @IntRange(from = 0, to = 255) int statusBarAlpha) {
        StatusBarUtil.setColorForSwipeBack(this, color, statusBarAlpha);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void addOnClickListeners(@IdRes int... ids) {
        try {
            if (ids != null) {
                for (@IdRes int id : ids) {
                    getView(id).setOnClickListener(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

    }
}