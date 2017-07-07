package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuMacFilterPreassignProTable class.
 * Created by QuickDVM
 */
public class OnuMacFilterPreassignProTable extends SnmpMibBean {

    public static final String onuMacFilterPreassignProfileIndex = "onuMacFilterPreassignProfileIndex";
    public static final String onuMacFilterPreassignProfileName = "onuMacFilterPreassignProfileName";
    public static final String onuMacFilterPreassignProfIPv4Multicast = "onuMacFilterPreassignProfIPv4Multicast";
    public static final String onuMacFilterPreassignProfIPv6Multicast = "onuMacFilterPreassignProfIPv6Multicast";
    public static final String onuMacFilterPreassignProfIPv4Broadcast = "onuMacFilterPreassignProfIPv4Broadcast";
    public static final String onuMacFilterPreassignProfRARP = "onuMacFilterPreassignProfRARP";
    public static final String onuMacFilterPreassignProfIPX = "onuMacFilterPreassignProfIPX";
    public static final String onuMacFilterPreassignProfNetBEUI = "onuMacFilterPreassignProfNetBEUI";
    public static final String onuMacFilterPreassignProfAppleTalk = "onuMacFilterPreassignProfAppleTalk";
    public static final String onuMacFilterPreassignProfBridgeManagemenInformation = "onuMacFilterPreassignProfBridgeManagemenInformation";
    public static final String onuMacFilterPreassignProfARP = "onuMacFilterPreassignProfARP";
    public static final String onuMacFilterPreassignProfPPPoEBroadcast = "onuMacFilterPreassignProfPPPoEBroadcast";

    public OnuMacFilterPreassignProTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuMacFilterPreassignProfileIndex, new SnmpMibBeanProperty(onuMacFilterPreassignProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.1", ISnmpConstant.GAUGE));
        initProperty(onuMacFilterPreassignProfileName, new SnmpMibBeanProperty(onuMacFilterPreassignProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.2", ISnmpConstant.STRING));
        initProperty(onuMacFilterPreassignProfIPv4Multicast, new SnmpMibBeanProperty(onuMacFilterPreassignProfIPv4Multicast, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.3", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfIPv6Multicast, new SnmpMibBeanProperty(onuMacFilterPreassignProfIPv6Multicast, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.4", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfIPv4Broadcast, new SnmpMibBeanProperty(onuMacFilterPreassignProfIPv4Broadcast, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.5", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfRARP, new SnmpMibBeanProperty(onuMacFilterPreassignProfRARP, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.6", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfIPX, new SnmpMibBeanProperty(onuMacFilterPreassignProfIPX, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.7", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfNetBEUI, new SnmpMibBeanProperty(onuMacFilterPreassignProfNetBEUI, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.8", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfAppleTalk, new SnmpMibBeanProperty(onuMacFilterPreassignProfAppleTalk, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.9", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfBridgeManagemenInformation, new SnmpMibBeanProperty(onuMacFilterPreassignProfBridgeManagemenInformation, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.10", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfARP, new SnmpMibBeanProperty(onuMacFilterPreassignProfARP, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.11", ISnmpConstant.INTEGER));
        initProperty(onuMacFilterPreassignProfPPPoEBroadcast, new SnmpMibBeanProperty(onuMacFilterPreassignProfPPPoEBroadcast, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.12", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.26.1.13", ISnmpConstant.INTEGER));
    }

    public Long getOnuMacFilterPreassignProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setOnuMacFilterPreassignProfileIndex(Long aOnuMacFilterPreassignProfileIndex) {
        setIndex(0, aOnuMacFilterPreassignProfileIndex);
    }

    public String getOnuMacFilterPreassignProfileName() {
        return (String) getProperty(onuMacFilterPreassignProfileName).getValue();
    }

    public void setOnuMacFilterPreassignProfileName(String aOnuMacFilterPreassignProfileName) {
        getProperty(onuMacFilterPreassignProfileName).setValue(aOnuMacFilterPreassignProfileName);
    }

    public Integer getOnuMacFilterPreassignProfIPv4Multicast() {
        return (Integer) getProperty(onuMacFilterPreassignProfIPv4Multicast).getValue();
    }

    public void setOnuMacFilterPreassignProfIPv4Multicast(Integer aOnuMacFilterPreassignProfIPv4Multicast) {
        getProperty(onuMacFilterPreassignProfIPv4Multicast).setValue(aOnuMacFilterPreassignProfIPv4Multicast);
    }

    public Integer getOnuMacFilterPreassignProfIPv6Multicast() {
        return (Integer) getProperty(onuMacFilterPreassignProfIPv6Multicast).getValue();
    }

    public void setOnuMacFilterPreassignProfIPv6Multicast(Integer aOnuMacFilterPreassignProfIPv6Multicast) {
        getProperty(onuMacFilterPreassignProfIPv6Multicast).setValue(aOnuMacFilterPreassignProfIPv6Multicast);
    }

    public Integer getOnuMacFilterPreassignProfIPv4Broadcast() {
        return (Integer) getProperty(onuMacFilterPreassignProfIPv4Broadcast).getValue();
    }

    public void setOnuMacFilterPreassignProfIPv4Broadcast(Integer aOnuMacFilterPreassignProfIPv4Broadcast) {
        getProperty(onuMacFilterPreassignProfIPv4Broadcast).setValue(aOnuMacFilterPreassignProfIPv4Broadcast);
    }

    public Integer getOnuMacFilterPreassignProfRARP() {
        return (Integer) getProperty(onuMacFilterPreassignProfRARP).getValue();
    }

    public void setOnuMacFilterPreassignProfRARP(Integer aOnuMacFilterPreassignProfRARP) {
        getProperty(onuMacFilterPreassignProfRARP).setValue(aOnuMacFilterPreassignProfRARP);
    }

    public Integer getOnuMacFilterPreassignProfIPX() {
        return (Integer) getProperty(onuMacFilterPreassignProfIPX).getValue();
    }

    public void setOnuMacFilterPreassignProfIPX(Integer aOnuMacFilterPreassignProfIPX) {
        getProperty(onuMacFilterPreassignProfIPX).setValue(aOnuMacFilterPreassignProfIPX);
    }

    public Integer getOnuMacFilterPreassignProfNetBEUI() {
        return (Integer) getProperty(onuMacFilterPreassignProfNetBEUI).getValue();
    }

    public void setOnuMacFilterPreassignProfNetBEUI(Integer aOnuMacFilterPreassignProfNetBEUI) {
        getProperty(onuMacFilterPreassignProfNetBEUI).setValue(aOnuMacFilterPreassignProfNetBEUI);
    }

    public Integer getOnuMacFilterPreassignProfAppleTalk() {
        return (Integer) getProperty(onuMacFilterPreassignProfAppleTalk).getValue();
    }

    public void setOnuMacFilterPreassignProfAppleTalk(Integer aOnuMacFilterPreassignProfAppleTalk) {
        getProperty(onuMacFilterPreassignProfAppleTalk).setValue(aOnuMacFilterPreassignProfAppleTalk);
    }

    public Integer getOnuMacFilterPreassignProfBridgeManagemenInformation() {
        return (Integer) getProperty(onuMacFilterPreassignProfBridgeManagemenInformation).getValue();
    }

    public void setOnuMacFilterPreassignProfBridgeManagemenInformation(Integer aOnuMacFilterPreassignProfBridgeManagemenInformation) {
        getProperty(onuMacFilterPreassignProfBridgeManagemenInformation).setValue(aOnuMacFilterPreassignProfBridgeManagemenInformation);
    }

    public Integer getOnuMacFilterPreassignProfARP() {
        return (Integer) getProperty(onuMacFilterPreassignProfARP).getValue();
    }

    public void setOnuMacFilterPreassignProfARP(Integer aOnuMacFilterPreassignProfARP) {
        getProperty(onuMacFilterPreassignProfARP).setValue(aOnuMacFilterPreassignProfARP);
    }

    public Integer getOnuMacFilterPreassignProfPPPoEBroadcast() {
        return (Integer) getProperty(onuMacFilterPreassignProfPPPoEBroadcast).getValue();
    }

    public void setOnuMacFilterPreassignProfPPPoEBroadcast(Integer aOnuMacFilterPreassignProfPPPoEBroadcast) {
        getProperty(onuMacFilterPreassignProfPPPoEBroadcast).setValue(aOnuMacFilterPreassignProfPPPoEBroadcast);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuMacFilterPreassignProfileName));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv4Multicast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv6Multicast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv4Broadcast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfRARP));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPX));
        prepareRead(super.getProperty(onuMacFilterPreassignProfNetBEUI));
        prepareRead(super.getProperty(onuMacFilterPreassignProfAppleTalk));
        prepareRead(super.getProperty(onuMacFilterPreassignProfBridgeManagemenInformation));
        prepareRead(super.getProperty(onuMacFilterPreassignProfARP));
        prepareRead(super.getProperty(onuMacFilterPreassignProfPPPoEBroadcast));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuMacFilterPreassignProfileName));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv4Multicast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv6Multicast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPv4Broadcast));
        prepareRead(super.getProperty(onuMacFilterPreassignProfRARP));
        prepareRead(super.getProperty(onuMacFilterPreassignProfIPX));
        prepareRead(super.getProperty(onuMacFilterPreassignProfNetBEUI));
        prepareRead(super.getProperty(onuMacFilterPreassignProfAppleTalk));
        prepareRead(super.getProperty(onuMacFilterPreassignProfBridgeManagemenInformation));
        prepareRead(super.getProperty(onuMacFilterPreassignProfARP));
        prepareRead(super.getProperty(onuMacFilterPreassignProfPPPoEBroadcast));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuMacFilterPreassignProfileName));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv4Multicast));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv6Multicast));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv4Broadcast));
        prepareSave(getProperty(onuMacFilterPreassignProfRARP));
        prepareSave(getProperty(onuMacFilterPreassignProfIPX));
        prepareSave(getProperty(onuMacFilterPreassignProfNetBEUI));
        prepareSave(getProperty(onuMacFilterPreassignProfAppleTalk));
        prepareSave(getProperty(onuMacFilterPreassignProfBridgeManagemenInformation));
        prepareSave(getProperty(onuMacFilterPreassignProfARP));
        prepareSave(getProperty(onuMacFilterPreassignProfPPPoEBroadcast));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuMacFilterPreassignProfileName));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv4Multicast));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv6Multicast));
        prepareSave(getProperty(onuMacFilterPreassignProfIPv4Broadcast));
        prepareSave(getProperty(onuMacFilterPreassignProfRARP));
        prepareSave(getProperty(onuMacFilterPreassignProfIPX));
        prepareSave(getProperty(onuMacFilterPreassignProfNetBEUI));
        prepareSave(getProperty(onuMacFilterPreassignProfAppleTalk));
        prepareSave(getProperty(onuMacFilterPreassignProfBridgeManagemenInformation));
        prepareSave(getProperty(onuMacFilterPreassignProfARP));
        prepareSave(getProperty(onuMacFilterPreassignProfPPPoEBroadcast));
        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuMacFilterPreassignProfileName();
    }

}