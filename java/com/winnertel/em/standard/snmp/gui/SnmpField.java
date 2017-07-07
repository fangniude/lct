package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.Map;

public class SnmpField {
    // field name
    private String fName = null;

    public String getName() {
        return fName;
    }

    public void setName(String aName) {
        fName = aName;
    }


    // field label, used as column header in table and label in form
    private String fLabel = null;

    public String getLabel() {
        return fLabel;
    }

    public void setLabel(String aLabel) {
        fLabel = aLabel;
    }


    // mib oid of the field
    private String fOid = null;

    public String getOid() {
        return fOid;
    }

    public void setOid(String aOid) {
        fOid = aOid;
    }


    // mib type of the field
    // see ISnmpConstant
    private byte fType = 0;

    public byte getType() {
        return fType;
    }

    public void setType(byte aType) {
        fType = aType;
    }


    // value map of the field.
    // the key is a value in device, and the value is text displayed to user
    private Map fValueMap = null;

    public Map getValueMap() {
        return fValueMap;
    }

    public void setValueMap(Map aValueMap) {
        fValueMap = aValueMap;
    }


    // formatter class of the field
    private SnmpFieldFormatter fFormatter = null;

    public SnmpFieldFormatter getFormatter() {
        return fFormatter;
    }

    public void setFormatter(SnmpFieldFormatter aFormatter) {
        fFormatter = aFormatter;
    }


    // mib bean property name of the field
    private String fMibProperty = null;

    public String getMibProperty() {
        return fMibProperty;
    }

    public void setMibProperty(String aMibProperty) {
        fMibProperty = aMibProperty;
    }


    // byte count of the index value
    // generally 1 for integer, 4 for ip address, 6 for mac address
    private int fIndexByteCount = 0;

    public int getIndexByteCount() {
        return fIndexByteCount;
    }

    public void setIndexByteCount(int aIndexByteCount) {
        fIndexByteCount = aIndexByteCount;
    }


    // field reference
    private SnmpFieldReference fReference = null;

    public SnmpFieldReference getReference() {
        return fReference;
    }

    public void setReference(SnmpFieldReference aReference) {
        fReference = aReference;
    }


    // ctor
    public SnmpField(String aName, String aLabel, String anOid, byte aType,
                     Map aValueMap, SnmpFieldFormatter aFormatter) {
        fName = aName;
        fLabel = aLabel;
        fOid = anOid;
        fType = aType;
        fValueMap = aValueMap;
        fFormatter = aFormatter;
    }
}
