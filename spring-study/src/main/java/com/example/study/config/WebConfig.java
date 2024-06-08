package com.example.study.config;

import com.example.study.filter.LogFilter;
import com.example.study.interceptor.LogInterceptor;
import com.example.study.resolver.MyHandlerExceptionResolver;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<Filter> logFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        // 필터 인스턴스 설정
        filterRegistrationBean.setFilter(new LogFilter());

        // 필터 실행 순서 설정 (1이면 가장 먼저 실행됨)
        filterRegistrationBean.setOrder(1);

        // 필터가 적용될 URL 패턴 설정 (모든 요청에 대해 필터 적용)
        filterRegistrationBean.addUrlPatterns("/*");

        filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR, DispatcherType.REQUEST);

        // 필터의 이름 설정
        filterRegistrationBean.setName("LoggingFilter");

        // 필터 활성화 설정 (true로 설정하면 필터 활성화)
        filterRegistrationBean.setEnabled(true);

        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터 생성 및 등록
        HandlerInterceptor loggingInterceptor = new LogInterceptor();

        registry.addInterceptor(loggingInterceptor)
                // 모든 요청에 인터셉터 적용
                .addPathPatterns("/**")
                // 로그인과 로그아웃 경로는 제외
                .excludePathPatterns("/login/**", "/logout/**")
                // 인터셉터의 실행 순서 설정
                .order(1);
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new MyHandlerExceptionResolver());
    }
}
