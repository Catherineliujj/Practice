package com.catherineliu.practice.main_code.about_db_green_dao;

import android.content.Context;

import com.catherineliu.practice.about_base.ConstantsValue;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.main_code.about_db_green_dao.model.DaoMaster;
import com.catherineliu.practice.main_code.about_db_green_dao.model.DaoSession;
import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDao;
import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDaoDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * 项目：Practice
 * 文件描述：数据库操作类
 * 作者：ljj
 * 创建时间：2020/11/2
 */
public class DbController {

    /**
     * 是否加密
     */
    public static final boolean ENCRYPTED = true;

    /**
     * Helper
     */
    private MyDevOpenHelper mHelper;

    /**
     * 数据库
     */
    private Database db;

    /**
     * DaoMaster
     */
    private DaoMaster mDaoMaster;

    /**
     * DaoSession
     */
    private DaoSession mDaoSession;

    /**
     * 上下文
     */
    private Context context;

    /**
     * dao
     */
    private PersonInfoDaoDao personInfoDaoDao;

    private static DbController mDbController;

    /**
     * 初始化
     * @param context
     */
    public DbController(Context context) {
        this.context = context;
        mHelper = new MyDevOpenHelper(context, ENCRYPTED ? "person_db_encrypt.db" : "person_db.db", null);
        db = ENCRYPTED ? mHelper.getEncryptedReadableDb(ConstantsValue.DATABASE_ENCRYPT_PASSWORD) : mHelper.getWritableDb();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        personInfoDaoDao = mDaoSession.getPersonInfoDaoDao();
    }

    /**
     * 获取单例
     */
    public static DbController getInstance(Context context) {
        if (mDbController == null) {
            synchronized (DbController.class) {
                if (mDbController == null) {
                    mDbController = new DbController(context);
                }
            }
        }
        return mDbController;
    }

    /**
     * 获取可读数据库
     */
    private Database getReadableDataBase() {
        if (mHelper == null) {
            mHelper = new MyDevOpenHelper(context, "person_db.db", null);
        }
        return mHelper.getReadableDb();
    }

    /**
     * 获取可写数据库
     * @return
     */
    private Database getWritableDataBase() {
        if (mHelper == null) {
            mHelper = new MyDevOpenHelper(context, "person_db.db", null);
        }
        return mHelper.getWritableDb();
    }

    /**
     * 会自动判定是插入还是替换
     */
    public void insertOrReplace(PersonInfoDao personInfo) {
        personInfoDaoDao.insertOrReplace(personInfo);
    }

    /**
     * 插入一条记录，表里要没有与之相同的记录
     */
    public long insert(PersonInfoDao personInfo) {
        return personInfoDaoDao.insert(personInfo);
    }

    /**
     * 更新数据
     */
    public void update (PersonInfoDao  personInfo) {
        PersonInfoDao mOldPersonInfo = personInfoDaoDao.queryBuilder().where(PersonInfoDaoDao.Properties.PerNo.eq(personInfo.getPerNo())).build().unique();
        if (mOldPersonInfo != null) {
            mOldPersonInfo.setPerNo(personInfo.getPerNo());
            mOldPersonInfo.setName(personInfo.getName());
            mOldPersonInfo.setSex(personInfo.getSex());
            mOldPersonInfo.setAge(personInfo.getAge());
            personInfoDaoDao.update(mOldPersonInfo);
        } else {
            MyLog.i("DbController", "无该用户的记录");
            ToastUtil.show("无该用户的记录");
        }
    }

    /**
     * 按条件查询数据
     */
    public List<PersonInfoDao> searchByWhere(int type, String wherecluse) {
        List<PersonInfoDao> personInfoDaos;
        WhereCondition condition = null;
        switch (type) {
            case 0:  // perNo
                condition = PersonInfoDaoDao.Properties.PerNo.eq(wherecluse);
                break;
            case 1:  // name
                condition = PersonInfoDaoDao.Properties.Name.eq(wherecluse);
                break;
            case 2:  // sex
                condition = PersonInfoDaoDao.Properties.Sex.eq(wherecluse);
                break;
            case 3:  // age
                condition = PersonInfoDaoDao.Properties.Age.eq(wherecluse);
                break;
        }
        personInfoDaos = (List<PersonInfoDao>) personInfoDaoDao.queryBuilder().where(condition).build().list();
        return personInfoDaos;
    }

    /**
     * 查询所有数据
     */
    public List<PersonInfoDao> searchAll() {
        List<PersonInfoDao> personInfoDaos = personInfoDaoDao.queryBuilder().list();
        return personInfoDaos;
    }

    /**
     * 删除数据
     */
    public void deleteByWhere(int type, String wherecluse) {
        WhereCondition condition = null;
        switch (type) {
            case 0:  // perNo
                condition = PersonInfoDaoDao.Properties.PerNo.eq(wherecluse);
                break;
            case 1:  // name
                condition = PersonInfoDaoDao.Properties.Name.eq(wherecluse);
                break;
            case 2:  // sex
                condition = PersonInfoDaoDao.Properties.Sex.eq(wherecluse);
                break;
            case 3:  // age
                condition = PersonInfoDaoDao.Properties.Age.eq(wherecluse);
                break;
        }
        personInfoDaoDao.queryBuilder().where(condition).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除数据
     */
    public void deleteAll() {
        personInfoDaoDao.queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
    }

}
