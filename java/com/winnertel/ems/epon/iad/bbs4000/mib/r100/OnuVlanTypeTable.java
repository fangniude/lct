package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuVlanTypeTable class. Created by QuickDVM
 */
public class OnuVlanTypeTable extends SnmpMibBean {
    public static final String onuVlanTypeSlotNo = "onuVlanTypeSlotNo";
    public static final String onuVlanTypePortNo = "onuVlanTypePortNo";
    public static final String onuVlanTypeLogicalPortNo = "onuVlanTypeLogicalPortNo";
    public static final String onuVlanTypeVirtualPortNo = "onuVlanTypeVirtualPortNo";
    public static final String onuVlanTypeNewSVLAN = "onuVlanTypeNewSVLAN";
    public static final String onuVlanTypeNewCVLAN = "onuVlanTypeNewCVLAN";
    public static final String onuVlanType = "onuVlanType";

    public OnuVlanTypeTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanTypeSlotNo, new SnmpMibBeanProperty(onuVlanTypeSlotNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.1", ISnmpConstant.INTEGER));
        initProperty(onuVlanTypePortNo, new SnmpMibBeanProperty(onuVlanTypePortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.2", ISnmpConstant.INTEGER));
        initProperty(onuVlanTypeLogicalPortNo, new SnmpMibBeanProperty(onuVlanTypeLogicalPortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.3", ISnmpConstant.INTEGER));
        initProperty(onuVlanTypeVirtualPortNo, new SnmpMibBeanProperty(onuVlanTypeVirtualPortNo,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.4", ISnmpConstant.INTEGER));
        initProperty(onuVlanTypeNewSVLAN, new SnmpMibBeanProperty(onuVlanTypeNewSVLAN,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.5", ISnmpConstant.INTEGER));
        initProperty(onuVlanTypeNewCVLAN, new SnmpMibBeanProperty(onuVlanTypeNewCVLAN,
                ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.6", ISnmpConstant.INTEGER));
        initProperty(onuVlanType, new SnmpMibBeanProperty(onuVlanType, ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.7",
                ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1000.1.1.100",
                ISnmpConstant.INTEGER));

    }

    public Integer getOnuVlanTypeSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuVlanTypeSlotNo(Integer aOnuVlanTypeSlotNo) {
        setIndex(0, aOnuVlanTypeSlotNo);
    }

    public Integer getOnuVlanTypePortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuVlanTypePortNo(Integer aOnuVlanTypePortNo) {
        setIndex(1, aOnuVlanTypePortNo);
    }

    public Integer getOnuVlanTypeLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuVlanTypeLogicalPortNo(Integer aOnuVlanTypeLogicalPortNo) {
        setIndex(2, aOnuVlanTypeLogicalPortNo);
    }

    public Integer getOnuVlanTypeVirtualPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuVlanTypeVirtualPortNo(Integer aOnuVlanTypeVirtualPortNo) {
        setIndex(3, aOnuVlanTypeVirtualPortNo);
    }

    public Integer getOnuVlanTypeNewSVLAN() {
        return (Integer) getIndex(4);
    }

    public void setOnuVlanTypeNewSVLAN(Integer aOnuVlanTypeNewSVLAN) {
        setIndex(4, aOnuVlanTypeNewSVLAN);
    }

    public Integer getOnuVlanTypeNewCVLAN() {
        return (Integer) getIndex(5);
    }

    public void setOnuVlanTypeNewCVLAN(Integer aOnuVlanTypeNewCVLAN) {
        setIndex(5, aOnuVlanTypeNewCVLAN);
    }

    public Integer getOnuVlanType() {
        return (Integer) getProperty(onuVlanType).getValue();
    }

    public void setOnuVlanType(Integer aOnuVlanType) {
        getProperty(onuVlanType).setValue(aOnuVlanType);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanType));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanType));

        return loadAll(new int[] { 1, 1, 1, 1, 1, 1 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVlanType));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVlanType));
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
