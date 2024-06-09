package com.example.spring.study.config;

import com.example.study.SpringStudyApplication;
import com.example.study.config.AccountsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.List;


@SpringBootTest(classes = SpringStudyApplication.class)
public class ConfigTest {

    @Value("${build.version}")
    private String buildVersion;

    @Value("${accounts.message}")
    private String accountsMessage;

    @Autowired
    private Environment env;

    @Autowired
    private AccountsProperties accountsProperties;

    @Test
    void envTest(){
        String buildVersion = env.getProperty("build.version");
        System.out.println("buildVersion = " + buildVersion);
    }

    @Test
    void envTest2(){
        String accounts = env.getProperty("accounts");
        List<String> accountsOnCallSupport = env.getProperty("accounts.onCallSupport", List.class);
        String accountsMessage = env.getProperty("accounts.message");
        System.out.println("accounts = " + accounts); // null
        System.out.println("accountsOnCallSupport = " + accountsOnCallSupport); // null
        System.out.println("accountsMessage = " + accountsMessage); // null
    }

    @Test
    void valueTest(){
        System.out.println("buildVersion = " + buildVersion);
    }

    @Test
    void valueTest2(){
        //System.out.println("accounts = " + accounts);
        System.out.println("accountsMessage = " + accountsMessage);
    }

    @Test
    void ConfigurationPropertiesTest(){
        System.out.println("Message: " + accountsProperties.getMessage());
        System.out.println("Contact Name: " + accountsProperties.getContactDetails().getName());
        System.out.println("Contact Email: " + accountsProperties.getContactDetails().getEmail());
        System.out.println("On Call Support: " + accountsProperties.getOnCallSupport());
    }
}
