package com.catherineliu.practice.main_code.about_student_system;

import java.util.Scanner;

/**
 * 项目：Practice
 * 文件描述：学生管理系统逻辑部分
 * 作者：ljj
 * 创建时间：2020/6/22
 */
public class StudentSystem {
    public static void main(String[] args) {
        Put putmain=new Put();
        Data da=new Data();
        while(true){
            putmain.outmain();
            Scanner sca=new Scanner(System.in);
            int x=sca.nextInt();
            if(x==1)
            {
                da.InData();
                da.OutData();
            }
            else if(x==2)
            {
                da.OutData();
            }
            else if(x==3)
            {
                Put putsort=new Put();
                putsort.outsort();
                Scanner sca1=new Scanner(System.in);
                int y=sca1.nextInt();
                if(y==1){
                    da.Sage();}
                else if(y==2){
                    da.Sname();}
                else if(y==3){
                    da.Snum();}
            }
            else if(x==4)
            {
                Put putfind=new Put();
                putfind.outfind();
                Scanner sca2=new Scanner(System.in);
                int z=sca2.nextInt();
                if(z==1){
                    da.Fage();
                }
                else if(z==2){
                    da.Fname();
                }
                else if(z==3){
                    da.Fnum();
                }
            }
            else if(x==5){
                da.Update();
                da.OutData();
            }
            else if(x==6){
                da.InsertData();
                da.OutData();
            }
            else if(x==7){
                da.DeleteData();
                da.OutData();
            }
            else if(x==0){
                System.exit(0);
            }
        }
    }

