/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface OnuMulticastCtrlRemoteIntf extends Remote {

    public static final String RMI_NAME = "OnuMulticastCtrlService";

    public boolean tableIsExist(String table) throws RemoteException;

    public void createOnuMulticastCtrlTables() throws RemoteException;

    public boolean addOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) throws RemoteException; //reserved

    public boolean deleteOnuMulticastCtrlProcess(OnuMulticastCtrlModel model) throws RemoteException; //reserved

    public boolean addOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) throws RemoteException;

    public boolean deleteOnuMulticastCtrlHeadProcess(OnuMulticastCtrlModel model) throws RemoteException;

    public boolean addOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) throws RemoteException;

    public boolean deleteOnuMulticastCtrlProfileProcess(String profile) throws RemoteException;

    public boolean deleteOnuMulticastCtrlProfileProcess(OnuMulticastCtrlProfileModel model) throws RemoteException;

    public Vector getOnuMulticastCtrlHeadTableModel() throws RemoteException;

    public Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId, int etherPortIndex) throws RemoteException;

    public Vector getOnuMulticastCtrlHeadTableModel(int moduleId, int portId, int logicalPortId) throws RemoteException;

    /* reserved (remarked due to set column 'profile' as invisible)
    public Vector getOnuMulticastCtrlProfileTableModel() throws RemoteException;
    */

    public Vector retrieveOnuMulticastCtrlProfileTableModelById(String profile) throws RemoteException;

    public Vector getOnuMulticastCtrlProfileTableModelById(String profile) throws RemoteException;

    public Vector getOnuMulticastCtrlProfileName() throws RemoteException;

    public Vector getOnuMulticastCtrlModule(String neName) throws RemoteException;

    /* reserved
    public Vector getOnuMulticastCtrlDeviceById(int module) throws RemoteException;
    */

    public Vector getOnuMulticastCtrlPortById(String neName, String module) throws RemoteException;

    public Vector getOnuMulticastCtrlLogicalPortById(String neName, String module, String port) throws RemoteException;

}