package ru.job4j.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 29.04.2019
 */
public class Main {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(SqlRuParser.class)
                .withIdentity("job", "gr1").build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trig", "gr1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(24).repeatForever())
                        .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
