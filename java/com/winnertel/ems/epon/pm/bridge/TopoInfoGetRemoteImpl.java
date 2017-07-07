package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponTopoInfoGet;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.entities.MeasurementType;
import com.winnertel.inms.upm.common.omcinterface.TopoInfoGetRemoteIntf;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TopoInfoGetRemoteImpl extends UnicastRemoteObject implements
    TopoInfoGetRemoteIntf
{
  EponTopoInfoGet eponTopoinfoGet = new EponTopoInfoGet();

  public TopoInfoGetRemoteImpl() throws RemoteException
  {
  }

  /**
   * 
   * @param userID
   *          String
   * @param parentMeasurementObject
   *          MeasurementObject
   * @param measurementType
   *          MeasurementType
   * @throws java.rmi.RemoteException
   * @return List
   */
  public List getChildMeasureObjects(String userID,
      MeasurementObject parentMeasurementObject, MeasurementType measurementType)
      throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getChildMeasureObjects(userID,
          parentMeasurementObject, measurementType);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  /**
   * 
   * @param userID
   *          String
   * @param nodeList
   *          NE list, added in Version 3.0.3.1
   * @param measurementType
   *          MeasurementType
   * @param measurementObjectType
   *          String
   * @throws java.rmi.RemoteException
   * @return List
   */
  public List getAllPossibleValue(String userID, List nodeList,
      MeasurementType measurementType, String measurementObjectType)
      throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getAllPossibleValue(userID, nodeList,
          measurementType, measurementObjectType);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  /**
   * 
   * @param userID
   *          String
   * @param measurementObject
   *          MeasurementObject
   * @param measurementType
   *          MeasurementType
   * @throws java.rmi.RemoteException
   * @return List
   */
  public List getAllMeasurementObjects(String userID,
      MeasurementObject measurementObject, MeasurementType measurementType)
      throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getAllMeasurementObjects(userID,
          measurementObject, measurementType);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  public MeasurementObject[] getValidMeasurementObject(String userId, MeasurementType measurementType, MeasurementObject[] measurementObjects) throws RemoteException
  {
    MeasurementObject[] rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getValidMeasurementObject(userId,
          measurementType, measurementObjects);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  public List getAllNodes(String userId) throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getAllNodes(userId);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  public List getMeasureObjectsByType(String userId, MeasurementObject measurementObject, MeasurementType measurementType, String moType) throws RemoteException
  {
    List rtnList = null;
    try
    {
      rtnList = eponTopoinfoGet.getMeasureObjectsByType(userId, measurementObject, measurementType, moType);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnList;
  }

  /**
   * 
   * @param userID
   *          String
   * @param measurementObject
   *          MeasurementObject
   * @param measurementType
   *          MeasurementType
   * @throws java.rmi.RemoteException
   * @return String
   */
  public String getDisplayName(String userID,
      MeasurementObject measurementObject, MeasurementType measurementType)
      throws RemoteException
  {
    String rtnStr = null;
    try
    {
      rtnStr = eponTopoinfoGet.getDisplayName(userID, measurementObject,
          measurementType);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
    return rtnStr;
  }



}
