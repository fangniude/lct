package com.winnertel.ems.epon.pm.impl;

import com.winnertel.ems.epon.pm.impl.tca.EponTCAJobFactory;
import com.winnertel.inms.upm.common.tca.entities.TCACommonResource;
import com.winnertel.inms.upm.common.tca.entities.TCAJobGroup;
import com.winnertel.inms.upm.common.tca.entities.TCAJobResultFeedback;
import com.winnertel.inms.upm.common.tca.entities.TCAMeasurementJob;
import com.winnertel.inms.upm.server.tca.TCAAssistant;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.utstar.ems.epon.log.EponLogger;
//import com.winnertel.ems.epon.util.LoggerUtility;

public class EponTCAJobImpl
{
//  static EponLogger log = LoggerUtility.getLogger(EponTCAJobImpl.class);
  private TCAAssistant tcaAssistant = new TCAAssistant();
  private static Scheduler tcaJobScheduler = null;

  public EponTCAJobImpl()
  {
    if(tcaJobScheduler == null)
    {
      String currentPath = new File(".").getAbsolutePath();
      StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
      String confFile = currentPath + "/conf/inms/upm/collector_quartz.properties";
      try
      {
        schedulerFactory.initialize(confFile);
      }
      catch(SchedulerException e)
      {
//        log.fatal("Can't initialize the Quartz: file = " + confFile + "; error = "+ e.getMessage());
        e.printStackTrace();
      }

      try
      {
        tcaJobScheduler = schedulerFactory.getScheduler();
        tcaJobScheduler.start();
        initTCAJobList();
      }
      catch(SchedulerException e)
      {
//        log.error(this, e);
//        log.fatal("Can't start the scheduler: " + e.getMessage());
          e.printStackTrace();
      }
      catch (Exception e)
      {
          e.printStackTrace();
//        log.error(this, e);
//        log.fatal("Can't load the TCA Job list: " + e.getMessage());
      }
    }    
  }

  public List createTCAJob(TCAJobGroup jobGroup, List tcaMeasurementJobs)
      throws Exception
  {
//    log.debug("Job group = " + jobGroup + ", TCA Job lists = " + tcaMeasurementJobs);

    List retList = new ArrayList();
    TCAMeasurementJob tcaJob = null;
    TCAJobResultFeedback tcaJobResultFB = null;

    if((jobGroup == null) || (tcaMeasurementJobs == null) || (tcaMeasurementJobs.size() == 0))
    {
//      log.warn("Input parameter is null!");
      tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_NO_JOBSLOT_ERROR);
      retList.add(tcaJobResultFB);
      return retList;
    }

