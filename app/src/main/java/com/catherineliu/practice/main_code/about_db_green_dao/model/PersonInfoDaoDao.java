package com.catherineliu.practice.main_code.about_db_green_dao.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PERSON_INFO_DAO".
*/
public class PersonInfoDaoDao extends AbstractDao<PersonInfoDao, Long> {

    public static final String TABLENAME = "PERSON_INFO_DAO";

    /**
     * Properties of entity PersonInfoDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PerNo = new Property(1, String.class, "perNo", false, "PER_NO");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Sex = new Property(3, String.class, "sex", false, "SEX");
        public final static Property Age = new Property(4, int.class, "age", false, "AGE");
    }


    public PersonInfoDaoDao(DaoConfig config) {
        super(config);
    }
    
    public PersonInfoDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PERSON_INFO_DAO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PER_NO\" TEXT," + // 1: perNo
                "\"NAME\" TEXT," + // 2: name
                "\"SEX\" TEXT," + // 3: sex
                "\"AGE\" INTEGER NOT NULL );"); // 4: age
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_PERSON_INFO_DAO_PER_NO ON \"PERSON_INFO_DAO\"" +
                " (\"PER_NO\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON_INFO_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PersonInfoDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String perNo = entity.getPerNo();
        if (perNo != null) {
            stmt.bindString(2, perNo);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
        stmt.bindLong(5, entity.getAge());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PersonInfoDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String perNo = entity.getPerNo();
        if (perNo != null) {
            stmt.bindString(2, perNo);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
        stmt.bindLong(5, entity.getAge());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PersonInfoDao readEntity(Cursor cursor, int offset) {
        PersonInfoDao entity = new PersonInfoDao( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // perNo
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sex
            cursor.getInt(offset + 4) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PersonInfoDao entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPerNo(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAge(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PersonInfoDao entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PersonInfoDao entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PersonInfoDao entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
