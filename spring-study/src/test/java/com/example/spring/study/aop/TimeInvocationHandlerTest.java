package com.example.spring.study.aop;

import com.example.study.aop.AImpl;
import com.example.study.aop.AInterface;
import com.example.study.aop.BImpl;
import com.example.study.aop.BInterface;
import com.example.study.aop.TimeInvocationHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;
class TimeInvocationHandlerTest {

    @Test
    void dynamicA(){
        com.example.study.aop.AInterface target = new AImpl();
        com.example.study.aop.TimeInvocationHandler handler = new com.example.study.aop.TimeInvocationHandler(target);

        // 인터페이스 정보로 프록시 생성
        com.example.study.aop.AInterface proxy = (com.example.study.aop.AInterface) Proxy.newProxyInstance(com.example.study.aop.AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                handler);

        // call()은 인터페이스의 함수
        proxy.call();
    }


    @Test
    void dynamicB(){
        com.example.study.aop.BInterface target = new BImpl();
        com.example.study.aop.TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 인터페이스 정보로 프록시 생성
        com.example.study.aop.BInterface proxy = (com.example.study.aop.BInterface) Proxy.newProxyInstance(com.example.study.aop.BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                handler);

        // call()은 인터페이스의 함수
        proxy.call();
    }

}