package com.example.spring.study.config;

import com.example.study.SpringStudyApplication;
import com.example.study.config.CliConfig;
import com.example.study.config.JavaConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = SpringStudyApplication.class, args = {"--username=userA", "--username=userB"})
public class ExternalEnvTest {

    @Autowired
    private JavaConfig javaConfig;

    @Autowired
    private CliConfig cliConfig;

    @Test
    void OsEnv(){
        // 전체 OS환경변수 조회
        Map<String, String> envMap = System.getenv();

        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, System.getenv(key));
        }
    }

    @Test
    void JavaEnv(){
        // 자바 시스템 변수
        System.out.println("javaConfig.getCustomProperty1() = " + javaConfig.getTest1());
        System.out.println("javaConfig.getCustomProperty2() = " + javaConfig.getTest2());
    }

    @Test
    void CliEnv(){
        // 자바 커맨드 라인 변수
        List<String> usernames = cliConfig.getUsernames();
        System.out.println("javaConfig.get(0) = " + usernames.get(0));
        System.out.println("javaConfig.get(1) = " + usernames.get(1));
    }
}
