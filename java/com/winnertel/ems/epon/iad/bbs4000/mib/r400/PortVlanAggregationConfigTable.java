package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortVlanAggregationConfigTable class.
 * Created by QuickDVM
 */
public class PortVlanAggregationConfigTable extends SnmpMibBean {
    public static final String pvaDeviceIndex = "pvaDeviceIndex";
    public static final String pvaCardIndex = "pvaCardIndex";
    public static final String pvaPortIndex = "pvaPortIndex";
    public static final String portAggregationVidIndex = "portAggregationVidIndex";
    public static final String aggregationVidList = "aggregationVidList";


    public PortVlanAggregationConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(pvaDeviceIndex, new SnmpMibBeanProperty(pvaDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(pvaCardIndex, new SnmpMibBeanProperty(pvaCardIndex, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(pvaPortIndex, new SnmpMibBeanProperty(pvaPortIndex, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(portAggregationVidIndex, new SnmpMibBeanProperty(portAggregationVidIndex, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(aggregationVidList, new SnmpMibBeanProperty(aggregationVidList, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.5", ISnmpConstant.OCTETS));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.7.3.3.1.1.6", ISnmpConstant.INTEGER));

    }


    public Integer getPvaDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPvaDeviceIndex(Integer aPvaDeviceIndex) {
        setIndex(0, aPvaDeviceIndex);
    }


    public Integer getPvaCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setPvaCardIndex(Integer aPvaCardIndex) {
        setIndex(1, aPvaCardIndex);
    }


    public Integer getPvaPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPvaPortIndex(Integer aPvaPortIndex) {
        setIndex(2, aPvaPortIndex);
    }


    public Integer getPortAggregationVidIndex() {
        return (Integer) getIndex(3);
    }

    public void setPortAggregationVidIndex(Integer aPortAggregationVidIndex) {
        setIndex(3, aPortAggregationVidIndex);
    }


    public byte[] getAggregationVidList() {
        return (byte[]) getProperty(aggregationVidList).getValue();
    }

    public void setAggregationVidList(byte[] aAggregationVidList) {
        getProperty(aggregationVidList).setValue(aAggregationVidList);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(aggregationVidList));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(aggregationVidList));


        return loadAll(new int[]{1
                , 1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(aggregationVidList));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(aggregationVidList));

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