package com.winnertel.ems.epon.pm.collector.mo;

import java.util.Calendar;

public class ContinuedRepeatType implements IRepeatType
{
  long startTime = -1;
  int granularity = 15;
//  public DailyRepeatType(int startTime, int endTime)
//  {
//    this.startTime = startTime;
//    this.endTime = endTime;
//  }
//
  public ContinuedRepeatType(long startTime, int granularity)
  {
    this.startTime = startTime;

    if(granularity > 0)
      this.granularity = granularity;
  }

  public boolean contains(int year, int month, int day, int hour, int minute, int second)
  {
    Calendar c = Calendar.getInstance();
    c.set(year, month-1, day, hour, minute, second);

    if((c.getTimeInMillis() >= startTime) && ((hour*60 + minute) % granularity == 0))
      return true;
    else
      return false;
  }

  public int getGranularity()
  {
    return granularity;
  }
}
