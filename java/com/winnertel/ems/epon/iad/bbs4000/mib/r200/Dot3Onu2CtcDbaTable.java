package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcDbaTable extends SnmpMibBean {

    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3Onu2DbaQueueSetNum = "utsDot3Onu2DbaQueueSetNum";
    public static final String utsDot3Onu2DbaQueueBitmap1 = "utsDot3Onu2DbaQueueBitmap1";
    public static final String utsDot3Onu2DbaQueueSetThreshold1 = "utsDot3Onu2DbaQueueSetThreshold1";
    public static final String utsDot3Onu2DbaQueueBitmap2 = "utsDot3Onu2DbaQueueBitmap2";
    public static final String utsDot3Onu2DbaQueueSetThreshold2 = "utsDot3Onu2DbaQueueSetThreshold2";
    public static final String utsDot3Onu2DbaQueueBitmap3 = "utsDot3Onu2DbaQueueBitmap3";
    public static final String utsDot3Onu2DbaQueueSetThreshold3 = "utsDot3Onu2DbaQueueSetThreshold3";
    public static final String utsDot3Onu2DbaQueueBitmap4 = "utsDot3Onu2DbaQueueBitmap4";
    public static final String utsDot3Onu2DbaQueueSetThreshold4 = "utsDot3Onu2DbaQueueSetThreshold4";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3Onu2CtcDbaTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2DbaQueueSetNum, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetNum, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2DbaQueueBitmap1, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueBitmap1, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.7", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueSetThreshold1, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetThreshold1, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.8", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueBitmap2, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueBitmap2, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.9", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueSetThreshold2, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetThreshold2, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.10", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueBitmap3, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueBitmap3, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.11", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueSetThreshold3, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetThreshold3, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.12", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueBitmap4, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueBitmap4, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.13", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2DbaQueueSetThreshold4, new SnmpMibBeanProperty(utsDot3Onu2DbaQueueSetThreshold4, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.14.1.14", ISnmpConstant.OCTETS));
    }

    public Integer getUtsDot3OnuModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
        setIndex(0, aUtsDot3OnuModuleId);
    }

    public Integer getUtsDot3OnuDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId) {
        setIndex(1, aUtsDot3OnuDeviceId);
    }

    public Integer getUtsDot3OnuPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
        setIndex(2, aUtsDot3OnuPortId);
    }

    public Integer getUtsDot3OnuLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
        setIndex(3, aUtsDot3OnuLogicalPortId);
    }

    public Integer getUtsDot3Onu2DbaQueueSetNum() {
        return (Integer) getProperty(utsDot3Onu2DbaQueueSetNum).getValue();
    }

    public void setUtsDot3Onu2DbaQueueSetNum(Integer aUtsDot3Onu2DbaQueueSetNum) {
        getProperty(utsDot3Onu2DbaQueueSetNum).setValue(aUtsDot3Onu2DbaQueueSetNum);
    }

    public byte[] getUtsDot3Onu2DbaQueueBitmap1() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueBitmap1).getValue();
    }

    public void setUtsDot3Onu2DbaQueueBitmap1(byte[] aUtsDot3Onu2DbaQueueBitmap1) {
        getProperty(utsDot3Onu2DbaQueueBitmap1).setValue(aUtsDot3Onu2DbaQueueBitmap1);
    }

    public byte[] getUtsDot3Onu2DbaQueueSetThreshold1() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueSetThreshold1).getValue();
    }

    public void setUtsDot3Onu2DbaQueueSetThreshold1(byte[] aUtsDot3Onu2DbaQueueSetThreshold1) {
        getProperty(utsDot3Onu2DbaQueueSetThreshold1).setValue(aUtsDot3Onu2DbaQueueSetThreshold1);
    }

    public byte[] getUtsDot3Onu2DbaQueueBitmap2() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueBitmap2).getValue();
    }

    public void setUtsDot3Onu2DbaQueueBitmap2(byte[] aUtsDot3Onu2DbaQueueBitmap2) {
        getProperty(utsDot3Onu2DbaQueueBitmap2).setValue(aUtsDot3Onu2DbaQueueBitmap2);
    }

    public byte[] getUtsDot3Onu2DbaQueueSetThreshold2() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueSetThreshold2).getValue();
    }

    public void setUtsDot3Onu2DbaQueueSetThreshold2(byte[] aUtsDot3Onu2DbaQueueSetThreshold2) {
        getProperty(utsDot3Onu2DbaQueueSetThreshold2).setValue(aUtsDot3Onu2DbaQueueSetThreshold2);
    }

    public byte[] getUtsDot3Onu2DbaQueueBitmap3() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueBitmap3).getValue();
    }

    public void setUtsDot3Onu2DbaQueueBitmap3(byte[] aUtsDot3Onu2DbaQueueBitmap3) {
        getProperty(utsDot3Onu2DbaQueueBitmap3).setValue(aUtsDot3Onu2DbaQueueBitmap3);
    }

    public byte[] getUtsDot3Onu2DbaQueueSetThreshold3() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueSetThreshold3).getValue();
    }

    public void setUtsDot3Onu2DbaQueueSetThreshold3(byte[] aUtsDot3Onu2DbaQueueSetThreshold3) {
        getProperty(utsDot3Onu2DbaQueueSetThreshold3).setValue(aUtsDot3Onu2DbaQueueSetThreshold3);
    }

    public byte[] getUtsDot3Onu2DbaQueueBitmap4() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueBitmap4).getValue();
    }

    public void setUtsDot3Onu2DbaQueueBitmap4(byte[] aUtsDot3Onu2DbaQueueBitmap4) {
        getProperty(utsDot3Onu2DbaQueueBitmap4).setValue(aUtsDot3Onu2DbaQueueBitmap4);
    }

    public byte[] getUtsDot3Onu2DbaQueueSetThreshold4() {
        return (byte[]) getProperty(utsDot3Onu2DbaQueueSetThreshold4).getValue();
    }

    public void setUtsDot3Onu2DbaQueueSetThreshold4(byte[] aUtsDot3Onu2DbaQueueSetThreshold4) {
        getProperty(utsDot3Onu2DbaQueueSetThreshold4).setValue(aUtsDot3Onu2DbaQueueSetThreshold4);
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
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetNum));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap1));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold1));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap2));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold2));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap3));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold3));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap4));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold4));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetNum));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap1));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold1));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap2));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold2));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap3));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold3));
        prepareRead(getProperty(utsDot3Onu2DbaQueueBitmap4));
        prepareRead(getProperty(utsDot3Onu2DbaQueueSetThreshold4));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcDbaTable bean = (Dot3Onu2CtcDbaTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuModuleId()).append("/").append(bean.getUtsDot3OnuPortId()).append("/").append(bean.getUtsDot3OnuLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3Onu2DbaQueueSetNum));
        prepareSave(getProperty(utsDot3Onu2DbaQueueBitmap1));
        prepareSave(getProperty(utsDot3Onu2DbaQueueSetThreshold1));
        prepareSave(getProperty(utsDot3Onu2DbaQueueBitmap2));
        prepareSave(getProperty(utsDot3Onu2DbaQueueSetThreshold2));
        prepareSave(getProperty(utsDot3Onu2DbaQueueBitmap3));
        prepareSave(getProperty(utsDot3Onu2DbaQueueSetThreshold3));
        prepareSave(getProperty(utsDot3Onu2DbaQueueBitmap4));
        prepareSave(getProperty(utsDot3Onu2DbaQueueSetThreshold4));

        return save();
    }

}