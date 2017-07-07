package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponCollectionSchedule;
import com.winnertel.inms.upm.common.job.entities.CollectionProperty;
import com.winnertel.inms.upm.common.job.entities.FtpProperty;
import com.winnertel.inms.upm.common.job.entities.OmcParamWrapper;
import com.winnertel.inms.upm.common.omcinterface.CollectionScheduleRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.CollectionScheduleResult;
import com.winnertel.inms.upm.common.omcinterface.OidInMeasurementType;
import com.winnertel.inms.upm.common.util.PmException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CollectionScheduleRemoteImpl extends UnicastRemoteObject implements
    CollectionScheduleRemoteIntf
{
  EponCollectionSchedule eponCollectSchedule = new EponCollectionSchedule();

  public CollectionScheduleRemoteImpl() throws RemoteException
  {
  }

  /**
   * 
   * @param omcParamWrapper
   *          OmcParamWrapper
   * @param oidInMeasurementType
   *          OidInMeasurementType
   * @param ftpProperty
   *          FtpProperty
   * @param collectionProperty
   *          CollectionProperty
   * @param lastAccessTime
   *          String
   * @throws java.rmi.RemoteException
   * @throws PmException
   * @return CollectionScheduleResult
   */
  public CollectionScheduleResult startCollection(OmcParamWrapper omcParamWrapper,
      OidInMeasurementType oidInMeasurementType, FtpProperty ftpProperty,
      CollectionProperty collectionProperty, String lastAccessTime)
      throws RemoteException, PmException
  {
    CollectionScheduleResult result = null;
    try
    {
      result = eponCollectSchedule
          .startCollection(omcParamWrapper, oidInMeasurementType, ftpProperty,
              collectionProperty, lastAccessTime);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }

    return result;
  }
}
