package com.winnertel.ems.epon.pm.collector.mo;

public interface IRepeatType
{
  public boolean contains(int year, int month, int day, int hour, int minute, int second);
  public int getGranularity();
}
