package com.winnertel.em.framework.model.snmp;

import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import org.apache.commons.collections.map.ListOrderedMap;

import java.util.*;

public abstract class SnmpMibBean implements IMibBean, Cloneable {

    private static final byte TABLE_INDEX = 1;
    private static final byte TABLE_OR_SCALAR_INDEX = 2;
    private static final byte SCALAR_INDEX = 3;

    private final ILogger fLogger = LoggerController.createLogger(SnmpMibBean.class);

    protected ISnmpProxy fSnmpProxy = null;

    private int fRowsPerFetch = 1;
    private int fRowsToFetch = 0;

    private final Map fPreparedMap = new ListOrderedMap();

    private Map fPropertyMap = new ListOrderedMap();

    private final int MAX_INDEX_COUNT = 20;
    private ArrayList fIndexList = new ArrayList(MAX_INDEX_COUNT);

    protected final String ROW_STATUS = "rowStatus";

    // indicate snmpProxy only retrieve the data which index starts with indexPrefix.
    private String indexPrefix = null;

    public SnmpMibBean(ISnmpProxy aSnmpProxy) {
        fSnmpProxy = aSnmpProxy;
        for (int i = 0; i < MAX_INDEX_COUNT; i++) {
            fIndexList.add(null);
        }
    }

    protected abstract void init();

    protected final int getRowsPerFetch() {
        return fRowsPerFetch;
    }

    public final void setRowsPerFetch(int aRowsPerFetch) {
        if (aRowsPerFetch < 1) {
            throw new IllegalArgumentException("rows per fetch should not be less thant 1");
        }
        fRowsPerFetch = aRowsPerFetch;
    }

    public final int getRowsToFetch() {
        return fRowsToFetch;
    }

    public final void setRowsToFetch(int aRowsToFetch) {
        if (aRowsToFetch < 0) {
            throw new IllegalArgumentException("rows to fetch should not be less thant 0");
        }
        fRowsToFetch = aRowsToFetch;
    }

    public final Object getIndex(int i) {
        return fIndexList.get(i);
    }

    public int getIndexCount() {
        for (int i = 0; i < fIndexList.size(); i++) {
            if (fIndexList.get(i) == null) {
                return i;
            }
        }

        return fIndexList.size();
    }

    public final void setIndex(int anIndex, Object anValue) {
        fIndexList.set(anIndex, anValue);
    }

    public final String getIndexPrefix() {
        return indexPrefix;
    }

    public final void setIndexPrefix(String prefix) {
        indexPrefix = prefix;
    }

    protected final void setRowStatus(Integer aRowStatus) {
        getProperty(ROW_STATUS).setValue(aRowStatus);
    }

    protected final void prepareRead(SnmpMibBeanProperty aProperty) {
        fPreparedMap.put(aProperty.getName(), aProperty);
    }

    protected final void prepareSave(SnmpMibBeanProperty aProperty) {
        if (aProperty.isModified()) {
            fPreparedMap.put(aProperty.getName(), aProperty);
        }
    }

    private final void releasePreparedList() {
        // set property status to un-modified
        Collection colProp = fPreparedMap.values();
        if (colProp != null && colProp.size() > 0) {
            Iterator it = colProp.iterator();
            while (it.hasNext()) {
                SnmpMibBeanProperty prop = (SnmpMibBeanProperty) it.next();
                prop.setModified(false);
            }
        }

        fPreparedMap.clear();
    }

    /**
     * This method has been deprecated. Please use initProperty() method.
     *
     * @param aName
     * @param aProperty
     * @see #initProperty
     * @deprecated
     */
    protected final void putProperty(String aName, SnmpMibBeanProperty aProperty) {
        fPropertyMap.put(aName, aProperty);
    }

    protected final void initProperty(String aName, SnmpMibBeanProperty aProperty) {
        fPropertyMap.put(aName, aProperty);
    }

    protected final SnmpMibBeanProperty getProperty(String aName) {
        return (SnmpMibBeanProperty) fPropertyMap.get(aName);
    }

