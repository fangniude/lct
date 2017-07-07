package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcServiceSlaTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcServiceSlaModuleId = "utsDot3Onu2CtcServiceSlaModuleId";
    public static final String utsDot3Onu2CtcServiceSlaDeviceId = "utsDot3Onu2CtcServiceSlaDeviceId";
    public static final String utsDot3Onu2CtcServiceSlaPortId = "utsDot3Onu2CtcServiceSlaPortId";
    public static final String utsDot3Onu2CtcServiceSlaLogicalPortId = "utsDot3Onu2CtcServiceSlaLogicalPortId";

    public static final String utsDot3Onu2CtcServiceSlaOperation = "utsDot3Onu2CtcServiceSlaOperation";
    public static final String utsDot3Onu2CtcServiceSlaBestEffortSchedule = "utsDot3Onu2CtcServiceSlaBestEffortSchedule";
    public static final String utsDot3Onu2CtcServiceSlaHighPriorityValue = "utsDot3Onu2CtcServiceSlaHighPriorityValue";
    public static final String utsDot3Onu2CtcServiceSlaCycleLength = "utsDot3Onu2CtcServiceSlaCycleLength";
    //public static final String utsDot3Onu2CtcServiceSlaServiceNumbers = "utsDot3Onu2CtcServiceSlaServiceNumbers";
    //public static final String utsDot3Onu2CtcServiceSlaQueue = "utsDot3Onu2CtcServiceSlaQueue";
    public static final String utsDot3Onu2CtcServiceSlaFixPktSize = "utsDot3Onu2CtcServiceSlaFixPktSize";
    public static final String utsDot3Onu2CtcServiceSlaFixBw = "utsDot3Onu2CtcServiceSlaFixBw";
    public static final String utsDot3Onu2CtcServiceSlaGuaranteedBw = "utsDot3Onu2CtcServiceSlaGuaranteedBw";
    public static final String utsDot3Onu2CtcServiceSlaBestEffortBw = "utsDot3Onu2CtcServiceSlaBestEffortBw";
    public static final String utsDot3Onu2CtcServiceSlaWrrWeight = "utsDot3Onu2CtcServiceSlaWrrWeight";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcServiceSlaTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcServiceSlaModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.4", ISnmpConstant.INTEGER));

        initProperty(utsDot3Onu2CtcServiceSlaOperation, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaOperation, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcServiceSlaCycleLength, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaCycleLength, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.8", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcServiceSlaServiceNumbers, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaServiceNumbers, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.9", ISnmpConstant.INTEGER));
        //initProperty(utsDot3Onu2CtcServiceSlaQueue, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaQueue, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.10", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcServiceSlaFixPktSize, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaFixPktSize, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.11", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcServiceSlaFixBw, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaFixBw, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.12", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.13", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcServiceSlaBestEffortBw, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaBestEffortBw, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.14", ISnmpConstant.OCTETS));
        initProperty(utsDot3Onu2CtcServiceSlaWrrWeight, new SnmpMibBeanProperty(utsDot3Onu2CtcServiceSlaWrrWeight, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.40.1.15", ISnmpConstant.OCTETS));
    }

    public Integer getUtsDot3Onu2CtcServiceSlaModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcServiceSlaModuleId(Integer aUtsDot3Onu2CtcServiceSlaModuleId) {
        setIndex(0, aUtsDot3Onu2CtcServiceSlaModuleId);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcServiceSlaDeviceId(Integer aUtsDot3Onu2CtcServiceSlaDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcServiceSlaDeviceId);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcServiceSlaPortId(Integer aUtsDot3Onu2CtcServiceSlaPortId) {
        setIndex(2, aUtsDot3Onu2CtcServiceSlaPortId);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcServiceSlaLogicalPortId(Integer aUtsDot3Onu2CtcServiceSlaLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcServiceSlaLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaOperation() {
        return (Integer) getProperty(utsDot3Onu2CtcServiceSlaOperation).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaOperation(Integer aUtsDot3Onu2CtcServiceSlaOperation) {
        getProperty(utsDot3Onu2CtcServiceSlaOperation).setValue(aUtsDot3Onu2CtcServiceSlaOperation);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaBestEffortSchedule() {
        return (Integer) getProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaBestEffortSchedule(Integer aUtsDot3Onu2CtcServiceSlaBestEffortSchedule) {
        getProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule).setValue(aUtsDot3Onu2CtcServiceSlaBestEffortSchedule);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaHighPriorityValue() {
        return (Integer) getProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaHighPriorityValue(Integer aUtsDot3Onu2CtcServiceSlaHighPriorityValue) {
        getProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue).setValue(aUtsDot3Onu2CtcServiceSlaHighPriorityValue);
    }

    public Integer getUtsDot3Onu2CtcServiceSlaCycleLength() {
        return (Integer) getProperty(utsDot3Onu2CtcServiceSlaCycleLength).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaCycleLength(Integer aUtsDot3Onu2CtcServiceSlaCycleLength) {
        getProperty(utsDot3Onu2CtcServiceSlaCycleLength).setValue(aUtsDot3Onu2CtcServiceSlaCycleLength);
    }

    /*
    public Integer getUtsDot3Onu2CtcServiceSlaServiceNumbers() {
        return (Integer) getProperty(utsDot3Onu2CtcServiceSlaServiceNumbers).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaServiceNumbers(Integer aUtsDot3Onu2CtcServiceSlaServiceNumbers) {
        getProperty(utsDot3Onu2CtcServiceSlaServiceNumbers).setValue(aUtsDot3Onu2CtcServiceSlaServiceNumbers);
    }

    public String getUtsDot3Onu2CtcServiceSlaQueue() {
        return (String) getProperty(utsDot3Onu2CtcServiceSlaQueue).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaQueue(String aUtsDot3Onu2CtcServiceSlaQueue) {
        getProperty(utsDot3Onu2CtcServiceSlaQueue).setValue(aUtsDot3Onu2CtcServiceSlaQueue);
    }
    */

    public byte[] getUtsDot3Onu2CtcServiceSlaFixPktSize() {
        return (byte[]) getProperty(utsDot3Onu2CtcServiceSlaFixPktSize).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaFixPktSize(byte[] aUtsDot3Onu2CtcServiceSlaFixPktSize) {
        getProperty(utsDot3Onu2CtcServiceSlaFixPktSize).setValue(aUtsDot3Onu2CtcServiceSlaFixPktSize);
    }

    public byte[] getUtsDot3Onu2CtcServiceSlaFixBw() {
        return (byte[]) getProperty(utsDot3Onu2CtcServiceSlaFixBw).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaFixBw(byte[] aUtsDot3Onu2CtcServiceSlaFixBw) {
        getProperty(utsDot3Onu2CtcServiceSlaFixBw).setValue(aUtsDot3Onu2CtcServiceSlaFixBw);
    }

    public byte[] getUtsDot3Onu2CtcServiceSlaGuaranteedBw() {
        return (byte[]) getProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaGuaranteedBw(byte[] aUtsDot3Onu2CtcServiceSlaGuaranteedBw) {
        getProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw).setValue(aUtsDot3Onu2CtcServiceSlaGuaranteedBw);
    }

    public byte[] getUtsDot3Onu2CtcServiceSlaBestEffortBw() {
        return (byte[]) getProperty(utsDot3Onu2CtcServiceSlaBestEffortBw).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaBestEffortBw(byte[] aUtsDot3Onu2CtcServiceSlaBestEffortBw) {
        getProperty(utsDot3Onu2CtcServiceSlaBestEffortBw).setValue(aUtsDot3Onu2CtcServiceSlaBestEffortBw);
    }

    public byte[] getUtsDot3Onu2CtcServiceSlaWrrWeight() {
        return (byte[]) getProperty(utsDot3Onu2CtcServiceSlaWrrWeight).getValue();
    }

    public void setUtsDot3Onu2CtcServiceSlaWrrWeight(byte[] aUtsDot3Onu2CtcServiceSlaWrrWeight) {
        getProperty(utsDot3Onu2CtcServiceSlaWrrWeight).setValue(aUtsDot3Onu2CtcServiceSlaWrrWeight);
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
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaOperation));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaCycleLength));
        //prepareRead(getProperty(utsDot3Onu2CtcServiceSlaServiceNumbers));
        //prepareRead(getProperty(utsDot3Onu2CtcServiceSlaQueue));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaFixPktSize));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaFixBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaBestEffortBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaWrrWeight));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaOperation));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaCycleLength));
        //prepareRead(getProperty(utsDot3Onu2CtcServiceSlaServiceNumbers));
        //prepareRead(getProperty(utsDot3Onu2CtcServiceSlaQueue));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaFixPktSize));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaFixBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaBestEffortBw));
        prepareRead(getProperty(utsDot3Onu2CtcServiceSlaWrrWeight));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcServiceSlaTable bean = (Onu2CtcServiceSlaTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcServiceSlaModuleId()).append("/").append(bean.getUtsDot3Onu2CtcServiceSlaPortId()).append("/").append(bean.getUtsDot3Onu2CtcServiceSlaLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaOperation));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaBestEffortSchedule));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaHighPriorityValue));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaCycleLength));
        //prepareSave(getProperty(utsDot3Onu2CtcServiceSlaServiceNumbers));
        //prepareSave(getProperty(utsDot3Onu2CtcServiceSlaQueue));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaFixPktSize));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaFixBw));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaGuaranteedBw));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaBestEffortBw));
        prepareSave(getProperty(utsDot3Onu2CtcServiceSlaWrrWeight));

        return save();
    }

}