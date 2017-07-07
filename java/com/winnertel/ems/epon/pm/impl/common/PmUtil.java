package com.winnertel.ems.epon.pm.impl.common;

import com.winnertel.ems.epon.pm.collector.job.CollectorUtil;
import com.winnertel.inms.upm.common.main.interfaces.PMMainProcessRemoteIntf;
import com.winnertel.inms.upm.common.tca.frame.PMTCAAlarmRemoteIntf;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.SnmpOID;

import java.rmi.Naming;
import java.util.Properties;
import java.util.StringTokenizer;

//import com.utstar.ems.epon.log.EponLogger;
//import com.winnertel.ems.epon.util.LoggerUtility;
//import com.winnertel.ems.epon.util.ServerUtility;

public class PmUtil
{
//  static EponLogger log = LoggerUtility.getLogger(PmUtil.class);
  private static final String PM_MAIN = "//127.0.0.1:1099/" + PMMainProcessRemoteIntf.APIName;
  private static final String ALARM_SERVICE = PMTCAAlarmRemoteIntf.SERVICENAME;
  static PMTCAAlarmRemoteIntf alarmIntf = null;

  public PmUtil()
  {}

  public static PMTCAAlarmRemoteIntf getTCAAlarmRemoteIntf()
  {
    if(alarmIntf == null)
    {
      try
      {
        PMMainProcessRemoteIntf pamMianInf = (PMMainProcessRemoteIntf) Naming.lookup(PM_MAIN);
        alarmIntf = (PMTCAAlarmRemoteIntf) pamMianInf.getRemoteService(ALARM_SERVICE);
      }
      catch (Exception e)
      {
        e.printStackTrace();
//        log.fatal("Can't get the PMTCAAlarmRemoteIntf reference: " + e.getMessage());
      }
    }
    return alarmIntf;
  }

  public static String getNEIPAddress(String neName)
  {
    Properties neProperty = CollectorUtil.getNeProperty(neName);

    if(neProperty != null) {
      return neProperty.getProperty("ipAddress", "");
    }

    return null;
  }

  public static String formatIfIndex(String s)
  {
    String returnStr = null;
    int i = Integer.parseInt(s);

    if(i == 0) return "0"; //

    // bits 28-27, 00 - L2, 01 - L3 VLAN, 10/11 - reserved.
    int highBits = i >>> 27;

    if (highBits == 0)
    {
      // this interface is a port or link aggregation.
      int bits = 67108864; // bit 26
      int bitsAnd = i & bits;
      if (bitsAnd != 0)
      {
        // this is a link aggregation interface.
        bits = 133693440; // bits 26-19
        bitsAnd = i & bits;
        int groupId = (bitsAnd >>> 19) - 128;
        returnStr = "group " + groupId;
      }
      else
      {
        int delta = 1023; // 0-9
        int logicalPort = i & delta;

        i >>= 10;
        delta = 31; // 10-14
        int port = i & delta;

        i >>= 5;
        delta = 15;
        int module = i & delta; // 15-18
        if (logicalPort == 0)
          returnStr = module + "/" + port;
        else
          returnStr = module + "/" + port + "/" + logicalPort;
      }
    }
    else
      if (highBits == 1)
      {
        // this interface is a VLAN.
        int bits = 134184960; // bits 26-15
        int bitsAnd = i & bits;
        int vlanId = bitsAnd >>> 15;
        returnStr = "vlan " + vlanId;
      }
      else
        if ((highBits == 2) || (highBits == 3))
        {
          // reserved for future use.
          returnStr = "unknown";
        }

    return returnStr;
  }

  public static int generateIfIndex(String s)
  {
    int intResult = 0;
    if (s.startsWith("vlan"))
    {
      String temp = s.substring(s.indexOf("vlan") + 5);
      int intTemp = Integer.parseInt(temp);
      intTemp = intTemp << 15;
      intResult = intTemp + 134217728; // bit27
    }
    else
      if (s.startsWith("group"))
      {
        String temp = s.substring(s.indexOf("group") + 6);
        intResult = (Integer.parseInt(temp) + 128) << 19;
      }
      else
      {
        StringTokenizer st = new StringTokenizer(s, "/");
        int[] result = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens())
        {
          result[i] = Integer.parseInt(st.nextToken());
          i++;
        }
        if(result.length == 1) return result[0];
        
        String tempModule = Integer.toBinaryString(result[0]);
        String tempPort = Integer.toBinaryString(result[1]);
        while (tempPort.length() < 5)
        {
          tempPort = "0" + tempPort;
        }
        String tempLogicalPort = "0000000000";
        if (result.length == 3)
        {
          tempLogicalPort = Integer.toBinaryString(result[2]);
          while (tempLogicalPort.length() < 10)
          {
            tempLogicalPort = "0" + tempLogicalPort;
          }
        }
        String tempResult = tempModule + tempPort + tempLogicalPort;
        intResult = Integer.parseInt(tempResult, 2);
      }
    return intResult;
  }

  public static String getIndexDisplayNameByValue(String value,
      String measTypeStr)
  {
    String[] tmpSplit = value.split("/");
    String tmpStr = "/OLT";
    if (measTypeStr.startsWith("L2InterfaceStatistics"))
    {
      tmpStr = "/PORT";
    }

    //
    if (tmpSplit.length == 1)
    {
      return "CARD" + value;
    }
    else if (tmpSplit.length == 2) //format: CARD#/PORT# or CARD#OLT#
    {
      StringBuffer sb = new StringBuffer("CARD");
      return sb.append(tmpSplit[0]).append(tmpStr).append(tmpSplit[1]).toString();
    }
    else if (tmpSplit.length == 3) //format: CARD#/OLT#/ONU#
    {
      StringBuffer sb = new StringBuffer("CARD");
      return sb.append(tmpSplit[0]).append(tmpStr).append(tmpSplit[1]).append("/ONU").append(tmpSplit[2]).toString();
    }
    else if (tmpSplit.length == 4) //format: CARD#/OLT#/ONU#/UNI#
    {
      StringBuffer sb = new StringBuffer("CARD");
      return sb.append(tmpSplit[0]).append(tmpStr).append(tmpSplit[1]).append("/ONU").append(tmpSplit[2]).append("/UNI").append(tmpSplit[3]).toString();
    }
    else
    {
      return value;
    }
  }

  public static boolean isNeActive(String ip)
  {
    return isNeActive(ip, 161, "public");
  }
  
  public static boolean isNeActive(String ip, int port, String getCommunity)
  {
//    log.debug("isNeActive(): Get NE SNMP info: IP =" + ip + ", SNMP port = " + port + "; getCommunity = " + getCommunity);
    SnmpTarget snmptarget = new SnmpTarget();
    snmptarget.setTimeout(1);
    snmptarget.setRetries(0);
    snmptarget.setAttemptPartial(true);

    snmptarget.setTargetHost(ip);
    snmptarget.setCommunity(getCommunity);
    snmptarget.setSnmpOID(new SnmpOID("1.1.0"));
    snmptarget.setTargetPort(port);

    String str = null;

    for (int j = 0; j < 3; j++)
    {
      str = snmptarget.snmpGet();
      if(str == null)
      {
        try
        {
          Thread.sleep(100);
        }
        catch (Throwable e)
        {}
      }
      else
      {
        break;
      }
    }
    snmptarget.releaseResources();
    return str != null;
  }
}
