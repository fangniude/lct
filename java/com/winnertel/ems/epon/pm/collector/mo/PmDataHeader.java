package com.winnertel.ems.epon.pm.collector.mo;

import java.util.List;
import java.util.ArrayList;

public class PmDataHeader implements IPmDataHeader
{
  String setName = null;
  String tableName = null;
  String time = null;
  int granularity = 0;

  List columnList = new ArrayList();

  public String getSetName()
  {
    return setName;
  }

  public void setSetName(String set)
  {
    this.setName = set;
  }

  public String getTableName()
  {
    return tableName;
  }

  public void setTableName(String table)
  {
    tableName = table;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public int getGranularity()
  {
    return granularity;
  }

  public void setGranularity(int granularity)
  {
    this.granularity = granularity;
  }

  public void addColumn(String column)
  {
    columnList.add(column);
  }

  public int getColumnCount()
  {
    return columnList.size();
  }

  public int getColumnIndex(String column)
  {
    return columnList.indexOf(column);
  }

  public String getColumn(int i)
  {
    return (String)columnList.get(i);
  }

  public String[] getColumns()
  {
    return (String[])columnList.toArray(new String[0]);
  }
}
