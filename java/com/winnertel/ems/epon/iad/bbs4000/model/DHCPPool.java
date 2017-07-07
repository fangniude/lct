package com.winnertel.ems.epon.iad.bbs4000.model;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolExcludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolIncludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import java.util.Vector;

public class DHCPPool {
  private String poolName = null;
  private IApplication fApplication = null;

  public DHCPPool(IApplication app, String name)
  {
    this.fApplication = app;
    this.poolName = name;
  }

  /**
   * check if the specified ip is used by dhcp.
   * @return
   */
  public boolean isIpReserved(String ip)
  {
    if(isIpIncluded(ip))
    {
      return !isIpExcluded(ip);
    }

    return false;
  }

  /**
   * this method only check if the ip is in the include range of dhcp pool.
   * if you want to check the ip is used by dhcp, please use isIpReserved method.
   * @param ip
   * @return
   */
  public boolean isIpIncluded(String ip)
  {
    DHCPPoolIncludeTableMBean includeBean = new DHCPPoolIncludeTableMBean(fApplication.getSnmpProxy());

    //retrieve the data from specified dhcp pool, but can't stop until reaching the end of the table.
    includeBean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName));
    includeBean.setUtsDHCPPoolIncludedLowIpAddress("0.0.0.0");

    Vector v = BeanService.refreshTableBean(fApplication, includeBean);

    for(int i = 0; v != null && i < v.size(); i++)
    {
      DHCPPoolIncludeTableMBean one = (DHCPPoolIncludeTableMBean)v.get(i);

      if(one.getUtsDHCPPoolName().equals(poolName))
      {
        if(ConfigUtility.checkIPScope(ip, one.getUtsDHCPPoolIncludedLowIpAddress(), one.getUtsDHCPPoolIncludedHighIpAddress()))
        {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * this method only check if the ip is in the exclude range of dhcp pool.
   * if you want to check the ip is used by dhcp, please use isIpReserved method.
   * @param ip
   * @return
   */
  public boolean isIpExcluded(String ip)
  {
    DHCPPoolExcludeTableMBean excludeBean = new DHCPPoolExcludeTableMBean(fApplication.getSnmpProxy());

    //retrieve the data from specified dhcp pool, but can't stop until reaching the end of the table.
    excludeBean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName));
    excludeBean.setUtsDHCPPoolExcludedLowIpAddress("0.0.0.0");

    Vector v = BeanService.refreshTableBean(fApplication, excludeBean);

    for(int i = 0; v != null && i < v.size(); i++)
    {
      DHCPPoolExcludeTableMBean one = (DHCPPoolExcludeTableMBean)v.get(i);

      if(ConfigUtility.checkIPScope(ip, one.getUtsDHCPPoolExcludedLowIpAddress(), one.getUtsDHCPPoolExcludedHighIpAddress()))
      {
        return true;
      }
    }

    return false;
  }

  /**
   * check if the specified IP is in same sub net with dhcp pool.
   * @param ip
   * @return
   */
  public boolean isIpInSameSubnet(String ip)
  {
    DHCPPoolTable dhcpBean = new DHCPPoolTable(fApplication.getSnmpProxy());
    dhcpBean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(poolName));
    BeanService.refreshBean(fApplication, dhcpBean);

    String poolMask = dhcpBean.getUtsDHCPPoolNetworkMask();
    String subnet = ConfigUtility.getSubnetAddress(ip, poolMask);

    return subnet.equals(dhcpBean.getUtsDHCPPoolNetworkAddress());
  }
}