    // period time in milliseconds
    long interval = jobGroup.getInterval() * 60 * 1000;
    // System.err.println("TCA job run interval is " + interval);
    for (int i = 0; i < tcaMeasurementJobs.size(); i++)
    {
      tcaJob = (TCAMeasurementJob) tcaMeasurementJobs.get(i);
      String triggerName = "" + tcaJob.getTcaJobId();
      String groupName = tcaJob.getNe().name;
      
      SimpleTrigger trigger = new SimpleTrigger(triggerName, groupName, new Date(), null, SimpleTrigger.REPEAT_INDEFINITELY, interval);    
      trigger.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
      
      JobDetail jobDetail = EponTCAJobFactory.generateJobDetail(jobGroup, tcaJob);
      tcaJobScheduler.scheduleJob(jobDetail, trigger);

      tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_SUCCESS);
      retList.add(tcaJobResultFB);
//      log.debug("Create TCA job OK, jobId=" + tcaJob.getTcaJobId());
    }
    return retList;
  }

  public List maintainTCAJob(int operationID, TCAJobGroup jobGroup,
      List tcaMeasurementJobs) throws Exception
  {
//    log.debug("OperationID = " + operationID + ",Job group = " + jobGroup + ", TCA Job lists = " + tcaMeasurementJobs);

    List retList = new ArrayList();
    TCAMeasurementJob tcaJob = null;
    TCAJobResultFeedback tcaJobResultFB = null;
    
    if(operationID == TCACommonResource.SUSPEND)
    {
      for (int i = 0; i < tcaMeasurementJobs.size(); i++)
      {
        tcaJob = (TCAMeasurementJob) tcaMeasurementJobs.get(i);
        String jobGroupName = tcaJob.getNe().name;
//        log.debug("Suspend TCA job ID = " + tcaJob.getTcaJobId());

        tcaJobScheduler.pauseJob("" + tcaJob.getTcaJobId(), jobGroupName);
       
        tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_SUCCESS);
        retList.add(tcaJobResultFB);
      }
    }
    else if(operationID == TCACommonResource.REUSME)
    {
      for (int i = 0; i < tcaMeasurementJobs.size(); i++)
      {
        tcaJob = (TCAMeasurementJob) tcaMeasurementJobs.get(i);
        String jobGroupName = tcaJob.getNe().name;
//        log.debug("Resume TCA job ID = " + tcaJob.getTcaJobId());

        tcaJobScheduler.resumeJob("" + tcaJob.getTcaJobId(), jobGroupName);
        tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_SUCCESS);
        retList.add(tcaJobResultFB);
      }
    }
    else if(operationID == TCACommonResource.MODIFY)
    {
      deleteTCAJob(jobGroup, tcaMeasurementJobs);
      retList = createTCAJob(jobGroup, tcaMeasurementJobs);
    }
    else
    {
//      log.warn("Unknow TCA job maintian operation: " + operationID);
      for (int i = 0; i < tcaMeasurementJobs.size(); i++)
      {
        tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_NO_JOBSLOT_ERROR);
        retList.add(tcaJobResultFB);
      }
    }

    return retList;
  }

  public List deleteTCAJob(TCAJobGroup jobGroup, List tcaMeasurementJobs)
      throws Exception
  {
    List retList = new ArrayList();
    TCAMeasurementJob tcaJob = null;
    TCAJobResultFeedback tcaJobResultFB = null;

    for (int i = 0; i < tcaMeasurementJobs.size(); i++)
    {
      tcaJob = (TCAMeasurementJob) tcaMeasurementJobs.get(i);
      String jobGroupName = tcaJob.getNe().name;
      tcaJobScheduler.deleteJob("" + tcaJob.getTcaJobId(), jobGroupName);
//      log.debug("Delete TCA Job, Job=" + tcaJob.getTcaJobId() + "; NE=" + jobGroupName);
      tcaJobResultFB = new TCAJobResultFeedback(tcaJob, TCACommonResource.JOB_RESULT_SUCCESS);
      retList.add(tcaJobResultFB);
    }

    return retList;
  }
  
  public void deleteAllTCAJobForNe(String neType, String neName, String neVersion)
  {
    try
    {
//      String[] jobNames = tcaJobScheduler.getJobNames(neName);
//      if(jobNames != null)
//      {
//        for(int i = 0; i < jobNames.length; i++)
//        {
//          tcaJobScheduler.deleteJob(jobNames[i], neName);
//        }
//      }
      
      List tcaJobList = tcaAssistant.getTCAMeasurementJobForNe(neType, neName, neVersion);
      if(tcaJobList != null)
      {
//        log.debug("There are " + tcaJobList.size() + " TCA Jobs in NE " + neName);
        tcaAssistant.deleteTCAJobFromJobGroup(null, tcaJobList);
        deleteTCAJob(null, tcaJobList);
      }
      else
      {
//        log.debug("There are no TCA Jobs in NE " + neName);
      }
    }
    catch(Exception e)
    {
//      log.error("Can't delete all the NEs for NE " + neName + ": " + e.getMessage());
        e.printStackTrace();
    }
  }
  
  /**
   * When the server is reboot, EMS need to retrieve all the TCA job from UPM
   * 
   * @throws Exception
   *           Exception thrown by UPM.
   */
  public void initTCAJobList() throws Exception
  {
    List tcaJobGroupList = tcaAssistant.getAllTCAJobGroup();
    if(tcaJobGroupList == null || tcaJobGroupList.size() == 0)
    {
//      log.debug("Init TCA job, get 0 pre-defined TCA job.");
      return;
    }
    
    List runingTcaJobList = null;
    List suspendTcaJobList = null;
    TCAJobGroup oneGroup = null;
//    Iterator listIteator = tcaJobGroupList.iterator();
    for(int i = 0; i < tcaJobGroupList.size(); i++)
    {
      try
      {
        oneGroup = (TCAJobGroup) tcaJobGroupList.get(i);
//        log.info("Get running job group " + oneGroup);

        runingTcaJobList = tcaAssistant.getTCAMeasurementJobForGroup(oneGroup, TCAMeasurementJob.RUNNING);
//        log.debug("Get running TCA job list " + runingTcaJobList.size());
        if(runingTcaJobList.size() > 0)
        {
          createTCAJob(oneGroup, runingTcaJobList);
//          log.debug("Create running TCA job OK.");
        }

        suspendTcaJobList = tcaAssistant.getTCAMeasurementJobForGroup(oneGroup, TCAMeasurementJob.SUSPENDED);
//        log.debug("Get suspend TCA job list " + suspendTcaJobList.size());
        if(suspendTcaJobList.size() > 0)
        {
          createTCAJob(oneGroup, suspendTcaJobList);
          maintainTCAJob(TCACommonResource.SUSPEND, oneGroup, suspendTcaJobList);
//          log.debug("Create suspended TCA job OK.");
        }
      }
      catch (Throwable e)
      {
        e.printStackTrace();
      }
    }
  }
}
