package com.example.quarts.quarts.job2;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class NormalQuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        for (String string : context.getMergedJobDataMap().keySet()) {
            System.out.println("string = " + string);
        }
    }
}
