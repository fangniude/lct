package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r200.Dot3Onu2CtcSerialNumberFormatter;
import com.winnertel.ems.epon.iad.bbs4000.model.IfIndex;
import com.winnertel.ems.epon.inventory.OnuMODHelper;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;

import java.util.Properties;
import java.util.Vector;

public class OnuMonitorTable extends SnmpMibBean {

    public static final String ifOnuIndex = "ifOnuIndex";
    public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
    public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
    public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
    public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
    public static final String utsDot3Onu2LoidAuthLoid = "utsDot3Onu2LoidAuthLoid";
    //public static final String utsDot3Onu2CtcLlid = "utsDot3Onu2CtcLlid";
    public static final String utsDot3Onu2SerialNumber = "utsDot3Onu2SerialNumber";
    public static final String utsDot3Onu2CtcRegisterStatus = "utsDot3Onu2CtcRegisterStatus";
    public static final String utsDot3Onu2CtcLinkStatus = "utsDot3Onu2CtcLinkStatus";
    public static final String utsDot3Onu2CtcPowerStatus = "utsDot3Onu2CtcPowerStatus";
    public static final String utsDot3Onu2CtcReset = "utsDot3Onu2CtcReset";

    private Integer linkStatus = null;
    private Integer powerStatus = null;
    private String onuLabel = null;
    private String switchIp = null;
    private String utsDot3Onu2CtcOnuMacAddr = null;

    /**
     *  Indicating whether the onu has been registered once or not.
     *  The init value is 0 when the records create, for example, just bound ONU, the value shall be 0, if the ONU registered, change the value to 1.
     *  if the records is created by ONU registered event, the value will be 1;
     *  the value will be reset to 0 until recieve the unbound event.
     */
    private int registeredever;

    private boolean isDyingGasp;

    public static final int STATUS_NOT_EXIST = 0;
    public static final int STATUS_ON_LINE = 1;
    public static final int STATUS_OFF_LINE = 2;
    private int status = STATUS_NOT_EXIST;

    public OnuMonitorTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2LoidAuthLoid, new SnmpMibBeanProperty(utsDot3Onu2LoidAuthLoid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.17.1.7", ISnmpConstant.STRING));
        //initProperty(utsDot3Onu2CtcLlid, new SnmpMibBeanProperty(utsDot3Onu2CtcLlid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2SerialNumber, new SnmpMibBeanProperty(utsDot3Onu2SerialNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.8", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcRegisterStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcRegisterStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.33", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcReset, new SnmpMibBeanProperty(utsDot3Onu2CtcReset, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.32", ISnmpConstant.INTEGER));
    }

    public IfIndex getIfOnuIndex() {
        return new IfIndex(getIndex(0) + "/" + getIndex(2) + "/" + getIndex(3));
    }

    public String getUtsDot3Onu2CtcOnuMacAddr() {
        //return Dot3Onu2CtcSerialNumberFormatter.getMacAddress((byte[]) getProperty(utsDot3Onu2SerialNumber).getValue());
        return utsDot3Onu2CtcOnuMacAddr;
    }

    public void setUtsDot3Onu2CtcOnuMacAddr(String aUtsDot3Onu2CtcOnuMacAddr) {
        utsDot3Onu2CtcOnuMacAddr = aUtsDot3Onu2CtcOnuMacAddr;
    }

    public void setIfOnuIndex(IfIndex ifIndex) {
        String[] split = ifIndex.getIfIndex().split("/");
        setIndex(0, new Integer(split[0]));
        setIndex(1, new Integer(1));
        setIndex(2, new Integer(split[1]));
        setIndex(3, new Integer(split[2]));
    }

    public Integer getUtsDot3Onu2CtcModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcModuleId(Integer autsDot3Onu2CtcModuleId) {
        setIndex(0, autsDot3Onu2CtcModuleId);
    }

    public Integer getUtsDot3Onu2CtcDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcDeviceId(Integer autsDot3Onu2CtcDeviceId) {
        setIndex(1, autsDot3Onu2CtcDeviceId);
    }

    public Integer getUtsDot3Onu2CtcPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcPortId(Integer autsDot3Onu2CtcPortId) {
        setIndex(2, autsDot3Onu2CtcPortId);
    }

