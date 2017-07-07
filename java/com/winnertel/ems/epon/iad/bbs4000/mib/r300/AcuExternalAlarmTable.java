package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class AcuExternalAlarmTable extends SnmpMibBean {

    public static final String utsBbsAcuExternalAlarmIndex = "utsBbsAcuExternalAlarmIndex";
    public static final String utsBbsAcuExternalAlarmEnable = "utsBbsAcuExternalAlarmEnable";
    public static final String utsBbsAcuExternalAlarmDescription = "utsBbsAcuExternalAlarmDescription";
    public static final String utsBbsAcuExternalAlarmSeverity = "utsBbsAcuExternalAlarmSeverity";
    public static final String utsBbsAcuExternalAlarmReportCriteria = "utsBbsAcuExternalAlarmReportCriteria";

    public AcuExternalAlarmTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsBbsAcuExternalAlarmIndex, new SnmpMibBeanProperty(utsBbsAcuExternalAlarmIndex, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsBbsAcuExternalAlarmEnable, new SnmpMibBeanProperty(utsBbsAcuExternalAlarmEnable, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsBbsAcuExternalAlarmDescription, new SnmpMibBeanProperty(utsBbsAcuExternalAlarmDescription, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.1.10.1.3", ISnmpConstant.OCTETS)); //modified by Zhou Chao, 2009/6/19
        initProperty(utsBbsAcuExternalAlarmSeverity, new SnmpMibBeanProperty(utsBbsAcuExternalAlarmSeverity, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.1.10.1.4", ISnmpConstant.INTEGER));
        initProperty(utsBbsAcuExternalAlarmReportCriteria, new SnmpMibBeanProperty(utsBbsAcuExternalAlarmReportCriteria, ".1.3.6.1.4.1.41355.1.3.10.200.6.2.1.1.4.1.10.1.5", ISnmpConstant.INTEGER));
    }

    public Integer getUtsBbsAcuExternalAlarmIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsBbsAcuExternalAlarmIndex(Integer aUtsBbsAcuExternalAlarmIndex) {
        setIndex(0, aUtsBbsAcuExternalAlarmIndex);
    }


    public Integer getUtsBbsAcuExternalAlarmEnable() {
        return (Integer) getProperty(utsBbsAcuExternalAlarmEnable).getValue();
    }

    public void setUtsBbsAcuExternalAlarmEnable(Integer aUtsBbsAcuExternalAlarmEnable) {
        getProperty(utsBbsAcuExternalAlarmEnable).setValue(aUtsBbsAcuExternalAlarmEnable);
    }

    public byte[] getUtsBbsAcuExternalAlarmDescription() { //modified by Zhou Chao, 2009/6/19
        return (byte[]) getProperty(utsBbsAcuExternalAlarmDescription).getValue();
    }

    public void setUtsBbsAcuExternalAlarmDescription(byte[] aUtsBbsAcuExternalAlarmDescription) { //modified by Zhou Chao, 2009/6/19
        getProperty(utsBbsAcuExternalAlarmDescription).setValue(aUtsBbsAcuExternalAlarmDescription);
    }

    public Integer getUtsBbsAcuExternalAlarmSeverity() {
        return (Integer) getProperty(utsBbsAcuExternalAlarmSeverity).getValue();
    }

    public void setUtsBbsAcuExternalAlarmSeverity(Integer aUtsBbsAcuExternalAlarmSeverity) {
        getProperty(utsBbsAcuExternalAlarmSeverity).setValue(aUtsBbsAcuExternalAlarmSeverity);
    }

    public Integer getUtsBbsAcuExternalAlarmReportCriteria() {
        return (Integer) getProperty(utsBbsAcuExternalAlarmReportCriteria).getValue();
    }

    public void setUtsBbsAcuExternalAlarmReportCriteria(Integer aUtsBbsAcuExternalAlarmReportCriteria) {
        getProperty(utsBbsAcuExternalAlarmReportCriteria).setValue(aUtsBbsAcuExternalAlarmReportCriteria);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmEnable));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmDescription));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmSeverity));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmReportCriteria));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmEnable));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmDescription));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmSeverity));
        prepareRead(super.getProperty(utsBbsAcuExternalAlarmReportCriteria));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsBbsAcuExternalAlarmEnable));
        prepareSave(getProperty(utsBbsAcuExternalAlarmDescription));
        prepareSave(getProperty(utsBbsAcuExternalAlarmSeverity));
        prepareSave(getProperty(utsBbsAcuExternalAlarmReportCriteria));

        return save();
    }

}