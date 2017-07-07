package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuVlanFilterProfileTable class.
 * Created by Yang Yizai
 */
public class OnuVlanFilterProfileTable extends SnmpMibBean {
    public static final String onuVlanFilterProfileIndex = "onuVlanFilterProfileIndex";
    public static final String onuVlanFilterProfileName = "onuVlanFilterProfileName";
    public static final String onuVlanFilterProfileTciEntryNumber = "onuVlanFilterProfileTciEntryNumber";
    public static final String onuVlanFilterProfileTciEntryList = "onuVlanFilterProfileTciEntryList";
    public static final String onuVlanFilterProfileForwardOperation = "onuVlanFilterProfileForwardOperation";

    public OnuVlanFilterProfileTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanFilterProfileIndex, new SnmpMibBeanProperty(onuVlanFilterProfileIndex,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.1", ISnmpConstant.GAUGE));
        initProperty(onuVlanFilterProfileName, new SnmpMibBeanProperty(onuVlanFilterProfileName,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.2", ISnmpConstant.STRING));
        initProperty(onuVlanFilterProfileTciEntryNumber, new SnmpMibBeanProperty(onuVlanFilterProfileTciEntryNumber,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.3", ISnmpConstant.GAUGE));
        initProperty(onuVlanFilterProfileTciEntryList, new SnmpMibBeanProperty(onuVlanFilterProfileTciEntryList,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.4", ISnmpConstant.OCTETS));
        initProperty(onuVlanFilterProfileForwardOperation, new SnmpMibBeanProperty(
                onuVlanFilterProfileForwardOperation, ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.5", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.27.1.100",
                ISnmpConstant.INTEGER));

    }

    public Long getOnuVlanFilterProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setOnuVlanFilterProfileIndex(Long aOnuVlanFilterProfileIndex) {
        setIndex(0, aOnuVlanFilterProfileIndex);
    }

    public String getOnuVlanFilterProfileName() {
        return ((String) getProperty(onuVlanFilterProfileName).getValue()).trim();
    }

    public void setOnuVlanFilterProfileName(String aOnuVlanFilterProfileName) {
        getProperty(onuVlanFilterProfileName).setValue(aOnuVlanFilterProfileName);
    }

    public Long getOnuVlanFilterProfileTciEntryNumber() {
        return (Long) getProperty(onuVlanFilterProfileTciEntryNumber).getValue();
    }

    public void setOnuVlanFilterProfileTciEntryNumber(Long aOnuVlanFilterProfileTciEntryNumber) {
        getProperty(onuVlanFilterProfileTciEntryNumber).setValue(aOnuVlanFilterProfileTciEntryNumber);
    }

    public byte[] getOnuVlanFilterProfileTciEntryList() {
        return (byte[]) getProperty(onuVlanFilterProfileTciEntryList).getValue();
    }

    public void setOnuVlanFilterProfileTciEntryList(byte[] aOnuVlanFilterProfileTciEntryList) {
        getProperty(onuVlanFilterProfileTciEntryList).setValue(aOnuVlanFilterProfileTciEntryList);
    }

    public Long getOnuVlanFilterProfileForwardOperation() {
        return (Long) getProperty(onuVlanFilterProfileForwardOperation).getValue();
    }

    public void setOnuVlanFilterProfileForwardOperation(Long aOnuVlanFilterProfileForwardOperation) {
        getProperty(onuVlanFilterProfileForwardOperation).setValue(aOnuVlanFilterProfileForwardOperation);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanFilterProfileName));
        prepareRead(super.getProperty(onuVlanFilterProfileTciEntryNumber));
        prepareRead(super.getProperty(onuVlanFilterProfileTciEntryList));
        prepareRead(super.getProperty(onuVlanFilterProfileForwardOperation));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanFilterProfileName));
        prepareRead(super.getProperty(onuVlanFilterProfileTciEntryNumber));
        prepareRead(super.getProperty(onuVlanFilterProfileTciEntryList));
        prepareRead(super.getProperty(onuVlanFilterProfileForwardOperation));

        return loadAll(new int[] { 2 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVlanFilterProfileName));
        prepareSave(getProperty(onuVlanFilterProfileTciEntryNumber));
        prepareSave(getProperty(onuVlanFilterProfileTciEntryList));
        prepareSave(getProperty(onuVlanFilterProfileForwardOperation));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVlanFilterProfileName));
        prepareSave(getProperty(onuVlanFilterProfileTciEntryNumber));
        prepareSave(getProperty(onuVlanFilterProfileTciEntryList));
        prepareSave(getProperty(onuVlanFilterProfileForwardOperation));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
    
    public String toString() {
        return getOnuVlanFilterProfileName();
    }

}
