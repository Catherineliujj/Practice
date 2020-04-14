package com.catherineliu.practice.about_base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.catherineliu.practice.about_utils.ACache;

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