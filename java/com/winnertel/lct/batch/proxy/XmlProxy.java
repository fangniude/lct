package com.winnertel.lct.batch.proxy;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.lct.batch.protocol.OltVlan;

import java.rmi.RemoteException;
import java.util.*;

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
        List<Map<String, Object>> listMap = new ArrayList<>();
        switch (String.format("%s.%s", split[0], split[1])) {
            case "olt.system":
                break;
            case "olt.vlan":
                List<OltVlan> vlanList = xmlManager.getOltBase().getVlanList();
                for (OltVlan vlan : vlanList) {
                    Map<String, Object> map = vlan.toMap();
                    listMap.add(map);
                }
                break;
            case "olt.qinq":
                break;
            case "onu.mac":
                break;
            case "onu.cfg":
                break;
            case "onu.uni":
                break;
            case "profile.onu":
                break;
            case "profile.uni":
                break;
            default:
                throw new RuntimeException("not supported");
        }

        Vector<Object[]> result = new Vector<>();

        for (Map<String, Object> map : listMap) {
            Object[] objs = new Object[anOidList.length];
            for (int i = 0; i < anOidList.length; i++) {
                String oid = anOidList[i];
                objs[i] = map.getOrDefault(oid, "");
            }
            result.add(objs);
        }

        return result;

//        if (rowsPerFetch > 1 && fParameter.getSnmpVersion() == ISnmpConstant.VERSION1) {
//            throw new com.winnertel.snmp.snmp2.DefaultSnmpException("Get bulk request is not support in SNMP v1 protocol");
//        }
//
//        fLogger.debug("rowsPerFetch:" + rowsPerFetch + ", retrieveCount:" + retrieveCount + ", subTableIndex:" + aSubTableIndex + ", indexPrefix:" + indexPrefix);
//
//        // 0. indexPrefix is all index, turn to get request.
//        if (prefixIsAllIndex(indexByteCountList, indexPrefix)) {
//            fLogger.debug("Now, the index prefix is all index, turn to get request");
//
//            return loadRow(anOidList, indexByteCountList, indexPrefix);
//
//        }
//
//        // 1. prepare the first OID List
//        String[] firstOidList = anOidList.clone();
//        if (aSubTableIndex != null && aSubTableIndex.length() > 0) {
//            for (int i = 0; i < firstOidList.length; i++) {
//                firstOidList[i] += aSubTableIndex;
//            }
//        }
//
//        // 2. get the responseVarBind
//        Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList = new Vector<com.winnertel.snmp.snmp2.SnmpVarBind>();
//        try {
//            fetchData(varBindList, firstOidList, anOidList, rowsPerFetch, retrieveCount, indexPrefix);
//        } catch (RemoteException e) {
//            fLogger.error("Error in lookup remote api", e);
//        }
//
//        // 3. transform result from varBind to object[] and return
//        return transformResult(varBindList, anOidList, indexByteCountList);

//        return new Vector<Object[]>();
    }

    private Vector<Object[]> loadRow(String[] anOidList, int[] indexByteCountList, String indexPrefix) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        Vector<Object[]> result = new Vector<Object[]>();

