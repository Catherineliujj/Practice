package com.catherineliu.practice.about_do_dish;

/**
 * 项目：Practice
 * 文件描述：红烧肉模板
 * 作者：ljj
 * 创建时间：2019/7/31
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class BraisedPork extends DoDishTemplate {
    @Override
    public void preparation() {
        System.out.println("切猪肉和土豆。");
    }

    @Override
    public void doing() {
        System.out.println("将切好的猪肉倒入锅中炒一会然后倒入土豆连炒带炖。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将做好的红烧肉盛进碗里端给客人吃。");
    }
}
