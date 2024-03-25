package org.example.chapter6.annotation;

public class Sample {
    @Test public static void m1(){}

    public static void m2(){}

    @Test public static void m3(){
        throw new RuntimeException("fail");
    }
}
