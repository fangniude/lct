package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.ems.epon.cm.framework.SystemConfigMgr;

import java.rmi.RemoteException;
import java.util.Vector;

public interface MibProxyMgr extends SystemConfigMgr {
    public Vector retrieveAll(String neId, String table) throws RemoteException;

    public Vector retrieveAll(String neId, String table, int[] index) throws RemoteException;
}
