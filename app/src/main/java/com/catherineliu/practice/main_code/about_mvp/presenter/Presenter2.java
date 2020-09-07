package com.catherineliu.practice.main_code.about_mvp.presenter;

import com.catherineliu.practice.main_code.about_mvp.DataCallBackListener;
import com.catherineliu.practice.main_code.about_mvp.model.Model;
import com.catherineliu.practice.main_code.about_mvp.model.ModelBean;
import com.catherineliu.practice.main_code.about_mvp.model.ModelImp2;
import com.catherineliu.practice.main_code.about_mvp.view.View;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public class Presenter2 {

    private View view;
    private Model model;

    public Presenter2(View view) {
        this.view = view;
        model = new ModelImp2();
    }

    // 传入id
    public void showInfo(int id){
        // 进行处理
        model.getId(id, new DataCallBackListener() {
            @Override
            public void success(ModelBean modelBean) {
                if (modelBean != null){
                    view.showInfo(modelBean);
                } else {
                    view.showInfo(null);
                }
            }

            @Override
            public void failed() {

            }
        });

    }

}
