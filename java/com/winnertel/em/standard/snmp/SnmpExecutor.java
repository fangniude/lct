package com.winnertel.em.standard.snmp;

import com.winnertel.em.framework.model.snmp.ISnmpExecutor;
import com.winnertel.nms.util.ULRunProcessInterface;
import com.winnertel.snmp.SnmpSessionFactory;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SnmpExecutor extends UnicastRemoteObject implements ISnmpExecutor, ULRunProcessInterface {

    private static final long serialVersionUID = 1126417628926190890L;

    protected boolean isInitialized = false;

    public SnmpExecutor() throws RemoteException {
        super();
    }

    @Override
    public com.winnertel.snmp.snmp2.SnmpPDU syncSend(com.winnertel.snmp.snmp2.SnmpPDU requestPdu) throws RemoteException, com.winnertel.snmp.snmp2.DefaultSnmpException {
        com.winnertel.snmp.snmp2.SnmpSession session = openSession();

        try {
            beforeSend(session, requestPdu);

            com.winnertel.snmp.snmp2.SnmpPDU responsePdu = session.syncSend(requestPdu);

            afterSend(session, responsePdu);

            return responsePdu;
        } finally {
            closeSession(session);
        }
    }

    private void afterSend(com.winnertel.snmp.snmp2.SnmpSession session, com.winnertel.snmp.snmp2.SnmpPDU responsePdu) {
        if (responsePdu == null) {
            return;
        }

        String localHost = "127.0.0.1";
        try {
            localHost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        responsePdu.setAgentAddr(localHost);

    }

    private void beforeSend(com.winnertel.snmp.snmp2.SnmpSession session, com.winnertel.snmp.snmp2.SnmpPDU requestPdu) {
        session.setVersion(requestPdu.getVersion());
    }

    private com.winnertel.snmp.snmp2.SnmpSession openSession() throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return SnmpSessionFactory.getInstance().getSnmpSession();
    }

    private void closeSession(com.winnertel.snmp.snmp2.SnmpSession session) {
        SnmpSessionFactory.getInstance().releaseSnmpSession(session);
    }

    @Override
    public void callMain(String[] as) {
        try {
            Naming.rebind("SnmpExecutor", this);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        isInitialized = true;
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void shutDown() {
        isInitialized = false;
    }

}
