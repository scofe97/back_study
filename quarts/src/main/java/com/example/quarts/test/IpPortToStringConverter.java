package com.example.quarts.test;

import org.springframework.core.convert.converter.Converter;

public class IpPortToStringConverter implements Converter<IpPort, String> {
    @Override
    public String convert(IpPort source) {
        return source.getIp() + ":" + source.getPort();
    }
}