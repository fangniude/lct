package com.winnertel.em.standard.snmp;

import com.winnertel.em.framework.model.snmp.DefaultSnmpPduException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpExecutor;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.inms.topoui.Main;
import com.winnertel.nms.lite.LiteContext;
import com.winnertel.snmp.snmp2.SnmpPDU;

import java.applet.Applet;
import java.math.BigInteger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class SnmpProxy implements ISnmpProxy {
    private ILogger fLogger = LoggerController.createLogger(SnmpProxy.class);

    private SnmpParameter fParameter;

    private ISnmpExecutor fSnmpExecutor;

    private SnmpTrapReceiverProxy fTrapReceiver = null;

    public SnmpProxy(ISnmpParameter aParameter) {
        fParameter = (SnmpParameter) aParameter;
        initSnmpExecutor();
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

    private void initSnmpExecutor() {
        if (fParameter.isClient() && !LiteContext.isLCTModel()) {
            try {
                fSnmpExecutor = (ISnmpExecutor) Naming.lookup(String.format("rmi://%s:%s/SnmpExecutor", "192.168.6.158", Main.RMI_PORT));
                return;
            } catch (Exception e) {
                fLogger.error("Error in lookup remote api", e);
            }
        }
        try {
            fSnmpExecutor = new SnmpExecutor();
        } catch (RemoteException e) {
            fLogger.error("Error in create SnmpExecutor", e);
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
        if (rowsPerFetch > 1 && fParameter.getSnmpVersion() == ISnmpConstant.VERSION1) {
            throw new com.winnertel.snmp.snmp2.DefaultSnmpException("Get bulk request is not support in SNMP v1 protocol");
        }

        fLogger.debug("rowsPerFetch:" + rowsPerFetch + ", retrieveCount:" + retrieveCount + ", subTableIndex:" + aSubTableIndex + ", indexPrefix:" + indexPrefix);

        // 0. indexPrefix is all index, turn to get request.
        if (prefixIsAllIndex(indexByteCountList, indexPrefix)) {
            fLogger.debug("Now, the index prefix is all index, turn to get request");

            return loadRow(anOidList, indexByteCountList, indexPrefix);

        }

        // 1. prepare the first OID List
        String[] firstOidList = anOidList.clone();
        if (aSubTableIndex != null && aSubTableIndex.length() > 0) {
            for (int i = 0; i < firstOidList.length; i++) {
                firstOidList[i] += aSubTableIndex;
            }
        }

        // 2. get the responseVarBind
        Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList = new Vector<com.winnertel.snmp.snmp2.SnmpVarBind>();
        try {
            fetchData(varBindList, firstOidList, anOidList, rowsPerFetch, retrieveCount, indexPrefix);
        } catch (RemoteException e) {
            fLogger.error("Error in lookup remote api", e);
        }

        // 3. transform result from varBind to object[] and return
        return transformResult(varBindList, anOidList, indexByteCountList);
    }

    private Vector<Object[]> loadRow(String[] anOidList, int[] indexByteCountList, String indexPrefix) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        Vector<Object[]> result = new Vector<Object[]>();

        String[] prefixIndexOidList = new String[anOidList.length];
        for (int i = 0; i < anOidList.length; i++) {
            prefixIndexOidList[i] = anOidList[i] + "." + indexPrefix;
        }

        Object[] rowVar = loadRow(prefixIndexOidList);

        if (recordExist(rowVar)) {
            Object[] rowData = new Object[indexByteCountList.length + rowVar.length];

            System.arraycopy(rowVar, 0, rowData, indexByteCountList.length, rowVar.length);

            long[] subIndex = buildSubOidArray(anOidList[0], prefixIndexOidList[0]);
            generateIndexValue(subIndex, indexByteCountList, rowData);

            result.add(rowData);
        }

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
        do {

            // 1. prepare request PDU
            com.winnertel.snmp.snmp2.SnmpPDU requestPdu = new com.winnertel.snmp.snmp2.SnmpPDU();
            initRequestPdu(requestPdu);
            if (rowsPerFetch > 1) {// getBulk
                requestPdu.setCommand(ISnmpConstant.GETBULK_REQ_MSG);
                requestPdu.setNonRepeaters(0);
                requestPdu.setMaxRepetitions(rowsPerFetch);
                fLogger.debug("GetBulk request. rowsPerFetch:" + rowsPerFetch);
            } else {// getNextRequest
                requestPdu.setCommand(ISnmpConstant.GETNEXT_REQ_MSG);
            }

            for (int i = 0; i < oidList.length; i++) {
                requestPdu.addVariableBinding(new com.winnertel.snmp.snmp2.SnmpVarBind(new com.winnertel.snmp.snmp2.SnmpOID(oidList[i]), null));
            }

            // 2. send request and get response
            com.winnertel.snmp.snmp2.SnmpPDU responsePdu = fSnmpExecutor.syncSend(requestPdu);
            if (responsePdu == null) {
                fLogger.error("Response PDU is null");
                return;
            }

            // 3. package the result
            @SuppressWarnings("unchecked") Vector<com.winnertel.snmp.snmp2.SnmpVarBind> variableBindings = responsePdu.getVariableBindings();

            for (int i = 0; i < variableBindings.size(); i++) {
                com.winnertel.snmp.snmp2.SnmpVarBind varBind = variableBindings.get(i);

                if (reachEnd(varBindList, varBind, anOidList, retrieveCount, indexPrefix)) {
                    return;
                } else {
                    varBindList.add(varBind);

                    // the records is enough
                    int rowsCount = varBindList.size() / anOidList.length;
                    if (retrieveCount > 0 && rowsCount >= retrieveCount) {
                        fLogger.debug("Reach end: the records is enough. rowsCount:" + rowsCount);
                        return;
                    }
                }
            }

            // 4. prepare the next request OID List
            String[] nextRequestOidList = new String[anOidList.length];
            int startIndex = varBindList.size() - anOidList.length;
            for (int i = 0; i < nextRequestOidList.length; i++) {
                nextRequestOidList[i] = varBindList.get(startIndex + i).getObjectID().toString();

                // next OID is the same as current
                if (oidList[i].equals(nextRequestOidList[i])) {
                    return;
                }
            }

            oidList = nextRequestOidList;

            // 5. recursion
            // fetchNextRow(varBindList, nextRequestOidList, anOidList,
            // rowsPerFetch, retrieveCount, indexPrefix);
        } while (true);

    }

    private boolean reachEnd(Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList, com.winnertel.snmp.snmp2.SnmpVarBind varBind, String[] anOidList, int retrieveCount, String indexPrefix) {
        // 1. varBind == null
        if (varBind == null) {
            fLogger.debug("Reach end: varBind is null");
            return true;
        }

        // 2. the oid is wrong
        String strVarOid = varBind.getObjectID().toString();
        int col = varBindList.size() % anOidList.length;// current column
        if (!strVarOid.startsWith(anOidList[col])) {
            fLogger.debug("Reach end: the oid <" + strVarOid + "> is not start with <" + anOidList[col] + ">");
            return true;
        }

        // 3. the index is prefix
        if (indexPrefix != null && indexPrefix.length() > 0) {
            String index = strVarOid.substring(anOidList[col].length() + 1);
            if (reachEndOfIndex(index, indexPrefix)) {
                fLogger.debug("Reach end: the index: <" + index + "> is not prefix: <" + indexPrefix + ">");
                return true;
            }
        }

        // 4. end of MIB view
        if (varBind.getErrindex() == ISnmpConstant.ENDOFMIBVIEW || varBind.getErrindex() == ISnmpConstant.ENDOFMIBVIEWEXP) {
            fLogger.debug("Reach end: end of mib view.");
            return true;
        }

        return false;
    }

    private Vector<Object[]> transformResult(Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList, String[] anOidList, int[] indexByteCountList) {
        Vector<Object[]> result = new Vector<Object[]>();

        int rowCount = varBindList.size() / anOidList.length;
        for (int i = 0; i < rowCount; i++) {
            com.winnertel.snmp.snmp2.SnmpVar[] rowVar = new com.winnertel.snmp.snmp2.SnmpVar[anOidList.length];

            // 1. get the row data
            for (int j = 0; j < anOidList.length; j++) {
                int index = i * anOidList.length + j;
                rowVar[j] = varBindList.get(index).getVariable();
            }

            // 2. transform one row data from SnmpVar[] to Object[]
            Object[] rowData = extractVarObject(rowVar, indexByteCountList);

            // 3. set the index to rowData
            long[] subIndex = buildSubOidArray(anOidList[0], varBindList.get(i * anOidList.length).getObjectID().toString());
            generateIndexValue(subIndex, indexByteCountList, rowData);

            result.add(rowData);
        }

        return result;
    }

    @Override
    public Object[] loadRow(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException {
        // 1. prepare request PDU
        com.winnertel.snmp.snmp2.SnmpPDU requestPdu = new com.winnertel.snmp.snmp2.SnmpPDU();
        initRequestPdu(requestPdu);
        requestPdu.setCommand(ISnmpConstant.GET_REQ_MSG);

        for (int i = 0; i < anOidList.length; i++) {
            requestPdu.addVariableBinding(new com.winnertel.snmp.snmp2.SnmpVarBind(new com.winnertel.snmp.snmp2.SnmpOID(anOidList[i]), null));
        }

        // 2. send request and get response
        com.winnertel.snmp.snmp2.SnmpPDU responsePdu = null;
        try {
            responsePdu = fSnmpExecutor.syncSend(requestPdu);
        } catch (RemoteException e) {
            fLogger.error("Error in lookup remote api", e);
            return null;
        }

        if (responsePdu == null) {
            fLogger.error("Response PDU is null");
            throw new com.winnertel.snmp.snmp2.DefaultSnmpException("Response PDU is null");
        }

        // 3. get varBind and transform to varArray
        @SuppressWarnings("unchecked") Vector<com.winnertel.snmp.snmp2.SnmpVarBind> varBindList = responsePdu.getVariableBindings();
        com.winnertel.snmp.snmp2.SnmpVar[] rowVar = new com.winnertel.snmp.snmp2.SnmpVar[anOidList.length];
        for (int i = 0; i < anOidList.length; i++) {
            rowVar[i] = varBindList.get(i).getVariable();
        }

        // 4. transform one row data from SnmpVar[] to Object[]
        Object[] rowData = extractVarObject(rowVar, null);

        return rowData;
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
        com.winnertel.snmp.snmp2.SnmpPDU requestPdu = new com.winnertel.snmp.snmp2.SnmpPDU();
        initRequestPdu(requestPdu);
        requestPdu.setCommand(ISnmpConstant.SET_REQ_MSG);

        for (int i = 0; i < aValueList.length; i++) {
            com.winnertel.snmp.snmp2.SnmpVar tmpVar = createSnmpVar(aValueList[i], aTypeList[i]);
            requestPdu.addVariableBinding(new com.winnertel.snmp.snmp2.SnmpVarBind(new com.winnertel.snmp.snmp2.SnmpOID(anOidList[i]), tmpVar));
        }

        // 2. send request and get response
        com.winnertel.snmp.snmp2.SnmpPDU responsePdu = null;
        try {
            responsePdu = fSnmpExecutor.syncSend(requestPdu);

            if (responsePdu == null) {
                fLogger.error("Response PDU is null");
                return false;
            }

            if (hasErrorInResponse(responsePdu)) {
                throw buildException(responsePdu);
            }

        } catch (RemoteException e) {
            fLogger.error("Error in lookup remote api", e);
            return false;
        }

        return true;
    }

    private DefaultSnmpPduException buildException(SnmpPDU responsePdu) {
        int errindex = responsePdu.getErrindex();
        int errstat = responsePdu.getErrstat();
        int reqid = responsePdu.getReqid();
        String agentAddr = responsePdu.getAgentAddr();

        DefaultSnmpPduException pduException = new DefaultSnmpPduException();
        pduException.setErrorIndex(errindex);
        pduException.setErrorStatus(errstat);

        pduException.setRequestId(reqid);
        pduException.setLocalAddress(agentAddr);

        fLogger.debug("Error index:" + errindex + ", Error status:" + errstat + ", request id:" + reqid + ", localaddress:" + agentAddr);
        return pduException;
    }

    private boolean hasErrorInResponse(com.winnertel.snmp.snmp2.SnmpPDU responsePdu) {
        switch (responsePdu.getErrstat()) {
            case 0:
            case -1:
                return false;
            default:
                return true;
        }
    }

    private void initRequestPdu(com.winnertel.snmp.snmp2.SnmpPDU requestPdu) {
        requestPdu.setRemoteHost(fParameter.getTargetHost());
        requestPdu.setRemotePort(fParameter.getTargetPort());

        requestPdu.setAgentAddr(fParameter.getTargetHost());

        requestPdu.setVersion(fParameter.getSnmpVersion());

        requestPdu.setCommunity(fParameter.getReadCommunity());
        requestPdu.setWriteCommunity(fParameter.getWriteCommunity());

        requestPdu.setTimeout(second2Millisecond(fParameter.getTimeout()));
        requestPdu.setRetries(fParameter.getRetries());

        fLogger.debug("timeout(ms):" + requestPdu.getTimeout() + ", Retries:" + requestPdu.getRetries());
    }

    private void generateIndexValue(long[] subOidArray, int[] indexByteCountList, Object[] data) {
        if (indexByteCountList == null || indexByteCountList.length == 0) {
            return;
        }

        int indexCount = indexByteCountList.length;
        int totalByteCount = 0;
        for (int i = 0; i < indexCount; i++) {
            Object result = null;
            StringBuffer sb = new StringBuffer();
            int byteCount = indexByteCountList[i];
            switch (byteCount) {
                case 1: // integer
                    result = new Integer((int) subOidArray[totalByteCount]);
                    break;

                case 2: // long
                    result = new Long(subOidArray[totalByteCount]);
                    byteCount = 1;
                    break;

                case 4: // ip address
                    for (int j = 0; j < byteCount; j++) {
                        sb.append(subOidArray[totalByteCount + j]);
                        if (j < byteCount - 1) {
                            sb.append('.');
                        }
                    }
                    result = sb.toString();
                    break;

                case 6: // mac address
                    byte[] macAddress = new byte[byteCount];
                    for (int j = 0; j < byteCount; j++) {
                        macAddress[j] = (byte) subOidArray[totalByteCount + j];
                    }
                    result = macAddress;
                    break;

                /*
                * case 0: // variable string int len = subOidArray[totalByteCount];
                * totalByteCount++; char[] ca = new char[len]; for (int j = 0; j <
                * len; j++) { ca[j] = (char) subOidArray[totalByteCount + j]; }
                * result = ca; totalByteCount += len; break;
                */

                case 0: // object id
                    result = "";
                    for (int j = 0; j < subOidArray.length; j++) {
                        if (j == subOidArray.length - 1)
                            result = result + (subOidArray[j] + "");
                        else
                            result = result + (subOidArray[j] + ".");

                    }
                    break;

                case -2: // variable string without length indicator
                    int vLen = subOidArray.length - totalByteCount;
                    byte[] vba = new byte[vLen];
                    for (int j = 0; j < vLen; j++) {
                        vba[j] = (byte) subOidArray[totalByteCount + j];
                    }
                    result = vba;
                    totalByteCount += vLen;
                    break;

                case -1: // variable string with length indicator
                    vLen = (int) subOidArray[totalByteCount];
                    totalByteCount++;
                    vba = new byte[vLen];
                    for (int j = 0; j < vLen; j++) {
                        vba[j] = (byte) subOidArray[totalByteCount + j];
                    }
                    result = vba;
                    totalByteCount += vLen;
                    break;

                default: // fixed string
                    int start = totalByteCount;
                    int end = start + byteCount;
                    byte[] ba = new byte[byteCount];
                    int k = 0;
                    for (int j = start; j < end; j++) {
                        ba[k] = (byte) subOidArray[j];
                        k++;
                    }
                    result = ba;

                    break;
            }
            data[i] = result;
            if (byteCount > 0) {
                totalByteCount += byteCount;
            }
        }
    }

    private long[] buildSubOidArray(String oldOid, String newOid) {
        long[] oldItemIndex = new com.winnertel.snmp.snmp2.SnmpOID(oldOid).toLongArray();
        long[] newItemIndex = new com.winnertel.snmp.snmp2.SnmpOID(newOid).toLongArray();
        long[] subOidArray = new long[newItemIndex.length - oldItemIndex.length];
        System.arraycopy(newItemIndex, oldItemIndex.length, subOidArray, 0, newItemIndex.length - oldItemIndex.length);
        return subOidArray;
    }

    /**
     * transform one row data from SnmpVar[] to Object[]
     *
     * @param aSnmpVar
     * @param indexByteCountList
     * @return
     */
    private Object[] extractVarObject(com.winnertel.snmp.snmp2.SnmpVar[] aSnmpVar, int[] indexByteCountList) {
        boolean returnIndex = (indexByteCountList != null);
        int indexCount = (returnIndex ? indexByteCountList.length : 0);
        int size = (returnIndex ? aSnmpVar.length + indexCount : aSnmpVar.length);
        Object[] objectList = new Object[size];
        int i = (returnIndex ? indexCount : 0);
        for (; i < objectList.length; i++) {
            int varIndex = (returnIndex ? i - indexCount : i);
            com.winnertel.snmp.snmp2.SnmpVar var = aSnmpVar[varIndex];
            Object value = null;
            byte varType = var.getType();
            switch (varType) {
                case ISnmpConstant.STRING:
                    value = var.toBytes();
                    break;
                case ISnmpConstant.COUNTER64:
                    value = ((com.winnertel.snmp.snmp2.SnmpCounter64) var).toBigInteger();
                    break;
                default:
                    value = var.getVarObject();
                    break;
            }
            objectList[i] = value;
        }

        return objectList;
    }

    private boolean reachEndOfIndex(String index, String indexPrefix) {
        if (index != null && indexPrefix != null) {
            String[] split1 = index.split("\\.");
            String[] split2 = indexPrefix.split("\\.");

            if (split1.length < split2.length) {
                return true;
            }

            for (int i = 0; i < split2.length; i++) {
                if (!split2[i].equals(split1[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    private com.winnertel.snmp.snmp2.SnmpVar createSnmpVar(Object aValue, byte aType) {
        com.winnertel.snmp.snmp2.SnmpVar result = null;
        switch (aType) {
            case ISnmpConstant.INTEGER:
                result = new com.winnertel.snmp.snmp2.SnmpInt(((Integer) aValue).intValue());
                break;
            case ISnmpConstant.IP_ADDRESS:
                if (aValue instanceof String) {
                    result = new com.winnertel.snmp.snmp2.SnmpIpAddress((String) aValue);
                } else if (aValue instanceof byte[]) {
                    result = new com.winnertel.snmp.snmp2.SnmpIpAddress((byte[]) aValue);
                }
                break;
            case ISnmpConstant.COUNTER:
                result = new com.winnertel.snmp.snmp2.SnmpCounter(((Long) aValue).longValue());
                break;
            case ISnmpConstant.COUNTER64:
                result = new com.winnertel.snmp.snmp2.SnmpCounter64((BigInteger) aValue);
                break;
            case ISnmpConstant.GAUGE:
                result = new com.winnertel.snmp.snmp2.SnmpGauge(((Long) aValue).longValue());
                break;
            case ISnmpConstant.TIME_TICKS:
                result = new com.winnertel.snmp.snmp2.SnmpTimeticks(((Long) aValue).longValue());
                break;
            case ISnmpConstant.STRING:
                if (aValue == null) {
                    aValue = "";
                }
                result = new com.winnertel.snmp.snmp2.SnmpString(((String) aValue).getBytes());
                break;
            case ISnmpConstant.MAC_ADDRESS:
                result = new com.winnertel.snmp.snmp2.SnmpString((byte[]) aValue);
                break;
            case ISnmpConstant.OCTETS:
                result = new com.winnertel.snmp.snmp2.SnmpString((byte[]) aValue);
                break;
            case ISnmpConstant.OBJID:
                result = new com.winnertel.snmp.snmp2.SnmpOID((String) aValue);
                break;
        }

        return result;
    }

    public synchronized void releaseResources() {
        if (fTrapReceiver != null) {
            fTrapReceiver.removeTrapListener(fTrapReceiver);
        }
        // fSnmpTarget.releaseResources();
    }

    public synchronized void addTrapListener(com.winnertel.snmp.beans.SnmpTrapListener aSnmpTrapListener) {
        if (fTrapReceiver != null) {
            fTrapReceiver.addTrapListener(fParameter.getTargetHost(), fParameter.getReadCommunity(), aSnmpTrapListener);
        }
    }

    /**
     * SnmpTrapReceiverProxy is a snmp trap receiver. It receiver trap from
     * agent or SAS server and forward to appropriate trap listener.
     */
    private static class SnmpTrapReceiverProxy extends com.winnertel.snmp.beans.SnmpTrapReceiver implements com.winnertel.snmp.beans.SnmpTrapListener {
        private Hashtable fListenerMap = new Hashtable();

        public SnmpTrapReceiverProxy() {
        }

        public SnmpTrapReceiverProxy(Applet aApplet) {
            super(aApplet);
        }

        public void addTrapListener(String anIpAddress, String aCommunity, com.winnertel.snmp.beans.SnmpTrapListener aSnmpTrapListener) {
            fListenerMap.put(new ProxyKeyObject(anIpAddress, aCommunity), aSnmpTrapListener);
        }

        public void receivedTrap(com.winnertel.snmp.beans.SnmpTrapEvent event) {
            String remoteHost = event.getRemoteHost();
            String community = event.getCommunity();

            // find the listenerSnmp by remote host
            com.winnertel.snmp.beans.SnmpTrapListener listenerSnmp = null;
            Set keySet = fListenerMap.keySet();
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                ProxyKeyObject key = (ProxyKeyObject) it.next();
                if (remoteHost.equals(key.getIpAddress()) && community.equals(key.getCommunity())) {
                    listenerSnmp = (com.winnertel.snmp.beans.SnmpTrapListener) fListenerMap.get(key);
                    break;
                }
            }

            if (listenerSnmp != null) {
                listenerSnmp.receivedTrap(event);
            }
        }

        private class ProxyKeyObject {
            private String fIpAddress = null;
            private String fCommunity = null;

            public ProxyKeyObject(String anIpAddress, String aCommunity) {
                fIpAddress = anIpAddress;
                fCommunity = aCommunity;
            }

            public String getIpAddress() {
                return fIpAddress;
            }

            public String getCommunity() {
                return fCommunity;
            }

            public String toString() {
                return fIpAddress + " " + fCommunity;
            }
        }
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

    public ISnmpExecutor getSnmpExecutor() {
        return fSnmpExecutor;
    }

    public void setSnmpExecutor(ISnmpExecutor fSnmpExecutor) {
        this.fSnmpExecutor = fSnmpExecutor;
    }

}
