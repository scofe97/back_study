package com.example.quarts.test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.NumberFormat;

public class CustomNumberSerializer extends JsonSerializer<Integer> {
    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(0);
        formatter.setMaximumFractionDigits(0);
        String formattedNumber = formatter.format(value);
        gen.writeString(formattedNumber);
    }
}
