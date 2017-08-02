/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Olt2PortTable extends SnmpMibBean {

    public static final String ifIndex = "ifIndex";

    public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
    public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
    public static final String utsDot3OltPortId = "utsDot3OltPortId";
    public static final String utsDot3OltOperState = "utsDot3OltOperState";
    public static final String utsDot3OltAdminState = "utsDot3OltAdminState";
    public static final String utsDot3OltRegisteredOnuNum = "utsDot3OltRegisteredOnuNum";
    public static final String utsDot3OltSyncTime = "utsDot3OltSyncTime";
    public static final String utsDot3OltLaserOnTime = "utsDot3OltLaserOnTime";
    public static final String utsDot3OltLaserOffTime = "utsDot3OltLaserOffTime";
    public static final String utsDot3OltTxFECEnable = "utsDot3OltTxFECEnable";
    public static final String utsDot3OltTransceiverTx = "utsDot3OltTransceiverTx";
    public static final String utsDot3OltTransceiverRx = "utsDot3OltTransceiverRx";
    //public static final String utsDot3OltONUP2PEnable = "utsDot3OltONUP2PEnable";
    public static final String utsDot3OltMPCPGateBackoffTime = "utsDot3OltMPCPGateBackoffTime";
    public static final String utsDot3OltP2pEnable = "utsDot3OltP2pEnable";
    public static final String utsDot3OltOlpPort = "utsDot3OltOlpPort";
    public static final String utsDot3OltPortLoopbackDetection = "utsDot3OltPortLoopbackDetection";
    public static final String utsDot3OltPortLoopbackDetectionControl = "utsDot3OltPortLoopbackDetectionControl";
    public static final String utsDot3OltPortTransmissionPower = "utsDot3OltPortTransmissionPower";
    public static final String utsDot3OltPortReceivingPower = "utsDot3OltPortReceivingPower";
    public static final String utsDot3OltPortRealtimeMulticastTraffic = "utsDot3OltPortRealtimeMulticastTraffic";
    public static final String utsDot3OltPortSupplyVoltage = "utsDot3OltPortSupplyVoltage";
    public static final String utsDot3OltPortCurrentBias = "utsDot3OltPortCurrentBias";
    public static final String utsDot3OltPortCurrentTemperature = "utsDot3OltPortCurrentTemperature";
    public static final String utsDot3OltPortFlexQinQSwitch = "utsDot3OltPortFlexQinQSwitch"; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    public static final String utsDot3OltPortONUSNumberSwitch = "utsDot3OltPortONUSNumberSwitch";

    public Dot3Olt2PortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortId, new SnmpMibBeanProperty(utsDot3OltPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOperState, new SnmpMibBeanProperty(utsDot3OltOperState, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltAdminState, new SnmpMibBeanProperty(utsDot3OltAdminState, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltRegisteredOnuNum, new SnmpMibBeanProperty(utsDot3OltRegisteredOnuNum, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltSyncTime, new SnmpMibBeanProperty(utsDot3OltSyncTime, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltLaserOnTime, new SnmpMibBeanProperty(utsDot3OltLaserOnTime, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltLaserOffTime, new SnmpMibBeanProperty(utsDot3OltLaserOffTime, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.13", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltTxFECEnable, new SnmpMibBeanProperty(utsDot3OltTxFECEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.14", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltTransceiverTx, new SnmpMibBeanProperty(utsDot3OltTransceiverTx, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.15", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltTransceiverRx, new SnmpMibBeanProperty(utsDot3OltTransceiverRx, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.16", ISnmpConstant.INTEGER));
        //initProperty(utsDot3OltONUP2PEnable, new SnmpMibBeanProperty(utsDot3OltONUP2PEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.17", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltMPCPGateBackoffTime, new SnmpMibBeanProperty(utsDot3OltMPCPGateBackoffTime, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.18", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltP2pEnable, new SnmpMibBeanProperty(utsDot3OltP2pEnable, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.21", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltOlpPort, new SnmpMibBeanProperty(utsDot3OltOlpPort, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.22", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortLoopbackDetection, new SnmpMibBeanProperty(utsDot3OltPortLoopbackDetection, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.24", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortLoopbackDetectionControl, new SnmpMibBeanProperty(utsDot3OltPortLoopbackDetectionControl, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.26", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortTransmissionPower, new SnmpMibBeanProperty(utsDot3OltPortTransmissionPower, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.27", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortReceivingPower, new SnmpMibBeanProperty(utsDot3OltPortReceivingPower, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.28", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortRealtimeMulticastTraffic, new SnmpMibBeanProperty(utsDot3OltPortRealtimeMulticastTraffic, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.29", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortSupplyVoltage, new SnmpMibBeanProperty(utsDot3OltPortSupplyVoltage, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.30", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortCurrentBias, new SnmpMibBeanProperty(utsDot3OltPortCurrentBias, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.31", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortCurrentTemperature, new SnmpMibBeanProperty(utsDot3OltPortCurrentTemperature, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.32", ISnmpConstant.INTEGER));
        initProperty(utsDot3OltPortFlexQinQSwitch, new SnmpMibBeanProperty(utsDot3OltPortFlexQinQSwitch, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.33", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        initProperty(utsDot3OltPortONUSNumberSwitch, new SnmpMibBeanProperty(utsDot3OltPortONUSNumberSwitch, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.2.1.35", ISnmpConstant.INTEGER));
    }

    public Integer getIfIndex() {
        return ConfigUtility.generateIfIndex(new StringBuffer().append(getUtsDot3OltModuleId()).append("/").append(getUtsDot3OltPortId()).toString());
    }

    public Integer getUtsDot3OltModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId) {
        setIndex(0, aUtsDot3OltModuleId);
    }

    public Integer getUtsDot3OltDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OltDeviceId(Integer aUtsDot3OltDeviceId) {
        setIndex(1, aUtsDot3OltDeviceId);
    }

    public Integer getUtsDot3OltPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OltPortId(Integer aUtsDot3OltPortId) {
        setIndex(2, aUtsDot3OltPortId);
    }

    public Integer getUtsDot3OltOperState() {
        return (Integer) getProperty(utsDot3OltOperState).getValue();
    }

    public void setUtsDot3OltOperState(Integer aUtsDot3OltOperState) {
        getProperty(utsDot3OltOperState).setValue(aUtsDot3OltOperState);
    }

    public Integer getUtsDot3OltAdminState() {
        return (Integer) getProperty(utsDot3OltAdminState).getValue();
    }

    public void setUtsDot3OltAdminState(Integer aUtsDot3OltAdminState) {
        getProperty(utsDot3OltAdminState).setValue(aUtsDot3OltAdminState);
    }

    public Integer getUtsDot3OltRegisteredOnuNum() {
        return (Integer) getProperty(utsDot3OltRegisteredOnuNum).getValue();
    }

    public void setUtsDot3OltRegisteredOnuNum(Integer aUtsDot3OltRegisteredOnuNum) {
        getProperty(utsDot3OltRegisteredOnuNum).setValue(aUtsDot3OltRegisteredOnuNum);
    }

    public Integer getUtsDot3OltSyncTime() {
        return (Integer) getProperty(utsDot3OltSyncTime).getValue();
    }

    public void setUtsDot3OltSyncTime(Integer aUtsDot3OltSyncTime) {
        getProperty(utsDot3OltSyncTime).setValue(aUtsDot3OltSyncTime);
    }

    public Integer getUtsDot3OltLaserOnTime() {
        return (Integer) getProperty(utsDot3OltLaserOnTime).getValue();
    }

    public void setUtsDot3OltLaserOnTime(Integer aUtsDot3OltLaserOnTime) {
        getProperty(utsDot3OltLaserOnTime).setValue(aUtsDot3OltLaserOnTime);
    }

    public Integer getUtsDot3OltLaserOffTime() {
        return (Integer) getProperty(utsDot3OltLaserOffTime).getValue();
    }

    public void setUtsDot3OltLaserOffTime(Integer aUtsDot3OltLaserOffTime) {
        getProperty(utsDot3OltLaserOffTime).setValue(aUtsDot3OltLaserOffTime);
    }

    public Integer getUtsDot3OltTxFECEnable() {
        return (Integer) getProperty(utsDot3OltTxFECEnable).getValue();
    }

    public void setUtsDot3OltTxFECEnable(Integer aUtsDot3OltTxFECEnable) {
        getProperty(utsDot3OltTxFECEnable).setValue(aUtsDot3OltTxFECEnable);
    }

    public Integer getUtsDot3OltTransceiverTx() {
        return (Integer) getProperty(utsDot3OltTransceiverTx).getValue();
    }

    public void setUtsDot3OltTransceiverTx(Integer aUtsDot3OltTransceiverTx) {
        getProperty(utsDot3OltTransceiverTx).setValue(aUtsDot3OltTransceiverTx);
    }

    public Integer getUtsDot3OltTransceiverRx() {
        return (Integer) getProperty(utsDot3OltTransceiverRx).getValue();
    }

    public void setUtsDot3OltTransceiverRx(Integer aUtsDot3OltTransceiverRx) {
        getProperty(utsDot3OltTransceiverRx).setValue(aUtsDot3OltTransceiverRx);
    }

    //public Integer getUtsDot3OltONUP2PEnable() {
    //    return (Integer) getProperty(utsDot3OltONUP2PEnable).getValue();
    //}

    //public void setUtsDot3OltONUP2PEnable(Integer aUtsDot3OltONUP2PEnable) {
    //    getProperty(utsDot3OltONUP2PEnable).setValue(aUtsDot3OltONUP2PEnable);
    //}

    public Integer getUtsDot3OltMPCPGateBackoffTime() {
        return (Integer) getProperty(utsDot3OltMPCPGateBackoffTime).getValue();
    }

    public void setUtsDot3OltMPCPGateBackoffTime(Integer aUtsDot3OltMPCPGateBackoffTime) {
        getProperty(utsDot3OltMPCPGateBackoffTime).setValue(aUtsDot3OltMPCPGateBackoffTime);
    }

    public Integer getUtsDot3OltP2pEnable() {
        return (Integer) getProperty(utsDot3OltP2pEnable).getValue();
    }

    public void setUtsDot3OltP2pEnable(Integer aUtsDot3OltP2pEnable) {
        getProperty(utsDot3OltP2pEnable).setValue(aUtsDot3OltP2pEnable);
    }

    public Integer getUtsDot3OltOlpPort() {
        return (Integer) getProperty(utsDot3OltOlpPort).getValue();
    }

    public void setUtsDot3OltOlpPort(Integer aUtsDot3OltOlpPort) {
        getProperty(utsDot3OltOlpPort).setValue(aUtsDot3OltOlpPort);
    }

    public Integer getUtsDot3OltPortLoopbackDetection() {
        return (Integer) getProperty(utsDot3OltPortLoopbackDetection).getValue();
    }

    public void setUtsDot3OltPortLoopbackDetection(Integer aUtsDot3OltPortLoopbackDetection) {
        getProperty(utsDot3OltPortLoopbackDetection).setValue(aUtsDot3OltPortLoopbackDetection);
    }

    public Integer getUtsDot3OltPortLoopbackDetectionControl() {
        return (Integer) getProperty(utsDot3OltPortLoopbackDetectionControl).getValue();
    }

    public void setUtsDot3OltPortLoopbackDetectionControl(Integer aUtsDot3OltPortLoopbackDetectionControl) {
        getProperty(utsDot3OltPortLoopbackDetectionControl).setValue(aUtsDot3OltPortLoopbackDetectionControl);
    }

    public Integer getUtsDot3OltPortTransmissionPower() {
        return (Integer) getProperty(utsDot3OltPortTransmissionPower).getValue();
    }

    public void setUtsDot3OltPortTransmissionPower(Integer aUtsDot3OltPortTransmissionPower) {
        getProperty(utsDot3OltPortTransmissionPower).setValue(aUtsDot3OltPortTransmissionPower);
    }

    public Integer getUtsDot3OltPortReceivingPower() {
        return (Integer) getProperty(utsDot3OltPortReceivingPower).getValue();
    }

    public void setUtsDot3OltPortReceivingPower(Integer aUtsDot3OltPortReceivingPower) {
        getProperty(utsDot3OltPortReceivingPower).setValue(aUtsDot3OltPortReceivingPower);
    }

    public Integer getUtsDot3OltPortRealtimeMulticastTraffic() {
        return (Integer) getProperty(utsDot3OltPortRealtimeMulticastTraffic).getValue();
    }

    public void setUtsDot3OltPortRealtimeMulticastTraffic(Integer aUtsDot3OltPortRealtimeMulticastTraffic) {
        getProperty(utsDot3OltPortRealtimeMulticastTraffic).setValue(aUtsDot3OltPortRealtimeMulticastTraffic);
    }

    public Integer getUtsDot3OltPortSupplyVoltage() {
        return (Integer) getProperty(utsDot3OltPortSupplyVoltage).getValue();
    }

    public void setUtsDot3OltPortSupplyVoltage(Integer aUtsDot3OltPortSupplyVoltage) {
        getProperty(utsDot3OltPortSupplyVoltage).setValue(aUtsDot3OltPortSupplyVoltage);
    }

    public Integer getUtsDot3OltPortCurrentBias() {
        return (Integer) getProperty(utsDot3OltPortCurrentBias).getValue();
    }

    public void setUtsDot3OltPortCurrentBias(Integer aUtsDot3OltPortCurrentBias) {
        getProperty(utsDot3OltPortCurrentBias).setValue(aUtsDot3OltPortCurrentBias);
    }

    public Integer getUtsDot3OltPortCurrentTemperature() {
        return (Integer) getProperty(utsDot3OltPortCurrentTemperature).getValue();
    }

    public void setUtsDot3OltPortCurrentTemperature(Integer aUtsDot3OltPortCurrentTemperature) {
        getProperty(utsDot3OltPortCurrentTemperature).setValue(aUtsDot3OltPortCurrentTemperature);
    }

    public Integer getUtsDot3OltPortFlexQinQSwitch() { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        return (Integer) getProperty(utsDot3OltPortFlexQinQSwitch).getValue();
    }

    public void setUtsDot3OltPortFlexQinQSwitch(Integer aUtsDot3OltPortFlexQinQSwitch) { //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        getProperty(utsDot3OltPortFlexQinQSwitch).setValue(aUtsDot3OltPortFlexQinQSwitch);
    }

    public Integer getUtsDot3OltPortONUSNumberSwitch() {
        return (Integer) getProperty(utsDot3OltPortONUSNumberSwitch).getValue();
    }

    public void setUtsDot3OltPortONUSNumberSwitch(Integer aUtsDot3OltPortONUSNumberSwitch) {
        getProperty(utsDot3OltPortONUSNumberSwitch).setValue(aUtsDot3OltPortONUSNumberSwitch);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OltOperState));
        prepareRead(getProperty(utsDot3OltAdminState));
        prepareRead(getProperty(utsDot3OltRegisteredOnuNum));
        prepareRead(getProperty(utsDot3OltSyncTime));
        prepareRead(getProperty(utsDot3OltLaserOnTime));
        prepareRead(getProperty(utsDot3OltLaserOffTime));
        prepareRead(getProperty(utsDot3OltTxFECEnable));
        prepareRead(getProperty(utsDot3OltTransceiverTx));
        prepareRead(getProperty(utsDot3OltTransceiverRx));
        //prepareRead(getProperty(utsDot3OltONUP2PEnable));
        prepareRead(getProperty(utsDot3OltMPCPGateBackoffTime));
        prepareRead(getProperty(utsDot3OltP2pEnable));
        prepareRead(getProperty(utsDot3OltOlpPort));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetection));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetectionControl));
        prepareRead(getProperty(utsDot3OltPortTransmissionPower));
        prepareRead(getProperty(utsDot3OltPortReceivingPower));
        prepareRead(getProperty(utsDot3OltPortRealtimeMulticastTraffic));
        prepareRead(getProperty(utsDot3OltPortSupplyVoltage));
        prepareRead(getProperty(utsDot3OltPortCurrentBias));
        prepareRead(getProperty(utsDot3OltPortCurrentTemperature));
        prepareRead(getProperty(utsDot3OltPortFlexQinQSwitch)); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        prepareRead(getProperty(utsDot3OltPortONUSNumberSwitch));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OltOperState));
        prepareRead(getProperty(utsDot3OltAdminState));
        prepareRead(getProperty(utsDot3OltRegisteredOnuNum));
        prepareRead(getProperty(utsDot3OltSyncTime));
        prepareRead(getProperty(utsDot3OltLaserOnTime));
        prepareRead(getProperty(utsDot3OltLaserOffTime));
        prepareRead(getProperty(utsDot3OltTxFECEnable));
        prepareRead(getProperty(utsDot3OltTransceiverTx));
        prepareRead(getProperty(utsDot3OltTransceiverRx));
        //prepareRead(getProperty(utsDot3OltONUP2PEnable));
        prepareRead(getProperty(utsDot3OltMPCPGateBackoffTime));
        prepareRead(getProperty(utsDot3OltP2pEnable));
        prepareRead(getProperty(utsDot3OltOlpPort));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetection));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetectionControl));
        prepareRead(getProperty(utsDot3OltPortTransmissionPower));
        prepareRead(getProperty(utsDot3OltPortReceivingPower));
        prepareRead(getProperty(utsDot3OltPortRealtimeMulticastTraffic));
        prepareRead(getProperty(utsDot3OltPortSupplyVoltage));
        prepareRead(getProperty(utsDot3OltPortCurrentBias));
        prepareRead(getProperty(utsDot3OltPortCurrentTemperature));
        prepareRead(getProperty(utsDot3OltPortFlexQinQSwitch)); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        prepareRead(getProperty(utsDot3OltPortONUSNumberSwitch));

        return loadAll(new int[]{1, 1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OltAdminState));
        prepareSave(getProperty(utsDot3OltTxFECEnable));
        prepareSave(getProperty(utsDot3OltTransceiverTx));
        prepareSave(getProperty(utsDot3OltTransceiverRx));
        //prepareSave(getProperty(utsDot3OltONUP2PEnable));
        prepareSave(getProperty(utsDot3OltMPCPGateBackoffTime));
        prepareSave(getProperty(utsDot3OltP2pEnable));
        prepareSave(getProperty(utsDot3OltOlpPort));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetection));
        prepareRead(getProperty(utsDot3OltPortLoopbackDetectionControl));
        prepareSave(getProperty(utsDot3OltPortFlexQinQSwitch)); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        prepareSave(getProperty(utsDot3OltPortONUSNumberSwitch));

        return save();
    }

}