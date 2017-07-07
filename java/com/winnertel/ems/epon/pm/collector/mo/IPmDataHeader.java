package com.winnertel.ems.epon.pm.collector.mo;

public interface IPmDataHeader
{
  public String getSetName();
  public void setSetName(String set);
  public String getTableName();
  public void setTableName(String table);
  public String getTime();
  public void setTime(String time);
  public int getGranularity();
  public void setGranularity(int granularity);

  public void addColumn(String column);
//  public void addColumn(int index, String column);
//  public void addColumn(int index, String column, boolean replaceable);
  public int getColumnCount();

  /**
   * return the specified column index in array, if the column doesn't exist, just return -1.
   * @param column
   * @return column index in array, -1 if the column doesn't exist.
   */
  public int getColumnIndex(String column);
  public String getColumn(int i);
  public String[] getColumns();
}
