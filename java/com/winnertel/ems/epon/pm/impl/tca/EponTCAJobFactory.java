package com.winnertel.ems.epon.pm.impl.tca;

//import com.utstar.ems.epon.log.EponLogger;
//import com.winnertel.ems.epon.util.LoggerUtility;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.tca.entities.TCAJobGroup;
import com.winnertel.inms.upm.common.tca.entities.TCAMeasurementJob;
import com.winnertel.inms.upm.common.commoninfo.entities.MeasurementItem;

public class EponTCAJobFactory
{
//  static EponLogger log = LoggerUtility.getLogger(EponTCAJobFactory.class);
  //
  public final static String JOBDETAIL_KEY_TCA_JOB_GROUP = "JOBDETAIL_KEY_TCA_JOB_GROUP";
  public final static String JOBDETAIL_KEY_TCA_MEASUREMENT_JOB = "JOBDETAIL_KEY_TCA_MEASUREMENT_JOB";
  public final static String JOBDETAIL_KEY_TCA_JOB_INFO = "JOBDETAIL_KEY_TCA_JOB_INFO";
  public EponTCAJobFactory()
  {}
  
  
  public static JobDetail generateJobDetail(TCAJobGroup jobGroup, TCAMeasurementJob tcaJob)
  {
    EponTCAJobInfo jobInfo = new EponTCAJobInfo();
    
    String mibName = jobGroup.getMeasurementType().getNamePair().name;

    MeasurementItem item = (MeasurementItem)jobGroup.getMeasurementItems().get(0);
    String oid = item.getOID();
    if(!oid.startsWith("."))
    {
      oid = "." + oid;
    }

    MeasurementObject measObj = tcaJob.getTcaMeasurementObject();
//    log.debug("Get TCA measurement MIB = " + mibName + ", oid = " + oid);
    
    String measType = measObj.getMeasurementObjectType();
//    log.debug("Get MeasurementObject type(Instance name):" + measType);
    if(measType.equals(MeasurementObject.Node_Type))
    {
//      log.debug("Instance is NE type, index = 0");
      jobInfo.oid = oid + ".0";
    }
    else if(oid.startsWith(".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1"))
    {
      String[] split = measObj.getName().split("/");

      StringBuffer sb = new StringBuffer(oid);
      sb.append(split[0]).append(".1.").append(split[1]).append(".");

      if(split.length > 2)
      {
        sb.append(split[2]);
      }
      else
      {
        sb.append("0");
      }

      jobInfo.oid = sb.toString();
    }
    else
    {
      jobInfo.oid = oid + "." + PmUtil.generateIfIndex(measObj.getName());
    }
      
//    log.debug("TCA Measurement OID = " + jobInfo.oid);
    
    String measSet = jobGroup.getMeasurementTypeSetName().name;
    if(measSet.startsWith("L2InterfaceStatistics"))
    {
      jobInfo.entityType = "SFP Port";
      jobInfo.entityInstance = "GE" + measObj.getName();
      jobInfo.entity = "NE=" + tcaJob.getNe().name + ";en=TCA;am=" + jobGroup.getMeasurementItem().name + ";id=" + jobInfo.entityInstance;
    }
    else if(measSet.startsWith("OnuInterfaceStatistics"))
    {
      jobInfo.entityType = "ONU Port";
      jobInfo.entityInstance = "ONU" + measObj.getName();
      jobInfo.entity = "NE=" + tcaJob.getNe().name + ";en=TCA;am=" + jobGroup.getMeasurementItem().name + ";id=" + jobInfo.entityInstance;
    }
    else if(measSet.startsWith("OltInterfaceStatistics"))
    {
      jobInfo.entityType = "OLT Port";
      jobInfo.entityInstance = "OLT" + measObj.getName();
      jobInfo.entity = "NE=" + tcaJob.getNe().name + ";en=TCA;am=" + jobGroup.getMeasurementItem().name + ";id=" + jobInfo.entityInstance;
    }
    else
    {
      jobInfo.entityType = "NE";
      jobInfo.entityInstance = "NE=" + tcaJob.getNe().name;
      jobInfo.entity = "NE=" + tcaJob.getNe().name + ";en=TCA;am=" + jobGroup.getMeasurementItem().name + ";id=NE";
    }


    String jobName = "" + tcaJob.getTcaJobId();
    String groupName = tcaJob.getNe().name;
    JobDetail jobDetail = new JobDetail(jobName, groupName, EponTCAJob.class);
    
    JobDataMap dataMap = jobDetail.getJobDataMap();
    dataMap.put(JOBDETAIL_KEY_TCA_JOB_GROUP, jobGroup);
    dataMap.put(JOBDETAIL_KEY_TCA_MEASUREMENT_JOB, tcaJob);
    dataMap.put(JOBDETAIL_KEY_TCA_JOB_INFO, jobInfo);

    return jobDetail;
  }
}