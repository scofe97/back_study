package com.example.quarts.quarts.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class ExampleJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Quarts Job1 실행");
    }
}
