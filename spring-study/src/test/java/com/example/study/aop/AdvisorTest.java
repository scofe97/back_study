package com.example.study.aop;

import com.example.study.aop.jdkDynamic.CImpl;
import com.example.study.aop.jdkDynamic.CInterface;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

public class AdvisorTest {

    @Test
    void advisorTest1(){
        CInterface target = new CImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor =
                new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());

        proxyFactory.addAdvisor(advisor);
        CInterface proxy = (CInterface) proxyFactory.getProxy();

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }

    @Test
    void advisorTest2() {
        CInterface target = new CImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor =
                new DefaultPointcutAdvisor(new MyPointcut(), new TimeAdvice());

        proxyFactory.addAdvisor(advisor);
        CInterface proxy = (CInterface) proxyFactory.getProxy();

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }

    @Test
    void advisorTest3() {
        CInterface target = new CImpl();

        NameMatchMethodPointcut namePointcut = new NameMatchMethodPointcut();
        namePointcut.setMappedNames("call");

        JdkRegexpMethodPointcut regexPointcut = new JdkRegexpMethodPointcut();
        regexPointcut.setPattern(".*sum.*");

        AspectJExpressionPointcut aspectJPointcut = new AspectJExpressionPointcut();
        aspectJPointcut.setExpression("execution(* com.example.study..*(..))");

        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor =
                new DefaultPointcutAdvisor(aspectJPointcut, new TimeAdvice());

        proxyFactory.addAdvisor(advisor);
        CInterface proxy = (CInterface) proxyFactory.getProxy();

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }

    @Test
    void advisorTest4() {
        // proxy -> advisor2 -> advisor1 -> target
        CInterface target = new CImpl();

        NameMatchMethodPointcut namePointcut = new NameMatchMethodPointcut();
        namePointcut.setMappedNames("call");

        JdkRegexpMethodPointcut regexPointcut = new JdkRegexpMethodPointcut();
        regexPointcut.setPattern(".*sum.*");

        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor1 =
                new DefaultPointcutAdvisor(namePointcut, new TimeAdvice());
        DefaultPointcutAdvisor advisor2 =
                new DefaultPointcutAdvisor(regexPointcut, new TimeAdvice());

        proxyFactory.addAdvisor(advisor1);
        proxyFactory.addAdvisor(advisor2);
        CInterface proxy = (CInterface) proxyFactory.getProxy();

        proxy.call();
        proxy.sum(1, 2);
        proxy.print();
    }

    static class MyPointcut implements Pointcut {
        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new MyMethodMatcher();
        }
    }

    static class MyMethodMatcher implements MethodMatcher{
        private String matchName = "call";

        // 적용여부
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            boolean result = method.getName().equals(matchName);
            return result;
        }

        // 런타임 시점에 수행되는지 여부
        @Override
        public boolean isRuntime() {
            return false;
        }

        // 매개변수를 포함하여 런타임시점 매칭여부
        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            throw  new UnsupportedOperationException(); // 지원하지 않음
        }
    }
}
