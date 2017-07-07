package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCVLANGroup class.
 * Created by QuickDVM
 */
public class ModEoCVLANGroup extends EocBaseSnmpMibBean {
    public static final String modEoCVLANVersionNumber = "modEoCVLANVersionNumber";
    public static final String modEoCVLANMaxVID = "modEoCVLANMaxVID";
    public static final String modEoCVLANMaxSupportedVLANs = "modEoCVLANMaxSupportedVLANs";
    public static final String modEoCVLANCreatedVLANNumber = "modEoCVLANCreatedVLANNumber";
    public static final String modEoCVLANVIDList = "modEoCVLANVIDList";
    public static final String modEoCVLANNextFreeVID = "modEoCVLANNextFreeVID";

    public ModEoCVLANGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCVLANVersionNumber, new SnmpMibBeanProperty(modEoCVLANVersionNumber, MIB_Head1 + ".9.1", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANMaxVID, new SnmpMibBeanProperty(modEoCVLANMaxVID, MIB_Head1 + ".9.2", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANMaxSupportedVLANs, new SnmpMibBeanProperty(modEoCVLANMaxSupportedVLANs, MIB_Head1 + ".9.3", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANCreatedVLANNumber, new SnmpMibBeanProperty(modEoCVLANCreatedVLANNumber, MIB_Head1 + ".9.4", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANVIDList, new SnmpMibBeanProperty(modEoCVLANVIDList, MIB_Head1 + ".9.5", ISnmpConstant.OCTETS));
        initProperty(modEoCVLANNextFreeVID, new SnmpMibBeanProperty(modEoCVLANNextFreeVID, MIB_Head1 + ".9.6", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCVLANVersionNumber() {
        return (Integer) getProperty(modEoCVLANVersionNumber).getValue();
    }

    public void setModEoCVLANVersionNumber(Integer aModEoCVLANVersionNumber) {
        getProperty(modEoCVLANVersionNumber).setValue(aModEoCVLANVersionNumber);
    }

    public Integer getModEoCVLANMaxVID() {
        return (Integer) getProperty(modEoCVLANMaxVID).getValue();
    }

    public void setModEoCVLANMaxVID(Integer aModEoCVLANMaxVID) {
        getProperty(modEoCVLANMaxVID).setValue(aModEoCVLANMaxVID);
    }

    public Integer getModEoCVLANMaxSupportedVLANs() {
        return (Integer) getProperty(modEoCVLANMaxSupportedVLANs).getValue();
    }

    public void setModEoCVLANMaxSupportedVLANs(Integer aModEoCVLANMaxSupportedVLANs) {
        getProperty(modEoCVLANMaxSupportedVLANs).setValue(aModEoCVLANMaxSupportedVLANs);
    }

    public Integer getModEoCVLANCreatedVLANNumber() {
        return (Integer) getProperty(modEoCVLANCreatedVLANNumber).getValue();
    }

    public void setModEoCVLANCreatedVLANNumber(Integer aModEoCVLANCreatedVLANNumber) {
        getProperty(modEoCVLANCreatedVLANNumber).setValue(aModEoCVLANCreatedVLANNumber);
    }

    public byte[] getModEoCVLANVIDList() {
        return (byte[]) getProperty(modEoCVLANVIDList).getValue();
    }

    public void setModEoCVLANVIDList(byte[] aModEoCVLANVIDList) {
        getProperty(modEoCVLANVIDList).setValue(aModEoCVLANVIDList);
    }

    public Integer getModEoCVLANNextFreeVID() {
        return (Integer) getProperty(modEoCVLANNextFreeVID).getValue();
    }

    public void setModEoCVLANNextFreeVID(Integer aModEoCVLANNextFreeVID) {
        getProperty(modEoCVLANNextFreeVID).setValue(aModEoCVLANNextFreeVID);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCVLANVersionNumber));
        prepareRead(super.getProperty(modEoCVLANMaxVID));
        prepareRead(super.getProperty(modEoCVLANMaxSupportedVLANs));
        prepareRead(super.getProperty(modEoCVLANCreatedVLANNumber));
        prepareRead(super.getProperty(modEoCVLANVIDList));
        prepareRead(super.getProperty(modEoCVLANNextFreeVID));

        return load();
    }


}
    
