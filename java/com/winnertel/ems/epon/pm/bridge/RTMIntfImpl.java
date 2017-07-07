package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponRTMGetDataImpl;
import com.winnertel.inms.upm.common.omcinterface.RealTimeIntf;
import com.winnertel.inms.upm.common.realtime.PMCounters;
import com.winnertel.inms.upm.common.realtime.PMMonitor;
import com.winnertel.util.misc.OperationResult;

import java.util.Map;

public class RTMIntfImpl implements RealTimeIntf
{
  private EponRTMGetDataImpl rtmGetDataImpl = new EponRTMGetDataImpl();

  public RTMIntfImpl()
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
    return rtmGetDataImpl.getValues(counters);
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
    return rtmGetDataImpl.resetCounter(counters, reserved);
  }

  public OperationResult maintainRealtimeMonitor(int operationId, PMMonitor pmMonitor) throws Exception
  {
    return rtmGetDataImpl.maintainRealtimeMonitor(operationId, pmMonitor);
  }
}
