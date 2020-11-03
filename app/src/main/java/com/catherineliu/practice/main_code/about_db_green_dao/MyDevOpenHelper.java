package com.catherineliu.practice.main_code.about_db_green_dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.catherineliu.practice.main_code.about_db_green_dao.model.DaoMaster;
import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDaoDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/11/2
 */
public class MyDevOpenHelper extends DaoMaster.OpenHelper {

    public MyDevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.migrate(db, PersonInfoDaoDao.class);
    }

}
