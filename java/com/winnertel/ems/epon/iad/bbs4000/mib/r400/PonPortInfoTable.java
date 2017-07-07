/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PonPortInfoTable extends SnmpMibBean {

    public static final String ponDeviceIndex = "ponDeviceIndex";
    public static final String ponCardIndex = "ponCardIndex";
    public static final String ponPortIndex = "ponPortIndex";
    public static final String ponPortType = "ponPortType";
    public static final String ponOperationStatus = "ponOperationStatus";
    public static final String ponPortAdminStatus = "ponPortAdminStatus";
    public static final String ponPortMaxOnuNumSupport = "ponPortMaxOnuNumSupport";
    public static final String ponPortUpOnuNum = "ponPortUpOnuNum";
    public static final String ponPortEncryptMode = "ponPortEncryptMode";
    public static final String ponPortEncryptKeyExchangeTime = "ponPortEncryptKeyExchangeTime";
    public static final String ponPortIsolationEnable = "ponPortIsolationEnable";
    public static final String maxBandwidth = "maxBandwidth";
    public static final String actualBandwidthInUse = "actualBandwidthInUse";
    public static final String remainBandwidth = "remainBandwidth";
    public static final String perfStats15minuteEnable = "perfStats15minuteEnable";
    public static final String perfStats24hourEnable = "perfStats24hourEnable";
    public static final String ponPortMacAddrLearnMaxNum = "ponPortMacAddrLearnMaxNum";
    public static final String maxUsBandwidth = "maxUsBandwidth";
    public static final String actualUsBandwidthInUse = "actualUsBandwidthInUse";
    public static final String remainUsBandwidth = "remainUsBandwidth";

    public PonPortInfoTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(ponDeviceIndex, new SnmpMibBeanProperty(ponDeviceIndex, ".1.3.6.1.4.1.17409.2.3.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(ponCardIndex, new SnmpMibBeanProperty(ponCardIndex, ".1.3.6.1.4.1.17409.2.3.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(ponPortIndex, new SnmpMibBeanProperty(ponPortIndex, ".1.3.6.1.4.1.17409.2.3.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(ponPortType, new SnmpMibBeanProperty(ponPortType, ".1.3.6.1.4.1.17409.2.3.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(ponOperationStatus, new SnmpMibBeanProperty(ponOperationStatus, ".1.3.6.1.4.1.17409.2.3.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(ponPortAdminStatus, new SnmpMibBeanProperty(ponPortAdminStatus, ".1.3.6.1.4.1.17409.2.3.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(ponPortMaxOnuNumSupport, new SnmpMibBeanProperty(ponPortMaxOnuNumSupport, ".1.3.6.1.4.1.17409.2.3.3.1.1.7", ISnmpConstant.INTEGER));
        initProperty(ponPortUpOnuNum, new SnmpMibBeanProperty(ponPortUpOnuNum, ".1.3.6.1.4.1.17409.2.3.3.1.1.8", ISnmpConstant.INTEGER));
        initProperty(ponPortEncryptMode, new SnmpMibBeanProperty(ponPortEncryptMode, ".1.3.6.1.4.1.17409.2.3.3.1.1.9", ISnmpConstant.INTEGER));
        initProperty(ponPortEncryptKeyExchangeTime, new SnmpMibBeanProperty(ponPortEncryptKeyExchangeTime, ".1.3.6.1.4.1.17409.2.3.3.1.1.10", ISnmpConstant.INTEGER));
        initProperty(ponPortIsolationEnable, new SnmpMibBeanProperty(ponPortIsolationEnable, ".1.3.6.1.4.1.17409.2.3.3.1.1.11", ISnmpConstant.INTEGER));
        initProperty(maxBandwidth, new SnmpMibBeanProperty(maxBandwidth, ".1.3.6.1.4.1.17409.2.3.3.1.1.12", ISnmpConstant.INTEGER));
        initProperty(actualBandwidthInUse, new SnmpMibBeanProperty(actualBandwidthInUse, ".1.3.6.1.4.1.17409.2.3.3.1.1.13", ISnmpConstant.INTEGER));
        initProperty(remainBandwidth, new SnmpMibBeanProperty(remainBandwidth, ".1.3.6.1.4.1.17409.2.3.3.1.1.14", ISnmpConstant.INTEGER));
        initProperty(perfStats15minuteEnable, new SnmpMibBeanProperty(perfStats15minuteEnable, ".1.3.6.1.4.1.17409.2.3.3.1.1.15", ISnmpConstant.INTEGER));
        initProperty(perfStats24hourEnable, new SnmpMibBeanProperty(perfStats24hourEnable, ".1.3.6.1.4.1.17409.2.3.3.1.1.16", ISnmpConstant.INTEGER));
        initProperty(ponPortMacAddrLearnMaxNum, new SnmpMibBeanProperty(ponPortMacAddrLearnMaxNum, ".1.3.6.1.4.1.17409.2.3.3.1.1.17", ISnmpConstant.INTEGER));
        initProperty(maxUsBandwidth, new SnmpMibBeanProperty(maxUsBandwidth, ".1.3.6.1.4.1.17409.2.3.3.1.1.18", ISnmpConstant.INTEGER));
        initProperty(actualUsBandwidthInUse, new SnmpMibBeanProperty(actualUsBandwidthInUse, ".1.3.6.1.4.1.17409.2.3.3.1.1.19", ISnmpConstant.INTEGER));
        initProperty(remainUsBandwidth, new SnmpMibBeanProperty(remainUsBandwidth, ".1.3.6.1.4.1.17409.2.3.3.1.1.20", ISnmpConstant.INTEGER));
    }

    public Integer getPonDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPonDeviceIndex(Integer aPonDeviceIndex) {
        setIndex(0, aPonDeviceIndex);
    }

    public Integer getPonCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setPonCardIndex(Integer aPonCardIndex) {
        setIndex(1, aPonCardIndex);
    }

    public Integer getPonPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPonPortIndex(Integer aPonPortIndex) {
        setIndex(2, aPonPortIndex);
    }

    public Integer getPonPortType() {
        return (Integer) getProperty(ponPortType).getValue();
    }

    public void setPonPortType(Integer aPonPortType) {
        getProperty(ponPortType).setValue(aPonPortType);
    }

    public Integer getPonOperationStatus() {
        return (Integer) getProperty(ponOperationStatus).getValue();
    }

    public void setPonOperationStatus(Integer aPonOperationStatus) {
        getProperty(ponOperationStatus).setValue(aPonOperationStatus);
    }

    public Integer getPonPortAdminStatus() {
        return (Integer) getProperty(ponPortAdminStatus).getValue();
    }

    public void setPonPortAdminStatus(Integer aPonPortAdminStatus) {
        getProperty(ponPortAdminStatus).setValue(aPonPortAdminStatus);
    }

    public Integer getPonPortMaxOnuNumSupport() {
        return (Integer) getProperty(ponPortMaxOnuNumSupport).getValue();
    }

    public void setPonPortMaxOnuNumSupport(Integer aPonPortMaxOnuNumSupport) {
        getProperty(ponPortMaxOnuNumSupport).setValue(aPonPortMaxOnuNumSupport);
    }

    public Integer getPonPortUpOnuNum() {
        return (Integer) getProperty(ponPortUpOnuNum).getValue();
    }

    public void setPonPortUpOnuNum(Integer aPonPortUpOnuNum) {
        getProperty(ponPortUpOnuNum).setValue(aPonPortUpOnuNum);
    }

    public Integer getPonPortEncryptMode() {
        return (Integer) getProperty(ponPortEncryptMode).getValue();
    }

    public void setPonPortEncryptMode(Integer aPonPortEncryptMode) {
        getProperty(ponPortEncryptMode).setValue(aPonPortEncryptMode);
    }

    public Integer getPonPortEncryptKeyExchangeTime() {
        return (Integer) getProperty(ponPortEncryptKeyExchangeTime).getValue();
    }

    public void setPonPortEncryptKeyExchangeTime(Integer aPonPortEncryptKeyExchangeTime) {
        getProperty(ponPortEncryptKeyExchangeTime).setValue(aPonPortEncryptKeyExchangeTime);
    }

    public Integer getPonPortIsolationEnable() {
        return (Integer) getProperty(ponPortIsolationEnable).getValue();
    }

    public void setPonPortIsolationEnable(Integer aPonPortIsolationEnable) {
        getProperty(ponPortIsolationEnable).setValue(aPonPortIsolationEnable);
    }

    public Integer getMaxBandwidth() {
        return (Integer) getProperty(maxBandwidth).getValue();
    }

    public void setMaxBandwidth(Integer aMaxBandwidth) {
        getProperty(maxBandwidth).setValue(aMaxBandwidth);
    }

    public Integer getActualBandwidthInUse() {
        return (Integer) getProperty(actualBandwidthInUse).getValue();
    }

    public void setActualBandwidthInUse(Integer aActualBandwidthInUse) {
        getProperty(actualBandwidthInUse).setValue(aActualBandwidthInUse);
    }

    public Integer getRemainBandwidth() {
        return (Integer) getProperty(remainBandwidth).getValue();
    }

    public void setRemainBandwidth(Integer aRemainBandwidth) {
        getProperty(remainBandwidth).setValue(aRemainBandwidth);
    }

    public Integer getPerfStats15minuteEnable() {
        return (Integer) getProperty(perfStats15minuteEnable).getValue();
    }

    public void setPerfStats15minuteEnable(Integer aPerfStats15minuteEnable) {
        getProperty(perfStats15minuteEnable).setValue(aPerfStats15minuteEnable);
    }

    public Integer getPerfStats24hourEnable() {
        return (Integer) getProperty(perfStats24hourEnable).getValue();
    }

    public void setPerfStats24hourEnable(Integer aPerfStats24hourEnable) {
        getProperty(perfStats24hourEnable).setValue(aPerfStats24hourEnable);
    }

    public Integer getPonPortMacAddrLearnMaxNum() {
        return (Integer) getProperty(ponPortMacAddrLearnMaxNum).getValue();
    }

    public void setPonPortMacAddrLearnMaxNum(Integer aPonPortMacAddrLearnMaxNum) {
        getProperty(ponPortMacAddrLearnMaxNum).setValue(aPonPortMacAddrLearnMaxNum);
    }

    public Integer getMaxUsBandwidth() {
        return (Integer)getProperty(maxUsBandwidth).getValue();
    }

    public void setMaxUsBandwidth(Integer aMaxUsBandwidth) {
        getProperty(maxUsBandwidth).setValue(aMaxUsBandwidth);
    }

    public Integer getActualUsBandwidthInUse() {
        return (Integer)getProperty(actualUsBandwidthInUse).getValue();
    }

    public void setActualUsBandwidthInUse(Integer aActualUsBandwidthInUse) {
        getProperty(actualUsBandwidthInUse).setValue(aActualUsBandwidthInUse);
    }

    public Integer getRemainUsBandwidth() {
        return (Integer)getProperty(remainUsBandwidth).getValue();
    }

    public void setRemainUsBandwidth(Integer aRemainUsBandwidth) {
        getProperty(remainUsBandwidth).setValue(aRemainUsBandwidth);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(ponPortType));
        prepareRead(getProperty(ponOperationStatus));
        prepareRead(getProperty(ponPortAdminStatus));
        prepareRead(getProperty(ponPortMaxOnuNumSupport));
        prepareRead(getProperty(ponPortUpOnuNum));
        prepareRead(getProperty(ponPortEncryptMode));
        prepareRead(getProperty(ponPortEncryptKeyExchangeTime));
        prepareRead(getProperty(ponPortIsolationEnable));
        prepareRead(getProperty(maxBandwidth));
        prepareRead(getProperty(actualBandwidthInUse));
        prepareRead(getProperty(remainBandwidth));
        prepareRead(getProperty(perfStats15minuteEnable));
        prepareRead(getProperty(perfStats24hourEnable));
        prepareRead(getProperty(ponPortMacAddrLearnMaxNum));
        prepareRead(getProperty(maxUsBandwidth));
        prepareRead(getProperty(actualUsBandwidthInUse));
        prepareRead(getProperty(remainUsBandwidth));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(ponPortType));
        prepareRead(getProperty(ponOperationStatus));
        prepareRead(getProperty(ponPortAdminStatus));
        prepareRead(getProperty(ponPortMaxOnuNumSupport));
        prepareRead(getProperty(ponPortUpOnuNum));
        prepareRead(getProperty(ponPortEncryptMode));
        prepareRead(getProperty(ponPortEncryptKeyExchangeTime));
        prepareRead(getProperty(ponPortIsolationEnable));
        prepareRead(getProperty(maxBandwidth));
        prepareRead(getProperty(actualBandwidthInUse));
        prepareRead(getProperty(remainBandwidth));
        prepareRead(getProperty(perfStats15minuteEnable));
        prepareRead(getProperty(perfStats24hourEnable));
        prepareRead(getProperty(ponPortMacAddrLearnMaxNum));
        prepareRead(getProperty(maxUsBandwidth));
        prepareRead(getProperty(actualUsBandwidthInUse));
        prepareRead(getProperty(remainUsBandwidth));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(ponPortAdminStatus));
        prepareSave(getProperty(ponPortEncryptMode));
        prepareSave(getProperty(ponPortEncryptKeyExchangeTime));
        prepareSave(getProperty(ponPortIsolationEnable));
        //prepareSave(getProperty(maxBandwidth));
        prepareSave(getProperty(perfStats15minuteEnable));
        prepareSave(getProperty(perfStats24hourEnable));
        prepareSave(getProperty(ponPortMacAddrLearnMaxNum));

        return save();
    }

}