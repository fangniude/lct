package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EponArpTable extends SnmpMibBean {
    public static final String utsEponArpIpAddress = "utsEponArpIpAddress";

    public static final String utsEponArpMacAddress = "utsEponArpMacAddress";

    public static final String utsEponArpIntfType = "utsEponArpIntfType";

    public static final String utsEponArpModuleId = "utsEponArpModuleId";

    public static final String utsEponArpPortId = "utsEponArpPortId";

    public static final String utsEponArpLinkAggGroupId = "utsEponArpLinkAggGroupId";

    public static final String utsEponArpVlanId = "utsEponArpVlanId";

    public static final String utsEponArpItemType = "utsEponArpItemType";

    public static final String utsEponArpVlanSubVlanId = "utsEponArpVlanSubVlanId";

    public EponArpTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsEponArpIpAddress, new SnmpMibBeanProperty(
                utsEponArpIpAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.1",
                ISnmpConstant.STRING));
        initProperty(utsEponArpMacAddress, new SnmpMibBeanProperty(
                utsEponArpMacAddress, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.2",
                ISnmpConstant.MAC_ADDRESS));
        initProperty(utsEponArpIntfType, new SnmpMibBeanProperty(
                utsEponArpIntfType, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.3",
                ISnmpConstant.INTEGER));
        initProperty(utsEponArpModuleId, new SnmpMibBeanProperty(
                utsEponArpModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.4",
                ISnmpConstant.INTEGER));
        initProperty(utsEponArpPortId, new SnmpMibBeanProperty(
                utsEponArpPortId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.5",
                ISnmpConstant.INTEGER));
        initProperty(utsEponArpLinkAggGroupId,
                new SnmpMibBeanProperty(utsEponArpLinkAggGroupId,
                        ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.6",
                        ISnmpConstant.INTEGER));
        initProperty(utsEponArpVlanId, new SnmpMibBeanProperty(
                utsEponArpVlanId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.7",
                ISnmpConstant.INTEGER));
        initProperty(utsEponArpItemType, new SnmpMibBeanProperty(
                utsEponArpItemType, ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.8",
                ISnmpConstant.INTEGER));
        initProperty(utsEponArpVlanSubVlanId,
                new SnmpMibBeanProperty(utsEponArpVlanSubVlanId,
                        ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.9",
                        ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
                ".1.3.6.1.4.1.41355.1800.2.2.1.6.8.1.1.10",
                ISnmpConstant.INTEGER));

    }

    public String getUtsEponArpIpAddress() {
        return (String) getIndex(0);
    }

    public void setUtsEponArpIpAddress(String aUtsEponArpIpAddress) {
        setIndex(0, aUtsEponArpIpAddress);
    }

    public byte[] getUtsEponArpMacAddress() {
        return (byte[]) getProperty(utsEponArpMacAddress).getValue();
    }

    public void setUtsEponArpMacAddress(byte[] aUtsEponArpMacAddress) {
        getProperty(utsEponArpMacAddress).setValue(aUtsEponArpMacAddress);
    }

    public Integer getUtsEponArpIntfType() {
        return (Integer) getProperty(utsEponArpIntfType).getValue();
    }

    public void setUtsEponArpIntfType(Integer aUtsEponArpIntfType) {
        getProperty(utsEponArpIntfType).setValue(aUtsEponArpIntfType);
    }

    public Integer getUtsEponArpModuleId() {
        return (Integer) getProperty(utsEponArpModuleId).getValue();
    }

    public void setUtsEponArpModuleId(Integer aUtsEponArpModuleId) {
        getProperty(utsEponArpModuleId).setValue(aUtsEponArpModuleId);
    }

    public Integer getUtsEponArpPortId() {
        return (Integer) getProperty(utsEponArpPortId).getValue();
    }

    public void setUtsEponArpPortId(Integer aUtsEponArpPortId) {
        getProperty(utsEponArpPortId).setValue(aUtsEponArpPortId);
    }

    public Integer getUtsEponArpLinkAggGroupId() {
        return (Integer) getProperty(utsEponArpLinkAggGroupId).getValue();
    }

    public void setUtsEponArpLinkAggGroupId(Integer aUtsEponArpLinkAggGroupId) {
        getProperty(utsEponArpLinkAggGroupId).setValue(
                aUtsEponArpLinkAggGroupId);
    }

    public Integer getUtsEponArpVlanId() {
        return (Integer) getProperty(utsEponArpVlanId).getValue();
    }

    public void setUtsEponArpVlanId(Integer aUtsEponArpVlanId) {
        getProperty(utsEponArpVlanId).setValue(aUtsEponArpVlanId);
    }

    public Integer getUtsEponArpItemType() {
        return (Integer) getProperty(utsEponArpItemType).getValue();
    }

    public void setUtsEponArpItemType(Integer aUtsEponArpItemType) {
        getProperty(utsEponArpItemType).setValue(aUtsEponArpItemType);
    }

    public Integer getUtsEponArpVlanSubVlanId() {
        return (Integer) getProperty(utsEponArpVlanSubVlanId).getValue();
    }

    public void setUtsEponArpVlanSubVlanId(Integer aUtsEponArpVlanSubVlanId) {
        getProperty(utsEponArpVlanSubVlanId).setValue(aUtsEponArpVlanSubVlanId);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsEponArpMacAddress));
        prepareRead(super.getProperty(utsEponArpIntfType));
        prepareRead(super.getProperty(utsEponArpModuleId));
        prepareRead(super.getProperty(utsEponArpPortId));
        prepareRead(super.getProperty(utsEponArpLinkAggGroupId));
        prepareRead(super.getProperty(utsEponArpVlanId));
        prepareRead(super.getProperty(utsEponArpItemType));
        prepareRead(super.getProperty(utsEponArpVlanSubVlanId));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        Vector v = null;

