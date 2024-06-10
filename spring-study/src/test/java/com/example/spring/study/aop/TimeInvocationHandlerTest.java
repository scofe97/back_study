package com.example.spring.study.aop;

import com.example.study.aop.jdkDynamic.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class TimeInvocationHandlerTest {

    @Test
    void dynamicA(){
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 인터페이스 정보로 프록시 생성
        AInterface proxy = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                handler);

        // call()은 인터페이스의 함수
        proxy.call();
    }


    @Test
    void dynamicB(){
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 인터페이스 정보로 프록시 생성
        BInterface proxy = (BInterface) Proxy.newProxyInstance(
                BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                handler);

        // call()은 인터페이스의 함수
        proxy.call();
    }

    @Test
    void dynamicC() {
        CInterface target = new CImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        CInterface proxy = (CInterface) Proxy.newProxyInstance(
                CInterface.class.getClassLoader(),
                new Class[]{CInterface.class},
                handler
        );

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }

    @Test
    void dynamicC2() {
        CInterface target = new CImpl();
        TimeInvocationMethodFilterHandler handler = new TimeInvocationMethodFilterHandler(target);

        CInterface proxy = (CInterface) Proxy.newProxyInstance(
                CInterface.class.getClassLoader(),
                new Class[]{CInterface.class},
                handler
        );

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }
}