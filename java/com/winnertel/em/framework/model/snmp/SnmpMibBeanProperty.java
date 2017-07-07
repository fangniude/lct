package com.winnertel.em.framework.model.snmp;

import java.math.BigInteger;

public class SnmpMibBeanProperty implements Cloneable {
    private String fName = null;

    private String fOid = null;

    private byte fType = 0;

    private Object fValue = null;

    private boolean fModified = false;


    public SnmpMibBeanProperty(String aName, String aOid, byte aType) {
        this(aName, aOid, aType, null);
    }

    public SnmpMibBeanProperty(String aName, String aOid, byte aType, Object aValue) {
        fName = aName;
        fOid = aOid;
        fType = aType;
        fValue = aValue;
    }


    public String getName() {
        return fName;
    }


    public String getOid() {
        return fOid;
    }


    public byte getType() {
        return fType;
    }


    public Object getValue() {
        return fValue;
    }

    public void setValue(Object aValue) {
        setModified(true);
        switch (fType) {
            case ISnmpConstant.INTEGER:
                fValue = (Integer) aValue;
                return;

            case ISnmpConstant.STRING:
                if (aValue instanceof byte[]) {
                    fValue = new String((byte[]) aValue);
                } else {
                    fValue = (String) aValue;
                }
                return;

            case ISnmpConstant.MAC_ADDRESS:
            case ISnmpConstant.OCTETS:
                fValue = (byte[]) aValue;
                return;

            case ISnmpConstant.IP_ADDRESS:
            case ISnmpConstant.OBJID:
                fValue = (String) aValue;
                return;

            case ISnmpConstant.COUNTER:
            case ISnmpConstant.GAUGE:
            case ISnmpConstant.TIME_TICKS:
                fValue = (Long) aValue;
                return;

            case ISnmpConstant.COUNTER64:
                fValue = (BigInteger) aValue;
                return;

            default:
                setModified(false);
        }
    }


    public boolean isModified() {
        return fModified;
    }

    protected void setModified(boolean aModified) {
        fModified = aModified;
    }


    public Object clone() {
        try {
            SnmpMibBeanProperty result = (SnmpMibBeanProperty) super.clone();
            return result;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
