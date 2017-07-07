package com.winnertel.ems.epon.pm.collector.mo;

public interface IPmRowData
{
//  public IPmDataHeader getDataHeader();
//  public String getName();
  public String getInstance();
  public int getColumnCount();
  public void addValue(String value);
  public String getValue(int index);
//  public String getValue(String column);
}
