package com.winnertel.lct.batch.proxy;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.lct.batch.LctContants;
import com.winnertel.lct.batch.protocol.XmlTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class XmlProxy implements ISnmpProxy {
    private static final ILogger fLogger = LoggerController.createLogger(SnmpProxy.class);
    private final String host;

    private SnmpParameter fParameter;
    private XmlManager xmlManager;

    public XmlProxy(ISnmpParameter aParameter) {
        this(aParameter.getTargetHost());
        fParameter = (SnmpParameter) aParameter;
    }

    public XmlProxy(String targetHost) {
        host = targetHost;
        xmlManager = XmlManager.getInstance(host);
    }

    private int second2Millisecond(int timeout) {
        if (timeout > 1000) {
            return timeout;
        } else {
            return timeout * 1000;
        }
    }

    private int millisecond2Second(int timeout) {
        if (timeout > 1000) {
            return timeout / 1000;
        } else {
            return timeout;
        }
    }

    @Override
    public Vector<Object[]> loadTable(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return loadTable(anOidList, null);
    }

    @Override
    public Vector<Object[]> loadTable(String[] anOidList, int[] indexByteCountList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return loadTable(anOidList, null, 1);
    }

    @Override
    public Vector<Object[]> loadTable(String[] anOidList, int[] indexByteCountList, int rowsPerFetch) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return loadTable(anOidList, indexByteCountList, rowsPerFetch, 0);
    }

    @Override
    public Vector<Object[]> loadTable(String[] anOidList, int[] indexByteCountList, int rowsPerFetch, int retrieveCount) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return loadTable(anOidList, indexByteCountList, rowsPerFetch, retrieveCount, null, null);
    }

    @Override
    public Vector<Object[]> loadTable(final String[] anOidList, int[] indexByteCountList, int rowsPerFetch, int retrieveCount, String aSubTableIndex) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        return loadTable(anOidList, indexByteCountList, rowsPerFetch, retrieveCount, null, null);
    }

    @Override
    public Vector<Object[]> loadTable(String[] anOidList, int[] indexByteCountList, int rowsPerFetch, int retrieveCount, String aSubTableIndex, String indexPrefix) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        String[] split = anOidList[0].split("\\.");
        String tableName = split[0];
        List<Map<String, Object>> listMap = xmlManager.readAll(XmlTable.valueOf(tableName));

        Vector<Object[]> result = new Vector<>();

        for (Map<String, Object> map : listMap) {
            Object[] objs = new Object[anOidList.length + indexByteCountList.length];
            for (int i = 0; i < indexByteCountList.length; i++) {
                objs[i] = map.getOrDefault(String.format("index.%d", i), "");
            }
            for (int i = 0; i < anOidList.length; i++) {
                objs[indexByteCountList.length + i] = map.getOrDefault(anOidList[i].substring(tableName.length() + 1), "");
            }
            result.add(objs);
        }

        return result;
    }

    @Override
    public Object[] loadRow(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        String[] split = anOidList[0].split("\\.");
        String tableName = split[0];
        Map<String, Object> map = xmlManager.read(XmlTable.valueOf(tableName));

        Object[] objs = new Object[anOidList.length];

        for (int i = 0; i < anOidList.length; i++) {
            objs[i] = map.getOrDefault(anOidList[i].substring(tableName.length() + 1), "");
        }


        return objs;
    }

    /**
     * This method is useless forever
     */
    @Override
    @Deprecated
    public Object[] loadRow(String[] anOidList, int[] indexByteCountList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {

        return loadRow(anOidList);
    }

    @Override
    public boolean saveRow(String[] anOidList, Object[] aValueList, byte[] aTypeList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        String[] split = anOidList[0].split("\\.");
        XmlTable xmlTable = XmlTable.valueOf(split[0]);

        HashMap<String, Object> map = new HashMap<>();
        for (int i = 2; i < split.length; i++) {
            map.put(String.format("index.%d", i - 2), split[i]);
        }

        for (int i = 0; i < anOidList.length; i++) {
            String oid = anOidList[i];
            String[] spl = oid.split("\\.");
            map.put(spl[1], aValueList[i]);
        }

        String operation = map.getOrDefault(LctContants.OPERATION, LctContants.MODIFY).toString();
        switch (operation) {
            case LctContants.ADD:
                xmlManager.add(xmlTable, map);
                break;
            case LctContants.MODIFY:
                xmlManager.modify(xmlTable, map);
                break;
            case LctContants.DELETE:
                xmlManager.delete(xmlTable, map);
                break;
            default:
                throw new RuntimeException("operation not supported");
        }


        // 1. prepare request PDU
//        com.winnertel.snmp.snmp2.SnmpPDU requestPdu = new com.winnertel.snmp.snmp2.SnmpPDU();
//        initRequestPdu(requestPdu);
//        requestPdu.setCommand(ISnmpConstant.SET_REQ_MSG);
//
//        for (int i = 0; i < aValueList.length; i++) {
//            com.winnertel.snmp.snmp2.SnmpVar tmpVar = createSnmpVar(aValueList[i], aTypeList[i]);
//            requestPdu.addVariableBinding(new com.winnertel.snmp.snmp2.SnmpVarBind(new com.winnertel.snmp.snmp2.SnmpOID(anOidList[i]), tmpVar));
//        }
//
//        // 2. send request and get response
//        com.winnertel.snmp.snmp2.SnmpPDU responsePdu = null;
//        try {
//            responsePdu = fSnmpExecutor.syncSend(requestPdu);
//
//            if (responsePdu == null) {
//                fLogger.error("Response PDU is null");
//                return false;
//            }
//
//            if (hasErrorInResponse(responsePdu)) {
//                throw buildException(responsePdu);
//            }
//
//        } catch (RemoteException e) {
//            fLogger.error("Error in lookup remote api", e);
//            return false;
//        }

        return true;
    }

    public synchronized void releaseResources() {

    }

    public synchronized void addTrapListener(com.winnertel.snmp.beans.SnmpTrapListener aSnmpTrapListener) {

    }

    @Override
    public void setTargetHost(String aHost) {
        fParameter.setTargetHost(aHost);
    }

    @Override
    public String getTargetHost() {
        return fParameter.getTargetHost();
    }

    @Override
    public void setReadCommunity(String aCommunity) {
        fParameter.setReadCommunity(aCommunity);
    }

    @Override
    public String getReadCommunity() {
        return fParameter.getReadCommunity();
    }

    @Override
    public void setWriteCommunity(String aCommunity) {
        fParameter.setWriteCommunity(aCommunity);
    }

    @Override
    public String getWriteCommunity() {
        return fParameter.getWriteCommunity();
    }

    @Override
    public void setSnmpVersion(int aVersion) {
        fParameter.setSnmpVersion(aVersion);
    }

    @Override
    public int getSnmpVersion() {
        return fParameter.getSnmpVersion();
    }

    @Override
    public void setTargetPort(int aPort) {
        fParameter.setTargetPort(aPort);
    }

    @Override
    public int getTargetPort() {
        return fParameter.getTargetPort();
    }

    @Override
    public void setTimeout(int aTimeout) {
        fParameter.setTimeout(second2Millisecond(aTimeout));
    }

    @Override
    public int getTimeout() {
        return millisecond2Second(fParameter.getTimeout());
    }

    @Override
    public void setRetries(int aRetries) {
        fParameter.setRetries(aRetries);
    }

    @Override
    public int getRetries() {
        return fParameter.getRetries();
    }

    public ISnmpParameter getParameter() {
        return fParameter;
    }

    public void setParameter(ISnmpParameter fParameter) {
        this.fParameter = (SnmpParameter) fParameter;
    }
}
