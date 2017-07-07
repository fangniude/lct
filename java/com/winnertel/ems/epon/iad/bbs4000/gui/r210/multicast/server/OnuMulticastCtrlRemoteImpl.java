/**
 * Created by Zhouchao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.server;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlRemoteIntf;

import java.rmi.RemoteException;
import java.util.Vector;

public class OnuMulticastCtrlRemoteImpl implements OnuMulticastCtrlRemoteIntf {

    public boolean tableIsExist(String table) throws RemoteException {
        return OnuMulticastCtrlDbOperator.tableIsExist(table);
    }

    public void createOnuMulticastCtrlTables() throws RemoteException {
        OnuMulticastCtrlDbOperator.createOnuMulticastCtrlTables();
    }

    public boolean addOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) throws RemoteException { //reserved
        return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlProcess(model);
    }

    public boolean deleteOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) throws RemoteException { //reserved
        return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProcess(model);
    }

    public boolean addOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) throws RemoteException {
        return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlHeadProcess(model);
    }

    public boolean deleteOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) throws RemoteException {
        return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlHeadProcess(model);
    }

    public boolean addOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) throws RemoteException {
        return OnuMulticastCtrlDbOperator.addOnuMulticastCtrlProfileProcess(model);
    }

    public boolean deleteOnuMulticastCtrlProfileProcess(String profile) throws RemoteException {
        return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProfileProcess(profile);
    }

    public boolean deleteOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) throws RemoteException {
        return OnuMulticastCtrlDbOperator.deleteOnuMulticastCtrlProfileProcess(model);
    }

    public Vector getOnuMulticastCtrlHeadTableModel() throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel();
    }

    public Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId, int etherPortIndex) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId, etherPortIndex);
    }

    public Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlHeadTableModel(moduleId, portId, logicalPortId);
    }

    /* remarked due to set column 'profile' as invisible
    public Vector getOnuMulticastCtrlProfileTableModel() throws RemoteException { //reserved
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileTableModel();
    }
    */

    public Vector retrieveOnuMulticastCtrlProfileTableModelById(String profile) throws RemoteException {
        return OnuMulticastCtrlDbOperator.retrieveOnuMulticastCtrlProfileTableModelById(profile);
    }

    public Vector getOnuMulticastCtrlProfileTableModelById(String profile) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileTableModelById(profile);
    }

    public Vector getOnuMulticastCtrlProfileName() throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlProfileName();
    }

    public Vector getOnuMulticastCtrlModule(String neName) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlModule(neName);
    }

    /* reserved
    public Vector getOnuMulticastCtrlDeviceById(int module) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlDeviceById(module);
    }
    */

    public Vector getOnuMulticastCtrlPortById(String neName, String module) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlPortById(neName, module);
    }

    public Vector getOnuMulticastCtrlLogicalPortById(String neName, String module, String port) throws RemoteException {
        return OnuMulticastCtrlDbOperator.getOnuMulticastCtrlLogicalPortById(neName, module, port);
    }

}