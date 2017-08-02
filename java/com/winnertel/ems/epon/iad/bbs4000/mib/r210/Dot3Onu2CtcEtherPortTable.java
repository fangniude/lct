package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcEtherPortTable extends SnmpMibBean {

    public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
    public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
    public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
    public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
    public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";
    public static final String utsDot3OnuEtherPortPhyAdminState = "utsDot3OnuEtherPortPhyAdminState";
    public static final String utsDot3OnuEtherPortPhyAdminCtrl = "utsDot3OnuEtherPortPhyAdminCtrl";
    public static final String utsDot3OnuEtherPortAutoNegAdminSt = "utsDot3OnuEtherPortAutoNegAdminSt";
    public static final String utsDot3OnuEtherPortAutoNegLocTec = "utsDot3OnuEtherPortAutoNegLocTec";
    public static final String utsDot3OnuEtherPortAutoNegAbility = "utsDot3OnuEtherPortAutoNegAbility";
    public static final String utsDot3OnuEtherPortAutoNegRestart = "utsDot3OnuEtherPortAutoNegRestart";
    public static final String utsDot3OnuEtherPortAutoNegAdminCtrl = "utsDot3OnuEtherPortAutoNegAdminCtrl";
    public static final String utsDot3OnuEtherPortLinkState = "utsDot3OnuEtherPortLinkState";
    public static final String utsDot3OnuEtherPortClassifiRuleClear = "utsDot3OnuEtherPortClassifiRuleClear";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3Onu2CtcEtherPortTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(utsDot3OnuEtherPortIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortPhyAdminState, new SnmpMibBeanProperty(utsDot3OnuEtherPortPhyAdminState, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortPhyAdminCtrl, new SnmpMibBeanProperty(utsDot3OnuEtherPortPhyAdminCtrl, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortAutoNegAdminSt, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminSt, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortAutoNegLocTec, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegLocTec, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.9", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortAutoNegAbility, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAbility, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.10", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuEtherPortAutoNegRestart, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegRestart, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortAutoNegAdminCtrl, new SnmpMibBeanProperty(utsDot3OnuEtherPortAutoNegAdminCtrl, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortLinkState, new SnmpMibBeanProperty(utsDot3OnuEtherPortLinkState, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.30", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuEtherPortClassifiRuleClear, new SnmpMibBeanProperty(utsDot3OnuEtherPortClassifiRuleClear, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.46", ISnmpConstant.INTEGER));
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

    public Integer getUtsDot3OnuEtherPortPhyAdminState() {
        return (Integer) getProperty(utsDot3OnuEtherPortPhyAdminState).getValue();
    }

    public void setUtsDot3OnuEtherPortPhyAdminState(Integer aUtsDot3OnuEtherPortPhyAdminState) {
        getProperty(utsDot3OnuEtherPortPhyAdminState).setValue(aUtsDot3OnuEtherPortPhyAdminState);
    }

    public Integer getUtsDot3OnuEtherPortPhyAdminCtrl() {
        return (Integer) getProperty(utsDot3OnuEtherPortPhyAdminCtrl).getValue();
    }

    public void setUtsDot3OnuEtherPortPhyAdminCtrl(Integer aUtsDot3OnuEtherPortPhyAdminCtrl) {
        getProperty(utsDot3OnuEtherPortPhyAdminCtrl).setValue(aUtsDot3OnuEtherPortPhyAdminCtrl);
    }

    public Integer getUtsDot3OnuEtherPortAutoNegAdminSt() {
        return (Integer) getProperty(utsDot3OnuEtherPortAutoNegAdminSt).getValue();
    }

    public void setUtsDot3OnuEtherPortAutoNegAdminSt(Integer aUtsDot3OnuEtherPortAutoNegAdminSt) {
        getProperty(utsDot3OnuEtherPortAutoNegAdminSt).setValue(aUtsDot3OnuEtherPortAutoNegAdminSt);
    }

    public byte[] getUtsDot3OnuEtherPortAutoNegLocTec() {
        return (byte[]) getProperty(utsDot3OnuEtherPortAutoNegLocTec).getValue();
    }

    public void setUtsDot3OnuEtherPortAutoNegLocTec(byte[] aUtsDot3OnuEtherPortAutoNegLocTec) {
        getProperty(utsDot3OnuEtherPortAutoNegLocTec).setValue(aUtsDot3OnuEtherPortAutoNegLocTec);
    }

    public byte[] getUtsDot3OnuEtherPortAutoNegAbility() {
        return (byte[]) getProperty(utsDot3OnuEtherPortAutoNegAbility).getValue();
    }

    public void setUtsDot3OnuEtherPortAutoNegAbility(byte[] aUtsDot3OnuEtherPortAutoNegAbility) {
        getProperty(utsDot3OnuEtherPortAutoNegAbility).setValue(aUtsDot3OnuEtherPortAutoNegAbility);
    }

    public Integer getUtsDot3OnuEtherPortAutoNegRestart() {
        return (Integer) getProperty(utsDot3OnuEtherPortAutoNegRestart).getValue();
    }

    public void setUtsDot3OnuEtherPortAutoNegRestart(Integer aUtsDot3OnuEtherPortAutoNegRestart) {
        getProperty(utsDot3OnuEtherPortAutoNegRestart).setValue(aUtsDot3OnuEtherPortAutoNegRestart);
    }

    public Integer getUtsDot3OnuEtherPortAutoNegAdminCtrl() {
        return (Integer) getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl).getValue();
    }

    public void setUtsDot3OnuEtherPortAutoNegAdminCtrl(Integer aUtsDot3OnuEtherPortAutoNegAdminCtrl) {
        getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl).setValue(aUtsDot3OnuEtherPortAutoNegAdminCtrl);
    }

    public Integer getUtsDot3OnuEtherPortLinkState() {
        return (Integer) getProperty(utsDot3OnuEtherPortLinkState).getValue();
    }

    public void setUtsDot3OnuEtherPortLinkState(Integer aUtsDot3OnuEtherPortLinkState) {
        getProperty(utsDot3OnuEtherPortLinkState).setValue(aUtsDot3OnuEtherPortLinkState);
    }

    public Integer getUtsDot3OnuEtherPortClassifiRuleClear() {
        return (Integer) getProperty(utsDot3OnuEtherPortClassifiRuleClear).getValue();
    }

    public void setUtsDot3OnuEtherPortClassifiRuleClear(Integer aUtsDot3OnuEtherPortClassifiRuleClear) {
        getProperty(utsDot3OnuEtherPortClassifiRuleClear).setValue(aUtsDot3OnuEtherPortClassifiRuleClear);
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
        prepareRead(getProperty(utsDot3OnuEtherPortPhyAdminState));
        prepareRead(getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAdminSt));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegLocTec));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAbility));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegRestart));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
        prepareRead(getProperty(utsDot3OnuEtherPortLinkState));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuEtherPortPhyAdminState));
        prepareRead(getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAdminSt));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegLocTec));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAbility));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegRestart));
        prepareRead(getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));
        prepareRead(getProperty(utsDot3OnuEtherPortLinkState));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcEtherPortTable bean = (Dot3Onu2CtcEtherPortTable) v.get(i);
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
        prepareSave(getProperty(utsDot3OnuEtherPortPhyAdminCtrl));
        prepareSave(getProperty(utsDot3OnuEtherPortAutoNegRestart));
        prepareSave(getProperty(utsDot3OnuEtherPortAutoNegAdminCtrl));

        return save();
    }

    public boolean restartAutoNeg() throws MibBeanException {
        setUtsDot3OnuEtherPortAutoNegRestart(new Integer(1));
        prepareSave(getProperty(utsDot3OnuEtherPortAutoNegRestart));

        return save();
    }

    public boolean clearClassifiRule() throws MibBeanException {
        setUtsDot3OnuEtherPortClassifiRuleClear(new Integer(1));
        prepareSave(getProperty(utsDot3OnuEtherPortClassifiRuleClear));

        return save();
    }

}