    public Integer getUtsDot3Onu2CtcLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcLogicalPortId(Integer autsDot3Onu2CtcLogicalPortId) {
        setIndex(3, autsDot3Onu2CtcLogicalPortId);
    }

    public String getUtsDot3Onu2LoidAuthLoid() {
        return (String) getProperty(utsDot3Onu2LoidAuthLoid).getValue();
    }

    public void setUtsDot3Onu2LoidAuthLoid(String aUtsDot3Onu2LoidAuthLoid) {
        getProperty(utsDot3Onu2LoidAuthLoid).setValue(aUtsDot3Onu2LoidAuthLoid);
    }

    /*
    public Integer getUtsDot3Onu2CtcLlid() {
        return (Integer) getProperty(utsDot3Onu2CtcLlid).getValue();
    }

    public void setUtsDot3Onu2CtcLlid(Integer autsDot3Onu2CtcLlid) {
        getProperty(utsDot3Onu2CtcLlid).setValue(autsDot3Onu2CtcLlid);
    }
    */

    public byte[] getUtsDot3Onu2SerialNumber() {
        return (byte[]) getProperty(utsDot3Onu2SerialNumber).getValue();
    }

    public void setUtsDot3Onu2SerialNumber(byte[] aUtsDot3Onu2SerialNumber) {
        getProperty(utsDot3Onu2SerialNumber).setValue(aUtsDot3Onu2SerialNumber);
    }

    public String getOnuType() {
        byte[] value = getUtsDot3Onu2SerialNumber();
        String onuType = "unknown";
        try {
            if (value != null) {
                //onuType = Dot3Onu2CtcSerialNumberFormatter.getOnuType(new String(value, 4, 4, "ISO-8859-1")); //remarked by Zhou Chao
                onuType = OnuMODHelper.convertHwType(new String(value, 4, 4, "ISO-8859-1")); //modified by Zhou Chao
                if(onuType.trim().length() == 0) onuType = "unknown";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return onuType;
    }

    public void setOnuType(String type) {
    }

    public Integer getUtsDot3Onu2CtcRegisterStatus() {
        return (Integer) getProperty(utsDot3Onu2CtcRegisterStatus).getValue();
    }

    public void setUtsDot3Onu2CtcRegisterStatus(Integer autsDot3Onu2CtcRegisterStatus) {
        getProperty(utsDot3Onu2CtcRegisterStatus).setValue(autsDot3Onu2CtcRegisterStatus);
    }

    public Integer getUtsDot3Onu2CtcLinkStatus() {
        return linkStatus;
    }

    public void setUtsDot3Onu2CtcLinkStatus(Integer aUtsDot3Onu2CtcLinkStatus) {
        linkStatus = aUtsDot3Onu2CtcLinkStatus;
    }

    public Integer getUtsDot3Onu2CtcPowerStatus() {
        return powerStatus;
    }

    public void setUtsDot3Onu2CtcPowerStatus(Integer aUtsDot3Onu2CtcPowerStatus) {
        powerStatus = aUtsDot3Onu2CtcPowerStatus;
    }

    public String getOnuLabel() {
        return onuLabel;
    }

    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public String getSwitchIp() {
        return switchIp;
    }

    public void setSwitchIp(String ip) {
        switchIp = ip;
    }

    public int getRegisteredever() {
        return registeredever;
    }

    public void setRegisteredever(int registeredever) {
        this.registeredever = registeredever;
    }

    public boolean isDyingGasp() {
        return isDyingGasp;
    }

    public void setDyingGasp(boolean dyingGasp) {
        isDyingGasp = dyingGasp;
    }

    public Integer getUtsDot3Onu2CtcReset() {
        return (Integer) getProperty(utsDot3Onu2CtcReset).getValue();
    }

    public void setUtsDot3Onu2CtcReset(Integer aUtsDot3Onu2CtcReset3) {
        getProperty(utsDot3Onu2CtcReset).setValue(aUtsDot3Onu2CtcReset3);
    }

    public int getUtsDot3Onu2CtcStatus() {
        return status;
    }

    public void setUtsDot3Onu2CtcStatus(int status) {
        this.status = status;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
        //prepareRead(getProperty(utsDot3Onu2CtcLlid));
        prepareRead(getProperty(utsDot3Onu2SerialNumber));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));

        try {
            OnuSwitchTable switchBean = new OnuSwitchTable(fSnmpProxy);
            switchBean.setUtsDot3OnuSwitchModuleId(getUtsDot3Onu2CtcModuleId());
            switchBean.setUtsDot3OnuSwitchPortId(getUtsDot3Onu2CtcPortId());
            switchBean.setUtsDot3OnuSwitchLogicalPortId(getUtsDot3Onu2CtcLogicalPortId());
            switchBean.retrieve();
            setSwitchIp(switchBean.getUtsDot3OnuSwitchIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String mac = Dot3Onu2CtcSerialNumberFormatter.getMacAddress(getUtsDot3Onu2SerialNumber());
            if (mac != null && !mac.equals("00-00-00-00-00-00") && !mac.equals("00:00:00:00:00:00")) {
                setUtsDot3Onu2CtcOnuMacAddr(mac.toUpperCase());
            } else {
                Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fSnmpProxy);
                macBean.setUtsDot3OnuValidOnuMacModuleId(getUtsDot3Onu2CtcModuleId());
                macBean.setUtsDot3OnuValidOnuMacDeviceId(getUtsDot3Onu2CtcDeviceId());
                macBean.setUtsDot3OnuValidOnuMacPortId(getUtsDot3Onu2CtcPortId());
                macBean.setUtsDot3OnuValidOnuMacAppLPortId(getUtsDot3Onu2CtcLogicalPortId());
                macBean.retrieve();
                setUtsDot3Onu2CtcOnuMacAddr(MacAddressFormatter.format(macBean.getUtsDot3ValidOnuMacAddr()).toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));
        //prepareRead(getProperty(utsDot3Onu2CtcLlid));
        prepareRead(getProperty(utsDot3Onu2SerialNumber));
        prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));

