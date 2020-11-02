package com.catherineliu.practice.about_utils.about_realm;

import android.os.Looper;

import com.catherineliu.practice.about_base.BaseRealmConfig;

import io.realm.Realm;

public abstract class BaseRealmThread {
    public Realm realm;

    public BaseRealmThread() {
        realm = BaseRealmConfig.getRealm();
        runMain();
    }

    public BaseRealmThread(Realm realm) {
        this.realm = realm;
        runMain();
    }

    //创建操作
    public abstract void beginDb();

    //更新数据操作
    public abstract void beginThreadDb() throws InterruptedException;


    public void runMain() {

//        realm= Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            beginDb();
            realm.commitTransaction();
        } catch (Exception e) {
            if (realm.isInTransaction())
                realm.cancelTransaction();
        } finally {
            realm.close();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    try {
                        beginThreadDb();
                        Looper.loop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
            }).start();
        }
    }


}
