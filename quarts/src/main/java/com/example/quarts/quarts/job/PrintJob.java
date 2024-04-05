package com.example.quarts.quarts.job;

import org.quartz.*;

public class PrintJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        System.out.println("PrintJob Key " + key);
    }
}
