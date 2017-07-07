/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ControlledMulticastUserAuthorityTable extends SnmpMibBean {

    public static final String cmDeviceIndex = "cmDeviceIndex";
    public static final String cmCardIndex = "cmCardIndex";
    public static final String cmPortIndex = "cmPortIndex";
    public static final String multicastPackageList = "multicastPackageList";
    public static final String igmpGlobalBW = "igmpGlobalBW";
    public static final String igmpGlobalBWUsed = "igmpGlobalBWUsed";

    public ControlledMulticastUserAuthorityTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(cmDeviceIndex, new SnmpMibBeanProperty(cmDeviceIndex, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.1", ISnmpConstant.GAUGE));
        initProperty(cmCardIndex, new SnmpMibBeanProperty(cmCardIndex, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(cmPortIndex, new SnmpMibBeanProperty(cmPortIndex, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(multicastPackageList, new SnmpMibBeanProperty(multicastPackageList, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.4", ISnmpConstant.OCTETS));
        initProperty(igmpGlobalBW, new SnmpMibBeanProperty(igmpGlobalBW, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.5", ISnmpConstant.GAUGE));
        initProperty(igmpGlobalBWUsed, new SnmpMibBeanProperty(igmpGlobalBWUsed, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.6", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.6.4.1.1.7", ISnmpConstant.INTEGER));
    }

    public Long getCmDeviceIndex() {
        return (Long) getIndex(0);
    }

    public void setCmDeviceIndex(Long aCmDeviceIndex) {
        setIndex(0, aCmDeviceIndex);
    }

    public Integer getCmCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setCmCardIndex(Integer aCmCardIndex) {
        setIndex(1, aCmCardIndex);
    }

    public Integer getCmPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setCmPortIndex(Integer aCmPortIndex) {
        setIndex(2, aCmPortIndex);
    }

    public byte[] getMulticastPackageList() {
        return (byte[]) getProperty(multicastPackageList).getValue();
    }

    public void setMulticastPackageList(byte[] aMulticastPackageList) {
        getProperty(multicastPackageList).setValue(aMulticastPackageList);
    }

    public Long getIgmpGlobalBW() {
        return (Long) getProperty(igmpGlobalBW).getValue();
    }

    public void setIgmpGlobalBW(Long aIgmpGlobalBW) {
        getProperty(igmpGlobalBW).setValue(aIgmpGlobalBW);
    }

    public Long getIgmpGlobalBWUsed() {
        return (Long) getProperty(igmpGlobalBWUsed).getValue();
    }

    public void setIgmpGlobalBWUsed(Long aIgmpGlobalBWUsed) {
        getProperty(igmpGlobalBWUsed).setValue(aIgmpGlobalBWUsed);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(multicastPackageList));
        prepareRead(getProperty(igmpGlobalBW));
        prepareRead(getProperty(igmpGlobalBWUsed));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(multicastPackageList));
        prepareRead(getProperty(igmpGlobalBW));
        prepareRead(getProperty(igmpGlobalBWUsed));

        return loadAll(new int[]{2, 1, 1});
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(multicastPackageList));
        prepareSave(getProperty(igmpGlobalBW));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }
    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(multicastPackageList));
        prepareSave(getProperty(igmpGlobalBW));

        setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}