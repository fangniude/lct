/**
 * Created by Zhou Chao, 2009/11/4
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class SwitchBufferAdjustmentMBean extends SnmpMibBean {

    public static final String utsSwitchBufferAdjustmentUplinkPorts = "utsSwitchBufferAdjustmentUplinkPorts";
    public static final String utsSwitchBufferAdjustmentDownlinkPorts = "utsSwitchBufferAdjustmentDownlinkPorts";
    public static final String utsSwitchBufferAdjustmentUsedCoS = "utsSwitchBufferAdjustmentUsedCoS";
    public static final String utsSwitchBufferAdjustmentUsedCoSWeight = "utsSwitchBufferAdjustmentUsedCoSWeight";

    public SwitchBufferAdjustmentMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSwitchBufferAdjustmentUplinkPorts, new SnmpMibBeanProperty(utsSwitchBufferAdjustmentUplinkPorts, ".1.3.6.1.4.1.45121.1800.2.1.1.4.9.1", ISnmpConstant.OCTETS));
        initProperty(utsSwitchBufferAdjustmentDownlinkPorts, new SnmpMibBeanProperty(utsSwitchBufferAdjustmentDownlinkPorts, ".1.3.6.1.4.1.45121.1800.2.1.1.4.9.2", ISnmpConstant.OCTETS));
        initProperty(utsSwitchBufferAdjustmentUsedCoS, new SnmpMibBeanProperty(utsSwitchBufferAdjustmentUsedCoS, ".1.3.6.1.4.1.45121.1800.2.1.1.4.9.3", ISnmpConstant.INTEGER));
        //initProperty(utsSwitchBufferAdjustmentUsedCoS, new SnmpMibBeanProperty(utsSwitchBufferAdjustmentUsedCoS, ".1.3.6.1.4.1.45121.1800.2.1.1.4.9.3", ISnmpConstant.OCTETS));
        initProperty(utsSwitchBufferAdjustmentUsedCoSWeight, new SnmpMibBeanProperty(utsSwitchBufferAdjustmentUsedCoSWeight, ".1.3.6.1.4.1.45121.1800.2.1.1.4.9.4", ISnmpConstant.OCTETS));
    }

    public byte[] getUtsSwitchBufferAdjustmentUplinkPorts() {
        return (byte[]) getProperty(utsSwitchBufferAdjustmentUplinkPorts).getValue();
    }

    public void setUtsSwitchBufferAdjustmentUplinkPorts(byte[] aUtsSwitchBufferAdjustmentUplinkPorts) {
        getProperty(utsSwitchBufferAdjustmentUplinkPorts).setValue(aUtsSwitchBufferAdjustmentUplinkPorts);
    }

    public byte[] getUtsSwitchBufferAdjustmentDownlinkPorts() {
        return (byte[]) getProperty(utsSwitchBufferAdjustmentDownlinkPorts).getValue();
    }

    public void setUtsSwitchBufferAdjustmentDownlinkPorts(byte[] aUtsSwitchBufferAdjustmentDownlinkPorts) {
        getProperty(utsSwitchBufferAdjustmentDownlinkPorts).setValue(aUtsSwitchBufferAdjustmentDownlinkPorts);
    }

    public Integer getUtsSwitchBufferAdjustmentUsedCoS() {
        return (Integer) getProperty(utsSwitchBufferAdjustmentUsedCoS).getValue();
    }

    public void setUtsSwitchBufferAdjustmentUsedCoS(Integer aUtsSwitchBufferAdjustmentUsedCoS) {
        getProperty(utsSwitchBufferAdjustmentUsedCoS).setValue(aUtsSwitchBufferAdjustmentUsedCoS);
    }

    /*
    public byte[] getUtsSwitchBufferAdjustmentUsedCoS() {
        return (byte[]) getProperty(utsSwitchBufferAdjustmentUsedCoS).getValue();
    }

    public void setUtsSwitchBufferAdjustmentUsedCoS(byte[] aUtsSwitchBufferAdjustmentUsedCoS) {
        getProperty(utsSwitchBufferAdjustmentUsedCoS).setValue(aUtsSwitchBufferAdjustmentUsedCoS);
    }
    */

    public byte[] getUtsSwitchBufferAdjustmentUsedCoSWeight() {
        return (byte[]) getProperty(utsSwitchBufferAdjustmentUsedCoSWeight).getValue();
    }

    public void setUtsSwitchBufferAdjustmentUsedCoSWeight(byte[] aUtsSwitchBufferAdjustmentUsedCoSWeight) {
        getProperty(utsSwitchBufferAdjustmentUsedCoSWeight).setValue(aUtsSwitchBufferAdjustmentUsedCoSWeight);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsSwitchBufferAdjustmentUplinkPorts));
        prepareRead(getProperty(utsSwitchBufferAdjustmentDownlinkPorts));
        prepareRead(getProperty(utsSwitchBufferAdjustmentUsedCoS));
        prepareRead(getProperty(utsSwitchBufferAdjustmentUsedCoSWeight));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSwitchBufferAdjustmentUplinkPorts));
        prepareSave(getProperty(utsSwitchBufferAdjustmentDownlinkPorts));
        prepareSave(getProperty(utsSwitchBufferAdjustmentUsedCoS));
        prepareSave(getProperty(utsSwitchBufferAdjustmentUsedCoSWeight));

        return save();
    }

}