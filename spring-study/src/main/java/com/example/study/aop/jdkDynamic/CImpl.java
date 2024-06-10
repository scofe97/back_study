package com.example.study.aop.jdkDynamic;

public class CImpl implements CInterface {
    @Override
    public String call() {
        System.out.println("C 호출");
        return "C 호출";
    }

    @Override
    public void print() {
        System.out.println("CImpl print");
    }

    @Override
    public Integer sum(int a, int b) {
        System.out.println(a+b);
        return a+b;
    }
}
