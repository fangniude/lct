package com.winnertel.ems.epon.pm.collector.mo;

import java.util.List;
import java.util.ArrayList;

public class NePmJobCenter
{
  ArrayList neJobList = new ArrayList();

  static NePmJobCenter neJobCenter;

  public static synchronized NePmJobCenter getInstance()
  {
    if(neJobCenter == null)
      neJobCenter = new NePmJobCenter();

    return neJobCenter;
  }

  public synchronized List getNePmJobList()
  {
    return (ArrayList)neJobList.clone();
  }

  public synchronized NePmJobInfo getNePmJobInfo(String neName)
  {
    NePmJobInfo jobInfo = null;

    for(int i = 0; i < neJobList.size(); i++)
    {
      NePmJobInfo job = (NePmJobInfo)neJobList.get(i);
      if(job.getNeName().equals(neName))
      {
        jobInfo = job;
        break;
      }
    }
    
    return jobInfo;
  }

  public synchronized void addNePmJobInfo(NePmJobInfo jobInfo)
  {
    for(int i = 0; i < neJobList.size(); i++)
    {
      NePmJobInfo job = (NePmJobInfo)neJobList.get(i);
      if(job.getNeName().equals(jobInfo.getNeName()))
      {
        List jobGroupList = jobInfo.getJobGroupList();
        for(int j = 0; j < jobGroupList.size(); j++)
        {
          String jobGroupId = (String)jobGroupList.get(j);
          job.addJobInfo(jobInfo.getJobId(jobGroupId), jobGroupId, jobInfo.getTable(jobGroupId), jobInfo.getRepeatType(jobGroupId), jobInfo.getItemList(jobGroupId), jobInfo.getInstanceList(jobGroupId));
        }
        return;
      }
    }

    neJobList.add(jobInfo);
  }

  public synchronized void removeNePmJobInfo(String neName, String jobGroup)
  {
    for(int i = 0; i < neJobList.size(); i++)
    {
      NePmJobInfo job = (NePmJobInfo)neJobList.get(i);
      if(job.getNeName().equals(neName))
      {
        job.removeJobInfo(jobGroup);
        //if no job in NE. remove it from list.
        if(job.getJobGroupList().isEmpty())
          neJobList.remove(job);
      }
    }
  }

  public synchronized void removeNePmJobInfo(String neName)
  {
    for(int i = 0; i < neJobList.size(); i++)
    {
      NePmJobInfo job = (NePmJobInfo)neJobList.get(i);
      if(job.getNeName().equals(neName))
      {
        neJobList.remove(job);
      }
    }
  }
}
