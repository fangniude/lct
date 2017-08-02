/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Hashtable;
import java.util.Vector;

public class Onu2CtcCombinedFeaturesSipCfg extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcSipMgPort = "utsDot3Onu2CtcSipMgPort";
    public static final String utsDot3Onu2CtcSipProxyServIp = "utsDot3Onu2CtcSipProxyServIp";
    public static final String utsDot3Onu2CtcSipProxyServComPort = "utsDot3Onu2CtcSipProxyServComPort";
    public static final String utsDot3Onu2CtcSipBackupProxyServIp = "utsDot3Onu2CtcSipBackupProxyServIp";
    public static final String utsDot3Onu2CtcSipBackupProxyServComPort = "utsDot3Onu2CtcSipBackupProxyServComPort";
    public static final String utsDot3Onu2CtcSipActiveProxyServ = "utsDot3Onu2CtcSipActiveProxyServ";
    public static final String utsDot3Onu2CtcSipRegServIp = "utsDot3Onu2CtcSipRegServIp";
    public static final String utsDot3Onu2CtcSipRegServComPort = "utsDot3Onu2CtcSipRegServComPort";
    public static final String utsDot3Onu2CtcSipBackupRegServIp = "utsDot3Onu2CtcSipBackupRegServIp";
    public static final String utsDot3Onu2CtcSipBackupRegServComPort = "utsDot3Onu2CtcSipBackupRegServComPort";
    public static final String utsDot3Onu2CtcSipOutBoundServIp = "utsDot3Onu2CtcSipOutBoundServIp";
    public static final String utsDot3Onu2CtcSipOutBoundServPort = "utsDot3Onu2CtcSipOutBoundServPort";
    public static final String utsDot3Onu2CtcSipRegInterval = "utsDot3Onu2CtcSipRegInterval";
    public static final String utsDot3Onu2CtcSipHeartbeatSwitch = "utsDot3Onu2CtcSipHeartbeatSwitch";
    public static final String utsDot3Onu2CtcSipHeartbeatCycle = "utsDot3Onu2CtcSipHeartbeatCycle";
    public static final String utsDot3Onu2CtcSipHeartbeatCount = "utsDot3Onu2CtcSipHeartbeatCount";
    public static final String utsDot3Onu2CtcSipDigitMap = "utsDot3Onu2CtcSipDigitMap";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCombinedFeaturesSipCfg(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.261", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.262", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.263", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.264", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.265", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.266", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.267", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.268", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.269", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.270", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.271", ISnmpConstant.IP_ADDRESS));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.272", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.273", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.274", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.275", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.276", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.361", ISnmpConstant.STRING));
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

    public Integer getUtsDot3Onu2CtcSipMgPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipMgPort(Integer aUtsDot3Onu2CtcSipMgPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort).setValue(aUtsDot3Onu2CtcSipMgPort);
    }

    public String getUtsDot3Onu2CtcSipProxyServIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipProxyServIp(String aUtsDot3Onu2CtcSipProxyServIp) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp).setValue(aUtsDot3Onu2CtcSipProxyServIp);
    }

    public Integer getUtsDot3Onu2CtcSipProxyServComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipProxyServComPort(Integer aUtsDot3Onu2CtcSipProxyServComPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort).setValue(aUtsDot3Onu2CtcSipProxyServComPort);
    }

    public String getUtsDot3Onu2CtcSipBackupProxyServIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupProxyServIp(String aUtsDot3Onu2CtcSipBackupProxyServIp) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp).setValue(aUtsDot3Onu2CtcSipBackupProxyServIp);
    }

    public Integer getUtsDot3Onu2CtcSipBackupProxyServComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupProxyServComPort(Integer aUtsDot3Onu2CtcSipBackupProxyServComPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort).setValue(aUtsDot3Onu2CtcSipBackupProxyServComPort);
    }

    public String getUtsDot3Onu2CtcSipActiveProxyServ() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ).getValue();
    }

    public void setUtsDot3Onu2CtcSipActiveProxyServ(String aUtsDot3Onu2CtcSipActiveProxyServ) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ).setValue(aUtsDot3Onu2CtcSipActiveProxyServ);
    }

    public String getUtsDot3Onu2CtcSipRegServIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegServIp(String aUtsDot3Onu2CtcSipRegServIp) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp).setValue(aUtsDot3Onu2CtcSipRegServIp);
    }

    public Integer getUtsDot3Onu2CtcSipRegServComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegServComPort(Integer aUtsDot3Onu2CtcSipRegServComPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort).setValue(aUtsDot3Onu2CtcSipRegServComPort);
    }

    public String getUtsDot3Onu2CtcSipBackupRegServIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupRegServIp(String aUtsDot3Onu2CtcSipBackupRegServIp) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp).setValue(aUtsDot3Onu2CtcSipBackupRegServIp);
    }

    public Integer getUtsDot3Onu2CtcSipBackupRegServComPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipBackupRegServComPort(Integer aUtsDot3Onu2CtcSipBackupRegServComPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort).setValue(aUtsDot3Onu2CtcSipBackupRegServComPort);
    }

    public String getUtsDot3Onu2CtcSipOutBoundServIp() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp).getValue();
    }

    public void setUtsDot3Onu2CtcSipOutBoundServIp(String aUtsDot3Onu2CtcSipOutBoundServIp) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp).setValue(aUtsDot3Onu2CtcSipOutBoundServIp);
    }

    public Integer getUtsDot3Onu2CtcSipOutBoundServPort() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort).getValue();
    }

    public void setUtsDot3Onu2CtcSipOutBoundServPort(Integer aUtsDot3Onu2CtcSipOutBoundServPort) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort).setValue(aUtsDot3Onu2CtcSipOutBoundServPort);
    }

    public Integer getUtsDot3Onu2CtcSipRegInterval() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval).getValue();
    }

    public void setUtsDot3Onu2CtcSipRegInterval(Integer aUtsDot3Onu2CtcSipRegInterval) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval).setValue(aUtsDot3Onu2CtcSipRegInterval);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatSwitch() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatSwitch(Integer aUtsDot3Onu2CtcSipHeartbeatSwitch) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch).setValue(aUtsDot3Onu2CtcSipHeartbeatSwitch);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatCycle() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatCycle(Integer aUtsDot3Onu2CtcSipHeartbeatCycle) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle).setValue(aUtsDot3Onu2CtcSipHeartbeatCycle);
    }

    public Integer getUtsDot3Onu2CtcSipHeartbeatCount() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount).getValue();
    }

    public void setUtsDot3Onu2CtcSipHeartbeatCount(Integer aUtsDot3Onu2CtcSipHeartbeatCount) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount).setValue(aUtsDot3Onu2CtcSipHeartbeatCount);
    }

    public String getUtsDot3Onu2CtcSipDigitMap() {
        return (String) getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap).getValue();
    }

    public void setUtsDot3Onu2CtcSipDigitMap(String aUtsDot3Onu2CtcSipDigitMap) {
        getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap).setValue(aUtsDot3Onu2CtcSipDigitMap);
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
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval));

        boolean bl1 = load();
        if (!bl1)
            return bl1;

        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap));

        boolean bl2 = load();

        return bl2;
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval));

        Vector servTable = loadAll(new int[]{1, 1, 1, 1});

        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap));

        Vector heartTable = loadAll(new int[]{1, 1, 1, 1});
        Hashtable<String, Onu2CtcCombinedFeaturesSipCfg> index2SipCfgBean = new Hashtable<String, Onu2CtcCombinedFeaturesSipCfg>();
        for (int i = 0; i < heartTable.size(); i++) {
            Onu2CtcCombinedFeaturesSipCfg mBean = (Onu2CtcCombinedFeaturesSipCfg) heartTable.get(i);
            Integer moduleId = mBean.getUtsDot3Onu2CtcCombinedFeaturesModuleId();
            Integer deviceId = mBean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId();
            Integer portId = mBean.getUtsDot3Onu2CtcCombinedFeaturesPortId();
            Integer logicalId = mBean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId();

            index2SipCfgBean.put(moduleId + "-" + deviceId + "-" + portId + "-" + logicalId, mBean);
        }

        Vector result = new Vector();
        for (int i = 0; i < servTable.size(); i++) {
            Onu2CtcCombinedFeaturesSipCfg mBean = (Onu2CtcCombinedFeaturesSipCfg) servTable.get(i);
            Integer moduleId = mBean.getUtsDot3Onu2CtcCombinedFeaturesModuleId();
            Integer deviceId = mBean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId();
            Integer portId = mBean.getUtsDot3Onu2CtcCombinedFeaturesPortId();
            Integer logicalId = mBean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId();

            Onu2CtcCombinedFeaturesSipCfg cfgBean = index2SipCfgBean.get(moduleId + "-" + deviceId + "-" + portId + "-" + logicalId);
            mBean.setUtsDot3Onu2CtcSipHeartbeatSwitch(cfgBean.getUtsDot3Onu2CtcSipHeartbeatSwitch());
            mBean.setUtsDot3Onu2CtcSipHeartbeatCycle(cfgBean.getUtsDot3Onu2CtcSipHeartbeatCycle());
            mBean.setUtsDot3Onu2CtcSipHeartbeatCount(cfgBean.getUtsDot3Onu2CtcSipHeartbeatCount());
            mBean.setUtsDot3Onu2CtcSipDigitMap(cfgBean.getUtsDot3Onu2CtcSipDigitMap());
            result.add(mBean);
        }

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < result.size(); i++) {
//                    Onu2CtcCombinedFeaturesSipCfg bean = (Onu2CtcCombinedFeaturesSipCfg) result.get(i);
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

        return result;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipMgPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipProxyServComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupProxyServComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipActiveProxyServ));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegServComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipBackupRegServComPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServIp));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipOutBoundServPort));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipRegInterval));

        boolean bl1 = save();
        if (!bl1)
            return bl1;

        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatSwitch));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCycle));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipHeartbeatCount));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesSipCfg.utsDot3Onu2CtcSipDigitMap));

        return save();
    }

}