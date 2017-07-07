package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class MSTPXstPortTableMBean extends SnmpMibBean {
    public static final String mstpXstPortXstId = "mstpXstPortXstId";
    public static final String mstpXstPortIndex = "mstpXstPortIndex";
    public static final String mstpXstPortState = "mstpXstPortState";
    public static final String mstpXstPortRole = "mstpXstPortRole";
    public static final String mstpXstPortDesignatedRoot = "mstpXstPortDesignatedRoot";
//    public static final String mstpXstPortExternalRootCost = "mstpXstPortExternalRootCost";
    public static final String mstpXstPortRegionalBridge = "mstpXstPortRegionalBridge";
    public static final String mstpXstPortInternalRootCost = "mstpXstPortInternalRootCost";
    public static final String mstpXstPortDesignatedBridge = "mstpXstPortDesignatedBridge";
    public static final String mstpXstPortDesignatedPort = "mstpXstPortDesignatedPort";
    public static final String mstpXstPortPriority = "mstpXstPortPriority";
    public static final String mstpXstPortAdminInternalPathCost = "mstpXstPortAdminInternalPathCost";
    public static final String mstpXstPortOperInternalPathCost = "mstpXstPortOperInternalPathCost";

    public MSTPXstPortTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(mstpXstPortXstId, new SnmpMibBeanProperty(mstpXstPortXstId, ".1.3.6.1.2.1.17.10.14.1.1", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortIndex, new SnmpMibBeanProperty(mstpXstPortIndex, ".1.3.6.1.2.1.17.10.14.1.2", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortState, new SnmpMibBeanProperty(mstpXstPortState, ".1.3.6.1.2.1.17.10.14.1.3", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortRole, new SnmpMibBeanProperty(mstpXstPortRole, ".1.3.6.1.2.1.17.10.14.1.4", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortDesignatedRoot, new SnmpMibBeanProperty(mstpXstPortDesignatedRoot, ".1.3.6.1.2.1.17.10.14.1.6", ISnmpConstant.OCTETS));
//        initProperty(mstpXstPortExternalRootCost, new SnmpMibBeanProperty(mstpXstPortExternalRootCost, ".1.3.6.1.2.1.17.10.14.1.7", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortRegionalBridge, new SnmpMibBeanProperty(mstpXstPortRegionalBridge, ".1.3.6.1.2.1.17.10.14.1.8", ISnmpConstant.OCTETS));
        initProperty(mstpXstPortInternalRootCost, new SnmpMibBeanProperty(mstpXstPortInternalRootCost, ".1.3.6.1.2.1.17.10.14.1.9", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortDesignatedBridge, new SnmpMibBeanProperty(mstpXstPortDesignatedBridge, ".1.3.6.1.2.1.17.10.14.1.10", ISnmpConstant.OCTETS));
        initProperty(mstpXstPortDesignatedPort, new SnmpMibBeanProperty(mstpXstPortDesignatedPort, ".1.3.6.1.2.1.17.10.14.1.14", ISnmpConstant.OCTETS));
        initProperty(mstpXstPortPriority, new SnmpMibBeanProperty(mstpXstPortPriority, ".1.3.6.1.2.1.17.10.14.1.15", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortAdminInternalPathCost, new SnmpMibBeanProperty(mstpXstPortAdminInternalPathCost, ".1.3.6.1.2.1.17.10.14.1.16", ISnmpConstant.INTEGER));
        initProperty(mstpXstPortOperInternalPathCost, new SnmpMibBeanProperty(mstpXstPortOperInternalPathCost, ".1.3.6.1.2.1.17.10.14.1.17", ISnmpConstant.INTEGER));
    }

    public Integer getMstpXstPortXstId() {
        return new Integer(((Integer) getIndex(0)).intValue()-1);
    }

    public void setMstpXstPortXstId(Integer aMstpXstPortXstId) {
        setIndex(0, aMstpXstPortXstId);
    }


    public String getMstpXstPortIndex() {
        Integer index =  (Integer) getIndex(1);
        String strindex = "";
        if(index.intValue()<=12) {
            if(index.intValue()%4 == 0){
            strindex = ((index.intValue()/4))+"/"+4;
            }
            else{
                strindex = ((index.intValue()/4)+1)+"/"+(index.intValue()%4);
            }
        }
        else{
            strindex = "lg"+(index.intValue()-12);
        }
        return strindex;
    }

    public void setMstpXstPortIndex(Integer aMstpXstPortIndex) {
        setIndex(1, aMstpXstPortIndex);
    }


    public Integer getMstpXstPortState() {
        return (Integer) getProperty(mstpXstPortState).getValue();
    }

    public void setMstpXstPortState(Integer aMstpXstPortState) {
        getProperty(mstpXstPortState).setValue(aMstpXstPortState);
    }

    public Integer getMstpXstPortRole() {
        return (Integer) getProperty(mstpXstPortRole).getValue();
    }

    public void setMstpXstPortRole(Integer aMstpXstPortRole) {
        getProperty(mstpXstPortRole).setValue(aMstpXstPortRole);
    }

    public byte[] getMstpXstPortDesignatedRoot() {
        return (byte[]) getProperty(mstpXstPortDesignatedRoot).getValue();
    }

    public void setMstpXstPortDesignatedRoot(byte[] aMstpXstPortDesignatedRoot) {
        getProperty(mstpXstPortDesignatedRoot).setValue(aMstpXstPortDesignatedRoot);
    }

//    public Integer getMstpXstPortExternalRootCost() {
//        return (Integer) getProperty(mstpXstPortExternalRootCost).getValue();
//    }
//
//    public void setMstpXstPortExternalRootCost(Integer aMstpXstPortExternalRootCost) {
//        getProperty(mstpXstPortExternalRootCost).setValue(aMstpXstPortExternalRootCost);
//    }

    public byte[] getMstpXstPortRegionalBridge() {
        return (byte[]) getProperty(mstpXstPortRegionalBridge).getValue();
    }

    public void setMstpXstPortRegionalBridge(byte[] aMstpXstPortRegionalBridge) {
        getProperty(mstpXstPortRegionalBridge).setValue(aMstpXstPortRegionalBridge);
    }

    public Integer getMstpXstPortInternalRootCost() {
        return (Integer) getProperty(mstpXstPortInternalRootCost).getValue();
    }

    public void setMstpXstPortInternalRootCost(Integer aMstpXstPortInternalRootCost) {
        getProperty(mstpXstPortInternalRootCost).setValue(aMstpXstPortInternalRootCost);
    }

    public byte[] getMstpXstPortDesignatedBridge() {
        return (byte[]) getProperty(mstpXstPortDesignatedBridge).getValue();
    }

    public void setMstpXstPortDesignatedBridge(byte[] aMstpXstPortDesignatedBridge) {
        getProperty(mstpXstPortDesignatedBridge).setValue(aMstpXstPortDesignatedBridge);
    }

    public byte[] getMstpXstPortDesignatedPort() {
      return (byte[]) getProperty(mstpXstPortDesignatedPort).getValue();
    }

    public void setMstpXstPortDesignatedPort(byte[] aMstpXstPortDesignatedPort) {
        getProperty(mstpXstPortDesignatedPort).setValue(aMstpXstPortDesignatedPort);
    }

    public Integer getMstpXstPortPriority() {
        return (Integer) getProperty(mstpXstPortPriority).getValue();
    }

    public void setMstpXstPortPriority(Integer aMstpXstPortPriority) {
        getProperty(mstpXstPortPriority).setValue(aMstpXstPortPriority);
    }

    public Integer getMstpXstPortAdminInternalPathCost() {
        return (Integer) getProperty(mstpXstPortAdminInternalPathCost).getValue();
    }

    public void setMstpXstPortAdminInternalPathCost(Integer aMstpXstPortAdminInternalPathCost) {
        getProperty(mstpXstPortAdminInternalPathCost).setValue(aMstpXstPortAdminInternalPathCost);
    }

    public Integer getMstpXstPortOperInternalPathCost() {
        return (Integer) getProperty(mstpXstPortOperInternalPathCost).getValue();
    }

    public void setMstpXstPortOperInternalPathCost(Integer aMstpXstPortOperInternalPathCost) {
        getProperty(mstpXstPortOperInternalPathCost).setValue(aMstpXstPortOperInternalPathCost);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(mstpXstPortState));
        prepareRead(super.getProperty(mstpXstPortRole));
        prepareRead(super.getProperty(mstpXstPortDesignatedRoot));
//        prepareRead(super.getProperty(mstpXstPortExternalRootCost));
        prepareRead(super.getProperty(mstpXstPortRegionalBridge));
        prepareRead(super.getProperty(mstpXstPortInternalRootCost));
        prepareRead(super.getProperty(mstpXstPortDesignatedBridge));
        prepareRead(super.getProperty(mstpXstPortDesignatedPort));
        prepareRead(super.getProperty(mstpXstPortPriority));
        prepareRead(super.getProperty(mstpXstPortAdminInternalPathCost));
        prepareRead(super.getProperty(mstpXstPortOperInternalPathCost));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(mstpXstPortState));
        prepareRead(super.getProperty(mstpXstPortRole));
        prepareRead(super.getProperty(mstpXstPortDesignatedRoot));
//        prepareRead(super.getProperty(mstpXstPortExternalRootCost));
        prepareRead(super.getProperty(mstpXstPortRegionalBridge));
        prepareRead(super.getProperty(mstpXstPortInternalRootCost));
        prepareRead(super.getProperty(mstpXstPortDesignatedBridge));
        prepareRead(super.getProperty(mstpXstPortDesignatedPort));
        prepareRead(super.getProperty(mstpXstPortPriority));
        prepareRead(super.getProperty(mstpXstPortAdminInternalPathCost));
        prepareRead(super.getProperty(mstpXstPortOperInternalPathCost));

        return loadAll(new int[]{1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(mstpXstPortPriority));
        prepareSave(getProperty(mstpXstPortAdminInternalPathCost));

        return save();
    }


}
