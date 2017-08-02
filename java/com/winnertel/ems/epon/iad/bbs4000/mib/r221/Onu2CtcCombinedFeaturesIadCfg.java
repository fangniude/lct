/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcCombinedFeaturesIadCfg extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcIadInfoMacAddr = "utsDot3Onu2CtcIadInfoMacAddr";
    public static final String utsDot3Onu2CtcIadInfoSupportedProtocol = "utsDot3Onu2CtcIadInfoSupportedProtocol";
    public static final String utsDot3Onu2CtcIadInfoSoftwareVer = "utsDot3Onu2CtcIadInfoSoftwareVer";
    public static final String utsDot3Onu2CtcIadInfoSoftwareDate = "utsDot3Onu2CtcIadInfoSoftwareDate";
    public static final String utsDot3Onu2CtcIadInfoVoipUserCount = "utsDot3Onu2CtcIadInfoVoipUserCount";
    public static final String utsDot3Onu2CtcIadIpMode = "utsDot3Onu2CtcIadIpMode";
    public static final String utsDot3Onu2CtcIadIpAddr = "utsDot3Onu2CtcIadIpAddr";
    public static final String utsDot3Onu2CtcIadNetMask = "utsDot3Onu2CtcIadNetMask";
    public static final String utsDot3Onu2CtcIadDefaultGw = "utsDot3Onu2CtcIadDefaultGw";
    public static final String utsDot3Onu2CtcIadPppoeMode = "utsDot3Onu2CtcIadPppoeMode";
    public static final String utsDot3Onu2CtcIadPppoeUsername = "utsDot3Onu2CtcIadPppoeUsername";
    public static final String utsDot3Onu2CtcIadPppoePassword = "utsDot3Onu2CtcIadPppoePassword";
    public static final String utsDot3Onu2CtcIadTagMode = "utsDot3Onu2CtcIadTagMode";
    public static final String utsDot3Onu2CtcIadCvlan = "utsDot3Onu2CtcIadCvlan";
    public static final String utsDot3Onu2CtcIadSvlan = "utsDot3Onu2CtcIadSvlan";
    public static final String utsDot3Onu2CtcIadPriority = "utsDot3Onu2CtcIadPriority";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCombinedFeaturesIadCfg(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.101", ISnmpConstant.MAC_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.102", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.103", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.104", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.105", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.131", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.132", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.133", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.134", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.135", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.136", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.137", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.138", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.139", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.140", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.141", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesModuleId(Integer aUtsDot3Onu2CtcCombinedFeaturesModuleId) {
        setIndex(0, aUtsDot3Onu2CtcCombinedFeaturesModuleId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesDeviceId(Integer aUtsDot3Onu2CtcCombinedFeaturesDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcCombinedFeaturesDeviceId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesPortId) {
        setIndex(2, aUtsDot3Onu2CtcCombinedFeaturesPortId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
    }

    public byte[] getUtsDot3Onu2CtcIadInfoMacAddr() {
        return (byte[]) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoMacAddr(byte[] aUtsDot3Onu2CtcIadInfoMacAddr) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr).setValue(aUtsDot3Onu2CtcIadInfoMacAddr);
    }

    public Integer getUtsDot3Onu2CtcIadInfoSupportedProtocol() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSupportedProtocol(Integer aUtsDot3Onu2CtcIadInfoSupportedProtocol) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol).setValue(aUtsDot3Onu2CtcIadInfoSupportedProtocol);
    }

    public String getUtsDot3Onu2CtcIadInfoSoftwareVer() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSoftwareVer(String aUtsDot3Onu2CtcIadInfoSoftwareVer) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer).setValue(aUtsDot3Onu2CtcIadInfoSoftwareVer);
    }

    public String getUtsDot3Onu2CtcIadInfoSoftwareDate() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoSoftwareDate(String aUtsDot3Onu2CtcIadInfoSoftwareDate) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate).setValue(aUtsDot3Onu2CtcIadInfoSoftwareDate);
    }

    public Integer getUtsDot3Onu2CtcIadInfoVoipUserCount() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount).getValue();
    }

    public void setUtsDot3Onu2CtcIadInfoVoipUserCount(Integer aUtsDot3Onu2CtcIadInfoVoipUserCount) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount).setValue(aUtsDot3Onu2CtcIadInfoVoipUserCount);
    }

    public Integer getUtsDot3Onu2CtcIadIpMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadIpMode(Integer aUtsDot3Onu2CtcIadIpMode) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode).setValue(aUtsDot3Onu2CtcIadIpMode);
    }

    public String getUtsDot3Onu2CtcIadIpAddr() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr).getValue();
    }

    public void setUtsDot3Onu2CtcIadIpAddr(String aUtsDot3Onu2CtcIadIpAddr) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr).setValue(aUtsDot3Onu2CtcIadIpAddr);
    }

    public String getUtsDot3Onu2CtcIadNetMask() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask).getValue();
    }

    public void setUtsDot3Onu2CtcIadNetMask(String aUtsDot3Onu2CtcIadNetMask) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask).setValue(aUtsDot3Onu2CtcIadNetMask);
    }

    public String getUtsDot3Onu2CtcIadDefaultGw() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw).getValue();
    }

    public void setUtsDot3Onu2CtcIadDefaultGw(String aUtsDot3Onu2CtcIadDefaultGw) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw).setValue(aUtsDot3Onu2CtcIadDefaultGw);
    }

    public Integer getUtsDot3Onu2CtcIadPppoeMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoeMode(Integer aUtsDot3Onu2CtcIadPppoeMode) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode).setValue(aUtsDot3Onu2CtcIadPppoeMode);
    }

    public String getUtsDot3Onu2CtcIadPppoeUsername() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoeUsername(String aUtsDot3Onu2CtcIadPppoeUsername) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername).setValue(aUtsDot3Onu2CtcIadPppoeUsername);
    }

    public String getUtsDot3Onu2CtcIadPppoePassword() {
        return (String) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword).getValue();
    }

    public void setUtsDot3Onu2CtcIadPppoePassword(String aUtsDot3Onu2CtcIadPppoePassword) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword).setValue(aUtsDot3Onu2CtcIadPppoePassword);
    }

    public Integer getUtsDot3Onu2CtcIadTagMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode).getValue();
    }

    public void setUtsDot3Onu2CtcIadTagMode(Integer aUtsDot3Onu2CtcIadTagMode) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode).setValue(aUtsDot3Onu2CtcIadTagMode);
    }

    public Integer getUtsDot3Onu2CtcIadCvlan() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan).getValue();
    }

    public void setUtsDot3Onu2CtcIadCvlan(Integer aUtsDot3Onu2CtcIadCvlan) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan).setValue(aUtsDot3Onu2CtcIadCvlan);
    }

    public Integer getUtsDot3Onu2CtcIadSvlan() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan).getValue();
    }

    public void setUtsDot3Onu2CtcIadSvlan(Integer aUtsDot3Onu2CtcIadSvlan) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan).setValue(aUtsDot3Onu2CtcIadSvlan);
    }

    public Integer getUtsDot3Onu2CtcIadPriority() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority).getValue();
    }

    public void setUtsDot3Onu2CtcIadPriority(Integer aUtsDot3Onu2CtcIadPriority) {
        getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority).setValue(aUtsDot3Onu2CtcIadPriority);
    }

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoMacAddr));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSupportedProtocol));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareVer));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoSoftwareDate));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadInfoVoipUserCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcCombinedFeaturesIadCfg bean = (Onu2CtcCombinedFeaturesIadCfg) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcCombinedFeaturesModuleId()).append("/").append(bean.getUtsDot3Onu2CtcCombinedFeaturesPortId()).append("/").append(bean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId()).toString();
//                    if (map.containsKey(key)) {
//                        bean.setOnuLabel((String) map.get(key));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadIpAddr));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadNetMask));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadDefaultGw));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoeUsername));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPppoePassword));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadTagMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadCvlan));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadSvlan));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadCfg.utsDot3Onu2CtcIadPriority));

        return save();
    }

}