package com.winnertel.em.framework.model.snmp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISnmpExecutor extends Remote {

    public com.winnertel.snmp.snmp2.SnmpPDU syncSend(com.winnertel.snmp.snmp2.SnmpPDU requestPDU) throws RemoteException, com.winnertel.snmp.snmp2.DefaultSnmpException;
}
