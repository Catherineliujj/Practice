package com.catherineliu.practice.about_base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.catherineliu.practice.about_utils.ACache;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.entry.DefaultApplicationLike;

import androidx.multidex.MultiDex;
import io.realm.Realm;

/**
 * 项目：Practice
 * 文件描述：BaseApplicationLike
 * 作者：ljj
 * 创建时间：2020/9/9
 */
public class BaseApplicationLike extends DefaultApplicationLike {
    public BaseApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @SuppressLint("InvalidWakeLockTag")
    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplication(), "9239091e65", false);

        MultiDex.install(this.getApplication().getApplicationContext());
        mContext=this.getApplication().getApplicationContext();
        BaseRealmConfig.setInitRealm(mContext);
    }
    public static ACache aCache;
    public static Context mContext;
    public static ACache getACache(){
        if (aCache==null)
        {
            aCache =  ACache.get(getAppContext());
        }
        return aCache;
    }
    public static Context getAppContext() {
        return mContext;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker(this);

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }
}
