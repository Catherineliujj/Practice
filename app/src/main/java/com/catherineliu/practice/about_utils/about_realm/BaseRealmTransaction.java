package com.catherineliu.practice.about_utils.about_realm;

import com.catherineliu.practice.about_base.BaseRealmConfig;

import io.realm.Realm;

public abstract class BaseRealmTransaction {

    public Realm realm;

    public BaseRealmTransaction() {
        if (realm == null)
            realm = BaseRealmConfig.getRealm();
        runMain();
    }

    public BaseRealmTransaction(Realm realm) {
        this.realm = realm;
        runMain();
    }

    //创建操作
    public abstract void beginDb();

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
        }
    }
}
