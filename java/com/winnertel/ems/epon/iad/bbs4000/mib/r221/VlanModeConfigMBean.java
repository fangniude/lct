package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class VlanModeConfigMBean extends SnmpMibBean {

    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
    public static final String utsDot3OnuEtherPortVlanMode = "utsDot3OnuEtherPortVlanMode";
    public static final String utsDot3OnuEtherPortVlanTag = "utsDot3OnuEtherPortVlanTag";
    public static final String utsDot3OnuEtherPortVlanTPID = "utsDot3OnuEtherPortVlanTPID";
    public static final String utsDot3OnuEtherPortVlanTranslation = "utsDot3OnuEtherPortVlanTranslation";
    public static final String utsDot3OnuEtherPortVlanNaggregationNumber = "utsDot3OnuEtherPortVlanNaggregationNumber";
    public static final String utsDot3OnuEtherPortVlanNaggregation = "utsDot3OnuEtherPortVlanNaggregation";
    public static final String utsDot3OnuEtherPortVlanTrunk = "utsDot3OnuEtherPortVlanTrunk";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public VlanModeConfigMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanMode, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.36", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTag, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTag, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.38", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTPID, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTPID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.37", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanTranslation, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTranslation, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.40", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortVlanNaggregationNumber, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregationNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.50", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortVlanNaggregation, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanNaggregation, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.51", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortVlanTrunk, new SnmpMibBeanProperty(utsDot3OnuEtherPortVlanTrunk, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.11.1.52", ISnmpConstant.OCTETS));
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

    public Integer getUtsDot3OnuEtherPortVlanMode() {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanMode).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanMode(Integer aUtsDot3OnuEtherPortVlanMode) {
        getProperty(utsDot3OnuEtherPortVlanMode).setValue(aUtsDot3OnuEtherPortVlanMode);
    }

    public Integer getUtsDot3OnuEtherPortVlanTag() {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanTag).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanTag(Integer aUtsDot3OnuEtherPortVlanTag) {
        getProperty(utsDot3OnuEtherPortVlanTag).setValue(aUtsDot3OnuEtherPortVlanTag);
    }

    public Integer getUtsDot3OnuEtherPortVlanTPID() {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanTPID).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanTPID(Integer aUtsDot3OnuEtherPortVlanTPID) {
        getProperty(utsDot3OnuEtherPortVlanTPID).setValue(aUtsDot3OnuEtherPortVlanTPID);
    }

    public byte[] getUtsDot3OnuEtherPortVlanTranslation() {
        return (byte[]) getProperty(utsDot3OnuEtherPortVlanTranslation).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanTranslation(byte[] aUtsDot3OnuEtherPortVlanTranslation) {
        getProperty(utsDot3OnuEtherPortVlanTranslation).setValue(aUtsDot3OnuEtherPortVlanTranslation);
    }

    public Integer getUtsDot3OnuEtherPortVlanNaggregationNumber() {
        return (Integer) getProperty(utsDot3OnuEtherPortVlanNaggregationNumber).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanNaggregationNumber(Integer aUtsDot3OnuEtherPortVlanNaggregationNumber) {
        getProperty(utsDot3OnuEtherPortVlanNaggregationNumber).setValue(aUtsDot3OnuEtherPortVlanNaggregationNumber);
    }

    public byte[] getUtsDot3OnuEtherPortVlanNaggregation() {
        return (byte[]) getProperty(utsDot3OnuEtherPortVlanNaggregation).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanNaggregation(byte[] aUtsDot3OnuEtherPortVlanNaggregation) {
        getProperty(utsDot3OnuEtherPortVlanNaggregation).setValue(aUtsDot3OnuEtherPortVlanNaggregation);
    }

    public byte[] getUtsDot3OnuEtherPortVlanTrunk() {
        return (byte[]) getProperty(utsDot3OnuEtherPortVlanTrunk).getValue();
    }

    public void setUtsDot3OnuEtherPortVlanTrunk(byte[] aUtsDot3OnuEtherPortVlanTrunk) {
        getProperty(utsDot3OnuEtherPortVlanTrunk).setValue(aUtsDot3OnuEtherPortVlanTrunk);
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
        prepareRead(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTrunk));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareRead(getProperty(utsDot3OnuEtherPortVlanTrunk));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
        /*if (!DebugMode.isDebug()) {
            try {
                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
                Map map = onuMgmtMgr.getOnuLabelMap(neName);
                for (int i = 0; i < v.size(); i++) {
                    VlanModeConfigMBean bean = (VlanModeConfigMBean) v.get(i);
                    //find the onu by module/port/logicalid
                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuModuleId()).append("/").append(bean.getUtsDot3OnuPortId()).append("/").append(bean.getUtsDot3OnuLogicalPortId()).toString();
                    if (map.containsKey(key)) {
                        bean.setOnuLabel((String) map.get(key));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuEtherPortVlanMode));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTag));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTPID));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTranslation));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregationNumber));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanNaggregation));
        prepareSave(getProperty(utsDot3OnuEtherPortVlanTrunk));

        return save();
    }

}