package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3OnuSwitchTable extends SnmpMibBean {

    public static final String utsDot3OnuSwitchModuleId = "utsDot3OnuSwitchModuleId";
    public static final String utsDot3OnuSwitchPortId = "utsDot3OnuSwitchPortId";
    public static final String utsDot3OnuSwitchLlid = "utsDot3OnuSwitchLlid";
    public static final String utsDot3OnuSwitchMngStatus = "utsDot3OnuSwitchMngStatus";
    public static final String utsDot3OnuSwitchIpAddress = "utsDot3OnuSwitchIpAddress";
    public static final String utsDot3OnuSwtichType = "utsDot3OnuSwtichType";
    public static final String utsDot3OnuSwitchFirmwareVer = "utsDot3OnuSwitchFirmwareVer";
    public static final String utsDot3OnuSwitchMacAddr = "utsDot3OnuSwitchMacAddr";
    public static final String utsDot3OnuSwitchMngVlan = "utsDot3OnuSwitchMngVlan";

    private String onuLabel = "";

    public Dot3OnuSwitchTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuSwitchModuleId, new SnmpMibBeanProperty(utsDot3OnuSwitchModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSwitchPortId, new SnmpMibBeanProperty(utsDot3OnuSwitchPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSwitchLlid, new SnmpMibBeanProperty(utsDot3OnuSwitchLlid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSwitchMngStatus, new SnmpMibBeanProperty(utsDot3OnuSwitchMngStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSwitchIpAddress, new SnmpMibBeanProperty(utsDot3OnuSwitchIpAddress, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.5", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3OnuSwtichType, new SnmpMibBeanProperty(utsDot3OnuSwtichType, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuSwitchFirmwareVer, new SnmpMibBeanProperty(utsDot3OnuSwitchFirmwareVer, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.7", ISnmpConstant.STRING));
        initProperty(utsDot3OnuSwitchMacAddr, new SnmpMibBeanProperty(utsDot3OnuSwitchMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.8", ISnmpConstant.MAC_ADDRESS));
        initProperty(utsDot3OnuSwitchMngVlan, new SnmpMibBeanProperty(utsDot3OnuSwitchMngVlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.9", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.3.1.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuSwitchModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuSwitchModuleId(Integer aUtsDot3OnuSwitchModuleId) {
        setIndex(0, aUtsDot3OnuSwitchModuleId);
    }

    public Integer getUtsDot3OnuSwitchPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuSwitchPortId(Integer aUtsDot3OnuSwitchPortId) {
        setIndex(1, aUtsDot3OnuSwitchPortId);
    }

    public Integer getUtsDot3OnuSwitchLlid() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuSwitchLlid(Integer aUtsDot3OnuSwitchLlid) {
        setIndex(2, aUtsDot3OnuSwitchLlid);
    }

    public Integer getUtsDot3OnuSwitchMngStatus() {
        return (Integer) getProperty(utsDot3OnuSwitchMngStatus).getValue();
    }

    public void setUtsDot3OnuSwitchMngStatus(Integer aUtsDot3OnuSwitchMngStatus) {
        getProperty(utsDot3OnuSwitchMngStatus).setValue(aUtsDot3OnuSwitchMngStatus);
    }

    public String getUtsDot3OnuSwitchIpAddress() {
        return (String) getProperty(utsDot3OnuSwitchIpAddress).getValue();
    }

    public void setUtsDot3OnuSwitchIpAddress(String aUtsDot3OnuSwitchIpAddress) {
        getProperty(utsDot3OnuSwitchIpAddress).setValue(aUtsDot3OnuSwitchIpAddress);
    }

    public Integer getUtsDot3OnuSwtichType() {
        return (Integer) getProperty(utsDot3OnuSwtichType).getValue();
    }

    public void setUtsDot3OnuSwtichType(Integer aUtsDot3OnuSwtichType) {
        getProperty(utsDot3OnuSwtichType).setValue(aUtsDot3OnuSwtichType);
    }

    public String getUtsDot3OnuSwitchFirmwareVer() {
        return (String) getProperty(utsDot3OnuSwitchFirmwareVer).getValue();
    }

    public void setUtsDot3OnuSwitchFirmwareVer(String aUtsDot3OnuSwitchFirmwareVer) {
        getProperty(utsDot3OnuSwitchFirmwareVer).setValue(aUtsDot3OnuSwitchFirmwareVer);
    }

    public byte[] getUtsDot3OnuSwitchMacAddr() {
        return (byte[]) getProperty(utsDot3OnuSwitchMacAddr).getValue();
    }

    public void setUtsDot3OnuSwitchMacAddr(byte[] aUtsDot3OnuSwitchMacAddr) {
        getProperty(utsDot3OnuSwitchMacAddr).setValue(aUtsDot3OnuSwitchMacAddr);
    }

    public Integer getUtsDot3OnuSwitchMngVlan() {
        return (Integer) getProperty(utsDot3OnuSwitchMngVlan).getValue();
    }

    public void setUtsDot3OnuSwitchMngVlan(Integer aUtsDot3OnuSwitchMngVlan) {
        getProperty(utsDot3OnuSwitchMngVlan).setValue(aUtsDot3OnuSwitchMngVlan);
    }

    public String getOnuLabel() {
        return onuLabel;
    }

    public void setOnuLabel(String s) {
        onuLabel = s;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuSwitchMngStatus));
        prepareRead(getProperty(utsDot3OnuSwitchIpAddress));
        prepareRead(getProperty(utsDot3OnuSwtichType));
        prepareRead(getProperty(utsDot3OnuSwitchFirmwareVer));
        prepareRead(getProperty(utsDot3OnuSwitchMacAddr));
        prepareRead(getProperty(utsDot3OnuSwitchMngVlan));

        boolean b = load();

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                String ifIndex = getUtsDot3OnuSwitchModuleId() + "/" + getUtsDot3OnuSwitchPortId() + "/" + getUtsDot3OnuSwitchLlid();
//                if (onuMgmtMgr != null && neName != null && ifIndex != null)
//                    setOnuLabel(onuMgmtMgr.getOnuLabel(neName, ifIndex));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuSwitchMngStatus));
        prepareRead(getProperty(utsDot3OnuSwitchIpAddress));
        prepareRead(getProperty(utsDot3OnuSwtichType));
        prepareRead(getProperty(utsDot3OnuSwitchFirmwareVer));
        prepareRead(getProperty(utsDot3OnuSwitchMacAddr));
        prepareRead(getProperty(utsDot3OnuSwitchMngVlan));

        Vector v = loadAll(new int[]{1, 1, 1});
        /*
        if (getUtsDot3OnuSwitchModuleId() != null && v != null) {
            int i = 0, module = getUtsDot3OnuSwitchModuleId().intValue();
            while (i < v.size()) {
                Dot3OnuSwitchTable one = (Dot3OnuSwitchTable) v.get(i);
                if (one.getUtsDot3OnuSwitchModuleId().intValue() != module) {
                    v.remove(i);
                } else {
                    i++;
                }
            }
        }
        */

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                if (onuMgmtMgr != null && neName != null) {
//                    Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                    if (map != null) {
//                        for (int i = 0; i < v.size(); i++) {
//                            Dot3OnuSwitchTable bean = (Dot3OnuSwitchTable) v.get(i);
//                            if (bean != null) {
//                                String key = neName + bean.getUtsDot3OnuSwitchModuleId() + "/" + bean.getUtsDot3OnuSwitchPortId() + "/" + bean.getUtsDot3OnuSwitchLlid();
//                                if (map.get(key) != null) {
//                                    bean.setOnuLabel((String) map.get(key));
//                                }
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuSwitchIpAddress));
        prepareSave(getProperty(utsDot3OnuSwitchMngVlan));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }
    
    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuSwitchIpAddress));
        prepareSave(getProperty(utsDot3OnuSwitchMngVlan));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}