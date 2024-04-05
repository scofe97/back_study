package com.example.quarts.quarts.job;

import org.quartz.*;

import java.util.ArrayList;

public class DummyJob implements Job {

    private String jobSays;
    private float myFloatValue;
    private ArrayList state;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        System.out.println("DummyJob Instance " + key + " of DummyJob says: " + jobSays + ",and val is " + myFloatValue);
    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    public void setState(ArrayList state) {
        this.state = state;
    }
}