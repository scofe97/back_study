package com.example.study.constants;

public enum DispatcherType {
    REQUEST, // 클라이언트 요청
    ERROR  , // 오류 요청
    FORWARD, // 서블릿에서 다른 서블릿 요청
    INCLUDE, // 서블릿에서 다른 서블릿이나 JSP결과 포함
    ASYNC    // 비동기 서블릿 호출
}