package com.catherineliu.practice.main_code.about_optimize_code.if_else;

import android.arch.core.util.Function;

/**
 * 项目：Practice
 * 文件描述：OptionalType
 * 作者：ljj
 * 创建时间：2020/4/1
 */
public class OptionalType {

    public static java.util.function.Function<? super User, ?> actionFirst(String str){
        System.out.println(str + "--我是第一个动作\n-------------------------------------");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return new java.util.function.Function<User, Object>() {
                @Override
                public Object apply(User user) {
                    return user;
                }
            };
        } else return null;
    }

    public static java.util.function.Function<? super User, ?> actionSecond(String str){
        System.out.println(str + "--我是第二个动作\n-------------------------------------");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return new java.util.function.Function<User, Object>() {
                @Override
                public Object apply(User user) {
                    return user;
                }
            };
        } else return null;
    }



    static class User{
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }



}
