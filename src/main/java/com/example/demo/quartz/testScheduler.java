package com.example.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class testScheduler {
        public static void main (String[] args) throws SchedulerException {
            //创建一个Jobdetail实例，将该实例与Job Class绑定
            JobDetail joddetail = JobBuilder.newJob(testJob.class).withIdentity("myjob","group1").build();
            //创建一个Trigger实例，定义该job立即执行，每隔两秒重复执行
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger","group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
            //创建Schedule实例
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler =  schedulerFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(joddetail,trigger);

        }
}
