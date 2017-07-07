/**
 * Created by Zhou Chao, 2010/4/30
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r220;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class Dot3Onu2CtcTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
    public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
    public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
    public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
    public static final String utsDot3Onu2CtcLlid = "utsDot3Onu2CtcLlid";
    public static final String utsDot3Onu2CtcOui = "utsDot3Onu2CtcOui";
    public static final String utsDot3Onu2CtcOamExtVersion = "utsDot3Onu2CtcOamExtVersion";
    public static final String utsDot3Onu2CtcSerialNumber = "utsDot3Onu2CtcSerialNumber";
    public static final String utsDot3Onu2CtcFwVer = "utsDot3Onu2CtcFwVer";
    public static final String utsDot3Onu2CtcChipsetId = "utsDot3Onu2CtcChipsetId";
    public static final String ctcServiceSupported = "CtcServiceSupported";
    public static final String utsDot3Onu2CtcGEPortNumber = "utsDot3Onu2CtcGEPortNumber";
    public static final String utsDot3Onu2CtcGEPortList = "utsDot3Onu2CtcGEPortList";
    public static final String utsDot3Onu2CtcFEPortNumber = "utsDot3Onu2CtcFEPortNumber";
    public static final String utsDot3Onu2CtcFEPortList = "utsDot3Onu2CtcFEPortList";
    public static final String utsDot3Onu2CtcPOTSPortNumber = "utsDot3Onu2CtcPOTSPortNumber";
    public static final String utsDot3Onu2CtcPOTSPortList = "utsDot3Onu2CtcPOTSPortList";
    public static final String utsDot3Onu2CtcE1PortNumber = "utsDot3Onu2CtcE1PortNumber";
    public static final String utsDot3Onu2CtcE1PortList = "utsDot3Onu2CtcE1PortList";
    //public static final String utsDot3Onu2CtcUpsQueueNum = "utsDot3Onu2CtcUpsQueueNum";
    //public static final String utsDot3Onu2CtcMaxUpsQueueNum = "utsDot3Onu2CtcMaxUpsQueueNum";
    //public static final String utsDot3Onu2CtcDownsQueueNum = "utsDot3Onu2CtcDownsQueueNum";
    //public static final String utsDot3Onu2CtcMaxDownsQueueNum = "utsDot3Onu2CtcMaxDownsQueueNum";
    public static final String utsDot3Onu2CtcBatteryInstalled = "utsDot3Onu2CtcBatteryInstalled";
    public static final String utsDot3Onu2CtcFECAbility = "utsDot3Onu2CtcFECAbility";
    public static final String utsDot3Onu2CtcFECMode = "utsDot3Onu2CtcFECMode";
    public static final String utsDot3Onu2CtcClassifiRuleClear = "utsDot3Onu2CtcClassifiRuleClear";
    public static final String utsDot3Onu2CtcMulticastSwitch = "utsDot3Onu2CtcMulticastSwitch";
    public static final String utsDot3Onu2CtcMCastControlType = "utsDot3Onu2CtcMCastControlType";
    public static final String utsDot3Onu2CtcMCastEntryNum = "utsDot3Onu2CtcMCastEntryNum";
    public static final String utsDot3Onu2CtcMCastEntryClear = "utsDot3Onu2CtcMCastEntryClear";
    public static final String utsDot3Onu2CtcReset = "utsDot3Onu2CtcReset";
    public static final String utsDot3Onu2CtcRegisterStatus = "utsDot3Onu2CtcRegisterStatus";
    public static final String utsDot3Onu2CtcEncryptTraffic = "utsDot3Onu2CtcEncryptTraffic";
    public static final String utsDot3Onu2CtcFDBAgingTime = "utsDot3Onu2CtcFDBAgingTime";
    public static final String utsDot3Onu2CtcFDBClear = "utsDot3Onu2CtcFDBClear";
    public static final String utsDot3Onu2CtcAdmin = "utsDot3Onu2CtcAdmin";
    public static final String utsDot3Onu2CtcRTT = "utsDot3Onu2CtcRTT";
    public static final String utsDot3Onu2CtcPVid = "utsDot3Onu2CtcPVid";
    public static final String utsDot3Onu2CtcMaxMacAddress = "utsDot3Onu2CtcMaxMacAddress";
    //public static final String utsDot3Onu2CtcVoIPPortLock = "utsDot3Onu2CtcVoIPPortLock";
    //public static final String utsDot3Onu2CtcE1PortLock = "utsDot3Onu2CtcE1PortLock";
    public static final String utsDot3Onu2CtcDistance = "utsDot3Onu2CtcDistance";
    //public static final String utsDot3Onu2FastLeaveAbility = "utsDot3Onu2FastLeaveAbility";
    //public static final String utsDot3Onu2FastLeaveAdminControl = "utsDot3Onu2FastLeaveAdminControl";
    public static final String utsDot3Onu2EthernetPortAlarmReversion = "utsDot3Onu2EthernetPortAlarmReversion";
    //public static final String utsDot3Onu2MulticastFilter = "utsDot3Onu2MulticastFilter";
    //public static final String utsDot3Onu2FlexQinQSwitch = "utsDot3Onu2FlexQinQSwitch"; //added by Zhou Chao, 2008/8/4
    //public static final String utsDot3Onu2SNumberValid = "utsDot3Onu2SNumberValid"; //added by Zhou Chao, 2008/12/10
    //public static final String utsDot3Onu2SNumberForService = "utsDot3Onu2SNumberForService"; //added by Zhou Chao, 2008/12/10
    public static final String utsDot3Onu2dot1xUserName = "utsDot3Onu2dot1xUserName"; //added by Zhou Chao, 2008/12/10
    public static final String utsDot3Onu2dot1xPassword = "utsDot3Onu2dot1xPassword"; //added by Zhou Chao, 2008/12/10
    //public static final String utsDot3Onu2LoidAuthLoid = "utsDot3Onu2LoidAuthLoid"; //added by Zhou Chao, 2010/4/30
    //public static final String utsDot3Onu2LoidAuthPassword = "utsDot3Onu2LoidAuthPassword"; //added by Zhou Chao, 2010/4/30
    //public static final String utsDot3OnuCatvSwitch = "utsDot3OnuCatvSwitch"; //added by Zhou Chao, 2010/4/30

    private String onuLabel = null;

    /**
     *  Indicating whether the onu has been registered once or not.
     *  The init value is 0 when the records create, for example, just bound ONU, the value shall be 0, if the ONU registered, change the value to 1.
     *  if the records is created by ONU registered event, the value will be 1;
     *  the value will be reset to 0 until recieve the unbound event.
     */
    private int registeredever;

    private boolean isDyingGasp;

    public static final int STATUS_NOT_EXIST = 0;
    public static final int STATUS_ON_LINE = 1;
    public static final int STATUS_OFF_LINE = 2;
    private int status = STATUS_NOT_EXIST;

    public Dot3Onu2CtcTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLlid, new SnmpMibBeanProperty(utsDot3Onu2CtcLlid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcOui, new SnmpMibBeanProperty(utsDot3Onu2CtcOui, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.6", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcOamExtVersion, new SnmpMibBeanProperty(utsDot3Onu2CtcOamExtVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSerialNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcSerialNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.8", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcFwVer, new SnmpMibBeanProperty(utsDot3Onu2CtcFwVer, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.9", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcChipsetId, new SnmpMibBeanProperty(utsDot3Onu2CtcChipsetId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.10", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcGEPortNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcGEPortNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcGEPortList, new SnmpMibBeanProperty(utsDot3Onu2CtcGEPortList, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.12", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcFEPortNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcFEPortNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.13", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFEPortList, new SnmpMibBeanProperty(utsDot3Onu2CtcFEPortList, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.14", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcPOTSPortNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcPOTSPortNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.15", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPOTSPortList, new SnmpMibBeanProperty(utsDot3Onu2CtcPOTSPortList, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.16", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcE1PortNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcE1PortNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.17", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcE1PortList, new SnmpMibBeanProperty(utsDot3Onu2CtcE1PortList, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.18", ISnmpConstant.OCTETS));
        //initProperty(utsDot3Onu2CtcUpsQueueNum, new SnmpMibBeanProperty(utsDot3Onu2CtcUpsQueueNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.19", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcMaxUpsQueueNum, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxUpsQueueNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.20", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcDownsQueueNum, new SnmpMibBeanProperty(utsDot3Onu2CtcDownsQueueNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.21", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcMaxDownsQueueNum, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxDownsQueueNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.22", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcBatteryInstalled, new SnmpMibBeanProperty(utsDot3Onu2CtcBatteryInstalled, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.23", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFECAbility, new SnmpMibBeanProperty(utsDot3Onu2CtcFECAbility, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.24", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFECMode, new SnmpMibBeanProperty(utsDot3Onu2CtcFECMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.25", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcClassifiRuleClear, new SnmpMibBeanProperty(utsDot3Onu2CtcClassifiRuleClear, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.26", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMulticastSwitch, new SnmpMibBeanProperty(utsDot3Onu2CtcMulticastSwitch, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.27", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMCastControlType, new SnmpMibBeanProperty(utsDot3Onu2CtcMCastControlType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.28", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMCastEntryNum, new SnmpMibBeanProperty(utsDot3Onu2CtcMCastEntryNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.29", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMCastEntryClear, new SnmpMibBeanProperty(utsDot3Onu2CtcMCastEntryClear, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.30", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcReset, new SnmpMibBeanProperty(utsDot3Onu2CtcReset, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.32", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcRegisterStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcRegisterStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.33", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcEncryptTraffic, new SnmpMibBeanProperty(utsDot3Onu2CtcEncryptTraffic, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.34", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFDBAgingTime, new SnmpMibBeanProperty(utsDot3Onu2CtcFDBAgingTime, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.35", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcFDBClear, new SnmpMibBeanProperty(utsDot3Onu2CtcFDBClear, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.36", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcAdmin, new SnmpMibBeanProperty(utsDot3Onu2CtcAdmin, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.37", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcRTT, new SnmpMibBeanProperty(utsDot3Onu2CtcRTT, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.38", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPVid, new SnmpMibBeanProperty(utsDot3Onu2CtcPVid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.39", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMaxMacAddress, new SnmpMibBeanProperty(utsDot3Onu2CtcMaxMacAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.40", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcVoIPPortLock, new SnmpMibBeanProperty(utsDot3Onu2CtcVoIPPortLock, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.50", ISnmpConstant.OCTETS));
        //initProperty(utsDot3Onu2CtcE1PortLock, new SnmpMibBeanProperty(utsDot3Onu2CtcE1PortLock, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.51", ISnmpConstant.OCTETS));
        //initProperty(utsDot3Onu2FastLeaveAbility, new SnmpMibBeanProperty(utsDot3Onu2FastLeaveAbility, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.54", ISnmpConstant.OCTETS));
        //initProperty(utsDot3Onu2FastLeaveAdminControl, new SnmpMibBeanProperty(utsDot3Onu2FastLeaveAdminControl, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.55", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2EthernetPortAlarmReversion, new SnmpMibBeanProperty(utsDot3Onu2EthernetPortAlarmReversion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.56", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2MulticastFilter, new SnmpMibBeanProperty(utsDot3Onu2MulticastFilter, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.58", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2FlexQinQSwitch, new SnmpMibBeanProperty(utsDot3Onu2FlexQinQSwitch, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.60", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/8/4
        //initProperty(utsDot3Onu2SNumberValid, new SnmpMibBeanProperty(utsDot3Onu2SNumberValid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.61", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2008/12/10
        //initProperty(utsDot3Onu2SNumberForService, new SnmpMibBeanProperty(utsDot3Onu2SNumberForService, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.62", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10
        initProperty(utsDot3Onu2dot1xUserName, new SnmpMibBeanProperty(utsDot3Onu2dot1xUserName, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.66", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10
        initProperty(utsDot3Onu2dot1xPassword, new SnmpMibBeanProperty(utsDot3Onu2dot1xPassword, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.68", ISnmpConstant.STRING)); //added by Zhou Chao, 2008/12/10
        //initProperty(utsDot3Onu2LoidAuthLoid, new SnmpMibBeanProperty(utsDot3Onu2LoidAuthLoid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.71", ISnmpConstant.STRING)); //added by Zhou Chao, 2010/4/30
        //initProperty(utsDot3Onu2LoidAuthPassword, new SnmpMibBeanProperty(utsDot3Onu2LoidAuthPassword, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.72", ISnmpConstant.STRING)); //added by Zhou Chao, 2010/4/30
        //initProperty(utsDot3OnuCatvSwitch, new SnmpMibBeanProperty(utsDot3OnuCatvSwitch, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.101", ISnmpConstant.INTEGER)); //added by Zhou Chao, 2010/4/30

        initProperty(utsDot3Onu2CtcDistance, new SnmpMibBeanProperty(utsDot3Onu2CtcDistance, "", ISnmpConstant.STRING));
    }

    public Integer getUtsDot3Onu2CtcModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
        setIndex(0, aUtsDot3Onu2CtcModuleId);
    }

    public Integer getUtsDot3Onu2CtcDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcDeviceId);
    }

    public Integer getUtsDot3Onu2CtcPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
        setIndex(2, aUtsDot3Onu2CtcPortId);
    }

    public Integer getUtsDot3Onu2CtcLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcLogicalPortId(Integer aUtsDot3Onu2CtcLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcLlid() {
        return (Integer) getProperty(utsDot3Onu2CtcLlid).getValue();
    }

    public void setUtsDot3Onu2CtcLlid(Integer aUtsDot3Onu2CtcLlid) {
        getProperty(utsDot3Onu2CtcLlid).setValue(aUtsDot3Onu2CtcLlid);
    }

    public String getUtsDot3Onu2CtcOui() {
        return (String) getProperty(utsDot3Onu2CtcOui).getValue();
    }

    public void setUtsDot3Onu2CtcOui(String aUtsDot3Onu2CtcOui) {
        getProperty(utsDot3Onu2CtcOui).setValue(aUtsDot3Onu2CtcOui);
    }

    public Integer getUtsDot3Onu2CtcOamExtVersion() {
        return (Integer) getProperty(utsDot3Onu2CtcOamExtVersion).getValue();
    }

    public void setUtsDot3Onu2CtcOamExtVersion(Integer aUtsDot3Onu2CtcOamExtVersion) {
        getProperty(utsDot3Onu2CtcOamExtVersion).setValue(aUtsDot3Onu2CtcOamExtVersion);
    }

    public byte[] getUtsDot3Onu2CtcSerialNumber() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public void setUtsDot3Onu2CtcSerialNumber(byte[] aUtsDot3Onu2CtcSerialNumber2) {
        getProperty(utsDot3Onu2CtcSerialNumber).setValue(aUtsDot3Onu2CtcSerialNumber2);
    }

    public byte[] getUtsDot3Onu2CtcOnuVendor() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuModel() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuMacAddr() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuHardwareVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuSoftwareVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcFwVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcFwVer).getValue();
    }

    public void setUtsDot3Onu2CtcFwVer(byte[] aUtsDot3Onu2CtcFwVersion2) {
        getProperty(utsDot3Onu2CtcFwVer).setValue(aUtsDot3Onu2CtcFwVersion2);
    }

    public byte[] getUtsDot3Onu2CtcChipsetId() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipVendor() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipModel() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipRevision() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public void setUtsDot3Onu2CtcChipsetId(byte[] aUtsDot3Onu2CtcChipsetId) {
        getProperty(utsDot3Onu2CtcChipsetId).setValue(aUtsDot3Onu2CtcChipsetId);
    }

    public String getCtcServiceSupported() {
        StringBuffer sb = new StringBuffer();
        List tmpList = new ArrayList(4);
        if (getUtsDot3Onu2CtcFEPortNumber() > 0) {
            tmpList.add("FE");
        }
        if (getUtsDot3Onu2CtcGEPortNumber() > 0) {
            tmpList.add("GE");
        }
        if (getUtsDot3Onu2CtcPOTSPortNumber() > 0) {
            tmpList.add("VoIP");
        }
        if (getUtsDot3Onu2CtcE1PortNumber() > 0) {
            tmpList.add("E1");
        }

        if (tmpList.size() <= 0) {
            return "none";
        } else {
            int i = 0;
            for (; i < tmpList.size() - 1; i++) {
                sb.append(tmpList.get(i)).append(" + ");
            }
            sb.append(tmpList.get(i));
        }

        return sb.toString();
    }

    //public void setCtcServiceSupported(String actcServiceSupported) {
    //    getProperty(ctcServiceSupported).setValue(actcServiceSupported);
    //}

    public Integer getUtsDot3Onu2CtcGEPortNumber() {
        return (Integer) getProperty(utsDot3Onu2CtcGEPortNumber).getValue();
    }

    public void setUtsDot3Onu2CtcGEPortNumber(Integer aUtsDot3Onu2CtcGEPortNumber) {
        getProperty(utsDot3Onu2CtcGEPortNumber).setValue(aUtsDot3Onu2CtcGEPortNumber);
    }

    public byte[] getUtsDot3Onu2CtcGEPortList() {
        return (byte[]) getProperty(utsDot3Onu2CtcGEPortList).getValue();
    }

    public void setUtsDot3Onu2CtcGEPortList(byte[] aUtsDot3Onu2CtcGEPortList) {
        getProperty(utsDot3Onu2CtcGEPortList).setValue(aUtsDot3Onu2CtcGEPortList);
    }

    public Integer getUtsDot3Onu2CtcFEPortNumber() {
        return (Integer) getProperty(utsDot3Onu2CtcFEPortNumber).getValue();
    }

    public void setUtsDot3Onu2CtcFEPortNumber(Integer aUtsDot3Onu2CtcFEPortNumber) {
        getProperty(utsDot3Onu2CtcFEPortNumber).setValue(aUtsDot3Onu2CtcFEPortNumber);
    }

    public byte[] getUtsDot3Onu2CtcFEPortList() {
        return (byte[]) getProperty(utsDot3Onu2CtcFEPortList).getValue();
    }

    public void setUtsDot3Onu2CtcFEPortList(byte[] aUtsDot3Onu2CtcFEPortList) {
        getProperty(utsDot3Onu2CtcFEPortList).setValue(aUtsDot3Onu2CtcFEPortList);
    }

    public Integer getUtsDot3Onu2CtcPOTSPortNumber() {
        return (Integer) getProperty(utsDot3Onu2CtcPOTSPortNumber).getValue();
    }

    public void setUtsDot3Onu2CtcPOTSPortNumber(Integer aUtsDot3Onu2CtcPOTSPortNumber) {
        getProperty(utsDot3Onu2CtcPOTSPortNumber).setValue(aUtsDot3Onu2CtcPOTSPortNumber);
    }

    public byte[] getUtsDot3Onu2CtcPOTSPortList() {
        return (byte[]) getProperty(utsDot3Onu2CtcPOTSPortList).getValue();
    }

    public void setUtsDot3Onu2CtcPOTSPortList(byte[] aUtsDot3Onu2CtcPOTSPortList) {
        getProperty(utsDot3Onu2CtcPOTSPortList).setValue(aUtsDot3Onu2CtcPOTSPortList);
    }

    public Integer getUtsDot3Onu2CtcE1PortNumber() {
        return (Integer) getProperty(utsDot3Onu2CtcE1PortNumber).getValue();
    }

    public void setUtsDot3Onu2CtcE1PortNumber(Integer aUtsDot3Onu2CtcE1PortNumber) {
        getProperty(utsDot3Onu2CtcE1PortNumber).setValue(aUtsDot3Onu2CtcE1PortNumber);
    }

    public byte[] getUtsDot3Onu2CtcE1PortList() {
        return (byte[]) getProperty(utsDot3Onu2CtcE1PortList).getValue();
    }

    public void setUtsDot3Onu2CtcE1PortList(byte[] aUtsDot3Onu2CtcE1PortList) {
        getProperty(utsDot3Onu2CtcE1PortList).setValue(aUtsDot3Onu2CtcE1PortList);
    }

    /*
    public Integer getUtsDot3Onu2CtcUpsQueueNum() {
        return (Integer) getProperty(utsDot3Onu2CtcUpsQueueNum).getValue();
    }

    public void setUtsDot3Onu2CtcUpsQueueNum(Integer aUtsDot3Onu2CtcUpsQueueNum) {
        getProperty(utsDot3Onu2CtcUpsQueueNum).setValue(aUtsDot3Onu2CtcUpsQueueNum);
    }

    public Integer getUtsDot3Onu2CtcMaxUpsQueueNum() {
        return (Integer) getProperty(utsDot3Onu2CtcMaxUpsQueueNum).getValue();
    }

    public void setUtsDot3Onu2CtcMaxUpsQueueNum(Integer aUtsDot3Onu2CtcMaxUpsQueueNum) {
        getProperty(utsDot3Onu2CtcMaxUpsQueueNum).setValue(aUtsDot3Onu2CtcMaxUpsQueueNum);
    }

    public Integer getUtsDot3Onu2CtcDownsQueueNum() {
        return (Integer) getProperty(utsDot3Onu2CtcDownsQueueNum).getValue();
    }

    public void setUtsDot3Onu2CtcDownsQueueNum(Integer aUtsDot3Onu2CtcDownsQueueNum) {
        getProperty(utsDot3Onu2CtcDownsQueueNum).setValue(aUtsDot3Onu2CtcDownsQueueNum);
    }

    public Integer getUtsDot3Onu2CtcMaxDownsQueueNum() {
        return (Integer) getProperty(utsDot3Onu2CtcMaxDownsQueueNum).getValue();
    }

    public void setUtsDot3Onu2CtcMaxDownsQueueNum(Integer aUtsDot3Onu2CtcMaxDownsQueueNum) {
        getProperty(utsDot3Onu2CtcMaxDownsQueueNum).setValue(aUtsDot3Onu2CtcMaxDownsQueueNum);
    }
    */

    public Integer getUtsDot3Onu2CtcBatteryInstalled() {
        return (Integer) getProperty(utsDot3Onu2CtcBatteryInstalled).getValue();
    }

    public void setUtsDot3Onu2CtcBatteryInstalled(Integer aUtsDot3Onu2CtcBatteryInstalled) {
        getProperty(utsDot3Onu2CtcBatteryInstalled).setValue(aUtsDot3Onu2CtcBatteryInstalled);
    }

    public Integer getUtsDot3Onu2CtcFECAbility() {
        return (Integer) getProperty(utsDot3Onu2CtcFECAbility).getValue();
    }

    public void setUtsDot3Onu2CtcFECAbility(Integer aUtsDot3Onu2CtcFECAbility) {
        getProperty(utsDot3Onu2CtcFECAbility).setValue(aUtsDot3Onu2CtcFECAbility);
    }

    public Integer getUtsDot3Onu2CtcFECMode() {
        return (Integer) getProperty(utsDot3Onu2CtcFECMode).getValue();
    }

    public void setUtsDot3Onu2CtcFECMode(Integer aUtsDot3Onu2CtcFECMode) {
        getProperty(utsDot3Onu2CtcFECMode).setValue(aUtsDot3Onu2CtcFECMode);
    }

    public Integer getUtsDot3Onu2CtcClassifiRuleClear() {
        return (Integer) getProperty(utsDot3Onu2CtcClassifiRuleClear).getValue();
    }

    public void setUtsDot3Onu2CtcClassifiRuleClear(Integer aUtsDot3Onu2CtcClassifiRuleClear) {
        getProperty(utsDot3Onu2CtcClassifiRuleClear).setValue(aUtsDot3Onu2CtcClassifiRuleClear);
    }

    public Integer getUtsDot3Onu2CtcMulticastSwitch() {
        return (Integer) getProperty(utsDot3Onu2CtcMulticastSwitch).getValue();
    }

    public void setUtsDot3Onu2CtcMulticastSwitch(Integer aUtsDot3Onu2CtcMulticastSwitch) {
        getProperty(utsDot3Onu2CtcMulticastSwitch).setValue(aUtsDot3Onu2CtcMulticastSwitch);
    }

    public Integer getUtsDot3Onu2CtcMCastControlType() {
        return (Integer) getProperty(utsDot3Onu2CtcMCastControlType).getValue();
    }

    public void setUtsDot3Onu2CtcMCastControlType(Integer aUtsDot3Onu2CtcMCastControlType) {
        getProperty(utsDot3Onu2CtcMCastControlType).setValue(aUtsDot3Onu2CtcMCastControlType);
    }

    public Integer getUtsDot3Onu2CtcMCastEntryNum() {
        return (Integer) getProperty(utsDot3Onu2CtcMCastEntryNum).getValue();
    }

    public void setUtsDot3Onu2CtcMCastEntryNum(Integer aUtsDot3Onu2CtcMCastEntryNum) {
        getProperty(utsDot3Onu2CtcMCastEntryNum).setValue(aUtsDot3Onu2CtcMCastEntryNum);
    }

    public Integer getUtsDot3Onu2CtcMCastEntryClear() {
        return (Integer) getProperty(utsDot3Onu2CtcMCastEntryClear).getValue();
    }

    public void setUtsDot3Onu2CtcMCastEntryClear(Integer aUtsDot3Onu2CtcMCastEntryClear) {
        getProperty(utsDot3Onu2CtcMCastEntryClear).setValue(aUtsDot3Onu2CtcMCastEntryClear);
    }

    public Integer getUtsDot3Onu2CtcReset() {
        return (Integer) getProperty(utsDot3Onu2CtcReset).getValue();
    }

    public void setUtsDot3Onu2CtcReset(Integer aUtsDot3Onu2CtcReset3) {
        getProperty(utsDot3Onu2CtcReset).setValue(aUtsDot3Onu2CtcReset3);
    }

    public Integer getUtsDot3Onu2CtcRegisterStatus() {
        return (Integer) getProperty(utsDot3Onu2CtcRegisterStatus).getValue();
    }

    public void setUtsDot3Onu2CtcRegisterStatus(Integer aUtsDot3Onu2CtcRegisterStatus) {
        getProperty(utsDot3Onu2CtcRegisterStatus).setValue(aUtsDot3Onu2CtcRegisterStatus);
    }

    public Integer getUtsDot3Onu2CtcEncryptTraffic() {
        return (Integer) getProperty(utsDot3Onu2CtcEncryptTraffic).getValue();
    }

    public void setUtsDot3Onu2CtcEncryptTraffic(Integer aUtsDot3Onu2CtcEncryptTraffic) {
        getProperty(utsDot3Onu2CtcEncryptTraffic).setValue(aUtsDot3Onu2CtcEncryptTraffic);
    }

    public Integer getUtsDot3Onu2CtcFDBAgingTime() {
        return (Integer) getProperty(utsDot3Onu2CtcFDBAgingTime).getValue();
    }

    public void setUtsDot3Onu2CtcFDBAgingTime(Integer aUtsDot3Onu2CtcFDBAgingTime) {
        getProperty(utsDot3Onu2CtcFDBAgingTime).setValue(aUtsDot3Onu2CtcFDBAgingTime);
    }

    public Integer getUtsDot3Onu2CtcFDBClear() {
        return (Integer) getProperty(utsDot3Onu2CtcFDBClear).getValue();
    }

    public void setUtsDot3Onu2CtcFDBClear(Integer aUtsDot3Onu2CtcFDBClear) {
        getProperty(utsDot3Onu2CtcFDBClear).setValue(aUtsDot3Onu2CtcFDBClear);
    }

    public Integer getUtsDot3Onu2CtcAdmin() {
        return (Integer) getProperty(utsDot3Onu2CtcAdmin).getValue();
    }

    public void setUtsDot3Onu2CtcAdmin(Integer aUtsDot3Onu2CtcAdmin) {
        getProperty(utsDot3Onu2CtcAdmin).setValue(aUtsDot3Onu2CtcAdmin);
    }

    public Integer getUtsDot3Onu2CtcRTT() {
        return (Integer) getProperty(utsDot3Onu2CtcRTT).getValue();
    }

    public void setUtsDot3Onu2CtcRTT(Integer aUtsDot3Onu2CtcRTT) {
        getProperty(utsDot3Onu2CtcRTT).setValue(aUtsDot3Onu2CtcRTT);
    }

    public String getUtsDot3Onu2CtcDistance() {
        return (String) getProperty(utsDot3Onu2CtcDistance).getValue();
    }

    public void setUtsDot3Onu2CtcDistance(String aUtsDot3Onu2CtcDistance) {
        getProperty(utsDot3Onu2CtcDistance).setValue(aUtsDot3Onu2CtcDistance);
    }

    public Integer getUtsDot3Onu2CtcPVid() {
        return (Integer) getProperty(utsDot3Onu2CtcPVid).getValue();
    }

    public void setUtsDot3Onu2CtcPVid(Integer aUtsDot3Onu2CtcPVid) {
        getProperty(utsDot3Onu2CtcPVid).setValue(aUtsDot3Onu2CtcPVid);
    }

    public Integer getUtsDot3Onu2CtcMaxMacAddress() {
        return (Integer) getProperty(utsDot3Onu2CtcMaxMacAddress).getValue();
    }

    public void setUtsDot3Onu2CtcMaxMacAddress(Integer aUtsDot3Onu2CtcMaxMacAddress) {
        getProperty(utsDot3Onu2CtcMaxMacAddress).setValue(aUtsDot3Onu2CtcMaxMacAddress);
    }

    /*
    public byte[] getUtsDot3Onu2CtcVoIPPortLock() {
        return (byte[]) getProperty(utsDot3Onu2CtcVoIPPortLock).getValue();
    }

    public void setUtsDot3Onu2CtcVoIPPortLock(byte[] aUtsDot3Onu2CtcVoIPPortLock) {
        getProperty(utsDot3Onu2CtcVoIPPortLock).setValue(aUtsDot3Onu2CtcVoIPPortLock);
    }

    public byte[] getUtsDot3Onu2CtcE1PortLock() {
        return (byte[]) getProperty(utsDot3Onu2CtcE1PortLock).getValue();
    }

    public void setUtsDot3Onu2CtcE1PortLock(byte[] aUtsDot3Onu2CtcE1PortLock) {
        getProperty(utsDot3Onu2CtcE1PortLock).setValue(aUtsDot3Onu2CtcE1PortLock);
    }

    public byte[] getUtsDot3Onu2FastLeaveAbility() {
        return (byte[]) getProperty(utsDot3Onu2FastLeaveAbility).getValue();
    }

    public void setUtsDot3Onu2FastLeaveAbility(byte[] aUtsDot3Onu2FastLeaveAbility) {
        getProperty(utsDot3Onu2FastLeaveAbility).setValue(aUtsDot3Onu2FastLeaveAbility);
    }

    public Integer getUtsDot3Onu2FastLeaveAdminControl() {
        return (Integer) getProperty(utsDot3Onu2FastLeaveAdminControl).getValue();
    }

    public void setUtsDot3Onu2FastLeaveAdminControl(Integer aUtsDot3Onu2FastLeaveAdminControl) {
        getProperty(utsDot3Onu2FastLeaveAdminControl).setValue(aUtsDot3Onu2FastLeaveAdminControl);
    }
    */

    public Integer getUtsDot3Onu2EthernetPortAlarmReversion() {
        return (Integer) getProperty(utsDot3Onu2EthernetPortAlarmReversion).getValue();
    }

    public void setUtsDot3Onu2EthernetPortAlarmReversion(Integer aUtsDot3Onu2EthernetPortAlarmReversion) {
        getProperty(utsDot3Onu2EthernetPortAlarmReversion).setValue(aUtsDot3Onu2EthernetPortAlarmReversion);
    }

    /*
    public Integer getUtsDot3Onu2MulticastFilter() {
        return (Integer) getProperty(utsDot3Onu2MulticastFilter).getValue();
    }

    public void setUtsDot3Onu2MulticastFilter(Integer aUtsDot3Onu2MulticastFilter) {
        getProperty(utsDot3Onu2MulticastFilter).setValue(aUtsDot3Onu2MulticastFilter);
    }

    public Integer getUtsDot3Onu2FlexQinQSwitch() { //added by Zhou Chao, 2008/8/4
        return (Integer) getProperty(utsDot3Onu2FlexQinQSwitch).getValue();
    }

    public void setUtsDot3Onu2FlexQinQSwitch(Integer aUtsDot3Onu2FlexQinQSwitch) { //added by Zhou Chao, 2008/8/4
        getProperty(utsDot3Onu2FlexQinQSwitch).setValue(aUtsDot3Onu2FlexQinQSwitch);
    }
    */

    /*
    public Integer getUtsDot3Onu2SNumberValid() { //added by Zhou Chao, 2008/12/10
        return (Integer) getProperty(utsDot3Onu2SNumberValid).getValue();
    }

    public void setUtsDot3Onu2SNumberValid(Integer aUtsDot3Onu2SNumberValid) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2SNumberValid).setValue(aUtsDot3Onu2SNumberValid);
    }

    public String getUtsDot3Onu2SNumberForService() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2SNumberForService).getValue();
    }

    public void setUtsDot3Onu2SNumberForService(String aUtsDot3Onu2SNumberForService) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2SNumberForService).setValue(aUtsDot3Onu2SNumberForService);
    }
    */

    public String getUtsDot3Onu2dot1xUserName() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2dot1xUserName).getValue();
    }

    public void setUtsDot3Onu2dot1xUserName(String aUtsDot3Onu2dot1xUserName) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2dot1xUserName).setValue(aUtsDot3Onu2dot1xUserName);
    }

    public String getUtsDot3Onu2dot1xPassword() { //added by Zhou Chao, 2008/12/10
        return (String) getProperty(utsDot3Onu2dot1xPassword).getValue();
    }

    public void setUtsDot3Onu2dot1xPassword(String aUtsDot3Onu2dot1xPassword) { //added by Zhou Chao, 2008/12/10
        getProperty(utsDot3Onu2dot1xPassword).setValue(aUtsDot3Onu2dot1xPassword);
    }

    /*
    public String getUtsDot3Onu2LoidAuthLoid() { //added by Zhou Chao, 2010/4/30
        return (String) getProperty(utsDot3Onu2LoidAuthLoid).getValue();
    }

    public void setUtsDot3Onu2LoidAuthLoid(String aUtsDot3Onu2LoidAuthLoid) { //added by Zhou Chao, 2010/4/30
        getProperty(utsDot3Onu2LoidAuthLoid).setValue(aUtsDot3Onu2LoidAuthLoid);
    }

    public String getUtsDot3Onu2LoidAuthPassword() { //added by Zhou Chao, 2010/4/30
        return (String) getProperty(utsDot3Onu2LoidAuthPassword).getValue();
    }

    public void setUtsDot3Onu2LoidAuthPassword(String aUtsDot3Onu2LoidAuthPassword) { //added by Zhou Chao, 2010/4/30
        getProperty(utsDot3Onu2LoidAuthPassword).setValue(aUtsDot3Onu2LoidAuthPassword);
    }
    */

    /*
    public Integer getUtsDot3OnuCatvSwitch() { //added by Zhou Chao, 2010/4/30
        return (Integer) getProperty(utsDot3OnuCatvSwitch).getValue();
    }

    public void setUtsDot3OnuCatvSwitch(Integer aUtsDot3OnuCatvSwitch) { //added by Zhou Chao, 2010/4/30
        getProperty(utsDot3OnuCatvSwitch).setValue(aUtsDot3OnuCatvSwitch);
    }
    */

    public boolean resetONU() throws MibBeanException {
        setUtsDot3Onu2CtcReset(1);
        prepareSave(getProperty(utsDot3Onu2CtcReset));

        return save();
    }

    public String getOnuLabel() {
        return onuLabel;
    }

    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public int getRegisteredever() {
        return registeredever;
    }

    public void setRegisteredever(int registeredever) {
        this.registeredever = registeredever;
    }

    public boolean isDyingGasp() {
        return isDyingGasp;
    }

    public void setDyingGasp(boolean dyingGasp) {
        isDyingGasp = dyingGasp;
    }

    public int getUtsDot3Onu2CtcStatus() {
        return status;
    }

    public void setUtsDot3Onu2CtcStatus(int status) {
        this.status = status;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcLlid));
        //prepareRead(getProperty(utsDot3Onu2CtcOui));
        prepareRead(getProperty(utsDot3Onu2CtcOamExtVersion));
        prepareRead(getProperty(utsDot3Onu2CtcSerialNumber));
        prepareRead(getProperty(utsDot3Onu2CtcFwVer));
        prepareRead(getProperty(utsDot3Onu2CtcChipsetId));
        prepareRead(getProperty(utsDot3Onu2CtcGEPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcGEPortList));
        prepareRead(getProperty(utsDot3Onu2CtcFEPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcFEPortList));
        prepareRead(getProperty(utsDot3Onu2CtcPOTSPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcPOTSPortList));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortList));
        //prepareRead(getProperty(utsDot3Onu2CtcUpsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcMaxUpsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcDownsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcMaxDownsQueueNum));
        prepareRead(getProperty(utsDot3Onu2CtcBatteryInstalled));
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcMulticastSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcMCastControlType));
        prepareRead(getProperty(utsDot3Onu2CtcMCastEntryNum));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcFDBAgingTime));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRTT));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        //prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));
        //prepareRead(getProperty(utsDot3Onu2CtcE1PortLock));
        //prepareRead(getProperty(utsDot3Onu2FastLeaveAbility));
        //prepareRead(getProperty(utsDot3Onu2FastLeaveAdminControl));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        //prepareRead(getProperty(utsDot3Onu2MulticastFilter));
        //prepareRead(getProperty(utsDot3Onu2FlexQinQSwitch)); //added by Zhou Chao, 2008/8/4
        //prepareRead(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        //prepareRead(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10
        //prepareRead(getProperty(utsDot3Onu2LoidAuthLoid)); //added by Zhou Chao, 2010/4/30
        //prepareRead(getProperty(utsDot3Onu2LoidAuthPassword)); //added by Zhou Chao, 2010/4/30
        //prepareRead(getProperty(utsDot3OnuCatvSwitch)); //added by Zhou Chao, 2010/4/30

        boolean b = load();

        setUtsDot3Onu2CtcDistance(calc(getUtsDot3Onu2CtcRTT()));

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
//        String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//        GuiUtils.initDyingGaspInfo(neName);

        prepareRead(getProperty(utsDot3Onu2CtcLlid));
        //prepareRead(getProperty(utsDot3Onu2CtcOui));
        prepareRead(getProperty(utsDot3Onu2CtcOamExtVersion));
        prepareRead(getProperty(utsDot3Onu2CtcSerialNumber));
        prepareRead(getProperty(utsDot3Onu2CtcFwVer));
        prepareRead(getProperty(utsDot3Onu2CtcChipsetId));
        prepareRead(getProperty(utsDot3Onu2CtcGEPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcGEPortList));
        prepareRead(getProperty(utsDot3Onu2CtcFEPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcFEPortList));
        prepareRead(getProperty(utsDot3Onu2CtcPOTSPortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcPOTSPortList));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortNumber));
        prepareRead(getProperty(utsDot3Onu2CtcE1PortList));
        //prepareRead(getProperty(utsDot3Onu2CtcUpsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcMaxUpsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcDownsQueueNum));
        //prepareRead(getProperty(utsDot3Onu2CtcMaxDownsQueueNum));
        prepareRead(getProperty(utsDot3Onu2CtcBatteryInstalled));
        prepareRead(getProperty(utsDot3Onu2CtcFECAbility));
        prepareRead(getProperty(utsDot3Onu2CtcFECMode));
        prepareRead(getProperty(utsDot3Onu2CtcMulticastSwitch));
        prepareRead(getProperty(utsDot3Onu2CtcMCastControlType));
        prepareRead(getProperty(utsDot3Onu2CtcMCastEntryNum));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
        prepareRead(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareRead(getProperty(utsDot3Onu2CtcFDBAgingTime));
        prepareRead(getProperty(utsDot3Onu2CtcAdmin));
        prepareRead(getProperty(utsDot3Onu2CtcRTT));
        prepareRead(getProperty(utsDot3Onu2CtcPVid));
        prepareRead(getProperty(utsDot3Onu2CtcMaxMacAddress));
        //prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));
        //prepareRead(getProperty(utsDot3Onu2CtcE1PortLock));
        //prepareRead(getProperty(utsDot3Onu2FastLeaveAbility));
        //prepareRead(getProperty(utsDot3Onu2FastLeaveAdminControl));
        prepareRead(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        //prepareRead(getProperty(utsDot3Onu2MulticastFilter));
        //prepareRead(getProperty(utsDot3Onu2FlexQinQSwitch)); //added by Zhou Chao, 2008/8/4
        //prepareRead(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        //prepareRead(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareRead(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10
        //prepareRead(getProperty(utsDot3Onu2LoidAuthLoid)); //added by Zhou Chao, 2010/4/30
        //prepareRead(getProperty(utsDot3Onu2LoidAuthPassword)); //added by Zhou Chao, 2010/4/30
        //prepareRead(getProperty(utsDot3OnuCatvSwitch)); //added by Zhou Chao, 2010/4/30

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        for (int i = 0; i < v.size(); i++) {
            Dot3Onu2CtcTable bean = (Dot3Onu2CtcTable) v.get(i);
            bean.setUtsDot3Onu2CtcDistance(calc(bean.getUtsDot3Onu2CtcRTT()));
        }

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//                Map map = onuMgmtMgr.getONUDeviceMap(neName);
//
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcTable bean = (Dot3Onu2CtcTable) v.get(i);
//
//                    if (bean.getUtsDot3Onu2CtcRegisterStatus() != null && bean.getUtsDot3Onu2CtcRegisterStatus() == 1) {
//                        bean.setUtsDot3Onu2CtcStatus(STATUS_ON_LINE);
//                    } else {
//                        bean.setUtsDot3Onu2CtcStatus(STATUS_OFF_LINE);
//                    }
//
//                    //find the onu by mac address.
//                    String mac = Dot3Onu2CtcSerialNumberFormatter.getMacAddress(bean.getUtsDot3Onu2CtcSerialNumber());
//                    String key = new StringBuilder(neName).append(mac).toString();
//                    if ((!mac.equals("00-00-00-00-00-00")) && map.containsKey(key)) {
//                        ONUDevice onuDevice = (ONUDevice) map.get(key);
//                        bean.setOnuLabel(onuDevice.getLabel());
//                        bean.setRegisteredever(onuDevice.getRegisteredever());
//                        String entityInstance = bean.getUtsDot3Onu2CtcModuleId() + "-" + bean.getUtsDot3Onu2CtcPortId() + "-" + bean.getUtsDot3Onu2CtcLogicalPortId();
//                        bean.setDyingGasp(GuiUtils.isDyingGasp(neName, entityInstance));
//                    } else {
//                        //find the onu by module/port/logicalid
//                        key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcModuleId()).append("/").append(bean.getUtsDot3Onu2CtcPortId()).append("/").append(bean.getUtsDot3Onu2CtcLogicalPortId()).toString();
//                        if (map.containsKey(key)) {
//                            ONUDevice onuDevice = (ONUDevice) map.get(key);
//                            bean.setOnuLabel(onuDevice.getLabel());
//                            bean.setRegisteredever(onuDevice.getRegisteredever());
//                            String entityInstance = bean.getUtsDot3Onu2CtcModuleId() + "-" + bean.getUtsDot3Onu2CtcPortId() + "-" + bean.getUtsDot3Onu2CtcLogicalPortId();
//                            bean.setDyingGasp(GuiUtils.isDyingGasp(neName, entityInstance));
//                        } else {
//                            //not found in onu management system and not on line.
//                            if (bean.getUtsDot3Onu2CtcStatus() != STATUS_ON_LINE) {
//                                bean.setUtsDot3Onu2CtcStatus(STATUS_NOT_EXIST);
//                                bean.setRegisteredever(ONUDevice.registeredever_no);
//                                bean.setDyingGasp(false);
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    //fiber transmit delay is about 5us/km, that is about 5ns/m��one TQ is 16ns, so it should greater than 16/5=3.2m, and the single trip is 3.2/2=1.6m.
    protected String calc(Integer i) {
        if (i != null) {
            if (i > 60)
                return "" + (int) ((i - 60) * 1.6);
            else
                return "1";
        }

        return "1";
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcFECMode));
        prepareSave(getProperty(utsDot3Onu2CtcMulticastSwitch));
        prepareSave(getProperty(utsDot3Onu2CtcMCastControlType));
        prepareSave(getProperty(utsDot3Onu2CtcEncryptTraffic));
        prepareSave(getProperty(utsDot3Onu2CtcFDBAgingTime));
        prepareSave(getProperty(utsDot3Onu2CtcAdmin));
        //prepareSave(getProperty(utsDot3Onu2CtcPVid));
        prepareSave(getProperty(utsDot3Onu2CtcMaxMacAddress));
        //prepareSave(getProperty(utsDot3Onu2CtcVoIPPortLock));
        //prepareSave(getProperty(utsDot3Onu2CtcE1PortLock));
        //prepareSave(getProperty(utsDot3Onu2FastLeaveAdminControl));
        //prepareSave(getProperty(utsDot3Onu2EthernetPortAlarmReversion));
        //prepareSave(getProperty(utsDot3Onu2MulticastFilter));
        //prepareSave(getProperty(utsDot3Onu2FlexQinQSwitch)); //added by Zhou Chao, 2008/8/4
        //prepareSave(getProperty(utsDot3Onu2SNumberValid)); //added by Zhou Chao, 2008/12/10
        //prepareSave(getProperty(utsDot3Onu2SNumberForService)); //added by Zhou Chao, 2008/12/10
        prepareSave(getProperty(utsDot3Onu2dot1xUserName)); //added by Zhou Chao, 2008/12/10
        prepareSave(getProperty(utsDot3Onu2dot1xPassword)); //added by Zhou Chao, 2008/12/10
        //prepareSave(getProperty(utsDot3Onu2LoidAuthLoid)); //added by Zhou Chao, 2010/4/30
        //prepareSave(getProperty(utsDot3Onu2LoidAuthPassword)); //added by Zhou Chao, 2010/4/30
        //prepareSave(getProperty(utsDot3OnuCatvSwitch)); //added by Zhou Chao, 2010/4/30

        return save();
    }

    public SnmpMibBean encode(Properties property) {
        Dot3Onu2CtcTable one = (Dot3Onu2CtcTable) this.clone();
        if (property.getProperty(utsDot3Onu2CtcModuleId) != null) {
            one.setUtsDot3Onu2CtcModuleId(new Integer(property.getProperty(utsDot3Onu2CtcModuleId)));
        }
        one.setUtsDot3Onu2CtcDeviceId(1);
        if (property.getProperty(utsDot3Onu2CtcPortId) != null) {
            one.setUtsDot3Onu2CtcPortId(new Integer(property.getProperty(utsDot3Onu2CtcPortId)));
        }
        if (property.getProperty(utsDot3Onu2CtcLogicalPortId) != null) {
            one.setUtsDot3Onu2CtcLogicalPortId(new Integer(property.getProperty(utsDot3Onu2CtcLogicalPortId)));
        }
        try {
            one.retrieve();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return one;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dot3Onu2CtcTable) {
            Dot3Onu2CtcTable bean = (Dot3Onu2CtcTable) obj;
            for (int i = 0; i < 4; i++) {
                if ((this.getIndex(i) == null) || (bean.getIndex(i) == null) || (!this.getIndex(i).equals(bean.getIndex(i)))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public String toString() {
        return new StringBuffer().append(getUtsDot3Onu2CtcModuleId()).append("-").append(getUtsDot3Onu2CtcDeviceId()).append("-").append(getUtsDot3Onu2CtcPortId()).append("-").append(getUtsDot3Onu2CtcLogicalPortId()).toString();
    }

    /**
     * Add by Li Pengpeng for MR:ONS00042143
     *
     * @param @return
     * @throws
     * @Description: only retrieve 2 property for improve the performance
     */
    public Vector retrieveOnlineInfo() {
        // ONU Name: getUtsDot3Onu2CtcOnuModel will use it
        prepareRead(getProperty(utsDot3Onu2CtcSerialNumber));
        // Online status will use it
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));

        int rowsPerFetch = getRowsPerFetch();
        setRowsPerFetch(50);
        Vector loadAll = loadAll(new int[]{1, 1, 1, 1});
        setRowsPerFetch(rowsPerFetch);
        return loadAll;
    }

}