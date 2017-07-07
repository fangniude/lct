package com.winnertel.ems.epon.pm.impl;

import com.winnertel.ems.epon.pm.collector.SchedulerServer;
import com.winnertel.ems.epon.pm.impl.common.PmSnmpTarget;
import com.winnertel.ems.epon.pm.impl.common.PmUtil;
import com.winnertel.common.inventory.model.Equipment;
import com.winnertel.common.inventory.server.InventoryAPIImpl;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.entities.MeasurementType;
import com.winnertel.nms.securitydb.AuthMgr;
import com.winnertel.nms.securitydb.AuthorizationMgr;
import com.winnertel.nms.topodb.ULNode;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class EponTopoInfoGet
{

  public EponTopoInfoGet()
  {
  }

  
  private List getBoardIndexes(String neName) {
		Properties prop = new Properties();
		prop.put("medn", neName);
		List<Equipment> list = null;
		List<String> result = new LinkedList<String>();
		try {

            list = InventoryAPIImpl
					.getInstance()
					.getInvObjectsByProperties(
							com.winnertel.common.inventory.model.InventoryConstants.INV_TYPE_BOARD,
							prop);
			if (list != null) {
				for (Equipment equip : list) {
                    SchedulerServer InventoryAPIImpl;
//					Board board = ModelConverter.toBoard(equip);
					result.add(equip.getIndex());
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
    
    private Properties getNePropertiesByNeName(String neName) {
        try {
            return UTopoAPI.getAPI().getByName(neName).getProperties();    
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return new Properties();
    }
  
  public List getChildMeasureObjects(String userID,
      MeasurementObject parentMeasObject, MeasurementType measType)
      throws Exception
  {
    if((parentMeasObject == null) || (measType == null))
    {
      return null;
    }

    List rtnList = new ArrayList();
    String neType = measType.getNeType();
    String neVer = measType.getVersion();
    String moType = parentMeasObject.getMeasurementObjectType();
    if(moType.equals(MeasurementObject.WholeNetwork_Type))
    {

      if(userID == null || userID.length() == 0)
      {
        userID = "root";
      }

      rtnList = this.filterNEs(userID, neType, neVer);

      rtnList = sortMeasurementObject(rtnList, "displayName");
      return rtnList;
    }
    else if(moType.equals(MeasurementObject.Node_Type))
    {
        //return the measurement object in OLT.
        if(neType.startsWith("FBW")) {
            String measTypeStr = measType.getMesTypeSet();
            HashMap infoMap = parentMeasObject.getExtendInfo();
            String ip = null;
            String getCommunity = null;
            if(infoMap != null)
            {
              ip = (String)infoMap.get("ipAddress");
              getCommunity = (String)infoMap.get(PropertyConstant.NE_GET_COMMUNITY);
            }
            else
            {
              String neName = parentMeasObject.getName();
              Properties prop = getNePropertiesByNeName(neName);
              ip = prop.getProperty("ipAddress");
              getCommunity = prop.getProperty("community", "public");
            }

//            log.debug("ipAddress = " + ip + "; getCommunity = " + getCommunity);
            PmSnmpTarget snmpTarget = new PmSnmpTarget(ip, 161, getCommunity);

            try
            {
              MeasurementObject neMo = null;
              //if NE has index, retieve the instances list.
              String indexName = snmpTarget.getIndexName(measTypeStr);
              if(indexName != null)
              {
                List<NamePair> moList = snmpTarget.getInstanceList(measTypeStr);
                List indexes = getBoardIndexes(parentMeasObject.getName());
                for(NamePair moNames: moList){
                    String name = moNames.name;
                    if(name.indexOf('/') != -1){
                        if(indexes.contains(name.split("/")[0])){
                            neMo = new MeasurementObject(parentMeasObject, moNames.name, moNames.displayName, indexName, moNames.name);
                              rtnList.add(neMo);
                        }
                    }
                }
              }
            }
            catch(Exception e)
            {
        e.printStackTrace();
//              log.warn("Can't get the instance list of mib[" + measTypeStr + "] from NE[" + ip + "]: "  + e.getMessage());
            }
            finally
            {
              if(snmpTarget != null)
              snmpTarget.close();
            }

            return rtnList;
        }
    }
    else
    {
//      log.warn("Unsupported Measurement Object Type: " + moType);
      return null;
    }

      return null;
  }

  /**
   * Get index display name of index.
   * 
   * @param userID
   *          String
   * @param nodeList
   *          List added since UPM 3031 changed
   * @param measType
   *          MeasurementType
   * @param measObjectType
   *          String
   * @throws Exception
   * @return List
   */
  public List getAllPossibleValue(String userID, List nodeList,
      MeasurementType measType, String measObjectType) throws Exception
  {
//    log.debug("Input: userID=" + userID + ", " + "Node List = " + nodeList + ", " + "MeasurementType=" + measType + "," + "MeasureObjType=" + measObjectType);


    List rtnList = new ArrayList();
    String neName = null;
    NamePair tmpNp = null;

    for(int i = 0; i < nodeList.size(); i++)
    {
      neName = (String)nodeList.get(i);
      if(measObjectType.equals(MeasurementObject.Node_Type))
      {
        // get NE display name
        String displayName = null;
        Properties neProperty = getNePropertiesByNeName(neName);
        if(neProperty != null)
        {
          displayName = neProperty.getProperty(PropertyConstant.NE_LABEL, neName);
        }
        else
        {
          displayName = neName;
        }
        tmpNp = new NamePair(neName, displayName);
        rtnList.add(tmpNp);
      }
      else
      {
        String measTypeStr = measType.getMesTypeSet();
        Properties neProperty = getNePropertiesByNeName(neName);
        String ip = neProperty.getProperty("IPAddress");
        String getCommunity = neProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
        PmSnmpTarget snmpTarget = new PmSnmpTarget(ip, 161, getCommunity);
        
        try
        {
          //if NE has index, retieve the instances list.
          String indexName = snmpTarget.getIndexName(measTypeStr);
          if(indexName != null)
          {
            List moList = snmpTarget.getInstanceList(measTypeStr);
            for(int j = 0; j < moList.size(); j++)
            {
              NamePair namePair = (NamePair)moList.get(j);
              namePair.name = "NENAME=" + neName + "$$" + indexName + "=" + namePair.name;
              rtnList.add(namePair);
            }
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
//          log.warn("Can't get the instance list of mib[" + measTypeStr + "] from NE[" + ip + "]"  + e.getMessage());
        }
        finally
        {
          if(snmpTarget != null)
          snmpTarget.close();
        }
      }
    }
    return rtnList;
  }

  /**
   * No using for only one laye.
   * 
   * @param userID
   *          String
   * @param measObject
   *          MeasurementObject
   * @param measType
   *          MeasurementType
   * @throws Exception
   * @return List
   */
  public List getAllMeasurementObjects(String userID,
      MeasurementObject measObject, MeasurementType measType) throws Exception
  {
//    log.debug("Input: userID=" + userID + ", " + "MeasurementObject=" + measObject + ", " + "MeasurementType=" + measType);

    if((measObject == null) || (measType == null))
    {
//      log.warn("Input parameters is null");
      return null;
    }

    String measTypeStr = measType.getMesTypeSet();

    ArrayList rtnList = new ArrayList();
    String neType = measType.getNeType();
    String neVer = measType.getVersion();
    String moType = measObject.getMeasurementObjectType();
    if(moType.equals(MeasurementObject.WholeNetwork_Type))
    {
      List tmpList = null;
      if(userID == null || userID.equals(""))
      {
        userID = "root";
      }

      tmpList = this.filterNEs(userID, neType, neVer);

      for(int i = 0; i < tmpList.size(); i++)
      {
        Properties nePro = (Properties) tmpList.get(i);
        String neName = nePro.getProperty("name", "");
        
        MeasurementObject neMo = new MeasurementObject(null, neName, neName, MeasurementObject.Node_Type, neName);
        List tmppList = this.getChildMeasureObjects(userID, neMo, measType);
        if(tmppList != null && (tmppList.size() > 0))
        {
          for(int j = 0; j < tmppList.size(); j++)
          {
            rtnList.add(tmppList.get(j));
          }
        }
      }
      return rtnList;
    }
    else if(moType.equals(MeasurementObject.Node_Type))
    {
      if(neType.equalsIgnoreCase("ONU4024i")) {
          for(int i = 1; i <= 24; i++) {
              String name = "" + i;
              String displayName = "PORT " + i;
              MeasurementObject neMo = new MeasurementObject(measObject, name, displayName, "utsUniIfExtIndex", name);
              rtnList.add(neMo);
          }
      } else {
          HashMap infoMap = measObject.getExtendInfo();
          String ip = null;
          String getCommunity = null;
          if(infoMap != null)
          {
            ip = (String)infoMap.get("IPAddress");
            getCommunity = (String)infoMap.get(PropertyConstant.NE_GET_COMMUNITY);
          }
          else
          {
            String neName = measObject.getName();
            Properties prop = getNePropertiesByNeName(neName);
            ip = prop.getProperty("ipAddress");
            getCommunity = prop.getProperty("community", "public");
          }

          PmSnmpTarget snmpTarget = new PmSnmpTarget(ip, 161, getCommunity);
          try
          {
            MeasurementObject neMo = null;

            //if NE has index, retieve the instances list.
            String indexName = snmpTarget.getIndexName(measTypeStr);
            if(indexName != null)
            {
              List moList = snmpTarget.getInstanceList(measTypeStr);
              for(int i = 0; i < moList.size(); i++)
              {
                NamePair mo = (NamePair) moList.get(i);
                neMo = new MeasurementObject(measObject, mo.name, mo.displayName, indexName, mo.name);
                rtnList.add(neMo);
              }
            }
          }
          catch(Exception e)
          {
//            log.warn("Can't get the instance list of mib[" + measTypeStr + "] from NE[" + ip + "]"  + e.getMessage());
              e.printStackTrace();
          }
          finally
          {
            if(snmpTarget != null) snmpTarget.close();
          }
      }

      return rtnList;
    }
    else
    {
      rtnList.add(measObject);
//      log.warn("Unsupported Measurement Object Type: " + moType);
      return rtnList;
    }
  }

  /**
   * Get NE display name or Measurement Object display name.
   * 
   * @param userID
   *          String
   * @param measObject
   *          MeasurementObject
   * @param measType
   *          MeasurementType
   * @throws Exception
   * @return String
   */
  public String getDisplayName(String userID, MeasurementObject measObject,
      MeasurementType measType) throws Exception
  {
//    log.debug("Input: userID=" + userID + ", " + "MeasurementObject=" + measObject + ", " + "MeasurementType=" + measType);
    String rtnStr = null;
    String measTypeStr = measType.getMesTypeSet();
//    log.debug("measObject.getName=" + measObject.getName() + "; displayName=" + measObject.getDisplayName());
    if(measObject.getMeasurementObjectType().equals(MeasurementObject.Node_Type))
    {
      String neName = measObject.getName();
      Properties neProperty = getNePropertiesByNeName(neName);
      if(neProperty != null)
      {
        rtnStr = neProperty.getProperty(PropertyConstant.NE_LABEL, neName);
      }
      else
      {
        rtnStr = neName;
      }
    }
    else if(measObject.getMeasurementObjectType().equals(MeasurementObject.WholeNetwork_Type))
    {
      rtnStr = measObject.getDisplayName();
    }
    else
    {
      String str = measObject.getName();
      rtnStr = PmUtil.getIndexDisplayNameByValue(str, measTypeStr);
    }
//    log.debug("Return display name = " + rtnStr);
    return rtnStr;
  }


  public MeasurementObject[] getValidMeasurementObject(String userId, MeasurementType measurementType, MeasurementObject[] measurementObjects) throws RemoteException
  {
//    log.debug("Input: userId=" + userId + "MeasurementType=" + measurementType);
    return measurementObjects;
  }

  public List getAllNodes(String userId) throws RemoteException
  {
    List rtnList = new ArrayList();
//    log.debug("Input: userID=" + userId);

    if(userId == null || userId.length() == 0)
    {
      userId = "root";
//      log.debug("No user specified, get NE list as root user.");
    }

    rtnList = this.filterNEs(userId, null, null);

    rtnList = sortMeasurementObject(rtnList, "displayName");
    return rtnList;
  }

  public List getMeasureObjectsByType(String userId, MeasurementObject measurementObject, MeasurementType measurementType, String moType) throws RemoteException
  {
//    log.debug("Input: userID=" + userId + ", " + "MeasurementObject=" + measurementObject + ", " + "MeasurementType=" + measurementType);

    if((measurementObject == null) || (measurementType == null))
    {
//      log.warn("Input parameters is null");
      return null;
    }

    String measTypeStr = measurementType.getMesTypeSet();

    ArrayList rtnList = new ArrayList();
    if(moType.equals(MeasurementObject.Node_Type))
    {
      HashMap infoMap = measurementObject.getExtendInfo();
      String ip = null;
      String getCommunity = null;
      if(infoMap != null)
      {
        ip = (String)infoMap.get("IPAddress");
        getCommunity = (String)infoMap.get(PropertyConstant.NE_GET_COMMUNITY);
      }
      else
      {
        String neName = measurementObject.getName();
        Properties prop = getNePropertiesByNeName(neName);
        ip = prop.getProperty("ipAddress");
        getCommunity = prop.getProperty("community", "public");
      }

      PmSnmpTarget snmpTarget = new PmSnmpTarget(ip, 161, getCommunity);
      try
      {
        MeasurementObject neMo = null;

        //if NE has index, retieve the instances list.
        String indexName = snmpTarget.getIndexName(measTypeStr);
        if(indexName != null)
        {
          List moList = snmpTarget.getInstanceList(measTypeStr);
          for(int i = 0; i < moList.size(); i++)
          {
            NamePair mo = (NamePair) moList.get(i);
            neMo = new MeasurementObject(measurementObject, mo.name, mo.displayName, indexName, mo.name);
            rtnList.add(neMo);
          }
        }
      }
      catch(Exception e)
      {
//        log.warn("Can't get the instance list of mib[" + measTypeStr + "] from NE[" + ip + "]"  + e.getMessage());
          e.printStackTrace();
      }
      finally
      {
        if(snmpTarget != null) snmpTarget.close();
      }
    }
    else
    {
//      log.warn("Unsupported Measurement Object Type: " + moType);
    }
    return rtnList;
  }

  private List filterNEs(String userId, String neType, String neVersion)
  {
//    log.debug("Input: userID=" + userId + ", " + "NE type=" + neType + "; NE version=" + neVersion);

    ArrayList rtnList = new ArrayList();
    String url = "rmi://127.0.0.1:1099/AuthMgr";
    if(userId == null || userId.length() == 0)
    {
      userId = "root";
//      log.debug("No user specified, get NE as root user.");
    }
    Vector neV = null;
    try
    {
      AuthMgr rmi = (AuthMgr) Naming.lookup(url);
      AuthorizationMgr am = rmi.getAuthorizationMgrAPI();

      String[] neTypes = null;

      if(neType == null || neType.length() == 0)
      {
        neTypes = new String[]{ "BBS1000", "BBS1000+", "BBS1000p", "BBS4000", "ONU4024i","BBS4606", "FBW5000", "FBW3000", "FBW2000" };
//        log.debug("The NE type is null, using all the Gepon NE types.");
      }
      else
      {
        neTypes = new String[]{ neType };
//        log.debug("get the NE list by userId and neType: " + neType);
      }

      neV = am.getMOList(userId, neTypes, AuthorizationMgr.PRIVILEGE_NOT_CONSIDER);
    }
    catch (Throwable e)
    {
      e.printStackTrace();
//      log.warn(this, e);
      return rtnList;
    }
    if(neV == null)
    {
      neV = new Vector();
    }
    for (int i = 0; i < neV.size(); i++)
    {
      Object o = neV.get(i);
      ULNode nd = (ULNode) o;
      
      Properties pro = nd.getProperties();
      String status = pro.getProperty("status", "2");
      String version = pro.getProperty("swVersion", "");
//      log.debug(" Get one NE : " + nd.getName() + "; NE version: " + version);
      // 1: means normal status. 2: unreachable status, 5, planning status.
      if(status.equals("5"))   //if the NE is planning, don't add it to list.
      {
        continue;
      }

      //only the neVersion is sepecified by user and the NE version does not equal with
      //the version user sepecified, don't add it to list.
      if((neVersion != null) && (!version.equals(neVersion)))
      {
        continue;
      }

//      log.debug("ne Pro = " + pro);

      String neName = nd.getName();
      String displayName = pro.getProperty(PropertyConstant.NE_LABEL, neName);
      MeasurementObject neMo = new MeasurementObject(null, neName, displayName, MeasurementObject.Node_Type, neName);
      neMo.setDisplayName(displayName);

      HashMap map = new HashMap();
      map.put(PropertyConstant.NE_IP_ADDRESS, pro.getProperty(PropertyConstant.NE_IP_ADDRESS));
      map.put("IPAddress", pro.getProperty(PropertyConstant.NE_IP_ADDRESS));
      map.put(PropertyConstant.NE_SNMP_PORT, pro.getProperty(PropertyConstant.NE_SNMP_PORT));
      map.put(PropertyConstant.NE_GET_COMMUNITY, pro.getProperty(PropertyConstant.NE_GET_COMMUNITY));
      map.put(PropertyConstant.NE_WRITE_COMMUNITY, pro.getProperty(PropertyConstant.NE_WRITE_COMMUNITY));
      map.put(MeasurementObject.Extend_Node_Type, pro.getProperty(PropertyConstant.NE_TYPE));
      map.put(MeasurementObject.Extend_Node_Version, pro.getProperty("version"));

      neMo.setExtendInfo(map);
      rtnList.add(neMo);
    }
//    log.debug("Return " + rtnList.size() + " NEs.");
    return rtnList;
  }
  
  private static List sortMeasurementObject( List aList, final String aPropertyName )
  {
    if( aList == null || aList.size() == 0 ) {
        return aList;
    }

    Collections.sort( aList, new Comparator() {
        public int compare( Object object1, Object object2 ) {
            MeasurementObject firstMeasurementObject = ( MeasurementObject ) object1;
            MeasurementObject secondMeasurementObject = ( MeasurementObject ) object2;
            if( "name".equals( aPropertyName ) ) {
                String str1 = firstMeasurementObject.getName();
                int index1 = -1;
                try {
                    index1 = Integer.parseInt( str1 );
                } catch ( NumberFormatException ex ) {
                    ex.printStackTrace();
                }
                String str2 = secondMeasurementObject.getName();
                int index2 = -1;
                try {
                    index2 = Integer.parseInt( str2 );
                } catch ( NumberFormatException ex ) {
                    ex.printStackTrace();
                }

                if( index1 == -1 && index2 == -1 ) {
                    return str1.compareTo( str2 );
                } else if( index1 == -1 ) {
                    return 1;
                } else if( index2 == -1 ) {
                    return -1;
                } else {
                    if( index1 > index2 ) {
                        return 1;
                    } else if( index1 == index2 ) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            } else if( "displayName".equals( aPropertyName ) ) {
                String str1 = firstMeasurementObject.getDisplayName();
                String str2 = secondMeasurementObject.getDisplayName();
                return str1.compareTo( str2 );
            } else {
                return 0;
            }
        }
    } );

    return aList;
  }
}
