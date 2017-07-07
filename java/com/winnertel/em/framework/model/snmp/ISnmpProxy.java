package com.winnertel.em.framework.model.snmp;

import java.util.Vector;

public interface ISnmpProxy extends ISnmpConstant {
    public void setTargetHost(String aHost);

    public String getTargetHost();

    public void setReadCommunity(String aCommunity);

    public String getReadCommunity();

    public void setWriteCommunity(String aCommunity);

    public String getWriteCommunity();

    public void setSnmpVersion(int aVersion);

    public int getSnmpVersion();

    public void setTargetPort(int aPort);

    public int getTargetPort();

    public void setTimeout(int aTimeout);

    public int getTimeout();

    public void setRetries(int aRetries);

    public int getRetries();

    /**
     * Load table data from device according to the oid list specified.
     *
     * @param anOidList oid list of the table items
     * @return the table data. The elements in vector is Object[],
     *         which is data of one row
     */
    public Vector loadTable(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException;


    /**
     * Load table data from device according to the oid list specified
     * and the data as index in the oid returned.
     * <p/>
     * The length of indexByteCountList indicates the count of indexes
     * returned. The value of indexByteCountList indicates
     * byte count occupied by each index. For integer type, the byte count
     * of index is 1. For IP address is 4 and for MAC address is 6.
     * <p/>
     * The values of indexes returned are ahead of the values of row data.
     *
     * @param anOidList          oid list of the table items
     * @param indexByteCountList index type array
     * @return the table data. The elements in vector is Object[],
     *         which is data of one row
     */
    public Vector loadTable(String[] anOidList, int[] indexByteCountList)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;

    /**
     * This mothod is the same as {@link #loadTable(java.lang.String[], int[])}
     * except that it use SNMP_GET_BULK request to retrieve data. Since SNMP v1
     * doesn't support SNMP_GET_BULK request, exception will be thrown
     * when SNMP v1 protocol is used.
     *
     * @param anOidList          oid list of the table items
     * @param indexByteCountList index type array
     * @param rowsPerFetch       max rows for each getbulk request
     * @return the table data. The elements in vector is Object[],
     *         which is data of one row
     */
    public Vector loadTable(String[] anOidList, int[] indexByteCountList,
                            int rowsPerFetch)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;


    /**
     * This mothod is the same as {@link #loadTable(String[], int[], int, int, String)}
     * except row
     *
     * @see #loadTable(String[], int[], int, int, String)
     */
    public Vector loadTable(String[] anOidList, int[] indexByteCountList,
                            int rowsPerFetch, int retrieveCount)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;


    /**
     * This method retrieve data from a MIB table with additional options.
     * ( SNMP GET_BULK operation is used. )
     * 1. Row count of each fetch
     * 2. Row count to retrieve
     * 3. Sub-table index
     * <p/>
     * If the row count is less than 0, all rows will be retrieved.
     *
     * @param anOidList          oid list of the table items
     * @param indexByteCountList index type array
     * @param rowsPerFetch       max rows for each getbulk request
     * @param retrieveCount      row count to retrieve
     * @param aSubTableIndex     Sub-table index
     * @return the table data. The elements in vector is Object[],
     *         which is data of one row
     */
    public Vector loadTable(String[] anOidList, int[] indexByteCountList,
                            int rowsPerFetch, int retrieveCount, String aSubTableIndex)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;

    /**
     * This method retrieve data from a MIB table with additional options.
     * ( SNMP GET_BULK operation is used. )
     * 1. Row count of each fetch
     * 2. Row count to retrieve
     * 3. Sub-table index
     * 4. Sub-table index prefix
     * <p/>
     * The row count depends on the retrieveCount and indexPrefix.
     *
     * @param anOidList          oid list of the table items
     * @param indexByteCountList index type array
     * @param rowsPerFetch       max rows for each getbulk request
     * @param retrieveCount      row count to retrieve
     * @param aSubTableIndex     Sub-table index which the table is loaded from.
     * @param indexPrefix        Sub-talbe index prefix, this method only retrieves the
     *                           data which index starts with indexPrfix.
     * @return the table data. The elements in vector is Object[],
     *         which is data of one row
     */
    public Vector loadTable(String[] anOidList, int[] indexByteCountList,
                            int rowsPerFetch, int retrieveCount, String aSubTableIndex, String indexPrefix)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;

    /**
     * Load a row data from device according to the oid list specified.
     *
     * @param anOidList oid list of the row items
     * @return the row data
     */
    public Object[] loadRow(String[] anOidList) throws com.winnertel.snmp.snmp2.DefaultSnmpException;

    /**
     * Load row data from device according to the oid list specified
     * and the data as index in the oid returned.
     *
     * @param anOidList          oid list of the row items
     * @param indexByteCountList index type array
     * @return the row data
     * @see #loadTable
     */
    public Object[] loadRow(String[] anOidList, int[] indexByteCountList)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;

    /**
     * Save one row data to device. The type in aTypeList should be
     * from ISnmpConstant interface.
     *
     * @param anOidList  oid list of the row items
     * @param aValueList value list of the row items
     * @param aTypeList  type list of the row items
     * @return true if operation succeeded, false otherwise
     */
    public boolean saveRow(String[] anOidList, Object[] aValueList,
                           byte[] aTypeList)
            throws com.winnertel.snmp.snmp2.DefaultSnmpException;


    public void releaseResources();


    public void addTrapListener(com.winnertel.snmp.beans.SnmpTrapListener aSnmpTrapListener);

}

