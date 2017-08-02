package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuTcontVPortBindProfTable class.
 * Created by QuickDVM
 */
public class OnuTcontVPortBindProfTable extends SnmpMibBean {

    public static final String tcontVirtualPortBindingProfileIndex = "tcontVirtualPortBindingProfileIndex";
    public static final String tcontVirtualPortBindingProfileVirtualPortNo = "tcontVirtualPortBindingProfileVirtualPortNo";
    public static final String onuTcontVPortBindProfileName = "onuTcontVPortBindProfileName";
    public static final String virtualPortServicePr = "virtualPortServicePr";
    public static final String tcontIndex = "tcontIndex";
    public static final String tcontServiceProfileIndex = "tcontServiceProfileIndex";

    public OnuTcontVPortBindProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(tcontVirtualPortBindingProfileIndex, new SnmpMibBeanProperty(tcontVirtualPortBindingProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.1", ISnmpConstant.GAUGE));
        //initProperty(tcontVirtualPortBindingProfileVirtualPortNo, new SnmpMibBeanProperty(tcontVirtualPortBindingProfileVirtualPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(onuTcontVPortBindProfileName, new SnmpMibBeanProperty(onuTcontVPortBindProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.3", ISnmpConstant.STRING));
        initProperty(virtualPortServicePr, new SnmpMibBeanProperty(virtualPortServicePr, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.4", ISnmpConstant.GAUGE));
        initProperty(tcontIndex, new SnmpMibBeanProperty(tcontIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.5", ISnmpConstant.GAUGE));
        initProperty(tcontServiceProfileIndex, new SnmpMibBeanProperty(tcontServiceProfileIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.6", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.2.1.1.7", ISnmpConstant.INTEGER));
    }

    public Long getTcontVirtualPortBindingProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setTcontVirtualPortBindingProfileIndex(Long aTcontVirtualPortBindingProfileIndex) {
        setIndex(0, aTcontVirtualPortBindingProfileIndex);
    }

    public Long getTcontVirtualPortBindingProfileVirtualPortNo() {
        return (Long) getIndex(1);
    }

    public void setTcontVirtualPortBindingProfileVirtualPortNo(Integer aTcontVirtualPortBindingProfileVirtualPortNo) {
        setIndex(1, aTcontVirtualPortBindingProfileVirtualPortNo);
    }

    public String getOnuTcontVPortBindProfileName() {
        return (String) getProperty(onuTcontVPortBindProfileName).getValue();
    }

    public void setOnuTcontVPortBindProfileName(String aOnuTcontVPortBindProfileName) {
        getProperty(onuTcontVPortBindProfileName).setValue(aOnuTcontVPortBindProfileName);
    }

    public Long getVirtualPortServicePr() {
        return (Long) getProperty(virtualPortServicePr).getValue();
    }

    public void setVirtualPortServicePr(Long aVirtualPortServicePr) {
        getProperty(virtualPortServicePr).setValue(aVirtualPortServicePr);
    }

    public Long getTcontIndex() {
        return (Long) getProperty(tcontIndex).getValue();
    }

    public void setTcontIndex(Long aTcontIndex) {
        getProperty(tcontIndex).setValue(aTcontIndex);
    }

    public Long getTcontServiceProfileIndex() {
        return (Long) getProperty(tcontServiceProfileIndex).getValue();
    }

    public void setTcontServiceProfileIndex(Long aTcontServiceProfileIndex) {
        getProperty(tcontServiceProfileIndex).setValue(aTcontServiceProfileIndex);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuTcontVPortBindProfileName));
        prepareRead(super.getProperty(virtualPortServicePr));
        prepareRead(super.getProperty(tcontIndex));
        prepareRead(super.getProperty(tcontServiceProfileIndex));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuTcontVPortBindProfileName));
        prepareRead(super.getProperty(virtualPortServicePr));
        prepareRead(super.getProperty(tcontIndex));
        prepareRead(super.getProperty(tcontServiceProfileIndex));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuTcontVPortBindProfileName));
        prepareSave(getProperty(virtualPortServicePr));
        prepareSave(getProperty(tcontIndex));
        prepareSave(getProperty(tcontServiceProfileIndex));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuTcontVPortBindProfileName));
        prepareSave(getProperty(virtualPortServicePr));
        prepareSave(getProperty(tcontIndex));
        prepareSave(getProperty(tcontServiceProfileIndex));

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
        return getOnuTcontVPortBindProfileName();
    }

}