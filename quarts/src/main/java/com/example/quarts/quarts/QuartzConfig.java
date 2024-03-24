package com.example.quarts.quarts;

import com.example.quarts.quarts.job.ExampleJob1;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail exampleJobDetail(){
        return JobBuilder.newJob(ExampleJob1.class)
                .withIdentity("exampleJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger exampleJobTrigger(JobDetail exampleJobDetail){
        return TriggerBuilder.newTrigger()
                .forJob(exampleJobDetail)
                .withIdentity("exampleTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }
}
