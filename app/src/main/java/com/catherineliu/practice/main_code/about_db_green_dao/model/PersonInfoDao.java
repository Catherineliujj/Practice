package com.catherineliu.practice.main_code.about_db_green_dao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目：Practice
 * 文件描述：PersonInfoDao实体类
 * 作者：ljj
 * 创建时间：2020/11/2
 */
@Entity
public class PersonInfoDao {

    @Id(autoincrement = true)  // 设置自增长
    private Long id;
    @Index(unique = true)  // 设置唯一性
    private String perNo;
    private String name;
    private String sex;
    private int age;

    @Generated(hash = 1255363335)
    public PersonInfoDao(Long id, String perNo, String name, String sex, int age) {
        this.id = id;
        this.perNo = perNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Generated(hash = 1933258214)
    public PersonInfoDao() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerNo() {
        return this.perNo;
    }

    public void setPerNo(String perNo) {
        this.perNo = perNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
