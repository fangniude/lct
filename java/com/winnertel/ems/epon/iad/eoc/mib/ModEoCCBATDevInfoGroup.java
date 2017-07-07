package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCCBATDevInfoGroup class.
 * Created by QuickDVM
 */
public class ModEoCCBATDevInfoGroup extends EocBaseSnmpMibBean {
    public static final String modEoCCBATAdminLogicalID = "modEoCCBATAdminLogicalID";
    public static final String modEoCCBATAdminTechProject = "modEoCCBATAdminTechProject";
    public static final String modEoCCBATAdminManufactoryInfo = "modEoCCBATAdminManufactoryInfo";
    public static final String modEoCCBATAdminModelNumber = "modEoCCBATAdminModelNumber";
    public static final String modEoCCBATAdminSerialNumber = "modEoCCBATAdminSerialNumber";
    public static final String modEoCCBATAdminSoftwareVersion = "modEoCCBATAdminSoftwareVersion";
    public static final String modEoCCBATAdminHardwareVersion = "modEoCCBATAdminHardwareVersion";
    public static final String modEoCCBATAdminVendorSpecialInfo = "modEoCCBATAdminVendorSpecialInfo";

    public ModEoCCBATDevInfoGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }


    protected void init() {
        initProperty(modEoCCBATAdminLogicalID, new SnmpMibBeanProperty(modEoCCBATAdminLogicalID, MIB_Head1 + ".1.1.1", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminTechProject, new SnmpMibBeanProperty(modEoCCBATAdminTechProject, MIB_Head1 + ".1.1.2", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminManufactoryInfo, new SnmpMibBeanProperty(modEoCCBATAdminManufactoryInfo, MIB_Head1 + ".1.1.3", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminModelNumber, new SnmpMibBeanProperty(modEoCCBATAdminModelNumber, MIB_Head1 + ".1.1.4", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminSerialNumber, new SnmpMibBeanProperty(modEoCCBATAdminSerialNumber, MIB_Head1 + ".1.1.5", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminSoftwareVersion, new SnmpMibBeanProperty(modEoCCBATAdminSoftwareVersion, MIB_Head1 + ".1.1.6", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminHardwareVersion, new SnmpMibBeanProperty(modEoCCBATAdminHardwareVersion, MIB_Head1 + ".1.1.7", ISnmpConstant.STRING));
        initProperty(modEoCCBATAdminVendorSpecialInfo, new SnmpMibBeanProperty(modEoCCBATAdminVendorSpecialInfo, MIB_Head1 + ".1.1.8", ISnmpConstant.STRING));

    }


    public String getModEoCCBATAdminLogicalID() {
        return (String) getProperty(modEoCCBATAdminLogicalID).getValue();
    }

    public void setModEoCCBATAdminLogicalID(String aModEoCCBATAdminLogicalID) {
        getProperty(modEoCCBATAdminLogicalID).setValue(aModEoCCBATAdminLogicalID);
    }

    public String getModEoCCBATAdminTechProject() {
        return (String) getProperty(modEoCCBATAdminTechProject).getValue();
    }

    public void setModEoCCBATAdminTechProject(String aModEoCCBATAdminTechProject) {
        getProperty(modEoCCBATAdminTechProject).setValue(aModEoCCBATAdminTechProject);
    }

    public String getModEoCCBATAdminManufactoryInfo() {
        return (String) getProperty(modEoCCBATAdminManufactoryInfo).getValue();
    }

    public void setModEoCCBATAdminManufactoryInfo(String aModEoCCBATAdminManufactoryInfo) {
        getProperty(modEoCCBATAdminManufactoryInfo).setValue(aModEoCCBATAdminManufactoryInfo);
    }

    public String getModEoCCBATAdminModelNumber() {
        return (String) getProperty(modEoCCBATAdminModelNumber).getValue();
    }

    public void setModEoCCBATAdminModelNumber(String aModEoCCBATAdminModelNumber) {
        getProperty(modEoCCBATAdminModelNumber).setValue(aModEoCCBATAdminModelNumber);
    }

    public String getModEoCCBATAdminSerialNumber() {
        return (String) getProperty(modEoCCBATAdminSerialNumber).getValue();
    }

    public void setModEoCCBATAdminSerialNumber(String aModEoCCBATAdminSerialNumber) {
        getProperty(modEoCCBATAdminSerialNumber).setValue(aModEoCCBATAdminSerialNumber);
    }

    public String getModEoCCBATAdminSoftwareVersion() {
        return (String) getProperty(modEoCCBATAdminSoftwareVersion).getValue();
    }

    public void setModEoCCBATAdminSoftwareVersion(String aModEoCCBATAdminSoftwareVersion) {
        getProperty(modEoCCBATAdminSoftwareVersion).setValue(aModEoCCBATAdminSoftwareVersion);
    }

    public String getModEoCCBATAdminHardwareVersion() {
        return (String) getProperty(modEoCCBATAdminHardwareVersion).getValue();
    }

    public void setModEoCCBATAdminHardwareVersion(String aModEoCCBATAdminHardwareVersion) {
        getProperty(modEoCCBATAdminHardwareVersion).setValue(aModEoCCBATAdminHardwareVersion);
    }

    public String getModEoCCBATAdminVendorSpecialInfo() {
        return (String) getProperty(modEoCCBATAdminVendorSpecialInfo).getValue();
    }

    public void setModEoCCBATAdminVendorSpecialInfo(String aModEoCCBATAdminVendorSpecialInfo) {
        getProperty(modEoCCBATAdminVendorSpecialInfo).setValue(aModEoCCBATAdminVendorSpecialInfo);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCCBATAdminLogicalID));
        prepareRead(super.getProperty(modEoCCBATAdminTechProject));
        prepareRead(super.getProperty(modEoCCBATAdminManufactoryInfo));
        prepareRead(super.getProperty(modEoCCBATAdminModelNumber));
        prepareRead(super.getProperty(modEoCCBATAdminSerialNumber));
        prepareRead(super.getProperty(modEoCCBATAdminSoftwareVersion));
        prepareRead(super.getProperty(modEoCCBATAdminHardwareVersion));
        prepareRead(super.getProperty(modEoCCBATAdminVendorSpecialInfo));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCCBATAdminLogicalID));

        return save();
    }
}