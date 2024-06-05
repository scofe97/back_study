package com.example.quarts;

import com.example.quarts.job.ExampleJob2;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuartzBasicTest {

    @Autowired
    private Scheduler scheduler;

    @Test
    void example1() throws SchedulerException, InterruptedException {
        // ExampleJob의 JobKey를 사용하여 스케줄러에서 해당 작업이 있는지 확인
        var jobKey = JobKey.jobKey("exampleJob");
        var isJobScheduled = scheduler.checkExists(jobKey);

        assertThat(isJobScheduled).isTrue();
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    void example2() throws SchedulerException, InterruptedException {

        JobDetail job = JobBuilder.newJob(ExampleJob2.class)
                .withIdentity("myJob2", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(job, trigger);

        TimeUnit.SECONDS.sleep(10);
    }
}