package com.catherineliu.practice.main_code.about_mvp;

import com.catherineliu.practice.main_code.about_mvp.model.ModelBean;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public interface DataCallBackListener {
    void success(ModelBean modelBean);
    void failed();
}
