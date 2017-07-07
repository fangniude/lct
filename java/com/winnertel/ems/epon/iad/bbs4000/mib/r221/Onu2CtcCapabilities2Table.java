/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcCapabilities2Table extends SnmpMibBean {

    public static final String utsDot3OnuCtcCapabilities2ModuleId = "utsDot3OnuCtcCapabilities2ModuleId";
    public static final String utsDot3OnuCtcCapabilities2DeviceId = "utsDot3OnuCtcCapabilities2DeviceId";
    public static final String utsDot3OnuCtcCapabilities2PortId = "utsDot3OnuCtcCapabilities2PortId";
    public static final String utsDot3OnuCtcCapabilities2LogicalPortId = "utsDot3OnuCtcCapabilities2LogicalPortId";
    public static final String utsDot3OnuCtcCapabilities2OnuType = "utsDot3OnuCtcCapabilities2OnuType";
    public static final String utsDot3OnuCtcCapabilities2MultiLlid = "utsDot3OnuCtcCapabilities2MultiLlid";
    public static final String utsDot3OnuCtcCapabilities2ProtectionType = "utsDot3OnuCtcCapabilities2ProtectionType";
    public static final String utsDot3OnuCtcCapabilities2PonifNum = "utsDot3OnuCtcCapabilities2PonifNum";
    public static final String utsDot3OnuCtcCapabilities2SlotNum = "utsDot3OnuCtcCapabilities2SlotNum";
    public static final String utsDot3OnuCtcCapabilities2IntfAttribute = "utsDot3OnuCtcCapabilities2IntfAttribute";
    public static final String utsDot3OnuCtcCapabilities2BackupBattery = "utsDot3OnuCtcCapabilities2BackupBattery";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCapabilities2Table(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuCtcCapabilities2ModuleId, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2ModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2DeviceId, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2DeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2PortId, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2PortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2LogicalPortId, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2LogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2OnuType, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2OnuType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2MultiLlid, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2MultiLlid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2ProtectionType, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2ProtectionType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2PonifNum, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2PonifNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2SlotNum, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2SlotNum, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuCtcCapabilities2IntfAttribute, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2IntfAttribute, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.11", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuCtcCapabilities2BackupBattery, new SnmpMibBeanProperty(utsDot3OnuCtcCapabilities2BackupBattery, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.41.1.12", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuCtcCapabilities2ModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuCtcCapabilities2ModuleId(Integer aUtsDot3OnuCtcCapabilities2ModuleId) {
        setIndex(0, aUtsDot3OnuCtcCapabilities2ModuleId);
    }

    public Integer getUtsDot3OnuCtcCapabilities2DeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuCtcCapabilities2DeviceId(Integer aUtsDot3OnuCtcCapabilities2DeviceId) {
        setIndex(1, aUtsDot3OnuCtcCapabilities2DeviceId);
    }

    public Integer getUtsDot3OnuCtcCapabilities2PortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuCtcCapabilities2PortId(Integer aUtsDot3OnuCtcCapabilities2PortId) {
        setIndex(2, aUtsDot3OnuCtcCapabilities2PortId);
    }

    public Integer getUtsDot3OnuCtcCapabilities2LogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuCtcCapabilities2LogicalPortId(Integer aUtsDot3OnuCtcCapabilities2LogicalPortId) {
        setIndex(3, aUtsDot3OnuCtcCapabilities2LogicalPortId);
    }

    public Integer getUtsDot3OnuCtcCapabilities2OnuType() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2OnuType).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2OnuType(Integer aUtsDot3OnuCtcCapabilities2OnuType) {
        getProperty(utsDot3OnuCtcCapabilities2OnuType).setValue(aUtsDot3OnuCtcCapabilities2OnuType);
    }

    public Integer getUtsDot3OnuCtcCapabilities2MultiLlid() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2MultiLlid).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2MultiLlid(Integer aUtsDot3OnuCtcCapabilities2MultiLlid) {
        getProperty(utsDot3OnuCtcCapabilities2MultiLlid).setValue(aUtsDot3OnuCtcCapabilities2MultiLlid);
    }

    public Integer getUtsDot3OnuCtcCapabilities2ProtectionType() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2ProtectionType).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2ProtectionType(Integer aUtsDot3OnuCtcCapabilities2ProtectionType) {
        getProperty(utsDot3OnuCtcCapabilities2ProtectionType).setValue(aUtsDot3OnuCtcCapabilities2ProtectionType);
    }

    public Integer getUtsDot3OnuCtcCapabilities2PonifNum() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2PonifNum).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2PonifNum(Integer aUtsDot3OnuCtcCapabilities2PonifNum) {
        getProperty(utsDot3OnuCtcCapabilities2PonifNum).setValue(aUtsDot3OnuCtcCapabilities2PonifNum);
    }

    public Integer getUtsDot3OnuCtcCapabilities2SlotNum() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2SlotNum).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2SlotNum(Integer aUtsDot3OnuCtcCapabilities2SlotNum) {
        getProperty(utsDot3OnuCtcCapabilities2SlotNum).setValue(aUtsDot3OnuCtcCapabilities2SlotNum);
    }

    public byte[] getUtsDot3OnuCtcCapabilities2IntfAttribute() {
        return (byte[]) getProperty(utsDot3OnuCtcCapabilities2IntfAttribute).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2IntfAttribute(byte[] aUtsDot3OnuCtcCapabilities2IntfAttribute) {
        getProperty(utsDot3OnuCtcCapabilities2IntfAttribute).setValue(aUtsDot3OnuCtcCapabilities2IntfAttribute);
    }

    public Integer getUtsDot3OnuCtcCapabilities2BackupBattery() {
        return (Integer) getProperty(utsDot3OnuCtcCapabilities2BackupBattery).getValue();
    }

    public void setUtsDot3OnuCtcCapabilities2BackupBattery(Integer aUtsDot3OnuCtcCapabilities2BackupBattery) {
        getProperty(utsDot3OnuCtcCapabilities2BackupBattery).setValue(aUtsDot3OnuCtcCapabilities2BackupBattery);
    }

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2OnuType));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2MultiLlid));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2ProtectionType));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2PonifNum));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2SlotNum));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2IntfAttribute));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2BackupBattery));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2OnuType));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2MultiLlid));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2ProtectionType));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2PonifNum));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2SlotNum));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2IntfAttribute));
        prepareRead(getProperty(utsDot3OnuCtcCapabilities2BackupBattery));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcCapabilities2Table bean = (Onu2CtcCapabilities2Table) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuCtcCapabilities2ModuleId()).append("/").append(bean.getUtsDot3OnuCtcCapabilities2PortId()).append("/").append(bean.getUtsDot3OnuCtcCapabilities2LogicalPortId()).toString();
//                    if (map.containsKey(key)) {
//                        bean.setOnuLabel((String) map.get(key));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

}