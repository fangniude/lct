package com.winnertel.ems.epon.pm.collector;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.pm.collector.job.EponJobDetailFactory;
import com.winnertel.ems.epon.pm.collector.job.EponTriggerFactory;
import com.winnertel.ems.epon.pm.collector.job.bbs4000.BBS4kStopCollectorJob;
import com.winnertel.ems.epon.pm.collector.mo.ContinuedRepeatType;
import com.winnertel.ems.epon.pm.collector.mo.DailyRepeatType;
import com.winnertel.ems.epon.pm.collector.mo.IRepeatType;
import com.winnertel.ems.epon.pm.collector.mo.NePmJobCenter;
import com.winnertel.ems.epon.pm.collector.mo.NePmJobInfo;
import com.winnertel.ems.epon.pm.collector.mo.OnceRepeatType;
import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.ems.epon.snmp.SnmpTargetExt;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.upm.common.commoninfo.entities.MeasurementItem;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.common.job.entities.JobGroup;
import com.winnertel.inms.upm.common.job.entities.JobOperateResult;
import com.winnertel.inms.upm.common.job.entities.JobStatus;
import com.winnertel.inms.upm.common.job.entities.MeasurementJob;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.entities.RepeatTime;
import com.winnertel.inms.upm.common.job.interfaces.JobInformRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.JobScheduleRemoteIntf;
import com.winnertel.inms.upm.server.collector.dataCollection.NEDataCollectorIntf;
import com.winnertel.inms.upm.server.common.DataCollectorParam;
import com.winnertel.inms.upm.server.exceptions.PmException;
import com.winnertel.inms.upm.server.job.entities.JobUtil;
import com.winnertel.snmp.snmp2.SnmpInt;
import com.winnertel.snmp.snmp2.SnmpString;
import com.winnertel.snmp.snmp2.SnmpVar;
import org.apache.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class BBS4kCollector implements NEDataCollectorIntf
{
  static Logger log = null;

  private String neIp = null;
  private String getCommunity = "public";
  private String writeCommunity = "private";
  private int snmpPort = 161;
  private SchedulerServer scheduler = null;

  public BBS4kCollector()
  {
      scheduler = SchedulerServer.getInstance();
      log = Logger.getLogger(BBS4kCollector.class);
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
      getCommunity = (String)extendInfo.get(PropertyConstant.NE_GET_COMMUNITY);
    }

    //
    if(extendInfo.get(PropertyConstant.NE_WRITE_COMMUNITY) != null)
    {
      writeCommunity = (String)extendInfo.get(PropertyConstant.NE_WRITE_COMMUNITY);
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
    log.debug("getCommunity = " + getCommunity);
    log.debug("writeCommunity = " + writeCommunity);
    log.debug("snmpPort = " + snmpPort);

    //close all the PM counter.
    disableNeCounters();
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

    if(!PmUtil.isNeActive(neIp, snmpPort, getCommunity))
    {
      log.info("Fail to dispatch job[" + jobName + "]: the NE[" + neIp + "] is inactive.");
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "The NE is inactive.");
      return jor;
    }
    log.debug("NE[" + neIp + "] is active.");

    try
    {
      addJob(measJob);
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
    try
    {
      if(opType == JobScheduleRemoteIntf.JOB_OPER_PEND)
      {
        //delete the job.
        deleteJob(measJob);
        log.debug("Suspend the Job[" + jobName + "] successfully.");
      }
      else if(opType == JobScheduleRemoteIntf.JOB_OPER_RESUME)
      {
        try
        {
          addJob(measJob);
          log.debug("Resume the Job[" + jobName + "] successfully.");
        }
        catch(Exception e)
        {
          log.warn("Can't resume the job[" + jobName + "], error occured when the Job was added to scheduler" + e.getMessage());
        }
      }
      else if(opType == JobScheduleRemoteIntf.JOB_OPER_DELETE)
      {
        deleteJob(measJob);
        log.debug("Delete the Job[" + jobName + "] successfully.");
      }
      else
      {
        log.warn("Fail to maintain job[" + jobName + "], unsupported operation: " + opType);
        jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Fail to maintain the job, unsupported operation: " + opType);
        return jor;
      }
    }
    catch (Exception e1)
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

  public JobOperateResult modifyJob(JobGroup jobGroup, MeasurementJob measJob)
  {
    log.debug("Modify job: " + measJob);

    JobOperateResult jor = null;
    try
    {
      modifyJob(measJob);
    }
    catch(Exception e)
    {
      log.error("Can't modify Job[" + measJob.getJobId() + "]: " + e.getMessage());
      log.debug(this, e);
      jor = new JobOperateResult(JobOperateResult.Result_Fail, measJob, "Failed to modify job: " + e.getMessage());
      return jor;
    }
    jor = new JobOperateResult(JobOperateResult.Result_Success, measJob, "Modify job successfully.");
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

    try
    {
      deleteJob(measJob);
      addJob(measJob);
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
    log.debug("syncMO(): EMS doesn't use this method.");
    return new JobOperateResult(JobOperateResult.Result_Success, aJob, "Sync MO job successfully.");
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

  void addJob(MeasurementJob measJob) throws Exception
  {
    String measType = measJob.getJobGroup().getMeasurementType().getNamePair().name;

    if(measType.startsWith("OLTThroughput") || measType.startsWith("ONUThroughput"))
    {
      addJobToCollector(measJob);
    }
    else
    {
      addJobToNe(measJob);
      addJobToCollector(measJob);
    }
  }

  void addJobToNe(MeasurementJob measJob) throws Exception
  {
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();

    int state = measJob.getJobStatus();
    if(state == JobStatus.JOBSTATE_FINISHED)
    {
      log.info("The Job[" + jobName + "] has finished, Can't be added to NE[" + neName + "].");
      return;
    }

    String oid = null;
    JobGroup jobGroup = measJob.getJobGroup();
    String measType = jobGroup.getMeasurementType().getNamePair().name;

    if(measType.startsWith("GEBridgePortData"))     //GE port
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.100.";
    }
    else if(measType.startsWith("PONOLTPortData") || measType.startsWith("PonOnuPortData"))     //OLT, ONU or ONU UNI Port
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.100.";
    }
    else if(measType.startsWith("PonOnuUniPortData"))
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.6.1.201.";
    }
    else if(measType.startsWith("SysMonitorData")) // don't need to enable the pm counters.
    {
      return;
    }
    else if(measType.startsWith("OLTOpticalLinkData")){
    	oid = ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.18.1.100.";
    }
    else if(measType.startsWith("ONUOpticalLinkData")){
    	oid = ".1.3.6.1.4.1.45121.1800.2.5.1.3.1.35.";
    }
    else
    {
      log.info("Invalid Measurement Type: " + measType);
      throw new Exception("Invalid Measurement Type: " + measType);
    }

    // get measurement instance list.
    PmSnmpTarget snmpTarget = new PmSnmpTarget(neIp, snmpPort, getCommunity);
    List measInstances = new ArrayList();
    String mibTable = jobGroup.getMeasurementTypeSetName().name;
    List moList = measJob.getMoList();
    for(int i = 0; i < moList.size(); i++)
    {
      MeasurementObject measObj = (MeasurementObject)moList.get(i);
      //user select the NE as the measurement instance.
      if(measObj.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
      {
        List list = snmpTarget.getInstanceList(mibTable);
        for(int j = 0; j < list.size(); j++)
        {
          NamePair mo = (NamePair)list.get(j);
          measInstances.add(mo.name);
        }
        break;
      }
      else
      {
        measInstances.add(measObj.getName());
      }
    }

    log.debug("Job[" + jobName + "] has " + measInstances.size() + " Measurement Instances.");

    //enable the tftp function.
    if(measType.startsWith("PonOnuUniPortData"))
    {
        boolean b = enableOnuUniCounters(oid, measInstances);
        if(!b)
        {
          //roll back.
          disableOnuUniCounters(oid, measInstances);
          throw new Exception("NE only support 72 Counters.");
        }
    } else {
        boolean b = enableNeCounters(oid, measInstances);
        if(!b)
        {
          //roll back.
          disableNeCounters(oid, measInstances);
          throw new Exception("NE only support 72 Counters.");
        }
    }
  }
  
  
  boolean enableNeCounters(String oid, List indices)
  {
    return setValueToNe(oid, indices, new SnmpInt(1));
  }

  boolean disableNeCounters(String oid, List indices)
  {
    return setValueToNe(oid, indices, new SnmpInt(2));
  }


    boolean enableOnuUniCounters(String oid, List indices)
    {
        //Now only suports 1 UNI in onu
        byte[] b = new byte[5];
        b[0] = 1;
      return setValueToNe(oid, indices, new SnmpString(b));
    }

    boolean disableOnuUniCounters(String oid, List indices)
    {
        //Now only suports 1 UNI in onu
        byte[] b = new byte[5];
      return setValueToNe(oid, indices, new SnmpString(b));
    }

  boolean setValueToNe(String oid, List indices, SnmpVar var)
  {
    //the maximal number of variables set to NE once time.
    int count = 10;
    PmSnmpTarget snmpTarget = new PmSnmpTarget(neIp, snmpPort, getCommunity, writeCommunity);

    for(int i = 0; i < indices.size(); i=i+count)
    {
      String[] oids = null;
      SnmpVar[] values = null;

      //sent
      if(indices.size() - i >= count)
      {
        oids = new String[count];
        values = new SnmpVar[count];
      }
      else
      {
        oids = new String[indices.size() - i];
        values = new SnmpVar[indices.size() - i];
      }

      for(int j = 0; j < oids.length; j++)
      {
        String index = (String)indices.get(i+j);
        String[] split = index.split("/");
        if(split.length > 3) //format: CARD#/OLT#/ONU#/UNI#
        {
          oids[j] = oid + split[0] + ".1." + split[1] + "." + split[2];
        }
        else
        {
          oids[j] = oid + ConfigUtility.generateIfIndex(index);
        }
        
        //utsDot3OltOpmOltDataTable->utsDot3OltOpmPmSwitch
        if(oid.indexOf("1.3.6.1.4.1.7064.1800.2.3.1.1.3.18.1.100")>=0){
        	oids[j] = oid + split[0] +"."+  split[1];
        }
        
        //utsDot3Onu2OpticalTransceiverDiagnosisTable->utsDot3OnuOpticalTransceiverDiagnosisPmSwitch
        if(oid.indexOf("1.3.6.1.4.1.7064.1800.2.5.1.3.1.35")>=0){
        	oids[j] = oid + split[0] + ".1." + split[1] + "." + split[2];
        }
        values[j] = var;
      }
      //
      boolean b = snmpTarget.setValues(oids, values);
      if(!b)
      {
        return false;
      }
    }

    return true;
  }

  void addJobToCollector(MeasurementJob measJob) throws Exception
  {
	  
	String nodeversion= SnmpUtility.getNeTotalVersion(measJob.getNetElement().getNeType(), neIp, snmpPort, getCommunity);
	
    String neName = measJob.getNetElement().getNeName();
    JobGroup jobGroup = measJob.getJobGroup();
    String measType = jobGroup.getMeasurementType().getNamePair().name;

    if(measType.startsWith("OLTThroughput") || measType.startsWith("ONUThroughput"))
    {
      JobDetail jobDetail = EponJobDetailFactory.generateBBS4kJobDetail(neIp, snmpPort, getCommunity, measJob);
      Trigger trigger = EponTriggerFactory.generateTrigger(measJob.getJobGroup(), measJob);
      scheduler.scheduleJob(jobDetail, trigger);
    }
    else
    {
      // get measurement instance list.
      List measInstances = new ArrayList();
      String mibTable = jobGroup.getMeasurementTypeSetName().name;
      List moList = measJob.getMoList();
      for(int i = 0; i < moList.size(); i++)
      {
        MeasurementObject measObj = (MeasurementObject)moList.get(i);
        //user select the NE as the measurement instance.
        if(measObj.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
        {
          PmSnmpTarget snmpTarget = new PmSnmpTarget(neIp, snmpPort, getCommunity);
          List list = snmpTarget.getInstanceList(mibTable);
          for(int j = 0; j < list.size(); j++)
          {
            NamePair mo = (NamePair)list.get(j);
            measInstances.add(mo.name);
          }
          break;
        }
        else
        {
          measInstances.add(measObj.getName());
        }
      }

      //
      NePmJobCenter jobCenter = NePmJobCenter.getInstance();
      NePmJobInfo jobInfo = new NePmJobInfo();
      jobInfo.setNeName(neName);
      jobInfo.setIp(this.neIp);
      jobInfo.setGetCommunity(getCommunity);
      jobInfo.setSnmpPort(snmpPort);
      jobInfo.setNeType(measJob.getNetElement().getNeType());
      
      RepeatTime repeatTime = jobGroup.getRepeatTime();
      IRepeatType repeatType = null;
      if(repeatTime.getRepeatType() == RepeatTime.Job_RepeatType_Continued)
      {
        long time = jobGroup.getBeginTime().getTimeInMillis() - TimeZone.getDefault().getRawOffset();
        repeatType = new ContinuedRepeatType(time, jobGroup.getGranularity());
      }
      else if(repeatTime.getRepeatType() == RepeatTime.Job_RepeatType_Daily)
      {
        long time = jobGroup.getBeginTime().getTimeInMillis() - TimeZone.getDefault().getRawOffset();
        int offset = TimeZone.getDefault().getRawOffset() / 3600000;
        repeatType = new DailyRepeatType(time, jobGroup.getGranularity(), (int)(repeatTime.getStartTime() - offset), (int)(repeatTime.getEndTime() - offset));
      }
      else if(repeatTime.getRepeatType() == RepeatTime.Job_RepeatType_Once)
      {
        int offset = TimeZone.getDefault().getRawOffset() / 3600000;
        repeatType = new OnceRepeatType((int)(repeatTime.getStartTime() - offset), (int)(repeatTime.getEndTime() - offset), jobGroup.getGranularity());

        //set the fire trigger to stop the job.
        String triggerName = neName + "_" + jobGroup.getMeasurementTypeSetName().name + "Stop_Trigger";
        String name = neName + "_" + jobGroup.getMeasurementTypeSetName().name + "Stop_JobDetail";
        Date startDate = new Date(jobGroup.getRepeatTime().getEndTime());

        Trigger trigger = new SimpleTrigger(triggerName, "1", startDate);
        JobDetail jobDetail = new JobDetail(name, "1", BBS4kStopCollectorJob.class);
        JobDataMap dataMap = jobDetail.getJobDataMap();
        dataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_NE_NAME, neName);
        dataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_JOBGROUP_ID, "" + jobGroup.getID());
        dataMap.put("NodeVersion", nodeversion);
        
        scheduler.scheduleJob(jobDetail, trigger);
      }

      //add the collect job info to list.
      List items = new ArrayList();
      for(int i = 0; i < jobGroup.getMeasurementItems().size(); i++)
      {
        MeasurementItem item = (MeasurementItem)jobGroup.getMeasurementItems().get(i);
        items.add(item.getNamePair().name);
      }
      jobInfo.addJobInfo("" + measJob.getJobId(), "" + jobGroup.getID(), measType, repeatType, items, measInstances);
      jobCenter.addNePmJobInfo(jobInfo);
    }
  }

  void modifyJob(MeasurementJob measJob) throws Exception
  {
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();

    int state = measJob.getJobStatus();
    if(state == JobStatus.JOBSTATE_FINISHED)
    {
      log.info("The Job[" + jobName + "] has finished, Can't be modified in NE[" + neName + "].");
      return;
    }

    String oid = null;
    JobGroup jobGroup = measJob.getJobGroup();
    String measType = jobGroup.getMeasurementType().getNamePair().name;

    if(measType.startsWith("OLTThroughput") || measType.startsWith("ONUThroughput"))
    {
      String jobId = "" + measJob.getJobId();
      scheduler.deleteJob(jobId, neName);
      addJob(measJob);
      return;
    }
    if(measType.startsWith("GEBridgePortData"))     //GE port
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.100.";
    }
    else if(measType.startsWith("PONOLTPortData") || measType.startsWith("PonOnuPortData"))     //OLT or ONU
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.100.";
    }
    else if(measType.startsWith("PonOnuUniPortData"))
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.6.1.201.";
    }
    else
    {
      log.info("Invalid Measurement Type: " + measType);
      throw new Exception("Invalid Measurement Type: " + measType);
    }

    // get measurement instance list.
    PmSnmpTarget snmpTarget = new PmSnmpTarget(neIp, snmpPort, getCommunity);
    List measInstances = new ArrayList();
    String mibTable = jobGroup.getMeasurementTypeSetName().name;
    List moList = measJob.getMoList();
    for(int i = 0; i < moList.size(); i++)
    {
      MeasurementObject measObj = (MeasurementObject)moList.get(i);
      //user select the NE as the measurement instance.
      if(measObj.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
      {
        List list = snmpTarget.getInstanceList(mibTable);
        for(int j = 0; j < list.size(); j++)
        {
          NamePair mo = (NamePair)list.get(j);
          measInstances.add(mo.name);
        }
        break;
      }
      else
      {
        measInstances.add(measObj.getName());
      }
    }

    log.debug("Job[" + jobName + "] has " + measInstances.size() + " new Measurement Instances.");

    List addList = new ArrayList();
    List removeList = new ArrayList();


    NePmJobInfo jobInfo = NePmJobCenter.getInstance().getNePmJobInfo(neName);

    if(jobInfo == null)
    {
      throw new Exception("The Job does not exist: " + jobGroup.getID());
    }

    List instanceList = jobInfo.getInstanceList("" + jobGroup.getID());
    if(instanceList != null)
    {
      //check which instances are added.
      for(int i = 0; i < measInstances.size(); i++)
      {
        if(!instanceList.contains(measInstances.get(i)))
        {
          addList.add(measInstances.get(i));
        }
      }

      //check which instances are deleted.
      for(int i = 0; i < instanceList.size(); i++)
      {
        if(!measInstances.contains(instanceList.get(i)))
        {
          removeList.add(instanceList.get(i));
        }
      }
    }

      //enable the tftp function.

    //diable the counters in remove list.
    if(removeList.size() > 0)
    {
        if(measType.startsWith("PonOnuUniPortData"))
        {
            if(disableOnuUniCounters(oid, measInstances))
            {
              //roll back.
//              enableOnuUniCounters(oid, measInstances);
//              throw new Exception("NE only support 72 Counters.");
            }
        } else {
            if(!disableNeCounters(oid, removeList))
            {
              //roll back.
//              enableNeCounters(oid, removeList);
//              throw new Exception("BBS4000 only support 72 Counters.");
            }
        }
    }

    //enable the counters in add list.
    if(addList.size() > 0)
    {
        if(measType.startsWith("PonOnuUniPortData"))
        {
            if(enableOnuUniCounters(oid, measInstances))
            {
              //roll back.
              disableOnuUniCounters(oid, measInstances);
              throw new Exception("NE only support 72 Counters.");
            }
        } else {
            if(!enableNeCounters(oid, addList))
            {
              //roll back.
              disableNeCounters(oid, addList);
              enableNeCounters(oid, removeList);
              throw new Exception("BBS4000 only support 72 Counters.");
            }
        }
    }
    //
    jobInfo.setInstanceList("" + jobGroup.getID(), measInstances);
  }

  void deleteJob(MeasurementJob measJob)
  {
    deleteJobFromCollector(measJob);
    deleteJobFromNe(measJob);
  }

  void deleteAllJobs(String neName)
  {
    try
    {
      String[] jobs = scheduler.getJobNames(neName);
      if(jobs != null)
      {
        for(int i = 0; i < jobs.length; i++)
        {
          scheduler.deleteJob(jobs[i], neName);
        }
      }
    }
    catch(Exception e)
    {
      log.warn("Failed to delete all the SNMP Jobs from NE[" + neName + "].");
    }

    NePmJobCenter.getInstance().removeNePmJobInfo(neName);
    disableNeCounters();
  }

  void deleteJobFromCollector(MeasurementJob measJob)
  {
    String measType = measJob.getJobGroup().getMeasurementTypeName().name;
    if(measType.startsWith("OLTThroughput") || measType.startsWith("ONUThroughput"))
    {
      try
      {
        String jobName = String.valueOf(measJob.getJobId());
        String neName = measJob.getNetElement().getNeName();
        scheduler.deleteJob(jobName, neName);
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      String neName = measJob.getNetElement().getNeName();
      NePmJobCenter.getInstance().removeNePmJobInfo(neName, measJob.getJobGroup().getMeasurementTypeName().name);
    }
  }

  void deleteJobFromNe(MeasurementJob measJob)
  {
    String jobName = String.valueOf(measJob.getJobId());
    String neName = measJob.getNetElement().getNeName();

    int state = measJob.getJobStatus();
    if(state == JobStatus.JOBSTATE_FINISHED)
    {
      log.info("The Job[" + jobName + "] has finished, Can't be added to NE[" + neName + "].");
      return;
    }

    String oid = null;
    JobGroup jobGroup = measJob.getJobGroup();
    String measType = jobGroup.getMeasurementType().getNamePair().name;

    if(measType.startsWith("GEBridgePortData"))     //GE port
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.1.1.1.1.100.";
    }
    else if(measType.startsWith("PONOLTPortData") || measType.startsWith("PonOnuPortData"))     //OLT or ONU
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.100.";
    }
    else if(measType.startsWith("PonOnuUniPortData"))
    {
      oid = ".1.3.6.1.4.1.45121.1800.4.2.1.1.6.1.201.";
    }
    else
    {
      return;
    }

    try
    {
      // get measurement instance list.
      PmSnmpTarget snmpTarget = new PmSnmpTarget(neIp, snmpPort, getCommunity);
      List measInstances = new ArrayList();
      String mibTable = jobGroup.getMeasurementTypeSetName().name;
      List moList = measJob.getMoList();
      for(int i = 0; i < moList.size(); i++)
      {
        MeasurementObject measObj = (MeasurementObject)moList.get(i);
        //user select the NE as the measurement instance.
        if(measObj.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
        {
          List list = snmpTarget.getInstanceList(mibTable);
          for(int j = 0; j < list.size(); j++)
          {
            NamePair mo = (NamePair)list.get(j);
            measInstances.add(mo.name);
          }
          break;
        }
        else
        {
          measInstances.add(measObj.getName());
        }
      }

      //
      disableNeCounters(oid, measInstances);
    }
    catch(Exception e)
    {
      log.error("Can't disable the PM Counters: " + e.getMessage());
      log.debug(this, e);
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
        measJob.getNetElement().setNeType(neType);
        try
        {
          if(measJob.getJobStatus() == JobStatus.JOBSTATE_MEASURING)
          {
            addJob(measJob);
            log.debug("Discovery the Job[" + measJob.getJobId() + "] from NE[" + neName + "] successfully.");
          }
          else
          {
            log.debug("The Job[" + measJob.getJobId() + "] is not running, don't add it to NE.");
          }
        }
        catch (Throwable e)
        {
          e.printStackTrace();
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
        deleteAllJobs(neName);
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

      deleteAllJobs(neName);

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
            addJobToCollector(measJob);
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

      deleteAllJobs(neName);
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
        String writeCommunity = (String)extendInfo.get(PropertyConstant.NE_WRITE_COMMUNITY);

        log.debug("The new IP address is " + ipAddress);
        log.debug("The new snmp port is " + snmpPortStr);
        log.debug("The new getCommunity is " + getCommunity);
        log.debug("The new writeCommunity is " + writeCommunity);

        if(ipAddress != null)
          neIp = ipAddress;

        if(snmpPortStr != null)
          snmpPort = Integer.parseInt(snmpPortStr);

        if(getCommunity != null)
          this.getCommunity = getCommunity;

        if(writeCommunity != null)
          this.writeCommunity = writeCommunity;
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

  void disableNeCounters()
  {
    try
    {
      SnmpTargetExt target = new SnmpTargetExt(neIp, snmpPort, getCommunity, writeCommunity);

      //disable the TFTP PM on NE.
      target.setValue(".1.3.6.1.4.1.45121.1800.4.4.1.2.0", new SnmpInt(2));
    }
    catch(Exception e)
    {
      log.error("Cannot reset the statistic counters: " + e.getMessage());
      log.debug(null, e);
    }
  }
}
