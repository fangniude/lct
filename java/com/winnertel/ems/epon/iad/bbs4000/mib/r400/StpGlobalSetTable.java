/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class StpGlobalSetTable extends SnmpMibBean {

    public static final String stpGlobalSetIndex = "stpGlobalSetIndex";
    public static final String stpGlobalSetVersion = "stpGlobalSetVersion";
    public static final String stpGlobalSetPriority = "stpGlobalSetPriority";
    public static final String stpGlobalSetTimeSinceTopologyChange = "stpGlobalSetTimeSinceTopologyChange";
    public static final String stpGlobalSetTopChanges = "stpGlobalSetTopChanges";
    public static final String stpGlobalSetDesignatedRoot = "stpGlobalSetDesignatedRoot";
    public static final String stpGlobalSetRootCost = "stpGlobalSetRootCost";
    public static final String stpGlobalSetRootPort = "stpGlobalSetRootPort";
    public static final String stpGlobalSetMaxAge = "stpGlobalSetMaxAge";
    public static final String stpGlobalSetHelloTime = "stpGlobalSetHelloTime";
    public static final String stpGlobalSetHoldTime = "stpGlobalSetHoldTime";
    public static final String stpGlobalSetForwardDelay = "stpGlobalSetForwardDelay";
    public static final String stpGlobalSetBridgeMaxAge = "stpGlobalSetBridgeMaxAge";
    public static final String stpGlobalSetBridgeHelloTime = "stpGlobalSetBridgeHelloTime";
    public static final String stpGlobalSetBridgeForwardDelay = "stpGlobalSetBridgeForwardDelay";
    public static final String stpGlobalSetRstpTxHoldCount = "stpGlobalSetRstpTxHoldCount";
    public static final String stpGlobalSetEnable = "stpGlobalSetEnable";

    public StpGlobalSetTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(stpGlobalSetIndex, new SnmpMibBeanProperty(stpGlobalSetIndex, ".1.3.6.1.4.1.17409.2.3.9.1.1.1", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetVersion, new SnmpMibBeanProperty(stpGlobalSetVersion, ".1.3.6.1.4.1.17409.2.3.9.1.1.2", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetPriority, new SnmpMibBeanProperty(stpGlobalSetPriority, ".1.3.6.1.4.1.17409.2.3.9.1.1.3", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetTimeSinceTopologyChange, new SnmpMibBeanProperty(stpGlobalSetTimeSinceTopologyChange, ".1.3.6.1.4.1.17409.2.3.9.1.1.4", ISnmpConstant.COUNTER));
        initProperty(stpGlobalSetTopChanges, new SnmpMibBeanProperty(stpGlobalSetTopChanges, ".1.3.6.1.4.1.17409.2.3.9.1.1.5", ISnmpConstant.COUNTER));
        initProperty(stpGlobalSetDesignatedRoot, new SnmpMibBeanProperty(stpGlobalSetDesignatedRoot, ".1.3.6.1.4.1.17409.2.3.9.1.1.6", ISnmpConstant.OCTETS));
        initProperty(stpGlobalSetRootCost, new SnmpMibBeanProperty(stpGlobalSetRootCost, ".1.3.6.1.4.1.17409.2.3.9.1.1.7", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetRootPort, new SnmpMibBeanProperty(stpGlobalSetRootPort, ".1.3.6.1.4.1.17409.2.3.9.1.1.8", ISnmpConstant.OCTETS));
        initProperty(stpGlobalSetMaxAge, new SnmpMibBeanProperty(stpGlobalSetMaxAge, ".1.3.6.1.4.1.17409.2.3.9.1.1.9", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetHelloTime, new SnmpMibBeanProperty(stpGlobalSetHelloTime, ".1.3.6.1.4.1.17409.2.3.9.1.1.10", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetHoldTime, new SnmpMibBeanProperty(stpGlobalSetHoldTime, ".1.3.6.1.4.1.17409.2.3.9.1.1.11", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetForwardDelay, new SnmpMibBeanProperty(stpGlobalSetForwardDelay, ".1.3.6.1.4.1.17409.2.3.9.1.1.12", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetBridgeMaxAge, new SnmpMibBeanProperty(stpGlobalSetBridgeMaxAge, ".1.3.6.1.4.1.17409.2.3.9.1.1.13", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetBridgeHelloTime, new SnmpMibBeanProperty(stpGlobalSetBridgeHelloTime, ".1.3.6.1.4.1.17409.2.3.9.1.1.14", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetBridgeForwardDelay, new SnmpMibBeanProperty(stpGlobalSetBridgeForwardDelay, ".1.3.6.1.4.1.17409.2.3.9.1.1.15", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetRstpTxHoldCount, new SnmpMibBeanProperty(stpGlobalSetRstpTxHoldCount, ".1.3.6.1.4.1.17409.2.3.9.1.1.16", ISnmpConstant.INTEGER));
        initProperty(stpGlobalSetEnable, new SnmpMibBeanProperty(stpGlobalSetEnable, ".1.3.6.1.4.1.17409.2.3.9.1.1.17", ISnmpConstant.INTEGER));
    }

    public Integer getStpGlobalSetIndex() {
        return (Integer) getIndex(0);
    }

    public void setStpGlobalSetIndex(Integer aStpGlobalSetIndex) {
        setIndex(0, aStpGlobalSetIndex);
    }

    public Integer getStpGlobalSetVersion() {
        return (Integer) getProperty(stpGlobalSetVersion).getValue();
    }

    public void setStpGlobalSetVersion(Integer aStpGlobalSetVersion) {
        getProperty(stpGlobalSetVersion).setValue(aStpGlobalSetVersion);
    }

    public Integer getStpGlobalSetPriority() {
        return (Integer) getProperty(stpGlobalSetPriority).getValue();
    }

    public void setStpGlobalSetPriority(Integer aStpGlobalSetPriority) {
        getProperty(stpGlobalSetPriority).setValue(aStpGlobalSetPriority);
    }

    public Long getStpGlobalSetTimeSinceTopologyChange() {
        return (Long) getProperty(stpGlobalSetTimeSinceTopologyChange).getValue();
    }

    public void setStpGlobalSetTimeSinceTopologyChange(Long aStpGlobalSetTimeSinceTopologyChange) {
        getProperty(stpGlobalSetTimeSinceTopologyChange).setValue(aStpGlobalSetTimeSinceTopologyChange);
    }

    public Long getStpGlobalSetTopChanges() {
        return (Long) getProperty(stpGlobalSetTopChanges).getValue();
    }

    public void setStpGlobalSetTopChanges(Long aStpGlobalSetTopChanges) {
        getProperty(stpGlobalSetTopChanges).setValue(aStpGlobalSetTopChanges);
    }

    public byte[] getStpGlobalSetDesignatedRoot() {
        return (byte[]) getProperty(stpGlobalSetDesignatedRoot).getValue();
    }

    public void setStpGlobalSetDesignatedRoot(byte[] aStpGlobalSetDesignatedRoot) {
        getProperty(stpGlobalSetDesignatedRoot).setValue(aStpGlobalSetDesignatedRoot);
    }

    public Integer getStpGlobalSetRootCost() {
        return (Integer) getProperty(stpGlobalSetRootCost).getValue();
    }

    public void setStpGlobalSetRootCost(Integer aStpGlobalSetRootCost) {
        getProperty(stpGlobalSetRootCost).setValue(aStpGlobalSetRootCost);
    }

    public byte[] getStpGlobalSetRootPort() {
        return (byte[]) getProperty(stpGlobalSetRootPort).getValue();
    }

    public void setStpGlobalSetRootPort(byte[] aStpGlobalSetRootPort) {
        getProperty(stpGlobalSetRootPort).setValue(aStpGlobalSetRootPort);
    }

    public Integer getStpGlobalSetMaxAge() {
        return (Integer) getProperty(stpGlobalSetMaxAge).getValue();
    }

    public void setStpGlobalSetMaxAge(Integer aStpGlobalSetMaxAge) {
        getProperty(stpGlobalSetMaxAge).setValue(aStpGlobalSetMaxAge);
    }

    public Integer getStpGlobalSetHelloTime() {
        return (Integer) getProperty(stpGlobalSetHelloTime).getValue();
    }

    public void setStpGlobalSetHelloTime(Integer aStpGlobalSetHelloTime) {
        getProperty(stpGlobalSetHelloTime).setValue(aStpGlobalSetHelloTime);
    }

    public Integer getStpGlobalSetHoldTime() {
        return (Integer) getProperty(stpGlobalSetHoldTime).getValue();
    }

    public void setStpGlobalSetHoldTime(Integer aStpGlobalSetHoldTime) {
        getProperty(stpGlobalSetHoldTime).setValue(aStpGlobalSetHoldTime);
    }

    public Integer getStpGlobalSetForwardDelay() {
        return (Integer) getProperty(stpGlobalSetForwardDelay).getValue();
    }

    public void setStpGlobalSetForwardDelay(Integer aStpGlobalSetForwardDelay) {
        getProperty(stpGlobalSetForwardDelay).setValue(aStpGlobalSetForwardDelay);
    }

    public Integer getStpGlobalSetBridgeMaxAge() {
        return (Integer) getProperty(stpGlobalSetBridgeMaxAge).getValue();
    }

    public void setStpGlobalSetBridgeMaxAge(Integer aStpGlobalSetBridgeMaxAge) {
        getProperty(stpGlobalSetBridgeMaxAge).setValue(aStpGlobalSetBridgeMaxAge);
    }

    public Integer getStpGlobalSetBridgeHelloTime() {
        return (Integer) getProperty(stpGlobalSetBridgeHelloTime).getValue();
    }

    public void setStpGlobalSetBridgeHelloTime(Integer aStpGlobalSetBridgeHelloTime) {
        getProperty(stpGlobalSetBridgeHelloTime).setValue(aStpGlobalSetBridgeHelloTime);
    }

    public Integer getStpGlobalSetBridgeForwardDelay() {
        return (Integer) getProperty(stpGlobalSetBridgeForwardDelay).getValue();
    }

    public void setStpGlobalSetBridgeForwardDelay(Integer aStpGlobalSetBridgeForwardDelay) {
        getProperty(stpGlobalSetBridgeForwardDelay).setValue(aStpGlobalSetBridgeForwardDelay);
    }

    public Integer getStpGlobalSetRstpTxHoldCount() {
        return (Integer) getProperty(stpGlobalSetRstpTxHoldCount).getValue();
    }

    public void setStpGlobalSetRstpTxHoldCount(Integer aStpGlobalSetRstpTxHoldCount) {
        getProperty(stpGlobalSetRstpTxHoldCount).setValue(aStpGlobalSetRstpTxHoldCount);
    }

    public Integer getStpGlobalSetEnable() {
        return (Integer) getProperty(stpGlobalSetEnable).getValue();
    }

    public void setStpGlobalSetEnable(Integer aStpGlobalSetEnable) {
        getProperty(stpGlobalSetEnable).setValue(aStpGlobalSetEnable);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(stpGlobalSetVersion));
        prepareRead(getProperty(stpGlobalSetPriority));
        prepareRead(getProperty(stpGlobalSetTimeSinceTopologyChange));
        prepareRead(getProperty(stpGlobalSetTopChanges));
        prepareRead(getProperty(stpGlobalSetDesignatedRoot));
        prepareRead(getProperty(stpGlobalSetRootCost));
        prepareRead(getProperty(stpGlobalSetRootPort));
        prepareRead(getProperty(stpGlobalSetMaxAge));
        prepareRead(getProperty(stpGlobalSetHelloTime));
        prepareRead(getProperty(stpGlobalSetHoldTime));
        prepareRead(getProperty(stpGlobalSetForwardDelay));
        prepareRead(getProperty(stpGlobalSetBridgeMaxAge));
        prepareRead(getProperty(stpGlobalSetBridgeHelloTime));
        prepareRead(getProperty(stpGlobalSetBridgeForwardDelay));
        prepareRead(getProperty(stpGlobalSetRstpTxHoldCount));
        prepareRead(getProperty(stpGlobalSetEnable));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(stpGlobalSetVersion));
        prepareRead(getProperty(stpGlobalSetPriority));
        prepareRead(getProperty(stpGlobalSetTimeSinceTopologyChange));
        prepareRead(getProperty(stpGlobalSetTopChanges));
        prepareRead(getProperty(stpGlobalSetDesignatedRoot));
        prepareRead(getProperty(stpGlobalSetRootCost));
        prepareRead(getProperty(stpGlobalSetRootPort));
        prepareRead(getProperty(stpGlobalSetMaxAge));
        prepareRead(getProperty(stpGlobalSetHelloTime));
        prepareRead(getProperty(stpGlobalSetHoldTime));
        prepareRead(getProperty(stpGlobalSetForwardDelay));
        prepareRead(getProperty(stpGlobalSetBridgeMaxAge));
        prepareRead(getProperty(stpGlobalSetBridgeHelloTime));
        prepareRead(getProperty(stpGlobalSetBridgeForwardDelay));
        prepareRead(getProperty(stpGlobalSetRstpTxHoldCount));
        prepareRead(getProperty(stpGlobalSetEnable));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(stpGlobalSetVersion));
        prepareSave(getProperty(stpGlobalSetPriority));
        prepareSave(getProperty(stpGlobalSetBridgeMaxAge));
        prepareSave(getProperty(stpGlobalSetBridgeHelloTime));
        prepareSave(getProperty(stpGlobalSetBridgeForwardDelay));
        prepareSave(getProperty(stpGlobalSetRstpTxHoldCount));
        prepareSave(getProperty(stpGlobalSetEnable));

        return save();
    }

}