package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponDnManipulation;
import com.winnertel.inms.upm.common.nbi.intf.DnManipulationRemoteIntf;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

public class DnManipulationRemoteImpl extends UnicastRemoteObject implements
    DnManipulationRemoteIntf
{
  /** epon instance */
  EponDnManipulation eponDnInstance = new EponDnManipulation();

  public DnManipulationRemoteImpl() throws RemoteException
  {}

  public String getLDnByMeasureObject(com.winnertel.inms.upm.common.job.entities.MeasurementObject measurementObject) throws RemoteException
  {
    return null;
    }

  public Map getMeasureObject(List list, com.winnertel.inms.upm.common.job.entities.MeasurementType measurementType) throws RemoteException
  {
    return null;
  }

  /**
   * 
   * @param neName
   *          String
   * @throws java.rmi.RemoteException
   * @return String
   */
  public String getNeUserLabel(String neName) throws RemoteException
  {
    String tmpStr = null;
    try
    {
      tmpStr = eponDnInstance.getNeUserLabel(neName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }

    return tmpStr;
  }

  /**
   * 
   * @param neName
   *          String
   * @throws java.rmi.RemoteException
   * @return String
   */
  public String getNeSwVersion(String neName) throws RemoteException
  {
    String tmpStr = null;
    try
    {
      tmpStr = eponDnInstance.getNeSwVersion(neName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }

    return tmpStr;
  }

  /**
   * 
   * @param neName
   *          String
   * @throws java.rmi.RemoteException
   * @return String
   */
  public String getNeVendorName(String neName) throws RemoteException
  {
    return null;
  }

  public String getNeLDn(String s) throws RemoteException
  {
    return null;
  }
}
