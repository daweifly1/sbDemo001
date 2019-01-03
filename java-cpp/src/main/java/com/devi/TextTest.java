package com.devi;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class TextTest {

    public static void main(String[] args) {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
        NativeLibrary.NativeClass l = new NativeLibrary.NativeClass();
        l.set_property("Hello World!");
        System.out.println(l.property());
    }
}
