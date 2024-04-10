package com.example.quarts.quarts.service;

import com.example.quarts.quarts.job2.ErrorJob;
import com.example.quarts.quarts.job2.NormalJob;
import com.example.quarts.quarts.job2.StatefulJob;
import lombok.RequiredArgsConstructor;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

@Component
public class JobDetailService {

    public JobDetail serviceBuild(JobKey jobKey) {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("data1", "data1");
        jobDataMap.put("data2", "data2");
        jobDataMap.put("data3", "data3");

        return JobBuilder.newJob(NormalJob.class)
                .withIdentity(jobKey.getName(), jobKey.getGroup())
                .usingJobData(jobDataMap)
                .build();
    }


    public JobDetail errorBuild(JobKey jobkey) {
        return JobBuilder.newJob(ErrorJob.class)
                .withIdentity(jobkey.getName(), jobkey.getGroup())
                .storeDurably(true)
                .build();
    }

    public JobDetail statefulBuild(JobKey jobKey) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("count", 0);

        return JobBuilder.newJob(StatefulJob.class)
                .withIdentity(jobKey.getName(), jobKey.getGroup())
                .usingJobData(jobDataMap)
                .build();
    }
}