    static class Student{
        private String name,sex;
        private int age,num;
        public String getName(){
            return name;}
        public void setName(String name){
            this.name=name;
        }
        public String getSex(){
            return sex;
        }
        public void setSex(String sex){
            this.sex=sex;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }
    static class Data{
        int z,flog=0;
        Student stu[]=new Student[100];
        Scanner sca=new Scanner(System.in);
        void InData(){
            int i=0;
            for(i=0;i<stu.length;i++)
            {
                stu[i]=new Student();
                flog++;
                System.out.println("姓名：");
                stu[i].setName(sca.next());
                System.out.println("年龄：");
                stu[i].setAge(sca.nextInt());
                System.out.println("性别：");
                stu[i].setSex(sca.next());
                System.out.println("学号：");
                stu[i].setNum(sca.nextInt());
                System.out.print("输入0返回主页面，输入其它任意数字继续录入，请选择：");
                int z = 0;
                try {
                    z = sca.nextInt();
                } catch (Exception e) {
                    z = 1;
                    e.printStackTrace();
                }
                if(z==0){
                    break;
                }
            }
        }
        void OutData(){
            for(int i=0;i<flog;i++){
                System.out.println("姓名："+stu[i].getName());
                System.out.println("年龄："+stu[i].getAge());
                System.out.println("性别："+stu[i].getSex());
                System.out.println("学号："+stu[i].getNum());
                System.out.println(" ");

            }
        }
        void Fname(){
            int i,x=0;
            if(flog==0){
                System.out.println("学生信息表没有记录！");
            }
            System.out.println("请输入要查找的姓名：");
            String y=sca.next();
            for(i=0;i<flog;i++){
                if(stu[i].getName().compareTo(y)==0){
                    System.out.println("姓名："+stu[i].getName());
                    System.out.println("年龄："+stu[i].getAge());
                    System.out.println("性别："+stu[i].getSex());
                    System.out.println("学号："+stu[i].getNum());
                    System.out.println(" ");
                    x++;
                }
            }
            if(x==0){
                System.out.println("查无此人！");
            }
        }
        void Fage(){
            int i,x=0;
            if(flog==0)
                System.out.println("学生信息表没有记录！");
            System.out.println("请输入要查找的年龄：");
            int y=sca.nextInt();
            for(i=0;i<flog;i++){
                if(stu[i].getAge()==y){
                    System.out.println("姓名："+stu[i].getName());
                    System.out.println("年龄："+stu[i].getAge());
                    System.out.println("性别："+stu[i].getSex());
                    System.out.println("学号："+stu[i].getNum());
                    System.out.println(" ");
                    x++;
                }
            }
            if(x==0){
                System.out.println("查无此人！");
            }
        }
        void Fnum(){
            int i,x=0;
            if(flog==0){
                System.out.println("学生信息表没有记录！");
            }
            System.out.println("请输入要查找的学号：");
            int y=sca.nextInt();
            for(i=0;i<flog;i++){
                if(stu[i].getNum()==y){
                    System.out.println("姓名："+stu[i].getName());
                    System.out.println("年龄："+stu[i].getAge());
                    System.out.println("性别："+stu[i].getSex());
                    System.out.println("学号："+stu[i].getNum());
                    System.out.println(" ");
                    x++;
                }
            }
            if(x==0){
                System.out.println("查无此人！");
            }
        }
        void Update(){
            Put putupdate=new Put();
            if(flog==0){
                System.out.println("学生信息表没有记录！");
            }
            System.out.print("请输入要修改信息学生的学号：");
            int x=sca.nextInt();
            for(int i=0;i<flog;i++)
                if(stu[i].getNum()!=x){
                    System.out.print("查无此人！");
                }
                else{
                    putupdate.outupdate();
                    int in=sca.nextInt();
                    if(in==1){
                        System.out.println("请输入新的年龄：");
                        stu[i].setAge(sca.nextInt());
                        break;
                    }
                    else if(in==2){
                        System.out.println("请输入新的姓名：");
                        stu[i].setName(sca.next());
                    }
                    else if(in==3){
                        System.out.println("请输入新的学号：");
                        stu[i].setNum(sca.nextInt());
                    }
                    else if(in==4){
                        System.out.println("请输入新的性别：");
                        stu[i].setSex(sca.next());
                    }
                }
        }
        void InsertData(){
            for(int i=flog;i<stu.length;i++)
            {
                stu[i]=new Student();
                flog++;
                System.out.print("姓名：");
                stu[i].setName(sca.next());
                System.out.print("年龄：");
                stu[i].setAge(sca.nextInt());
                System.out.print("性别：");
                stu[i].setSex(sca.next());
                System.out.print("学号：");
                stu[i].setNum(sca.nextInt());
                System.out.print("输入0返回主页面，输入其它任意数字继续插入数据，请选择：");
                int z=sca.nextInt();
                if(z==0)
                    break;
            }
        }
        void DeleteData(){
            System.out.print("请输入要删除学生的学号：");
            int x=sca.nextInt();
            for(int i=0;i<flog;i++)
                if(stu[i].getNum()!=x){
                    System.out.print("查无此人！");
                }
                else{
                    int index=x;
                    if(index==stu[i].getNum()){
                        System.out.print("请确认是否要删除该学生的信息?(y/n)");
                        String y=sca.next();
                        if(y.equals("y")||y.equals("Y")){
                            for(int a=index+1;a<flog;a++){
                                stu[a-1].setName(stu[a].getName());
                                stu[a-1].setNum(stu[a].getNum());
                                stu[a-1].setSex(stu[a].getSex());
                                stu[a-1].setAge(stu[a].getAge());
                            }
                            flog--;
                            System.out.println("删除成功！");
                        }
                    }
                }
        }
        void Sage(){
            int i,j;
            for(i=0;i<flog;i++)
                for(j=0;j<flog-1;j++){
                    if(stu[j].getAge()>stu[j+1].getAge()){
                        Student a=stu[j];
                        stu[j]=stu[j+1];
                        stu[j+1]=a;}
                }
            for(j=0;j<flog;j++){
                System.out.println("姓名："+stu[j].getName());
                System.out.println("年龄："+stu[j].getAge());
                System.out.println("性别："+stu[j].getSex());
                System.out.println("学号："+stu[j].getNum());
                System.out.println(" ");
            }
        }
        void Sname(){
            int i,j;
            for(i=0;i<flog;i++){
                for(j=0;j<flog-1;j++){
                    if(stu[j].getName().compareTo(stu[j+1].getName())>0){
                        Student swap;
                        swap=stu[j];
                        stu[j]=stu[j+1];
                        stu[j+1]=swap;}
                }
            }
            for(j=0;j<flog;j++){
                System.out.println("姓名："+stu[j].getName());
                System.out.println("年龄："+stu[j].getAge());
                System.out.println("性别："+stu[j].getSex());
                System.out.println("学号："+stu[j].getNum());
                System.out.println(" ");
            }
        }
        void Snum(){
            int i,j;
            for(i=0;i<flog;i++){
                for(j=0;j<flog-1;j++){
                    if(stu[j].getAge()>stu[j+1].getAge()){
                        Student a=stu[j];
                        stu[j]=stu[j+1];
                        stu[j+1]=a;}
                }
            }
            for(j=0;j<flog;j++){
                System.out.println("姓名："+stu[j].getName());
                System.out.println("年龄："+stu[j].getAge());
                System.out.println("性别："+stu[j].getSex());
                System.out.println("学号："+stu[j].getNum());
                System.out.println(" ");
            }
        }
    }
    static class Put{
        void outmain(){
            System.out.println("学生信息管理系统");
            System.out.println("==============");
            System.out.println("1.创建学生信息表");
            System.out.println("2.显示学生信息");
            System.out.println("3.排序学生信息");
            System.out.println("4.查找学生信息");
            System.out.println("5.修改学生信息");
            System.out.println("6.添加学生信息");
            System.out.println("7.删除学生信息");
            System.out.println("0.退出");
            System.out.println("==============");
            System.out.print("请输入你的选择：");
        }
        void outsort(){
            System.out.println("1.按照年龄排序");
            System.out.println("2.按照姓名排序");
            System.out.println("3.按照学号排序");
            System.out.print("请输入你的选择：");
        }
        void outfind(){
            System.out.println("1.按照年龄查找");
            System.out.println("2.按照姓名查找");
            System.out.println("3.按照学号查找");
            System.out.print("请输入你的选择：");
        }
        void outupdate(){
            System.out.println("请选择要修改的学生信息：");
            System.out.println("1.修改年龄");
            System.out.println("2.修改姓名");
            System.out.println("3.修改学号");
            System.out.println("4.修改性别");
            System.out.print("请输入你的选择：");
        }
    }

}
