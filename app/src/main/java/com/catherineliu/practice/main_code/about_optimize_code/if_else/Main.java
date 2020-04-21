package com.catherineliu.practice.main_code.about_optimize_code.if_else;

import android.os.Build;

import java.util.Optional;

/**
 * 项目：Practice
 * 文件描述：优化代码  if_else 篇
 * 作者：ljj
 * 创建时间：2020/4/1
 */
public class Main {

    public static void main(String args[]){
        /*
        类型一
        if(param.equals("NEW")){
            statusCode = 0;
        }else if(param.equals("RUNNABLE")){
            statusCode = 1;
        }*/
        int statusCode = EnumType.Status.valueOf("RUNNING").statusCode;
        System.out.println(statusCode + "\n-------------------------------------");

        /*
        类型二
        if(null == user){
            //actionFirst
        }else{
            //actionSecond
        }*/
/*        OptionalType.User user = new OptionalType.User();
        Optional<OptionalType.User> userOptional = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            userOptional = Optional.ofNullable(user);
            userOptional.map(OptionalType.actionSecond("two")).orElse(OptionalType.actionSecond("two"));
        }*/


    }
}
