package com.winnertel.ems.epon.pm.collector.job.bbs4000;

import com.winnertel.ems.epon.pm.collector.mo.PmDataHeader;
import com.winnertel.ems.epon.pm.collector.mo.PmRowData;
import com.winnertel.ems.epon.pm.collector.parser.IPmFileWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class BBS4kPmDataParser
{
  String curTag = "";

  PmDataHeader dataHeader = null;
  List dataList = new ArrayList();

  IPmFileWriter fileWriter = null;

  public void setPmFileWriter(IPmFileWriter fileWriter)
  {
    this.fileWriter = fileWriter;
  }

  public void parser(String fileName) throws IOException
  {
    if(fileName.endsWith(".gz"))
    {
      parser(new GZIPInputStream(new FileInputStream(fileName)));
    }
    else
    {
      parser(new FileInputStream(fileName));
    }
  }

  public void parser(InputStream in) throws IOException
  {
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String line = null;

      while((line = br.readLine()) != null)
      {
        line = line.trim();
        if(line.startsWith("#table"))
        {
        }
        else if(line.startsWith("#header"))
        {
          parseHeader(line);
        }
        else if(line.startsWith("#dataset"))
        {
          parseDataSet(line);
        }
        else if(line.startsWith("suspect"))
        {
          parseSuspect(line);
        }
        else if(line.startsWith("#period"))
        {
          curTag = "#period";

          parsePeriod(line);
        }
        else if(line.startsWith("#endperiod"))
        {
          fireWriteFile();
        }
        else
        {
          if(line.startsWith("#"))
          {
            curTag = "";
//          System.out.println("This Tag is not used: " + line);
          }
          else
          {
            if(curTag.equals("#period"))
            {
              parseRowData(line);
            }
          }
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      in.close();
    }
//    in.read();
  }

  protected void parseHeader(String line)
  {
    if(dataHeader != null)
    {
      fireWriteFile();
    }

    dataHeader = new PmDataHeader();

    String[] token = line.split(":");

    int granularity = 0;
    try
    {
      if(token[2].indexOf(" ") != -1)
      {
        granularity = Integer.parseInt(token[2].substring(0, token[2].indexOf(" ")));
      }
      else
      {
        granularity = Integer.parseInt(token[2]);
      }
    }
    catch(NumberFormatException e)
    {
      
    }

    dataHeader.setSetName(token[1].trim());
    dataHeader.setGranularity(granularity);
  }

  protected void parseDataSet(String line)
  {
    String[] token = line.split(":");
    dataHeader.setTableName(token[1].trim());
  }

  protected void parseSuspect(String line)
  {
    String[] token = line.split(":");
    for(int i = 1; i < token.length; i++)
    {
      dataHeader.addColumn(token[i].trim());
    }
  }

  protected void parsePeriod(String line)
  {
    String dataTime = null;
    String[] token = line.split(":");
    if(token[1].indexOf(".") != -1)
    {
      dataTime = token[1].substring(0, token[1].indexOf("."));
    }
    else
    {
      dataTime = token[1];
    }

//    SimpleDateFormat dFF = new SimpleDateFormat("yyyyMMddHHmmss");
//    SimpleDateFormat dFC = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss.SSS");
//    dFF.format(time);
//    Date currentDate = calendar.getTime();
//    String currentTimeF = dFF.format(currentDate);
//    String currentTimeC = dFC.format(currentDate);
    dataHeader.setTime(dataTime);
  }

  protected void parseRowData(String line)
  {
    String[] token = line.split(":");

    PmRowData rowData;
    if(dataHeader.getTableName().equals("SysMonitorData"))
    {
      rowData = new PmRowData(null);
    }
    else
    {
      String instance = token[0].replaceAll("-", "/");
      instance = instance.substring(instance.indexOf("/")+1, instance.length());

      int index = instance.indexOf('[');
      if(index != -1)
      {
        String port = instance.substring(0, index).trim();
        instance = port + "/" + instance.substring(index+1, instance.indexOf(']'));
      }

      rowData = new PmRowData(instance);
    }

    for(int i = 3; i < token.length; i++)
    {
      rowData.addValue(token[i].trim());
    }

    dataList.add(rowData);
  }

  protected void fireWriteFile()
  {
    //write to pm file.
    if(dataList.size() > 0)
    {
      if(fileWriter != null)
      {
        fileWriter.wirte(dataHeader, dataList);
      }
    }

    //clear the data.
    dataList.clear();
  }

  protected void push(String str)
  {
    curTag = str;
  }

  protected String pop()
  {
    return curTag;
  }
}
