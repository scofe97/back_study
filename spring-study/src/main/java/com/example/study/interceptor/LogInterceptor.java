package com.example.study.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler
    ) throws Exception {
        // 요청 처리 전 실행
        String uuid = UUID.randomUUID().toString();

        // Request 속성 지정
        request.setAttribute("change", "Filter");
        request.setAttribute("uuid", uuid);

        // Response Header 조작
        response.setHeader("Change Interceptor Header", "Interceptor");
        response.setDateHeader("Change Interceptor DateHeader", 100L);

        log.info("Pre Handle method is Calling: REQUEST [{}][{}]", uuid, request.getRequestURI());
        return true; // true 반환하여 요청 처리 계속
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView
    ) throws Exception {
        // 요청 처리 후 실행 (응답 생성 전)
        String uuid = (String) request.getAttribute("uuid");
        log.info("Post Handle method is Calling: HANDLED [{}][{}]", uuid, request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex
    )throws Exception {

        // 요청 처리 완료 후 실행 (응답 생성 후)
        String uuid = (String) request.getAttribute("uuid");
        log.info("Request and Response is completed: RESPONSE [{}][{}]", uuid, request.getRequestURI());
    }
}