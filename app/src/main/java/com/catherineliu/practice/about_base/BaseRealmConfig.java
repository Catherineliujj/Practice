package com.catherineliu.practice.about_base;

import android.content.Context;

import com.catherineliu.practice.about_utils.MathUtils;
import com.catherineliu.practice.about_utils.MyLog;

import java.util.HashSet;
import java.util.Set;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import party.loveit.bip44forjava.core.ECKey;
import party.loveit.bip44forjava.core.Sha256Hash;

/**
 * 项目：Practice
 * 文件描述：Realm数据库配置文件
 * 作者：ljj
 * 创建时间：2020/9/18
 */
public class BaseRealmConfig {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    static RealmConfiguration realmConfig = null;
    protected static Set<RealmConfiguration> mConfigsList = new HashSet<RealmConfiguration>();
    private static final int version_db = 1;  // 数据库版本号

    public static void setInitRealm(Context context) {
        //此处根据业务调用初始化，避免出现默认库bug
        if (Realm.getDefaultConfiguration() == null)
            Realm.init(context);
        if (!Realm.getDefaultConfiguration().getRealmFileName().equals("practice")) {
            MyLog.d("baseRealm", "=============realmDBName  !equals======setRealm=====");
            setRealm();
        }
    }

    private static void setRealm() {
//        AppConfig.logs("=============setWalletOCRealm======开始=====");
        ECKey ecKey = ECKey.fromPrivate(MathUtils.toBigInt("0abc4301"));
        byte[] sha256 = Sha256Hash.hash(ecKey.getPubKey());
//      解密
        MyLog.e("sha256---------", MathUtils.toHexStringNoPrefix(MathUtils.toHexStringNoPrefix(sha256).getBytes()));
        realmConfig = new RealmConfiguration.Builder()
//                .schemaVersion(ConfigRealm.DB_VER)
                .migration(migration_db)
//       设置数据库密码
                .encryptionKey(MathUtils.toHexStringNoPrefix(sha256).getBytes())
                .deleteRealmIfMigrationNeeded()//声明版本冲突时自动删除原数据库，开发时候打开
                .name("practice.realm")
                .schemaVersion(version_db)
                .build();
        mConfigsList.add(realmConfig);
        Realm.setDefaultConfiguration(realmConfig);

    }

    public static Realm getRealm() {
        return Realm.getInstance(getRealmConfiguration());
    }

    public static RealmConfiguration getRealmConfiguration() {
        if (realmConfig == null) {
            setRealm();
        }
        return realmConfig;
    }

    // 升级数据库
    protected static RealmMigration migration_db = new RealmMigration() {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
/*            RealmSchema schema = realm.getSchema();
            //数据库升级
            if (oldVersion == 1) {
                schema.get("Rm_WalletOC")
                        .removeField("isInvitation")
                        .addField("invitationStatus", String.class)
                        .addField("pledgeStatus", String.class);
                RealmObjectSchema rm_currencyExgRates = schema.get("Rm_CurrencyExgRates");
                schema.get("Rm_WalletOC")
                        .addRealmListField("rm_currencyExgRates", rm_currencyExgRates)
                        .addField("pledgeNum", String.class)
                ;
                oldVersion++;
            }*/

        }
    };

}
