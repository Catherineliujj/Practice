package com.catherineliu.practice.main_code.about_do_dish;

/**
 * 项目：Practice
 * 文件描述：模板设计模式  运用
 * 作者：ljj
 * 创建时间：2019/7/31
 */
public class Practice {
    public static void  main(String[] args){
        DoDishTemplate eggsWithTomato = new EggWithTomato();
        eggsWithTomato.startDoDish();

        System.out.println("-------------------------------------");

        DoDishTemplate braisedPork = new BraisedPork();
        braisedPork.startDoDish();
    }
}
