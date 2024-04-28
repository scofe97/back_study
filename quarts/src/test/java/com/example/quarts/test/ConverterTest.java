package com.example.quarts.test;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {
    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }
    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        assertThat(conversionService.canConvert(String.class, IpPort.class)).isTrue();
        assertThat(conversionService.canConvert(IpPort.class, String.class)).isTrue();

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        String ipPortString = conversionService.convert(ipPort, String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number result = formatter.parse("1,000", Locale.KOREA);
        assertThat(result).isEqualTo(1000L); // Long 타입 주의
    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }

    @Test
    void conversionServiceWithFormatter() {
        // 1. FormattingConversionService 생성
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // 2. 포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // 3. 포맷터 사용
        Number number = conversionService.convert("1,000", Number.class);
        assertThat(number).isEqualTo(1000);
        String formattedNumber = conversionService.convert(1000, String.class);
        assertThat(formattedNumber).isEqualTo("1,000");
    }
}