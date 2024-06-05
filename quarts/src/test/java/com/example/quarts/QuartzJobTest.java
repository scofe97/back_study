package com.example.quarts;

import com.example.quarts.job.MyJob;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuartzJobTest {

    @Autowired
    private Scheduler scheduler;

    @Test
    void example3() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("email", "user@example.com") // 이메일 주소 설정
                .usingJobData("filePath", "/path/to/file") // 파일 경로 설정
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(60)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Test
    void example4() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)                    // Job의 구현 클래스 설정
                .withIdentity("myJob", "group1")        // Job의 identity 설정
                .withDescription("This is my job")      // Job의 설명 설정
                .ofType(MyJob.class)                    // Job의 구현 클래스 설정
                .requestRecovery(true)                  // Job이 실패한 경우 다시 실행하도록 설정
                .storeDurably(true)                     // Job이 지속적으로 저장되도록 설정
                .usingJobData("key", "value")           // Job의 data map 설정
                .build();                               // 설정된 정보를 바탕으로 JobDetail 인스턴스 생성


        // 스케줄러에 Job 등록
        scheduler.addJob(jobDetail, true);
        System.out.println("Job 등록 완료.");

        // Job의 Key 조회
        JobKey jobKey = jobDetail.getKey();
        System.out.println("Job Key: " + jobKey);

        // Job의 설명 조회
        String description = jobDetail.getDescription();
        System.out.println("Job Description: " + description);

        // Job의 구현 클래스 조회
        Class<? extends Job> jobClass = jobDetail.getJobClass();
        System.out.println("Job Class: " + jobClass.getName());

        // Job의 data map 조회
        JobDataMap dataMap = jobDetail.getJobDataMap();
        System.out.println("Job Data Map: " + dataMap.getString("key"));

        // Job의 지속성 조회
        boolean isDurable = jobDetail.isDurable();
        System.out.println("Is Durable: " + isDurable);

        // Job 실행 후 data map 지속 저장 여부 조회
        boolean isPersistJobDataAfterExecution = jobDetail.isPersistJobDataAfterExecution();
        System.out.println("Is Persist Job Data After Execution: " + isPersistJobDataAfterExecution);

        // 동시 실행 금지 여부 조회
        boolean isConcurrentExecutionDisallowed = jobDetail.isConcurrentExectionDisallowed();
        System.out.println("Is Concurrent Execution Disallowed: " + isConcurrentExecutionDisallowed);

        // 실패 시 재실행 요청 여부 조회
        boolean requestsRecovery = jobDetail.requestsRecovery();
        System.out.println("Requests Recovery: " + requestsRecovery);

        scheduler.shutdown(true);
    }

}
