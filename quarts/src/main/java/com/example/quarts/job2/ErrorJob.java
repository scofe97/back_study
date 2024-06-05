package com.example.quarts.job2;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

@Slf4j
public class ErrorJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        System.out.println("ErrorJob key = " + key);
        throw new RuntimeException();
    }
}
