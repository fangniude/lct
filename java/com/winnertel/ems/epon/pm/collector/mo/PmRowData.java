package com.winnertel.ems.epon.pm.collector.mo;

import java.util.List;
import java.util.ArrayList;

public class PmRowData implements IPmRowData
{
  String instance = null;
  String time = null;
  List dataList = new ArrayList();

  public PmRowData(String instance)
  {
    this.instance = instance;
  }

  public String getInstance()
  {
    return instance;
  }

  public int getColumnCount()
  {
    return dataList.size();
  }

  public void addValue(String value)
  {
    dataList.add(value);
  }

  public String getValue(int index)
  {
    return (String)dataList.get(index);
  }
}
