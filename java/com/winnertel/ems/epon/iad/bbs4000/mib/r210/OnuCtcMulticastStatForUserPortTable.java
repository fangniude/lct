package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCtcMulticastStatForUserPortTable extends SnmpMibBean {

    public static final String utsDot3OnuMCastStatForUserPortModuleId = "utsDot3OnuMCastStatForUserPortModuleId";
    public static final String utsDot3OnuMCastStatForUserPortDeviceId = "utsDot3OnuMCastStatForUserPortDeviceId";
    public static final String utsDot3OnuMCastStatForUserPortPortId = "utsDot3OnuMCastStatForUserPortPortId";
    public static final String utsDot3OnuMCastStatForUserPortLogicalPortId = "utsDot3OnuMCastStatForUserPortLogicalPortId";
    public static final String utsDot3OnuMCastStatForUserPortEthernetPortId = "utsDot3OnuMCastStatForUserPortEthernetPortId";
    public static final String utsDot3OnuMCastStatForUserPortViewNumber = "utsDot3OnuMCastStatForUserPortViewNumber";
    public static final String utsDot3OnuMCastStatForUserPortTotalTime = "utsDot3OnuMCastStatForUserPortTotalTime";
    public static final String utsDot3OnuMCastStatForUserPortAverageTime = "utsDot3OnuMCastStatForUserPortAverageTime";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuCtcMulticastStatForUserPortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuMCastStatForUserPortModuleId, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortModuleId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortDeviceId, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortDeviceId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortPortId, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortEthernetPortId, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortEthernetPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortViewNumber, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortViewNumber, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortTotalTime, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortTotalTime, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastStatForUserPortAverageTime, new SnmpMibBeanProperty(utsDot3OnuMCastStatForUserPortAverageTime, ".1.3.6.1.4.1.45121.1800.2.4.3.1.9.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuMCastStatForUserPortModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuMCastStatForUserPortModuleId(Integer aUtsDot3OnuMCastStatForUserPortModuleId) {
        setIndex(0, aUtsDot3OnuMCastStatForUserPortModuleId);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuMCastStatForUserPortDeviceId(Integer aUtsDot3OnuMCastStatForUserPortDeviceId) {
        setIndex(1, aUtsDot3OnuMCastStatForUserPortDeviceId);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuMCastStatForUserPortPortId(Integer aUtsDot3OnuMCastStatForUserPortPortId) {
        setIndex(2, aUtsDot3OnuMCastStatForUserPortPortId);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuMCastStatForUserPortLogicalPortId(Integer aUtsDot3OnuMCastStatForUserPortLogicalPortId) {
        setIndex(3, aUtsDot3OnuMCastStatForUserPortLogicalPortId);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortEthernetPortId() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuMCastStatForUserPortEthernetPortId(Integer aUtsDot3OnuMCastStatForUserPortEthernetPortId) {
        setIndex(4, aUtsDot3OnuMCastStatForUserPortEthernetPortId);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortViewNumber() {
        return (Integer) getProperty(utsDot3OnuMCastStatForUserPortViewNumber).getValue();
    }

    public void setUtsDot3OnuMCastStatForUserPortViewNumber(Integer aUtsDot3OnuMCastStatForUserPortViewNumber) {
        getProperty(utsDot3OnuMCastStatForUserPortViewNumber).setValue(aUtsDot3OnuMCastStatForUserPortViewNumber);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortTotalTime() {
        return (Integer) getProperty(utsDot3OnuMCastStatForUserPortTotalTime).getValue();
    }

    public void setUtsDot3OnuMCastStatForUserPortTotalTime(Integer aUtsDot3OnuMCastStatForUserPortTotalTime) {
        getProperty(utsDot3OnuMCastStatForUserPortTotalTime).setValue(aUtsDot3OnuMCastStatForUserPortTotalTime);
    }

    public Integer getUtsDot3OnuMCastStatForUserPortAverageTime() {
        return (Integer) getProperty(utsDot3OnuMCastStatForUserPortAverageTime).getValue();
    }

    public void setUtsDot3OnuMCastStatForUserPortAverageTime(Integer aUtsDot3OnuMCastStatForUserPortAverageTime) {
        getProperty(utsDot3OnuMCastStatForUserPortAverageTime).setValue(aUtsDot3OnuMCastStatForUserPortAverageTime);
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
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortViewNumber));
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortTotalTime));
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortAverageTime));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortViewNumber));
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortTotalTime));
        prepareRead(getProperty(utsDot3OnuMCastStatForUserPortAverageTime));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuCtcMulticastStatForUserPortTable bean = (OnuCtcMulticastStatForUserPortTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuMCastStatForUserPortModuleId()).append("/").append(bean.getUtsDot3OnuMCastStatForUserPortPortId()).append("/").append(bean.getUtsDot3OnuMCastStatForUserPortLogicalPortId()).toString();
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