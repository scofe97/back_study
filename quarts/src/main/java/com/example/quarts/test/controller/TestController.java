package com.example.quarts.test.controller;

import com.example.quarts.test.CustomNumberSerializer;
import com.example.quarts.test.IpPort;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam("ipPort") IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort PORT = " + ipPort.getPort());
        return "ok";
    }

    @GetMapping("/formatter/edit")
    public ResponseEntity<Form> formatterForm() {
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        System.out.println("form.getNumber() = " + form.getNumber());
        System.out.println("form.getLocalDateTime() = " + form.getLocalDateTime());
        return ResponseEntity.ok().body(form);
    }

    @Data
    static class Form {
        @JsonSerialize(using = CustomNumberSerializer.class)
        private Integer number;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }
}
