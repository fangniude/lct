package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortQinQConfigTable class.
 * Created by QuickDVM
 */
public class PortQinQConfigTable extends SnmpMibBean {
    public static final String pqDeviceIndex = "pqDeviceIndex";
    public static final String pqCardIndex = "pqCardIndex";
    public static final String pqPortIndex = "pqPortIndex";
    public static final String pqStartVlanId = "pqStartVlanId";
    public static final String pqEndVlanId = "pqEndVlanId";
    public static final String pqSVlanId = "pqSVlanId";
    public static final String pqSTagCosDetermine = "pqSTagCosDetermine";
    public static final String pqSTagCosNewValue = "pqSTagCosNewValue";


    public PortQinQConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(pqDeviceIndex, new SnmpMibBeanProperty(pqDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.1", ISnmpConstant.GAUGE));
        initProperty(pqCardIndex, new SnmpMibBeanProperty(pqCardIndex, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.2", ISnmpConstant.GAUGE));
        initProperty(pqPortIndex, new SnmpMibBeanProperty(pqPortIndex, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(pqStartVlanId, new SnmpMibBeanProperty(pqStartVlanId, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.4", ISnmpConstant.INTEGER));
        initProperty(pqEndVlanId, new SnmpMibBeanProperty(pqEndVlanId, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.5", ISnmpConstant.INTEGER));
        initProperty(pqSVlanId, new SnmpMibBeanProperty(pqSVlanId, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.6", ISnmpConstant.INTEGER));
        initProperty(pqSTagCosDetermine, new SnmpMibBeanProperty(pqSTagCosDetermine, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.7", ISnmpConstant.INTEGER));
        initProperty(pqSTagCosNewValue, new SnmpMibBeanProperty(pqSTagCosNewValue, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.8", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.4.1.1.9", ISnmpConstant.INTEGER));

    }


    public Long getPqDeviceIndex() {
        return (Long) getIndex(0);
    }

    public void setPqDeviceIndex(Long aPqDeviceIndex) {
        setIndex(0, aPqDeviceIndex);
    }


    public Long getPqCardIndex() {
        return (Long) getIndex(1);
    }

    public void setPqCardIndex(Long aPqCardIndex) {
        setIndex(1, aPqCardIndex);
    }


    public Integer getPqPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPqPortIndex(Integer aPqPortIndex) {
        setIndex(2, aPqPortIndex);
    }


    public Integer getPqStartVlanId() {
        return (Integer) getIndex(3);
    }

    public void setPqStartVlanId(Integer aPqStartVlanId) {
        setIndex(3, aPqStartVlanId);
    }


    public Integer getPqEndVlanId() {
        return (Integer) getIndex(4);
    }

    public void setPqEndVlanId(Integer aPqEndVlanId) {
        setIndex(4, aPqEndVlanId);
    }


    public Integer getPqSVlanId() {
        return (Integer) getProperty(pqSVlanId).getValue();
    }

    public void setPqSVlanId(Integer aPqSVlanId) {
        getProperty(pqSVlanId).setValue(aPqSVlanId);
    }

    public Integer getPqSTagCosDetermine() {
        return (Integer) getProperty(pqSTagCosDetermine).getValue();
    }

    public void setPqSTagCosDetermine(Integer aPqSTagCosDetermine) {
        getProperty(pqSTagCosDetermine).setValue(aPqSTagCosDetermine);
    }

    public Integer getPqSTagCosNewValue() {
        return (Integer) getProperty(pqSTagCosNewValue).getValue();
    }

    public void setPqSTagCosNewValue(Integer aPqSTagCosNewValue) {
        getProperty(pqSTagCosNewValue).setValue(aPqSTagCosNewValue);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(pqSVlanId));
        prepareRead(super.getProperty(pqSTagCosDetermine));
        prepareRead(super.getProperty(pqSTagCosNewValue));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(pqSVlanId));
        prepareRead(super.getProperty(pqSTagCosDetermine));
        prepareRead(super.getProperty(pqSTagCosNewValue));


        return loadAll(new int[]{2
                , 2
                , 1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(pqSVlanId));
        prepareSave(getProperty(pqSTagCosDetermine));
        prepareSave(getProperty(pqSTagCosNewValue));

        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean add() throws MibBeanException {

        prepareSave(getProperty(pqSVlanId));
        prepareSave(getProperty(pqSTagCosDetermine));
        prepareSave(getProperty(pqSTagCosNewValue));
        
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
