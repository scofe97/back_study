package com.example.study.aop.cglib;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


@Slf4j
@RequiredArgsConstructor
public class MyProxyInterceptor implements MethodInterceptor {

    private final Object target;

    @Override
    public Object intercept(Object obj,         // CGLIB가 적용된 객체
                            Method method,      // 호출된 메서드
                            Object[] args,      // 메서드를 호출하면서 전달된 인수
                            MethodProxy proxy   // 메서드 호출에 사용
    ) throws Throwable {

        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = method.invoke(target, args); // 파라미터로 전달받은 메서드를 invoke로 실행

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}", resultTime);

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        return result;
    }
}
