package com.example.quarts.quarts.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class ExampleJob2 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Quarts Job2 실행");
    }
}
