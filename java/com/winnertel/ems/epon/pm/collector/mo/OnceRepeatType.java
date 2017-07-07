package com.winnertel.ems.epon.pm.collector.mo;

import java.util.Calendar;

public class OnceRepeatType implements IRepeatType
{
  long startTime = -1;
  long endTime = -1;
  int granularity = 15;

  public OnceRepeatType(long startTime, long endTime, int granularity)
  {
    this.startTime = startTime;
    this.endTime = endTime;
    if(granularity > 0)
      this.granularity = granularity;
  }

  public boolean contains(int year, int month, int day, int hour, int minute, int second)
  {
    Calendar c = Calendar.getInstance();
    c.set(year, month, day, hour, minute, second);

    if((c.getTimeInMillis() >= startTime) && (c.getTimeInMillis() <= endTime) && ((hour*60 + minute) % granularity == 0))
      return true;
    else
      return true;
  }

  public int getGranularity()
  {
    return granularity;
  }
}
