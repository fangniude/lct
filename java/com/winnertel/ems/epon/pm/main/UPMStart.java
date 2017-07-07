package com.winnertel.ems.epon.pm.main;


import com.winnertel.ems.epon.pm.bridge.OMCPMMainRemoteImpl;
import com.winnertel.inms.upm.common.omcinterface.OMCPMMainRemoteIntf;
import com.winnertel.nms.common.ULPureServerUtils;
import com.winnertel.nms.util.ULRunProcessInterface;

import java.rmi.Naming;

public class UPMStart implements ULRunProcessInterface
{

  private OMCPMMainRemoteIntf omcProcessAPI = null;

  private static boolean isInitialized = false;

  /**
   * constructor
   */
  public UPMStart()
  {
  }

  public void callMain(String as[])
  {
    omcProcessAPI = OMCPMMainRemoteImpl.getInstance();
    if(omcProcessAPI == null)
    {
      return;
    }
    
    int retries = 30;
    for (int i = 0; i < retries; i++)
    {
      try
      {
        // isBindOK = NmsUtil.bindObjectInRegistry(
        // omcProcessAPI, EponPMConstant.PM_SERVICE_NAME , true);
        Naming.rebind(EponPMConstant.PM_SERVICE_NAME, omcProcessAPI);
        isInitialized = true;
        break;
      }
      catch (Exception e)
      {
        e.printStackTrace();
        continue;
      }
    }
  }

  public void shutDown()
  {
    try
    {
//      if(!ULNmsMainFE.singleJVM)
//      {
        String s = ULPureServerUtils.getRMIURL(EponPMConstant.PM_SERVICE_NAME);
        if(s != null)
        {
          Naming.unbind(s);
        }
//      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public boolean isInitialized()
  {
    return isInitialized;
  }

}
