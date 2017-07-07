/**
 * Created by Zhouchao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.server;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlHeadModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.nms.lite.persistence.base.DBAccess;
import com.winnertel.nms.lite.persistence.base.DBParams;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OnuMulticastCtrlDbOperator {

    final private static String dbConfFilePath = "conf/";
    final private static String dbConfFileName = "databaseinfo.xml";

    /*
    jdbc:sybase:Tds:{$HostAddress}:{$Port(4500)}/{$DatabaseName}
    jdbc:oracle:thin:@{$HostAddress}:{$Port(1521)}:{$DatabaseName}
    */

    private static OnuMulticastCtrlDbOperator instance = null;

    public static void main(String[] args) { //for test
        boolean result = tableIsExist("OnuMulticastCtrlHead");
        System.out.println("Check whether table 'OnuMulticastCtrlHead' is exists in Database? (" + result + ")");
    }

    private OnuMulticastCtrlDbOperator() {
    }

    public synchronized static OnuMulticastCtrlDbOperator getInstance() {
        try {
            if (instance == null) {
                instance = new OnuMulticastCtrlDbOperator();

                File file = new File(dbConfFilePath + dbConfFileName);
                if (file.exists()) {
                    DBParams.init(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    public static boolean tableIsExist(String table) { //a simple common SQL for check whether a table exists in DB
        DBAccess dbAccess = DBAccess.getInstance();
        if (dbAccess != null) {
            String sql = "select count(*) from " + table;
            try {
                ResultSet set = dbAccess.executeQuery(sql);
                if (set != null)
                    return true;
            } catch (SQLException e) {
            }
        }

        return false;
    }

    public static void createOnuMulticastCtrlTables() {
        String table1 = "OnuMulticastCtrlHead";
        String sql1 = "create table OnuMulticastCtrlHead (module int NOT NULL, device int default 1 NOT NULL, port int NOT NULL, logical_port int NOT NULL, ether_port int default 1 NOT NULL, profile varchar(32) NOT NULL, PRIMARY KEY (module, device, port, logical_port, ether_port, profile))";
        String table2 = "OnuMulticastCtrlProfile";
        String sql2 = "create table OnuMulticastCtrlProfile (profile varchar(32) NOT NULL, multicast_vlan int NOT NULL, multicast_group_start varchar(15) NOT NULL, multicast_group_end varchar(15) NOT NULL, authentication_type int NOT NULL, PRIMARY KEY (profile, multicast_vlan, multicast_group_start, multicast_group_end, authentication_type))";
        try {
            if (!tableIsExist(table1))
                DBAccess.getInstance().execute(sql1);
            if (!tableIsExist(table2))
                DBAccess.getInstance().execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //reserved
    public static boolean addOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "insert into OnuMulticastCtrlHead values(" + model.getModuleId() + ", " + model.getDeviceId() + ", " + model.getPortId() + ", " + model.getLogicalPortId() + ", " + model.getEtherPortIndex() + ", '" + model.getProfile() + "')";
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            result = false;
            Vector profileData = model.getProfileData();
            if (profileData != null) {
                for (int i = 0; i < profileData.size(); i++) {
                    OnuMulticastCtrlProfileModel profileModel = (OnuMulticastCtrlProfileModel) profileData.get(i);
                    if (profileModel != null) {
                        sql = "insert into OnuMulticastCtrlProfile values('" + profileModel.getProfile() + "', " + profileModel.getVlan() + ", '" + profileModel.getGroupStart() + "', '" + profileModel.getGroupEnd() + "', " + profileModel.getAuthType() + ")";
                        try {
                            DBAccess.getInstance().execute(sql);
                            result = true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return result;
    }

    //reserved
    public static boolean deleteOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "delete from OnuMulticastCtrlHead where module=" + model.getModuleId() + " and device=" + model.getDeviceId() + " and port=" + model.getPortId() + " and logical_port=" + model.getLogicalPortId() + " and ether_port=" + model.getEtherPortIndex() + " and profile='" + model.getProfile() + "'";
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            result = false;
            sql = "delete from OnuMulticastCtrlProfile where profile='" + model.getProfile() + "'";
            try {
                DBAccess.getInstance().execute(sql);
                result = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static boolean addOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "insert into OnuMulticastCtrlHead values(" + model.getModuleId() + ", " + model.getDeviceId() + ", " + model.getPortId() + ", " + model.getLogicalPortId() + ", " + model.getEtherPortIndex() + ", '" + model.getProfile() + "')";
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean deleteOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        //String sql = "delete from OnuMulticastCtrlHead where module=" + model.getModuleId() + " and device=" + model.getDeviceId() + " and port=" + model.getPortId() + " and logical_port=" + model.getLogicalPortId() + " and ether_port=" + model.getEtherPortIndex() + " and profile='" + model.getProfile() + "'";
        String sql = "delete from OnuMulticastCtrlHead where module=" + model.getModuleId() + " and device=" + model.getDeviceId() + " and port=" + model.getPortId() + " and logical_port=" + model.getLogicalPortId() + " and ether_port=" + model.getEtherPortIndex();
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean addOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "insert into OnuMulticastCtrlProfile values('" + model.getProfile() + "', " + model.getVlan() + ", '" + model.getGroupStart() + "', '" + model.getGroupEnd() + "', " + model.getAuthType() + ")";
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean deleteOnuMulticastCtrlProfileProcess(String profile) {
        if (profile == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "delete from OnuMulticastCtrlProfile where profile='" + profile + "'";
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean deleteOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) {
        if (model == null)
            return false;

        boolean result = false;
        //Database-Operation
        String sql = "delete from OnuMulticastCtrlProfile where profile='" + model.getProfile() + "' and multicast_vlan=" + model.getVlan() + " and multicast_group_start='" + model.getGroupStart() + "' and multicast_group_end='" + model.getGroupEnd() + "' and authentication_type=" + model.getAuthType();
        try {
            DBAccess.getInstance().execute(sql);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Vector getOnuMulticastCtrlHeadTableModel() {
        Vector data = new Vector();

        String sql = "select module, device, port, logical_port, ether_port, profile from OnuMulticastCtrlHead order by module, device, port, logical_port, ether_port, profile";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    OnuMulticastCtrlHeadModel rowModel = new OnuMulticastCtrlHeadModel(set.getInt("module"), set.getInt("device"), set.getInt("port"), set.getInt("logical_port"), set.getInt("ether_port"), set.getString("profile"));
                    data.add(rowModel);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId, int etherPortIndex) {
        Vector data = new Vector();

        String sql = "select module, device, port, logical_port, ether_port, profile from OnuMulticastCtrlHead";
        String where = "";
        if (moduleId > 0 || portId > 0 || logicalPortId > 0) {
            sql += " where";
            if (moduleId > 0) {
                if (where.trim().length() > 0)
                    where += " and module=" + moduleId;
                else
                    where += " module=" + moduleId;
            }
            if (portId > 0) {
                if (where.trim().length() > 0)
                    where += " and port=" + portId;
                else
                    where += " port=" + portId;
            }
            if (logicalPortId > 0) {
                if (where.trim().length() > 0)
                    where += " and logical_port=" + logicalPortId;
                else
                    where += " logical_port=" + logicalPortId;
            }
            if (etherPortIndex > 0) {
                if (where.trim().length() > 0)
                    where += " and ether_port=" + etherPortIndex;
                else
                    where += " ether_port=" + etherPortIndex;
            }
        }
        sql += where + " order by module, device, port, logical_port, ether_port, profile";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    OnuMulticastCtrlHeadModel rowModel = new OnuMulticastCtrlHeadModel(set.getInt("module"), set.getInt("device"), set.getInt("port"), set.getInt("logical_port"), set.getInt("ether_port"), set.getString("profile"));
                    data.add(rowModel);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId) {
        Vector data = new Vector();

        String sql = "select module, device, port, logical_port, ether_port, profile from OnuMulticastCtrlHead";
        String where = "";
        if (moduleId > 0 || portId > 0 || logicalPortId > 0) {
            sql += " where";
            if (moduleId > 0) {
                if (where.trim().length() > 0)
                    where += " and module=" + moduleId;
                else
                    where += " module=" + moduleId;
            }
            if (portId > 0) {
                if (where.trim().length() > 0)
                    where += " and port=" + portId;
                else
                    where += " port=" + portId;
            }
            if (logicalPortId > 0) {
                if (where.trim().length() > 0)
                    where += " and logical_port=" + logicalPortId;
                else
                    where += " logical_port=" + logicalPortId;
            }
        }
        sql += where + " order by module, device, port, logical_port, ether_port, profile";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    OnuMulticastCtrlHeadModel rowModel = new OnuMulticastCtrlHeadModel(set.getInt("module"), set.getInt("device"), set.getInt("port"), set.getInt("logical_port"), set.getInt("ether_port"), set.getString("profile"));
                    data.add(rowModel);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    /* remarked due to set column 'profile' as invisible
    public static Vector getOnuMulticastCtrlProfileTableModel() {
        Vector data = new Vector();

        String sql = "select profile, multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile order by profile, multicast_vlan, multicast_group_start, authentication_type";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    OnuMulticastCtrlProfileModel rowModel = new OnuMulticastCtrlProfileModel(set.getString("profile"), set.getInt("multicast_vlan"), set.getString("multicast_group_start"), set.getString("multicast_group_end"), set.getInt("authentication_type"));
                    data.add(rowModel);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
    */

    public static Vector retrieveOnuMulticastCtrlProfileTableModelById(String profile) {
        Vector data = new Vector();

        String sql = "select multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile where profile='" + profile + "' order by profile, multicast_vlan, multicast_group_start, authentication_type";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    OnuMulticastCtrlProfileModel rowModel = new OnuMulticastCtrlProfileModel(profile, set.getInt("multicast_vlan"), set.getString("multicast_group_start"), set.getString("multicast_group_end"), set.getInt("authentication_type"));
                    data.add(rowModel);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    /*
    public static Vector getOnuMulticastCtrlProfileTableModelById(String profile) { //modified by Zhou Chao, 2009-2-19
        Vector data = new Vector();

        int[] authTypeVList = new int[]{1, 3, 2}; //priority: low -> high
        for (int i = 0; i < authTypeVList.length; i++) {
            String sql = "select distinct multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile where profile='" + profile + "' and authentication_type=" + authTypeVList[i] + " order by profile, multicast_vlan, multicast_group_start";
            ResultSet set = null;
            try {
                set = DBAccess.getInstance().executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (set != null) {
                try {
                    while (set.next()) {
                        OnuMulticastCtrlProfileModel rowModel = new OnuMulticastCtrlProfileModel(profile, set.getInt("multicast_vlan"), set.getString("multicast_group_start"), set.getString("multicast_group_end"), set.getInt("authentication_type"));
                        data.add(rowModel);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }
    */

    public static Vector getOnuMulticastCtrlProfileTableModelById(String profile) { //modified by Zhou Chao, 2009-2-19
        Vector data = new Vector();

        String[] profiles = profile.split(",");
        String profileName = "";
        String profileValue = "";
        if (profiles != null) {
            for (int i = 0; i < profiles.length; i++) {
                if (i != 0) {
                    profileName += ",";
                    profileValue += ",";
                }
                profileName += profiles[i];
                profileValue += "'" + profiles[i] + "'";
            }
        }

        String sqlPrefix = "";
        if (profiles == null || profiles.length <= 0) {
            sqlPrefix = "select distinct multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile where ";
        } else {
            if (profiles.length > 1)
                sqlPrefix = "select distinct multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile where profile in (" + profileValue + ") and ";
            else
                sqlPrefix = "select distinct multicast_vlan, multicast_group_start, multicast_group_end, authentication_type from OnuMulticastCtrlProfile where profile=" + profileValue + " and ";
        }

        int[] authTypeVList = new int[]{1, 3, 2}; //priority: low -> high
        for (int i = 0; i < authTypeVList.length; i++) {
            String sql = sqlPrefix + "authentication_type=" + authTypeVList[i] + " order by profile, multicast_vlan, multicast_group_start";
            ResultSet set = null;
            try {
                set = DBAccess.getInstance().executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (set != null) {
                try {
                    while (set.next()) {
                        OnuMulticastCtrlProfileModel rowModel = new OnuMulticastCtrlProfileModel(profileName, set.getInt("multicast_vlan"), set.getString("multicast_group_start"), set.getString("multicast_group_end"), set.getInt("authentication_type"));
                        data.add(rowModel);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }

    public static Vector getOnuMulticastCtrlProfileName() {
        Vector data = new Vector();

        String sql = "select distinct profile from OnuMulticastCtrlProfile";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("profile"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static Vector getOnuMulticastCtrlModule(String neName) {
        Vector data = new Vector();

        String sql = "select distinct cardid from ut_inv_onu_gepon where nename='" + neName + "'";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("cardid"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    /* reserved
    public static Vector getOnuMulticastCtrlDeviceById(String neName, String module) {
        Vector data = new Vector();

        String sql = "select distinct deviceid from ut_inv_onu_gepon where nename='" + neName + "' and cardid='" + module + "'";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("deviceid"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
    */

    public static Vector getOnuMulticastCtrlPortById(String neName, String module) {
        Vector data = new Vector();

        String sql = "select distinct portid from ut_inv_onu_gepon where nename='" + neName + "' and cardid='" + module + "'";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("portid"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static Vector getOnuMulticastCtrlLogicalPortById(String neName, String module, String port) {
        Vector data = new Vector();

        String sql = "select distinct onuid from ut_inv_onu_gepon where nename='" + neName + "' and cardid='" + module + "' and portid='" + port + "'";
        ResultSet set = null;
        try {
            set = DBAccess.getInstance().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("onuid"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

}