//        if (!DebugMode.isDebug()) {
//            ObjectFactory factory = ClientUtility.getObjectFactory();
//            try {
//                MibProxyMgr mibMgr = (MibProxyMgr) factory.getSystemMgr(-1, "MibProxyMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Vector tftpVector = mibMgr.retrieveAll(neName, "utsEponArpTable");
//
//                v = new Vector(tftpVector.size());
//                for (int i = 0; i < tftpVector.size(); i++) {
//                    EponArpTable arp = new EponArpTable(fSnmpProxy);
//
//                    Vector arpVector = (Vector) tftpVector.get(i);
//
//                    arp.setUtsEponArpIpAddress((String) arpVector.get(0));
//                    arp.setUtsEponArpMacAddress((byte[]) arpVector.get(1));
//                    arp.setUtsEponArpIntfType((Integer) arpVector.get(2));
//                    arp.setUtsEponArpModuleId((Integer) arpVector.get(3));
//                    arp.setUtsEponArpPortId((Integer) arpVector.get(4));
//                    arp.setUtsEponArpLinkAggGroupId((Integer) arpVector.get(5));
//                    arp.setUtsEponArpVlanId((Integer) arpVector.get(6));
//                    arp.setUtsEponArpItemType((Integer) arpVector.get(7));
//                    arp.setUtsEponArpVlanSubVlanId((Integer) arpVector.get(8));
//
//                    v.add(arp);
//                }
//
//                return v;
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }

        prepareRead(super.getProperty(utsEponArpMacAddress));
        prepareRead(super.getProperty(utsEponArpIntfType));
        prepareRead(super.getProperty(utsEponArpModuleId));
        prepareRead(super.getProperty(utsEponArpPortId));
        prepareRead(super.getProperty(utsEponArpLinkAggGroupId));
        prepareRead(super.getProperty(utsEponArpVlanId));
        prepareRead(super.getProperty(utsEponArpItemType));
        prepareRead(super.getProperty(utsEponArpVlanSubVlanId));

        v = loadAll(new int[]{4});
        return v;
    }

    public boolean modify() throws MibBeanException {
        myPrepareSave(getProperty(utsEponArpIpAddress));
        myPrepareSave(getProperty(utsEponArpMacAddress));
        myPrepareSave(getProperty(utsEponArpIntfType));
        myPrepareSave(getProperty(utsEponArpModuleId));
        myPrepareSave(getProperty(utsEponArpPortId));
        myPrepareSave(getProperty(utsEponArpLinkAggGroupId));
        myPrepareSave(getProperty(utsEponArpVlanId));
        myPrepareSave(getProperty(utsEponArpItemType));
        myPrepareSave(getProperty(utsEponArpVlanSubVlanId));

        return save();
    }

    public void myPrepareSave(SnmpMibBeanProperty property) {
        if (property.getValue() != null) {
            prepareSave(property);
        }
    }

    public boolean add() throws MibBeanException {
        myPrepareSave(getProperty(utsEponArpIpAddress));
        myPrepareSave(getProperty(utsEponArpMacAddress));
        myPrepareSave(getProperty(utsEponArpIntfType));
        myPrepareSave(getProperty(utsEponArpModuleId));
        myPrepareSave(getProperty(utsEponArpPortId));
        myPrepareSave(getProperty(utsEponArpLinkAggGroupId));
        myPrepareSave(getProperty(utsEponArpVlanId));
        setUtsEponArpItemType(new Integer(1));
        myPrepareSave(getProperty(utsEponArpItemType));
        myPrepareSave(getProperty(utsEponArpVlanSubVlanId));

        setRowStatus(new Integer(4));
        myPrepareSave(getProperty(ROW_STATUS));
        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}
