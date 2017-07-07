/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

public class PerfStatsThresholdTable extends SnmpMibBean {

    public static final String perfStatsThresholdDeviceIndex = "perfStatsThresholdDeviceIndex";
    public static final String perfStatsThresholdCardIndex = "perfStatsThresholdCardIndex";
    public static final String perfStatsThresholdPortIndex = "perfStatsThresholdPortIndex";
    public static final String perfStatsThresholdTypeIndex = "perfStatsThresholdTypeIndex";
    public static final String perfStatsThresholdUpper = "perfStatsThresholdUpper";
    public static final String perfStatsThresholdLower = "perfStatsThresholdLower";

    public PerfStatsThresholdTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(perfStatsThresholdDeviceIndex, new SnmpMibBeanProperty(perfStatsThresholdDeviceIndex, ".1.3.6.1.4.1.17409.2.3.10.5.1.1", ISnmpConstant.GAUGE));
        initProperty(perfStatsThresholdCardIndex, new SnmpMibBeanProperty(perfStatsThresholdCardIndex, ".1.3.6.1.4.1.17409.2.3.10.5.1.2", ISnmpConstant.GAUGE));
        initProperty(perfStatsThresholdPortIndex, new SnmpMibBeanProperty(perfStatsThresholdPortIndex, ".1.3.6.1.4.1.17409.2.3.10.5.1.3", ISnmpConstant.INTEGER));
        initProperty(perfStatsThresholdTypeIndex, new SnmpMibBeanProperty(perfStatsThresholdTypeIndex, ".1.3.6.1.4.1.17409.2.3.10.5.1.4", ISnmpConstant.INTEGER));
        initProperty(perfStatsThresholdUpper, new SnmpMibBeanProperty(perfStatsThresholdUpper, ".1.3.6.1.4.1.17409.2.3.10.5.1.5", ISnmpConstant.COUNTER64));
        initProperty(perfStatsThresholdLower, new SnmpMibBeanProperty(perfStatsThresholdLower, ".1.3.6.1.4.1.17409.2.3.10.5.1.6", ISnmpConstant.COUNTER64));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.10.5.1.7", ISnmpConstant.INTEGER));
    }

    public Long getPerfStatsThresholdDeviceIndex() {
        return (Long) getIndex(0);
    }

    public void setPerfStatsThresholdDeviceIndex(Long aPerfStatsThresholdDeviceIndex) {
        setIndex(0, aPerfStatsThresholdDeviceIndex);
    }

    public Long getPerfStatsThresholdCardIndex() {
        return (Long) getIndex(1);
    }

    public void setPerfStatsThresholdCardIndex(Long aPerfStatsThresholdCardIndex) {
        setIndex(1, aPerfStatsThresholdCardIndex);
    }

    public Integer getPerfStatsThresholdPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPerfStatsThresholdPortIndex(Integer aPerfStatsThresholdPortIndex) {
        setIndex(2, aPerfStatsThresholdPortIndex);
    }

    public Integer getPerfStatsThresholdTypeIndex() {
        return (Integer) getIndex(3);
    }

    public void setPerfStatsThresholdTypeIndex(Integer aPerfStatsThresholdTypeIndex) {
        setIndex(3, aPerfStatsThresholdTypeIndex);
    }

    public BigInteger getPerfStatsThresholdUpper() {
        return (BigInteger) getProperty(perfStatsThresholdUpper).getValue();
    }

    public void setPerfStatsThresholdUpper(BigInteger aPerfStatsThresholdUpper) {
        getProperty(perfStatsThresholdUpper).setValue(aPerfStatsThresholdUpper);
    }

    public BigInteger getPerfStatsThresholdLower() {
        return (BigInteger) getProperty(perfStatsThresholdLower).getValue();
    }

    public void setPerfStatsThresholdLower(BigInteger aPerfStatsThresholdLower) {
        getProperty(perfStatsThresholdLower).setValue(aPerfStatsThresholdLower);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(perfStatsThresholdUpper));
        prepareRead(getProperty(perfStatsThresholdLower));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(perfStatsThresholdUpper));
        prepareRead(getProperty(perfStatsThresholdLower));

        return loadAll(new int[]{2, 2, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(perfStatsThresholdUpper));
        prepareSave(getProperty(perfStatsThresholdLower));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(perfStatsThresholdUpper));
        prepareSave(getProperty(perfStatsThresholdLower));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}