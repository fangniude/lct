package com.winnertel.ems.epon.pm.collector.mo;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class NePmJobInfo
{
  String neName = null;
  String neType = null;
  String neIp = null;
  String getCommunity="public";
  int snmpPort=161;
  
  List jobGroupList = new ArrayList();
  HashMap jobIdMap = new HashMap();
  HashMap tableMap = new HashMap();
  HashMap itemMap = new HashMap();
  HashMap instanceMap = new HashMap();
  HashMap repeatTypeMap = new HashMap();

  public String getNeName()
  {
    return neName;
  }

  public String getGetCommunity() {
	return getCommunity;
}

public void setGetCommunity(String getCommunity) {
	this.getCommunity = getCommunity;
}

public int getSnmpPort() {
	return snmpPort;
}

public void setSnmpPort(int snmpPort) {
	this.snmpPort = snmpPort;
}

public void setNeName(String neName)
  {
    this.neName = neName;
  }

  public String getNeType() {
      return neType;
  }

  public void setNeType(String type) {
      neType = type;
  }
    
  public String getIp()
  {
    return neIp;
  }

  public void setIp(String ip)
  {
    neIp = ip;
  }

  public void addJobInfo(String jobId, String jobGroupId, String table, IRepeatType type, List itemList, List instanceList)
  {
    jobIdMap.put(jobGroupId, jobId);
    tableMap.put(jobGroupId, table);
    repeatTypeMap.put(jobGroupId, type);
    instanceMap.put(jobGroupId, instanceList);
    itemMap.put(jobGroupId, itemList);

    jobGroupList.add(jobGroupId);
  }

  public List getJobGroupList()
  {
    return jobGroupList;
  }

  public String getJobId(String jobGroup)
  {
    return (String)jobIdMap.get(jobGroup);
  }

  public String getTable(String jobGroup)
  {
    return (String)tableMap.get(jobGroup);
  }

  public List getInstanceList(String jobGroup)
  {
    return (List)instanceMap.get(jobGroup);
  }

  public void setInstanceList(String jobGroup, List instanceList)
  {
    instanceMap.put(jobGroup, instanceList);
  }

  public List getItemList(String jobGroup)
  {
    return (List)itemMap.get(jobGroup);
  }

  public IRepeatType getRepeatType(String jobGroup)
  {
    return (IRepeatType)repeatTypeMap.get(jobGroup);
  }

  public void removeJobInfo(String jobGroup)
  {
    jobIdMap.remove(jobGroup);
    tableMap.remove(jobGroup);
    itemMap.remove(jobGroup);
    instanceMap.remove(jobGroup);
    repeatTypeMap.remove(jobGroup);
  }
}
