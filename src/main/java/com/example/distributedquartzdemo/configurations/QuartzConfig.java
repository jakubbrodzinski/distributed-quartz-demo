package com.example.distributedquartzdemo.configurations;

import com.example.distributedquartzdemo.configurations.scheduled.jobs.UpdateBookJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail updateBookJobDetail(){
        return JobBuilder.newJob(UpdateBookJob.class)
                .storeDurably()
                .withIdentity(UpdateBookJob.JOB_NAME)
                .build();
    }

    @Bean
    public Trigger updateBookJobTrigger(@Value("${update-book.cron.expression}") String cronExpression,
                                        JobDetail updateBookJobDetail) throws ParseException {
        return TriggerBuilder.newTrigger()
                .withIdentity(UpdateBookJob.JOB_NAME + "Trigger")
                .forJob(updateBookJobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }

}
