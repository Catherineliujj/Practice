package com.catherineliu.practice.main_code.about_optimize_code.if_else;

/**
 * 项目：Practice
 * 文件描述：转为枚举
 * 作者：ljj
 * 创建时间：2020/4/1
 */
public class EnumType {

    /**
     * 枚举类型
     */
    public enum Status {
        NEW(0),RUNNABLE(1),RUNNING(2),BLOCKED(3),DEAD(4);

        public int statusCode;

        Status(int statusCode){
            this.statusCode = statusCode;
        }
    }

}
