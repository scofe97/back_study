package com.example.study.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CliConfig implements ApplicationRunner {
    private List<String> usernames;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        usernames = args.getOptionValues("username");
        if (usernames != null) {
            System.out.println("Usernames: " + usernames);
        } else {
            System.out.println("No usernames provided.");
        }
    }

    public List<String> getUsernames() {
        return usernames;
    }
}