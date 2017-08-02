package com.winnertel.ems.epon.pm.impl.tca;

import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.ems.fm.FMUtil;
import com.winnertel.ems.fm.alarmdb.AlarmAPI;
import com.winnertel.inms.upm.common.tca.TCAAlarmCenter;
import com.winnertel.inms.upm.common.tca.entities.ExtraInfo;
import com.winnertel.inms.upm.common.tca.entities.TCAAlarm;
import com.winnertel.inms.upm.common.tca.entities.TCACommonResource;
import com.winnertel.inms.upm.common.tca.entities.TCAJobGroup;
import com.winnertel.inms.upm.common.tca.entities.TCAMeasurementJob;
import com.winnertel.inms.upm.server.tca.TCAAssistant;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EponTCAJob implements Job
{
//  static EponLogger log = LoggerUtility.getLogger(EponTCAJob.class.getName());
  String jobId = null;
  TCAJobGroup jobGroup = null;
  TCAMeasurementJob measJob = null;
  EponTCAJobInfo jobInfo = null;
  TCAAssistant tcaJobUtil = new TCAAssistant();
  TCAAlarmCenter alarmCenter = TCAAlarmCenter.getInstance();

  public EponTCAJob()
  {
  }

  public void execute(JobExecutionContext context) throws JobExecutionException
  {
    JobDetail jobDetail = context.getJobDetail();
    JobDataMap jobDataMap = jobDetail.getJobDataMap();
    jobGroup = (TCAJobGroup)jobDataMap.get(EponTCAJobFactory.JOBDETAIL_KEY_TCA_JOB_GROUP);
    measJob = (TCAMeasurementJob)jobDataMap.get(EponTCAJobFactory.JOBDETAIL_KEY_TCA_MEASUREMENT_JOB);
    jobInfo = (EponTCAJobInfo)jobDataMap.get(EponTCAJobFactory.JOBDETAIL_KEY_TCA_JOB_INFO);
    jobId = "" + measJob.getTcaJobId();

    String measValue = null;
    PmSnmpTarget snmpTarget = null; 
    try
    {
      String neIp = PmUtil.getNEIPAddress(measJob.getNe().name);
//      log.debug("Get the NE IP address: " + neIp);
      snmpTarget = new PmSnmpTarget(neIp);
      measValue = snmpTarget.getValue(jobInfo.oid);
    }
    catch (Exception e)
    {
        e.printStackTrace();
//      log.warn("TCA Job [" + jobId + "] can't get oid value:" + e.getMessage());
      return;
    }
//    log.debug("TCA Job [" + jobId + "] original value = " + measValue);
    if(measValue == null || measValue.length() == 0)
    {
      return;
    }

    int granularity = jobGroup.getGranularity();
    String measType = jobGroup.getMeasurementTypeName().name;
    String measItem = jobGroup.getMeasurementItem().name;
    if(measType.equals("OLTThroughput"))
    {
      if(measItem.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
        measValue = "" + Double.parseDouble(measValue)/(7680*granularity);
      else if(measItem.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
        measValue = "" + Double.parseDouble(measValue)/(7680*granularity);
      else if(measItem.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
        measValue = "" + Double.parseDouble(measValue)/(76800000*granularity);
      else if(measItem.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
        measValue = "" + Double.parseDouble(measValue)/(76800000*granularity);
    }
    else if(measType.equals("ONUThroughput"))
    {
/*
        PON Transmitting Throughput = (new utsPonIfExtStatsPonOctetsTxOk ?C old utsPonIfExtStatsPonOctetsTxOk) * 8 / (1024 * polling interval).
        PON Receiving Throughput = (new utsPonIfExtStatsPonOctetsRxOk ?C old utsPonIfExtStatsPonOctetsRxOk)  * 8 / (1024 * polling interval).
        PON Transmitting Bandwidth Utilization = PON Transmitting Throughput / utsDot3DbaSlaUpMaxBandwidth.
        PON Receiving Bandwidth Utilization = PON Receiving Throughput / utsDot3DbaSlaDownMaxBandwidth.
*/
      try
      {
        String index = jobInfo.oid.substring(jobInfo.oid.lastIndexOf(".") + 1, jobInfo.oid.length());
        String oid = ".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.5." + index;
        String bandwidth = snmpTarget.getValue(oid);

        if(measItem.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
          measValue = "" + Double.parseDouble(measValue)/(7680*granularity);
        else if(measItem.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
          measValue = "" + Double.parseDouble(measValue)/(7680*granularity);
        else if(measItem.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
          measValue = "" + Double.parseDouble(measValue)*100/(7680*granularity*Long.parseLong(bandwidth));
        else if(measItem.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
          measValue = "" + Double.parseDouble(measValue)*100/(7680*granularity*Long.parseLong(bandwidth));
      }
      catch(Exception e)
      {
        e.printStackTrace();
        return;
      }
    }

    double tcaValue = 0;
    // assemble the value to send alarm.
    if(this.jobGroup.getSampleType() == TCACommonResource.SAMPLE_ABSOLUTE)
    {
//      log.debug("TCA Job[" + jobId + "] is SAMPLE_ABSOLUTE.");
      tcaValue = Double.parseDouble(measValue);
//      log.debug("TCA Job[" + jobId + "] TCA value = " + tcaValue);
    }
    else if(this.jobGroup.getSampleType() == TCACommonResource.SAMPLE_DELTA)
    {
//      log.debug("TCA Job[" + jobId + "] is SAMPLE_DELTA.");
      if(jobInfo.lastMeasValue != 0)
      {
        tcaValue = Double.parseDouble(measValue) - jobInfo.lastMeasValue;
      }
      
//      log.debug("TCA Job[" + jobId + "] last value = " + jobInfo.lastMeasValue);
//      log.debug("TCA Job[" + jobId + "] current value = " + measValue);
//      log.debug("TCA Job[" + jobId + "] TCA value = " + tcaValue);
      jobInfo.lastMeasValue = Double.parseDouble(measValue);
    }
    else
    {
//      log.debug("TCA Job[" + jobId + "] is SAMPLE_unKnow");
      return;
    }
    
    boolean result = false;
    try
    {
      AlarmAPI alarmApi = (AlarmAPI) FMUtil.getAPI("UTAlarmAPI");
      result = alarmApi.isAlarmExists(jobInfo.entity);
    }
    catch(Exception e)
    {
//      log.error("Can't check whether the TCA alarm exist: " + e.getMessage());
        e.printStackTrace();
    }
    
    //the alarm existed.
    if(result)
    {
//      log.debug("TCA Job[" + jobId + "] has sent severity = " + jobInfo.sendAlarmSeverity + " alarm before.");
      
      int[] rt = alarmCenter.produceTCAAlarmSeverity(this.jobGroup.getThresholdList(), this.jobGroup.getDirection(), jobInfo.sendAlarmSeverity, tcaValue);
      if(rt[0] != 0)
      {
        // send clear alarm
//        log.debug("TCA Job[" + jobId + "] ready send a severity " + rt[0] + " clear alarm.");
        sendTCAAlarm(rt[0], 2, tcaValue);
      }
      else if(rt[1] != 0)
      {
        // send a new alarm
//        log.debug("TCA Job[" + jobId + "] re-send a new severity " + rt[1] + " alarm.");
        sendTCAAlarm(rt[1], 1, tcaValue);
      }
      else
      {
//        log.debug("TCA Job[" + jobId + "] need not to send alarm.");
      }
    }
    else
    {
//      log.debug("TCA Job[" + jobId + "] hasn't sent alarm before.");
      int lastSeverity = alarmCenter.produceTCAAlarmSeverity(this.jobGroup.getThresholdList(), this.jobGroup.getDirection(), tcaValue);
      if(lastSeverity != 0)
      {
        // send a new alarm
//        log.debug("TCA Job[" + jobId + "] ready to send a new serevity " + lastSeverity + " alarm.");
        sendTCAAlarm(lastSeverity, 1, tcaValue);
      }
      else
      {
//        log.debug("TCA Job[" + jobId + "] value is under threshold.");
      }
    }
  }
  
  private void sendTCAAlarm(int severity, int type, double tcaValue)
  {
    TCAAlarm alarm = null;
    String lang = Locale.getDefault().getLanguage();
    //chinese
    if(lang != null && lang.equalsIgnoreCase("Chinese"))
    {
      alarm = createTCAAlarm_zh(severity, type, tcaValue);
    }
    else
    {
      alarm = createTCAAlarm(severity, type, tcaValue);
    }

    try
    {
      PmUtil.getTCAAlarmRemoteIntf().sendTCAAlarm(alarm);
//      log.debug("TCA Job[" + jobId + "] send alarm successfully!");
      updataSeverity(severity, type);
//      log.debug("TCA Job[" + jobId + "] update severity successfully!");
    }
    catch (Exception e)
    {
      e.printStackTrace();
//      log.warn("TCA Job[" + jobId + "] can't send TCA alarm normally!");
      return;
    }
  }

  private TCAAlarm createTCAAlarm_zh(int severity, int type, double tcaValue)
  {
    List alarmInfoList = new ArrayList();

    alarmInfoList.add(new ExtraInfo("alarmId", "EponTCAAlarm"));

//    String strEntity = "NE Name=" + this.neName + "," + tmpPort;

    alarmInfoList.add(new ExtraInfo("entity", jobInfo.entity));
    alarmInfoList.add(new ExtraInfo("entityType", translateEntityType(jobInfo.entityType)));

    alarmInfoList.add(new ExtraInfo("entityInstance", jobInfo.entityInstance));

    alarmInfoList.add(new ExtraInfo("neId", measJob.getNe().name));
    alarmInfoList.add(new ExtraInfo("neType", jobGroup.getNeType().name));
    alarmInfoList.add(new ExtraInfo("probableCause", "?????????"));
//    alarmInfoList.add(new ExtraInfo("specialReason",
//        "The counter " + this.jobGroup.getMeasurementItem().toString() + " crosses the pre-defined threshold"));
    if(type == 1)
    {
      alarmInfoList.add(new ExtraInfo("addInfo", "??????????"));
    }
    else
    {
      alarmInfoList.add(new ExtraInfo("addInfo", "?????????"));
    }

    alarmInfoList.add(new ExtraInfo("domain", "domian..."));
    alarmInfoList.add(new ExtraInfo("source", measJob.getNe().name));
    alarmInfoList.add(new ExtraInfo("category", "qualityOfService"));


    if(type == 1)
    {
      StringBuffer sb = new StringBuffer("???????\"");
      sb.append(this.jobGroup.getMeasurementItem().toString()).append("(")
        .append(this.jobGroup.getMeasurementType().toString())
        .append(")\"???????????????, ?????").append(tcaValue).append(".");
      alarmInfoList.add(new ExtraInfo("message", sb.toString()));
    }
    else
    {
      String clearMsg = "Clear TCA alarm for counter: " + this.jobGroup.getMeasurementType() + " " + this.jobGroup.getMeasurementItem();
      alarmInfoList.add(new ExtraInfo("message", clearMsg));
    }

    alarmInfoList.add(new ExtraInfo("createTime", "" + System.currentTimeMillis()));
    // commented by sz081182
    // alarmInfoList.add(new ExtraInfo("ackTime","ack Time"));
    // alarmInfoList.add(new ExtraInfo("clearTime","clear time"));
    // alarmInfoList.add(new ExtraInfo("ackUser","ack user"));
    alarmInfoList.add(new ExtraInfo("help", "tca alarm help"));
    alarmInfoList.add(new ExtraInfo("severity", "" + severity));
    alarmInfoList.add(new ExtraInfo("previousSeverity", "-1"));
    alarmInfoList.add(new ExtraInfo("seqNo", "0"));
    alarmInfoList.add(new ExtraInfo("primaryKey", "TCA alarm primary key"));
    alarmInfoList.add(new ExtraInfo("flag", "1"));
    alarmInfoList.add(new ExtraInfo("notifyFlag", "" + type));
    Object[] tmpArray = alarmInfoList.toArray();

    ExtraInfo[] info = new ExtraInfo[alarmInfoList.size()];
    System.arraycopy(tmpArray, 0, info, 0, tmpArray.length);
    // info = (ExtraInfo[])alarmInfoList.toArray(info);
    TCAAlarm alarm = new TCAAlarm(info);
//    log.debug("Create a new TCA alarm : " + alarm);
    return alarm;
  }

  private String translateEntityType(String string)
  {
    if(string.equalsIgnoreCase("SFP Port"))
    {
      return "SFP???";
    }
    else if(string.equalsIgnoreCase("ONU Port"))
    {
      return "ONU???";
    }
    else if(string.equalsIgnoreCase("OLT Port"))
    {
      return "OLT???";
    }
    else
     return "???";
  }

  private TCAAlarm createTCAAlarm(int severity, int type, double tcaValue)
  {
    List alarmInfoList = new ArrayList();

    alarmInfoList.add(new ExtraInfo("alarmId", "EponTCAAlarm"));

//    String strEntity = "NE Name=" + this.neName + "," + tmpPort;
    
    alarmInfoList.add(new ExtraInfo("entity", jobInfo.entity));
    alarmInfoList.add(new ExtraInfo("entityType", jobInfo.entityType));

    alarmInfoList.add(new ExtraInfo("entityInstance", jobInfo.entityInstance));

    alarmInfoList.add(new ExtraInfo("neId", measJob.getNe().name));
    alarmInfoList.add(new ExtraInfo("neType", jobGroup.getNeType().name));
    alarmInfoList.add(new ExtraInfo("probableCause", "Performance Threshold Cross"));
//    alarmInfoList.add(new ExtraInfo("specialReason",
//        "The counter " + this.jobGroup.getMeasurementItem().toString() + " crosses the pre-defined threshold"));
    if(type == 1)
    {
      alarmInfoList.add(new ExtraInfo("addInfo", "TCA raised alarm"));
    }
    else
    {
      alarmInfoList.add(new ExtraInfo("addInfo", "TCA clear alarm"));
    }
    
    alarmInfoList.add(new ExtraInfo("domain", "domian..."));
    alarmInfoList.add(new ExtraInfo("source", measJob.getNe().name));
    alarmInfoList.add(new ExtraInfo("category", "qualityOfService"));


    if(type == 1)
    {
      StringBuffer sb = new StringBuffer("The counter ");
      sb.append(this.jobGroup.getMeasurementType().toString()).append(" ")
        .append(this.jobGroup.getMeasurementItem().toString())
        .append(" has crossed the pre-defined threshold; Current value is ").append(tcaValue).append(".");
      alarmInfoList.add(new ExtraInfo("message", sb.toString()));
    }
    else
    {
      String clearMsg = "Clear TCA alarm for counter: " + this.jobGroup.getMeasurementType() + " " + this.jobGroup.getMeasurementItem();
      alarmInfoList.add(new ExtraInfo("message", clearMsg));
    }

    alarmInfoList.add(new ExtraInfo("createTime", "" + System.currentTimeMillis()));
    // commented by sz081182
    // alarmInfoList.add(new ExtraInfo("ackTime","ack Time"));
    // alarmInfoList.add(new ExtraInfo("clearTime","clear time"));
    // alarmInfoList.add(new ExtraInfo("ackUser","ack user"));
    alarmInfoList.add(new ExtraInfo("help", "tca alarm help"));
    alarmInfoList.add(new ExtraInfo("severity", "" + severity));
    alarmInfoList.add(new ExtraInfo("previousSeverity", "-1"));
    alarmInfoList.add(new ExtraInfo("seqNo", "0"));
    alarmInfoList.add(new ExtraInfo("primaryKey", "TCA alarm primary key"));
    alarmInfoList.add(new ExtraInfo("flag", "1"));
    alarmInfoList.add(new ExtraInfo("notifyFlag", "" + type));
    Object[] tmpArray = alarmInfoList.toArray();

    ExtraInfo[] info = new ExtraInfo[alarmInfoList.size()];
    System.arraycopy(tmpArray, 0, info, 0, tmpArray.length);
    // info = (ExtraInfo[])alarmInfoList.toArray(info);
    TCAAlarm alarm = new TCAAlarm(info);
//    log.debug("Create a new TCA alarm : " + alarm);
    return alarm;
  }

  private void updataSeverity(int severity, int type)
  {
    // update alarm severity
    if(type == 2)//send the clear alarm.
    {
      jobInfo.sendAlarmSeverity = -1;
    }
    else
    {
      jobInfo.sendAlarmSeverity = severity;
    }
    
    List jobList = new ArrayList();
    jobList.add(this.measJob);
    try
    {
      tcaJobUtil.updateExistedTCAJob(jobGroup, jobList);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    if(type == 2)
    {
//      log.debug("TCA Job[" + this.measJob.getTcaJobId() + "] remove last alarm severity.");
    }
    else
    {
//      log.debug("TCA Job[" + this.measJob.getTcaJobId() + "] update last alarm severity to " + severity);
    }
  }
}