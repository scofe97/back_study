package com.example.quarts.quarts.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {

    public String getName() {
        return "myJobListener";
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("Job 실행되기 이전에 수행됩니다.");
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("Job 실행이 실패하였을때 수행됩니다.");
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("Job 실행 이후에 수행됩니다.");
    }
}
