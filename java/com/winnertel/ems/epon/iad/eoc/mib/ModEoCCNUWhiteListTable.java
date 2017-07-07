package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCCNUWhiteListTable class.
 * Created by QuickDVM
 */
public class ModEoCCNUWhiteListTable extends EocBaseSnmpMibBean {
    public static final String modEoCCNUWhiteListIndex = "modEoCCNUWhiteListIndex";
    //    public static final String modEoCCNUWhiteListIPAddress = "modEoCCNUWhiteListIPAddress";
    public static final String modEoCCNUWhiteListMACAddress = "modEoCCNUWhiteListMACAddress";
    public static final String modEoCCNUWhiteListAuthorization = "modEoCCNUWhiteListAuthorization";
    public static final String modEoCCNUWhiteListRFOutputLevel = "modEoCCNUWhiteListRFOutputLevel";
    public static final String modEoCCNUWhiteListAutoUpgradeEN = "modEoCCNUWhiteListAutoUpgradeEN";
    public static final String modEoCCNUWhiteListRegisterOnlineStatus = "modEoCCNUWhiteListRegisterOnlineStatus";
    public static final String modEoCCNUWhiteListStartTime = "modEoCCNUWhiteListStartTime";
    public static final String modEoCCNUWhiteListEndTime = "modEoCCNUWhiteListEndTime";


    public ModEoCCNUWhiteListTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCCNUWhiteListIndex, new SnmpMibBeanProperty(modEoCCNUWhiteListIndex, MIB_Head1 + ".5.1.6.1.1", ISnmpConstant.INTEGER));
