package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The PortVlanTable class.
 * Created by QuickDVM
 */
public class PortVlanTable extends SnmpMibBean {
    public static final String pvlanDeviceIndex = "pvlanDeviceIndex";
    public static final String pvlanCardIndex = "pvlanCardIndex";
    public static final String pvlanPortIndex = "pvlanPortIndex";
    public static final String vlanTagTpid = "vlanTagTpid";
    public static final String vlanTagCfi = "vlanTagCfi";
    public static final String vlanTagPriority = "vlanTagPriority";
    public static final String vlanPVid = "vlanPVid";
    public static final String vlanMode = "vlanMode";

    public PortVlanTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(pvlanDeviceIndex, new SnmpMibBeanProperty(pvlanDeviceIndex, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(pvlanCardIndex, new SnmpMibBeanProperty(pvlanCardIndex, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(pvlanPortIndex, new SnmpMibBeanProperty(pvlanPortIndex, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(vlanTagTpid, new SnmpMibBeanProperty(vlanTagTpid, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.4", ISnmpConstant.OCTETS));
        initProperty(vlanTagCfi, new SnmpMibBeanProperty(vlanTagCfi, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(vlanTagPriority, new SnmpMibBeanProperty(vlanTagPriority, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(vlanPVid, new SnmpMibBeanProperty(vlanPVid, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.7", ISnmpConstant.INTEGER));
        initProperty(vlanMode, new SnmpMibBeanProperty(vlanMode, ".1.3.6.1.4.1.17409.2.3.7.3.1.1.8", ISnmpConstant.INTEGER));

    }


    public Integer getPvlanDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setPvlanDeviceIndex(Integer aPvlanDeviceIndex) {
        setIndex(0, aPvlanDeviceIndex);
    }


    public Integer getPvlanCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setPvlanCardIndex(Integer aPvlanCardIndex) {
        setIndex(1, aPvlanCardIndex);
    }


    public Integer getPvlanPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setPvlanPortIndex(Integer aPvlanPortIndex) {
        setIndex(2, aPvlanPortIndex);
    }


    public byte[] getVlanTagTpid() {
        return (byte[]) getProperty(vlanTagTpid).getValue();
    }

    public void setVlanTagTpid(byte[] aVlanTagTpid) {
        getProperty(vlanTagTpid).setValue(aVlanTagTpid);
    }

    public Integer getVlanTagCfi() {
        return (Integer) getProperty(vlanTagCfi).getValue();
    }

    public void setVlanTagCfi(Integer aVlanTagCfi) {
        getProperty(vlanTagCfi).setValue(aVlanTagCfi);
    }

    public Integer getVlanTagPriority() {
        return (Integer) getProperty(vlanTagPriority).getValue();
    }

    public void setVlanTagPriority(Integer aVlanTagPriority) {
        getProperty(vlanTagPriority).setValue(aVlanTagPriority);
    }

    public Integer getVlanPVid() {
        return (Integer) getProperty(vlanPVid).getValue();
    }

    public void setVlanPVid(Integer aVlanPVid) {
        getProperty(vlanPVid).setValue(aVlanPVid);
    }

    public Integer getVlanMode() {
        return (Integer) getProperty(vlanMode).getValue();
    }

    public void setVlanMode(Integer aVlanMode) {
        getProperty(vlanMode).setValue(aVlanMode);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(vlanTagTpid));
        prepareRead(super.getProperty(vlanTagCfi));
        prepareRead(super.getProperty(vlanTagPriority));
        prepareRead(super.getProperty(vlanPVid));
        prepareRead(super.getProperty(vlanMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(vlanTagTpid));
        prepareRead(super.getProperty(vlanTagCfi));
        prepareRead(super.getProperty(vlanTagPriority));
        prepareRead(super.getProperty(vlanPVid));
        prepareRead(super.getProperty(vlanMode));

        return loadAll(new int[]{1
                , 1
                , 1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(vlanTagTpid));
        prepareSave(getProperty(vlanTagCfi));
        prepareSave(getProperty(vlanTagPriority));
        prepareSave(getProperty(vlanPVid));
        prepareSave(getProperty(vlanMode));

        return save();
    }


}