package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.ems.epon.iad.bbs4000.formatter.BridgeIdFormatter;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The MSTPGeneralMBean class.
 * Created by QuickDVM
 */
public class MSTPGeneralMBean extends SnmpMibBean {
    public static final String mstpGenBridgeMaxAge = "mstpGenBridgeMaxAge";
    public static final String mstpGenBridgeHelloTime = "mstpGenBridgeHelloTime";
    public static final String mstpGenBridgeForwardDelay = "mstpGenBridgeForwardDelay";
    public static final String mstpGenMaxAge = "mstpGenMaxAge";
    public static final String mstpGenHelloTime = "mstpGenHelloTime";
    public static final String mstpGenForwardDelay = "mstpGenForwardDelay";
    public static final String mstpGenMaxHops = "mstpGenMaxHops";
//    public static final String mstpGenHoldTime = "mstpGenHoldTime";
//    public static final String mstpGenMigrateTime = "mstpGenMigrateTime";
    public static final String mstpGenPathCostDefault = "mstpGenPathCostDefault";
    public static final String mstpGenCapable = "mstpGenCapable";
    public static final String mstpGenForceVersion = "mstpGenForceVersion";
//    public static final String mstpGenCfgIdFmtSel = "mstpGenCfgIdFmtSel";
    public static final String mstpGenCfgIdName = "mstpGenCfgIdName";
    public static final String mstpGenCfgIdRevLevel = "mstpGenCfgIdRevLevel";
    public static final String mstpGenReginalRoot = "mstpGenReginalRoot";
    public static final String mstpGenExternalRootCost = "mstpGenExternalRootCost";

