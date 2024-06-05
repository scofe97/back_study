package com.example.quarts.job;

import org.quartz.*;

import java.util.ArrayList;

public class DummyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.out.println("DummyJob Instance " + key + " says: " + jobSays + ", and val is " + myFloatValue);
    }
}