//        initProperty(modEoCCNUWhiteListIPAddress, new SnmpMibBeanProperty(modEoCCNUWhiteListIPAddress, MIB_Head1 + ".5.1.6.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(modEoCCNUWhiteListMACAddress, new SnmpMibBeanProperty(modEoCCNUWhiteListMACAddress, MIB_Head1 + ".5.1.6.1.3", ISnmpConstant.OCTETS));
        initProperty(modEoCCNUWhiteListAuthorization, new SnmpMibBeanProperty(modEoCCNUWhiteListAuthorization, MIB_Head1 + ".5.1.6.1.4", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListRFOutputLevel, new SnmpMibBeanProperty(modEoCCNUWhiteListRFOutputLevel, MIB_Head1 + ".5.1.6.1.5", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListAutoUpgradeEN, new SnmpMibBeanProperty(modEoCCNUWhiteListAutoUpgradeEN, MIB_Head1 + ".5.1.6.1.6", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListRegisterOnlineStatus, new SnmpMibBeanProperty(modEoCCNUWhiteListRegisterOnlineStatus, MIB_Head1 + ".5.1.6.1.7", ISnmpConstant.INTEGER));
        initProperty(modEoCCNUWhiteListStartTime, new SnmpMibBeanProperty(modEoCCNUWhiteListStartTime, MIB_Head1 + ".5.1.6.1.8", ISnmpConstant.TIME_TICKS));
        initProperty(modEoCCNUWhiteListEndTime, new SnmpMibBeanProperty(modEoCCNUWhiteListEndTime, MIB_Head1 + ".5.1.6.1.9", ISnmpConstant.TIME_TICKS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, MIB_Head1 + ".5.1.6.1.10", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCCNUWhiteListIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCCNUWhiteListIndex(Integer aModEoCCNUWhiteListIndex) {
        setIndex(0, aModEoCCNUWhiteListIndex);
    }


//    public String getModEoCCNUWhiteListIPAddress() {
//        return (String) getProperty(modEoCCNUWhiteListIPAddress).getValue();
//    }
//
//    public void setModEoCCNUWhiteListIPAddress(String aModEoCCNUWhiteListIPAddress) {
//        getProperty(modEoCCNUWhiteListIPAddress).setValue(aModEoCCNUWhiteListIPAddress);
//    }

    public byte[] getModEoCCNUWhiteListMACAddress() {
        return (byte[]) getProperty(modEoCCNUWhiteListMACAddress).getValue();
    }

    public void setModEoCCNUWhiteListMACAddress(byte[] aModEoCCNUWhiteListMACAddress) {
        getProperty(modEoCCNUWhiteListMACAddress).setValue(aModEoCCNUWhiteListMACAddress);
    }

    public Integer getModEoCCNUWhiteListAuthorization() {
        return (Integer) getProperty(modEoCCNUWhiteListAuthorization).getValue();
    }

    public void setModEoCCNUWhiteListAuthorization(Integer aModEoCCNUWhiteListAuthorization) {
        getProperty(modEoCCNUWhiteListAuthorization).setValue(aModEoCCNUWhiteListAuthorization);
    }

    public Integer getModEoCCNUWhiteListRFOutputLevel() {
        return (Integer) getProperty(modEoCCNUWhiteListRFOutputLevel).getValue();
    }

    public void setModEoCCNUWhiteListRFOutputLevel(Integer aModEoCCNUWhiteListRFOutputLevel) {
        getProperty(modEoCCNUWhiteListRFOutputLevel).setValue(aModEoCCNUWhiteListRFOutputLevel);
    }

    public Integer getModEoCCNUWhiteListAutoUpgradeEN() {
        return (Integer) getProperty(modEoCCNUWhiteListAutoUpgradeEN).getValue();
    }

    public void setModEoCCNUWhiteListAutoUpgradeEN(Integer aModEoCCNUWhiteListAutoUpgradeEN) {
        getProperty(modEoCCNUWhiteListAutoUpgradeEN).setValue(aModEoCCNUWhiteListAutoUpgradeEN);
    }

    public Integer getModEoCCNUWhiteListRegisterOnlineStatus() {
        return (Integer) getProperty(modEoCCNUWhiteListRegisterOnlineStatus).getValue();
    }

    public void setModEoCCNUWhiteListRegisterOnlineStatus(Integer aModEoCCNUWhiteListRegisterOnlineStatus) {
        getProperty(modEoCCNUWhiteListRegisterOnlineStatus).setValue(aModEoCCNUWhiteListRegisterOnlineStatus);
    }

    public Long getModEoCCNUWhiteListStartTime() {
        return (Long) getProperty(modEoCCNUWhiteListStartTime).getValue();
    }

    public void setModEoCCNUWhiteListStartTime(Long aModEoCCNUWhiteListStartTime) {
        getProperty(modEoCCNUWhiteListStartTime).setValue(aModEoCCNUWhiteListStartTime);
    }

    public Long getModEoCCNUWhiteListEndTime() {
        return (Long) getProperty(modEoCCNUWhiteListEndTime).getValue();
    }

    public void setModEoCCNUWhiteListEndTime(Long aModEoCCNUWhiteListEndTime) {
        getProperty(modEoCCNUWhiteListEndTime).setValue(aModEoCCNUWhiteListEndTime);
    }


    public boolean retrieve() throws MibBeanException {
//        prepareRead(super.getProperty(modEoCCNUWhiteListIPAddress));
        prepareRead(super.getProperty(modEoCCNUWhiteListMACAddress));
        prepareRead(super.getProperty(modEoCCNUWhiteListAuthorization));
        prepareRead(super.getProperty(modEoCCNUWhiteListRFOutputLevel));
        prepareRead(super.getProperty(modEoCCNUWhiteListAutoUpgradeEN));
        prepareRead(super.getProperty(modEoCCNUWhiteListRegisterOnlineStatus));
        //prepareRead(super.getProperty(modEoCCNUWhiteListStartTime));
        //prepareRead(super.getProperty(modEoCCNUWhiteListEndTime));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
//        prepareRead(super.getProperty(modEoCCNUWhiteListIPAddress));
        prepareRead(super.getProperty(modEoCCNUWhiteListMACAddress));
        prepareRead(super.getProperty(modEoCCNUWhiteListAuthorization));
        prepareRead(super.getProperty(modEoCCNUWhiteListRFOutputLevel));
        prepareRead(super.getProperty(modEoCCNUWhiteListAutoUpgradeEN));
        prepareRead(super.getProperty(modEoCCNUWhiteListRegisterOnlineStatus));
        //prepareRead(super.getProperty(modEoCCNUWhiteListStartTime));
        //prepareRead(super.getProperty(modEoCCNUWhiteListEndTime));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
//        prepareSave(getProperty(modEoCCNUWhiteListIPAddress));
        prepareSave(getProperty(modEoCCNUWhiteListMACAddress));
        prepareSave(getProperty(modEoCCNUWhiteListAuthorization));
        prepareSave(getProperty(modEoCCNUWhiteListRFOutputLevel));
        prepareSave(getProperty(modEoCCNUWhiteListAutoUpgradeEN));
        //prepareSave(getProperty(modEoCCNUWhiteListStartTime));
        //prepareSave(getProperty(modEoCCNUWhiteListEndTime));

        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean add() throws MibBeanException {
//        prepareSave(getProperty(modEoCCNUWhiteListIPAddress));
        prepareSave(getProperty(modEoCCNUWhiteListMACAddress));
        prepareSave(getProperty(modEoCCNUWhiteListAuthorization));
        prepareSave(getProperty(modEoCCNUWhiteListRFOutputLevel));
        prepareSave(getProperty(modEoCCNUWhiteListAutoUpgradeEN));
        //prepareSave(getProperty(modEoCCNUWhiteListStartTime));
        //prepareSave(getProperty(modEoCCNUWhiteListEndTime));

        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}