package com.example.quarts.test;


import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public String print(Number object, Locale locale) {
        return NumberFormat.getInstance(locale).format(object);
    }

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        return NumberFormat.getInstance(locale).parse(text);
    }
}
