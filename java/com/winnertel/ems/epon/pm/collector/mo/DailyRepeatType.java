package com.winnertel.ems.epon.pm.collector.mo;

import java.util.Calendar;

public class DailyRepeatType implements IRepeatType
{
  long startTime = -1;
  int granularity = 15;
  int startHour = 0;
  int endHour = 24;

  public DailyRepeatType(long startTime, int granularity, int startHour, int endHour)
  {
    this.startTime = startTime;
    this.granularity = granularity;
    this.startHour = startHour;
    this.endHour = endHour;
  }

  public boolean contains(int year, int month, int day, int hour, int minute, int second)
  {
    Calendar c = Calendar.getInstance();
    c.set(year, month, day, hour, minute, second);

    if((c.getTimeInMillis() >= startTime) && (hour >= startHour) && (hour <= endHour) && ((hour*60 + minute) % granularity == 0))
      return true;
    else
      return true;
  }

  public int getGranularity()
  {
    return granularity;
  }
}
