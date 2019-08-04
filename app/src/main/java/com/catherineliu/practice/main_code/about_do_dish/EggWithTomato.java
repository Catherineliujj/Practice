package com.catherineliu.practice.main_code.about_do_dish;

/**
 * 项目：Practice
 * 文件描述：西红柿炒蛋模板
 * 作者：ljj
 * 创建时间：2019/7/31
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class EggWithTomato extends DoDishTemplate {

    /**
     * 重载三大abstract修饰的方法
     * 根据需求编写个性化的动作
     */

    @Override
    public void preparation() {
        System.out.println("洗并切西红柿，打鸡蛋。");
    }

    @Override
    public void doing() {
        System.out.println("鸡蛋倒入锅里，然后倒入西红柿一起炒。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将炒好的西红柿鸡蛋装入碟子里，端给客人吃。");
    }
}
