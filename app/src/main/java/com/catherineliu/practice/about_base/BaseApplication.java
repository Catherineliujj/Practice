package com.catherineliu.practice.about_base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.catherineliu.practice.about_utils.ACache;
import com.catherineliu.practice.about_utils.about_swipback.BGASwipeBackHelper;

public class BaseApplication extends MultiDexApplication {
    //cpu常开，息屏保活
//    private PowerManager pm;
//    private PowerManager.WakeLock wakeLock;

//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

    @SuppressLint("InvalidWakeLockTag")
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        mContext=this;
//        QMUISwipeBackActivityManager.init(this);
        /**
         * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
         */
        BGASwipeBackHelper.init(this, null);
//        pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
//        wakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"CPUKeepRunning");
//        wakeLock.acquire();
    }
    public static ACache aCache;
    public static Context mContext;
    public static ACache getaCache(){
        if (aCache==null)
        {
            aCache =  ACache.get(getAppContext());
        }
        return aCache;
    }
    public static Context getAppContext() {
        return mContext;
    }
}