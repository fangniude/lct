package com.winnertel.ems.epon.pm.collector.job;

import com.winnertel.inms.topodb.UTopoAPI;
import org.apache.log4j.Logger;

import java.util.Properties;

public class CollectorUtil
{
  static Logger log = Logger.getLogger(CollectorUtil.class);
//  static ObjectFactory objFactory = null;
//  static UtilityMgr utilityMgr = null;

  
  public CollectorUtil()
  {}

  /*static ObjectFactory getObjectFactory()
  {
    ObjectFactory objFactory = null;
    try
    {
      String url = "//localhost:1099/epon.ObjectFactory";
      objFactory = (ObjectFactory) Naming.lookup(url);
    }
    catch (Exception e)
    {
      log.warn(null, e) ;
      log.warn("RMI lookup Exception : " + e.getMessage());
    }
    return objFactory;
  }

  static UtilityMgr getUtilityMgr()
  {
    UtilityMgr utilityMgr = null;

    ObjectFactory factory = getObjectFactory();
    if(factory != null)
    {
      try
      {
        // TODO : Here is a big pitfall point!
        utilityMgr = (UtilityMgr) factory.getSystemMgr(-1, "UtilityMgr") ;
//      log.debug("Get the UtilityMgr from EMS.");
      }
      catch (Exception e)
      {
        log.warn(null, e) ;
      }
    }
    else
    {
      log.warn("Can't get the UtilityMgr, because the object factory is null.");
    }
    return utilityMgr ;
  }

  public static String getNEIPAddress(String neName)
  {
    String ip = null;
    try
    {
      UtilityMgr mgr = getUtilityMgr();
      Properties pro = mgr.getNePropertiesByNeName(neName);
      ip = pro.getProperty("ipAddress") ;
//      int neID = mgr.getNeIdByNeName(neName);
//      ip = mgr.getNeIpByNeId(neID);
    }
    catch (Exception e)
    {
      log.warn(null, e);
      log.warn("Error occured while getting NE IP by name : " + e.getMessage());
    }
    return ip;
  }
*/

  public static Properties getNeProperty(String neName)
  {
    Properties pro = null;
    try
    {
//      UtilityMgr mgr = getUtilityMgr();
//      pro = mgr.getNePropertiesByNeName(neName);
        pro = UTopoAPI.getAPI().getNodeProperties( neName );
    }
    catch (Exception e)
    {
      log.warn(null, e);
      log.warn("Error occured while getting NE Property by name : " + e.getMessage());
    }
    return pro;
  }
}
