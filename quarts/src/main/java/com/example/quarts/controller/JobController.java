package com.example.quarts.controller;

import com.example.quarts.job.DummyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private Scheduler scheduler;

    @PostMapping("/add")
    public String addJob(@RequestParam("jobName") String jobName,
                         @RequestParam("groupName") String groupName,
                         @RequestParam("jobSays") String jobSays,
                         @RequestParam("myFloatValue") float myFloatValue) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(DummyJob.class)
                .withIdentity(jobName, groupName)
                .usingJobData("jobSays", jobSays)  // 문자열 데이터 추가
                .usingJobData("myFloatValue", myFloatValue)  // 실수 데이터 추가
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobName + "Trigger", groupName)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        return "Job and Trigger added successfully with data!";
    }
}