package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SystemInfoMbean class.
 * Created by QuickDVM
 */
public class SystemInfoMBean extends SnmpMibBean {

    public static final String sysDescr = "sysDescr";
    public static final String sysObjectID = "sysObjectID";
    public static final String sysUpTime = "sysUpTime";
    public static final String sysContact = "sysContact";
    public static final String sysName = "sysName";
    public static final String sysLocation = "sysLocation";
    public static final String sysServices = "sysServices";

    public SystemInfoMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(sysDescr, new SnmpMibBeanProperty(sysDescr, ".1.3.6.1.2.1.1.1", ISnmpConstant.STRING));
        initProperty(sysObjectID, new SnmpMibBeanProperty(sysObjectID, ".1.3.6.1.2.1.1.2", ISnmpConstant.OBJID));
        initProperty(sysUpTime, new SnmpMibBeanProperty(sysUpTime, ".1.3.6.1.2.1.1.3", ISnmpConstant.TIME_TICKS));
        initProperty(sysContact, new SnmpMibBeanProperty(sysContact, ".1.3.6.1.2.1.1.4", ISnmpConstant.STRING));
        initProperty(sysName, new SnmpMibBeanProperty(sysName, ".1.3.6.1.2.1.1.5", ISnmpConstant.STRING));
        initProperty(sysLocation, new SnmpMibBeanProperty(sysLocation, ".1.3.6.1.2.1.1.6", ISnmpConstant.STRING));
//        initProperty(sysServices, new SnmpMibBeanProperty(sysServices, ".1.3.6.1.2.1.1.7", ISnmpConstant.INTEGER));
    }

    public String getSysDescr() {
        return (String) getProperty(sysDescr).getValue();
    }

    public void setSysDescr(String aSysDescr) {
        getProperty(sysDescr).setValue(aSysDescr);
    }

    public String getSysObjectID() {
        String oid = (String) getProperty(sysObjectID).getValue();
        return translateNeType(oid);
    }

    public void setSysObjectID(String aSysObjectID) {
        getProperty(sysObjectID).setValue(aSysObjectID);
    }

    public String getSysUpTime() {
        Long time = (Long) getProperty(sysUpTime).getValue();
        return ConfigUtility.formatSysUpTime(time.longValue());
    }

    public void setSysUpTime(Long aSysUpTime) {
        getProperty(sysUpTime).setValue(ConfigUtility.formatSysUpTime(aSysUpTime.longValue()));
    }

    public String getSysContact() {
        return (String) getProperty(sysContact).getValue();
    }

    public void setSysContact(String aSysContact) {
        getProperty(sysContact).setValue(aSysContact);
    }

    public String getSysName() {
        return (String) getProperty(sysName).getValue();
    }

    public void setSysName(String aSysName) {
        getProperty(sysName).setValue(aSysName);
    }

    public String getSysLocation() {
        return (String) getProperty(sysLocation).getValue();
    }

    public void setSysLocation(String aSysLocation) {
        getProperty(sysLocation).setValue(aSysLocation);
    }

    public String getSysServices() {
        int service = ((Integer) getProperty(sysServices).getValue());
        return checkServiceType(service);
    }

    public void setSysServices(Integer aSysServices) {
        getProperty(sysServices).setValue(checkServiceType(aSysServices));
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(sysDescr));
        prepareRead(getProperty(sysObjectID));
        prepareRead(getProperty(sysUpTime));
        prepareRead(getProperty(sysContact));
        prepareRead(getProperty(sysName));
        prepareRead(getProperty(sysLocation));
//        prepareRead(getProperty(sysServices));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(sysContact));
        prepareSave(getProperty(sysName));
        prepareSave(getProperty(sysLocation));

        return save();
    }

    private static String translateNeType(String oid) {
        if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.1"))
            return "BBS1000";
        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.2"))
            return "BBS5000";
        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.3"))
            return "FBW5000";
        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.4"))
            return "BBS2000";
        else if (oid.equals(".1.3.6.1.4.1.45121.1.3.10.2.5"))
            return "BBS1000plus";
        else
            return oid;
    }

    private String checkServiceType(int type) {
        String strResult = "";
        if ((type & 0X01) != 0) {
            strResult = "Physical ";
        }
        if ((type & 0X02) != 0) {
            strResult = strResult + "Datalink/Subnetwork ";
        }
        if ((type & 0X04) != 0) {
            strResult = strResult + "Internet ";
        }
        if ((type & 0X08) != 0) {
            strResult = strResult + "Applications";
        }

        return strResult;
    }

}