package com.winnertel.ems.epon.pm.collector.parser;

import com.winnertel.ems.epon.pm.collector.mo.IPmDataHeader;
import com.winnertel.ems.epon.pm.collector.mo.IPmRowData;
import com.winnertel.ems.epon.pm.collector.mo.IRepeatType;
import com.winnertel.ems.epon.pm.collector.mo.NePmJobInfo;
import com.winnertel.inms.upm.server.job.entities.JobUtil;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PmFileWriter implements IPmFileWriter
{
  static Logger log = Logger.getLogger(PmFileWriter.class.getName());
  NePmJobInfo neJobInfo;

  public PmFileWriter()
  {
  }

  public void setNePmJobInfo(NePmJobInfo neJobInfo)
  {
    this.neJobInfo = neJobInfo;
  }

  public void wirte(IPmDataHeader header, List dataList)
  {
    String fileName = null;
    BufferedWriter writer = null;
    String time = header.getTime();
    int year = Integer.parseInt(time.substring(0, 4));
    int month = Integer.parseInt(time.substring(4, 6));
    int day = Integer.parseInt(time.substring(6, 8));
    int hour = Integer.parseInt(time.substring(8, 10));
    int minute = Integer.parseInt(time.substring(10, 12));
    int second = Integer.parseInt(time.substring(12, 14));

    log.debug("Try to write the data into file: " + header.getTableName());
      
    List jobGroup = neJobInfo.getJobGroupList();
    for(int i = 0; i < jobGroup.size(); i++)
    {
      String jobGroupId = (String)jobGroup.get(i);

      String neName = neJobInfo.getNeName();
      String table = neJobInfo.getTable(jobGroupId);

      if(table.startsWith(header.getTableName()))
      {
        String jobId = neJobInfo.getJobId(jobGroupId);
        IRepeatType repeatType = neJobInfo.getRepeatType(jobGroupId);

        List items = neJobInfo.getItemList(jobGroupId);
        List instances = neJobInfo.getInstanceList(jobGroupId);

        if((repeatType != null) && (!repeatType.contains(year, month, day, hour, minute, second)))
        {
          log.debug("Ignore the data because of the invalid time: " + time);
          continue;
        }

        try
        {
          int granularity = repeatType.getGranularity();

          StringBuffer sb = new StringBuffer("");
          fileName = sb.append("pmData").append(File.separator).append("PM_1.0_").append(jobGroupId).append("_").append(jobId).append("_").append(time).append("_").append(granularity).append(".dat").toString();
          writer = new BufferedWriter(new FileWriter(fileName));

          Calendar calendar = Calendar.getInstance();
          calendar.set(year, month-1, day, hour, minute, second);
          SimpleDateFormat dFC = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");

          String pmTime = dFC.format(calendar.getTime()) + ".000";

          writer.write("N " + neName + "\r\n");
          writer.write("T " + pmTime + "\r\n");

          for(int j = 0; j < dataList.size(); j++)
          {
            IPmRowData rowData = (IPmRowData)dataList.get(j);
            String instance = rowData.getInstance();

            if(instance == null)
            {
              writer.write("O" + "\r\n");
            }
            else if(instances.contains(instance))
            {
              writer.write("O " + instance + "\r\n");
            }
            else
            {
              log.debug("The Instance [" + instance + "] is not contained in Selected Instance List: " + instances);
              continue;
            }
            
            for(int k = 0; k < items.size(); k++)
            {
              int index = header.getColumnIndex((String)items.get(k));
              if(index >= 0)
              {
                writer.write("R " + items.get(k) + " " + rowData.getValue(index) + "\r\n");
              }
            }

          }

          writer.flush();
          writer.close();
          log.info("File " + fileName + " write data OK!");

          JobUtil.setJobDataCollectionTime(Long.parseLong(jobId), calendar);
        }
        catch (Exception e)
        {
          log.warn("Job[" + jobId + "] can't write the data to file[" + fileName + "]: " + e.getMessage());
          e.printStackTrace();
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
  }
}
