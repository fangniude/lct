package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3OnuRTT extends SnmpMibBean {

    public static final String utsDot3Onu2CtcModuleId = "utsDot3Onu2CtcModuleId";
    public static final String utsDot3Onu2CtcDeviceId = "utsDot3Onu2CtcDeviceId";
    public static final String utsDot3Onu2CtcPortId = "utsDot3Onu2CtcPortId";
    public static final String utsDot3Onu2CtcLogicalPortId = "utsDot3Onu2CtcLogicalPortId";
    public static final String utsDot3Onu2CtcLlid = "utsDot3Onu2CtcLlid";
    public static final String utsDot3Onu2CtcSerialNumber = "utsDot3Onu2CtcSerialNumber";
    public static final String utsDot3Onu2CtcFwVer = "utsDot3Onu2CtcFwVer";
    public static final String utsDot3Onu2CtcChipsetId = "utsDot3Onu2CtcChipsetId";
    public static final String utsDot3Onu2CtcRTT = "utsDot3Onu2CtcRTT";
    public static final String utsDot3Onu2CtcDistance = "utsDot3Onu2CtcDistance";

    protected Integer min = null;
    protected Integer max = null;

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3OnuRTT(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcLlid, new SnmpMibBeanProperty(utsDot3Onu2CtcLlid, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcSerialNumber, new SnmpMibBeanProperty(utsDot3Onu2CtcSerialNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.8", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcFwVer, new SnmpMibBeanProperty(utsDot3Onu2CtcFwVer, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.9", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcChipsetId, new SnmpMibBeanProperty(utsDot3Onu2CtcChipsetId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.10", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcRTT, new SnmpMibBeanProperty(utsDot3Onu2CtcRTT, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.10.1.38", ISnmpConstant.INTEGER));

        initProperty(utsDot3Onu2CtcDistance, new SnmpMibBeanProperty(utsDot3Onu2CtcDistance, "", ISnmpConstant.STRING));
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

    /*
    public Integer getUtsDot3Onu2CtcLlid() {
        return (Integer) getProperty(utsDot3Onu2CtcLlid).getValue();
    }

    public void setUtsDot3Onu2CtcLlid(Integer aUtsDot3Onu2CtcLlid) {
        getProperty(utsDot3Onu2CtcLlid).setValue(aUtsDot3Onu2CtcLlid);
    }

    public byte[] getUtsDot3Onu2CtcSerialNumber() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public void setUtsDot3Onu2CtcSerialNumber(byte[] aUtsDot3Onu2CtcSerialNumber2) {
        getProperty(utsDot3Onu2CtcSerialNumber).setValue(aUtsDot3Onu2CtcSerialNumber2);
    }

    public byte[] getUtsDot3Onu2CtcOnuVendor() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuModel() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuMacAddr() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuHardwareVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcOnuSoftwareVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcSerialNumber).getValue();
    }

    public byte[] getUtsDot3Onu2CtcFwVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcFwVer).getValue();
    }

    public void setUtsDot3Onu2CtcFwVer(byte[] aUtsDot3Onu2CtcFwVersion2) {
        getProperty(utsDot3Onu2CtcFwVer).setValue(aUtsDot3Onu2CtcFwVersion2);
    }

    public byte[] getUtsDot3Onu2CtcChipsetId() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipVendor() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipModel() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipRevision() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public byte[] getUtsDot3Onu2CtcChipVer() {
        return (byte[]) getProperty(utsDot3Onu2CtcChipsetId).getValue();
    }

    public void setUtsDot3Onu2CtcChipsetId(byte[] aUtsDot3Onu2CtcChipsetId) {
        getProperty(utsDot3Onu2CtcChipsetId).setValue(aUtsDot3Onu2CtcChipsetId);
    }
    */

    public Integer getUtsDot3Onu2CtcRTT() {
        return (Integer) getProperty(utsDot3Onu2CtcRTT).getValue();
    }

    public void setUtsDot3Onu2CtcRTT(Integer aUtsDot3Onu2CtcRTT) {
        getProperty(utsDot3Onu2CtcRTT).setValue(aUtsDot3Onu2CtcRTT);
    }

    public String getUtsDot3Onu2CtcDistance() {
        return (String) getProperty(utsDot3Onu2CtcDistance).getValue();
    }

    public void setUtsDot3Onu2CtcDistance(String aUtsDot3Onu2CtcDistance) {
        getProperty(utsDot3Onu2CtcDistance).setValue(aUtsDot3Onu2CtcDistance);
    }

    public Integer getMin() {
        return min;
    }

    //set the criteria to filter the onu which distance is less than the criteria.
    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    //set the criteria to filter the onu which distance is greater than the criteria.
    public void setMax(Integer max) {
        this.max = max;
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
        //prepareRead(super.getProperty(utsDot3Onu2CtcLlid));
        //prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));
        //prepareRead(super.getProperty(utsDot3Onu2CtcFwVer));
        //prepareRead(super.getProperty(utsDot3Onu2CtcChipsetId));
        prepareRead(getProperty(utsDot3Onu2CtcRTT));

        boolean b = load();

        setUtsDot3Onu2CtcDistance(format(getUtsDot3Onu2CtcRTT()));

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
        //prepareRead(super.getProperty(utsDot3Onu2CtcLlid));
        //prepareRead(super.getProperty(utsDot3Onu2CtcSerialNumber));
        //prepareRead(super.getProperty(utsDot3Onu2CtcFwVer));
        //prepareRead(super.getProperty(utsDot3Onu2CtcChipsetId));
        prepareRead(getProperty(utsDot3Onu2CtcRTT));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        int cursor = 0;
        while (cursor < v.size()) {
            Dot3OnuRTT bean = (Dot3OnuRTT) v.get(cursor);

//            if (getMin() != null && calc(bean.getUtsDot3Onu2CtcRTT()) < getMin()) {
//                v.remove(cursor);
//                continue;
//            }
//
//            if (getMax() != null && calc(bean.getUtsDot3Onu2CtcRTT()) > getMax()) {
//                v.remove(cursor);
//                continue;
//            }

            bean.setUtsDot3Onu2CtcDistance(format(bean.getUtsDot3Onu2CtcRTT()));
            cursor++;
        }

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3OnuRTT bean = (Dot3OnuRTT) v.get(i);
//                    //find the onu by module/port/logicalid
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

    protected int calc(int i) {
        if (i > 60)
            return (int) ((i - 60) * 1.6);
        else
            return 1;
    }

    protected String format(int i) {
        if (i > 60)
            return "" + (int) ((i - 60) * 1.6);
        else
            return "1";
    }

}