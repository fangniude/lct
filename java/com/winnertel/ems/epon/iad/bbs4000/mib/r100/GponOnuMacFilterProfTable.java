package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuMacFilterProfTable extends SnmpMibBean {

    public static final String onuMacFilterProfIndex1 = "onuMacFilterProfIndex1";
    public static final String onuMacFilterProfIndex2 = "onuMacFilterProfIndex2";
    public static final String onuMacFilterProfileName = "onuMacFilterProfileName";
    public static final String onuMacFilterProfMacAddress = "onuMacFilterProfMacAddress";
    public static final String onuMacFilterProfFilterForward = "onuMacFilterProfFilterForward";
    //public static final String oltVlanTransProfIndex1 = "oltVlanTransProfIndex1";

    public GponOnuMacFilterProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        // TODO Auto-generated method stub
        initProperty(onuMacFilterProfIndex1, new SnmpMibBeanProperty(onuMacFilterProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.1", ISnmpConstant.GAUGE));
        initProperty(onuMacFilterProfIndex2, new SnmpMibBeanProperty(onuMacFilterProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.2", ISnmpConstant.GAUGE));
        initProperty(onuMacFilterProfileName, new SnmpMibBeanProperty(onuMacFilterProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.3", ISnmpConstant.STRING));
        initProperty(onuMacFilterProfMacAddress, new SnmpMibBeanProperty(onuMacFilterProfMacAddress, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.4", ISnmpConstant.MAC_ADDRESS));
        initProperty(onuMacFilterProfFilterForward, new SnmpMibBeanProperty(onuMacFilterProfFilterForward, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.5", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.14.1.6", ISnmpConstant.INTEGER));
    }

    public void setOnuMacFilterProfIndex1(Long aOnuMacFilterProfIndex1) {
        setIndex(0, aOnuMacFilterProfIndex1);
    }

    public Long getOnuMacFilterProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuMacFilterProfIndex2(Long aOnuMacFilterProfIndex2) {
        setIndex(1, aOnuMacFilterProfIndex2);
    }

    public Long getOnuMacFilterProfIndex2() {
        return (Long) getIndex(1);
    }

    public String getOnuMacFilterProfileName() {
        return (String) getProperty(onuMacFilterProfileName).getValue();
    }

    public void setOnuMacFilterProfileName(String aOnuMacFilterProfileName) {
        getProperty(onuMacFilterProfileName).setValue(aOnuMacFilterProfileName);
    }

    public byte[] getOnuMacFilterProfMacAddress() {
        return (byte[]) getProperty(onuMacFilterProfMacAddress).getValue();
    }

    public void setOnuMacFilterProfMacAddress(byte[] aOnuMacFilterProfMacAddress) {
        getProperty(onuMacFilterProfMacAddress).setValue(aOnuMacFilterProfMacAddress);
    }

    public Integer getOnuMacFilterProfFilterForward() {
        return (Integer) getProperty(onuMacFilterProfFilterForward).getValue();
    }

    public void setOnuMacFilterProfFilterForward(Integer aOnuMacFilterProfFilterForward) {
        getProperty(onuMacFilterProfFilterForward).setValue(aOnuMacFilterProfFilterForward);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuMacFilterProfileName));
        prepareRead(super.getProperty(onuMacFilterProfMacAddress));
        prepareRead(super.getProperty(onuMacFilterProfFilterForward));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuMacFilterProfileName));
        prepareRead(getProperty(onuMacFilterProfMacAddress));
        prepareRead(getProperty(onuMacFilterProfFilterForward));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuMacFilterProfileName));
        prepareSave(getProperty(onuMacFilterProfMacAddress));
        prepareSave(getProperty(onuMacFilterProfFilterForward));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuMacFilterProfileName));
        prepareSave(getProperty(onuMacFilterProfMacAddress));
        prepareSave(getProperty(onuMacFilterProfFilterForward));
        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuMacFilterProfileName();
    }

}