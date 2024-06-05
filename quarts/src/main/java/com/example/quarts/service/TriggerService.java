package com.example.quarts.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TriggerService {
    public Trigger everySeconds(JobKey jobKey, TriggerKey triggerKey) {
        return TriggerBuilder.newTrigger()
                .forJob(jobKey)
                .withIdentity(triggerKey.getName(), triggerKey.getGroup())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();
    }

    public Trigger everySeconds2(JobKey jobKey, TriggerKey triggerKey) {
        return TriggerBuilder.newTrigger()
                .forJob(jobKey)
                .usingJobData("myKey", "myValue")
                .withIdentity(triggerKey.getName(), triggerKey.getGroup())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
    }

    public Trigger testTrigger1(){
        return TriggerBuilder.newTrigger()
                .withIdentity("complexTrigger", "group")
                .forJob("complexTrigger", "group")
                .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.MINUTE))
                // 매 30초마다 실행하는 크론 스케줄
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                // 시작 후 1시간 동안만 유효
                .endAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.HOUR))
                // JobDataMap에 데이터 추가
                .usingJobData("myKey", "myValue")
                // 우선순위 설정
                .withPriority(5)
                .build();
    }
}
