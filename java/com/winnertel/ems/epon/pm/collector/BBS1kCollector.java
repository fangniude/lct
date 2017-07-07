package com.winnertel.ems.epon.pm.collector;

import com.winnertel.ems.epon.pm.collector.job.EponJobDetailFactory;
import com.winnertel.ems.epon.pm.collector.job.EponTriggerFactory;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.upm.common.job.entities.JobGroup;
import com.winnertel.inms.upm.common.job.entities.JobOperateResult;
import com.winnertel.inms.upm.common.job.entities.JobStatus;
import com.winnertel.inms.upm.common.job.entities.MeasurementJob;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.interfaces.JobInformRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.JobScheduleRemoteIntf;
import com.winnertel.inms.upm.server.collector.dataCollection.NEDataCollectorIntf;
import com.winnertel.inms.upm.server.common.DataCollectorParam;
import com.winnertel.inms.upm.server.exceptions.PmException;
import com.winnertel.inms.upm.server.job.entities.JobUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class BBS1kCollector implements NEDataCollectorIntf
{
  static String currentPath = null;
  static
  {
    //initialize the Log4j before getting the reference.
    currentPath = new File(".").getAbsolutePath();
    String confFile = currentPath + "/conf/inms/upm/collectorLogs.conf";
    System.out.println("Config file for Log4j: " + confFile);
    PropertyConfigurator.configure(confFile);
  }

  static Logger log = Logger.getLogger(BBS1kCollector.class);
  static Scheduler scheduler = null;
  
  private String neIp = null;
  private String community = "public";
  private int snmpPort = 161;
  
  public BBS1kCollector()
  {
    if(scheduler == null)
    {
      StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
      String confFile = currentPath + "/conf/inms/upm/collector_quartz.properties";
      try
      {
        schedulerFactory.initialize(confFile);
      }
      catch(SchedulerException e)
      {
        log.fatal("Can't initialize the Quartz: file = " + confFile + "; error = "+ e.getMessage());
        e.printStackTrace();
      }

      try
      {
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();
      }
      catch(SchedulerException e)
      {
        log.fatal("Can't start the scheduler: " + e.getMessage());
        e.printStackTrace();
      }
    }
  }

  /**
   * Init method of interface
   * 
   * @param neMeasurementObject
   *          MeasurementObject
   */
  public void init(MeasurementObject neMeasurementObject)
  {
    log.debug("Init() method parameter = " + neMeasurementObject);
    HashMap extendInfo = neMeasurementObject.getExtendInfo();
    log.debug("NE extend info: " + extendInfo);
    neIp = (String)extendInfo.get(PropertyConstant.NE_IP_ADDRESS);
    if(extendInfo.get(PropertyConstant.NE_GET_COMMUNITY) != null)
    {
      community = (String)extendInfo.get(PropertyConstant.NE_GET_COMMUNITY);
    }
    try
    {
      snmpPort = Integer.parseInt((String)extendInfo.get(PropertyConstant.NE_SNMP_PORT));
    }
    catch(NumberFormatException e)
    {
      log.warn("Invalid SNMP Port: " + extendInfo.get(PropertyConstant.NE_SNMP_PORT));
    }
    
    log.debug("neIp = " + neIp);
    log.debug("community = " + community);
    log.debug("snmpPort = " + snmpPort);
    log.debug("Init() method end.");
  }

  /**
   * This method will be invoked every hour for get the PM job data.
   * 
   * @param dcParam
   *          DataCollectorParam
   * @throws PmException
   */
  public void getPMData(DataCollectorParam dcParam) throws PmException
  {
//    List jobList = dcParam.getMeasurementJobList();
//    String filePath = dcParam.getFileLocation();
//    String neName = dcParam.getNe().getNeName();
    // log.warn("DataCollect NE name = " + neName);
    // log.warn("DataCollect file patha = " + filePath);
//    if(jobList == null || (jobList.size() == 0))
//    {
//      log.warn("No Job specified for get data!");
//      return;
//    }
//    Iterator jobIt = jobList.iterator();
//    MeasurementJob oneJob = null;
//    while (jobIt.hasNext())
//    {
//      oneJob = (MeasurementJob) jobIt.next();
      // log.warn("One Job ID = " + oneJob.getJobId());
      // get job file and move job file to file location.

//    }
    log.debug("getPMData(): EMS doesn't use this method.");
  }

  /**
   * This method will be invoked when use create a new job or retrieve the old
   * job. The job status must be set to corret status.
   * 
   * @param jobGroup
   *          JobGroup
   * @param measJob
   *          MeasurementJob
   * @return JobOperateResult
   */
  public JobOperateResult dispatchJob(JobGroup jobGroup, MeasurementJob measJob)
  {
    log.debug("Begin to dispatch a job, jobgroup = " + jobGroup + ", measure job = " + measJob);
    JobOperateResult jor = null;
    if((jobGroup == null) || (measJob == null))
    {
      log.warn("Fail to dispatch job, input parameters are null.");
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Input parameters are null.");
      return jor;
    }

    String jobName = String.valueOf(measJob.getJobId());

//    String neName = measJob.getNetElement().getNeName();
//    String neIp = CollectorUtil.getNEIPAddress(neName);
//    if(neIp == null)
//    {
//      log.warn("Fail to dispatch job[" + jobName + "]: can't get the NE[" + neName + "] IP address.");
//      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Can't get the NE IP address by NE name.");
//      return jor;
//    }
    
    if(!PmUtil.isNeActive(neIp, snmpPort, community))
    {
      log.info("Fail to dispatch job[" + jobName + "]: the NE[" + neIp + "] is inactive.");
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "The NE is inactive.");
      return jor;
    }
    log.debug("NE[" + neIp + "] is active.");
       
//    if(hasJob(jobName, groupName))
//    {
//      log.warn("Fail to dispatch job, the specified job[" + jobName + "] already exists.");
//      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "The specified job already exists.");
//      return jor;
//    }
    
    try
    {
      addJobToNe(measJob);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      log.warn("Fail to dispatch job[" + jobName + "] to NE[" + neIp + "]: " + e.getMessage());
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, e.getMessage());
      return jor;
    }

    log.info("Dispatch job[" + jobName + "] to NE[" + neIp + "] successfully.");
    jor = new JobOperateResult(JobOperateResult.Result_Success, measJob, "Dispatch job successfully.");
    return jor;
  }

  /**
   * This method will be invokde when user to suspend or resume a job. BBEMS
   * need to check the job status to commit the operation.
   * 
   * @param jobGroup
   *          JobGroup
   * @param measJob
   *          MeasurementJob
   * @param opType
   *          int UpdateJobType_MO: update job mo; UpdateJobType_State : update
   *          Job status
   * @return JobOperateResult
   */
  public JobOperateResult maintainJob(JobGroup jobGroup, MeasurementJob measJob, int opType)
  {
    log.debug("Begin to maintain a job, job group = " + jobGroup + ", measure job = " + measJob + ", operation= " + opType);
    JobOperateResult jor = null;
    if((jobGroup == null) || (measJob == null))
    {
      log.warn("Fail to maintain the job, input parameters are null.");
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Input parameters are null.");
      return jor;
    }

    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();
    try
    {
      if(opType == JobScheduleRemoteIntf.JOB_OPER_PEND)
      {
        //delete the job.
        scheduler.deleteJob(jobName, neName);
        log.debug("Suspend the Job[" + jobName + "] successfully.");
      }
      else if(opType == JobScheduleRemoteIntf.JOB_OPER_RESUME)
      {
        try
        {
          addJobToNe(measJob);
          log.debug("Resume the Job[" + jobName + "] successfully.");
        }
        catch(Exception e)
        {
          log.warn("Can't resume the job[" + jobName + "], error occured when the Job was added to scheduler" + e.getMessage());
        }
      }
//      else if(opType == JobScheduleRemoteIntf.JOB_OPER_CHANGEBEGINTIME)
//      {
//        // repace the older trigger with new trigger.
          // PM GUI doesn't support the function.      
//      }
      else if(opType == JobScheduleRemoteIntf.JOB_OPER_DELETE)
      {
        scheduler.deleteJob(jobName, neName);
        log.debug("Delete the Job[" + jobName + "] successfully.");
      }
      else
      {
        log.warn("Fail to maintain job[" + jobName + "], unsupported operation: " + opType);
        jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Fail to maintain the job, unsupported operation: " + opType);
        return jor;
      }
    }
    catch (SchedulerException e1)
    {
//      e1.printStackTrace();
      log.warn("Fail to maintain job[" + jobName + "], Error: " + e1.getMessage());
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Fail to maintain the job: " + e1.getMessage());
      return jor;
    }
    
    jor = new JobOperateResult(JobOperateResult.Result_Success, measJob, "Maintain job[" + jobName + "] successfully.");
    return jor;
  }

  public JobOperateResult modifyJobGroup(JobGroup jobGroup, MeasurementJob measurementJob)
  {
    log.debug("JobGroup=" + jobGroup);
    log.debug("EMS doesn't need this interface.");
    return null;
  }

  public JobOperateResult modifyJob(JobGroup jobGroup, MeasurementJob measurementJob)
  {
    log.debug("Modify job: " + measurementJob);
    String neName = measurementJob.getNetElement().getNeName();
    String jobId = "" + measurementJob.getJobId();

    JobOperateResult jor = null;
    try
    {
      scheduler.deleteJob(jobId, neName);
    }
    catch(Exception e)
    {
      log.error(this, e);
    }

    try
    {
      addJobToNe(measurementJob);
    }
    catch(Exception e)
    {
      log.error(this, e);
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measurementJob, "Failed to modify job: " + e.getMessage());
      return jor;
    }
    jor = new JobOperateResult(JobOperateResult.Result_Success, measurementJob, "Modify job successfully.");
    return jor;
  }

  /**
   * Change the Job begin time.
   * 
   * @param jobGroup
   *          JobGroup
   * @param measJob
   *          MeasurementJob
   * @param time
   *          String
   * @return JobOperateResult
   */
  public JobOperateResult changeJobBeginTime(JobGroup jobGroup, MeasurementJob measJob, String time)
  {
    log.debug("Change the job time, Job = " + measJob + ", Time = " + time);
    JobOperateResult jor = null;
    if((jobGroup == null) || (measJob == null) || (time == null) || (time.length() == 0))
    {
      log.warn("Failt to change job time, the input parameters are null.");
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "The input parameters are null.");
      return jor;
    }
    
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();
    try
    {
      //
      Trigger trigger = EponTriggerFactory.generateTrigger(jobGroup, measJob);
      scheduler.rescheduleJob(jobName, neName, trigger);
    }
    catch (Exception e1)
    {
//      e1.printStackTrace();
      log.warn("Fail to change Job[" + measJob.getJobId() + "]'s begin time: " + e1.getMessage());
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Fail to change begin time: " + e1.getMessage());
      return jor;
    }
    
    log.info("Change Job[" + measJob.getJobId() + "]'s begin time successfully.");
    jor = new JobOperateResult(JobOperateResult.Result_Success, measJob, "Change the begin time successfully.");
  
    return jor;
  }

  /**
   * Following tow methods are for UPM and EMS sync. UPM only use EMS to notify
   * itself about NE add/delete/modify and MO add/delete/modify regardless NE
   * contains jobs or not. When EMS NE or MO under NE has changed, EMS should
   * notify UPM use JobInformRemoteIntf(RMI). UPM then invoke the followiing
   * methods to sync with EMS.
   * 
   * Notice : when the server is reboot, the syncNode() is invoked.
   */

  /**
   * UPM will invoke this method to sync jobs with EMS if MO(under NE) status is
   * changed(add/delete). BBEMS need not implement this interface when MO is
   * changed.
   * 
   * @param aJob
   *          MeasurementJob
   * @param measObject
   *          MeasurementObject
   * @param syncType
   *          int
   * @return JobOperateResult
   */
  public JobOperateResult syncMO(MeasurementJob aJob,
      MeasurementObject measObject, int syncType)
  {
    log.debug("Sync mo, Job = " + aJob + ", measure obj = " + measObject + ", sync type = " + syncType);
//    HashMap extendInfo = measObject.getExtendInfo();
//    log.debug("ExtendInfo=" + extendInfo);
//    if(syncType == JobInformRemoteIntf.JOB_SYNC_OMC_MANUAL)
//    {
//      if(extendInfo.get("snmpport") != null)
//      {
//        try
//        {
//          int port = Integer.parseInt((String)extendInfo.get("snmpport"));
//          if(snmpPort != port)
//          {
//            snmpPort = port;
//            ;
//          }
//        }
//        catch(Exception e)
//        {
//
//        }
//      }
//
//      if(extendInfo.get("getCommunity") != null)
//      {
//        if(!community.equals(extendInfo.get("getCommunity")))
//        {
//          try
//          {
//            community = (String)extendInfo.get("getCommunity");
//            ;
//          }
//          catch(Exception e)
//          {
//
//          }
//        }
//      }
//    }
//    JobOperateResult jor = null;
//    if((aJob == null) || (measObject == null))
//    {
//      log.warn("Fail to sync mo, the input parameters are null.");
//      jor = new JobOperateResult(JobOperateResult.Result_Fail, aJob, "The input parameters are null.");
//      return jor;
//    }

//    // MO delete or added
//    if(syncType == JobInformRemoteIntf.JOB_SYNC_DELETED)
//    {
//    }
//    else if(syncType == JobInformRemoteIntf.JOB_SYNC_DISCOVERY)
//    {
//    }
//    else
//    {
//      log.warn("Unknow Sync type!");
//    }
//    log.debug("Sync the mo successfully.");

    log.debug("syncMO(): EMS doesn't use this method.");
    JobOperateResult jor = new JobOperateResult(JobOperateResult.Result_Success, aJob, "Sync MO job successfully.");
    return jor;
  }

  /**
   * UPM will invoke this method to sync jobs with EMS if NE status is
   * changed(reconnection/disconnection). BBESM need to restart or pause these jobs
   * in memory.
   *
   * @param neName
   *          String
   * @param neType
   *          String
   * @param neVersion
   *          String
   * @param syncType
   *          int
   * @return JobOperateResult
   */
  public JobOperateResult syncNode(String neName, String neType, String neVersion, int syncType)
  {
    log.debug("syncNode(NEDataCollector is deprecated.");
    return null;
  }
  
  boolean hasJob(String jobName, String groupName)
  {
    String[] jobs;
    try
    {
      jobs = scheduler.getJobNames(groupName);
      if(jobs != null)
      {
        for(int i = 0; i < jobs.length; i++)
        {
          if(jobs[i].equals(jobName))
          {
            return true;
          }
        }
      }
    }
    catch (SchedulerException e)
    {
//      e.printStackTrace();
    }
    return false;
  }
  
  boolean hasTrigger(String triggerName, String groupName)
  {
    try
    {
      if(scheduler.getTrigger(triggerName, groupName) != null)
        return true;
    }
    catch (SchedulerException e)
    {
//      e.printStackTrace();
    }
    return false;
  }
  
  void addJobToNe(MeasurementJob measJob) throws SchedulerException, Exception
  {
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();
    
    int state = measJob.getJobStatus();
    if(state == JobStatus.JOBSTATE_FINISHED)
    {
      log.info("The Job[" + jobName + "] has finished, Can't be added to NE[" + neName + "].");
      return;
    }
    
    JobDetail jobDetail = EponJobDetailFactory.generateJobDetail(neIp, snmpPort, community, measJob);
    Trigger trigger = EponTriggerFactory.generateTrigger(measJob.getJobGroup(), measJob);
    scheduler.scheduleJob(jobDetail, trigger);
    log.debug("Job[" + jobName + "] has been added to NE[" + neName + "].");
  }
  
  void deleteJobsFromNe(String neName)
  {
    String jobName = null;
    try
    {
      String[] jobs = scheduler.getJobNames(neName);
      if(jobs != null)
      {
        for(int i = 0; i < jobs.length; i++)
        {
          jobName = jobs[i];
          scheduler.deleteJob(jobName, neName);
        }
      }
    }
    catch (SchedulerException e)
    {
      log.warn("Can't delete the Job[" + jobName + "] from NE[" + neName + "]: " + e.getMessage());
//      e.printStackTrace();
    }
  }
  
  public static void main(String[] args)
  {
  }

  public void reset()
  {
    log.debug("This reset method is not implemented by OMC-D.");
  }

  public JobOperateResult syncNode(MeasurementObject mo, int syncType)
  {
    String neName = mo.getName();
    HashMap extendInfo = mo.getExtendInfo();
    String neType = (String)extendInfo.get(MeasurementObject.Extend_Node_Type);

    log.debug("syncNode(NEDataCollectorIntf) invoked , NE = " + neName + ", Sync Type = " + syncType + ", ExtendInfo = " + extendInfo);

    JobOperateResult jor = null;
    
    if(syncType == JobInformRemoteIntf.JOB_SYNC_DISCOVERY)
    {
      log.debug("Discovery the jobs from NE[" + neName + "], NE Type = " + neType);
      
      List jobList = JobUtil.getPMJobList(neName, neType);
      if(jobList == null || (jobList.size() == 0))
      {
        log.debug("Discovery the Jobs from NE[" + neName + "] successfully, The job list is empty.");
        jor = new JobOperateResult(JobOperateResult.Result_Success, null, "Sync NE node job successfully.");
        return jor;
      }
      
      for(int i = 0; i < jobList.size(); i++)
      {
        MeasurementJob measJob = (MeasurementJob)jobList.get(i);
        if(measJob == null)
        {
          log.debug("Discovery the job from NE[" + neName + "] successfully, The job is null.");
          continue;
        }
        
        try
        {
          if(measJob.getJobStatus() == JobStatus.JOBSTATE_MEASURING)
          {
            addJobToNe(measJob);
            log.debug("Discovery the Job[" + measJob.getJobId() + "] from NE[" + neName + "] successfully.");
          }
          else
          {
            log.debug("The Job[" + measJob.getJobId() + "] is not running, don't add it to NE.");
          }
        }
        catch (Throwable e)
        {
//          e.printStackTrace();
          log.warn("Fail to discovery the Job[" + measJob.getJobId() + "] from NE[" + neName + "]: " + e.getMessage());
        }
      }
      log.info("Finish to discovery " + jobList.size() + " jobs from NE[" + neName + "].");
    }
    else if(syncType == JobInformRemoteIntf.JOB_SYNC_DELETED)
    {
      log.info("Delete the jobs in NE. NE[" + neName + "], NE Type = " + neType);

      /* find the jobs of the NE, and delete them. */
      try
      {
        deleteJobsFromNe(neName);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        log.warn("Fail to delete the jobs from NE[" + neName + "], Error = " + e.getMessage());
      }
    }
    else if(syncType == JobInformRemoteIntf.JOB_SYNC_RECONNECTIOIN)
    {
      log.debug("The NE[" + neName + "] is reconnected, resume the related jobs.");
      List jobList = JobUtil.getPMJobList(neName, neType);
      if(jobList == null || (jobList.size() == 0))
      {
        log.debug("Resume the jobs in NE[" + neName + "] successfully, The job list is empty.");
        jor = new JobOperateResult(JobOperateResult.Result_Success, null, "Sync NE node job successfully.");
        return jor;
      }

      for(int i = 0; i < jobList.size(); i++)
      {
        MeasurementJob measJob = (MeasurementJob)jobList.get(i);
        if(measJob == null)
        {
          log.debug("resume the job successfully, the job got from DB is null.");
          continue;
        }
               
        try
        {
          if(measJob.getJobStatus() == JobStatus.JOBSTATE_MEASURING)
          {
            addJobToNe(measJob);
            log.debug("The NE[" + neName + "] is reconnected now, add the Job[" + measJob.getJobId() + "] to NE again.");
          }
          else
          {
            log.debug("The Job[" + measJob.getJobId() + "] is not running, don't add it to NE.");
          }
        }
        catch(Exception e)
        {
          log.warn("Fail to resume the Job[" + measJob.getJobId() + "] in NE[" + neName + "]: " + e.getMessage());
        }
      }
      log.info("Finish to resume " + jobList.size() + " jobs for NE[" + neName + "].");
    }
    else if(syncType == JobInformRemoteIntf.JOB_SYNC_DISCONNECTION)
    {
      log.debug("The NE[" + neName + "] is disconnected, suspend the related Jobs.");

      deleteJobsFromNe(neName);
      log.info("Finish to suspend jobs in NE[" + neName + "].");
    }
    else if(syncType == JobInformRemoteIntf.JOB_SYNC_UPDATE)
    {
      log.debug("The Property of NE[" + neName + "] is changed, synchronize the property.");
      try
      {
//        extendInfo
        String ipAddress = (String)extendInfo.get(PropertyConstant.NE_IP_ADDRESS);
        String snmpPortStr = (String)extendInfo.get(PropertyConstant.NE_SNMP_PORT);
        String getCommunity = (String)extendInfo.get(PropertyConstant.NE_GET_COMMUNITY);
        
        log.debug("The new IP address is " + ipAddress);
        log.debug("The new snmp port is " + snmpPortStr);
        log.debug("The new get community is " + getCommunity);
        
        if(ipAddress != null)
          neIp = ipAddress;
        
        if(snmpPortStr != null)
          snmpPort = Integer.parseInt(snmpPortStr);
        
        if(getCommunity != null)
          community = getCommunity;

        String[] jobs = scheduler.getJobNames(neName);
        if(jobs != null)
        {
          for(int i = 0; i < jobs.length; i++)
          {
            log.debug("update job extend info for job: " + jobs[i]);
            JobDetail jobDetail = scheduler.getJobDetail(jobs[i], neName);
            
            JobDataMap dataMap = jobDetail.getJobDataMap();
            if(ipAddress != null)
              dataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_NE_IP, ipAddress);
            
            if(snmpPortStr != null)
              dataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_NE_SNMP_PORT, Integer.parseInt(snmpPortStr));
            
            if(getCommunity != null)
              dataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_NE_SNMP_GETCOMMUNITY, getCommunity);
          }
        }
      }
      catch(Throwable e)
      {
        log.error(this, e);
      }
    }
    else if(syncType == JobInformRemoteIntf.JOB_SYNC_OMC_MANUAL)
    {
      log.debug("Do nothing for synchronizing NE[" + neName + "] manually.");
    }
    else
    {
      log.warn("Fail to sync NE[" + neName + "], unsupported operation type: " + syncType);
      jor = new JobOperateResult(JobOperateResult.Result_Fail, null, "Unsupported operation type: " + syncType);
      return jor;
    }    
     
    jor = new JobOperateResult(JobOperateResult.Result_Success, null, "Sync Node successfully.");
    return jor;
  }
}
