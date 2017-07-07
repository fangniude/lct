package com.winnertel.ems.epon.pm.collector;

import org.quartz.impl.StdSchedulerFactory;
import org.quartz.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import java.util.Date;
import java.io.File;

import com.winnertel.ems.epon.pm.collector.job.bbs4000.BBS4kCollectorJob;

public class SchedulerServer {
    static {
        try {
            //initialize the Log4j before getting the reference.
            String currentPath = new File(".").getAbsolutePath();
            String confFile = currentPath + "/conf/inms/upm/collectorLogs.conf";
            System.out.println("BBS4000 Config file for Log4j: " + confFile);

            PropertyConfigurator.configure(confFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    Scheduler scheduler = null;
    Logger log = Logger.getLogger(BBS4kCollector.class);

    private static SchedulerServer instance = null;

    private SchedulerServer() {

    }

    /**
     * new the Scheduler, and register the collector job.
     */
    public void start() {
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        String confFile = "./conf/inms/upm/collector_quartz.properties";
        try {
            schedulerFactory.initialize(confFile);
        }
        catch (SchedulerException e) {
            log.fatal("Can't initialize the Quartz: file = " + confFile + "; error = " + e.getMessage());
            e.printStackTrace();
        }

        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();

            long t = System.currentTimeMillis();
            //collect the data 5 minutes past every hour.
            t = t - (t % 3600000) + 3900000;
            Date startDate = new Date(t);
            int interval = 3600000;
//          interval = interval / 60;

            log.debug("Collect Thread starts at " + startDate + ", and collect the PM data every " + (interval / 1000) + " seconds.");
            Trigger trigger = new SimpleTrigger("Collection_Job_Trigger", "1", startDate, null, SimpleTrigger.REPEAT_INDEFINITELY, interval);
            JobDetail jobDetail = new JobDetail("Collection_Job", "1", BBS4kCollectorJob.class);

            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e) {
            log.fatal("Can't start the scheduler: " + e.getMessage());
            e.printStackTrace();
        }

        //make the directory to store the tftp file.
        File file = new File("download");
        if (!file.exists() || file.isFile()) {
            file.mkdir();
        }
    }

    public synchronized void scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public synchronized void deleteJob(String jobId, String jobGroup) throws SchedulerException {
        scheduler.deleteJob(jobId, jobGroup);
    }

    public synchronized String[] getJobNames(String jobGroup) throws SchedulerException {
        return scheduler.getJobNames(jobGroup);
    }

    public static synchronized SchedulerServer getInstance() {
        if (instance == null) {
            instance = new SchedulerServer();
            instance.start();
        }

        return instance;
    }
}