    public MSTPGeneralMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(mstpGenBridgeMaxAge, new SnmpMibBeanProperty(mstpGenBridgeMaxAge, ".1.3.6.1.2.1.17.10.10.2", ISnmpConstant.INTEGER));
        initProperty(mstpGenBridgeHelloTime, new SnmpMibBeanProperty(mstpGenBridgeHelloTime, ".1.3.6.1.2.1.17.10.10.3", ISnmpConstant.INTEGER));
        initProperty(mstpGenBridgeForwardDelay, new SnmpMibBeanProperty(mstpGenBridgeForwardDelay, ".1.3.6.1.2.1.17.10.10.4", ISnmpConstant.INTEGER));
        initProperty(mstpGenMaxAge, new SnmpMibBeanProperty(mstpGenMaxAge, ".1.3.6.1.2.1.17.10.10.8", ISnmpConstant.INTEGER));
        initProperty(mstpGenHelloTime, new SnmpMibBeanProperty(mstpGenHelloTime, ".1.3.6.1.2.1.17.10.10.9", ISnmpConstant.INTEGER));
        initProperty(mstpGenForwardDelay, new SnmpMibBeanProperty(mstpGenForwardDelay, ".1.3.6.1.2.1.17.10.10.10", ISnmpConstant.INTEGER));
        initProperty(mstpGenMaxHops, new SnmpMibBeanProperty(mstpGenMaxHops, ".1.3.6.1.2.1.17.10.10.14", ISnmpConstant.INTEGER));
//        initProperty(mstpGenHoldTime, new SnmpMibBeanProperty(mstpGenHoldTime, ".1.3.6.1.2.1.17.10.10.15", ISnmpConstant.INTEGER));
//        initProperty(mstpGenMigrateTime, new SnmpMibBeanProperty(mstpGenMigrateTime, ".1.3.6.1.2.1.17.10.10.16", ISnmpConstant.INTEGER));
        initProperty(mstpGenPathCostDefault, new SnmpMibBeanProperty(mstpGenPathCostDefault, ".1.3.6.1.2.1.17.10.10.18", ISnmpConstant.INTEGER));
        initProperty(mstpGenCapable, new SnmpMibBeanProperty(mstpGenCapable, ".1.3.6.1.2.1.17.10.10.19", ISnmpConstant.INTEGER));
        initProperty(mstpGenForceVersion, new SnmpMibBeanProperty(mstpGenForceVersion, ".1.3.6.1.2.1.17.10.10.20", ISnmpConstant.INTEGER));
//        initProperty(mstpGenCfgIdFmtSel, new SnmpMibBeanProperty(mstpGenCfgIdFmtSel, ".1.3.6.1.2.1.17.10.10.30", ISnmpConstant.INTEGER));
        initProperty(mstpGenCfgIdName, new SnmpMibBeanProperty(mstpGenCfgIdName, ".1.3.6.1.2.1.17.10.10.31", ISnmpConstant.STRING));
        initProperty(mstpGenCfgIdRevLevel, new SnmpMibBeanProperty(mstpGenCfgIdRevLevel, ".1.3.6.1.2.1.17.10.10.32", ISnmpConstant.INTEGER));
        initProperty(mstpGenReginalRoot, new SnmpMibBeanProperty(mstpGenReginalRoot, ".1.3.6.1.2.1.17.10.10.36", ISnmpConstant.OCTETS));
        initProperty(mstpGenExternalRootCost, new SnmpMibBeanProperty(mstpGenExternalRootCost, ".1.3.6.1.2.1.17.10.10.37", ISnmpConstant.INTEGER));
    }


    public Integer getMstpGenBridgeMaxAge() {
        Integer a = (Integer) getProperty(mstpGenBridgeMaxAge).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenBridgeMaxAge(Integer aMstpGenBridgeMaxAge) {
        getProperty(mstpGenBridgeMaxAge).setValue(aMstpGenBridgeMaxAge);
    }

    public Integer getMstpGenBridgeHelloTime() {
        Integer a = (Integer) getProperty(mstpGenBridgeHelloTime).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenBridgeHelloTime(Integer aMstpGenBridgeHelloTime) {
        getProperty(mstpGenBridgeHelloTime).setValue(aMstpGenBridgeHelloTime);
    }

    public Integer getMstpGenBridgeForwardDelay() {
        Integer a = (Integer) getProperty(mstpGenBridgeForwardDelay).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenBridgeForwardDelay(Integer aMstpGenBridgeForwardDelay) {
        getProperty(mstpGenBridgeForwardDelay).setValue(aMstpGenBridgeForwardDelay);
    }

    public Integer getMstpGenMaxAge() {
        Integer a = (Integer) getProperty(mstpGenMaxAge).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenMaxAge(Integer aMstpGenMaxAge) {
        getProperty(mstpGenMaxAge).setValue(aMstpGenMaxAge);
    }

    public Integer getMstpGenHelloTime() {
        Integer a = (Integer) getProperty(mstpGenHelloTime).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenHelloTime(Integer aMstpGenHelloTime) {
        getProperty(mstpGenHelloTime).setValue(aMstpGenHelloTime);
    }

    public Integer getMstpGenForwardDelay() {
        Integer a = (Integer) getProperty(mstpGenForwardDelay).getValue();
        return new Integer(a.intValue() / 100);
    }

    public void setMstpGenForwardDelay(Integer aMstpGenForwardDelay) {
        getProperty(mstpGenForwardDelay).setValue(aMstpGenForwardDelay);
    }

    public Integer getMstpGenMaxHops() {
        return (Integer) getProperty(mstpGenMaxHops).getValue();
    }

    public void setMstpGenMaxHops(Integer aMstpGenMaxHops) {
        getProperty(mstpGenMaxHops).setValue(aMstpGenMaxHops);
    }

//    public Integer getMstpGenHoldTime() {
//        return (Integer) getProperty(mstpGenHoldTime).getValue();
//    }
//
//    public void setMstpGenHoldTime(Integer aMstpGenHoldTime) {
//        getProperty(mstpGenHoldTime).setValue(aMstpGenHoldTime);
//    }

//    public Integer getMstpGenMigrateTime() {
//        return (Integer) getProperty(mstpGenMigrateTime).getValue();
//    }
//
//    public void setMstpGenMigrateTime(Integer aMstpGenMigrateTime) {
//        getProperty(mstpGenMigrateTime).setValue(aMstpGenMigrateTime);
//    }

    public Integer getMstpGenPathCostDefault() {
        return (Integer) getProperty(mstpGenPathCostDefault).getValue();
    }

    public void setMstpGenPathCostDefault(Integer aMstpGenPathCostDefault) {
        getProperty(mstpGenPathCostDefault).setValue(aMstpGenPathCostDefault);
    }

    public Integer getMstpGenCapable() {
        return (Integer) getProperty(mstpGenCapable).getValue();
    }

    public void setMstpGenCapable(Integer aMstpGenCapable) {
        getProperty(mstpGenCapable).setValue(aMstpGenCapable);
    }

    public Integer getMstpGenForceVersion() {
        return (Integer) getProperty(mstpGenForceVersion).getValue();
    }

    public void setMstpGenForceVersion(Integer aMstpGenForceVersion) {
        getProperty(mstpGenForceVersion).setValue(aMstpGenForceVersion);
    }

//    public Integer getMstpGenCfgIdFmtSel() {
//        return (Integer) getProperty(mstpGenCfgIdFmtSel).getValue();
//    }
//
//    public void setMstpGenCfgIdFmtSel(Integer aMstpGenCfgIdFmtSel) {
//        getProperty(mstpGenCfgIdFmtSel).setValue(aMstpGenCfgIdFmtSel);
//    }
//
    public String getMstpGenCfgIdName() {
        return (String) getProperty(mstpGenCfgIdName).getValue();
    }

    public void setMstpGenCfgIdName(String aMstpGenCfgIdName) {
        getProperty(mstpGenCfgIdName).setValue(aMstpGenCfgIdName);
    }

    public Integer getMstpGenCfgIdRevLevel() {
        return (Integer) getProperty(mstpGenCfgIdRevLevel).getValue();
    }

    public void setMstpGenCfgIdRevLevel(Integer aMstpGenCfgIdRevLevel) {
        getProperty(mstpGenCfgIdRevLevel).setValue(aMstpGenCfgIdRevLevel);
    }

    public String getMstpGenReginalRoot() {
//        return (String) getProperty(mstpGenReginalRoot).getValue();
        byte[] root = (byte[]) getProperty(mstpGenReginalRoot).getValue();
        return BridgeIdFormatter.format(root);
    }

    public void setMstpGenReginalRoot(byte[] aMstpGenReginalRoot) {
        getProperty(mstpGenReginalRoot).setValue(aMstpGenReginalRoot);
    }

    public Integer getMstpGenExternalRootCost() {
        return (Integer) getProperty(mstpGenExternalRootCost).getValue();
    }

    public void setMstpGenExternalRootCost(Integer aMstpGenExternalRootCost) {
        getProperty(mstpGenExternalRootCost).setValue(aMstpGenExternalRootCost);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(mstpGenBridgeMaxAge));
        prepareRead(super.getProperty(mstpGenBridgeHelloTime));
        prepareRead(super.getProperty(mstpGenBridgeForwardDelay));
        prepareRead(super.getProperty(mstpGenMaxAge));
        prepareRead(super.getProperty(mstpGenHelloTime));
        prepareRead(super.getProperty(mstpGenForwardDelay));
        prepareRead(super.getProperty(mstpGenMaxHops));

        prepareRead(super.getProperty(mstpGenPathCostDefault));
        prepareRead(super.getProperty(mstpGenCapable));
//        prepareRead(super.getProperty(mstpGenCfgIdFmtSel));
        prepareRead(super.getProperty(mstpGenCfgIdName));
        prepareRead(super.getProperty(mstpGenCfgIdRevLevel));
        prepareRead(super.getProperty(mstpGenReginalRoot));
        prepareRead(super.getProperty(mstpGenExternalRootCost));


//        prepareRead(super.getProperty(mstpGenHoldTime));
//        prepareRead(super.getProperty(mstpGenMigrateTime));
        prepareRead(super.getProperty(mstpGenForceVersion));

        return load();
    }


    public boolean modify() throws MibBeanException {
        //mstpGenForceVersion is used as MSTP mode switch, it must be at first posion in SNMP packet.
        prepareSave(getProperty(mstpGenForceVersion));
        prepareSave(getProperty(mstpGenBridgeMaxAge));
        prepareSave(getProperty(mstpGenBridgeHelloTime));
        prepareSave(getProperty(mstpGenBridgeForwardDelay));
        prepareSave(getProperty(mstpGenMaxHops));
        prepareSave(getProperty(mstpGenPathCostDefault));
//        prepareSave(getProperty(mstpGenCfgIdFmtSel));
        prepareSave(getProperty(mstpGenCfgIdName));
        prepareSave(getProperty(mstpGenCfgIdRevLevel));
//        prepareSave(getProperty(mstpGenHoldTime));
//        prepareSave(getProperty(mstpGenMigrateTime));

        return save();
    }
}
