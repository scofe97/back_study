package com.example.quarts.test;

import org.springframework.core.convert.converter.Converter;

public class IntegerToStringConverter implements Converter<Integer, String> {
    @Override
    public String convert(Integer source) {
        return String.valueOf(source);
    }
}
