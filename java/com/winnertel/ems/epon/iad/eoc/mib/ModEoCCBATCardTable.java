package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCBATCardTable class.
 * Created by QuickDVM
 */
public class ModEoCCBATCardTable extends EocBaseSnmpMibBean {
    public static final String modEoCCBATCardIndex = "modEoCCBATCardIndex";
    public static final String modEoCCBATCardMACAddress = "modEoCCBATCardMACAddress";
    public static final String modEoCCBATCardOnlineStatus = "modEoCCBATCardOnlineStatus";
    public static final String modEoCCBATCardModelNumber = "modEoCCBATCardModelNumber";
    public static final String modEoCCBATCardSoftwareVersion = "modEoCCBATCardSoftwareVersion";
    public static final String modEoCCBATCardReset = "modEoCCBATCardReset";
    public static final String modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck = "modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck";
    public static final String modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck = "modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck";
    //    public static final String modEoCCBATCardUpLinkDeviceMACAddress = "modEoCCBATCardUpLinkDeviceMACAddress";
//    public static final String modEoCCBATCardUpLinkDevicePortNumber = "modEoCCBATCardUpLinkDevicePortNumber";
    public static final String modEoCCBATCardConfigurationSaving = "modEoCCBATCardConfigurationSaving";
    public static final String modEoCCBATCardConfigurationResult = "modEoCCBATCardConfigurationResult";

    public ModEoCCBATCardTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCBATCardIndex, new SnmpMibBeanProperty(modEoCCBATCardIndex, MIB_Head1 + ".3.2.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardMACAddress, new SnmpMibBeanProperty(modEoCCBATCardMACAddress, MIB_Head1 + ".3.2.1.2", ISnmpConstant.OCTETS));
        initProperty(modEoCCBATCardOnlineStatus, new SnmpMibBeanProperty(modEoCCBATCardOnlineStatus, MIB_Head1 + ".3.2.1.3", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardModelNumber, new SnmpMibBeanProperty(modEoCCBATCardModelNumber, MIB_Head1 + ".3.2.1.4", ISnmpConstant.STRING));
        initProperty(modEoCCBATCardSoftwareVersion, new SnmpMibBeanProperty(modEoCCBATCardSoftwareVersion, MIB_Head1 + ".3.2.1.5", ISnmpConstant.STRING));
        initProperty(modEoCCBATCardReset, new SnmpMibBeanProperty(modEoCCBATCardReset, MIB_Head1 + ".3.2.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck, new SnmpMibBeanProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck, MIB_Head1 + ".3.2.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck, new SnmpMibBeanProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck, MIB_Head1 + ".3.2.1.8", ISnmpConstant.INTEGER));
//        initProperty(modEoCCBATCardUpLinkDeviceMACAddress, new SnmpMibBeanProperty(modEoCCBATCardUpLinkDeviceMACAddress, MIB_Head1 + ".3.2.1.9", ISnmpConstant.OCTETS));
//        initProperty(modEoCCBATCardUpLinkDevicePortNumber, new SnmpMibBeanProperty(modEoCCBATCardUpLinkDevicePortNumber, MIB_Head1 + ".3.2.1.10", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardConfigurationSaving, new SnmpMibBeanProperty(modEoCCBATCardConfigurationSaving, MIB_Head1 + ".3.2.1.11", ISnmpConstant.INTEGER));
        initProperty(modEoCCBATCardConfigurationResult, new SnmpMibBeanProperty(modEoCCBATCardConfigurationResult, MIB_Head1 + ".3.2.1.12", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCBATCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCBATCardIndex(Integer aModEoCCBATCardIndex) {
        setIndex(0, aModEoCCBATCardIndex);
    }


    public byte[] getModEoCCBATCardMACAddress() {
        return (byte[]) getProperty(modEoCCBATCardMACAddress).getValue();
    }

    public void setModEoCCBATCardMACAddress(byte[] aModEoCCBATCardMACAddress) {
        getProperty(modEoCCBATCardMACAddress).setValue(aModEoCCBATCardMACAddress);
    }

    public Integer getModEoCCBATCardOnlineStatus() {
        return (Integer) getProperty(modEoCCBATCardOnlineStatus).getValue();
    }

    public void setModEoCCBATCardOnlineStatus(Integer aModEoCCBATCardOnlineStatus) {
        getProperty(modEoCCBATCardOnlineStatus).setValue(aModEoCCBATCardOnlineStatus);
    }

    public String getModEoCCBATCardModelNumber() {
        return (String) getProperty(modEoCCBATCardModelNumber).getValue();
    }

    public void setModEoCCBATCardModelNumber(String aModEoCCBATCardModelNumber) {
        getProperty(modEoCCBATCardModelNumber).setValue(aModEoCCBATCardModelNumber);
    }

    public String getModEoCCBATCardSoftwareVersion() {
        return (String) getProperty(modEoCCBATCardSoftwareVersion).getValue();
    }

    public void setModEoCCBATCardSoftwareVersion(String aModEoCCBATCardSoftwareVersion) {
        getProperty(modEoCCBATCardSoftwareVersion).setValue(aModEoCCBATCardSoftwareVersion);
    }

    public Integer getModEoCCBATCardReset() {
        return (Integer) getProperty(modEoCCBATCardReset).getValue();
    }

    public void setModEoCCBATCardReset(Integer aModEoCCBATCardReset) {
        getProperty(modEoCCBATCardReset).setValue(aModEoCCBATCardReset);
    }

    public Integer getModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck() {
        return (Integer) getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck).getValue();
    }

    public void setModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck(Integer aModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck) {
        getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck).setValue(aModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck);
    }

    public Integer getModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck() {
        return (Integer) getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck).getValue();
    }

    public void setModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck(Integer aModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck) {
        getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck).setValue(aModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck);
    }

//    public byte[] getModEoCCBATCardUpLinkDeviceMACAddress() {
//        return (byte[]) getProperty(modEoCCBATCardUpLinkDeviceMACAddress).getValue();
//    }
//
//    public void setModEoCCBATCardUpLinkDeviceMACAddress(byte[] aModEoCCBATCardUpLinkDeviceMACAddress) {
//        getProperty(modEoCCBATCardUpLinkDeviceMACAddress).setValue(aModEoCCBATCardUpLinkDeviceMACAddress);
//    }
//
//    public Integer getModEoCCBATCardUpLinkDevicePortNumber() {
//        return (Integer) getProperty(modEoCCBATCardUpLinkDevicePortNumber).getValue();
//    }
//
//    public void setModEoCCBATCardUpLinkDevicePortNumber(Integer aModEoCCBATCardUpLinkDevicePortNumber) {
//        getProperty(modEoCCBATCardUpLinkDevicePortNumber).setValue(aModEoCCBATCardUpLinkDevicePortNumber);
//    }

