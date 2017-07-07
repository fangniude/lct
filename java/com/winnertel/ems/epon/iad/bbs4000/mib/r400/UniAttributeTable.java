/**
 * Created by Zhou Chao, 2010/3/15
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UniAttributeTable extends SnmpMibBean {

    public static final String uniAttributeDeviceIndex = "uniAttributeDeviceIndex";
    public static final String uniAttributeCardIndex = "uniAttributeCardIndex";
    public static final String uniAttributePortIndex = "uniAttributePortIndex";
    public static final String uniAdminStatus = "uniAdminStatus";
    public static final String uniOperationStatus = "uniOperationStatus";
    /*
    public static final String uniPerfStats15minuteEnable = "uniPerfStats15minuteEnable";
    public static final String uniPerfStats24hourEnable = "uniPerfStats24hourEnable";
    public static final String uniLastChangeTime = "uniLastChangeTime";
    public static final String uniIsolationEnable = "uniIsolationEnable";
    public static final String uniMacAddrLearnMaxNum = "uniMacAddrLearnMaxNum";
    */
    public static final String uniAutoNegotiationEnable = "uniAutoNegotiationEnable";
    public static final String uniAutoNegotiationLocalTechAbility = "uniAutoNegotiationLocalTechAbility";
    public static final String uniAutoNegotiationAdvertisedTechAbility = "uniAutoNegotiationAdvertisedTechAbility";
    public static final String uniAutoNegotiationRestart = "uniAutoNegotiationRestart";

    public UniAttributeTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniAttributeDeviceIndex, new SnmpMibBeanProperty(uniAttributeDeviceIndex, ".1.3.6.1.4.1.17409.2.3.5.1.1.1", ISnmpConstant.INTEGER));
        initProperty(uniAttributeCardIndex, new SnmpMibBeanProperty(uniAttributeCardIndex, ".1.3.6.1.4.1.17409.2.3.5.1.1.2", ISnmpConstant.INTEGER));
        initProperty(uniAttributePortIndex, new SnmpMibBeanProperty(uniAttributePortIndex, ".1.3.6.1.4.1.17409.2.3.5.1.1.3", ISnmpConstant.INTEGER));
        initProperty(uniAdminStatus, new SnmpMibBeanProperty(uniAdminStatus, ".1.3.6.1.4.1.17409.2.3.5.1.1.4", ISnmpConstant.INTEGER));
        initProperty(uniOperationStatus, new SnmpMibBeanProperty(uniOperationStatus, ".1.3.6.1.4.1.17409.2.3.5.1.1.5", ISnmpConstant.INTEGER));
        /*
        initProperty(uniPerfStats15minuteEnable, new SnmpMibBeanProperty(uniPerfStats15minuteEnable, ".1.3.6.1.4.1.17409.2.3.5.1.1.9", ISnmpConstant.INTEGER));
        initProperty(uniPerfStats24hourEnable, new SnmpMibBeanProperty(uniPerfStats24hourEnable, ".1.3.6.1.4.1.17409.2.3.5.1.1.10", ISnmpConstant.INTEGER));
        initProperty(uniLastChangeTime, new SnmpMibBeanProperty(uniLastChangeTime, ".1.3.6.1.4.1.17409.2.3.5.1.1.11", ISnmpConstant.COUNTER));
        initProperty(uniIsolationEnable, new SnmpMibBeanProperty(uniIsolationEnable, ".1.3.6.1.4.1.17409.2.3.5.1.1.12", ISnmpConstant.INTEGER));
        initProperty(uniMacAddrLearnMaxNum, new SnmpMibBeanProperty(uniMacAddrLearnMaxNum, ".1.3.6.1.4.1.17409.2.3.5.1.1.13", ISnmpConstant.INTEGER));
        */
        initProperty(uniAutoNegotiationEnable, new SnmpMibBeanProperty(uniAutoNegotiationEnable, ".1.3.6.1.4.1.17409.2.3.5.1.1.6", ISnmpConstant.INTEGER));
        initProperty(uniAutoNegotiationLocalTechAbility, new SnmpMibBeanProperty(uniAutoNegotiationLocalTechAbility, ".1.3.6.1.4.1.17409.2.3.5.1.1.7", ISnmpConstant.OCTETS));
        initProperty(uniAutoNegotiationAdvertisedTechAbility, new SnmpMibBeanProperty(uniAutoNegotiationAdvertisedTechAbility, ".1.3.6.1.4.1.17409.2.3.5.1.1.8", ISnmpConstant.OCTETS));
        initProperty(uniAutoNegotiationRestart, new SnmpMibBeanProperty(uniAutoNegotiationRestart, ".1.3.6.1.4.1.17409.2.3.5.1.1.9", ISnmpConstant.INTEGER));
    }

    public Integer getUniAttributeDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniAttributeDeviceIndex(Integer aUniAttributeDeviceIndex) {
        setIndex(0, aUniAttributeDeviceIndex);
    }

    public Integer getUniAttributeCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setUniAttributeCardIndex(Integer aUniAttributeCardIndex) {
        setIndex(1, aUniAttributeCardIndex);
    }

    public Integer getUniAttributePortIndex() {
        return (Integer) getIndex(2);
    }

    public void setUniAttributePortIndex(Integer aUniAttributePortIndex) {
        setIndex(2, aUniAttributePortIndex);
    }

    public Integer getUniAdminStatus() {
        return (Integer) getProperty(uniAdminStatus).getValue();
    }

    public void setUniAdminStatus(Integer aUniAdminStatus) {
        getProperty(uniAdminStatus).setValue(aUniAdminStatus);
    }

    public Integer getUniOperationStatus() {
        return (Integer) getProperty(uniOperationStatus).getValue();
    }

    public void setUniOperationStatus(Integer aUniOperationStatus) {
        getProperty(uniOperationStatus).setValue(aUniOperationStatus);
    }

    /*
    public Integer getUniPerfStats15minuteEnable() {
        return (Integer) getProperty(uniPerfStats15minuteEnable).getValue();
    }

    public void setUniPerfStats15minuteEnable(Integer aUniPerfStats15minuteEnable) {
        getProperty(uniPerfStats15minuteEnable).setValue(aUniPerfStats15minuteEnable);
    }

    public Integer getUniPerfStats24hourEnable() {
        return (Integer) getProperty(uniPerfStats24hourEnable).getValue();
    }

    public void setUniPerfStats24hourEnable(Integer aUniPerfStats24hourEnable) {
        getProperty(uniPerfStats24hourEnable).setValue(aUniPerfStats24hourEnable);
    }

    public Long getUniLastChangeTime() {
        return (Long) getProperty(uniLastChangeTime).getValue();
    }

    public void setUniLastChangeTime(Long aUniLastChangeTime) {
        getProperty(uniLastChangeTime).setValue(aUniLastChangeTime);
    }

    public Integer getUniIsolationEnable() {
        return (Integer) getProperty(uniIsolationEnable).getValue();
    }

    public void setUniIsolationEnable(Integer aUniIsolationEnable) {
        getProperty(uniIsolationEnable).setValue(aUniIsolationEnable);
    }

    public Integer getUniMacAddrLearnMaxNum() {
        return (Integer) getProperty(uniMacAddrLearnMaxNum).getValue();
    }

    public void setUniMacAddrLearnMaxNum(Integer aUniMacAddrLearnMaxNum) {
        getProperty(uniMacAddrLearnMaxNum).setValue(aUniMacAddrLearnMaxNum);
    }
    */

    public Integer getUniAutoNegotiationEnable() {
        return (Integer) getProperty(uniAutoNegotiationEnable).getValue();
    }

    public void setUniAutoNegotiationEnable(Integer aUniAutoNegotiationEnable) {
        getProperty(uniAutoNegotiationEnable).setValue(aUniAutoNegotiationEnable);
    }

    public byte[] getUniAutoNegotiationLocalTechAbility() {
        return (byte[]) getProperty(uniAutoNegotiationLocalTechAbility).getValue();
    }

    public void setUniAutoNegotiationLocalTechAbility(byte[] aUniAutoNegotiationLocalTechAbility) {
        getProperty(uniAutoNegotiationLocalTechAbility).setValue(aUniAutoNegotiationLocalTechAbility);
    }

    public byte[] getUniAutoNegotiationAdvertisedTechAbility() {
        return (byte[]) getProperty(uniAutoNegotiationAdvertisedTechAbility).getValue();
    }

    public void setUniAutoNegotiationAdvertisedTechAbility(byte[] aUniAutoNegotiationAdvertisedTechAbility) {
        getProperty(uniAutoNegotiationAdvertisedTechAbility).setValue(aUniAutoNegotiationAdvertisedTechAbility);
    }

    public Integer getUniAutoNegotiationRestart() {
        return (Integer) getProperty(uniAutoNegotiationRestart).getValue();
    }

    public void setUniAutoNegotiationRestart(Integer aUniAutoNegotiationRestart) {
        getProperty(uniAutoNegotiationRestart).setValue(aUniAutoNegotiationRestart);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniAdminStatus));
        prepareRead(getProperty(uniOperationStatus));
        /*
        prepareRead(getProperty(uniPerfStats15minuteEnable));
        prepareRead(getProperty(uniPerfStats24hourEnable));
        prepareRead(getProperty(uniLastChangeTime));
        prepareRead(getProperty(uniIsolationEnable));
        prepareRead(getProperty(uniMacAddrLearnMaxNum));
        */
        prepareRead(getProperty(uniAutoNegotiationEnable));
        prepareRead(getProperty(uniAutoNegotiationLocalTechAbility));
        prepareRead(getProperty(uniAutoNegotiationAdvertisedTechAbility));
        //prepareRead(getProperty(uniAutoNegotiationRestart));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniAdminStatus));
        prepareRead(getProperty(uniOperationStatus));
        /*
        prepareRead(getProperty(uniPerfStats15minuteEnable));
        prepareRead(getProperty(uniPerfStats24hourEnable));
        prepareRead(getProperty(uniLastChangeTime));
        prepareRead(getProperty(uniIsolationEnable));
        prepareRead(getProperty(uniMacAddrLearnMaxNum));
        */
        prepareRead(getProperty(uniAutoNegotiationEnable));
        prepareRead(getProperty(uniAutoNegotiationLocalTechAbility));
        prepareRead(getProperty(uniAutoNegotiationAdvertisedTechAbility));
        //prepareRead(getProperty(uniAutoNegotiationRestart));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniAdminStatus));
        /*
        prepareSave(getProperty(uniPerfStats15minuteEnable));
        prepareSave(getProperty(uniPerfStats24hourEnable));
        prepareSave(getProperty(uniIsolationEnable));
        prepareSave(getProperty(uniMacAddrLearnMaxNum));
        */
        prepareSave(getProperty(uniAutoNegotiationEnable));
        prepareSave(getProperty(uniAutoNegotiationAdvertisedTechAbility));
        //prepareSave(getProperty(uniAutoNegotiationRestart));

        return save();
    }

    public boolean restartAutoNeg() throws MibBeanException {
        setUniAutoNegotiationRestart(new Integer(1));
        prepareSave(getProperty(uniAutoNegotiationRestart));

        return save();
    }

}