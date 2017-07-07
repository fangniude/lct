package com.winnertel.ems.epon.pm.collector.job;

import com.winnertel.inms.upm.common.job.entities.JobGroup;
import com.winnertel.inms.upm.common.job.entities.MeasurementJob;
import com.winnertel.inms.upm.common.job.entities.RepeatTime;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import java.util.Date;
import java.util.TimeZone;

public class EponTriggerFactory
{
  static Logger log = Logger.getLogger(EponTriggerFactory.class);
  
  public EponTriggerFactory()
  {}

  public static Trigger generateTrigger(JobGroup jobGroup, MeasurementJob measJob) throws Exception
  {
    //adjust the time according to time zone.
    log.debug("Generate the Trigger for Job[" + measJob.getJobId() + "].");
    Trigger trigger = null;
    String triggerName = String.valueOf(measJob.getJobId());
    String groupName = measJob.getNetElement().getNeName();
    
    //Generate the trigger for job according to the repeatTime.
    RepeatTime repeatTime = jobGroup.getRepeatTime();
    int granularity = jobGroup.getGranularity();
    long interval = granularity * 60000;
    
    //adjust the job start time. 
    long startTime = jobGroup.getBeginTime().getTimeInMillis();
    long currentTime = System.currentTimeMillis();
    if(currentTime > startTime)
    {
      startTime = currentTime;
    }
    startTime = startTime + interval - (startTime % interval);
    if(granularity == 1440) startTime = startTime - TimeZone.getDefault().getOffset(0);
    log.debug("The start time of Job[" + measJob.getJobId() + "] after adjustment: " + new Date(startTime));

    switch(repeatTime.getRepeatType())
    {
      case RepeatTime.Job_RepeatType_Continued:
      {       
        //
        Date startDate = new Date(startTime);
        trigger = new SimpleTrigger(triggerName, groupName, startDate, null, SimpleTrigger.REPEAT_INDEFINITELY, interval);
        break;
      }
      case RepeatTime.Job_RepeatType_Daily:
      {
        String expressions = null;
        long startHour = repeatTime.getStartTime();
        long stopHour = repeatTime.getEndTime();
        if(startHour >= stopHour)
        {
          throw new Exception("Start Hour(" + startHour + ") >= End Hour(" + stopHour + ").");
        }
        if(granularity == 15)
        {
          expressions = "0 0/15 * * * ?";
        }
        else if(granularity == 60)
        {
          expressions = "0 0 " + startHour + "-" + stopHour + " * * ?";
        }
        else if(granularity == 1440)
        {
          expressions = "0 0 " + startHour + " * * ?";
        }
        else
        {
          throw new Exception("The measurement Granularity isn't supported: " + granularity);
        }
        
        //the job name is same as trigger name, and the job group name is as same as trigger group name.
        trigger = new CronTrigger(triggerName, groupName, triggerName, groupName, new Date(startTime), null, expressions);
        break;
      }
      case RepeatTime.Job_RepeatType_Once:
      {
        //use start time in repeatTime not begin time in jobGroup.
        startTime = repeatTime.getStartTime();
        long stopTime = repeatTime.getEndTime();
        
        Date startDate = new Date(startTime);
        Date stopDate = new Date(stopTime);
        trigger = new SimpleTrigger(triggerName, groupName, startDate, stopDate, SimpleTrigger.REPEAT_INDEFINITELY, interval);
        break;
      }
      default:
        throw new Exception("Repeat Type isn't supported: " + repeatTime.getRepeatType());
    }
    
    //
    trigger.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
    return trigger;
  }
}