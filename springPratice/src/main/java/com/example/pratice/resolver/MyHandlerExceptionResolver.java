package com.example.pratice.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex)
    {

        // 예외 발생시 200으로 상태코드 변경
        if (ex instanceof RuntimeException) {
            log.info("RuntimeException을 200코드로 변경");
            response.setStatus(HttpServletResponse.SC_OK);
            return new ModelAndView();
        }
        return null;
    }
}