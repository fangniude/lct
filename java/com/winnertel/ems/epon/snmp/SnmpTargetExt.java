package com.winnertel.ems.epon.snmp;

import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.nms.lite.util.APIUtil;
import com.winnertel.snmp.beans.SnmpDataException;
import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.DefaultSnmpException;
import com.winnertel.snmp.snmp2.SnmpCounter64;
import com.winnertel.snmp.snmp2.SnmpNull;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpVar;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.util.ArrayList;
import java.util.Properties;

public class SnmpTargetExt {

    private String[] mibIndexes;
    private SnmpTarget target;

    /**
     * User defined constructor. Create an instance and set the target device's ip
     * address.
     *
     * @param neName the name of target device.
     *               Creation date: (4/25/2002 9:14:48 PM)
     */

    public SnmpTargetExt(String neName) {
        String ip = "127.0.0.1";
        int port = 161;
        String getCommunity = "public";
        String writeCommunity = "private";

        try {
            Properties moProperty = APIUtil.getTopoAPI().getMEByMoName( neName ).getProperties();
            if (moProperty != null) {
                ip = moProperty.getProperty( PropertyConstant.NE_IP_ADDRESS, "" );
                getCommunity = moProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
                writeCommunity = moProperty.getProperty(PropertyConstant.NE_WRITE_COMMUNITY, "private");
                port = Integer.parseInt(moProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161"));
            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

        target = new SnmpTarget();
        target.setTargetHost(ip);
        target.setTargetPort(port);
        target.setRetries(SnmpConstant.RETRIES);
        target.setTimeout(SnmpConstant.TIMEOUT);

        //set the SNMP protocol version to use get bulk.
        target.setSnmpVersion(SnmpConstant.VERSION2C);

        target.setCommunity(getCommunity);
        target.setWriteCommunity(writeCommunity);
    }

    /**
     * User defined constructor. Create an instance and set the target device's ip
     * address.
     *
     * @param neId the ID of target device.
     *             Creation date: (4/25/2002 9:14:48 PM)
     */

    public SnmpTargetExt(int neId) {
        String ip = "127.0.0.1";
        int port = 161;
        String getCommunity = "public";
        String writeCommunity = "private";

        try {
//            Properties moProperty = ServerUtility.getNePropertiesByNeId(neId);
            Properties moProperty = APIUtil.getTopoAPI().getMEByMoName( "PhysicalNEMOD-" + neId ).getProperties();
            if (moProperty != null) {
                ip = moProperty.getProperty( PropertyConstant.NE_IP_ADDRESS, "" );
                getCommunity = moProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
                writeCommunity = moProperty.getProperty(PropertyConstant.NE_WRITE_COMMUNITY, "private");
                port = Integer.parseInt(moProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161"));
            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }


        target = new SnmpTarget();
        target.setTargetHost(ip);
        target.setTargetPort(port);
        target.setRetries(SnmpConstant.RETRIES);
        target.setTimeout(SnmpConstant.TIMEOUT);

        //set the SNMP protocol version to use get bulk.
        target.setSnmpVersion(SnmpConstant.VERSION2C);

        target.setCommunity(getCommunity);
        target.setWriteCommunity(writeCommunity);
    }

    public SnmpTargetExt(Properties moProperty) { //added by Zhou Chao, 2009/4/1 (for LCT mode)
        String ip = "127.0.0.1";
        int port = 161;
        String getCommunity = "public";
        String writeCommunity = "private";

        if (moProperty != null) {
            ip = moProperty.getProperty(PropertyConstant.NE_IP_ADDRESS, "");
            getCommunity = moProperty.getProperty(PropertyConstant.NE_GET_COMMUNITY, "public");
            writeCommunity = moProperty.getProperty(PropertyConstant.NE_WRITE_COMMUNITY, "private");
            port = Integer.parseInt(moProperty.getProperty(PropertyConstant.NE_SNMP_PORT, "161"));
        }

        target = new SnmpTarget();
        target.setTargetHost(ip);
        target.setTargetPort(port);
        target.setRetries(SnmpConstant.RETRIES);
        target.setTimeout(SnmpConstant.TIMEOUT);

        //set the SNMP protocol version to use get bulk.
        target.setSnmpVersion(SnmpConstant.VERSION2C);

        target.setCommunity(getCommunity);
        target.setWriteCommunity(writeCommunity);
    }

    public SnmpTargetExt(String ipAddress, int port, String getCommunity, String writeCommunity) {
        target = new SnmpTarget();
        target.setTargetHost(ipAddress);
        target.setTargetPort(port);
        target.setRetries(SnmpConstant.RETRIES);
        target.setTimeout(SnmpConstant.TIMEOUT);

        //set the SNMP protocol version to use get bulk.
        target.setSnmpVersion(SnmpConstant.VERSION2C);
        target.setCommunity(getCommunity);
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
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or
     *                named strings (label).
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table is empty.
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
                String oids = "";
                for (int i = 0; i < oidList.length; i++) {
                    oids = oids + oidList[i] + ", ";
                }
                if (target.getErrorCode() == 22) {
                    throw new DefaultSnmpException("SNMP TIMEOUT");
                }
                throw new DefaultSnmpException("SNMP GET NEXT error: " + target.getErrorString());
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
     * invocation of the method, getAllRows(). Creation date: (4/25/2002 9:38:25
     * PM)
     *
     * @return java.lang.String[]: String-valued indexes for the mib table
     *         indicated by the argument, oidList, passed to the last invocation
     *         of the method, getAllRows().
     */
    public String[] getMibIndexes() {
        return mibIndexes;
    }

    /**
     * Return AdventNet SnmpTarget instance to handle time out exception
     * in system administration.
     */
    public SnmpTarget getSnmpTarget() {
        return target;
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
     * return an array with zero elements. Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or named
     *                strings (label).
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table is empty.
     */
    public Object[][] getTable(String[] oidList) throws DefaultSnmpException {
        int colSize = oidList.length;
        String preIndex = null; // previous row index.
        String curOid = null; // current row last column oid.
        String curIndex = null; // current row index.
        String initOid = null;
        ArrayList rows = new ArrayList();
        ArrayList mibIdxes = new ArrayList();
        SnmpVarBind[][] rowTemp = null;
        Object[] row = null;
        Object[][] values = null;

        target.setObjectIDList(oidList);
        initOid = (target.getSnmpOIDList())[0].toString();
        outer :
        while (true) {
            rowTemp = target.snmpGetBulkVariableBindings();
            if ((rowTemp == null) || (target.getErrorCode() != 0)) {
                String oids = "";
                for (int i = 0; i < oidList.length; i++) {
                    oids = oids + oidList[i] + ", ";
                }
                if (target.getErrorCode() == 22) {
                    throw new DefaultSnmpException("SNMP TIMEOUT");
                }
                throw new DefaultSnmpException("SNMP GET BULK error: " + target.getErrorString());
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
                    if (curOid.equals(initOid)) {
                        return null;
                    }
                    if (curOid.startsWith(initOid)) {
                        curIndex = curOid.substring(initOid.length() + 1);
                        if (curIndex.equals(preIndex)) {
                            // duplicate instance means end of mib.
                            break outer;
                        } else {
                            preIndex = curIndex;
                        }
                        row = new Object[colSize];
                        for (int j = 0; j < colSize; j++) {
                            if (rowTemp[j][i].getVariable() instanceof SnmpNull) {
                                row[j] = new String("");
                            } else if (rowTemp[j][i].getVariable().getTypeString().equals("COUNTER64")) {
                                SnmpCounter64 l = (SnmpCounter64) rowTemp[j][i].getVariable();
                                row[j] = l.toString(10);
                            } else {
                                row[j] = rowTemp[j][i].getVariable().getVarObject();
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

        values = new Object[rows.size()][colSize];
        mibIndexes = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            values[i] = (Object[]) rows.get(i);
            mibIndexes[i] = (String) mibIdxes.get(i);
        }
        return values;
    }

    /**
     * This method is implemented using snmp GetBulk. The default maxRepetitions =
     * 50 is used. If PDU is full, the method will return null. If this case
     * happens, you can adjust maxRepetitions using setMaxRepetitions() method.
     * This method retrieves partial rows from mib table. The starting row is
     * specified by the MIB index contained in the oidList. If index = null, the
     * starting row is the first of the table. The total number of rows retrieved
     * are specified by numberOfRows. This method is used for the filter purpose
     * in case a MIB table is huge and retriving whole table takes too long time.
     * This method allows the user to retrieve specified number of rows a time.
     * This method allows the user to specify any number of columns in the
     * parameter, oidList, and in any order. The oidList can be either oid numbers
     * or named strings (label). The method returns a two-dimensional array of Object
     * type, containing the values in exactly the same order as the oidList. The
     * user needs to convert Object type to the appropriate Java data types according
     * to their mib definition. For IP ADDRESS, NETWORK ADDRESS and OID mib types,
     * the returned is String type. If there is a snmp error, throws AdventNet
     * DefaultSnmpException. If table is empty, return an array with zero elements.
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oidList      the oid list that can be either oid numbers or named strings
     *                     (label). This parameter cannot contain the MIB INDEX.
     * @param index        the MIB INDEX of the starting row. If want to start from the
     *                     first record of the table, set index = null;
     * @param numberOfRows the number of rows that user want to retrieve.
     * @return java.lang.Object[][]: a two-dimentional array of Object, containing
     *         the object values or return an array with zero elements, if table is empty.
     */
    public Object[][] getTable(String[] oidList, String index, int numberOfRows) throws DefaultSnmpException {
        int colSize = oidList.length;
        String preIndex = null; // previous row index.
        String curOid = null; // current row last column oid.
        String curIndex = null; // current row index.
        String initOid = null;
        ArrayList rows = new ArrayList();
        ArrayList mibIdxes = new ArrayList();
        SnmpVarBind[][] rowTemp = null;
        Object[] row = null;
        Object[][] values = null;

        target.setObjectIDList(oidList);
        initOid = (target.getSnmpOIDList())[0].toString();
        if (index != null && !index.equalsIgnoreCase("")) {
            for (int i = 0; i < oidList.length; i++) {
                oidList[i] = oidList[i] + "." + index;
            }
            target.setObjectIDList(oidList);
        }
        outer :
        while (true) {
            rowTemp = target.snmpGetBulkVariableBindings();
            if ((rowTemp == null) || (target.getErrorCode() != 0)) {
                String oids = "";
                for (int i = 0; i < oidList.length; i++) {
                    oids = oids + oidList[i] + ", ";
                }
                if (target.getErrorCode() == 22) {
                    throw new DefaultSnmpException("SNMP TIMEOUT");
                }
                throw new DefaultSnmpException("SNMP GET BULK error: " + target.getErrorString());
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
                    if (curOid.equals(initOid)) {
                        return null;
                    }
                    if (curOid.startsWith(initOid)) {
                        curIndex = curOid.substring(initOid.length() + 1);
                        if (curIndex.equals(preIndex)) {
                            // duplicate instance means end of mib.
                            break outer;
                        } else {
                            preIndex = curIndex;
                        }

                        row = new Object[colSize];
                        for (int j = 0; j < colSize; j++) {
                            if (rowTemp[j][i].getVariable() instanceof SnmpNull) {
                                row[j] = new String("");
                            } else if (rowTemp[j][i].getVariable().getTypeString().equals("COUNTER64")) {
                                SnmpCounter64 l = (SnmpCounter64) rowTemp[j][i].getVariable();
                                row[j] = l.toString(10);
                            } else {
                                row[j] = rowTemp[j][i].getVariable().getVarObject();
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

        values = new Object[rows.size()][colSize];
        mibIndexes = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            values[i] = (Object[]) rows.get(i);
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
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param oid java.lang.String: mib object id.
     * @return java.lang.Object: an Object containing the value of the mib object.
     */
    public Object getValue(String oid) throws DefaultSnmpException {
        SnmpVar valueTemp = null;
        Object value = null;
//	    target.setObjectID(oid);
        valueTemp = target.snmpGet(new SnmpOID(oid));
        if ((valueTemp == null) || (target.getErrorCode() != 0)) {
            if (target.getErrorCode() == 22) {
                throw new DefaultSnmpException("SNMP TIMEOUT");
            }
            throw new DefaultSnmpException("SNMP GET error: " + target.getErrorString());
        } else {
            /* added by bryce to convert the COUNTER64 SNMP data */
            if (valueTemp.getTypeString().equals("COUNTER64")) {
                SnmpCounter64 l = (SnmpCounter64) valueTemp;
                value = l.toString(10);
            } else {
                value = valueTemp.getVarObject();
            }
        }
        return value;
    }

    /**
     * Given a list of oids, return the String-valued variables, using snmp GET.
     * The user needs to convert them to the appropriate Java data type according
     * to their mib definition. For IP ADDRESS, NETWORK ADDRESS and OID mib types,
     * the returned is String type. The oids in the list can be either oid numbers
     * or named strings (label), but must be instance oids, that is, ends either
     * .0 for scalar mibs or .<index> for columnar mibs. If there is a snmp
     * error, throws AdventNet DefaultSnmpException. Creation date: (4/25/2002 9:38:25
     * PM)
     *
     * @param oidList java.lang.String[]: oid list that can be either oid numbers or
     *                named strings (label).
     * @return java.lang.Object[]: a array of Object, containing the values of the
     *         mib objects
     */
    public Object[] getValues(String[] oidList) throws DefaultSnmpException {
        SnmpVar[] valuesTemp = null;
        Object[] values = new Object[0];
        target.setObjectIDList(oidList);
        valuesTemp = target.snmpGetVariables();
        String oids = "";
        for (int i = 0; i < oidList.length; i++) {
            oids = oids + oidList[i] + ", ";
        }
        if ((valuesTemp == null) || (target.getErrorCode() != 0)) {
            if (target.getErrorCode() == 22) {
                throw new DefaultSnmpException("SNMP TIMEOUT");
            }
            throw new DefaultSnmpException("SNMP GET error: " + target.getErrorString());
        } else {
            String valuesStr = "";
            values = new Object[valuesTemp.length];
            for (int i = 0; i < valuesTemp.length; i++) {
                if (valuesTemp[i] instanceof SnmpNull) {
                    return null;
                } else if (valuesTemp[i].getTypeString().equals("COUNTER64")) {
                    SnmpCounter64 l = (SnmpCounter64) valuesTemp[i];
                    values[i] = l.toString(10);
                } else {
                    values[i] = valuesTemp[i].getVarObject();
                }
                valuesStr = valuesStr + values[i] + ", ";
            }
        }
        return values;
    }

    /**
     * Set the maximum repetitions for SNMP GetBulk. In the two getTable()
     * methods, the default maximum = 50 is used. If PDU is full, the getTable()
     * will return null. In the case, we can use this method maximum repetitions.
     * Creation date: (4/25/2002 9:38:25 PM)
     *
     * @param maxRepetitions the maximum repetitions for SNMP GetBulk.
     */
    public void setMaxRepetitions(int maxRepetitions) {
        // set maximum repetitions.
        target.setMaxRepetitions(maxRepetitions);
    }

    /**
     * Set the number of retries for SNMP GET and SET operations.
     *
     * @param m the number of retries.
     */
    public void setRetries(int m) {
        target.setRetries(m);
    }

    /**
     * Set the SNMP timeout.
     *
     * @param t the SNMP timeout.
     */
    public void setTimeout(int t) {
        target.setTimeout(t);
    }

    /**
     * Send a snmp SET to agent for a specified oid. If MIBs are loaded, the oid
     * can be either a label name, such as "sysDescr", or numbered OID prefix with
     * ".", such as ".1.3.6.1.2.1.1.1", and the value can be String type. If MIBs
     * are not loaded, the oid must be numbered OID prefix with "." and the vlaue
     * must be AdventNet SnmpVar type, such as Snmptring, SnmpIpAddress, SnmpInt,
     * SnmpCounter and so on. Return true if the snmp operation is successful and
     * flase if failed.
     *
     * @param oid   MIB OID which can be either label name or numbered OID.
     *              If using label name, MIBs must be loaded.
     * @param value MIB object value. If MIBs are loaded, the value can be String type.
     *              Otherwise, the value must be AdventNet SnmpVar type.
     * @return true if SNMP SET is successful and false if failed.
     */
    public boolean setValue(String oid, Object value) throws DefaultSnmpException {
        Object retValue = null;
        boolean retCode = false;
        target.setObjectID(oid);
        try {
            String strValue = value.toString();
            if (value instanceof SnmpVar) {
                retValue = target.snmpSetVariable((SnmpVar) value);
            } else {
                retValue = target.snmpSet(strValue);
            }
            if ((retValue == null) || (target.getErrorCode() != 0)) {
                retCode = false;
            } else {
                retCode = true;
            }
        } catch (SnmpDataException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            if (target.getErrorCode() == 22) {
                throw new DefaultSnmpException("SNMP TIMEOUT");
            }
        }
        return retCode;
    }

    /**
     * Send a snmp SET to agent for a specified oid. If MIBs are loaded, each oid
     * in the list can be either a label name, such as "sysDescr", or numbered OID
     * prefix with ".", such as ".1.3.6.1.2.1.1.1", and the value can be String type.
     * If MIBs are not loaded, each oid must be numbered OID prefix with "." and each
     * vlaue must be AdventNet SnmpVar type, such as Snmptring, SnmpIpAddress, SnmpInt,
     * SnmpCounter and so on. Return true if the snmp operation is successful and
     * flase if failed.
     *
     * @param oidList list of MIB OIDs and each oid can be either label name or
     *                numbered OID. If using label name, MIBs must be loaded.
     * @param values  list of MIB object value. If MIBs are loaded, each value can be
     *                String type. Otherwise, each value must be AdventNet SnmpVar type.
     * @return true if SNMP SET is successful and false if failed.
     */
    public boolean setValues(String[] oidList, Object[] values) throws DefaultSnmpException {
        Object[] retValues = null;
        boolean retCode = false;
        String[] strValues = new String[values.length];
        target.setObjectIDList(oidList);
        String oids = "";
        String tempValues = "";
        for (int i = 0; i < values.length; i++) {
            strValues[i] = values[i].toString();
            oids = oids + oidList[i] + ", ";
            tempValues = tempValues + strValues[i] + ", ";
        }

        try {
            if (values[0] instanceof SnmpVar) {
                retValues = target.snmpSetVariables((SnmpVar[]) values);
            } else {
                retValues = target.snmpSetList(strValues);
            }
            if ((retValues == null) || (target.getErrorCode() != 0)) {
                retCode = false;
            } else {
                retCode = true;
            }
        } catch (SnmpDataException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            if (target.getErrorCode() == 22) {
                throw new DefaultSnmpException("SNMP TIMEOUT");
            }
        }
        return retCode;
    }

}