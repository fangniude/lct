package com.winnertel.ems.epon.pm.impl.common;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r400.EponDeviceIndexFormatter;
import com.winnertel.ems.epon.inventory.OnuMODHelper;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.upm.common.commoninfo.entities.NamePair;
import com.winnertel.inms.upm.server.common.CollectorLog;
import com.winnertel.snmp.beans.SnmpDataException;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.DefaultSnmpException;
import com.winnertel.snmp.snmp2.SnmpCounter64;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpVar;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PmSnmpTarget {

//    static EponLogger log = LoggerUtility.getLogger(PmSnmpTarget.class);
    public static final int PORT = 161;
    public static final int VERSION = SnmpTarget.VERSION2C;
    public static final int RETRIES = 3;
    public static final int TIMEOUT = 5;
    public static final int NONREPEATERS = 0;
//mes set name
    public static final String L2_TABLE = "L2InterfaceStatistics";
    public static final String OLT_TABLE = "OltInterfaceStatistics";
    public static final String ONU_TABLE = "OnuInterfaceStatistics";
    public static final String DHCP_TABLE = "DHCPStatistic";
    public static final String RESOURCE_TABLE = "SysMonitorData";
    public static final String UNI_INTERFACE_TABLE = "UniInterfaceStatistics";
    public static final String ONU4024i_UNI_INTERFACE_TABLE = "Onu4024iUniInterfaceStatistics"; //added by Zhou Chao, 2009/5/18
    public static final String OLT_OPTIC_STATISTICS = "OLTOpticalLinkDiagnostics"; 
    public static final String ONU_OPTIC_STATISTICS = "ONUOpticalLinkDiagnostics";
    
    //bbs4606 mes set name
    public static final String CSMEthernetPort = "CSMEthernetPort";
    public static final String GponNNIPort = "GponNNIPort";
    public static final String GponAllocID = "GponAllocID";
    public static final String ONTUNIEthernetPort = "ONTUNIEthernetPort";
    public static final String ONTGEMPort = "ONTGEMPort";
    public static final String SYSTEM_RESOUCE = "System";
    public static final String OLTOpticalLayerStatistics = "OltTransceiver";
    public static final String ONTOpticalLayerStatistics = "OntTransceiver";

    private SnmpTarget target;
    private String ipAddress = null;
    private int port = 161;
    private String getCommunity = "public";
    private String wirteCommunity = "private";

    private String[] mibIndexes;

    /**
     * User defined constructor. Create an instance and set the target device's ip
     * address.
     *
     * @param hostIpAddr String: the ip address of target device.
     *                   <p/>
     *                   Creation date: (4/25/2002 9:14:48 PM)
     */
    public PmSnmpTarget(String hostIpAddr) {
        try {
            String neName = UTopoAPI.getAPI().getNodeNameByIP( hostIpAddr );
            Properties moProperty = UTopoAPI.getAPI().getByName( neName ).getProperties();//ServerUtility.getNePropertiesByIpAddr(hostIpAddr);
            if (moProperty != null) {
                getCommunity = moProperty.getProperty("getCommunity", "public");
                wirteCommunity = moProperty.getProperty("writeCommunity", "private");
                port = Integer.parseInt(moProperty.getProperty("portForSnmp", "161"));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }


        target = new SnmpTarget();
        target.setTargetHost(hostIpAddr);
        target.setTargetPort(this.port);
        target.setSnmpVersion(PmSnmpTarget.VERSION);
        target.setRetries(PmSnmpTarget.RETRIES);
        target.setTimeout(PmSnmpTarget.TIMEOUT);
        target.setNonRepeaters(PmSnmpTarget.NONREPEATERS);

        target.setCommunity(this.getCommunity);
        target.setWriteCommunity(this.wirteCommunity);
    }

    public PmSnmpTarget(String hostIpAddr, int port, String getCommunity) {
        this(hostIpAddr, port, getCommunity, "private");
    }

    public PmSnmpTarget(String hostIpAddr, int port, String readCommunity, String writeCommunity) {
        ipAddress = hostIpAddr;
        this.port = port;
        if (readCommunity != null)
            this.getCommunity = readCommunity;
        if (writeCommunity != null)
            this.wirteCommunity = writeCommunity;

        target = new SnmpTarget();
        target.setTargetHost(hostIpAddr);
        target.setTargetPort(this.port);
        target.setSnmpVersion(PmSnmpTarget.VERSION);
        target.setRetries(PmSnmpTarget.RETRIES);
        target.setTimeout(PmSnmpTarget.TIMEOUT);
        target.setNonRepeaters(PmSnmpTarget.NONREPEATERS);

        target.setCommunity(this.getCommunity);
        target.setWriteCommunity(this.wirteCommunity);
    }

    public void close() {
        if (target != null)
            target.releaseResources();
    }

    public void setIpAddress(String ip) {
        ipAddress = ip;
        target.setTargetHost(ip);
    }

    public void setReadCommunity(String readCommunity) {
        target.setCommunity(readCommunity);
    }

    public void setWriteCommunity(String writeCommunity) {
        target.setWriteCommunity(writeCommunity);
    }

    /**
     * This method retrieves all the rows in a mib table, using snmp GetNext.
     * Unlike the getTable() defined in superclass, SnmpTarget, this method allows
     * the user to specify any number of columns in the parameter, oidList, and in
     * any order. The oidList can be either oid numbers or named strings (label).
     * The method returns a two-dimensional array of Object type, containing the
     * values in exactly the same order as the oidList. The user needs to convert
     * Object type to the appropriate Java data types according to their mib
     * definition. For IP ADDRESS, NETWORK ADDRESS and OID mib types, the returned
     * is String type. If there is a snmp error, throws AdventNet DefaultSnmpException.
     * If table is empty, return an array with zero elements.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or
     *                named strings (label).
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table
     *         is empty.
     */

    public Object[][] getAllRows(String[] oidList) throws DefaultSnmpException {
        int colSize = oidList.length;
        String initOid = null; // inital last column oid.
        String curOid = null; // current row last column oid.
        String preIndex = null; // previous row index.
        String curIndex = null; // current row index.
        ArrayList rows = new ArrayList();
        ArrayList mibIdxes = new ArrayList();
        SnmpVar[] rowTemp = null;
        Object[] row = null;
        Object[][] values = null;

        target.setObjectIDList(oidList);
        // Get the initial last column oid from oid list.
        initOid = (target.getObjectIDList())[colSize - 1];
        // Set previous row index to empty string.
        preIndex = "";

        while (true) {
            rowTemp = target.snmpGetNextVariables();
            if ((rowTemp == null) || (target.getErrorCode() != 0)) {
                CollectorLog.Log("Can't get all rows from NE[" + ipAddress + "]: " + target.getErrorString());
                throw new DefaultSnmpException("SNMP GET NEXT ERROR: " + target.getErrorString());
            } else {
                row = new Object[rowTemp.length];
                for (int i = 0; i < rowTemp.length; i++) {
                    row[i] = rowTemp[i].getVarObject();
                }
            }

            // Get the last column oid of the current row.
            curOid = (target.getObjectIDList())[colSize - 1];
            if (curOid.startsWith(initOid)) {
                // Instance is in table.
                curIndex = curOid.substring(initOid.length() + 1);
                if (curIndex.equals(preIndex)) {
                    // Duplicate instance means end of mib.
                    break;
                } else {
                    // Get a instance (row).
                    rows.add(row);
                    mibIdxes.add(curIndex);
                    preIndex = curIndex;
                }
            } else {
                // End of table.
                break;
            }
        }

        values = new Object[rows.size()][colSize];
        mibIndexes = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            values[i] = (Object[]) rows.get(i);
            mibIndexes[i] = (String) mibIdxes.get(i);
        }

        return values;
    }

    /**
     * In some mib tables definition, the index column (or columns) are not
     * accessible. This method gives the user a convenient way to obtain the
     * indexes of all the instances in a table. the returned values are
     * String-valued variables. The user needs to convert them to the appropriate
     * Java data type according to their mib syntax (type). This method must be
     * invoked immediately after getAllRows() and the returned indexes are the
     * indexes of the table indicated by the argument, oidList, passed to the last
     * invocation of the method, getAllRows().
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @return java.lang.String[]: String-valued indexes for the mib table
     *         indicated by the argument, oidList, passed to the last invocation
     *         of the method, getAllRows().
     */

    public String[] getMibIndexes() {
        return mibIndexes;
    }

    /**
     * This method retrieves all the rows in a mib table, using snmp GetBulk. The
     * default maxRepetitions = 50 is used. If PDU is full, the method will return
     * null. If this case happens, you can adjust maxRepetitions using
     * setMaxRepetitions() method. This method allows the user to specify any
     * number of columns in the parameter, oidList, and in any order. The oidList
     * can be either oid numbers or named strings (label). The method returns a
     * two-dimensional array of Object type, containing the values in exactly the
     * same order as the oidList. The user needs to convert Object type to the
     * appropriate Java data types according to their mib definition. For IP
     * ADDRESS, NETWORK ADDRESS and OID mib types, the returned is String type. If
     * there is a snmp error, throws AdventNet DefaultSnmpException. If table is empty,
     * return an array with zero elements.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or
     *                named strings (label).
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table
     *         is empty.
     */

    public String[][] getTable(String[] oidList) throws DefaultSnmpException {
        int colSize = oidList.length;
        String preIndex = null; // previous row index.
        String curOid = null; // current row last column oid.
        String curIndex = null; // current row index.
        String initOid = null;
        ArrayList rows = new ArrayList();
        ArrayList mibIdxes = new ArrayList();

        SnmpVarBind[][] rowTemp = null;
        String[] row = null;
        String[][] values = null;

        target.setObjectIDList(oidList);
        initOid = (target.getSnmpOIDList())[0].toString();

        outer:
        while (true) {
            rowTemp = target.snmpGetBulkVariableBindings();
            if ((rowTemp == null) || (target.getErrorCode() != 0)) {
                //CollectorLog.Log("Can't get table from NE[" + ipAddress + "]: " + target.getErrorString());
                throw new DefaultSnmpException("SNMP GET BULK ERROR: " + target.getErrorString());
            } else {
                int rowSize = rowTemp[0].length;
                // check if last row has null object binding. If true,
                // discard the last row.
                for (int j = 0; j < colSize; j++) {
                    if (rowTemp[j][rowSize - 1] == null) {
                        if (rowSize > 1) {
                            rowSize--;
                            break;
                        } else {
                            // too many columns and exit.
                            break outer;
                        }
                    }
                }

                // retrieve object data.
                for (int i = 0; i < rowSize; i++) {
                    curOid = rowTemp[0][i].getObjectID().toString();
                    if (curOid.startsWith(initOid)) {
                        curIndex = curOid.substring(initOid.length() + 1);
                        if (curIndex.equals(preIndex)) {
                            // duplicate instance means end of mib.
                            break outer;
                        } else {
                            preIndex = curIndex;
                        }

                        row = new String[colSize];
                        for (int j = 0; j < colSize; j++) {
                            //row[j] = rowTemp[j][i].getVariable().getVarObject(); //commented by Rox.
                            //added by Rox, convert Counter64 to String.
                            SnmpVar var = rowTemp[j][i].getVariable();
                            if (var.getTypeString().equals("COUNTER64")) {
                                SnmpCounter64 l = (SnmpCounter64) var;
                                row[j] = l.toString(10);
                            } else {
                                row[j] = var.getVarObject().toString();
                            }

                            // check if it is last row. If true, re-set OID list.
                            if (i == (rowSize - 1)) {
                                oidList[j] = rowTemp[j][i].getObjectID().toString();
                            }
                        }

                        // this is a complete row and no null object binding.
                        // add index to array list and add objects to array list.
                        mibIdxes.add(curIndex);
                        rows.add(row);
                    } else {
                        // end of table.
                        break outer;
                    }
                }
            }

            // re-set last row OIDs as OID list.
            target.setObjectIDList(oidList);
        }

        values = new String[rows.size()][colSize];
        mibIndexes = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            values[i] = (String[]) rows.get(i);
            mibIndexes[i] = (String) mibIdxes.get(i);
        }

        //CollectorLog.Log("Table is successfully retrieved. The first OID is " + initOid);
        //CollectorLog.Log("The total number of instances in the table is " + rows.size());

        return values;
    }

    /**
     * This method is implemented using snmp GetBulk. The default maxRepetitions =
     * 50 is used. If PDU is full, the method will return null. If this case
     * happens, you can adjust maxRepetitions using setMaxRepetitions() method.
     * This method retrieves partial rows from mib table. The starting row is
     * specified by the MIB index contained in the oidList. If oidList does not
     * contain MIB index, the starting row is the first of the table. The total
     * number of rows retrieved are specified by numberOfRows. This method is used
     * for the filter purpose in case a MIB table is huge and retriving whole
     * table takes too long time. This method allows the user to retrieve
     * specified number of rows a time. This method allows the user to specify any
     * number of columns in the parameter, oidList, and in any order. The oidList
     * can be either oid numbers or named strings (label). The method returns a
     * two-dimensional array of Object type, containing the values in exactly the
     * same order as the oidList. The user needs to convert Object type to the
     * appropriate Java data types according to their mib definition. For IP
     * ADDRESS, NETWORK ADDRESS and OID mib types, the returned is String type. If
     * there is a snmp error, throws AdventNet DefaultSnmpException. If table is empty,
     * return an array with zero elements.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList      java.lang.String[]: oid list that can be either oid numbers or
     *                     named strings (label).
     * @param numberOfRows integer: the count of rows that user want to retrieve.
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table
     *         is empty.
     */
    public String[][] getTable(String[] oidList, int numberOfRows) throws DefaultSnmpException {
        int colSize = oidList.length;
        String preIndex = null; // previous row index.
        String curOid = null; // current row last column oid.
        String curIndex = null; // current row index.
        String initOid = null;
        ArrayList rows = new ArrayList();
        ArrayList mibIdxes = new ArrayList();

        SnmpVarBind[][] rowTemp = null;
        String[] row = null;
        String[][] values = null;

        target.setObjectIDList(oidList);
        initOid = (target.getSnmpOIDList())[0].toString();

        outer:
        while (true) {
            rowTemp = target.snmpGetBulkVariableBindings();
            if ((rowTemp == null) || (target.getErrorCode() != 0)) {
                CollectorLog.Log("Can't get table from NE[" + ipAddress + "]: " + target.getErrorString());
                throw new DefaultSnmpException("SNMP GET BULK ERROR: " + target.getErrorString());
            } else {
                int rowSize = rowTemp[0].length;
                // check if last row has null object binding. If true,
                // discard the last row.
                for (int j = 0; j < colSize; j++) {
                    if (rowTemp[j][rowSize - 1] == null) {
                        if (rowSize > 1) {
                            rowSize--;
                            break;
                        } else {
                            // too many columns and exit.
                            break outer;
                        }
                    }
                }

                // retrieve object data.
                for (int i = 0; i < rowSize; i++) {
                    curOid = rowTemp[0][i].getObjectID().toString();
                    if (curOid.startsWith(initOid)) {
                        curIndex = curOid.substring(initOid.length() + 1);
                        if (curIndex.equals(preIndex)) {
                            // duplicate instance means end of mib.
                            break outer;
                        } else {
                            preIndex = curIndex;
                        }

                        row = new String[colSize];
                        for (int j = 0; j < colSize; j++) {
                            //row[j] = rowTemp[j][i].getVariable().getVarObject(); //commented by Rox.
                            //added by Rox, convert Counter64 to String.
                            SnmpVar var = rowTemp[j][i].getVariable();
                            if (var.getTypeString().equals("COUNTER64")) {
                                SnmpCounter64 l = (SnmpCounter64) var;
                                row[j] = l.toString(10);
                            } else {
                                row[j] = var.getVarObject().toString();
                            }

                            // check if it is last row. If true, re-set OID list.
                            if (i == (rowSize - 1)) {
                                oidList[j] = rowTemp[j][i].getObjectID().toString();
                            }
                        }

                        // this is a complete row and no null object binding.
                        // add index to array list and add objects to array list.
                        mibIdxes.add(curIndex);
                        rows.add(row);

                        // check if row size larger than numberOfRows. If true, stop
                        // retrieving.
                        if (rows.size() >= numberOfRows) {
                            break outer;
                        }
                    } else {
                        // end of table.
                        break outer;
                    }
                }
            }

            // re-set last row OIDs as OID list.
            target.setObjectIDList(oidList);
        }

        values = new String[rows.size()][colSize];
        mibIndexes = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            values[i] = (String[]) rows.get(i);
            mibIndexes[i] = (String) mibIdxes.get(i);
        }

        return values;
    }

    /**
     * Given an oid, return the Object type using snmp GET. The user needs to
     * convert it to the appropriate Java data type according to its mib
     * definition. For IP ADDRESS, NETWORK ADDRESS and OID mib types, the returned
     * is String type. The oid can be either oid number or named string (label),
     * but must be instance oid, that is, ends either .0 for scalar mib or .<index>
     * for columnar mib. If there is a snmp error, throws AdventNet DefaultSnmpException.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oid java.lang.String: mib object id.
     * @return java.lang.Object: an Object containing the value of the mib object.
     */

    public String getValue(String oid) throws DefaultSnmpException {
        SnmpVar valueTemp = null;
        Object value = null;

        valueTemp = target.snmpGet(new SnmpOID(oid));

        if ((valueTemp == null) || (target.getErrorCode() != 0)) {
            CollectorLog.Log("Can't get the data from NE[" + ipAddress + "]: oid = " + oid + "; error = " + target.getErrorString());
            throw new DefaultSnmpException("SNMP GET ERROR: " + target.getErrorString());
        } else {
            /* added by bryce to convert the COUNTER64 SNMP data */
            if (valueTemp.getTypeString().equals("COUNTER64")) {
                SnmpCounter64 l = (SnmpCounter64) valueTemp;
                value = l.toString(10);
            } else {
                value = valueTemp.getVarObject();
            }
        }

        return value != null ? value.toString() : null;
    }

    /**
     * Given a list of oids, return the String-valued variables, using snmp GET.
     * The user needs to convert them to the appropriate Java data type according
     * to their mib definition. For IP ADDRESS, NETWORK ADDRESS and OID mib types,
     * the returned is String type. The oids in the list can be either oid numbers
     * or named strings (label), but must be instance oids, that is, ends either
     * .0 for scalar mibs or .<index> for columnar mibs. If there is a snmp
     * error, throws AdventNet DefaultSnmpException.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or
     *                named strings (label).
     * @return java.lang.Object[]: a array of Object, containing the values of the
     *         mib objects
     */

    public String[] getValues(String[] oidList) throws DefaultSnmpException {
        SnmpVar[] valuesTemp = null;
        String[] values = new String[0];

        target.setObjectIDList(oidList);
        valuesTemp = target.snmpGetVariables();

        if ((valuesTemp == null) || (target.getErrorCode() != 0)) {
            CollectorLog.Log("Can't get data from NE[" + ipAddress + "]: " + target.getErrorString());
            throw new DefaultSnmpException("SNMP GET ERROR: " + target.getErrorString());
        } else {
            values = new String[valuesTemp.length];

            for (int i = 0; i < valuesTemp.length; i++) {
                /* added by bryce to convert the COUNTER64 SNMP data */
                if (valuesTemp[i].getTypeString().equals("COUNTER64")) {
                    SnmpCounter64 l = (SnmpCounter64) valuesTemp[i];
                    values[i] = l.toString(10);
                } else {
                    System.out.println();
                    values[i] = valuesTemp[i].getVarObject().toString();
                }
            }
        }

        return values;
    }

    /**
     * Set the maximum repetitions for SNMP GetBulk. In the two getTable()
     * methods, the default maximum = 50 is used. If PDU is full, the getTable()
     * will return null. In the case, we can use this method maximum repetitions.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param maxRepetitions the maximum repetitions for SNMP GetBulk.
     */

    public void setMaxRepetitions(int maxRepetitions) {
        // set maximum repetitions.
        target.setMaxRepetitions(maxRepetitions);
    }

    /**
     * Send a snmp SET to agent for a specified oid. The underneath method
     * automatically converts the Object type to the appropriate data type based
     * on the oid's type defined in mib. Return the mib value (Object type) if the
     * snmp operation is successful and null if failed.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oid   java.lang.String: oid.
     * @param value java.lang.Object: an Object containing the value of the mib
     *              object.
     * @return true if SNMP SET is successful and false if failed.
     */

    public boolean setValue(String oid, Object value) {
        String retValue = null;
        boolean retCode = false;

        try {
            target.setObjectID(oid);
            String strValue = value.toString();
            retValue = target.snmpSet(strValue);

            if ((retValue == null) || (target.getErrorCode() != 0)) {
                CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: oid = " + oid + "; value = " + value + "; error = " + target.getErrorString());
                retCode = false;
            } else {
                retCode = true;
            }
        } catch (SnmpDataException e) {
            CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: oid = " + oid + "; value = " + value + "; Exception = " + e.getMessage());
        } catch (Exception e) {
            CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: oid = " + oid + "; value = " + value + "; Exception = " + e.getMessage());
        }

        return retCode;
    }

    /**
     * Send a snmp SET to agent for a specified oid list. The underneath method
     * automatically converts the Object-typed values to the appropriate data
     * types based on the oids' types defined in mib. For IP ADDRESS, NETWORK
     * ADDRESS and OID mib types, the values must be the String type. Return the
     * Object-typed values if the snmp operation is successful and an array with
     * zero elements if failed.
     * <p/>
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list..
     * @param values  java.lang.Object[]: an array of Object, containing the values of
     *                the mib objects.
     * @return true if SNMP SET is successful and false if failed.
     */

    public boolean setValues(String[] oidList, SnmpVar[] values) {
        SnmpVar[] retValues = null;
        boolean retCode = false;

        try {
            target.setObjectIDList(oidList);
            retValues = target.snmpSetVariables(values);
            if ((retValues == null) || (target.getErrorCode() != 0)) {
                CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: " + target.getErrorString());
                retCode = false;
            } else {
                retCode = true;
            }
        } catch (SnmpDataException e) {
            CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: Exception = " + e.getMessage());
        } catch (Exception e) {
            CollectorLog.Log("Can't set the data to NE[" + ipAddress + "]: Exception = " + e.getMessage());
        }

        return retCode;
    }

    protected String slotPortLogicalFormat(String str){
    	String[] tmp=str.split("/");
    	return "Slot"+tmp[0]+"/"+"Port"+tmp[1]+"/LogicalPort"+tmp[2];
    }
    
 
    protected List getGponNNIPortList(){
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);

            //TODO: change OID
            String[] indices = {".1.3.6.1.4.1.41355.1.3.20.1.3.1.3.1.3"}; //oltPonLinkAdministrativeState
            Object[][] l2StateList = null;
            String[] l2List = null;

            l2StateList = getTable(indices);
            l2List = getMibIndexes();

            if (l2StateList == null || l2List == null) {
                CollectorLog.Log("The NNI PortList in NE[" + ipAddress + "] is empty.");
                return rtn;
            }
            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < l2StateList.length; i++) {
                name = l2List[i];
                name=name.replaceAll("\\.", "/");
                //TODO: change display type
                displayName = PmUtil.getIndexDisplayNameByValue(name, L2_TABLE);
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
    protected List getGponAllocIDList(){
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);

            //TODO: change OID
            String[] indices = {".1.3.6.1.4.1.41355.1.3.20.1.3.1.3.1.3"}; //oltPonLinkAdministrativeState
            Object[][] l2StateList = null;
            String[] l2List = null;

            l2StateList = getTable(indices);
            l2List = getMibIndexes();

            if (l2StateList == null || l2List == null) {
                CollectorLog.Log("The Gpon AllocID List in NE[" + ipAddress + "] is empty.");
                return rtn;
            }
            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < l2StateList.length; i++) {
                name = l2List[i];
                name=name.replaceAll("\\.", "/");
                //TODO: change display type
                displayName = PmUtil.getIndexDisplayNameByValue(name, L2_TABLE);
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
    protected List getONTUNIEthernetPortList(){
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);

            //TODO: change OID
            String[] indices = {".1.3.6.1.4.1.41355.1.3.20.1.3.1.4.1.7"}; //onuCfgProfileIndex
            Object[][] l2StateList = null;
            String[] l2List = null;

            l2StateList = getTable(indices);
            l2List = getMibIndexes();

            if (l2StateList == null || l2List == null) {
                CollectorLog.Log("The ONT UNI Ethernet PortList in NE[" + ipAddress + "] is empty.");
                return rtn;
            }
            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < l2StateList.length; i++) {
                name = l2List[i];
                name=name.replaceAll("\\.", "/");
                //TODO: change display type
                displayName = slotPortLogicalFormat(name);
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
    protected List getONTGEMPortList(){
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);

            //TODO: change OID
            String[] indices = {".1.3.6.1.4.1.41355.1.3.20.1.3.1.4.1.7"}; //onuCfgProfileIndex
            Object[][] l2StateList = null;
            String[] l2List = null;

            l2StateList = getTable(indices);
            l2List = getMibIndexes();

            if (l2StateList == null || l2List == null) {
                CollectorLog.Log("The GEM PortList in NE[" + ipAddress + "] is empty.");
                return rtn;
            }
            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < l2StateList.length; i++) {
                name = l2List[i];
                name=name.replaceAll("\\.", "/");
                //TODO: change display type
                displayName = slotPortLogicalFormat(name);
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
    protected List getSystemResouceList(){
    	return new ArrayList(0);
    }
    
    /**
     * return the list containing NamePair.
     *
     * @param mibTable
     * @return
     * @throws Exception
     */
    public List getInstanceList(String mibTable) throws Exception {
        if (!PmUtil.isNeActive(this.ipAddress, this.port, this.getCommunity)) {
            throw new Exception("The NE is inactive.");
        }

        List instances = null;
        if (mibTable.startsWith(ONU_TABLE)) {
            // only need ONU
            instances = getAllOnuList();
        } else if (mibTable.startsWith(OLT_TABLE)) {
            // only need OLT
            instances = getAllOltList();
        } else if (mibTable.startsWith(L2_TABLE)) {
            instances = getL2PortList();
        } else if (mibTable.startsWith(UNI_INTERFACE_TABLE)) {
            instances = getUniPortList();
        } else if (mibTable.startsWith(ONU4024i_UNI_INTERFACE_TABLE)) { //added by Zhou Chao, 2009/5/18
            instances = getOnu4024iUniPortList();
        } else if (mibTable.startsWith(DHCP_TABLE) || mibTable.startsWith(RESOURCE_TABLE)) {
            instances = new ArrayList(0);
        }else if(mibTable.startsWith(OLT_OPTIC_STATISTICS)){
        	instances= getAllOltList();
        }else if(mibTable.startsWith(ONU_OPTIC_STATISTICS)){
        	instances= getAllOnuList();
        }
        else if(mibTable.startsWith(CSMEthernetPort)){
        	instances = new ArrayList(0);
        }
        else if(mibTable.startsWith(GponNNIPort)){
        	instances= getGponNNIPortList();
        }
        else if(mibTable.startsWith(GponAllocID)){
        	instances= getGponAllocIDList();
        }
        else if(mibTable.startsWith(ONTUNIEthernetPort)){
        	instances= getONTUNIEthernetPortList();
        }
        else if(mibTable.startsWith(ONTGEMPort)){
        	instances= getONTGEMPortList();
        }
        else if(mibTable.startsWith(SYSTEM_RESOUCE)){
        	instances= getSystemResouceList();
        }
        else if(mibTable.startsWith(OLTOpticalLayerStatistics)){
        	instances= getGponNNIPortList();//same index
        }else if(mibTable.startsWith(ONTOpticalLayerStatistics)){
        	instances= getGponNNIPortList();//same index
        }else{
            throw new Exception("Unsupported mib table:" + mibTable);
        }

        CollectorLog.Log("The measurement type[" + mibTable + "] in NE[" + ipAddress + "] has " + instances.size() + " instances.");

        return instances;
    }

    /**
     * @return
     * @throws DefaultSnmpException
     */
    List getL2PortList() throws DefaultSnmpException {
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);
            if (type != null && type.startsWith("BBS1000"))  //BBS1000+
            {
                String[] indices = {".1.3.6.1.4.1.41355.1800.2.1.1.1.1.3"}; //utsEponModuleBoardState
                Object[][] l2StateList = null;
                String[] l2List = null;

                l2StateList = getTable(indices);
                l2List = getMibIndexes();

                if (l2StateList == null || l2List == null) {
                    CollectorLog.Log("The L2 list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < l2StateList.length; i++) {
                    if (l2StateList[i][0] != null && l2StateList[i][0].equals("3"))//active
                        for (int j = 1; j < 5; j++) {
                            name = l2List[i] + "/" + j;
                            displayName = PmUtil.getIndexDisplayNameByValue(name, L2_TABLE);

                            pair = new NamePair(name, displayName);
                            rtn.add(pair);
                        }
                }
            } else if(version != null && version.startsWith("4.0")) {   //BBS4000 v4.0(NGB)
                String[] indices = {".1.3.6.1.4.1.17409.2.3.2.1.1.5"}; //sniAdminStatus
                Object[][] l2StateList = null;
                String[] cardList = null;

                l2StateList = getTable(indices);
                cardList = getMibIndexes();

                if (l2StateList == null || cardList == null) {
                    CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < l2StateList.length; i++) {
                    String[] split = cardList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[1]).append("/").append(split[2]).toString();
                    displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else {
                String[] indices = {".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.1.1.3"};//utsEponModulePhyPresenceStat
                Object[][] l2StateList = null;
                String[] l2List = null;

                l2StateList = getTable(indices);
                l2List = getMibIndexes();

                if (l2StateList == null || l2List == null) {
                    CollectorLog.Log("The L2 list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;

                for (int i = 0; i < l2StateList.length && i < 12; i++) {
                    if (l2StateList[i][0] != null && l2StateList[i][0].equals("1"))//install
                    {
                        for (int j = 1; j < 5; j++) {
                            name = l2List[i] + "/" + j;
                            displayName = PmUtil.getIndexDisplayNameByValue(name, L2_TABLE);

                            pair = new NamePair(name, displayName);
                            rtn.add(pair);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * for BBS4000r3.1 upm
     */
    List getOltOpmOltDataList() throws DefaultSnmpException {
    	List rtn = new ArrayList();
    	try{
	    	//String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
	    	//String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);
	
	        String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.1.3.18.1.3"}; //utsDot3OltOpmOltDataTemperature
	        Object[][] oltStateList = null;
	        String[] onuList = null;
	
	        oltStateList = getTable(indices);
	        onuList = getMibIndexes();
	
	        if (oltStateList == null || onuList == null) {
	            CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
	            return rtn;
	        }
	
	        NamePair pair = null;
	        String name = null;
	        String displayName = null;
	        for (int i = 0; i < oltStateList.length; i++) {
	            String[] split = onuList[i].split("\\.");
	            StringBuffer sb = new StringBuffer();
	            name = sb.append(split[0]).append("/").append(split[2]).toString();
	            displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);
	
	            pair = new NamePair(name, displayName);
	            rtn.add(pair);
	        }
    	}catch(Exception e){
    		CollectorLog.Log("Error on getOltOpmOltDataList: "+e.toString());
    	}
        CollectorLog.Log("There are " + rtn.size() + " OLT ports in NE[" + ipAddress + "].");
        return rtn;
    }
    
    List getAllOltList() throws DefaultSnmpException {
        List rtn = new ArrayList();
        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);
            if (type != null && type.startsWith("BBS1000"))  //BBS1000+
            {
                String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.3"}; //utsDot3OltOperStatus
                Object[][] oltStateList = null;
                String[] oltList = null;

                oltStateList = getTable(indices);
                oltList = getMibIndexes();

                if (oltStateList == null || oltList == null) {
                    CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < oltStateList.length; i++) {
                    name = PmUtil.formatIfIndex(oltList[i]);
                    displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else if(type != null && type.startsWith("BBS4000") && version != null && version.startsWith("1.0")) {   //BBS4000 v1.0(GPON)
                String[] indices = {".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.4"}; //oltPonLinkCfgOperationalState
                Object[][] oltStateList = null;
                String[] cardList = null;

                oltStateList = getTable(indices);
                cardList = getMibIndexes();

                if (oltStateList == null || cardList == null) {
                    CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < oltStateList.length; i++) {
                    String[] split = cardList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[0]).append("/").append(split[1]).toString();
                    displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else if(version != null && version.startsWith("4.0")) {   //BBS4000 v4.0(NGB)
                String[] indices = {".1.3.6.1.4.1.17409.2.3.3.1.1.6"}; //ponPortAdminStatus
                Object[][] oltStateList = null;
                String[] cardList = null;

                oltStateList = getTable(indices);
                cardList = getMibIndexes();

                if (oltStateList == null || cardList == null) {
                    CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < oltStateList.length; i++) {
                    String[] split = cardList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[1]).append("/").append(split[2]).toString();
                    displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else {
                String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.4"}; //utsDot3OltOperState
                Object[][] oltStateList = null;
                String[] onuList = null;

                oltStateList = getTable(indices);
                onuList = getMibIndexes();

                if (oltStateList == null || onuList == null) {
                    CollectorLog.Log("The OLT list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < oltStateList.length; i++) {
                    String[] split = onuList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[0]).append("/").append(split[2]).toString();
                    displayName = PmUtil.getIndexDisplayNameByValue(name, OLT_TABLE);

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CollectorLog.Log("There are " + rtn.size() + " OLT ports in NE[" + ipAddress + "].");
        return rtn;
    }
    
    /**
     * for BBS4000r3.1 upm
     */
    List getOnu2OpticalTransceiverDiagnosisTable() throws DefaultSnmpException {
    	List rtn = new ArrayList();
    	try{
	    	//String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
	    	//String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);
	

            String[] indices = {".1.3.6.1.4.1.41355.1800.2.5.1.3.1.5"}; //using utsDot3OnuOpticalTransceiverDiagnosisTemperature to get onu instance.
            Object[][] onuStateList = null;
            String[] onuList = null;

            onuStateList = getTable(indices);
            onuList = getMibIndexes();

            if (onuStateList == null || onuList == null) {
                CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                return rtn;
            }

            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < onuStateList.length; i++) {
                String[] split = onuList[i].split("\\.");
                StringBuffer sb = new StringBuffer();
                name = sb.append(split[0]).append("/").append(split[2]).append("/").append(split[3]).toString();

                displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE) + "(a)";
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        
    	}catch(Exception e){
    		CollectorLog.Log("Error on getOnu2OpticalTransceiverDiagnosisTable: "+e.toString());
    	}
        CollectorLog.Log("There are " + rtn.size() + " ONU ports in NE[" + ipAddress + "].");
        return rtn;
    }
    
    List getAllOnuList() throws DefaultSnmpException {
        List rtn = new ArrayList();

        try {
            String type = SnmpUtility.getNeType(ipAddress, port, getCommunity);
            String version = SnmpUtility.getNeVersion(ipAddress, port, getCommunity);
            if (type != null && type.startsWith("BBS1000+") && version != null && version.startsWith("2.3")) {
                String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.4"};//utsDot3OnuRegistrationState
                Object[][] onuStateList = null;
                String[] onuList = null;

                onuStateList = getTable(indices);
                onuList = getMibIndexes();

                if (onuStateList == null || onuList == null) {
                    CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < onuStateList.length; i++) {
                    name = PmUtil.formatIfIndex(onuList[i]);
                    String status = onuStateList[i][0].toString();
                    if (status.equals("3")) { //unregistered(1); pending(2); registered(3)
                        displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE) + "(a)";
                    } else {
                        displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE);
                    }

                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else if(type != null && type.startsWith("BBS4000") && version != null && version.startsWith("1.0")) { //BBS4000 v1.0.x(GPON)
                String[] indices = {".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.5"}; //using onuCfgPrimaryStatus to get onu instance.
                Object[][] onuStateList = null;
                String[] onuList = null;

                onuStateList = getTable(indices);
                onuList = getMibIndexes();

                if (onuStateList == null || onuList == null) {
                    CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < onuStateList.length; i++) {
                    String[] split = onuList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[0]).append("/").append(split[1]).append("/").append(split[2]).toString();

                    displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE) + "(a)";
                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else if(version != null && version.startsWith("4.0")) { //BBS4000 v4.0.x(NGB)
                String[] indices = {".1.3.6.1.4.1.17409.2.3.4.1.1.9"}; //onuAdminStatus
                Object[][] onuStateList = null;
                String[] onuList = null;

                onuStateList = getTable(indices);
                onuList = getMibIndexes();

                if (onuStateList == null || onuList == null) {
                    CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < onuList.length; i++) {
                    String index = EponDeviceIndexFormatter.format(Integer.parseInt(onuList[i]));
                    name = index.substring(index.indexOf('/')+1);

                    displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE) + "(a)";
                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            } else {
                String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.2.1.5.1.5"}; //using utsDot3OnuUpstreamPir to get onu instance.
                Object[][] onuStateList = null;
                String[] onuList = null;

                onuStateList = getTable(indices);
                onuList = getMibIndexes();

                if (onuStateList == null || onuList == null) {
                    CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                    return rtn;
                }

                NamePair pair = null;
                String name = null;
                String displayName = null;
                for (int i = 0; i < onuStateList.length; i++) {
                    String[] split = onuList[i].split("\\.");
                    StringBuffer sb = new StringBuffer();
                    name = sb.append(split[0]).append("/").append(split[2]).append("/").append(split[3]).toString();

                    displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE) + "(a)";
                    pair = new NamePair(name, displayName);
                    rtn.add(pair);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //CollectorLog.Log("There are "+ rtn.size() + " ONUs in NE[" + ipAddress + "]." );

        return rtn;
    }

    List getUniPortList() throws DefaultSnmpException {
        List rtn = new ArrayList();

        try {
            String[] indices = {".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.8"}; //using utsDot3Onu2SerialNumber to get onu instance.
            Object[][] valueList = null;
            String[] onuList = null;

            valueList = getAllRows(indices);
            onuList = getMibIndexes();

            if (valueList == null || onuList == null) {
                CollectorLog.Log("The ONU list in NE[" + ipAddress + "] is empty.");
                return rtn;
            }

            NamePair pair = null;
            String name = null;
            String displayName = null;
            for (int i = 0; i < valueList.length; i++) {
                String onuType = OnuMODHelper.convertHwType(((String) valueList[i][0]).substring(4, 8));
                if (onuType.equalsIgnoreCase("ONU1001i") || onuType.equalsIgnoreCase("ONU101i")) {
                    String[] split = onuList[i].split("\\.");

                    int count = getUniPortCount(onuType);
                    for (int j = 1; j <= count; j++) {
                        StringBuffer sb = new StringBuffer();
                        name = sb.append(split[0]).append("/").append(split[2]).append("/").append(split[3]).append("/").append(j).toString();
                        displayName = PmUtil.getIndexDisplayNameByValue(name, ONU_TABLE);
                        pair = new NamePair(name, displayName);
                        rtn.add(pair);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    int getUniPortCount(String onuType) {
        int count = 0;

        if (onuType.equalsIgnoreCase("ONU1001i") || onuType.equalsIgnoreCase("ONU101i")) {
            count = 1;
        }

        return count;
    }

    List getOnu4024iUniPortList() throws DefaultSnmpException { //added by Zhou Chao, 2009/5/18
        List rtn = new ArrayList();

        try {
            String[] indices = {".1.3.6.1.4.1.41355.1.3.10.100.4024.3.1.1.1.3"}; //using portType to get port instance.
            Object[][] valueList = null;
            String[] portList = null;

            valueList = getAllRows(indices);
            portList = getMibIndexes();

            if (valueList == null || portList == null) {
                CollectorLog.Log("The Port list in NE[" + ipAddress + "] is empty.");
                return rtn;
            }

            NamePair pair = null;
            String name = null;
            String displayName = null;
            int count = getOnu4024iUniPortCount();
            for (int i = 0; i < count; i++) {
                StringBuffer sb = new StringBuffer();
                name = sb.append(portList[i]).toString();
                displayName = "PORT " + portList[i];
                pair = new NamePair(name, displayName);
                rtn.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    int getOnu4024iUniPortCount() { //added by Zhou Chao, 2009/5/18
        return 24;
    }

    public String getIndexName(String mibTable) throws Exception {
        if (mibTable.startsWith(ONU_TABLE)) {
            return "utsPonIfExtIndex";
        } else if (mibTable.startsWith(OLT_TABLE)) {
            return "utsPonIfExtIndex";
        } else if (mibTable.startsWith(L2_TABLE)) {
            return "utsEthIfExtIndex";
        } else if (mibTable.startsWith(DHCP_TABLE) || mibTable.equals(RESOURCE_TABLE)) {
            return null;
        } else if (mibTable.startsWith(UNI_INTERFACE_TABLE) || mibTable.startsWith(ONU4024i_UNI_INTERFACE_TABLE))
        { //modified by Zhou Chao, 2009/5/18
            return "utsUniIfExtIndex";
        }
        else if(mibTable.startsWith(OLT_OPTIC_STATISTICS)){
        	return  "utsDot3OltOpmOltDataPortId";
        }else if(mibTable.startsWith(ONU_OPTIC_STATISTICS)){
        	return  "utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId";
        }
        else if(mibTable.startsWith(GponAllocID)){
        	return  GponAllocID;
        }
        else if(mibTable.startsWith(CSMEthernetPort)){
        	return  CSMEthernetPort;
        }
        else if(mibTable.startsWith(GponNNIPort)){
        	return  GponNNIPort;
        }
        else if(mibTable.startsWith(ONTUNIEthernetPort)){
        	return  ONTUNIEthernetPort;
        }
        else if(mibTable.startsWith(ONTGEMPort)){
        	return  ONTGEMPort;
        }
        else if(mibTable.startsWith(SYSTEM_RESOUCE)){
        	return SYSTEM_RESOUCE;
        }else if(mibTable.startsWith(OLTOpticalLayerStatistics)){
        	return OLTOpticalLayerStatistics;
        }else if(mibTable.startsWith(ONTOpticalLayerStatistics)){
        	return ONTOpticalLayerStatistics;
        }
        else {
            throw new Exception("Unsupported mib table:" + mibTable);
        }
    }

}