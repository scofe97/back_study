package com.example.quarts.quarts;

import com.example.quarts.quarts.job.DummyJob;
import com.example.quarts.quarts.job.PrintJob;
import com.example.quarts.quarts.listener.JobsGlobalListener;
import com.example.quarts.quarts.listener.TriggersGlobalListener;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class QuartzConfig {

    private final JobsGlobalListener jobsGlobalListener;
    private final TriggersGlobalListener triggersGlobalListener;


    @Bean
    @Qualifier("printJob")
    public JobDetail printJobDetail() {
        return JobBuilder.newJob(PrintJob.class)
                .withIdentity("응애", "개발자")
                .storeDurably()
                .build();
    }

    @Bean
    @Qualifier("dummyJob")
    public JobDetail dummyJobDetail() {
        return JobBuilder.newJob(DummyJob.class)
                .withIdentity("더미", "개발자")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTrigger(@Qualifier("printJob") JobDetail printJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(printJobDetail)
                .withIdentity("응애", "개발자")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

        // 스프링 애플리케이션 시작 시 스케줄러 자동 시작 설정
        schedulerFactory.setAutoStartup(true);

        // 스케줄러 시작 지연 시간 설정 (예: 애플리케이션 시작 후 10초 후에 스케줄러 시작)
        schedulerFactory.setStartupDelay(1);

        // 설정 적용
        schedulerFactory.setQuartzProperties(quartzProperties());

        schedulerFactory.setGlobalJobListeners(jobsGlobalListener);
        schedulerFactory.setGlobalTriggerListeners(triggersGlobalListener);

        return schedulerFactory;
    }

    private Properties quartzProperties() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quarts.properties"));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
