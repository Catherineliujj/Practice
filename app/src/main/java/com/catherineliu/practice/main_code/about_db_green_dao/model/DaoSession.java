package com.catherineliu.practice.main_code.about_db_green_dao.model;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDao;

import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personInfoDaoDaoConfig;

    private final PersonInfoDaoDao personInfoDaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personInfoDaoDaoConfig = daoConfigMap.get(PersonInfoDaoDao.class).clone();
        personInfoDaoDaoConfig.initIdentityScope(type);

        personInfoDaoDao = new PersonInfoDaoDao(personInfoDaoDaoConfig, this);

        registerDao(PersonInfoDao.class, personInfoDaoDao);
    }
    
    public void clear() {
        personInfoDaoDaoConfig.clearIdentityScope();
    }

    public PersonInfoDaoDao getPersonInfoDaoDao() {
        return personInfoDaoDao;
    }

}