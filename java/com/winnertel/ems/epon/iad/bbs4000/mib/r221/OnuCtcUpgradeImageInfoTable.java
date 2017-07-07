package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCtcUpgradeImageInfoTable extends SnmpMibBean {
    public static final String utsCtcTftpOamOnuUpgradeImageInfoVendorInfo = "utsCtcTftpOamOnuUpgradeImageInfoVendorInfo";
    public static final String utsCtcTftpOamOnuUpgradeImageInfoOnuType = "utsCtcTftpOamOnuUpgradeImageInfoOnuType";
    public static final String utsCtcTftpOamOnuUpgradeImageInfoImageName = "utsCtcTftpOamOnuUpgradeImageInfoImageName";
    public static final String utsCtcTftpOamOnuUpgradeImageInfoImageVersion = "utsCtcTftpOamOnuUpgradeImageInfoImageVersion";
    public static final String utsCtcTftpOamOnuUpgradeImageInfoImageDate = "utsCtcTftpOamOnuUpgradeImageInfoImageDate";

    public OnuCtcUpgradeImageInfoTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsCtcTftpOamOnuUpgradeImageInfoVendorInfo, new SnmpMibBeanProperty(utsCtcTftpOamOnuUpgradeImageInfoVendorInfo, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.1", ISnmpConstant.STRING));
        initProperty(utsCtcTftpOamOnuUpgradeImageInfoOnuType, new SnmpMibBeanProperty(utsCtcTftpOamOnuUpgradeImageInfoOnuType, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.2", ISnmpConstant.STRING));
        initProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName, new SnmpMibBeanProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.3", ISnmpConstant.STRING));
        initProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion, new SnmpMibBeanProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.4", ISnmpConstant.STRING));
        initProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate, new SnmpMibBeanProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.5", ISnmpConstant.STRING));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.7.5.1.100", ISnmpConstant.INTEGER));
    }

    public String getUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo() {
        return (String) getIndex(0);
    }

    public void setUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo(String autsCtcTftpOamOnuUpgradeImageInfoVendorInfo) {
        setIndex(0, autsCtcTftpOamOnuUpgradeImageInfoVendorInfo);
    }

    public String getUtsCtcTftpOamOnuUpgradeImageInfoOnuType() {
        return (String) getIndex(1);
    }

    public void setUtsCtcTftpOamOnuUpgradeImageInfoOnuType(String autsCtcTftpOamOnuUpgradeImageInfoOnuType) {
        setIndex(1, autsCtcTftpOamOnuUpgradeImageInfoOnuType);
    }

    public String getUtsCtcTftpOamOnuUpgradeImageInfoImageName() {
        return (String) getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName).getValue();
    }

    public void setUtsCtcTftpOamOnuUpgradeImageInfoImageName(String autsCtcTftpOamOnuUpgradeImageInfoImageName) {
        getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName).setValue(autsCtcTftpOamOnuUpgradeImageInfoImageName);
    }

    public String getUtsCtcTftpOamOnuUpgradeImageInfoImageVersion() {
        return (String) getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion).getValue();
    }

    public void setUtsCtcTftpOamOnuUpgradeImageInfoImageVersion(String autsCtcTftpOamOnuUpgradeImageInfoImageVersion) {
        getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion).setValue(autsCtcTftpOamOnuUpgradeImageInfoImageVersion);
    }

    public String getUtsCtcTftpOamOnuUpgradeImageInfoImageDate() {
        return (String) getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate).getValue();
    }

    public void setUtsCtcTftpOamOnuUpgradeImageInfoImageDate(String autsCtcTftpOamOnuUpgradeImageInfoImageDate) {
        getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate).setValue(autsCtcTftpOamOnuUpgradeImageInfoImageDate);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName));
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion));
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName));
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion));
        prepareRead(super.getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate));

        return loadAll(new int[] { -1, -1 });
    }

    public boolean add() throws MibBeanException {
        super.setRowStatus(new Integer(4));

        prepareSave(getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageName));
        prepareSave(getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageVersion));
        prepareSave(getProperty(utsCtcTftpOamOnuUpgradeImageInfoImageDate));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
}
