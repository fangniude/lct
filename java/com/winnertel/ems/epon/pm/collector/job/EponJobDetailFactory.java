package com.winnertel.ems.epon.pm.collector.job;

import com.winnertel.ems.epon.pm.collector.job.bbs1000p.BBS1kCollectorJob;
import com.winnertel.ems.epon.pm.collector.job.bbs4000.BBS4kThroughputJob;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.inms.upm.common.commoninfo.entities.MeasurementItem;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.common.job.entities.JobGroup;
import com.winnertel.inms.upm.common.job.entities.MeasurementJob;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import org.apache.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

import java.util.ArrayList;
import java.util.List;

public class EponJobDetailFactory
{
  static Logger log = Logger.getLogger(EponJobDetailFactory.class);
  public static String JOBDETAIL_KEY_JOB_ID = "JOBDETAIL_KEY_JOB_ID";
  public static String JOBDETAIL_KEY_JOBGROUP_ID = "JOBDETAIL_KEY_JOBGROUP_ID";
  public static String JOBDETAIL_KEY_JOB_GRANULARITY = "JOBDETAIL_KEY_JOB_GRANULARITY";
  public static String JOBDETAIL_KEY_NE_NAME = "JOBDETAIL_KEY_NE_NAME";
  public static String JOBDETAIL_KEY_NE_IP = "JOBDETAIL_KEY_IP";
  public static String JOBDETAIL_KEY_NE_SNMP_PORT = "JOBDETAIL_KEY_NE_SNMP_PORT";
  public static String JOBDETAIL_KEY_NE_SNMP_GETCOMMUNITY = "JOBDETAIL_KEY_NE_SNMP_GETCOMMUNITY";
  public static String JOBDETAIL_KEY_MEASUREMENT_SET_NAME = "JOBDETAIL_KEY_MEASUREMENT_SET_NAME";
  public static String JOBDETAIL_KEY_MEASUREMENT_TYPE_NAME = "JOBDETAIL_KEY_MEASUREMENT_TYPE_NAME";
  public static String JOBDETAIL_KEY_ITEM = "JOBDETAIL_KEY_ITEM";
  public static String JOBDETAIL_KEY_INSTANCE = "JOBDETAIL_KEY_INSTANCE";
  
  public EponJobDetailFactory()
  {}
  
  public static JobDetail generateJobDetail(String neIp, int port, String getCommunity, MeasurementJob measJob)
  {
    try {
      String version = SnmpUtility.getNeVersion("BBS1000+", neIp, port, getCommunity);
      if(version.startsWith("3.1"))
      {
        return generateJobDetail(neIp, port, getCommunity, measJob, BBS1kCollectorJob.class);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return generateJobDetail(neIp, port, getCommunity, measJob, EponCollectorJob.class);
  }

  public static JobDetail generateBBS4kJobDetail(String neIp, int port, String getCommunity, MeasurementJob measJob)
  {
    return generateJobDetail(neIp, port, getCommunity, measJob, BBS4kThroughputJob.class);
  }

  private static JobDetail generateJobDetail(String neIp, int port, String getCommunity, MeasurementJob measJob, Class jobClass)
  {
    JobGroup jobGroup = measJob.getJobGroup();
    log.debug("Get the JobDetail for Job[" + measJob.getJobId() + "].");
    //get the measurement info.
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();
    
    //get measurement items.
    List measItems = new ArrayList();
    MeasurementItem[] items = jobGroup.getMeasureItems();
    for(int i = 0; i < items.length; i++)
    {
      NamePair namePair = new NamePair(items[i].getOID(), items[i].getNamePair().name); 
      measItems.add(namePair);
    }
    log.debug("Job[" + jobName + "] has " + measItems.size() + " Measurement Items.");

    
    // get measurement instance list.
    List measInstances = new ArrayList();
    
    List moList = measJob.getMoList();
    for(int i = 0; i < moList.size(); i++)
    {
      MeasurementObject measObj = (MeasurementObject)moList.get(i);
      //user select the NE as the measurement instance.
      if(measObj.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
      {
        //set instances list empty. get all the instances from NE during data collection.
        measInstances = null;
        break;
      }
      else
      {
        measInstances.add(measObj.getName());
      }
    }
    
    if(measInstances != null)
      log.debug("Job[" + jobName + "] has " + measInstances.size() + " Measurement Instances.");
    else
      log.debug("Job[" + jobName + "] has null Measurement Instances.");
    
    JobDetail jobDetail = new JobDetail(jobName, neName, jobClass);
    //use ne name as job group.
    jobDetail.setGroup(neName);

    JobDataMap dataMap = jobDetail.getJobDataMap();
    dataMap.put(JOBDETAIL_KEY_JOB_ID, jobName);
    dataMap.put(JOBDETAIL_KEY_JOBGROUP_ID, String.valueOf(jobGroup.getJobGroupId()));
    dataMap.put(JOBDETAIL_KEY_JOB_GRANULARITY, String.valueOf(jobGroup.getGranularity()));
    dataMap.put(JOBDETAIL_KEY_NE_NAME, neName);
    dataMap.put(JOBDETAIL_KEY_NE_IP, neIp);
    dataMap.put(JOBDETAIL_KEY_NE_SNMP_PORT, port);
    dataMap.put(JOBDETAIL_KEY_NE_SNMP_GETCOMMUNITY, getCommunity);
    dataMap.put(JOBDETAIL_KEY_MEASUREMENT_SET_NAME, jobGroup.getMeasurementTypeSetName().name);
    dataMap.put(JOBDETAIL_KEY_MEASUREMENT_TYPE_NAME, jobGroup.getMeasurementTypeName().name);
    dataMap.put(JOBDETAIL_KEY_ITEM, measItems);
    dataMap.put(JOBDETAIL_KEY_INSTANCE, measInstances);

    return jobDetail;
  }
}
