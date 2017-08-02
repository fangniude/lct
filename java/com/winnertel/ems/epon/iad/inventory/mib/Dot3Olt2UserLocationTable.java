/**
 * Created by Zhou Chao, 2009/7/23
 */

package com.winnertel.ems.epon.iad.inventory.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Olt2UserLocationTable extends SnmpMibBean {

    public static final String utsDot3Olt2UserLocationMacAddress = "utsDot3Olt2UserLocationMacAddress";
    public static final String utsDot3Olt2UserLocationModuleId = "utsDot3Olt2UserLocationModuleId";
    public static final String utsDot3Olt2UserLocationPortId = "utsDot3Olt2UserLocationPortId";
    public static final String utsDot3Olt2UserLocationLogicalPortId = "utsDot3Olt2UserLocationLogicalPortId";

    private String onuLabel;

    public Dot3Olt2UserLocationTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Olt2UserLocationMacAddress, new SnmpMibBeanProperty(utsDot3Olt2UserLocationMacAddress, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.16.1.1", ISnmpConstant.MAC_ADDRESS));
        initProperty(utsDot3Olt2UserLocationModuleId, new SnmpMibBeanProperty(utsDot3Olt2UserLocationModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.16.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Olt2UserLocationPortId, new SnmpMibBeanProperty(utsDot3Olt2UserLocationPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.16.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Olt2UserLocationLogicalPortId, new SnmpMibBeanProperty(utsDot3Olt2UserLocationLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.16.1.4", ISnmpConstant.INTEGER));
    }

    public byte[] getUtsDot3Olt2UserLocationMacAddress() {
        return (byte[]) getIndex(0);
    }

    public void setUtsDot3Olt2UserLocationMacAddress(byte[] aUtsDot3Olt2UserLocationMacAddress) {
        setIndex(0, aUtsDot3Olt2UserLocationMacAddress);
    }

    public Integer getUtsDot3Olt2UserLocationModuleId() {
        return (Integer) getProperty(utsDot3Olt2UserLocationModuleId).getValue();
    }

    public void setUtsDot3Olt2UserLocationModuleId(Integer aUtsDot3Olt2UserLocationModuleId) {
        getProperty(utsDot3Olt2UserLocationModuleId).setValue(aUtsDot3Olt2UserLocationModuleId);
    }

    public Integer getUtsDot3Olt2UserLocationPortId() {
        return (Integer) getProperty(utsDot3Olt2UserLocationPortId).getValue();
    }

    public void setUtsDot3Olt2UserLocationPortId(Integer aUtsDot3Olt2UserLocationPortId) {
        getProperty(utsDot3Olt2UserLocationPortId).setValue(aUtsDot3Olt2UserLocationPortId);
    }

    public Integer getUtsDot3Olt2UserLocationLogicalPortId() {
        return (Integer) getProperty(utsDot3Olt2UserLocationLogicalPortId).getValue();
    }

    public void setUtsDot3Olt2UserLocationLogicalPortId(Integer aUtsDot3Olt2UserLocationLogicalPortId) {
        getProperty(utsDot3Olt2UserLocationLogicalPortId).setValue(aUtsDot3Olt2UserLocationLogicalPortId);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Olt2UserLocationMacAddress));
        prepareRead(getProperty(utsDot3Olt2UserLocationModuleId));
        prepareRead(getProperty(utsDot3Olt2UserLocationPortId));
        prepareRead(getProperty(utsDot3Olt2UserLocationLogicalPortId));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Olt2UserLocationMacAddress));
        prepareRead(getProperty(utsDot3Olt2UserLocationModuleId));
        prepareRead(getProperty(utsDot3Olt2UserLocationPortId));
        prepareRead(getProperty(utsDot3Olt2UserLocationLogicalPortId));

        return loadAll(new int[]{6});
    }

}