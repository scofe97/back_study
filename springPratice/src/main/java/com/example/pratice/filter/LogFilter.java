package com.example.pratice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그: log filter init");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain
    ) throws IOException, ServletException {

        log.info("----------------------------------");
        log.info("로그: log filter doFilter");
        String uuid = UUID.randomUUID().toString();

        // Request 속성 지정
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        httpRequest.setAttribute("change", "Filter");

        // Response Header 조작
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Change Filter Header", " Filter");
        httpResponse.setDateHeader("Change Filter DateHeader", 100l);

        log.info("로그: REQUEST [{}][{}]", uuid, requestURI);
        chain.doFilter(request, response);
        log.info("로그: RESPONSE [{}][{}]", uuid, requestURI);
    }

    @Override
    public void destroy() {
        log.info("로그: log filter destroy");
    }
}