        return loadAll(new int[]{1, 1, 1, 1});
//        String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//        GuiUtils.initDyingGaspInfo(neName);

//        Vector v = null;
//        try {
//            if (!DebugMode.isDebug()) {
//                ObjectFactory factory = ClientUtility.getObjectFactory();
//                Properties tProperties = ClientUtility.getNePropertiesByNeName(neName);
//                String neType = "";
//                String neVersion = "";
//                if (tProperties != null) {
//                    neType = tProperties.getProperty("neType", "FBW5000");
//                    try {
//                        neVersion = SnmpUtility.getNeTotalVersion(neType, fSnmpProxy.getTargetHost(), fSnmpProxy.getTargetPort(), fSnmpProxy.getReadCommunity());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                Vector switchVector = null;
//                if (!((neType.equals("FBW5000")  && neVersion.startsWith("3.1") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.1.1.6")) ||
//                	  (neType.equals("FBW5000")  && neVersion.startsWith("2.2") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "2.2.1.6")) ||
//                	  (neType.equals("FBW3000") && neVersion.startsWith("3.4") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.4.1.8")))) {
//                    try {
//                        OnuSwitchTable switchBean = new OnuSwitchTable(fSnmpProxy);
//                        //filter the result. OnuSwitchTable has 3 indices, OnuMonitorTable has 4 indices.
//                        switchBean.setIndex(0, getIndex(0));
//                        switchBean.setIndex(1, getIndex(2));
//                        switchBean.setIndex(2, getIndex(3));
//                        String prefix = getIndexPrefix();
//                        if (prefix != null) {
//                            String[] split = prefix.split("\\.");
//
//                            //remove the ".1." (deviceId) from prefix.
//                            if (split.length > 2) {
//                                StringBuffer sb = new StringBuffer();
//                                for (int i = 0; i < split.length; i++) {
//                                    if (i != 1) {
//                                        sb.append(split[i]).append(".");
//                                    }
//                                }
//                                switchBean.setIndexPrefix(sb.toString());
//                            } else {
//                                switchBean.setIndexPrefix(getIndexPrefix());
//                            }
//                        }
//                        switchVector = switchBean.retrieveAll();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
                
//                Vector tftpOnuInfoSyncTableVector = null;
//                Vector tftpOnuBindingTableVector = null;
//                MibProxyMgr mibMgr = null;
                
//                if (((neType.equals("FBW5000") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.1.1.11"))
//                		&& !neVersion.equalsIgnoreCase("3.1.1.500")) || (neType.equals("FBW3000") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.4.1.8"))) {
//                	mibMgr = GuiUtils.getMibProxyMgr(fSnmpProxy);
//                	if (mibMgr != null) {
//                		if (getIndexPrefix() == null) {
//                			tftpOnuInfoSyncTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuInfoSyncTable", null);
//                			tftpOnuBindingTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuBindingTable", null);
//                		} else {
//                			int[] indexs = { 0, (Integer) getIndex(0), (Integer) getIndex(2)};
//                			tftpOnuInfoSyncTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuInfoSyncTable", indexs);
//                			tftpOnuBindingTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuBindingTable", indexs);
//                		}
//                	}
//                } else {
//                	mibMgr = GuiUtils.getMibProxyMgr(fSnmpProxy);
//                	if (mibMgr != null) {
//                		tftpOnuInfoSyncTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuInfoSyncTable", null);
//                		tftpOnuBindingTableVector = GuiUtils.retrieveFtpFile(mibMgr, neName, "onuBindingTable", null);
//                	}
//                }



//                if (tftpOnuInfoSyncTableVector != null && tftpOnuBindingTableVector != null) {
//                    if (v == null)
//                        v = new Vector();
//                    int module1 = (getIndex(0) != null ? Integer.valueOf(getIndex(0).toString()) : 0);
//                    int device1 = (getIndex(1) != null ? Integer.valueOf(getIndex(1).toString()) : 0);
//                    int port1 = (getIndex(2) != null ? Integer.valueOf(getIndex(2).toString()) : 0);
//
//                    for(int i = 0; i < tftpOnuBindingTableVector.size(); i++) {
//                    	Vector data2 = (Vector) tftpOnuBindingTableVector.get(i);
//                        int module2 = (Integer) data2.get(0);
//                        int device2 = (Integer) data2.get(1);
//                        int port2 = (Integer) data2.get(2);
//                        int logicalPort2 = (Integer) data2.get(3);
//
//                        OnuMonitorTable monitor = new OnuMonitorTable(fSnmpProxy);
//                        monitor.setUtsDot3Onu2CtcModuleId(module2);
//                        monitor.setUtsDot3Onu2CtcDeviceId(device2);
//                        monitor.setUtsDot3Onu2CtcPortId(port2);
//                        monitor.setUtsDot3Onu2CtcLogicalPortId(logicalPort2);
//                        String mac2 = Dot3Onu2CtcSerialNumberFormatter.getMacAddress((byte[]) data2.get(4));
//                        if (mac2 == null || mac2.length() <= 0 || mac2.equals("00-00-00-00-00-00") || mac2.equals("00:00:00:00:00:00")) {
//                            monitor.setUtsDot3Onu2CtcOnuMacAddr("00:00:00:00:00:00");
//                        } else {
//                            monitor.setUtsDot3Onu2CtcOnuMacAddr(MacAddressFormatter.format((byte[]) data2.get(4)).toUpperCase());
//                        }
//                        monitor.setUtsDot3Onu2LoidAuthLoid(data2.get(6) != null ? new String((byte[]) data2.get(6)).trim() : "");
//                        monitor.setUtsDot3Onu2CtcRegisterStatus(2); // deregister(2)
//
//                        if (module1 != 0 && module1 != monitor.getUtsDot3Onu2CtcModuleId())
//                            continue;
//                        if (device1 != 0 && device1 != monitor.getUtsDot3Onu2CtcDeviceId())
//                            continue;
//                        if (port1 != 0 && port1 != monitor.getUtsDot3Onu2CtcPortId())
//                            continue;
//
//                        for (int j = 0; j < tftpOnuInfoSyncTableVector.size(); j++) {
//                            Vector data = (Vector) tftpOnuInfoSyncTableVector.get(j);
//                            int module = (Integer) data.get(0);
//                            int device = (Integer) data.get(1);
//                            int port = (Integer) data.get(2);
//                            int logicalPort = (Integer) data.get(3);
//                            if (module2 == module && device2 == device && port2 == port && logicalPort2 == logicalPort) {
//                            	monitor.setUtsDot3Onu2SerialNumber((byte[]) data.get(5));
//                            	String mac = Dot3Onu2CtcSerialNumberFormatter.getMacAddress(((byte[]) data.get(5)));
//
//                            	if (mac != null && mac.length() > 0 && !mac.equals("00-00-00-00-00-00") && !mac.equals("00:00:00:00:00:00")) {
//                                    monitor.setUtsDot3Onu2CtcOnuMacAddr(mac);
//                                }
//                            	monitor.setUtsDot3Onu2CtcRegisterStatus((Integer) data.get(7));
                            	
//                                if (!((neType.equals("FBW5000")  && neVersion.startsWith("3.1") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.1.1.6")) ||
//                                  	  (neType.equals("FBW5000")  && neVersion.startsWith("2.2") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "2.2.1.6")) ||
//                                  	  (neType.equals("FBW3000") && neVersion.startsWith("3.4") && DiscoveryUtility.isNeVersionGreaterThan(neVersion, "3.4.1.8")))) {
//                                    if (switchVector != null) {
//                                        for (int n = 0; n < switchVector.size(); n++) {
//                                            OnuSwitchTable one = (OnuSwitchTable) switchVector.get(n);
//                                            if (one.getUtsDot3OnuSwitchModuleId().equals(monitor.getUtsDot3Onu2CtcModuleId())
//                                                    && one.getUtsDot3OnuSwitchPortId().equals(monitor.getUtsDot3Onu2CtcPortId())
//                                                    && one.getUtsDot3OnuSwitchLogicalPortId().equals(monitor.getUtsDot3Onu2CtcLogicalPortId())) {
//                                                monitor.setSwitchIp(one.getUtsDot3OnuSwitchIpAddress());
//                                                switchVector.remove(n);
//                                                break;
//                                            }
//                                        }
//                                    }
//                                } else {
//                                    monitor.setSwitchIp(data.get(11) != null ? String.valueOf(data.get(11)) : "0.0.0.0");
//                                }


//                                tftpOnuInfoSyncTableVector.remove(j);
//                                break;
//                            }
//                        }
//
//                        v.add(monitor);
//                    }
//                } else {
//                    prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));

//                    prepareRead(getProperty(utsDot3Onu2SerialNumber));
//                    prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
//
//                    v = loadAll(new int[]{1, 1, 1, 1});
//                }
//            } else {
//                prepareRead(getProperty(utsDot3Onu2LoidAuthLoid));

//                prepareRead(getProperty(utsDot3Onu2SerialNumber));
//                prepareRead(getProperty(utsDot3Onu2CtcRegisterStatus));
//
//                v = loadAll(new int[]{1, 1, 1, 1});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        if (v != null) {
//            if (!DebugMode.isDebug()) {
//                try {
//                    OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//                    Map map = onuMgmtMgr.getONUDeviceMap(neName);
//
//                    for (int i = 0; v != null && i < v.size(); i++) {
//                        OnuMonitorTable monitorBean = (OnuMonitorTable) v.get(i);
//
//                        if (monitorBean.getUtsDot3Onu2CtcRegisterStatus() != null && monitorBean.getUtsDot3Onu2CtcRegisterStatus() == 1) {
//                            monitorBean.setUtsDot3Onu2CtcStatus(STATUS_ON_LINE);
//                        } else {
//                            monitorBean.setUtsDot3Onu2CtcStatus(STATUS_OFF_LINE);
//                        }
//
//                        //find the onu by mac address.
//                        String mac = Dot3Onu2CtcSerialNumberFormatter.getMacAddress(monitorBean.getUtsDot3Onu2SerialNumber());
//                        String key = "";
//                        if (mac != null)
//                            key = new StringBuilder(neName).append(mac).toString();
//                        else
//                            mac = "00:00:00:00:00:00";
//                        if ((!(mac.equals("00-00-00-00-00-00") || mac.equals("00:00:00:00:00:00"))) && map.containsKey(key)) {
//                            ONUDevice onuDevice = (ONUDevice)map.get(key);
//                            monitorBean.setOnuLabel(onuDevice.getLabel());
//                            monitorBean.setRegisteredever(onuDevice.getRegisteredever());
//                            String entityInstance = monitorBean.getUtsDot3Onu2CtcModuleId() + "-" + monitorBean.getUtsDot3Onu2CtcPortId() + "-" + monitorBean.getUtsDot3Onu2CtcLogicalPortId();
//                            monitorBean.setDyingGasp(GuiUtils.isDyingGasp(neName,entityInstance));
//                        } else {
//                            //find the onu by module/port/logicalid
//                            key = new StringBuilder(neName).append(monitorBean.getUtsDot3Onu2CtcModuleId()).append("/").append(monitorBean.getUtsDot3Onu2CtcPortId()).append("/").append(monitorBean.getUtsDot3Onu2CtcLogicalPortId()).toString();
//                            if (map.containsKey(key)) {
//                                ONUDevice onuDevice = (ONUDevice)map.get(key);
//                                monitorBean.setOnuLabel(onuDevice.getLabel());
//                                monitorBean.setRegisteredever(onuDevice.getRegisteredever());
//                                String entityInstance = monitorBean.getUtsDot3Onu2CtcModuleId() + "-" + monitorBean.getUtsDot3Onu2CtcPortId() + "-" + monitorBean.getUtsDot3Onu2CtcLogicalPortId();
//                                monitorBean.setDyingGasp(GuiUtils.isDyingGasp(neName,entityInstance));
//                            } else {
//                                //not found in onu management system and not on line.
//                                if (monitorBean.getUtsDot3Onu2CtcStatus() != STATUS_ON_LINE) {
//                                    monitorBean.setUtsDot3Onu2CtcStatus(STATUS_NOT_EXIST);
//                                    monitorBean.setRegisteredever(ONUDevice.registeredever_no);
//                                    monitorBean.setDyingGasp(false);
//                                }
//                            }
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        return v;
    }

    public boolean reset() throws MibBeanException {
        setUtsDot3Onu2CtcReset(1);
        prepareSave(getProperty(utsDot3Onu2CtcReset));

        return save();
    }

    public boolean modify() throws MibBeanException {
        return true;
    }

    public SnmpMibBean encode(Properties property) {
        OnuMonitorTable one = (OnuMonitorTable) this.clone();
        if (property.getProperty(utsDot3Onu2CtcModuleId) != null) {
            one.setUtsDot3Onu2CtcModuleId(new Integer(property.getProperty(utsDot3Onu2CtcModuleId)));
        }
        one.setUtsDot3Onu2CtcDeviceId(1);
        if (property.getProperty(utsDot3Onu2CtcPortId) != null) {
            one.setUtsDot3Onu2CtcPortId(new Integer(property.getProperty(utsDot3Onu2CtcPortId)));
        }
        if (property.getProperty(utsDot3Onu2CtcLogicalPortId) != null) {
            one.setUtsDot3Onu2CtcLogicalPortId(new Integer(property.getProperty(utsDot3Onu2CtcLogicalPortId)));
        }
        if (property.getProperty(utsDot3Onu2SerialNumber) != null) {
            one.setUtsDot3Onu2SerialNumber((byte[]) property.get(utsDot3Onu2SerialNumber));
        }
        if (property.getProperty(utsDot3Onu2CtcRegisterStatus) != null) {
            one.setUtsDot3Onu2CtcRegisterStatus(new Integer(property.getProperty(utsDot3Onu2CtcRegisterStatus)));
        }
        if (property.getProperty(utsDot3Onu2CtcLinkStatus) != null) {
            one.setUtsDot3Onu2CtcLinkStatus(new Integer(property.getProperty(utsDot3Onu2CtcLinkStatus)));
        }
        if (property.getProperty(utsDot3Onu2CtcPowerStatus) != null) {
            one.setUtsDot3Onu2CtcPowerStatus(new Integer(property.getProperty(utsDot3Onu2CtcPowerStatus)));
        }

        return one;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OnuMonitorTable) {
            OnuMonitorTable bean = (OnuMonitorTable) obj;
            for (int i = 0; i < 4; i++) {
                if ((this.getIndex(i) == null) || (bean.getIndex(i) == null) || (!this.getIndex(i).equals(bean.getIndex(i)))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public String toString() {
        return "ONU" + getIndex(0) + "/" + getIndex(2) + "/" + getIndex(3);
    }

}