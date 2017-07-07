package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponTCAJobImpl;
import com.winnertel.inms.upm.common.omcinterface.OMCTCARemoteIntf;
import com.winnertel.inms.upm.common.tca.entities.TCAJobGroup;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class OMCTCARemoteImpl extends UnicastRemoteObject implements
    OMCTCARemoteIntf
{
  private EponTCAJobImpl tcaImpl = new EponTCAJobImpl();

  public OMCTCARemoteImpl() throws RemoteException
  {}

  public List createTCAJob(TCAJobGroup jobGroup, List tcaMeasurementJobs)
      throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = tcaImpl.createTCAJob(jobGroup, tcaMeasurementJobs);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  public List maintainTCAJob(int operationID, TCAJobGroup jobGroup,
      List tcaMeasurementJobs) throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = tcaImpl.maintainTCAJob(operationID, jobGroup, tcaMeasurementJobs);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  public List deleteTCAJob(TCAJobGroup jobGroup, List tcaMeasurementJobs)
      throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = tcaImpl.deleteTCAJob(jobGroup, tcaMeasurementJobs);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }
}
