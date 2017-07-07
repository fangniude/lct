package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortVlanTranslationTable class.
 * Created by QuickDVM
 */
public class PortVlanTranslationTable extends SnmpMibBean {
    public static final String pvtDeviceIndex = "pvtDeviceIndex";
    public static final String pvtCardIndex = "pvtCardIndex";
    public static final String pvtPortIndex = "pvtPortIndex";
    public static final String portVidIndex = "portVidIndex";
    public static final String translationNewVid = "translationNewVid";


    public PortVlanTranslationTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(pvtDeviceIndex, new SnmpMibBeanProperty(pvtDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.1", ISnmpConstant.GAUGE));
        initProperty(pvtCardIndex, new SnmpMibBeanProperty(pvtCardIndex, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.2", ISnmpConstant.GAUGE));
        initProperty(pvtPortIndex, new SnmpMibBeanProperty(pvtPortIndex, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.3", ISnmpConstant.INTEGER));
        initProperty(portVidIndex, new SnmpMibBeanProperty(portVidIndex, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.4", ISnmpConstant.GAUGE));
        initProperty(translationNewVid, new SnmpMibBeanProperty(translationNewVid, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.5", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.3.2.1.6", ISnmpConstant.INTEGER));

    }


    public Long getPvtDeviceIndex() {
        return (Long) getIndex(0);
    }

    public void setPvtDeviceIndex(Long aPvtDeviceIndex) {
        setIndex(0, aPvtDeviceIndex);
    }


    public Long getPvtCardIndex() {
        return (Long) getIndex(1);
    }

    public void setPvtCardIndex(Long aPvtCardIndex) {
        setIndex(1, aPvtCardIndex);
    }


    public Integer getPvtPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPvtPortIndex(Integer aPvtPortIndex) {
        setIndex(2, aPvtPortIndex);
    }


    public Long getPortVidIndex() {
        return (Long) getIndex(3);
    }

    public void setPortVidIndex(Long aPortVidIndex) {
        setIndex(3, aPortVidIndex);
    }


    public Long getTranslationNewVid() {
        return (Long) getProperty(translationNewVid).getValue();
    }

    public void setTranslationNewVid(Long aTranslationNewVid) {
        getProperty(translationNewVid).setValue(aTranslationNewVid);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(translationNewVid));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(translationNewVid));


        return loadAll(new int[]{2
                , 2
                , 1
                , 2
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(translationNewVid));

        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(translationNewVid));
        
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
    