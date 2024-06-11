package com.example.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanPostProcessorTest {

//    @Test
//    void beanPostProcessorTest(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);
//
//        // B는 Bean으로 등록된다.
//        B beanB = applicationContext.getBean("beanA", B.class);
//
//        // A는 Bean으로 등록되지 않는다. (바꿔치기됨)
//        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
//                () -> applicationContext.getBean(A.class));
//    }

    @Test
    void beanPostProcessorTest2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);

        // A는 프록시로 등록된다.
        A proxyA = applicationContext.getBean(A.class);
        proxyA.helloA();

        // B는 프록시로 등록되지 않는다.
        B beanB = applicationContext.getBean(B.class);
        beanB.helloB();
    }

    @Slf4j
    @Configuration
    static class BasicConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }

        @Bean(name = "beanB")
        public B b() {
            return new B();
        }

//        @Bean
//        public AToBPostProcessor helloPostProcessor() {
//            return new AToBPostProcessor();
//        }

        @Bean
        public PackageLogTraceProxyPostProcessor packageLogTraceProxyPostProcessor() {
            return new PackageLogTraceProxyPostProcessor("com.example.study.aop", getAdvisor());
        }

        private Advisor getAdvisor() {
            AspectJExpressionPointcut aspectJPointcut = new AspectJExpressionPointcut();
            aspectJPointcut.setExpression("within(com.example.study.aop.BeanPostProcessorTest.A)");

            return new DefaultPointcutAdvisor(aspectJPointcut, new TimeAdvice());
        }
    }

    @Slf4j
    public static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    public static class B {
        public void helloB() {
            log.info("hello B");
        }
    }

//    @Slf4j
//    static class AToBPostProcessor implements BeanPostProcessor {
//        @Override
//        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//            log.info("beanName={} bean={}", beanName, bean);
//            if (bean instanceof A) {
//                return new B();
//            }
//            return bean;
//        }
//    }

    @Slf4j
    static class PackageLogTraceProxyPostProcessor implements BeanPostProcessor {
        private final String basePackage;
        private final Advisor advisor;

        public PackageLogTraceProxyPostProcessor(String basePackage, Advisor advisor) {
            this.basePackage = basePackage;
            this.advisor = advisor;
        }
        @Override
        public Object postProcessAfterInitialization(Object bean,
                                                     String beanName
        ) throws BeansException {
            log.info("param beanName={} bean={}", beanName, bean.getClass());

            // 프록시 적용 대상 여부 체크
            // 프록시 적용 대상이 아니면 원본을 그대로 반환
            String packageName = bean.getClass().getPackageName();
            if (!packageName.startsWith(basePackage)) {
                return bean;
            }

            // 프록시 대상이면 프록시를 만들어서 반환
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            proxyFactory.addAdvisor(advisor);
            Object proxy = proxyFactory.getProxy();
            log.info("create proxy: target={} proxy={}", bean.getClass(), proxy.getClass());
            return proxy;
        }
    }
}
