package com.example.study.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JavaConfig {
    @Value("${custom.test1}")
    private String test1;

    @Value("${custom.test2}")
    private String test2;
}
