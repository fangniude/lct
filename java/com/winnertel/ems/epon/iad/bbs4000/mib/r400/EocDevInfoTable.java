/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;


import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EocDevInfoTable extends SnmpMibBean {

    public static final String eocDeviceIndex = "eocDeviceIndex";
    public static final String eocCardIndex = "eocCardIndex";
    public static final String eocPortIndex = "eocPortIndex";
    public static final String eocDeviceTechnologyProject = "eocDeviceTechnologyProject";
    public static final String eocDeviceVendorName = "eocDeviceVendorName";
    public static final String eocDeviceProductType = "eocDeviceProductType";
    public static final String eocDeviceSoftwareVersion = "eocDeviceSoftwareVersion";
    public static final String eocDeviceHardwareVersion = "eocDeviceHardwareVersion";
    public static final String eocSeriesNumber = "eocSeriesNumber";
    public static final String eocDeviceIpAddress = "eocDeviceIpAddress";
    public static final String eocDeviceMacAddress = "eocDeviceMacAddress";
    public static final String eocDeviceMibVersion = "eocDeviceMibVersion";

    public EocDevInfoTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(eocDeviceIndex, new SnmpMibBeanProperty(eocDeviceIndex, ".1.3.6.1.4.1.17409.2.3.11.1.1.1", ISnmpConstant.INTEGER));
        initProperty(eocCardIndex, new SnmpMibBeanProperty(eocCardIndex, ".1.3.6.1.4.1.17409.2.3.11.1.1.2", ISnmpConstant.INTEGER));
        initProperty(eocPortIndex, new SnmpMibBeanProperty(eocPortIndex, ".1.3.6.1.4.1.17409.2.3.11.1.1.3", ISnmpConstant.INTEGER));
        initProperty(eocDeviceTechnologyProject, new SnmpMibBeanProperty(eocDeviceTechnologyProject, ".1.3.6.1.4.1.17409.2.3.11.1.1.4", ISnmpConstant.STRING));
        initProperty(eocDeviceVendorName, new SnmpMibBeanProperty(eocDeviceVendorName, ".1.3.6.1.4.1.17409.2.3.11.1.1.5", ISnmpConstant.STRING));
        initProperty(eocDeviceProductType, new SnmpMibBeanProperty(eocDeviceProductType, ".1.3.6.1.4.1.17409.2.3.11.1.1.6", ISnmpConstant.STRING));
        initProperty(eocDeviceSoftwareVersion, new SnmpMibBeanProperty(eocDeviceSoftwareVersion, ".1.3.6.1.4.1.17409.2.3.11.1.1.7", ISnmpConstant.STRING));
        initProperty(eocDeviceHardwareVersion, new SnmpMibBeanProperty(eocDeviceHardwareVersion, ".1.3.6.1.4.1.17409.2.3.11.1.1.8", ISnmpConstant.STRING));
        initProperty(eocSeriesNumber, new SnmpMibBeanProperty(eocSeriesNumber, ".1.3.6.1.4.1.17409.2.3.11.1.1.9", ISnmpConstant.STRING));
        initProperty(eocDeviceIpAddress, new SnmpMibBeanProperty(eocDeviceIpAddress, ".1.3.6.1.4.1.17409.2.3.11.1.1.10", ISnmpConstant.STRING));
        initProperty(eocDeviceMacAddress, new SnmpMibBeanProperty(eocDeviceMacAddress, ".1.3.6.1.4.1.17409.2.3.11.1.1.11", ISnmpConstant.MAC_ADDRESS));
        initProperty(eocDeviceMibVersion, new SnmpMibBeanProperty(eocDeviceMibVersion, ".1.3.6.1.4.1.17409.2.3.11.1.1.12", ISnmpConstant.STRING));
    }

    public Integer getEocDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setEocDeviceIndex(Integer aEDeviceIndex) {
        setIndex(0, aEDeviceIndex);
    }

    public Integer getEocCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setEocCardIndex(Integer aECardIndex) {
        setIndex(1, aECardIndex);
    }

    public Integer getEocPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setEocPortIndex(Integer aEPortIndex) {
        setIndex(2, aEPortIndex);
    }

    public String getEocDeviceTechnologyProject() {
        return (String) getProperty(eocDeviceTechnologyProject).getValue();
    }

    public void setEocDeviceTechnologyProject(String aEocDeviceTechnologyProject) {
        getProperty(eocDeviceTechnologyProject).setValue(aEocDeviceTechnologyProject);
    }

    public String getEocDeviceVendorName() {
        return (String) getProperty(eocDeviceVendorName).getValue();
    }

    public void setEocDeviceVendorName(String aEocDeviceVendorName) {
        getProperty(eocDeviceVendorName).setValue(aEocDeviceVendorName);
    }

    public String getEocDeviceProductType() {
        return (String) getProperty(eocDeviceProductType).getValue();
    }

    public void setEocDeviceProductType(String aEocDeviceProductType) {
        getProperty(eocDeviceProductType).setValue(aEocDeviceProductType);
    }

    public String getEocDeviceSoftwareVersion() {
        return (String) getProperty(eocDeviceSoftwareVersion).getValue();
    }

    public void setEocDeviceSoftwareVersion(String aEocDeviceSoftwareVersion) {
        getProperty(eocDeviceSoftwareVersion).setValue(aEocDeviceSoftwareVersion);
    }

    public String getEocDeviceHardwareVersion() {
        return (String) getProperty(eocDeviceHardwareVersion).getValue();
    }

    public void setEocDeviceHardwareVersion(String aEocDeviceHardwareVersion) {
        getProperty(eocDeviceHardwareVersion).setValue(aEocDeviceHardwareVersion);
    }

    public String getEocSeriesNumber() {
        return (String) getProperty(eocSeriesNumber).getValue();
    }

    public void setEocSeriesNumber(String aEocSeriesNumber) {
        getProperty(eocSeriesNumber).setValue(aEocSeriesNumber);
    }

    public String getEocDeviceIpAddress() {
        return (String) getProperty(eocDeviceIpAddress).getValue();
    }

    public void setEocDeviceIpAddress(String aEocDeviceIpAddress) {
        getProperty(eocDeviceIpAddress).setValue(aEocDeviceIpAddress);
    }

    public byte[] getEocDeviceMacAddress() {
        return (byte[]) getProperty(eocDeviceMacAddress).getValue();
    }

    public void setEocDeviceMacAddress(byte[] aEocDeviceMacAddress) {
        getProperty(eocDeviceMacAddress).setValue(aEocDeviceMacAddress);
    }

    public String getEocDeviceMibVersion() {
        return (String) getProperty(eocDeviceMibVersion).getValue();
    }

    public void setEocDeviceMibVersion(String aEocDeviceMibVersion) {
        getProperty(eocDeviceMibVersion).setValue(aEocDeviceMibVersion);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(eocDeviceTechnologyProject));
        prepareRead(getProperty(eocDeviceVendorName));
        prepareRead(getProperty(eocDeviceProductType));
        prepareRead(getProperty(eocDeviceSoftwareVersion));
        prepareRead(getProperty(eocDeviceHardwareVersion));
        prepareRead(getProperty(eocSeriesNumber));
        prepareRead(getProperty(eocDeviceIpAddress));
        prepareRead(getProperty(eocDeviceMacAddress));
        prepareRead(getProperty(eocDeviceMibVersion));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(eocDeviceTechnologyProject));
        prepareRead(getProperty(eocDeviceVendorName));
        prepareRead(getProperty(eocDeviceProductType));
        prepareRead(getProperty(eocDeviceSoftwareVersion));
        prepareRead(getProperty(eocDeviceHardwareVersion));
        prepareRead(getProperty(eocSeriesNumber));
        prepareRead(getProperty(eocDeviceIpAddress));
        prepareRead(getProperty(eocDeviceMacAddress));
        prepareRead(getProperty(eocDeviceMibVersion));

        return loadAll(new int[]{1, 1, 1});
    }

    public Vector retrieveByONU(Integer eDeviceIndex) throws MibBeanException {
        setEocDeviceIndex(eDeviceIndex);
        setIndexPrefix(eDeviceIndex + ".");

        prepareRead(getProperty(eocDeviceTechnologyProject));
        prepareRead(getProperty(eocDeviceVendorName));
        prepareRead(getProperty(eocDeviceProductType));
        prepareRead(getProperty(eocDeviceSoftwareVersion));
        prepareRead(getProperty(eocDeviceHardwareVersion));
        prepareRead(getProperty(eocSeriesNumber));
        prepareRead(getProperty(eocDeviceIpAddress));
        prepareRead(getProperty(eocDeviceMacAddress));
        prepareRead(getProperty(eocDeviceMibVersion));

        return loadAll(new int[]{1, 1, 1});
    }

    public EocDevInfoTable retrieveByIP(String ip) throws MibBeanException {
        Vector allEocVec = retrieveAll();
        for (int i=0;i<allEocVec.size();i++){
            EocDevInfoTable oneEoc = (EocDevInfoTable)allEocVec.get(i);
            if (ip.equalsIgnoreCase(oneEoc.getEocDeviceIpAddress())){
                return oneEoc;
            }
        }
        return null;
    }
}