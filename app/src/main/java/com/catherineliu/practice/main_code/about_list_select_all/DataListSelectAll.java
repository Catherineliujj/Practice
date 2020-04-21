package com.catherineliu.practice.main_code.about_list_select_all;

/**
 * 项目：Practice
 * 文件描述：列表全选数据model
 * 作者：ljj
 * 创建时间：2020/4/20
 */
public class DataListSelectAll {

    private boolean isChecked;  // 是否选中
    private String content;  // item内容

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
