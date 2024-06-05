package com.example.quarts.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

@Component
public class JobsListener implements JobListener {

    @Override
    public String getName() {
        return "myLocalJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("로컬 Job 실행되기 이전에 수행됩니다.");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("로컬 Job 실행이 실패하였을때 수행됩니다.");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("로컬 Job 실행 이후에 수행됩니다.");
    }
}
