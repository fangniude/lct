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

public class Onu2CtcCombinedFeaturesH248Cfg extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcH248MgPort = "utsDot3Onu2CtcH248MgPort";
    public static final String utsDot3Onu2CtcH248MgcIp = "utsDot3Onu2CtcH248MgcIp";
    public static final String utsDot3Onu2CtcH248MgpComPort = "utsDot3Onu2CtcH248MgpComPort";
    public static final String utsDot3Onu2CtcH248BackupMgcIp = "utsDot3Onu2CtcH248BackupMgcIp";
    public static final String utsDot3Onu2CtcH248BackupMgcComPort = "utsDot3Onu2CtcH248BackupMgcComPort";
    public static final String utsDot3Onu2CtcH248ActiveMgc = "utsDot3Onu2CtcH248ActiveMgc";
    public static final String utsDot3Onu2CtcH248RegMode = "utsDot3Onu2CtcH248RegMode";
    public static final String utsDot3Onu2CtcH248Mid = "utsDot3Onu2CtcH248Mid";
    public static final String utsDot3Onu2CtcH248HeartbeatMode = "utsDot3Onu2CtcH248HeartbeatMode";
    public static final String utsDot3Onu2CtcH248HeartbeatCycle = "utsDot3Onu2CtcH248HeartbeatCycle";
    public static final String utsDot3Onu2CtcH248HeartbeatCount = "utsDot3Onu2CtcH248HeartbeatCount";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidNum = "utsDot3Onu2CtcH248RtpTidCfgTidNum";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidPrefix = "utsDot3Onu2CtcH248RtpTidCfgTidPrefix";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = "utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidMode = "utsDot3Onu2CtcH248RtpTidCfgTidMode";
    public static final String utsDot3Onu2CtcH248RtpTidCfgTidDigitLength = "utsDot3Onu2CtcH248RtpTidCfgTidDigitLength";
    public static final String utsDot3Onu2CtcH248RtpTidInfoFirstTidName = "utsDot3Onu2CtcH248RtpTidInfoFirstTidName";
    public static final String utsDot3Onu2CtcH248IadOperationStaus = "utsDot3Onu2CtcH248IadOperationStaus";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCombinedFeaturesH248Cfg(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.161", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.162", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.163", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.164", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.165", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.166", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.167", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.168", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.169", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.170", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.171", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.201", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.202", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.203", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.204", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.205", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.231", ISnmpConstant.STRING));
        initProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.331", ISnmpConstant.INTEGER));
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

    public Integer getUtsDot3Onu2CtcH248MgPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgPort(Integer aUtsDot3Onu2CtcH248MgPort) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort).setValue(aUtsDot3Onu2CtcH248MgPort);
    }

    public String getUtsDot3Onu2CtcH248MgcIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgcIp(String aUtsDot3Onu2CtcH248MgcIp) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp).setValue(aUtsDot3Onu2CtcH248MgcIp);
    }

    public Integer getUtsDot3Onu2CtcH248MgpComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248MgpComPort(Integer aUtsDot3Onu2CtcH248MgpComPort) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort).setValue(aUtsDot3Onu2CtcH248MgpComPort);
    }

    public String getUtsDot3Onu2CtcH248BackupMgcIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp).getValue();
    }

    public void setUtsDot3Onu2CtcH248BackupMgcIp(String aUtsDot3Onu2CtcH248BackupMgcIp) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp).setValue(aUtsDot3Onu2CtcH248BackupMgcIp);
    }

    public Integer getUtsDot3Onu2CtcH248BackupMgcComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort).getValue();
    }

    public void setUtsDot3Onu2CtcH248BackupMgcComPort(Integer aUtsDot3Onu2CtcH248BackupMgcComPort) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort).setValue(aUtsDot3Onu2CtcH248BackupMgcComPort);
    }

    public Integer getUtsDot3Onu2CtcH248ActiveMgc() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc).getValue();
    }

    public void setUtsDot3Onu2CtcH248ActiveMgc(Integer aUtsDot3Onu2CtcH248ActiveMgc) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc).setValue(aUtsDot3Onu2CtcH248ActiveMgc);
    }

    public Integer getUtsDot3Onu2CtcH248RegMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248RegMode(Integer aUtsDot3Onu2CtcH248RegMode) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode).setValue(aUtsDot3Onu2CtcH248RegMode);
    }

    public String getUtsDot3Onu2CtcH248Mid() {
        return (String) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid).getValue();
    }

    public void setUtsDot3Onu2CtcH248Mid(String aUtsDot3Onu2CtcH248Mid) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid).setValue(aUtsDot3Onu2CtcH248Mid);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatMode(Integer aUtsDot3Onu2CtcH248HeartbeatMode) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode).setValue(aUtsDot3Onu2CtcH248HeartbeatMode);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatCycle() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatCycle(Integer aUtsDot3Onu2CtcH248HeartbeatCycle) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle).setValue(aUtsDot3Onu2CtcH248HeartbeatCycle);
    }

    public Integer getUtsDot3Onu2CtcH248HeartbeatCount() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount).getValue();
    }

    public void setUtsDot3Onu2CtcH248HeartbeatCount(Integer aUtsDot3Onu2CtcH248HeartbeatCount) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount).setValue(aUtsDot3Onu2CtcH248HeartbeatCount);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidNum() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidNum(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidNum) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidNum);
    }

    public String getUtsDot3Onu2CtcH248RtpTidCfgTidPrefix() {
        return (String) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidPrefix(String aUtsDot3Onu2CtcH248RtpTidCfgTidPrefix) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidPrefix);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidMode() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidMode(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidMode) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidMode);
    }

    public Integer getUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength(Integer aUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength).setValue(aUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength);
    }

    public String getUtsDot3Onu2CtcH248RtpTidInfoFirstTidName() {
        return (String) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName).getValue();
    }

    public void setUtsDot3Onu2CtcH248RtpTidInfoFirstTidName(String aUtsDot3Onu2CtcH248RtpTidInfoFirstTidName) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName).setValue(aUtsDot3Onu2CtcH248RtpTidInfoFirstTidName);
    }

    public Integer getUtsDot3Onu2CtcH248IadOperationStaus() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus).getValue();
    }

    public void setUtsDot3Onu2CtcH248IadOperationStaus(Integer aUtsDot3Onu2CtcH248IadOperationStaus) {
        getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus).setValue(aUtsDot3Onu2CtcH248IadOperationStaus);
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
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248IadOperationStaus));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcCombinedFeaturesH248Cfg bean = (Onu2CtcCombinedFeaturesH248Cfg) v.get(i);
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
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgcIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248MgpComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248BackupMgcComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248ActiveMgc));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RegMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248Mid));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCycle));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248HeartbeatCount));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidNum));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidMode));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesH248Cfg.utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));

        return save();
    }

}