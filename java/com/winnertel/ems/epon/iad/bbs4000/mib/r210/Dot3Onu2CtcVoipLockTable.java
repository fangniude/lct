package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcVoipLockTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
    public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
    public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
    public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
    public static final String utsDot3Onu2CtcVoIPPortLock = "utsDot3Onu2CtcVoIPPortLock";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3Onu2CtcVoipLockTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcVoIPPortLock, new SnmpMibBeanProperty(utsDot3Onu2CtcVoIPPortLock, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.50", ISnmpConstant.OCTETS));
    }

    public Integer getUtsDot3Onu2CtcModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcModuleId(Integer aUtsDot3Onu2CtcModuleId) {
        setIndex(0, aUtsDot3Onu2CtcModuleId);
    }

    public Integer getUtsDot3Onu2CtcDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcDeviceId(Integer aUtsDot3Onu2CtcDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcDeviceId);
    }

    public Integer getUtsDot3Onu2CtcPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcPortId(Integer aUtsDot3Onu2CtcPortId) {
        setIndex(2, aUtsDot3Onu2CtcPortId);
    }

    public Integer getUtsDot3Onu2CtcLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcLogicalPortId(Integer aUtsDot3Onu2CtcLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcLogicalPortId);
    }

    public byte[] getUtsDot3Onu2CtcVoIPPortLock() {
        return (byte[]) getProperty(utsDot3Onu2CtcVoIPPortLock).getValue();
    }

    public void setUtsDot3Onu2CtcVoIPPortLock(byte[] aUtsDot3Onu2CtcVoIPPortLock) {
        getProperty(utsDot3Onu2CtcVoIPPortLock).setValue(aUtsDot3Onu2CtcVoIPPortLock);
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
        prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcVoIPPortLock));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcVoipLockTable bean = (Dot3Onu2CtcVoipLockTable) v.get(i);
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcModuleId()).append("/").append(bean.getUtsDot3Onu2CtcPortId()).append("/").append(bean.getUtsDot3Onu2CtcLogicalPortId()).toString();
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

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcVoIPPortLock));

        return save();
    }
}