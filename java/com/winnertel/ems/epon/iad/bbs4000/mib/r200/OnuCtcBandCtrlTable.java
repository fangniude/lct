package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCtcBandCtrlTable extends SnmpMibBean {

    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
    public static final String utsDot3OnuMaxBand = "utsDot3OnuMaxBand";
    public static final String utsDot3OnuPreviewLength = "utsDot3OnuPreviewLength";
    public static final String utsDot3OnuPreviewCount = "utsDot3OnuPreviewCount";
    public static final String utsDot3OnuPreviewInterval = "utsDot3OnuPreviewInterval";
    public static final String utsDot3OnuPreviewResetTime = "utsDot3OnuPreviewResetTime";
    public static final String utsDot3OnuMGroupJoinNum = "utsDot3OnuMGroupJoinNum";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuCtcBandCtrlTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMaxBand, new SnmpMibBeanProperty(utsDot3OnuMaxBand, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPreviewLength, new SnmpMibBeanProperty(utsDot3OnuPreviewLength, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPreviewCount, new SnmpMibBeanProperty(utsDot3OnuPreviewCount, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPreviewInterval, new SnmpMibBeanProperty(utsDot3OnuPreviewInterval, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPreviewResetTime, new SnmpMibBeanProperty(utsDot3OnuPreviewResetTime, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMGroupJoinNum, new SnmpMibBeanProperty(utsDot3OnuMGroupJoinNum, ".1.3.6.1.4.1.45121.1800.2.4.3.1.2.1.11", ISnmpConstant.INTEGER));
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

    public Integer getUtsDot3OnuEtherPortIndex() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex) {
        setIndex(4, aUtsDot3OnuEtherPortIndex);
    }

    public Integer getUtsDot3OnuMaxBand() {
        return (Integer) getProperty(utsDot3OnuMaxBand).getValue();
    }

    public void setUtsDot3OnuMaxBand(Integer aUtsDot3OnuMaxBand) {
        getProperty(utsDot3OnuMaxBand).setValue(aUtsDot3OnuMaxBand);
    }

    public Integer getUtsDot3OnuPreviewLength() {
        return (Integer) getProperty(utsDot3OnuPreviewLength).getValue();
    }

    public void setUtsDot3OnuPreviewLength(Integer aUtsDot3OnuPreviewLength) {
        getProperty(utsDot3OnuPreviewLength).setValue(aUtsDot3OnuPreviewLength);
    }

    public Integer getUtsDot3OnuPreviewCount() {
        return (Integer) getProperty(utsDot3OnuPreviewCount).getValue();
    }

    public void setUtsDot3OnuPreviewCount(Integer aUtsDot3OnuPreviewCount) {
        getProperty(utsDot3OnuPreviewCount).setValue(aUtsDot3OnuPreviewCount);
    }

    public Integer getUtsDot3OnuPreviewInterval() {
        return (Integer) getProperty(utsDot3OnuPreviewInterval).getValue();
    }

    public void setUtsDot3OnuPreviewInterval(Integer aUtsDot3OnuPreviewInterval) {
        getProperty(utsDot3OnuPreviewInterval).setValue(aUtsDot3OnuPreviewInterval);
    }

    public Integer getUtsDot3OnuPreviewResetTime() {
        return (Integer) getProperty(utsDot3OnuPreviewResetTime).getValue();
    }

    public void setUtsDot3OnuPreviewResetTime(Integer aUtsDot3OnuPreviewResetTime) {
        getProperty(utsDot3OnuPreviewResetTime).setValue(aUtsDot3OnuPreviewResetTime);
    }

    public Integer getUtsDot3OnuMGroupJoinNum() {
        return (Integer) getProperty(utsDot3OnuMGroupJoinNum).getValue();
    }

    public void setUtsDot3OnuMGroupJoinNum(Integer aUtsDot3OnuMGroupJoinNum) {
        getProperty(utsDot3OnuMGroupJoinNum).setValue(aUtsDot3OnuMGroupJoinNum);
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
        prepareRead(getProperty(utsDot3OnuMaxBand));
        prepareRead(getProperty(utsDot3OnuPreviewLength));
        prepareRead(getProperty(utsDot3OnuPreviewCount));
        prepareRead(getProperty(utsDot3OnuPreviewInterval));
        prepareRead(getProperty(utsDot3OnuPreviewResetTime));
        prepareRead(getProperty(utsDot3OnuMGroupJoinNum));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuMaxBand));
        prepareRead(getProperty(utsDot3OnuPreviewLength));
        prepareRead(getProperty(utsDot3OnuPreviewCount));
        prepareRead(getProperty(utsDot3OnuPreviewInterval));
        prepareRead(getProperty(utsDot3OnuPreviewResetTime));
        prepareRead(getProperty(utsDot3OnuMGroupJoinNum));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuCtcBandCtrlTable bean = (OnuCtcBandCtrlTable) v.get(i);
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
        prepareSave(getProperty(utsDot3OnuMaxBand));
        prepareSave(getProperty(utsDot3OnuPreviewLength));
        prepareSave(getProperty(utsDot3OnuPreviewCount));
        prepareSave(getProperty(utsDot3OnuPreviewInterval));
        prepareSave(getProperty(utsDot3OnuPreviewResetTime));

        return save();
    }

}