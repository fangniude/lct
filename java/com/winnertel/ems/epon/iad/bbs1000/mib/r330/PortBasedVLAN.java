/**
 * Created by Zhou Chao, 2008/11/27
 */

package com.winnertel.ems.epon.iad.bbs1000.mib.r330;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PortBasedVLAN extends SnmpMibBean {

    public static final String utsLagExtDot1qVlanIndex = "utsLagExtDot1qVlanIndex";
    public static final String utsLagExtDot1qVlanName = "utsLagExtDot1qVlanName";
    public static final String utsLagExtDot1qVlanPortListPorts = "utsLagExtDot1qVlanPortListPorts";
    public static final String utsLagExtDot1qVlanTaggedPortListPorts = "utsLagExtDot1qVlanTaggedPortListPorts";
    public static final String utsLagExtDot1qVlanPortVidListPorts = "utsLagExtDot1qVlanPortVidListPorts";
    public static final String utsLagExtDot1qVlanUnTaggedPortListPorts = "utsLagExtDot1qVlanUnTaggedPortListPorts";
    public static final String utsLagExtDot1qVlanIgmpSnoop = "utsLagExtDot1qVlanIgmpSnoop";
//    public static final String utsEponDot1qVlanStpBridgeEnable = "utsEponDot1qVlanStpBridgeEnable";
    public static final String utsLagExtDot1qVlanPPPoEPlus = "utsLagExtDot1qVlanPPPoEPlus";
    public static final String utsLagExtDot1qVlanL2DHCPOption82 = "utsLagExtDot1qVlanL2DHCPOption82";
    public static final String utsLagExtDot1qVlanArpProxySwitch = "utsLagExtDot1qVlanArpProxySwitch";

    public PortBasedVLAN(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsLagExtDot1qVlanIndex, new SnmpMibBeanProperty(utsLagExtDot1qVlanIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.1", ISnmpConstant.INTEGER));
        initProperty(utsLagExtDot1qVlanName, new SnmpMibBeanProperty(utsLagExtDot1qVlanName, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.2", ISnmpConstant.STRING));
        initProperty(utsLagExtDot1qVlanPortListPorts, new SnmpMibBeanProperty(utsLagExtDot1qVlanPortListPorts, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.3", ISnmpConstant.OCTETS));
        initProperty(utsLagExtDot1qVlanTaggedPortListPorts, new SnmpMibBeanProperty(utsLagExtDot1qVlanTaggedPortListPorts, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.4", ISnmpConstant.OCTETS));
        initProperty(utsLagExtDot1qVlanPortVidListPorts, new SnmpMibBeanProperty(utsLagExtDot1qVlanPortVidListPorts, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.5", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.6", ISnmpConstant.INTEGER));
        initProperty(utsLagExtDot1qVlanUnTaggedPortListPorts, new SnmpMibBeanProperty(utsLagExtDot1qVlanUnTaggedPortListPorts, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.7", ISnmpConstant.OCTETS));
        initProperty(utsLagExtDot1qVlanIgmpSnoop, new SnmpMibBeanProperty(utsLagExtDot1qVlanIgmpSnoop, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.8", ISnmpConstant.INTEGER));
//        initProperty(utsEponDot1qVlanStpBridgeEnable, new SnmpMibBeanProperty(utsEponDot1qVlanStpBridgeEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.9", ISnmpConstant.INTEGER));
        initProperty(utsLagExtDot1qVlanPPPoEPlus, new SnmpMibBeanProperty(utsLagExtDot1qVlanPPPoEPlus, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.10", ISnmpConstant.INTEGER));
        initProperty(utsLagExtDot1qVlanL2DHCPOption82, new SnmpMibBeanProperty(utsLagExtDot1qVlanL2DHCPOption82, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.11", ISnmpConstant.INTEGER));
        initProperty(utsLagExtDot1qVlanArpProxySwitch, new SnmpMibBeanProperty(utsLagExtDot1qVlanArpProxySwitch, ".1.3.6.1.4.1.45121.1800.2.2.1.4.1.12", ISnmpConstant.INTEGER));
    }

    public Integer getUtsLagExtDot1qVlanIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsLagExtDot1qVlanIndex(Integer aUtsLagExtDot1qVlanIndex) {
        setIndex(0, aUtsLagExtDot1qVlanIndex);
    }

    public String getUtsLagExtDot1qVlanName() {
        return (String) getProperty(utsLagExtDot1qVlanName).getValue();
    }

    public void setUtsLagExtDot1qVlanName(String aUtsLagExtDot1qVlanName) {
        getProperty(utsLagExtDot1qVlanName).setValue(aUtsLagExtDot1qVlanName);
    }

    public byte[] getUtsLagExtDot1qVlanPortListPorts() {
        return (byte[]) getProperty(utsLagExtDot1qVlanPortListPorts).getValue();
    }

    public void setUtsLagExtDot1qVlanPortListPorts(byte[] aUtsLagExtDot1qVlanPortListPorts) {
        getProperty(utsLagExtDot1qVlanPortListPorts).setValue(aUtsLagExtDot1qVlanPortListPorts);
    }

    public byte[] getUtsLagExtDot1qVlanTaggedPortListPorts() {
        return (byte[]) getProperty(utsLagExtDot1qVlanTaggedPortListPorts).getValue();
    }

    public void setUtsLagExtDot1qVlanTaggedPortListPorts(byte[] aUtsLagExtDot1qVlanTaggedPortListPorts) {
        getProperty(utsLagExtDot1qVlanTaggedPortListPorts).setValue(aUtsLagExtDot1qVlanTaggedPortListPorts);
    }

    public byte[] getUtsLagExtDot1qVlanPortVidListPorts() {
        return (byte[]) getProperty(utsLagExtDot1qVlanPortVidListPorts).getValue();
    }

    public void setUtsLagExtDot1qVlanPortVidListPorts(byte[] aUtsLagExtDot1qVlanPortVidListPorts) {
        getProperty(utsLagExtDot1qVlanPortVidListPorts).setValue(aUtsLagExtDot1qVlanPortVidListPorts);
    }

    public byte[] getUtsLagExtDot1qVlanUnTaggedPortListPorts() {
        return (byte[]) getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts).getValue();
    }

    public void setUtsLagExtDot1qVlanUnTaggedPortListPorts(byte[] aUtsLagExtDot1qVlanUnTaggedPortListPorts) {
        getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts).setValue(aUtsLagExtDot1qVlanUnTaggedPortListPorts);
    }

    public Integer getUtsLagExtDot1qVlanIgmpSnoop() {
        return (Integer) getProperty(utsLagExtDot1qVlanIgmpSnoop).getValue();
    }

    public void setUtsLagExtDot1qVlanIgmpSnoop(Integer aUtsLagExtDot1qVlanIgmpSnoop) {
        getProperty(utsLagExtDot1qVlanIgmpSnoop).setValue(aUtsLagExtDot1qVlanIgmpSnoop);
    }

//    public Integer getUtsEponDot1qVlanStpBridgeEnable() {
//        return (Integer) getProperty(utsEponDot1qVlanStpBridgeEnable).getValue();
//    }
//
//    public void setUtsEponDot1qVlanStpBridgeEnable(Integer aUtsEponDot1qVlanStpBridgeEnable) {
//        getProperty(utsEponDot1qVlanStpBridgeEnable).setValue(aUtsEponDot1qVlanStpBridgeEnable);
//    }

    public Integer getUtsLagExtDot1qVlanPPPoEPlus() {
        return (Integer) getProperty(utsLagExtDot1qVlanPPPoEPlus).getValue();
    }

    public void setUtsLagExtDot1qVlanPPPoEPlus(Integer aUtsLagExtDot1qVlanPPPoEPlus) {
        getProperty(utsLagExtDot1qVlanPPPoEPlus).setValue(aUtsLagExtDot1qVlanPPPoEPlus);
    }

    public Integer getUtsLagExtDot1qVlanL2DHCPOption82() {
        return (Integer) getProperty(utsLagExtDot1qVlanL2DHCPOption82).getValue();
    }

    public void setUtsLagExtDot1qVlanL2DHCPOption82(Integer aUtsLagExtDot1qVlanL2DHCPOption82) {
        getProperty(utsLagExtDot1qVlanL2DHCPOption82).setValue(aUtsLagExtDot1qVlanL2DHCPOption82);
    }

    public Integer getUtsLagExtDot1qVlanArpProxySwitch() {
        return (Integer) getProperty(utsLagExtDot1qVlanArpProxySwitch).getValue();
    }

    public void setUtsLagExtDot1qVlanArpProxySwitch(Integer aUtsLagExtDot1qVlanArpProxySwitch) {
        getProperty(utsLagExtDot1qVlanArpProxySwitch).setValue(aUtsLagExtDot1qVlanArpProxySwitch);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsLagExtDot1qVlanName));
        prepareRead(getProperty(utsLagExtDot1qVlanPortListPorts));
        prepareRead(getProperty(utsLagExtDot1qVlanTaggedPortListPorts));
        prepareRead(getProperty(utsLagExtDot1qVlanPortVidListPorts));
        prepareRead(getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts));
        prepareRead(getProperty(utsLagExtDot1qVlanIgmpSnoop));
//        prepareRead(getProperty(utsEponDot1qVlanStpBridgeEnable));
        prepareRead(getProperty(utsLagExtDot1qVlanPPPoEPlus));
        prepareRead(getProperty(utsLagExtDot1qVlanL2DHCPOption82));
        prepareRead(getProperty(utsLagExtDot1qVlanArpProxySwitch));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        int old = fSnmpProxy.getTimeout();

        fSnmpProxy.setTimeout(30);

        Vector v = null;
        try {
            prepareRead(getProperty(utsLagExtDot1qVlanName));
            prepareRead(getProperty(utsLagExtDot1qVlanPortListPorts));
            prepareRead(getProperty(utsLagExtDot1qVlanTaggedPortListPorts));
            prepareRead(getProperty(utsLagExtDot1qVlanPortVidListPorts));
            prepareRead(getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts));
            prepareRead(getProperty(utsLagExtDot1qVlanIgmpSnoop));
//            prepareRead(getProperty(utsEponDot1qVlanStpBridgeEnable));
            prepareRead(getProperty(utsLagExtDot1qVlanPPPoEPlus));
            prepareRead(getProperty(utsLagExtDot1qVlanL2DHCPOption82));
            prepareRead(getProperty(utsLagExtDot1qVlanArpProxySwitch));

            v = loadAll(new int[]{1});
        } catch (Exception e) {
        } finally {
            fSnmpProxy.setTimeout(old);
        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsLagExtDot1qVlanName));
        int vLANIdx = getUtsLagExtDot1qVlanIndex();
        if (vLANIdx != 1) {
            prepareSave(getProperty(utsLagExtDot1qVlanTaggedPortListPorts));
            prepareSave(getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts));
            prepareSave(getProperty(utsLagExtDot1qVlanPortVidListPorts));
        }
        prepareSave(getProperty(utsLagExtDot1qVlanIgmpSnoop));
//        prepareSave(getProperty(utsEponDot1qVlanStpBridgeEnable));
        prepareSave(getProperty(utsLagExtDot1qVlanPPPoEPlus));
        prepareSave(getProperty(utsLagExtDot1qVlanL2DHCPOption82));
        prepareSave(getProperty(utsLagExtDot1qVlanArpProxySwitch));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsLagExtDot1qVlanIndex));
        prepareSave(getProperty(utsLagExtDot1qVlanName));
        prepareSave(getProperty(utsLagExtDot1qVlanTaggedPortListPorts));
        prepareSave(getProperty(utsLagExtDot1qVlanPortVidListPorts));
        prepareSave(getProperty(utsLagExtDot1qVlanUnTaggedPortListPorts));
        prepareSave(getProperty(utsLagExtDot1qVlanIgmpSnoop));
//        prepareSave(getProperty(utsEponDot1qVlanStpBridgeEnable));
        prepareSave(getProperty(utsLagExtDot1qVlanPPPoEPlus));
        prepareSave(getProperty(utsLagExtDot1qVlanL2DHCPOption82));
        prepareSave(getProperty(utsLagExtDot1qVlanArpProxySwitch));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public String toString() {
        return "vlan" + getUtsLagExtDot1qVlanIndex();
    }

}