//        String[] prefixIndexOidList = new String[anOidList.length];
//        for (int i = 0; i < anOidList.length; i++) {
//            prefixIndexOidList[i] = anOidList[i] + "." + indexPrefix;
//        }
//
//        Object[] rowVar = loadRow(prefixIndexOidList);
//
//        if (recordExist(rowVar)) {
//            Object[] rowData = new Object[indexByteCountList.length + rowVar.length];
//
//            System.arraycopy(rowVar, 0, rowData, indexByteCountList.length, rowVar.length);
//
//            long[] subIndex = buildSubOidArray(anOidList[0], prefixIndexOidList[0]);
//            generateIndexValue(subIndex, indexByteCountList, rowData);
//
//            result.add(rowData);
//        }

        return result;
    }

    private boolean recordExist(Object[] rowVar) {
        if (rowVar != null) {
            for (int i = 0; i < rowVar.length; i++) {
                if (rowVar[i] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean prefixIsAllIndex(int[] indexByteCountList, String indexPrefix) {
        if (indexPrefix != null && indexPrefix.trim().length() != 0) {
            String[] indexArray = indexPrefix.split("\\.");

            if (indexByteCountList.length == indexArray.length) {
                return true;
            }
        }

        return false;
    }

    private void fetchData(final Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList, String[] oidList, final String[] anOidList, final int rowsPerFetch, final int retrieveCount, final String indexPrefix) throws RemoteException, com.winnertel.snmp.snmp2.DefaultSnmpException {

    }

    private boolean reachEnd(Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList, com.winnertel.snmp.snmp2.SnmpVarBind varBind, String[] anOidList, int retrieveCount, String indexPrefix) {
        // 1. varBind == null
//        if (varBind == null) {
//            fLogger.debug("Reach end: varBind is null");
//            return true;
//        }
//
//        // 2. the oid is wrong
//        String strVarOid = varBind.getObjectID().toString();
//        int col = varBindList.size() % anOidList.length;// current column
//        if (!strVarOid.startsWith(anOidList[col])) {
//            fLogger.debug("Reach end: the oid <" + strVarOid + "> is not start with <" + anOidList[col] + ">");
//            return true;
//        }
//
//        // 3. the index is prefix
//        if (indexPrefix != null && indexPrefix.length() > 0) {
//            String index = strVarOid.substring(anOidList[col].length() + 1);
//            if (reachEndOfIndex(index, indexPrefix)) {
//                fLogger.debug("Reach end: the index: <" + index + "> is not prefix: <" + indexPrefix + ">");
//                return true;
//            }
//        }
//
//        // 4. end of MIB view
//        if (varBind.getErrindex() == ISnmpConstant.ENDOFMIBVIEW || varBind.getErrindex() == ISnmpConstant.ENDOFMIBVIEWEXP) {
//            fLogger.debug("Reach end: end of mib view.");
//            return true;
//        }

        return false;
    }

    private Vector<Object[]> transformResult(Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList, String[] anOidList, int[] indexByteCountList) {
        Vector<Object[]> result = new Vector<Object[]>();

//        int rowCount = varBindList.size() / anOidList.length;
//        for (int i = 0; i < rowCount; i++) {
//            com.winnertel.snmp.snmp2.SnmpVar[] rowVar = new com.winnertel.snmp.snmp2.SnmpVar[anOidList.length];
//
//            // 1. get the row data
//            for (int j = 0; j < anOidList.length; j++) {
//                int index = i * anOidList.length + j;
//                rowVar[j] = varBindList.get(index).getVariable();
//            }
//
//            // 2. transform one row data from SnmpVar[] to Object[]
//            Object[] rowData = extractVarObject(rowVar, indexByteCountList);
//
//            // 3. set the index to rowData
//            long[] subIndex = buildSubOidArray(anOidList[0], varBindList.get(i * anOidList.length).getObjectID().toString());
//            generateIndexValue(subIndex, indexByteCountList, rowData);
//
//            result.add(rowData);
//        }

        return result;
    }

    @Override
    public Object[] loadRow(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        // 1. prepare request PDU
//        com.winnertel.snmp.snmp2.SnmpPDU requestPdu = new com.winnertel.snmp.snmp2.SnmpPDU();
//        initRequestPdu(requestPdu);
//        requestPdu.setCommand(ISnmpConstant.GET_REQ_MSG);
//
//        for (int i = 0; i < anOidList.length; i++) {
//            requestPdu.addVariableBinding(new com.winnertel.snmp.snmp2.SnmpVarBind(new com.winnertel.snmp.snmp2.SnmpOID(anOidList[i]), null));
//        }
//
//        // 2. send request and get response
//        com.winnertel.snmp.snmp2.SnmpPDU responsePdu = null;
//        try {
//            responsePdu = fSnmpExecutor.syncSend(requestPdu);
//        } catch (RemoteException e) {
//            fLogger.error("Error in lookup remote api", e);
//            return null;
//        }
//
//        if (responsePdu == null) {
//            fLogger.error("Response PDU is null");
//            throw new com.winnertel.snmp.snmp2.DefaultSnmpException("Response PDU is null");
//        }
//
//        // 3. get varBind and transform to varArray
//        @SuppressWarnings("unchecked") Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList = responsePdu.getVariableBindings();
//        com.winnertel.snmp.snmp2.SnmpVar[] rowVar = new com.winnertel.snmp.snmp2.SnmpVar[anOidList.length];
//        for (int i = 0; i < anOidList.length; i++) {
//            rowVar[i] = varBindList.get(i).getVariable();
//        }
//
//        // 4. transform one row data from SnmpVar[] to Object[]
//        Object[] rowData = extractVarObject(rowVar, null);
//
//        return rowData;

        return new Object[]{};
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
