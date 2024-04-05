package com.example.quarts.quarts.service;

import com.example.quarts.quarts.listener.JobsGlobalListener;
import com.example.quarts.quarts.listener.JobsListener;
import com.example.quarts.quarts.listener.TriggersGlobalListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final Scheduler scheduler;
    private final TriggerService triggerService;
    private final JobDetailService jobDetailService;

    private final JobsGlobalListener jobsGlobalListener;
    private final TriggersGlobalListener triggersGlobalListener;
    private final JobsListener jobsListener;

    @PostConstruct
    public void init() throws SchedulerException {
        startSchedule();

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        executor.schedule(this::resetNormalSchedule, 5, TimeUnit.SECONDS);
    }

    public void startSchedule() {
        // 일반 잡
        applyNormalSchedule(JobKey.jobKey("normal Key111",  "normal Group" ));
        applyNormalSchedule(JobKey.jobKey("normal Key222",  "normal Group"));
        // applyNormalSchedule(JobKey.jobKey("normal Key3", "normal Group"));


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

    private void applyNormalSchedule(JobKey jobKey){
        System.out.println("jobKey = " + jobKey.getName());
        JobDetail jobDetail = jobDetailService.serviceBuild(jobKey);
        Trigger trigger = triggerService.everySeconds(jobKey);

        schedule(jobDetail, trigger);
    }

    private void applyErrorSchedule(){
        JobKey jobKey = JobKey.jobKey("error Key", "error Group");
        JobDetail jobDetail = jobDetailService.errorBuild(jobKey);
        Trigger trigger = triggerService.everySeconds(jobKey);
        schedule(jobDetail, trigger);
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

    private void schedule(JobDetail jobDetail, Trigger lastTrigger) {
        try {
            scheduler.scheduleJob(jobDetail, lastTrigger);
        } catch (SchedulerException e) {
            JobExecutionException jobExecutionException = new JobExecutionException(e);
            jobExecutionException.setRefireImmediately(true);
        }
    }
}
