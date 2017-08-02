package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PonVlanTranslationTable extends SnmpMibBean {

    public static final String utsPonVlanTranslationModuleID = "utsPonVlanTranslationModuleID";
    public static final String utsPonVlanTranslationDeviceID = "utsPonVlanTranslationDeviceID";
    public static final String utsPonVlanTranslationPortID = "utsPonVlanTranslationPortID";
    public static final String utsPonVlanTranslationLogicPortID = "utsPonVlanTranslationLogicPortID";
    public static final String utsPonVlanTranslationOldVID = "utsPonVlanTranslationOldVID";
    public static final String utsPonVlanTranslationOldCos = "utsPonVlanTranslationOldCos";
    public static final String utsPonVlanTranslationNewVID = "utsPonVlanTranslationNewVID";
    public static final String utsPonVlanTranslationNewCos = "utsPonVlanTranslationNewCos";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public PonVlanTranslationTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsPonVlanTranslationModuleID, new SnmpMibBeanProperty(utsPonVlanTranslationModuleID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.1", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationDeviceID, new SnmpMibBeanProperty(utsPonVlanTranslationDeviceID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.2", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationPortID, new SnmpMibBeanProperty(utsPonVlanTranslationPortID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.3", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationLogicPortID, new SnmpMibBeanProperty(utsPonVlanTranslationLogicPortID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.4", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationOldVID, new SnmpMibBeanProperty(utsPonVlanTranslationOldVID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.5", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationOldCos, new SnmpMibBeanProperty(utsPonVlanTranslationOldCos, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.6", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationNewVID, new SnmpMibBeanProperty(utsPonVlanTranslationNewVID, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.7", ISnmpConstant.INTEGER));
        initProperty(utsPonVlanTranslationNewCos, new SnmpMibBeanProperty(utsPonVlanTranslationNewCos, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.8", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.1.3.15.1.9", ISnmpConstant.INTEGER));
    }

    public Integer getUtsPonVlanTranslationModuleID() {
        return (Integer) getIndex(0);
    }

    public void setUtsPonVlanTranslationModuleID(Integer autsPonVlanTranslationModuleID) {
        setIndex(0, autsPonVlanTranslationModuleID);
    }

    public Integer getUtsPonVlanTranslationDeviceID() {
        return (Integer) getIndex(1);
    }

    public void setUtsPonVlanTranslationDeviceID(Integer autsPonVlanTranslationDeviceID) {
        setIndex(1, autsPonVlanTranslationDeviceID);
    }

    public Integer getUtsPonVlanTranslationPortID() {
        return (Integer) getIndex(2);
    }

    public void setUtsPonVlanTranslationPortID(Integer autsPonVlanTranslationPortID) {
        setIndex(2, autsPonVlanTranslationPortID);
    }

    public Integer getUtsPonVlanTranslationLogicPortID() {
        return (Integer) getIndex(3);
    }

    public void setUtsPonVlanTranslationLogicPortID(Integer autsPonVlanTranslationLogicPortID) {
        setIndex(3, autsPonVlanTranslationLogicPortID);
    }

    public Integer getUtsPonVlanTranslationOldVID() {
        return (Integer) getIndex(4);
    }

    public void setUtsPonVlanTranslationOldVID(Integer autsPonVlanTranslationOldVID) {
        setIndex(4, autsPonVlanTranslationOldVID);
    }

    public Integer getUtsPonVlanTranslationOldCos() {
        return (Integer) getIndex(5);
    }

    public void setUtsPonVlanTranslationOldCos(Integer aUtsPonVlanTranslationOldCos) {
        setIndex(5, aUtsPonVlanTranslationOldCos);
    }

    public Integer getUtsPonVlanTranslationNewVID() {
        return (Integer) getProperty(utsPonVlanTranslationNewVID).getValue();
    }

    public void setUtsPonVlanTranslationNewVID(Integer aUtsPonVlanTranslationNewVID) {
        getProperty(utsPonVlanTranslationNewVID).setValue(aUtsPonVlanTranslationNewVID);
    }

    public Integer getUtsPonVlanTranslationNewCos() {
        return (Integer) getProperty(utsPonVlanTranslationNewCos).getValue();
    }

    public void setUtsPonVlanTranslationNewCos(Integer aUtsPonVlanTranslationNewCos) {
        getProperty(utsPonVlanTranslationNewCos).setValue(aUtsPonVlanTranslationNewCos);
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
        prepareRead(getProperty(utsPonVlanTranslationNewVID));
        prepareRead(getProperty(utsPonVlanTranslationNewCos));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsPonVlanTranslationNewVID));
        prepareRead(getProperty(utsPonVlanTranslationNewCos));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    PonVlanTranslationTable bean = (PonVlanTranslationTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsPonVlanTranslationModuleID()).append("/").append(bean.getUtsPonVlanTranslationPortID()).append("/").append(bean.getUtsPonVlanTranslationLogicPortID()).toString();
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
        prepareSave(getProperty(utsPonVlanTranslationNewVID));
        prepareSave(getProperty(utsPonVlanTranslationNewCos));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}