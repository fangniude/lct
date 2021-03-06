package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2TrafficProfTable extends SnmpMibBean {

    public static final String utsDot3OnuTProfModuleId = "utsDot3OnuTProfModuleId";
    public static final String utsDot3OnuTProfDeviceId = "utsDot3OnuTProfDeviceId";
    public static final String utsDot3OnuTProfPortId = "utsDot3OnuTProfPortId";
    public static final String utsDot3OnuTProfLogicalPortId = "utsDot3OnuTProfLogicalPortId";
    public static final String utsDot3OnuUpstreamPir = "utsDot3OnuUpstreamPir";
    public static final String utsDot3OnuDownstreamPir = "utsDot3OnuDownstreamPir";
    public static final String utsDot3OnuUpstreamCir = "utsDot3OnuUpstreamCir";
    public static final String utsDot3OnuDownstreamCir = "utsDot3OnuDownstreamCir";
    public static final String utsDot3OnuUpstreamMaxBurstSize = "utsDot3OnuUpstreamMaxBurstSize";
    public static final String utsDot3OnuDownstreamMaxBurstSize = "utsDot3OnuDownstreamMaxBurstSize";
    public static final String utsDot3OnuUpstreamWeight = "utsDot3OnuUpstreamWeight";
    public static final String utsDot3OnuUpstreamFir = "utsDot3OnuUpstreamFir";
    public static final String utsDot3OnuAppliedDbaProfile = "utsDot3OnuAppliedDbaProfile";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2TrafficProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuTProfModuleId, new SnmpMibBeanProperty(utsDot3OnuTProfModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuTProfDeviceId, new SnmpMibBeanProperty(utsDot3OnuTProfDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuTProfPortId, new SnmpMibBeanProperty(utsDot3OnuTProfPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuTProfLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuTProfLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuUpstreamPir, new SnmpMibBeanProperty(utsDot3OnuUpstreamPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDownstreamPir, new SnmpMibBeanProperty(utsDot3OnuDownstreamPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuUpstreamCir, new SnmpMibBeanProperty(utsDot3OnuUpstreamCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDownstreamCir, new SnmpMibBeanProperty(utsDot3OnuDownstreamCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuUpstreamMaxBurstSize, new SnmpMibBeanProperty(utsDot3OnuUpstreamMaxBurstSize, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDownstreamMaxBurstSize, new SnmpMibBeanProperty(utsDot3OnuDownstreamMaxBurstSize, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuUpstreamWeight, new SnmpMibBeanProperty(utsDot3OnuUpstreamWeight, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuUpstreamFir, new SnmpMibBeanProperty(utsDot3OnuUpstreamFir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuAppliedDbaProfile, new SnmpMibBeanProperty(utsDot3OnuAppliedDbaProfile, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.5.1.13", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuTProfModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuTProfModuleId(Integer aUtsDot3OnuTProfModuleId) {
        setIndex(0, aUtsDot3OnuTProfModuleId);
    }

    public Integer getUtsDot3OnuTProfDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuTProfDeviceId(Integer aUtsDot3OnuTProfDeviceId) {
        setIndex(1, aUtsDot3OnuTProfDeviceId);
    }

    public Integer getUtsDot3OnuTProfPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuTProfPortId(Integer aUtsDot3OnuTProfPortId) {
        setIndex(2, aUtsDot3OnuTProfPortId);
    }

    public Integer getUtsDot3OnuTProfLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuTProfLogicalPortId(Integer aUtsDot3OnuTProfLogicalPortId) {
        setIndex(3, aUtsDot3OnuTProfLogicalPortId);
    }

    public Integer getUtsDot3OnuUpstreamPir() {
        return (Integer) getProperty(utsDot3OnuUpstreamPir).getValue();
    }

    public void setUtsDot3OnuUpstreamPir(Integer aUtsDot3OnuUpstreamPir) {
        getProperty(utsDot3OnuUpstreamPir).setValue(aUtsDot3OnuUpstreamPir);
    }

    public Integer getUtsDot3OnuDownstreamPir() {
        return (Integer) getProperty(utsDot3OnuDownstreamPir).getValue();
    }

    public void setUtsDot3OnuDownstreamPir(Integer aUtsDot3OnuDownstreamPir) {
        getProperty(utsDot3OnuDownstreamPir).setValue(aUtsDot3OnuDownstreamPir);
    }

    public Integer getUtsDot3OnuUpstreamCir() {
        return (Integer) getProperty(utsDot3OnuUpstreamCir).getValue();
    }

    public void setUtsDot3OnuUpstreamCir(Integer aUtsDot3OnuUpstreamCir) {
        getProperty(utsDot3OnuUpstreamCir).setValue(aUtsDot3OnuUpstreamCir);
    }

    public Integer getUtsDot3OnuDownstreamCir() {
        return (Integer) getProperty(utsDot3OnuDownstreamCir).getValue();
    }

    public void setUtsDot3OnuDownstreamCir(Integer aUtsDot3OnuDownstreamCir) {
        getProperty(utsDot3OnuDownstreamCir).setValue(aUtsDot3OnuDownstreamCir);
    }

    public Integer getUtsDot3OnuUpstreamMaxBurstSize() {
        return (Integer) getProperty(utsDot3OnuUpstreamMaxBurstSize).getValue();
    }

    public void setUtsDot3OnuUpstreamMaxBurstSize(Integer aUtsDot3OnuUpstreamMaxBurstSize) {
        getProperty(utsDot3OnuUpstreamMaxBurstSize).setValue(aUtsDot3OnuUpstreamMaxBurstSize);
    }

    public Integer getUtsDot3OnuDownstreamMaxBurstSize() {
        return (Integer) getProperty(utsDot3OnuDownstreamMaxBurstSize).getValue();
    }

    public void setUtsDot3OnuDownstreamMaxBurstSize(Integer aUtsDot3OnuDownstreamMaxBurstSize) {
        getProperty(utsDot3OnuDownstreamMaxBurstSize).setValue(aUtsDot3OnuDownstreamMaxBurstSize);
    }

    public Integer getUtsDot3OnuUpstreamWeight() {
        return (Integer) getProperty(utsDot3OnuUpstreamWeight).getValue();
    }

    public void setUtsDot3OnuUpstreamWeight(Integer aUtsDot3OnuUpstreamWeight) {
        getProperty(utsDot3OnuUpstreamWeight).setValue(aUtsDot3OnuUpstreamWeight);
    }

    public Integer getUtsDot3OnuUpstreamFir() {
        return (Integer) getProperty(utsDot3OnuUpstreamFir).getValue();
    }

    public void setUtsDot3OnuUpstreamFir(Integer aUtsDot3OnuUpstreamFir) {
        getProperty(utsDot3OnuUpstreamFir).setValue(aUtsDot3OnuUpstreamFir);
    }

    public Integer getUtsDot3OnuAppliedDbaProfile() {
        return (Integer) getProperty(utsDot3OnuAppliedDbaProfile).getValue();
    }

    public void setUtsDot3OnuAppliedDbaProfile(Integer aUtsDot3OnuAppliedDbaProfile) {
        getProperty(utsDot3OnuAppliedDbaProfile).setValue(aUtsDot3OnuAppliedDbaProfile);
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
        prepareRead(getProperty(utsDot3OnuUpstreamPir));
        prepareRead(getProperty(utsDot3OnuDownstreamPir));
        prepareRead(getProperty(utsDot3OnuUpstreamCir));
        prepareRead(getProperty(utsDot3OnuDownstreamCir));
        prepareRead(getProperty(utsDot3OnuUpstreamMaxBurstSize));
        prepareRead(getProperty(utsDot3OnuDownstreamMaxBurstSize));
        prepareRead(getProperty(utsDot3OnuUpstreamWeight));
        prepareRead(getProperty(utsDot3OnuUpstreamFir));
        prepareRead(getProperty(utsDot3OnuAppliedDbaProfile));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuUpstreamPir));
        prepareRead(getProperty(utsDot3OnuDownstreamPir));
        prepareRead(getProperty(utsDot3OnuUpstreamCir));
        prepareRead(getProperty(utsDot3OnuDownstreamCir));
        prepareRead(getProperty(utsDot3OnuUpstreamMaxBurstSize));
        prepareRead(getProperty(utsDot3OnuDownstreamMaxBurstSize));
        prepareRead(getProperty(utsDot3OnuUpstreamWeight));
        prepareRead(getProperty(utsDot3OnuUpstreamFir));
        prepareRead(getProperty(utsDot3OnuAppliedDbaProfile));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2TrafficProfTable bean = (Onu2TrafficProfTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuTProfModuleId()).append("/").append(bean.getUtsDot3OnuTProfPortId()).append("/").append(bean.getUtsDot3OnuTProfLogicalPortId()).toString();
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

    /**
     * this method is only used in batch modify GUI.
     *
     * @return
     * @throws com.winnertel.em.framework.model.MibBeanException
     *
     */
    public boolean add() throws MibBeanException {
        return true;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuUpstreamPir));
        prepareSave(getProperty(utsDot3OnuDownstreamPir));
        prepareSave(getProperty(utsDot3OnuUpstreamCir));
        prepareSave(getProperty(utsDot3OnuDownstreamCir));
        prepareSave(getProperty(utsDot3OnuUpstreamMaxBurstSize));
        prepareSave(getProperty(utsDot3OnuDownstreamMaxBurstSize));
        prepareSave(getProperty(utsDot3OnuUpstreamWeight));
        if (getUtsDot3OnuUpstreamFir() != null)
            prepareSave(getProperty(utsDot3OnuUpstreamFir));
        prepareSave(getProperty(utsDot3OnuAppliedDbaProfile));

        return save();
    }

    public String toString() {
        return "ONU " + getIndex(0) + "/" + getIndex(2) + "/" + getIndex(3);
    }

}