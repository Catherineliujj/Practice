package com.catherineliu.practice.main_code.about_mvp.presenter;

import com.catherineliu.practice.main_code.about_mvp.model.IModel;
import com.catherineliu.practice.main_code.about_mvp.model.ModelImp;
import com.catherineliu.practice.main_code.about_mvp.view.IView;

/**
 * 项目：Practice
 * 文件描述：定义路由层
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public class Presenter {

    IModel iModel;
    IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
        iModel = new ModelImp();
    }

    public void getInfo(String info){
        String iModelInfo = iModel.getInfo(info);
        if (iModelInfo == null){
            iView.showInfo("暂无该人员信息");
        } else {
            iView.showInfo(iModelInfo);
        }
    }

}
