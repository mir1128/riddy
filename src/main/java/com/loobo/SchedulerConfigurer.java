package com.loobo;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfigurer {
    private Scheduler scheduler;

    public SchedulerConfigurer() {
        SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Scheduler scheduler() {
        return scheduler;
    }
}
