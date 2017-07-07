package com.winnertel.ems.epon.pm.impl;

import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.entities.MeasurementType;
import com.winnertel.inms.upm.common.nbi.intf.DnManipulationRemoteIntf;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DnManipulationRemoteImpl implements DnManipulationRemoteIntf {

  public DnManipulationRemoteImpl(){
  }

  /**
   * get ne user label
   *
   * @param neName
   * @return
   * @throws java.rmi.RemoteException
   */
  public String getNeUserLabel(String neName) throws RemoteException {
//    String label = null;
      try {
          return UTopoAPI.getAPI().getByName(neName).getDisplayName();
      } catch ( Exception ex) {
          ex.printStackTrace();
      }
      return neName;


//    Properties neProperty = ServerUtility.getNePropertiesByNeName(neName);
//    if(neProperty != null)
//      label = neProperty.getProperty("userLabel");
//
//    return label != null? label : neName;
  }

  /**
   * get ne software version
   *
   * @param neName
   * @return
   * @throws java.rmi.RemoteException
   */
  public String getNeSwVersion(String neName) throws RemoteException {
    String version = null;
      try {
          version = UTopoAPI.getAPI().getByName(neName).getProperty("version");
      } catch ( Exception ex) {
          ex.printStackTrace();
      }

//    Properties neProperty = ServerUtility.getNePropertiesByNeName(neName);
//    if(neProperty != null)
//      version = neProperty.getProperty("version");

    return version != null? version : "1.0.0";
  }

  /**
   * get ne vendor name
   *
   * @param neName
   * @return
   * @throws java.rmi.RemoteException
   */
  public String getNeVendorName(String neName) throws RemoteException {
    return "utstar.com";
  }

  /**
   * get ne local DN
   *
   * @param neName
   * @return
   * @throws java.rmi.RemoteException
   */
  public String getNeLDn(String neName) throws RemoteException {
    return "ManagedElement=" + neName;
  }

  /**
   * get the corresponding measurement objects
   *
   * @param iocNameList
   * @param mesType
   * @return
   * @throws java.rmi.RemoteException
   */
  public Map getMeasureObject(List iocNameList, MeasurementType mesType) throws RemoteException {
    // omcPMMainRemoteIntfMap = util.getAllOMCPMMainRemoteIntf();
    // "SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1"
    // "SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1,Chassis=Chassis_1"
    // "SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1,Chassis=Chassis_1,Slot=Slot_1"
    // "SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1,Chassis=Chassis_1,Slot=Slot_1,Board=Board_1"
    // "SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1,Chassis=Chassis_1,Slot=Slot_1,Board=Board_1,Port=Port_1"

    if (iocNameList == null) {
      return null;
    }

    Map neMOMap = new HashMap();

    Iterator iocNameListIt = iocNameList.iterator();
    while (iocNameListIt.hasNext()) {
      String iocName = (String) iocNameListIt.next();
      StringTokenizer stk = new StringTokenizer(iocName, ",");
      String neName = null;
      boolean foundManagedElement = false;
      List moPath = new ArrayList();
      while (stk.hasMoreTokens()) {
        String tokenElement = stk.nextToken();
        StringTokenizer subToken = new StringTokenizer(tokenElement, "=");
        if (subToken.countTokens() != 2) {
          return null;
        }

        String moType = subToken.nextToken();
        String moName = subToken.nextToken();
        if (moType.equals("ManagedElement")) {
          neName = moName;
          foundManagedElement = true;
        }

        if (foundManagedElement) {
          moPath.add(moName);
        }
      }

      if (neName == null) {
        return null;
      }

      try {
        EponTopoInfoGet r_intf = new EponTopoInfoGet();
        if (r_intf == null) {
          return null;
        }

        MeasurementObject mo = this.getMOByPath(r_intf, moPath, mesType);

        List moList = r_intf.getAllMeasurementObjects(null, mo, mesType);
        if (moList == null) {
          return null;
        }
        neMOMap.put(neName, moList);
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    return neMOMap;
  }

  private MeasurementObject getMOByPath(EponTopoInfoGet eponTopoInfo, List moPath, MeasurementType measType) {
    try {
      if (moPath == null || eponTopoInfo == null) {
        return null;
      }
      MeasurementObject root = new MeasurementObject(null, "AllNet", "AllNet", MeasurementObject.WholeNetwork_Type, "AllNet");
      MeasurementObject parentMO = root;
      Iterator moPathIt = moPath.iterator();
      MeasurementObject acturalMO = null;
      while (moPathIt.hasNext()) {
        String moName = (String) moPathIt.next();

        List moList = eponTopoInfo.getChildMeasureObjects(null, parentMO, measType);
        if (moList == null || moList.size() == 0) {
          return null;
        }

        acturalMO = null;
        Iterator moListIt = moList.iterator();
        while (moListIt.hasNext()) {
          acturalMO = (MeasurementObject) moListIt.next();
          if (acturalMO.getName().equals(moName)) {
            break;
          }
        }
        acturalMO.setParentMeasurementObject(parentMO);
        parentMO = acturalMO;
      }
      return acturalMO;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * get the local DN of a specific measurement object
   *
   * @param mo
   * @return
   * @throws java.rmi.RemoteException
   */
  public String getLDnByMeasureObject(MeasurementObject mo) throws RemoteException {
    if (mo != null) {
      return mo.getName();
    } else {
      return null;
    }
  }

  public static void main(String args[]) {
    try {
      DnManipulationRemoteImpl dnSimulator = new DnManipulationRemoteImpl();
      String iocName = "DC=a1.companyNN.com,SubNetwork=CountryNN,MeContext=MEC-Gbg-1,ManagedElement=Node_1";

      List iocInstanceList = new ArrayList();
      iocInstanceList.add(iocName);
      MeasurementType measType = new MeasurementType();
      measType.setOmcType("upm");
      measType.setNeType("dummy-AN2000B-100");
      measType.setMesTypeSet("TestBB");
      measType.setMesType("utWapgwProxyPmConn");
      measType.setVersion("2.5.1");
      // measType.set
      Map moMap = dnSimulator.getMeasureObject(iocInstanceList, measType);
      Iterator i = moMap.keySet().iterator();
      while(i.hasNext())
      {
        Object o = i.next();
        System.out.println("Key=" + o + "; Value=" + moMap.get(o));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