    protected final Vector loadAll(int[] indexByteCountList) {
        int propertyCount = fPreparedMap.size();
        if (propertyCount == 0 && indexByteCountList.length == 0) {
            return new Vector(0);
        }

        Vector result = null;
        try {
            // build sub-index
            String subIndex = buildIndex(TABLE_INDEX);

            // build oid list for retrieval.
            String[] oidList = new String[propertyCount];
            Collection props = fPreparedMap.values();
            Iterator it = props.iterator();
            int propIndex = 0;
            while (it.hasNext()) {
                SnmpMibBeanProperty property = (SnmpMibBeanProperty) it.next();
                oidList[propIndex] = property.getOid();
                propIndex++;
            }

            // retrieve data with the help of SNMP proxy
            Vector tableData = null;
            tableData = fSnmpProxy.loadTable(oidList, indexByteCountList, getRowsPerFetch(), getRowsToFetch(), subIndex, indexPrefix);
            int rowCount = tableData.size();
            if (rowCount == 0) {
                return new Vector(0);
            }

            // extract values from table data and create MIB bean list
            result = new Vector(rowCount);
            int indexCount = indexByteCountList.length;
            for (int i = 0; i < rowCount; i++) {
                Object[] data = (Object[]) tableData.get(i);
                SnmpMibBean bean = (SnmpMibBean) clone();
                for (propIndex = 0; propIndex < indexCount; propIndex++) {
                    bean.fIndexList.set(propIndex, data[propIndex]);
                }

                Collection beanProps = bean.fPreparedMap.values();
                Iterator itProps = beanProps.iterator();
                while (itProps.hasNext()) {
                    SnmpMibBeanProperty property = (SnmpMibBeanProperty) itProps.next();

                    Object value = data[propIndex];

                    if (property.getType() == ISnmpConstant.STRING && data[propIndex] instanceof byte[]) {
                        // Special for octets, maybe there's a good way for this?
                        // value = new String((byte[])value, "gb2312");
                        value = covertToLegalString((byte[]) value);
                    }

                    MibBeanUtil.setSimpleProperty(bean, property.getName(), value);
                    propIndex++;
                }
                result.add(bean);
            }
        } catch (Exception ex) {
            fLogger.error("Error in loading all mib beans", ex);
        } finally {
            releasePreparedList();
        }

        return result;
    }

    private String covertToLegalString(byte[] value) {
        boolean isEmpty = true;
        for( byte b : value ) {
            if( b == 0 ) {
                continue;
            } else {
                isEmpty = false;
                break;
            }
        }
        if( !isEmpty ) {
            return new String(value);
        }
        return "";

    }

    private Object extractVarObject(com.winnertel.snmp.snmp2.SnmpVar aSnmpVar) {
        Object value = null;
        byte varType = aSnmpVar.getType();
        switch (varType) {
            case com.winnertel.snmp.snmp2.DefaultSnmpAPI.STRING:
                value = aSnmpVar.toBytes();
                break;
            case com.winnertel.snmp.snmp2.DefaultSnmpAPI.COUNTER64:
                value = ((com.winnertel.snmp.snmp2.SnmpCounter64) aSnmpVar).toBigInteger();
                break;
            default:
                value = aSnmpVar.getVarObject();
                break;
        }

        return value;
    }

    protected final boolean load() throws MibBeanException {
        int propertyCount = fPreparedMap.size();
        if (propertyCount == 0) {
            return false;
        }

        try {
            String[] oidList = new String[propertyCount];
            String index = buildIndex(TABLE_OR_SCALAR_INDEX);
            Collection props = fPreparedMap.values();
            Iterator it = props.iterator();
            int propIndex = 0;
            while (it.hasNext()) {
                SnmpMibBeanProperty property = (SnmpMibBeanProperty) it.next();
                oidList[propIndex] = property.getOid() + index;
                propIndex++;
            }

            Object[] rowData = fSnmpProxy.loadRow(oidList);
            if (rowData == null) {
                return false;
            }
            it = props.iterator();
            propIndex = 0;
            while (it.hasNext()) {
                SnmpMibBeanProperty property = (SnmpMibBeanProperty) it.next();
                property.setValue(rowData[propIndex]);
                propIndex++;
            }
        } catch (Exception ex) {
            fLogger.debug("Error in loading mib bean", ex);
            throw new MibBeanException(ex);
        } finally {
            releasePreparedList();
        }

        return true;
    }

    private String buildIndex(byte policy) {
        StringBuffer result = new StringBuffer();
        switch (policy) {
            case TABLE_INDEX:
                buildTableIndex(result);
                break;
            case TABLE_OR_SCALAR_INDEX:
                buildTableIndex(result);
                if (result.length() == 0) {
                    buildScalarIndex(result);
                }
                break;
            case SCALAR_INDEX:
                buildScalarIndex(result);
                break;
        }

        return result.toString();
    }

    private void buildScalarIndex(StringBuffer aResult) {
        aResult.append(".0");
    }

