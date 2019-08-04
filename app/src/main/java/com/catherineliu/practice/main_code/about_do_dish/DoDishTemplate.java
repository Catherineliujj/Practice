package com.catherineliu.practice.main_code.about_do_dish;

/**
 * 项目：Practice
 * 文件描述：模板设计模式  模板
 * 作者：ljj
 * 创建时间：2019/7/31
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public abstract class DoDishTemplate {

    /**
     * 具体的整个过程
     */
    void startDoDish(){
        this.washThings();
        this.preparation();
        this.doing();
        this.carriedDishes();
    }

    /**
     * 准备工作
     * 公共实现的方法
     */
    private void washThings(){
        System.out.println("洗手和洗碗筷。");
    }

    /**
     * 备料
     * abstract修饰，暴露给继承类，可重载的方法
     */
    public abstract void preparation();

    /**
     * 做菜
     * abstract修饰，暴露给继承类，可重载的方法
     */
    public abstract void doing();

    /**
     * 上菜
     * abstract修饰，暴露给继承类，可重载的方法
     */
    public abstract void carriedDishes();

}
