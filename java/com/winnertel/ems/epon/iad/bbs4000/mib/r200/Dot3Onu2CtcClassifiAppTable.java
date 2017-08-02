package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcClassifiAppTable extends SnmpMibBean {

    public static final String utsDot3OnuClassifiAppModuleId = "utsDot3OnuClassifiAppModuleId";
    public static final String utsDot3OnuClassifiAppDeviceId = "utsDot3OnuClassifiAppDeviceId";
    public static final String utsDot3OnuClassifiAppPortId = "utsDot3OnuClassifiAppPortId";
    public static final String utsDot3OnuClassifiAppLogicalPortId = "utsDot3OnuClassifiAppLogicalPortId";
    public static final String utsDot3OnuClassifiAppPortIndex = "utsDot3OnuClassifiAppPortIndex";
    public static final String utsDot3OnuClassifiAppPrecedence = "utsDot3OnuClassifiAppPrecedence";
    public static final String utsDot3OnuClassifiAppQueueMapped = "utsDot3OnuClassifiAppQueueMapped";
    public static final String utsDot3OnuClassifiAppPriMark = "utsDot3OnuClassifiAppPriMark";
    public static final String utsDot3OnuClassifiAppClassId = "utsDot3OnuClassifiAppClassId";
    public static final String utsDot3OnuClassifiAppFieldId = "utsDot3OnuClassifiAppFieldId";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3Onu2CtcClassifiAppTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuClassifiAppModuleId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppDeviceId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppPortId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppPortIndex, new SnmpMibBeanProperty(utsDot3OnuClassifiAppPortIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppClassId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppClassId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppFieldId, new SnmpMibBeanProperty(utsDot3OnuClassifiAppFieldId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppPrecedence, new SnmpMibBeanProperty(utsDot3OnuClassifiAppPrecedence, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppQueueMapped, new SnmpMibBeanProperty(utsDot3OnuClassifiAppQueueMapped, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuClassifiAppPriMark, new SnmpMibBeanProperty(utsDot3OnuClassifiAppPriMark, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.10", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.16.1.11", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuClassifiAppModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuClassifiAppModuleId(Integer aUtsDot3OnuClassifiAppModuleId) {
        setIndex(0, aUtsDot3OnuClassifiAppModuleId);
    }

    public Integer getUtsDot3OnuClassifiAppDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuClassifiAppDeviceId(Integer aUtsDot3OnuClassifiAppDeviceId) {
        setIndex(1, aUtsDot3OnuClassifiAppDeviceId);
    }

    public Integer getUtsDot3OnuClassifiAppPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuClassifiAppPortId(Integer aUtsDot3OnuClassifiAppPortId) {
        setIndex(2, aUtsDot3OnuClassifiAppPortId);
    }

    public Integer getUtsDot3OnuClassifiAppLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuClassifiAppLogicalPortId(Integer aUtsDot3OnuClassifiAppLogicalPortId) {
        setIndex(3, aUtsDot3OnuClassifiAppLogicalPortId);
    }

    public Integer getUtsDot3OnuClassifiAppPortIndex() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuClassifiAppPortIndex(Integer aUtsDot3OnuClassifiAppPortIndex) {
        setIndex(4, aUtsDot3OnuClassifiAppPortIndex);
    }

    public Integer getUtsDot3OnuClassifiAppClassId() {
        return (Integer) getIndex(5);
    }

    public void setUtsDot3OnuClassifiAppClassId(Integer aUtsDot3OnuClassifiAppClassId) {
        setIndex(5, aUtsDot3OnuClassifiAppClassId);
    }

    public Integer getUtsDot3OnuClassifiAppFieldId() {
        return (Integer) getIndex(6);
    }

    public void setUtsDot3OnuClassifiAppFieldId(Integer aUtsDot3OnuClassifiAppFieldId) {
        setIndex(6, aUtsDot3OnuClassifiAppFieldId);
    }

    public Integer getUtsDot3OnuClassifiAppPrecedence() {
        return (Integer) getProperty(utsDot3OnuClassifiAppPrecedence).getValue();
    }

    public void setUtsDot3OnuClassifiAppPrecedence(Integer aUtsDot3OnuClassifiAppPrecedence) {
        getProperty(utsDot3OnuClassifiAppPrecedence).setValue(aUtsDot3OnuClassifiAppPrecedence);
    }

    public Integer getUtsDot3OnuClassifiAppQueueMapped() {
        return (Integer) getProperty(utsDot3OnuClassifiAppQueueMapped).getValue();
    }

    public void setUtsDot3OnuClassifiAppQueueMapped(Integer aUtsDot3OnuClassifiAppQueueMapped) {
        getProperty(utsDot3OnuClassifiAppQueueMapped).setValue(aUtsDot3OnuClassifiAppQueueMapped);
    }

    public Integer getUtsDot3OnuClassifiAppPriMark() {
        return (Integer) getProperty(utsDot3OnuClassifiAppPriMark).getValue();
    }

    public void setUtsDot3OnuClassifiAppPriMark(Integer aUtsDot3OnuClassifiAppPriMark) {
        getProperty(utsDot3OnuClassifiAppPriMark).setValue(aUtsDot3OnuClassifiAppPriMark);
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
        prepareRead(getProperty(utsDot3OnuClassifiAppPrecedence));
        prepareRead(getProperty(utsDot3OnuClassifiAppQueueMapped));
        prepareRead(getProperty(utsDot3OnuClassifiAppPriMark));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuClassifiAppPrecedence));
        prepareRead(getProperty(utsDot3OnuClassifiAppQueueMapped));
        prepareRead(getProperty(utsDot3OnuClassifiAppPriMark));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcClassifiAppTable bean = (Dot3Onu2CtcClassifiAppTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuClassifiAppModuleId()).append("/").append(bean.getUtsDot3OnuClassifiAppPortId()).append("/").append(bean.getUtsDot3OnuClassifiAppLogicalPortId()).toString();
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

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuClassifiAppPrecedence));
        prepareSave(getProperty(utsDot3OnuClassifiAppQueueMapped));
        prepareSave(getProperty(utsDot3OnuClassifiAppPriMark));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}