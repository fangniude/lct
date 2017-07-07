package com.winnertel.ems.epon.inventory;

import com.winnertel.ems.epon.cm.framework.SystemConfigMgr;

import java.rmi.RemoteException;

public interface UnboundOnuMgmtMgr extends SystemConfigMgr {
  //for onu management.
  public int getRowCount(String sql) throws RemoteException;

  public UnboundOnuMOD[] getUnboundOnuMOD(String str, int index, int len) throws RemoteException;

  public UnboundOnuMOD getUnboundOnuMOD(String mac) throws RemoteException;

  public void bindOnu(UnboundOnuMOD onu) throws RemoteException;

  public void addUnbindOnu(UnboundOnuMOD onu) throws RemoteException;

  public void deleteUnbindOnu(UnboundOnuMOD onu) throws RemoteException;
}
