package com.example.quarts.test.controller;

import com.example.quarts.test.IpPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;

@Controller
public class MyController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(IpPort.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(new IpPort(text)); // IpPort는 String을 인자로 받는 생성자 필요
            }
        });
    }

    @RequestMapping("/custom")
    public String handleCustomObject(IpPort ipPort) {
        return "viewPage";
    }
}