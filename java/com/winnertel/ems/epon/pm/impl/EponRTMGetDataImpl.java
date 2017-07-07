package com.winnertel.ems.epon.pm.impl;

import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.inms.upm.common.realtime.PMCounters;
import com.winnertel.inms.upm.common.realtime.PMMonitor;
import com.winnertel.inms.upm.common.realtime.PMOidInstance;
import com.winnertel.inms.upm.common.realtime.RealTimeConst;
import com.winnertel.util.misc.OperationResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EponRTMGetDataImpl
{
//  static EponLogger log = LoggerUtility.getLogger(EponRTMGetDataImpl.class);

  public EponRTMGetDataImpl()
  {}

  /**
   * Get realtime values from EMS, one time only for one ne, but can many
   * instance
   * 
   * @param counters
   *          PMCounters
   * @return Map key=PMOidInstance, value=value if null, maybe network error.
   */
  public Map getValues(PMCounters counters)
  {
    Map rtnMap = new HashMap();

    String neName = counters.getNEName();
    String ip = PmUtil.getNEIPAddress(neName);
//    log.debug("Get NE IP = " + ip);
    PmSnmpTarget snmpTarget = new PmSnmpTarget(ip);

    List oidList = counters.getOidInstanceList();
    PMOidInstance oid = null;
    String value = null;
    String tmpOid = null;
    try
    {
      for (int i = 0; i < oidList.size(); i++)
      {
        oid = (PMOidInstance) oidList.get(i);
        // tmpOid = "." + oid.toString();
        tmpOid = oid.toString();
//        log.debug("OID get from UPM: " + tmpOid);

        if(tmpOid.startsWith(".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1"))
        {
          //format: .1.3.6.1.4.1.41355.1800.4.2.1.1.1.1.84.1/1
          int index = tmpOid.lastIndexOf(".");
          if(index != -1)
          {
            String[] split = tmpOid.substring(index +1).split("/");

            StringBuffer sb = new StringBuffer(tmpOid.substring(0, index+1));
            sb.append(split[0]).append(".1.").append(split[1]).append(".");

            if(split.length > 2)
            {
              sb.append(split[2]);
            }
            else
            {
              sb.append("0");
            }

            tmpOid = sb.toString();
          }
        }
        else
        {
          //format: .1.3.6.1.4.1.41355.1800.4.2.1.1.1.1.84.1/1
          int index = tmpOid.lastIndexOf(".");
          if(index != -1)
          {
            int ifIndex = PmUtil.generateIfIndex(tmpOid.substring(index +1));
            tmpOid = tmpOid.substring(0, index + 1) + ifIndex;
          }
        }
        // tmpOid = this.tempFormatOid(tmpOid);
//        log.debug("Format OID = " + tmpOid);
        value = snmpTarget.getValue(tmpOid);
//        log.debug("OID:" + tmpOid + "=" + value);
        rtnMap.put(oid, value);
      }
    }
    catch (Exception e)
    {
//      log.error(this, e);
        e.printStackTrace();
    }
    snmpTarget.close();
    return rtnMap;
  }

  /**
   * reset counter value by EMS,
   * 
   * @param counters
   *          PMCounters
   * @param reserved
   *          String
   * @return boolean if success return true, else return false
   */
  public boolean resetCounter(PMCounters counters, String reserved)
  {
    //do nothing.
    return true;
  }


  public OperationResult maintainRealtimeMonitor(int operationId, PMMonitor pmMonitor) throws Exception
  {
//    log.debug("maintain realtime monitor: " + pmMonitor + "; operationId=" + operationId);
    if(operationId == RealTimeConst.CHECK_INTERVAL)
    {

    }
    else if(operationId == RealTimeConst.RESET_INTERVAL)
    {

    }
    else
    {
//      log.debug("Unsupported operation: " + operationId);
    }

    OperationResult result = new OperationResult();
    result.setSuccess(true);
    return result;
  }
}
