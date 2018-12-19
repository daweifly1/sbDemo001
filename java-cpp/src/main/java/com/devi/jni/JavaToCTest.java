package com.devi.jni;

public class JavaToCTest {
    private native String sayHello(String str);//声明本地方法.

    static {
        System.loadLibrary("JavaToCTest");//需要加载的so库文件的名称,在linux中会在上前缀"lib"+库文件的名称.
    }

    public static void main(String[] args) {
        new JavaToCTest().sayHello("hhhh");
    }
}
