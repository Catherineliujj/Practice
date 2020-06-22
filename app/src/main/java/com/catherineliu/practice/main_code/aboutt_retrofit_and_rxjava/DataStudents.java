package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import java.util.List;

/**
 * 项目：Practice
 * 文件描述：RxJava 的使用model
 * 作者：ljj
 * 创建时间：2020/6/19
 */
public class DataStudents {

    private String name;
    private int age;
    private String sex;
    private List<Course> coursesList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public static class Course{
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
