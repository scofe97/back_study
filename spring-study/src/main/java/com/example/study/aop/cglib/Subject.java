package com.example.study.aop.cglib;

public class Subject {
    public void call() {
        System.out.println("서비스 호출");
    }

    public void run() {
        System.out.println("서비스 실행");
    }
}
