package com.winnertel.ems.epon.pm.collector.job.bbs4000;

import com.winnertel.ems.epon.pm.collector.job.EponJobDetailFactory;
import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.server.job.entities.JobUtil;
import org.apache.log4j.Logger;
import org.quartz.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BBS4kThroughputJob implements Job
{
  static Logger log = Logger.getLogger(BBS4kThroughputJob.class.getName());

  int jobId = 0;
  int jobGroup = 0;
  int granularity = 0;
  String neName = null;
  String ip = null;
  int port = 161;
  String getCommunity = "public";
  String mibTable = null;
  String measType = null;
  List measItems = null;
  List measInstances = null;

  public BBS4kThroughputJob()
  {}

  public void execute(JobExecutionContext context) throws JobExecutionException
  {
    JobDetail jobDetail = context.getJobDetail();
    JobDataMap jobDataMap = jobDetail.getJobDataMap();

    jobId = Integer.parseInt(jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_JOB_ID));
    jobGroup = Integer.parseInt(jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_JOBGROUP_ID));
    granularity = Integer.parseInt(jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_JOB_GRANULARITY));
    neName = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_NE_NAME);
    ip = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_NE_IP);
    port = jobDataMap.getInt(EponJobDetailFactory.JOBDETAIL_KEY_NE_SNMP_PORT);
    getCommunity = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_NE_SNMP_GETCOMMUNITY);
    mibTable = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_MEASUREMENT_SET_NAME);
    measType = jobDataMap.getString(EponJobDetailFactory.JOBDETAIL_KEY_MEASUREMENT_TYPE_NAME);
    measItems = (List)jobDataMap.get(EponJobDetailFactory.JOBDETAIL_KEY_ITEM);
    measInstances = (List)jobDataMap.get(EponJobDetailFactory.JOBDETAIL_KEY_INSTANCE);

    PmSnmpTarget snmpTarget = new PmSnmpTarget(ip, port, getCommunity);

    //if the measure instances list is null, retrieve the instances from NE agin.
    if(measInstances == null)
    {
      try
      {
        log.debug("Job[" + jobId + "] on NE[" + ip + "] has no [" + mibTable + "] instances, retrieve the instances.");
        List moList = snmpTarget.getInstanceList(mibTable);
        measInstances = new ArrayList();
        for(int i = 0; i < moList.size(); i++)
        {
          NamePair mo = (NamePair)moList.get(i);
          measInstances.add(mo.name);
        }
        jobDataMap.put(EponJobDetailFactory.JOBDETAIL_KEY_INSTANCE, measInstances);
      }
      catch(Exception e)
      {
        measInstances = null;
        log.debug(this, e);
        log.warn("Job[" + jobId + "] on NE[" + ip + "] can't retrieve the [" + mibTable + "] instances: " + e.getMessage());
      }
    }

    //the measure instances list is still null or empty, doesn't write the data to file.
    if((measInstances == null) ||(measInstances.size() == 0))
    {
      snmpTarget.close();
      log.info("Job[" + jobId + "] on NE[" + ip + "] has 0 measurement instances, doesn't write the data to file.");
      return;
    }

    try
    {
      //initialize measurement items.
      String[] oids = null;
      String[] items = new String[measItems.size()];
      String[][] values = null;

      for(int i = 0; i < measItems.size(); i++)
      {
        NamePair namePair = (NamePair)measItems.get(i);
        items[i] = namePair.displayName;
        log.debug("namePair.displayName of " + mibTable + "=" + items[i]);
      }

      values = new String[measInstances.size()][measItems.size()];

      if(measType.startsWith("OLTThroughput"))
      {
/*
        PON Transmitting Throughput = ( (new utsPonIfExtSysOctetTxOk �C old utsPonIfExtSysOctetTxOk) + (new utsPonIfExtSysFrameTxOk �C old utsPonIfExtSysFrameTxOk) * 20 ) * 8 / (1024 * polling interval).
        PON Receiving Throughput = ( (new utsPonIfExtSysOctetRxOk�C old utsPonIfExtSysOctetRxOk) + (new utsPonIfExtSysFrameRxOk �C old utsPonIfExtSysFrameRxOk) * 20s )  * 8 / (1024 * polling interval).
        PON Transmitting Bandwidth Utilization = PON Transmitting Throughput / 1000000.
        PON Receiving Bandwidth Utilization = PON Receiving Throughput / 1000000.
*/

        for(int i = 0; i < measInstances.size(); i++)
        {
          String[] split = ((String)measInstances.get(i)).split("/");
          String index = new StringBuffer(split[0]).append(".1.").append(split[1]).append(".").append("0").toString();

          oids = new String[]{".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.30." + index, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.31." + index,
                              ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.5." + index, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.6." + index};

          String[] oidValue = snmpTarget.getValues(oids);

          if(oidValue == null || oidValue[0] == null || oidValue[1] == null || oidValue[2] == null || oidValue[3] == null)
          {
            log.error(new StringBuffer("Can't retrieve the data from NE[").append(ip).append("] for ").append(measType).append(".").append(index));
            continue;
          }

          for(int j = 0; j < measItems.size(); j++)
          {
            String item = ((NamePair)measItems.get(j)).displayName;

            if(item.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[0]) + Double.parseDouble(oidValue[2])*20)/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[1]) + Double.parseDouble(oidValue[3])*20)/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[0]) + Double.parseDouble(oidValue[2])*20)/(76800000*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[1]) + Double.parseDouble(oidValue[3])*20)/(76800000*granularity));
          }
        }
      }
      else if(measType.startsWith("ONUThroughput"))
      {
/*
        PON Transmitting Throughput = ( (new utsPonIfExtSysOctetTxOk �C old utsPonIfExtSysOctetTxOk) + (new utsPonIfExtSysFrameTxOk �C old utsPonIfExtSysFrameTxOk) * 20 ) * 8 / (1024 * polling interval).
        PON Receiving Throughput = ( (new utsPonIfExtSysOctetRxOk�C old utsPonIfExtSysOctetRxOk) + (new utsPonIfExtSysFrameRxOk �C old utsPonIfExtSysFrameRxOk) * 20s )  * 8 / (1024 * polling interval).
        PON Transmitting Bandwidth Utilization = PON Transmitting Throughput / utsDot3OnuUpstreamPir.
        PON Receiving Bandwidth Utilization = PON Receiving Throughput / utsDot3OnuDownstreamPir.
*/

        for(int i = 0; i < measInstances.size(); i++)
        {
          String[] split = ((String)measInstances.get(i)).split("/");
          String index = new StringBuffer(split[0]).append(".1.").append(split[1]).append(".").append(split[2]).toString();

          oids = new String[]{".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.30." + index, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.31." + index,
                              ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.5." + index, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.6." + index,
                              ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.5." + index, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.6." + index};

          String[] oidValue = snmpTarget.getValues(oids);

          if(oidValue == null || oidValue[0] == null || oidValue[1] == null || oidValue[2] == null || oidValue[3] == null || oidValue[4] == null || oidValue[5] == null || oidValue[4].equals("") || oidValue[4].equals("0") || oidValue[5].equals("") || oidValue[5].equals("0"))
          {
            log.error(new StringBuffer("The data retrieved from NE[").append(ip).append("] for ").append(measType).append(".").append(index).append(" is invalid."));
            continue;
          }

          for(int j = 0; j < measItems.size(); j++)
          {
            String item = ((NamePair)measItems.get(j)).displayName;

            if(item.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[0]) + Double.parseDouble(oidValue[2])*20)/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[1]) + Double.parseDouble(oidValue[3])*20)/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[0]) + Double.parseDouble(oidValue[2])*20)/(76.8*granularity*Double.parseDouble(oidValue[4])));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
              values[i][j] = "" + ((Double.parseDouble(oidValue[1]) + Double.parseDouble(oidValue[3])*20)/(76.8*granularity*Double.parseDouble(oidValue[5])));
          }
        }
      }
      else
      {
        return;
      }

      writePmFile(items, (String[])measInstances.toArray(new String[0]), values);
    }
    catch (Throwable e)
    {
      log.warn("Job[" + jobId + "] can't get the PM data of measurement type[" + mibTable + "] from NE[" + ip + "]: " + e.getMessage());
//      e.printStackTrace();
    }
    finally
    {
      if(snmpTarget != null) snmpTarget.close();
    }
  }

  void writePmFile(String[] items, String[] indices, String[][] values)
  {
    for(int i = 0; i < values.length; i++)
    {
      for(int j = 0; j < values[i].length; j++)
      {
        if(values[i][j] == null)
        {
          values[i][j] = "0";
        }
      }
    }

    String fileName = null;
    BufferedWriter writer = null;
    try
    {
      Calendar calendar = Calendar.getInstance();

      //write the file.
      SimpleDateFormat dFF = new SimpleDateFormat("yyyyMMddHHmmss");
      SimpleDateFormat dFC = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss.SSS");
      Date currentDate = calendar.getTime();
      String currentTimeF = dFF.format(currentDate);
      String currentTimeC = dFC.format(currentDate);

      StringBuffer sb = new StringBuffer("");
      fileName = sb.append("pmData").append(File.separator).append("PM_1.0_").append(jobGroup).append("_").append(jobId).append("_").append(currentTimeF).append("_").append(granularity).append(".dat").toString();
      writer = new BufferedWriter(new FileWriter(fileName));
      writer.write("N " + neName + "\r\n");
      writer.write("T " + currentTimeC + "\r\n");
      for(int i = 0; i < indices.length; i++)
      {
        if(indices[i].equals("0")) //if the Measurement Set is DHCP, only wirte letter "o".
        {
          writer.write("O\r\n");
        }
        else
        {
          writer.write("O " + indices[i] + "\r\n");
        }

        for(int j = 0; j < items.length; j++)
        {
          writer.write("R " + items[j] + " " + values[i][j] + "\r\n");
        }
      }

      writer.flush();
      writer.close();
      log.info("File " + fileName + " write data OK!");
      JobUtil.setJobDataCollectionTime(jobId, calendar);
    }
    catch (Throwable e)
    {
      log.warn("Job[" + jobId + "] can't write the data to file[" + fileName + "]: " + e.getMessage());
      log.debug(null, e);
//      e.printStackTrace();
    }
    finally
    {
      if(writer != null)
        try
        {
          writer.close();
        }
        catch (IOException e)
        {
//          e.printStackTrace();
        }
      writer = null;
    }
  }
}