/**
 * Created by Zhouchao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

//import com.winnertel.ems.epon.global.ResourceManager;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlHeadModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlRemoteIntf;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.server.OnuMulticastCtrlDbOperator;
import com.winnertel.em.framework.IApplication;
import com.winnertel.inms.topoui.UTopoUIContext;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;
import java.util.Vector;

public class OnuMulticastCtrlApplication {

    private static boolean isLocal = false; //for test

    private static OnuMulticastCtrlApplication instance = null;

    private String serverIp = "";
    private String rmiPort = "";
    private String userName = "";

    private String nodeName = "";

    private OnuMulticastCtrlRemoteIntf databaseService = null;

    private OnuMulticastCtrlApplication() {
        init();
        setEnvironment();
    }

    public synchronized static OnuMulticastCtrlApplication getInstance() {
        try {
            if (instance == null) {
                instance = new OnuMulticastCtrlApplication();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    public static boolean isLocal() {
        return isLocal;
    }

    private void init() {
        if (!isLocal) {
            Properties prop = UTopoUIContext.getInstance().getUIProperties();
            if (prop != null) {
                serverIp = prop.getProperty("SERVER_NAME");
                rmiPort = prop.getProperty("RMI_PORT");
                userName = prop.getProperty("USER_NAME");
            }

            initRMI();
        }
    }

    private boolean initRMI() {
        databaseService = lookupRemoteDatabaseService();

        return true;
    }

    private OnuMulticastCtrlRemoteIntf lookupRemoteDatabaseService() {
        try {
            String url = "//" + serverIp + ":" + rmiPort + "/" + OnuMulticastCtrlRemoteIntf.RMI_NAME;
            return (OnuMulticastCtrlRemoteIntf) Naming.lookup(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void setEnvironment() {
        if (isLocal)
            OnuMulticastCtrlDbOperator.getInstance();

        createOnuMulticastCtrlTables();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getRmiPort() {
        return rmiPort;
    }

    public void setRmiPort(String rmiPort) {
        this.rmiPort = rmiPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    private void createOnuMulticastCtrlTables() {
        if (!isLocal) {
            try {
                databaseService.createOnuMulticastCtrlTables();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            OnuMulticastCtrlDbOperator.createOnuMulticastCtrlTables();
        }
    }

    //reserved
    public boolean addOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) {
        if (!isLocal) {
            try {
                return databaseService.addOnuMulticastCtrlProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlProcess(model);
        }

        return false;
    }

    //reserved
    public boolean deleteOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) {
        if (!isLocal) {
            try {
                return databaseService.deleteOnuMulticastCtrlProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProcess(model);
        }

        return false;
    }

    public boolean addOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) {
        if (!isLocal) {
            try {
                return databaseService.addOnuMulticastCtrlHeadProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlHeadProcess(model);
        }

        return false;
    }

    public boolean deleteOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) {
        if (!isLocal) {
            try {
                return databaseService.deleteOnuMulticastCtrlHeadProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlHeadProcess(model);
        }

        return false;
    }

    public boolean addOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) {
        if (!isLocal) {
            try {
                return databaseService.addOnuMulticastCtrlProfileProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlProfileProcess(model);
        }

        return false;
    }

    public boolean deleteOnuMulticastCtrlProfileProcess(String profile) {
        if (!isLocal) {
            try {
                return databaseService.deleteOnuMulticastCtrlProfileProcess(profile);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProfileProcess(profile);
        }

        return false;
    }

    public boolean deleteOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) {
        if (!isLocal) {
            try {
                return databaseService.deleteOnuMulticastCtrlProfileProcess(model);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProfileProcess(model);
        }

        return false;
    }

    public OnuMulticastCtrlHeadTableModel getOnuMulticastCtrlHeadTableModel(IApplication fApplication, int moduleId, int portId, int logicalPortId, int etherPortIndex) {
        OnuMulticastCtrlHeadTableModel model = new OnuMulticastCtrlHeadTableModel(fApplication);

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId, etherPortIndex);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId, etherPortIndex);
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlHeadModel) v.get(i));
        }

        return model;
    }

    public OnuMulticastCtrlHeadTableModel getOnuMulticastCtrlHeadTableModel(IApplication fApplication, int moduleId, int portId, int logicalPortId) {
        OnuMulticastCtrlHeadTableModel model = new OnuMulticastCtrlHeadTableModel(fApplication);

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId);
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlHeadModel) v.get(i));
        }

        return model;
    }

    public OnuMulticastCtrlHeadTableModel getOnuMulticastCtrlHeadTableModel(IApplication fApplication) {
        OnuMulticastCtrlHeadTableModel model = new OnuMulticastCtrlHeadTableModel(fApplication);

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.getOnuMulticastCtrlHeadTableModel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel();
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlHeadModel) v.get(i));
        }

        return model;
    }

    /* remarked due to set column 'profile' as invisible
    public OnuMulticastCtrlProfileTableModel getOnuMulticastCtrlProfileTableModel() {
        OnuMulticastCtrlProfileTableModel model = new OnuMulticastCtrlProfileTableModel();

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.getOnuMulticastCtrlProfileTableModel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileTableModel();
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlProfileModel) v.get(i));
        }

        return model;
    }
    */

    public OnuMulticastCtrlProfileTableModel retrieveOnuMulticastCtrlProfileTableModelById(IApplication fApplication, String profile) {
        OnuMulticastCtrlProfileTableModel model = new OnuMulticastCtrlProfileTableModel(fApplication);

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.retrieveOnuMulticastCtrlProfileTableModelById(profile);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.retrieveOnuMulticastCtrlProfileTableModelById(profile);
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlProfileModel) v.get(i));
        }

        return model;
    }

    public OnuMulticastCtrlProfileTableModel getOnuMulticastCtrlProfileTableModelById(IApplication fApplication, String profile) {
        OnuMulticastCtrlProfileTableModel model = new OnuMulticastCtrlProfileTableModel(fApplication);

        Vector v = null;
        if (!isLocal) {
            try {
                v = databaseService.getOnuMulticastCtrlProfileTableModelById(profile);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            v = OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileTableModelById(profile);
        }
        if (v != null) {
            for (int i = 0; i < v.size(); i++)
                model.addRow((OnuMulticastCtrlProfileModel) v.get(i));
        }

        return model;
    }

    public Vector getOnuMulticastCtrlProfileName() {
        if (!isLocal) {
            try {
                return databaseService.getOnuMulticastCtrlProfileName();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileName();
        }

        return null;
    }

    /*
    public Vector getOnuMulticastCtrlModule(String neName) { //public Vector getOnuMulticastCtrlModule() {
        if (!isLocal) {
            try {
                return databaseService.getOnuMulticastCtrlModule(neName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlModule(neName);
        }

        return null;
    }
    */

    /* reserved
    public Vector getOnuMulticastCtrlDeviceById(int module) {
        if (!isLocal) {
            try {
                return databaseService.getOnuMulticastCtrlDeviceById(module);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlDeviceById(module);
        }

        return null;
    }
    */

    /*
    public Vector getOnuMulticastCtrlPortById(String neName, String module) { //public Vector getOnuMulticastCtrlPortById(int module, int device) {
        if (!isLocal) {
            try {
                return databaseService.getOnuMulticastCtrlPortById(neName, module);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlPortById(neName, module);
        }

        return null;
    }
    */

    /*
    public Vector getOnuMulticastCtrlLogicalPortById(String neName, String module, String port) { //public Vector getOnuMulticastCtrlLogicalPortById(int module, int device, int port) {
        if (!isLocal) {
            try {
                return databaseService.getOnuMulticastCtrlLogicalPortById(neName, module, port);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlLogicalPortById(neName, module, port);
        }

        return null;
    }
    */

    /*
    public Vector getOnuMulticastCtrlEtherPortById(int module, int device, int port, int logicalPort) {
        Vector data = new Vector();

        String sql = "select distinct ether_port from OnuMulticastCtrlHead where module=" + module + " and device=" + device + " and port=" + port + " and logical_port=" + logicalPort;
        ResultSet set = null;
        if (!isLocal) {
            try {
                set = databaseService.getDBInstance().executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            set = ClientDBServiceRemoteImpl.getInstance().executeQuery(sql);
        }
        if (set != null) {
            try {
                while (set.next()) {
                    data.add(set.getString("ether_port"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
    */

    /*
    public Vector getOnuMulticastCtrlEtherPorts() {
        Vector data = new Vector();
        for (int i = 0; i < 32; i++)
            data.add(String.valueOf(i + 1));

        return data;
    }
    */

    public static String getString(String s) {
        return (s == null || s.length() <= 0) ? s : s;//ResourceManager.getString(s);
    }

    public static void main(String[] args) {
    }

}