    public Integer getModEoCCBATCardConfigurationSaving() {
        return (Integer) getProperty(modEoCCBATCardConfigurationSaving).getValue();
    }

    public void setModEoCCBATCardConfigurationSaving(Integer aModEoCCBATCardConfigurationSaving) {
        getProperty(modEoCCBATCardConfigurationSaving).setValue(aModEoCCBATCardConfigurationSaving);
    }

    public Integer getModEoCCBATCardConfigurationResult() {
        return (Integer) getProperty(modEoCCBATCardConfigurationResult).getValue();
    }

    public void setModEoCCBATCardConfigurationResult(Integer aModEoCCBATCardConfigurationResult) {
        getProperty(modEoCCBATCardConfigurationResult).setValue(aModEoCCBATCardConfigurationResult);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardMACAddress));
        prepareRead(super.getProperty(modEoCCBATCardOnlineStatus));
        prepareRead(super.getProperty(modEoCCBATCardModelNumber));
        prepareRead(super.getProperty(modEoCCBATCardSoftwareVersion));
        prepareRead(super.getProperty(modEoCCBATCardReset));
        prepareRead(super.getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck));
        prepareRead(super.getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck));
//        prepareRead(super.getProperty(modEoCCBATCardUpLinkDeviceMACAddress));
//        prepareRead(super.getProperty(modEoCCBATCardUpLinkDevicePortNumber));
        prepareRead(super.getProperty(modEoCCBATCardConfigurationSaving));
        prepareRead(super.getProperty(modEoCCBATCardConfigurationResult));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATCardMACAddress));
        prepareRead(super.getProperty(modEoCCBATCardOnlineStatus));
        prepareRead(super.getProperty(modEoCCBATCardModelNumber));
        prepareRead(super.getProperty(modEoCCBATCardSoftwareVersion));
        prepareRead(super.getProperty(modEoCCBATCardReset));
        prepareRead(super.getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck));
        prepareRead(super.getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck));
//        prepareRead(super.getProperty(modEoCCBATCardUpLinkDeviceMACAddress));
//        prepareRead(super.getProperty(modEoCCBATCardUpLinkDevicePortNumber));
        prepareRead(super.getProperty(modEoCCBATCardConfigurationSaving));
        prepareRead(super.getProperty(modEoCCBATCardConfigurationResult));

        return loadAll(new int[]{1
        });
    }


    public boolean resetCard() throws MibBeanException {
        setModEoCCBATCardReset(1);
        prepareSave(getProperty(modEoCCBATCardReset));

        return save();
    }

    public boolean saveConfig() throws MibBeanException {
        setModEoCCBATCardConfigurationSaving(1);
        prepareSave(getProperty(modEoCCBATCardConfigurationSaving));

        return save();
    }

    public boolean modify() throws MibBeanException {
        //prepareSave(getProperty(modEoCCBATCardReset));
        prepareSave(getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck));
        prepareSave(getProperty(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck));
//        prepareSave(getProperty(modEoCCBATCardUpLinkDeviceMACAddress));
//        prepareSave(getProperty(modEoCCBATCardUpLinkDevicePortNumber));
        //prepareSave(getProperty(modEoCCBATCardConfigurationSaving));

        return save();
    }


}