package com.winnertel.ems.epon.pm.collector.job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.apache.log4j.Logger;

import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.server.job.entities.JobUtil;

public class EponCollectorJob implements Job
{
  static Logger log = Logger.getLogger(EponCollectorJob.class.getName());
  
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

  public EponCollectorJob()
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
      //DHCP has no instance, using 0. 
      if(mibTable.startsWith("DHCPStatistic"))
      {
        measInstances = new ArrayList();
        measInstances.add("0");
      }
      else//retrieve instances from NE.
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
          log.warn("Job[" + jobId + "] on NE[" + ip + "] can't retrieve the [" + mibTable + "] instances: " + e.getMessage());
        }
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
      String[] indices = null;

      for(int i = 0; i < measItems.size(); i++)
      {
        NamePair namePair = (NamePair)measItems.get(i);
        items[i] = namePair.displayName;
      }

      if(measType.startsWith("OLTThroughput"))
      {
        oids = new String[]{".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.86", ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.87"};
        //retrieve all the data from NE.
        String[][] oidValues = snmpTarget.getTable(oids);
        indices = snmpTarget.getMibIndexes();

/*
        PON Transmitting Throughput = (new utsPonIfExtStatsPonOctetsTxOk �C old utsPonIfExtStatsPonOctetsTxOk) * 8 / (1024 * polling interval).
        PON Receiving Throughput = (new utsPonIfExtStatsPonOctetsRxOk �C old utsPonIfExtStatsPonOctetsRxOk)  * 8 / (1024 * polling interval).
        PON Transmitting Bandwidth Utilization = PON Transmitting Throughput / 1000000.
        PON Receiving Bandwidth Utilization = PON Receiving Throughput / 1000000.
*/

        values = new String[oidValues.length][measItems.size()];
        for(int i = 0; i < oidValues.length; i++)
        {
          for(int j = 0; j < measItems.size(); j++)
          {
            String item = ((NamePair)measItems.get(j)).displayName;

            if(item.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
              values[i][j] = "" + (Double.parseDouble(oidValues[i][0])/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
              values[i][j] = "" + (Double.parseDouble(oidValues[i][1])/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
              values[i][j] = "" + (Double.parseDouble(oidValues[i][0])/(76800000*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
              values[i][j] = "" + (Double.parseDouble(oidValues[i][1])/(76800000*granularity));
          }
        }
      }
      else if(measType.startsWith("ONUThroughput"))
      {
/*
        PON Transmitting Throughput = (new utsPonIfExtStatsPonOctetsTxOk �C old utsPonIfExtStatsPonOctetsTxOk) * 8 / (1024 * polling interval).
        PON Receiving Throughput = (new utsPonIfExtStatsPonOctetsRxOk �C old utsPonIfExtStatsPonOctetsRxOk)  * 8 / (1024 * polling interval).
        PON Transmitting Bandwidth Utilization = PON Transmitting Throughput / utsDot3DbaSlaUpMaxBandwidth.
        PON Receiving Bandwidth Utilization = PON Receiving Throughput / utsDot3DbaSlaDownMaxBandwidth.
*/
        indices = new String[measInstances.size()];
        values = new String[measInstances.size()][measItems.size()];

        for(int i = 0; i < measInstances.size(); i++)
        {
          indices[i] = "" + PmUtil.generateIfIndex((String)measInstances.get(i));

          oids = new String[]{".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.86." + indices[i], ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.87." + indices[i],
                              ".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.5." + indices[i], ".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.27." + indices[i]};

          String[] oidValue = snmpTarget.getValues(oids);

          if(oidValue == null || oidValue[0] == null || oidValue[1] == null || oidValue[2] == null || oidValue[3] == null || oidValue[2].equals("") || oidValue[2].equals("0") || oidValue[3].equals("") || oidValue[3].equals("0"))
          {
            log.error(new StringBuffer("The data retrieved from NE[").append(ip).append("] for ").append(measType).append(".").append(indices[i]).append(" is invalid."));
            continue;
          }

          for(int j = 0; j < measItems.size(); j++)
          {
            String item = ((NamePair)measItems.get(j)).displayName;

            if(item.equals("utsPonIfExtStatsPonOctetsTxThroughput"))
              values[i][j] = "" + (Double.parseDouble(oidValue[0])/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxThroughput"))
              values[i][j] = "" + (Double.parseDouble(oidValue[1])/(7680*granularity));
            else if(item.equals("utsPonIfExtStatsPonOctetsTxUtilization"))
              values[i][j] = "" + (Double.parseDouble(oidValue[0])*100/(7680*granularity*Double.parseDouble(oidValue[2])));
            else if(item.equals("utsPonIfExtStatsPonOctetsRxUtilization"))
              values[i][j] = "" + (Double.parseDouble(oidValue[1])*100/(7680*granularity*Double.parseDouble(oidValue[3])));
          }
        }
      }
      else
      {
        oids = new String[measItems.size()];

        for(int i = 0; i < measItems.size(); i++)
        {
          NamePair namePair = (NamePair)measItems.get(i);
          oids[i] = "." + namePair.name;
        }

        //retrieve all the data from NE.
        values = snmpTarget.getTable(oids);
        indices = snmpTarget.getMibIndexes();
      }

      writePmFile(items, indices, values);
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
        String index = PmUtil.formatIfIndex(indices[i]);
        if(measInstances.contains(index))
        {
          if(index.equals("0")) //if the Measurement Set is DHCP, only wirte letter "o".
          {
            writer.write("O\r\n");
          }
          else
          {
            writer.write("O " + index + "\r\n");
          }

          for(int j = 0; j < items.length; j++)
          {
            writer.write("R " + items[j] + " " + values[i][j] + "\r\n");
          }
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