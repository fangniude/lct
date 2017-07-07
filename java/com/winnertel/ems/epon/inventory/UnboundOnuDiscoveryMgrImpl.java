package com.winnertel.ems.epon.inventory;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.snmp.SnmpTargetExt;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.topodb.UWrapperOfTopoAPI;

import java.util.Properties;
import java.util.Vector;

public class UnboundOnuDiscoveryMgrImpl {

  private UnboundOnuMgmtMgrImpl onuMgmtMgr = UnboundOnuMgmtMgrImpl.getInstance();
  private static UnboundOnuDiscoveryMgrImpl mgr = null;
  /**
   * DiscoveryMgr default constructor.
   */
  private UnboundOnuDiscoveryMgrImpl()
  {
  }

  public synchronized static UnboundOnuDiscoveryMgrImpl getInstance()
  {
    try
    {
      if(mgr == null)
      {
        mgr = new UnboundOnuDiscoveryMgrImpl();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return mgr;
  }

  public void init()
  {
    UWrapperOfTopoAPI api = UTopoAPI.getAPI();
    Vector v = null;
    try
    {
      v = api.getNodes();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return;
    }

    for (int i = 0; i < v.size(); i++)
    {
      try
      {
        discover((String)v.get(i));
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
  }

  public void discover(String neName) throws Exception
  {
      UWrapperOfTopoAPI api = UTopoAPI.getAPI();
    Properties neProperty = api.getNodeProperties(neName);

    String neType = neProperty.getProperty("typecategory", "");

    if(neType.equalsIgnoreCase("Gepon"))//Gepon
    {
      String ipAddress = neProperty.getProperty(PropertyConstant.NE_IP_ADDRESS);
      int port = Integer.parseInt(neProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161"));
      String getCommunity = neProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");

      discover(neName, ipAddress, port, getCommunity);
    }
  }

  public void discover(String neName, String ipAddress, int port, String getCommunity) throws Exception
  {
    //ping the NE before retrieving data to reduce the timeout time.
    if(!SnmpUtility.snmpPing(ipAddress, port, getCommunity))
    {
      throw new Exception("The NE is inactive: ip=" + ipAddress + "; port=" + port + "; getCommunity=" + getCommunity);
    }

    String neType = SnmpUtility.getNeType(ipAddress, port, getCommunity);
    String neVersion = SnmpUtility.getNeVersion(neType, ipAddress, port, getCommunity);

    if(neType.equals("BBS4606")) {
        //discovery the unbound ONU in OLT.
        discoveryUnboundOnt(neName, ipAddress, port, getCommunity);
    } else {
        //discovery the unbound ONU in OLT.
        discoveryUnboundOnu(neName, ipAddress, port, getCommunity);
    }
  }

    private void discoveryUnboundOnt(String neName, String ipAddress, int port, String getCommunity) throws Exception {
      SnmpTargetExt target = new SnmpTargetExt(ipAddress, port, getCommunity, "private");

      try
      {
        // retrieve all unbound onu data from NE.
        String[] oidList = {
            //utsDot3UnboundOnuModuleId
            ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.1",
            //utsDot3UnboundOnuPortId
            ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.2",
            //utsDot3UnboundOnuLlid
            ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.3",
            //utsDot3UnboundOnuPonMacAddr
            ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.4"
        };

        Object[][] result = target.getTable(oidList);
        if (result != null)
        {
          for (int i = 0; i < result.length; i++)
          {
            UnboundOnuMOD onu = composeUnboundOnu(result[i]);
            onu.setNeName(neName);

            try
            {
              onuMgmtMgr.synchronize(onu);
            }
            catch(Exception e)
            {
              e.printStackTrace();
            }
          }
        }
      }
      catch (Throwable e)
      {
          e.printStackTrace();
      }
    }

  private void discoveryUnboundOnu(String neName, String ipAddress, int port, String getCommunity) throws Exception {
    SnmpTargetExt target = new SnmpTargetExt(ipAddress, port, getCommunity, "private");

    try
    {
      // retrieve all unbound onu data from NE.
      String[] oidList = {
          //utsDot3UnboundOnuModuleId
          ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.1",
          //utsDot3UnboundOnuPortId
          ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.2",
          //utsDot3UnboundOnuLlid
          ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.3",
          //utsDot3UnboundOnuPonMacAddr
          ".1.3.6.1.4.1.41355.1800.2.3.1.2.2.1.1.4"
      };

      Object[][] result = target.getTable(oidList);
      if (result != null)
      {
        for (int i = 0; i < result.length; i++)
        {
          UnboundOnuMOD onu = composeUnboundOnu(result[i]);
          onu.setNeName(neName);
          
          try
          {
            onuMgmtMgr.synchronize(onu);
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
        }
      }
    }
    catch (Throwable e)
    {
        e.printStackTrace();
    }
  }

  private UnboundOnuMOD composeUnboundOnu(Object[] result) {
    UnboundOnuMOD unbound = new UnboundOnuMOD();

    unbound.setCardId(result[0].toString());
    unbound.setPortId(result[1].toString());
    unbound.setLlId(result[2].toString());
    unbound.setMacAddress(ConfigUtility.OctetToMacAddress(result[3].toString()));

    return unbound;
  }

  public void deleteOnuByNeName(String neName) {
    try
    {
      onuMgmtMgr.deleteOnuByNeName(neName);
    }
    catch (Exception e){
        e.printStackTrace();
    }
  }
}
