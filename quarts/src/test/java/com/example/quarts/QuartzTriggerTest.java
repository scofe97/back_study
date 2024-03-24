package com.example.quarts;

import com.example.quarts.quarts.job.MyJob;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuartzTriggerTest {
    @Test
    void triggerTest1(){
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("email", "user@example.com") // 이메일 주소 설정
                .usingJobData("filePath", "/path/to/file") // 파일 경로 설정
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("complexTrigger", "group1") // 트리거 식별자 설정
                .forJob(jobDetail) // 실행할 JobDetail 지정
                .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.MINUTE)) // 현재로부터 10분 후 시작
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?")) // 매 30초마다 실행하는 크론 스케줄
                .endAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.HOUR)) // 시작 후 1시간 동안만 유효
                .usingJobData("myKey", "myValue") // JobDataMap에 데이터 추가
                .withPriority(5) // 우선순위 설정
                .modifiedByCalendar("myCalendar") // 사용할 달력 이름 설정 (예: 공휴일 제외)
                .build();

        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(60) // 60초 마다 반복
                        .repeatForever()) // 무한 반복
                .build();

        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?")) // 매일 8시부터 17시까지 2분 간격으로 반복
                .build();
    }

    @Test
    void triggerTest2(){
        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("weeklyTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 30 10 ? * MON")) // 매주 월요일 오전 10:30에 실행
                .build();
    }

}
