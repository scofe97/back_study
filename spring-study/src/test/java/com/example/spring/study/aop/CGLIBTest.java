package com.example.spring.study.aop;

import com.example.study.aop.cglib.MyProxyInterceptor;
import com.example.study.aop.cglib.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CGLIBTest {

    @Test
    void cglibTest() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Subject.class);
        enhancer.setCallback(new MyProxyInterceptor((new Subject())));

        Subject proxy = (Subject) enhancer.create();

        proxy.call();
    }

    @Test
    void cglibTest2() {
        Subject proxy = (Subject) Enhancer.create(Subject.class, (MethodInterceptor) (o, method, args, methodProxy) -> {
            Subject target = new Subject();

            System.out.println("TimeProxy 실행");
            long startTime = System.nanoTime();

            Object result = method.invoke(target, args); // 파라미터로 전달받은 메서드를 invoke로 실행

            long endTime = System.nanoTime();
            long resultTime = endTime - startTime;
            System.out.println("TimeProxy 종료 resultTime = " + resultTime);

            return result;
        });

        proxy.call();
    }
}
