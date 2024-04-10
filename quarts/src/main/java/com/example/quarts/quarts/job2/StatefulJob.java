package com.example.quarts.quarts.job2;

import org.quartz.*;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class StatefulJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        int count = dataMap.getInt("count");
        count++;

        try {
            Thread.sleep(1000); // 100 밀리초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        dataMap.put("count", count);
        System.out.println("Job is running for the " + count + " time");
    }
}
