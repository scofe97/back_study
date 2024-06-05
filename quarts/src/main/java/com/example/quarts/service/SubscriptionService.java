package com.example.quarts.service;

import com.example.quarts.listener.JobsListener;
import com.example.quarts.listener.TriggersGlobalListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final Scheduler scheduler;
    private final SchedulerFactoryBean schedulerFactoryBean;
    private final TriggerService triggerService;
    private final JobDetailService jobDetailService;

    private final TriggersGlobalListener triggersGlobalListener;
    private final JobsListener jobsListener;

//    @PostConstruct
//    public void init() throws SchedulerException {
//
//        System.out.println("scheduler = " + scheduler);
//        System.out.println("schedulerFactoryBean = " + schedulerFactoryBean);
//
//        startSchedule();
//
////        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
////        executor.schedule(this::resetNormalSchedule, 5, TimeUnit.SECONDS);
//    }

    public void startSchedule() {
        // 일반 잡
        applyNormalSchedule(
                JobKey.jobKey("normal Key1", "normal Group"),
                TriggerKey.triggerKey("trigger key1", "group"));
        // applyNormalSchedule(JobKey.jobKey("normal Key2",  "normal Group"));

        // 상태 잡
        // applyStatefulSchedule();

        // 에러 잡
        //applyErrorSchedule();


        // 특정 JobDetail에 대한 JobListener 등록
        KeyMatcher<JobKey> exampleJob1Matcher = KeyMatcher.keyEquals(JobKey.jobKey("normal Key111", "normal Group"));
        KeyMatcher<TriggerKey> exampleJob1TriggerMatcher = KeyMatcher.keyEquals(TriggerKey.triggerKey("normal Key1"));

        try {
            scheduler.getListenerManager().addJobListener(jobsListener, exampleJob1Matcher);
            scheduler.getListenerManager().addTriggerListener(triggersGlobalListener, exampleJob1TriggerMatcher);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    private void applyNormalSchedule(JobKey jobKey, TriggerKey triggerKey){
        JobDetail jobDetail = jobDetailService.serviceBuild(jobKey);

        Trigger trigger = triggerService.everySeconds2(jobKey, triggerKey);
        schedule(jobDetail, trigger, jobKey);
        schedule(jobDetail, trigger, jobKey);
    }

    private void applyStatefulSchedule() {
        JobKey jobKey = JobKey.jobKey("stateful key1", "stateful group");
        JobDetail jobDetail = jobDetailService.statefulBuild(jobKey);

        TriggerKey triggerKey = TriggerKey.triggerKey("stateful key1", "stateful group");
        Trigger trigger = triggerService.everySeconds(jobKey, triggerKey);

        TriggerKey triggerKey2 = TriggerKey.triggerKey("stateful key2", "stateful group");
        Trigger trigger2 = triggerService.everySeconds(jobKey, triggerKey2);

        TriggerKey triggerKey3 = TriggerKey.triggerKey("stateful key3", "stateful group");
        Trigger trigger3 = triggerService.everySeconds2(jobKey, triggerKey3);

        schedule(jobDetail, trigger, jobKey);
        schedule(jobDetail, trigger2, jobKey);
        schedule(jobDetail, trigger3, jobKey);
    }


    private void applyErrorSchedule(TriggerKey triggerKey){
        JobKey jobKey = JobKey.jobKey("error Key", "error Group");
        JobDetail jobDetail = jobDetailService.errorBuild(jobKey);

        Trigger trigger = triggerService.everySeconds(jobKey, triggerKey);
        schedule(jobDetail, trigger, jobKey);
    }

    private void resetNormalSchedule(){
        startSchedule();
        deleteNormalSchedule();
    }

    private void deleteNormalSchedule(){
        try {
            scheduler.deleteJob(JobKey.jobKey("normal Key111", "normal Group"));
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    private void schedule(JobDetail jobDetail, Trigger lastTrigger,JobKey jobKey) {
        System.out.println("start");

        try {
            if(Objects.isNull(scheduler.getJobDetail(jobKey)))
                scheduler.scheduleJob(jobDetail, lastTrigger);
            else
                scheduler.scheduleJob(lastTrigger);
        } catch (SchedulerException e) {
            JobExecutionException jobExecutionException = new JobExecutionException(e);
            jobExecutionException.setRefireImmediately(true);
            System.out.println("jobExecutionException = " + jobExecutionException);
        }
    }
}
