package com.winnertel.ems.epon.iad.bbs1000.gui.specialpanel;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Layer2PortTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;

import java.util.*;

public class LinkAggregationModel
{
  protected ISnmpProxy aSnmpProxy;

  protected Vector portList = new Vector();
  protected Vector lgIdList = new Vector(32);

  public LinkAggregationModel( ISnmpProxy aSnmpProxy )
  {
    this.aSnmpProxy = aSnmpProxy;
  }
  /*
  1. only the GSM port.
  2. only L2 port.
  3. only in a lg.
  */

  /*
  1. getAllL2Port()
     getAllGsmCard()
     filterThePort()
  2. check if its ipAddress is "0.0.0.0".
  3. getAllLg()
     filterThePort()
  */

  public void retrieveForAdd()
  {
    retrieve(null);
  }

  public void retrieveForModify(LinkAggregation bean)
  {
    retrieve(bean);
  }

  /**
   * retrieve all the port list. if the
   * @param lgBean
   */
  private void retrieve(LinkAggregation lgBean)
  {
    portList.clear();
//    category_map.clear();
    lgIdList.clear();
    for(int i = 1; i <= 32; i++)
      lgIdList.add(i + "");

    try
    {
      Vector l2PortList = getL2PortList();

      //filter the ports used by LG, but remain the port used by certain LG.
      Vector lgPortList = getLgPortList();
      if(lgBean != null)
      {
        String[] array = ConfigUtility.portMappingToStringArray(lgBean.getUtsLagExtDot3adAggPortListPorts());
        for(int i = 0; i < array.length; i++)
          lgPortList.remove(array[i]);
      }
      l2PortList = filterLgPort(l2PortList, lgPortList);

      for(int i = 0; i < l2PortList.size(); i++)
      {
        Layer2PortTable bean = (Layer2PortTable)l2PortList.get(i);

        portList.add(bean.getUtsEthIfExtModuleId() + "/" + bean.getUtsEthIfExtPortId());
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * return the link aggregation id which is not used by NE.
   * @return Vector
   */
  public Vector getLgIdList()
  {
    return lgIdList;
  }

  /**
   * return the port list.
   * @return
   */
  public Vector getPortList()
  {
    return portList;
  }

  private Vector getL2PortList() throws Exception
  {
    Layer2PortTable bean = new Layer2PortTable(aSnmpProxy);
    Vector portList = bean.retrieveAll();

    //remove the invalid port.
    int i = 0;
    while(i < portList.size())
    {
      Layer2PortTable port = (Layer2PortTable)portList.get(i);
      //Not Physical Port, or OLT Port.
      if(port.getUtsEthIfExtPortType().intValue() != 1 || port.getUtsEthIfExtModuleId().intValue() != 3) //1-physical port.
        portList.remove(i);
      else
        i++;
    }

    return portList;
  }

  private Vector getLgPortList() throws Exception
  {
    Vector list = new Vector();
    LinkAggregation lg = new LinkAggregation(aSnmpProxy);
    Vector v = lg.retrieveAll();

    if(v != null)
    {
      for(int i = 0; i < v.size(); i++)
      {
        LinkAggregation bean = (LinkAggregation)v.get(i);

        String[] array = ConfigUtility.portMappingToStringArray(bean.getUtsLagExtDot3adAggPortListPorts());

        for(int j = 0; j < array.length; j++)
        {
          list.add(array[j]);
        }

        //remove the lg id used by NE.
        lgIdList.remove("" + bean.getUtsLagExtDot3adAggGroupId());
      }
    }

    return list;
  }

  private Vector filterLgPort(Vector portList, Vector lgPortList)
  {
    for(int i = 0; i < lgPortList.size(); i++)
    {
      String lgPort = (String)lgPortList.get(i);
      int j = 0;
      while(j < portList.size())
      {
        Layer2PortTable ifBean = (Layer2PortTable)portList.get(j);
        String port = ifBean.getUtsEthIfExtModuleId() + "/" + ifBean.getUtsEthIfExtPortId();
        if(port.equals(lgPort))
        {
          portList.remove(j);
        }
        else
        {
          j++;
        }
      }
    }

    return portList;
  }
}
