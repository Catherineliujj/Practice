package com.catherineliu.practice.main_code.about_ebbinghaus;

import java.util.List;

/**
 * 项目：Practice
 * 文件描述：艾宾浩斯遗忘曲线表格数据model
 * 作者：ljj
 * 创建时间：2020/6/22
 */
public class DataEbbinghaus {

    private int week;
    private String day;
    private String listStr;
    private String todayPlan;
    private List<String> reviewPlanList;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getListStr() {
        return listStr;
    }

    public void setListStr(String listStr) {
        this.listStr = listStr;
    }

    public String getTodayPlan() {
        return todayPlan;
    }

    public void setTodayPlan(String todayPlan) {
        this.todayPlan = todayPlan;
    }

    public List<String> getReviewPlanList() {
        return reviewPlanList;
    }

    public void setReviewPlanList(List<String> reviewPlanList) {
        this.reviewPlanList = reviewPlanList;
    }
}
