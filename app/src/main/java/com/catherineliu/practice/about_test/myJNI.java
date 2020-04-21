package com.catherineliu.practice.about_test;

public class myJNI {

    static {
        System.loadLibrary("JniTest");
    }

    public static native String sayHello();

}
