package com.example.quarts.quarts.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String email = dataMap.getString("email");
        String filePath = dataMap.getString("filePath");

        System.out.println("email = " + email);
        System.out.println("filePath = " + filePath);
    }
}
