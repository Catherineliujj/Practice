package com.catherineliu.practice.main_code.about_mvp.model;

import com.catherineliu.practice.main_code.about_mvp.DataCallBackListener;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public interface Model {
    void getId(int id, DataCallBackListener callBack);
}
