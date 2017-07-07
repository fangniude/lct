// JobScheduleRemoteImpl.java
package com.winnertel.ems.epon.pm.impl;

import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.common.job.entities.CollectionProperty;
import com.winnertel.inms.upm.common.job.entities.JobGroup;
import com.winnertel.inms.upm.common.omcinterface.JobResultReturn;

import java.util.ArrayList;
import java.util.List;

public class EponJobSchedule
{
//  CommonDebugLog log = new CommonDebugLog(this.getClass().getName());

  public EponJobSchedule()
  {
  }

  public List addJob(JobGroup jobGroup, List measurementJobList,
      CollectionProperty collectionProperty) throws Exception
  {
    String methodName = "addJob()";
//    log.logStart(methodName);
    System.err.println(methodName + " begin ........");
    List resultList = null;
//    log.logMessage(methodName, CommonDebugLog.LOG_DEBUG, "Job Group : "
//        + jobGroup + ", Measment Job List : " + measurementJobList
//        + ", Collect Properties : " + collectionProperty);

    int agentType = jobGroup.getAgentType();
    if(agentType == 1)
    {
//      log.logMessage(methodName, CommonDebugLog.LOG_DEBUG,
//          "Agent type : Common Agent.");
    }
    else
    {
//      log.logMessage(methodName, CommonDebugLog.LOG_DEBUG,
//          "Agent type : Non-Common Agent.");
    }
    long jobId = jobGroup.getJobGroupId();
//    log.logMessage(methodName, CommonDebugLog.LOG_DEBUG, "Job Group ID : "
//        + jobId);

    NamePair neType = jobGroup.getNeTypeName();

//    log.logMessage(methodName, CommonDebugLog.LOG_DEBUG, "NE type : "
//        + neType.name);

    // resultList.add() ;
    // JobResultReturn jobResult = new JobResultReturn();
    // List returnList = new ArrayList();
    // JobResultReturn jobResultReturn = new JobResultReturn(
    // "nename11",
    // JobResultReturn.JOB_RESULT_SUCCESS);
    // returnList.add(jobResultReturn);
    // jobResultReturn = new JobResultReturn("nename12",
    // JobResultReturn.JOB_RESULT_SUCCESS);
    // returnList.add(jobResultReturn);
    // jobResultReturn = new JobResultReturn("nename21",
    // JobResultReturn.JOB_RESULT_SUCCESS);
    // returnList.add(jobResultReturn);
    // jobResultReturn = new JobResultReturn("nename22",
    // JobResultReturn.JOB_RESULT_SUCCESS);
    // returnList.add(jobResultReturn);
    // System.out.println("add Job completed!");
    //
//    log.logEnd(methodName);
    return resultList;
  }

  public List deleteJob(JobGroup jobGroup, List measurementJobList)
      throws Exception
  {
    String methodName = "deleteJob()";
//    log.logStart(methodName);

    List returnList = new ArrayList();
    JobResultReturn jobResultReturn = new JobResultReturn("nename11",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename12",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename21",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename22",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    System.out.println("delete Job completed!");

//    log.logEnd(methodName);
    return returnList;

  }

  public List suspendJob(JobGroup jobGroup, List measurementJobList)
      throws Exception
  {
    String methodName = "suspendJob()";
//    log.logStart(methodName);
    List returnList = new ArrayList();
    JobResultReturn jobResultReturn = new JobResultReturn("nename11",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename12",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename21",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename22",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    System.out.println("suspend Job completed!");
//    log.logEnd(methodName);
    return returnList;
  }

  public List resumeJob(JobGroup jobGroup, List measurementJobList)
      throws Exception
  {
    String methodName = "resumeJob()";
//    log.logStart(methodName);

    List returnList = new ArrayList();
    JobResultReturn jobResultReturn = new JobResultReturn("nename11",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename12",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename21",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename22",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    System.out.println("resume Job completed!");

//    log.logEnd(methodName);
    return returnList;

  }

  public List changeJobBeginTime(JobGroup jobGroup, List measurementJobList)
      throws Exception
  {
    String methodName = "changeJobBeginTime()";
//    log.logStart(methodName);

    List returnList = new ArrayList();
    JobResultReturn jobResultReturn = new JobResultReturn("nename11",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename12",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename21",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    jobResultReturn = new JobResultReturn("nename22",
        JobResultReturn.JOB_RESULT_SUCCESS);
    returnList.add(jobResultReturn);
    System.out.println("change time completed!");

//    log.logEnd(methodName);
    return returnList;
  }
}
