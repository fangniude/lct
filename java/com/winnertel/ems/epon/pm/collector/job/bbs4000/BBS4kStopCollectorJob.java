package com.winnertel.ems.epon.pm.collector.job.bbs4000;

import com.winnertel.ems.epon.pm.collector.job.EponJobDetailFactory;
import com.winnertel.ems.epon.pm.collector.mo.NePmJobCenter;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BBS4kStopCollectorJob implements Job
{
  static Logger log = Logger.getLogger(BBS4kCollectorJob.class.getName());

  public BBS4kStopCollectorJob()
  {}

  public void execute(JobExecutionContext context) throws JobExecutionException
  {
    NePmJobCenter nePmJobCenter = NePmJobCenter.getInstance();

    JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
    String neName = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_NE_NAME);
    String jobGroup = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_JOBGROUP_ID);

    nePmJobCenter.removeNePmJobInfo(neName, jobGroup);
  }
}
