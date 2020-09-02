package com.catherineliu.practice.main_code.about_mvp.model;

/**
 * 项目：Practice
 * 文件描述：对IModel接口的实现
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public class ModelImp implements IModel {

    private String[] mId = {
            "001", "002",
            "003", "004",
            "005", "006", "007"};
    private String[] mInfoStr = {
            "Amy, girl, 20",
            "Bob, boy, 24",
            "Cathy, girl, 23",
            "David, boy, 15",
            "Ella, girl, 10",
            "Feel, boy, 22",
            "Given, boy, 23"};

    @Override
    public String getInfo(String info) {
        for (int i=0; i < mId.length; i ++){
            if (info.equals(mId[i])){
                return mInfoStr[i];
            }
        }
        return null;
    }
}
