package com.catherineliu.practice.about_base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_utils.AppManager;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.about_utils.WindowBugDeal;
import com.catherineliu.practice.about_utils.about_status_bar.StateBarUtils;
import com.catherineliu.practice.about_utils.about_swipe_back.SwipeBackActivity;
import com.catherineliu.practice.about_utils.windowStatusBar;

import butterknife.ButterKnife;

public abstract class BaseActivityForResult extends SwipeBackActivity {
    // 默认是日间模式
    private int theme = R.style.AppTheme;

    public String simpleName;
    protected abstract int getLayoutView();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否有主题存储
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        AppManager.getAppManager().addActivity(this);
        /**
         * 切换为非全屏
         */
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        if (isImmersive()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

//        getWindow().setBackgroundDrawableResource(android.R.color.transparent);// 将 Activity 的背景色取消

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        simpleName = getClass().getSimpleName();
//        ScreenUtils.setWindowStatusBarColor(AppManager.getAppManager().currentActivity(),R.color.red);
        if (isImmersive()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

//            windowStatusBar.setStatusColor(this, getResources().getColor(R.color.app_theme), 50);
                getWindow().setNavigationBarColor(Color.WHITE);
            }
        }
        initBeforeContentView();
        setContentView(getLayoutView());
        ButterKnife.bind(this);
        initViewUI();
        initData();
//        EventBus.getDefault().register(this);
    }
    /**
     * 订阅方法，接收到服务器返回事件处理
     */
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventStr(String messageEvent){
//
//    }
    protected void initBeforeContentView() {
        if (isImmersive()) {
            if (isGonesStatus()) {
                //全屏不显示状态栏导航栏
                StateBarUtils.setFullscreen(this, false, false);
            } else {
                //全屏显示状态栏隐藏导航栏
                StateBarUtils.setFullscreen(this, true, false);
//            设置状态栏的颜色
                windowStatusBar.setStatusColor(this, getResources().getColor(R.color.white), 0);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);  // 设置状态栏黑色字体
//            StateBarUtils.setFullscreen(this,true,true);
            }
        }
//        StateBarUtils.setAndroidNativeLightStatusBar(this, false);//设置界面浮在导航栏上
    }

    protected abstract void initViewUI();
    protected abstract void initData();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }

/*    protected int getLayoutView() {
        return 0;
    }*/

    protected boolean isGones() {
        return true;
    }

    //    是否隐藏状态栏，默认不隐藏
    protected boolean isGonesStatus() {
        return false;
    }
    //    是否沉浸式状态栏  默认是
    public boolean isImmersive() {
        return true;
    }

    //    是否登录页面 默认不是
    protected boolean isLogin() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        关闭eventbus
//        EventBus.getDefault().unregister(this);
//        关闭弹窗
//        DialogUtils.isShow();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (findViewById(R.id.include_top_lin_back) != null){
            initTopBack();
        }
        if (findViewById(R.id.include_top_iv_right) != null){
            initTopSwitch();
        }
    }

    private void initTopSwitch() {
        if (isTopSwitch()) {
            try {
                findViewById(R.id.include_top_iv_right).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        theme = (theme == R.style.AppTheme) ? R.style.NightAppTheme : R.style.AppTheme;
                        AppManager.getAppManager().currentActivity().recreate();
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initTopBack() {
        if (isTopBack())
        {
            try {
                findViewById(R.id.include_top_lin_back).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        AppManager.getAppManager().finishActivity();
                        return false;
                    }
                });
                isGone();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isGones())
        {
            isGone();
        }
    }

    public boolean isSupportSwipeBack() {
        return true;
    }
    protected boolean isTopBack() {
        return true;
    }
    protected boolean isTopSwitch() {
        return true;
    }
    //接收到消息，传递给子类
    public void receiveResultMsg(String responseText) {
    }

    private void isGone() {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
//        NewStatusBarUtil.setRootViewFitsSystemWindows(this,true);
        View mtv=null;
        try {
//            mtv = (View) AppManager.getAppManager().currentActivity().findViewById(R.id.include_top_margin10);
        } catch (Exception e) {
            e.printStackTrace();
            mtv=null;
        }
        if (mtv==null)
        {
            return;
        }
//        LinearLayout mLinBac = (LinearLayout) AppManager.getAppManager().currentActivity().findViewById(R.id.include_top_lin_background);
//        mLinBac.setBackgroundColor(getResources().getColor(R.color.app_theme));
        mtv.setBackgroundColor(getResources().getColor(R.color.white));
        // 设置状态栏高度
        int statusBarHeight = WindowBugDeal.getStatusBarHeight(this);
        //这里我用RelativeLayout布局为列，其他布局设置方法一样，只需改变布局名就行
        LinearLayout.LayoutParams layout=(LinearLayout.LayoutParams)mtv.getLayoutParams();
        //获得button控件的位置属性，需要注意的是，可以将button换成想变化位置的其它控件
//        layout.setMargins(0,-statusBarHeight,0,0);
        layout.height=statusBarHeight;
        //设置button的新位置属性,left，top，right，bottom
        mtv.setLayoutParams(layout);
//        mtv.getBackground().setAlpha(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mtv.setVisibility(View.VISIBLE);
        }else
        {
            mtv.setVisibility(View.GONE);
        }
    }

}