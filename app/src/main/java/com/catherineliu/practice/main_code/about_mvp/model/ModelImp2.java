package com.catherineliu.practice.main_code.about_mvp.model;

import com.catherineliu.practice.main_code.about_mvp.DataCallBackListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/2
 */
public class ModelImp2 implements Model {

    private List<ModelBean> modelBeanList = new ArrayList<>();

    @Override
    public void getId(int id, DataCallBackListener callBack) {
        try {
            for (int i = 0; i < 26; i++){
                modelBeanList.add(new ModelBean(i + 1, "Helen" + i, 12 + i));
            }
            for (int i = 0; i < modelBeanList.size(); i++){
                if (id == modelBeanList.get(i).getId()){
                    callBack.success(modelBeanList.get(i));
                }
            }
        }catch (Exception e){
            callBack.failed();
        }
    }
}
