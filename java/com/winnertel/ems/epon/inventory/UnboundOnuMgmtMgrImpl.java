package com.winnertel.ems.epon.inventory;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.snmp.SnmpConstant;
import com.winnertel.ems.epon.snmp.SnmpTargetExt;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.lite.persistence.base.DBAccess;
import com.winnertel.nms.lite.persistence.base.DBParams;
import com.winnertel.snmp.snmp2.SnmpVar;
import sun.jdbc.rowset.CachedRowSet;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UnboundOnuMgmtMgrImpl extends UnicastRemoteObject implements UnboundOnuMgmtMgr {
  private static boolean isOracle = false;
  private static UnboundOnuMgmtMgrImpl impl = null;
  private static int tableId = 0;

  public UnboundOnuMgmtMgrImpl() throws RemoteException {
    String dbType = DBParams.getParams().getDriverType();
    if (dbType != null && dbType.equalsIgnoreCase("ORACLE")) {
      isOracle = true;
    }
  }

  public synchronized static UnboundOnuMgmtMgrImpl getInstance() {
    try {
      if (impl == null) {
        impl = new UnboundOnuMgmtMgrImpl();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return impl;
  }

  //for onu management.
  public int getRowCount(String sql) throws RemoteException {
    int count = 0;

    try {
      CachedRowSet rowSet = DBAccess.getInstance().executeQuery(sql);
      if (rowSet.next()) {
        count = Integer.parseInt(rowSet.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return count;
  }

  public UnboundOnuMOD[] getUnboundOnuMOD(String str, int index, int len) throws RemoteException {
    if (len <= 0) {
      return null;
    }

    if (index < 0) {
      index = 0;
    }

    UnboundOnuMOD[] onuModel = null;
    CachedRowSet rowSet = null;
    if (isOracle) {
      rowSet = getUnboundOnuDataFromOracle(str, index, len);
    } else {
      rowSet = getUnboundOnuDataFromSybase(str, index, len);
    }
    if (rowSet == null)
      return null;

    try {
      onuModel = new UnboundOnuMOD[rowSet.size()];

      int cursor = 0;
      while (rowSet.next()) {
        if (cursor >= onuModel.length)
          break;

        onuModel[cursor] = new UnboundOnuMOD();

        String macAddress = rowSet.getString("macaddress");
        if (macAddress == null)
          macAddress = "";
        onuModel[cursor].setMacAddress(macAddress);

        String neLabel = rowSet.getString("nelabel");
        if (neLabel == null)
        	neLabel = "";
        onuModel[cursor].setNeLabel(neLabel);
        
        String neName = rowSet.getString("nename");
        if (neName == null)
          neName = "";
        onuModel[cursor].setNeName(neName);

        String cardid = rowSet.getString("cardid");
        if (cardid == null)
          cardid = "";
        onuModel[cursor].setCardId(cardid);

        String portid = rowSet.getString("portid");
        if (portid == null)
          portid = "";
        onuModel[cursor].setPortId(portid);

        String onuid = rowSet.getString("llid");
        if (onuid == null)
          onuid = "";
        onuModel[cursor].setLlId(onuid);

        cursor++;
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }

    return onuModel;
  }

  protected CachedRowSet getUnboundOnuDataFromOracle(String str, int index, int len) {
    CachedRowSet rowSet = null;

    StringBuffer sb = new StringBuffer();
    //SELECT * FROM (SELECT A.*, rownum r FROM (select * from VIEW_INVENTORY_ONU) A WHERE rownum<=10) B WHERE r>=9;
    sb.append("select * from (select a.*, rownum r from (").append(str).append(") a where rownum<").append(index + len).append(") b where r>=").append(index);
    try {
      rowSet = DBAccess.getInstance().executeQuery(sb.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowSet;
  }

  protected CachedRowSet getUnboundOnuDataFromSybase(String str, int index, int len) {
    CachedRowSet rowSet = null;

    String tmpTblName = getTempTableName();

    //select id=identity(12), * into #rox1 from ut_inv_unbound_onu_gepon //order by id
    StringBuffer sb = new StringBuffer();
    sb.append("set rowcount ").append(index + len).append(" select id=identity(12), * into ").append(tmpTblName).append(" ").append(str.substring(str.lastIndexOf("from")));
    String tmpTblSql = sb.toString();

    sb = new StringBuffer();
    if (str.indexOf("where") != -1) {
      sb.append("select * from ").append(tmpTblName).append(" ").append(str.substring(str.indexOf("where"))).append(" and id>=").append(index).append(" and id<").append(index + len - 1);
    } else {
      sb.append("select * from ").append(tmpTblName).append(" where id>=").append(index).append(" and id<").append(index + len).append(" ").append(str.substring(str.indexOf("VIEW_UNBOUND_ONU") + 16));
    }
    String querySql = sb.toString();


    try {
      Connection c = DBAccess.getInstance().getConnection();
      Statement stmt = c.createStatement();
      stmt.executeUpdate(tmpTblSql);
      stmt.execute("set rowcount 0");

      rowSet = DBAccess.getInstance().executeQuery(querySql);

      stmt.execute("drop table " + tmpTblName);
      if (!c.getAutoCommit())
        c.commit();

      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return rowSet;
  }

  private synchronized static String getTempTableName() {
    if (tableId == 65535)
      tableId = 0;

    String tableName = "#unboundonu" + tableId;
    tableId++;

    return tableName;
  }

  public UnboundOnuMOD getUnboundOnuMOD(String mac) throws RemoteException {
    UnboundOnuMOD onu = new UnboundOnuMOD();

    try
    {
      String sql = "select * from ut_inv_unbound_onu_gepon where macAddress='" + mac + "'";
      DBAccess dbAccess = DBAccess.getInstance();
      ResultSet set = dbAccess.executeQuery(sql);

      if (set.next()) {
        String macAddress = set.getString("macaddress");
        if (macAddress == null)
          macAddress = "";
        onu.setMacAddress(macAddress);

        String neName = set.getString("nename");
        if (neName == null)
          neName = "";
        onu.setNeName(neName);

        String cardid = set.getString("cardid");
        if (cardid == null)
          cardid = "";
        onu.setCardId(cardid);

        String portid = set.getString("portid");
        if (portid == null)
          portid = "";
        onu.setPortId(portid);

        String onuid = set.getString("llid");
        if (onuid == null)
          onuid = "";
        onu.setLlId(onuid);
      }

      return onu;
    } catch (Exception e)
    {
      throw new RemoteException("Can't get the Unbound ONU: " + onu.getMacAddress(), e);
    }
  }

  public void deleteUnboundOnu(UnboundOnuMOD onu) throws RemoteException {
    try {
      deleteUnboundOnuInDB(onu);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RemoteException("Can't delete ONU: " + onu.getMacAddress(), e);
    }
  }

  protected void deleteUnboundOnuInDB(UnboundOnuMOD onu) throws SQLException {
    Connection con = DBAccess.getInstance().getConnection();
    PreparedStatement pstmt = con.prepareStatement("delete from ut_inv_unbound_onu_gepon where macAddress=?");
    pstmt.setString(1, onu.getMacAddress());
    pstmt.execute();
  }

  public void synchronize(UnboundOnuMOD onu) throws SQLException {
    if (isExistedInDB(onu)) {
      updateOnuInDB(onu);
    } else {
      createOnuInDB(onu);
    }
  }

  boolean isExistedInDB(UnboundOnuMOD onu) throws SQLException {
    String sql = "select macAddress from ut_inv_unbound_onu_gepon where macAddress='" + onu.getMacAddress() + "'";
    DBAccess dbAccess = DBAccess.getInstance();
    ResultSet set = dbAccess.executeQuery(sql);

    return set.next();
  }

  boolean createOnuInDB(UnboundOnuMOD onu) throws SQLException {
    Connection con = DBAccess.getInstance().getConnection();
    PreparedStatement pstmt = con.prepareStatement("insert into ut_inv_unbound_onu_gepon(macAddress, neName, cardId, portId, llId) values(?, ?, ?, ?, ?)");
    pstmt.setString(1, onu.getMacAddress());
    pstmt.setString(2, onu.getNeName());
    pstmt.setString(3, onu.getCardId());
    pstmt.setString(4, onu.getPortId());
    pstmt.setString(5, onu.getLlId());

    return pstmt.execute();
  }

  boolean updateOnuInDB(UnboundOnuMOD onu) throws SQLException {
    Connection con = DBAccess.getInstance().getConnection();
    PreparedStatement pstmt = con.prepareStatement("update ut_inv_unbound_onu_gepon set neName=?, cardId=?, portId=?, llId=? where macAddress=?");
    pstmt.setString(1, onu.getNeName());
    pstmt.setString(2, onu.getCardId());
    pstmt.setString(3, onu.getPortId());
    pstmt.setString(4, onu.getLlId());
    pstmt.setString(5, onu.getMacAddress());

    return pstmt.execute();
  }

  public boolean deleteOnuByNeName(String neName) throws SQLException {
    Connection con = DBAccess.getInstance().getConnection();
    PreparedStatement pstmt = con.prepareStatement("delete from ut_inv_unbound_onu_gepon where neName=?");
    pstmt.setString(1, neName);

    return pstmt.execute();
  }

  public void bindOnu(UnboundOnuMOD onu) throws RemoteException {
    try {
      Properties neProperty = UTopoAPI.getAPI().getNodeProperties(onu.getNeName());

      String ipAddress = neProperty.getProperty(PropertyConstant.NE_IP_ADDRESS);
      int port = Integer.parseInt(neProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161"));
      String getCommunity = neProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
      String neType = neProperty.getProperty(PropertyConstant.NE_TYPE, "");
      String neVersion = neProperty.getProperty(PropertyConstant.NE_VERSION, "");
      
      SnmpTargetExt target = new SnmpTargetExt(ipAddress, port, getCommunity, "private");
      String[] oidList;

      //
      if((neType.equals("BBS1000+") && neVersion.startsWith("2.3")) ||
          (neType.equals("BBS4000") && neVersion.startsWith("1.0")))
      {
        //utsDot3DbaSlaBindingMacAddress
        oidList = new String[]{".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.25." + ConfigUtility.generateIfIndex(onu.getCardId()+"/"+onu.getPortId()+"/"+onu.getLlId())};
      }
      else
      {
        //utsDot3ValidOnuMacAddr
        oidList = new String[]{".1.3.6.1.4.1.45121.1800.2.3.1.2.1.17.1.5." + onu.getCardId() + ".1." + onu.getPortId() + "." + onu.getLlId()};
      }

      Object[] valueList = new SnmpVar[] {
        SnmpConstant.createSnmpVar(ConfigUtility.MacAddressToOctet1(onu.getMacAddress()), SnmpConstant.MAC_ADDRESS)
      };

      target.setValues(oidList, valueList);

      deleteUnboundOnuInDB(onu);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

    public void addUnbindOnu(UnboundOnuMOD onu) throws RemoteException {
      try {
          if (!isExistedInDB(onu)) {
              createOnuInDB(onu);
          } else {
          }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    public void deleteUnbindOnu(UnboundOnuMOD onu) throws RemoteException {
        try {
            deleteUnboundOnuInDB(onu);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}