    private void buildTableIndex(StringBuffer aResult) {
        for (int i = 0; i < fIndexList.size(); i++) {
            Object o = fIndexList.get(i);
            if (o != null) {
                if (o instanceof byte[]) {
                    // if is mac address
                    byte[] data = (byte[]) o;
                    for (int j = 0; j < data.length; j++) {
                        int b = data[j];
                        if (b < 0) {
                            b += 0x100;
                        }
                        aResult.append('.');
                        aResult.append(b);
                    }
                } else if (o instanceof long[]) {
                    long[] oldData = (long[]) o;
                    long[] data = new long[oldData.length + 1];
                    data[0] = oldData.length;
                    System.arraycopy(oldData, 0, data, 1, oldData.length);
                    for (int j = 0; j < data.length; j++) {
                        aResult.append('.');
                        aResult.append(data[j]);
                    }
                } else {
                    aResult.append('.');
                    aResult.append(o.toString());
                }
            }
        }
    }

    protected final boolean save() throws MibBeanException {
        int propertyCount = fPreparedMap.size();
        if (propertyCount == 0) {
            return false;
        }

        boolean result = false;
        try {
            String[] oidList = new String[propertyCount];
            Object[] valueList = new Object[propertyCount];
            byte[] typeList = new byte[propertyCount];
            String index = buildIndex(TABLE_OR_SCALAR_INDEX);
            Collection beanProps = fPreparedMap.values();
            Iterator itProps = beanProps.iterator();
            int propIndex = 0;
            while (itProps.hasNext()) {
                SnmpMibBeanProperty property = (SnmpMibBeanProperty) itProps.next();
                oidList[propIndex] = property.getOid() + index;
                valueList[propIndex] = property.getValue();
                typeList[propIndex] = property.getType();
                propIndex++;
            }
            result = fSnmpProxy.saveRow(oidList, valueList, typeList);
        } catch (DefaultSnmpPduException ex) {
            fLogger.debug("Error in saving mib bean", ex);
            MibBeanException mibBeanException = new MibBeanException(ex);
            mibBeanException.setRequestId(ex.getRequestId());
            mibBeanException.setErrorStatus(ex.getErrorStatus());
            mibBeanException.setLocalAddress(ex.getLocalAddress());

            int errorIndex = ex.getErrorIndex();
            if (errorIndex > 0) {
                String tmPropertyName = (String) ((ListOrderedMap) fPreparedMap).get(errorIndex - 1);
                if (!ROW_STATUS.equalsIgnoreCase(tmPropertyName)) {
                    mibBeanException.setErrorItem(tmPropertyName);
                }
            }
            throw mibBeanException;
        } catch (Exception ex) {
            fLogger.debug("Error in saving mib bean", ex);
            throw new MibBeanException(ex);
        } finally {
            releasePreparedList();
        }

        return result;
    }

    public boolean retrieve() throws MibBeanException {
        return false;
    }

    public Vector retrieveAll() throws MibBeanException {
        return null;
    }

    public boolean add() throws MibBeanException {
        return false;
    }

    public boolean modify() throws MibBeanException {
        return false;
    }

    public boolean delete() throws MibBeanException {
        return false;
    }

    public void resetStatus() {
        Collection props = fPropertyMap.values();
        if (props != null) {
            Iterator it = props.iterator();
            while (it.hasNext()) {
                SnmpMibBeanProperty property = (SnmpMibBeanProperty) it.next();
                property.setModified(false);
            }
        }
    }

    public void copyProperties(SnmpMibBean aSnmpMibBean) {
        fPropertyMap = deepCopy(aSnmpMibBean.fPropertyMap);
    }

    public final Object clone() {
        try {
            SnmpMibBean result = (SnmpMibBean) super.clone();

            result.fPropertyMap = deepCopy(fPropertyMap);
            result.fIndexList = (ArrayList) fIndexList.clone();

            return result;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    private static Map deepCopy(Map aPropertyMap) {
        Map propertyMap = new ListOrderedMap();
        Collection beanProps = aPropertyMap.values();
        Iterator itProps = beanProps.iterator();
        while (itProps.hasNext()) {
            SnmpMibBeanProperty property = (SnmpMibBeanProperty) itProps.next();
            SnmpMibBeanProperty newProperty = (SnmpMibBeanProperty) property.clone();
            propertyMap.put(newProperty.getName(), newProperty);
        }

        return propertyMap;
    }

    /**
     * encode a SnmpMibBean by Properties. NSManager uses this method to create a SnmpMibBean.
     *
     * @param pro
     * @return SnmpMibBean return a SnmpMibBean instance.
     */
    public SnmpMibBean encode(Properties pro) {
        return null;
    }

    public boolean isApplyChanged() {
        return fApplyChanged;
    }

    public void setApplyChanged(boolean fApplyChanged) {
        this.fApplyChanged = fApplyChanged;
    }

    private boolean fApplyChanged = false;

}
