package com.example.quarts.quarts.job2;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

@Slf4j
public class NormalJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        for (String string : context.getMergedJobDataMap().keySet()) {
            System.out.println("string = " + string);
        }
    }
}
