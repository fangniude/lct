/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuFlexQinQMBean extends SnmpMibBean {

    public static final String utsDot3OnuFlexQinQModuleId = "utsDot3OnuFlexQinQModuleId";
    public static final String utsDot3OnuFlexQinQDeviceId = "utsDot3OnuFlexQinQDeviceId";
    public static final String utsDot3OnuFlexQinQPortId = "utsDot3OnuFlexQinQPortId";
    public static final String utsDot3OnuFlexQinQLogicalPortId = "utsDot3OnuFlexQinQLogicalPortId";
    public static final String utsDot3OnuFlexQinQEtherType = "utsDot3OnuFlexQinQEtherType";
    public static final String utsDot3OnuFlexQinQSourceCCos = "utsDot3OnuFlexQinQSourceCCos";
    public static final String utsDot3OnuFlexQinQSourceCVID = "utsDot3OnuFlexQinQSourceCVID";
    public static final String utsDot3OnuFlexQinQSourceCTPID = "utsDot3OnuFlexQinQSourceCTPID";
    public static final String utsDot3OnuFlexQinQDestinationSTPID = "utsDot3OnuFlexQinQDestinationSTPID";
    public static final String utsDot3OnuFlexQinQDestinationSCosAction = "utsDot3OnuFlexQinQDestinationSCosAction";
    public static final String utsDot3OnuFlexQinQDestinationSVID = "utsDot3OnuFlexQinQDestinationSVID";
    public static final String utsDot3OnuFlexQinQDestinationCTPID = "utsDot3OnuFlexQinQDestinationCTPID";
    public static final String utsDot3OnuFlexQinQDestinationCCosAction = "utsDot3OnuFlexQinQDestinationCCosAction";
    public static final String utsDot3OnuFlexQinQDestinationCVID = "utsDot3OnuFlexQinQDestinationCVID";
    public static final String utsDot3OnuFlexQinQDestinationAppointSCos = "utsDot3OnuFlexQinQDestinationAppointSCos";
    public static final String utsDot3OnuFlexQinQDestinationAppointCCos = "utsDot3OnuFlexQinQDestinationAppointCCos";
    public static final String utsDot3OnuFlexQinQDestinationTagMode = "utsDot3OnuFlexQinQDestinationTagMode";
    public static final String utsDot3OnuFlexQinQDestinationSTagProperty = "utsDot3OnuFlexQinQDestinationSTagProperty";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuFlexQinQMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuFlexQinQModuleId, new SnmpMibBeanProperty(utsDot3OnuFlexQinQModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDeviceId, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQPortId, new SnmpMibBeanProperty(utsDot3OnuFlexQinQPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuFlexQinQLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQEtherType, new SnmpMibBeanProperty(utsDot3OnuFlexQinQEtherType, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQSourceCCos, new SnmpMibBeanProperty(utsDot3OnuFlexQinQSourceCCos, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQSourceCVID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQSourceCVID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQSourceCTPID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQSourceCTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationSTPID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationSTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationSCosAction, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationSCosAction, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.10", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationSVID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationSVID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.11", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationCTPID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationCTPID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.12", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationCCosAction, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationCCosAction, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.13", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationCVID, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationCVID, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.14", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationAppointSCos, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationAppointSCos, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.15", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationAppointCCos, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationAppointCCos, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.16", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationTagMode, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationTagMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.17", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFlexQinQDestinationSTagProperty, new SnmpMibBeanProperty(utsDot3OnuFlexQinQDestinationSTagProperty, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.18", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.25.1.19", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuFlexQinQModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuFlexQinQModuleId(Integer aUtsDot3OnuFlexQinQModuleId) {
        setIndex(0, aUtsDot3OnuFlexQinQModuleId);
    }

    public Integer getUtsDot3OnuFlexQinQDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuFlexQinQDeviceId(Integer aUtsDot3OnuFlexQinQDeviceId) {
        setIndex(1, aUtsDot3OnuFlexQinQDeviceId);
    }

    public Integer getUtsDot3OnuFlexQinQPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuFlexQinQPortId(Integer aUtsDot3OnuFlexQinQPortId) {
        setIndex(2, aUtsDot3OnuFlexQinQPortId);
    }

    public Integer getUtsDot3OnuFlexQinQLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuFlexQinQLogicalPortId(Integer aUtsDot3OnuFlexQinQLogicalPortId) {
        setIndex(3, aUtsDot3OnuFlexQinQLogicalPortId);
    }

    public Integer getUtsDot3OnuFlexQinQEtherType() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3OnuFlexQinQEtherType(Integer aUtsDot3OnuFlexQinQEtherType) {
        setIndex(4, aUtsDot3OnuFlexQinQEtherType);
    }

    public Integer getUtsDot3OnuFlexQinQSourceCCos() {
        return (Integer) getIndex(5);
    }

    public void setUtsDot3OnuFlexQinQSourceCCos(Integer aUtsDot3OnuFlexQinQSourceCCos) {
        setIndex(5, aUtsDot3OnuFlexQinQSourceCCos);
    }

    public Integer getUtsDot3OnuFlexQinQSourceCVID() {
        return (Integer) getIndex(6);
    }

    public void setUtsDot3OnuFlexQinQSourceCVID(Integer aUtsDot3OnuFlexQinQSourceCVID) {
        setIndex(6, aUtsDot3OnuFlexQinQSourceCVID);
    }

    public Integer getUtsDot3OnuFlexQinQSourceCTPID() {
        return (Integer) getIndex(7);
    }

    public void setUtsDot3OnuFlexQinQSourceCTPID(Integer aUtsDot3OnuFlexQinQSourceCTPID) {
        setIndex(7, aUtsDot3OnuFlexQinQSourceCTPID);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationSTPID() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationSTPID).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationSTPID(Integer aUtsDot3OnuFlexQinQDestinationSTPID) {
        getProperty(utsDot3OnuFlexQinQDestinationSTPID).setValue(aUtsDot3OnuFlexQinQDestinationSTPID);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationSCosAction() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationSCosAction).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationSCosAction(Integer aUtsDot3OnuFlexQinQDestinationSCosAction) {
        getProperty(utsDot3OnuFlexQinQDestinationSCosAction).setValue(aUtsDot3OnuFlexQinQDestinationSCosAction);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationSVID() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationSVID).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationSVID(Integer aUtsDot3OnuFlexQinQDestinationSVID) {
        getProperty(utsDot3OnuFlexQinQDestinationSVID).setValue(aUtsDot3OnuFlexQinQDestinationSVID);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationCTPID() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationCTPID).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationCTPID(Integer aUtsDot3OnuFlexQinQDestinationCTPID) {
        getProperty(utsDot3OnuFlexQinQDestinationCTPID).setValue(aUtsDot3OnuFlexQinQDestinationCTPID);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationCCosAction() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationCCosAction).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationCCosAction(Integer aUtsDot3OnuFlexQinQDestinationCCosAction) {
        getProperty(utsDot3OnuFlexQinQDestinationCCosAction).setValue(aUtsDot3OnuFlexQinQDestinationCCosAction);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationCVID() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationCVID).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationCVID(Integer aUtsDot3OnuFlexQinQDestinationCVID) {
        getProperty(utsDot3OnuFlexQinQDestinationCVID).setValue(aUtsDot3OnuFlexQinQDestinationCVID);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationAppointSCos() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationAppointSCos).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationAppointSCos(Integer aUtsDot3OnuFlexQinQDestinationAppointSCos) {
        getProperty(utsDot3OnuFlexQinQDestinationAppointSCos).setValue(aUtsDot3OnuFlexQinQDestinationAppointSCos);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationAppointCCos() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationAppointCCos).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationAppointCCos(Integer aUtsDot3OnuFlexQinQDestinationAppointCCos) {
        getProperty(utsDot3OnuFlexQinQDestinationAppointCCos).setValue(aUtsDot3OnuFlexQinQDestinationAppointCCos);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationTagMode() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationTagMode).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationTagMode(Integer aUtsDot3OnuFlexQinQDestinationTagMode) {
        getProperty(utsDot3OnuFlexQinQDestinationTagMode).setValue(aUtsDot3OnuFlexQinQDestinationTagMode);
    }

    public Integer getUtsDot3OnuFlexQinQDestinationSTagProperty() {
        return (Integer) getProperty(utsDot3OnuFlexQinQDestinationSTagProperty).getValue();
    }

    public void setUtsDot3OnuFlexQinQDestinationSTagProperty(Integer aUtsDot3OnuFlexQinQDestinationSTagProperty) {
        getProperty(utsDot3OnuFlexQinQDestinationSTagProperty).setValue(aUtsDot3OnuFlexQinQDestinationSTagProperty);
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
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSTPID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSCosAction));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSVID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCTPID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCCosAction));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCVID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationAppointSCos));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationAppointCCos));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationTagMode));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSTagProperty));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSTPID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSCosAction));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSVID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCTPID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCCosAction));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationCVID));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationAppointSCos));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationAppointCCos));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationTagMode));
        prepareRead(getProperty(utsDot3OnuFlexQinQDestinationSTagProperty));

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuFlexQinQMBean bean = (OnuFlexQinQMBean) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuFlexQinQModuleId()).append("/").append(bean.getUtsDot3OnuFlexQinQPortId()).append("/").append(bean.getUtsDot3OnuFlexQinQLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSTPID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSCosAction));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSVID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCTPID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCCosAction));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCVID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationAppointSCos));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationAppointCCos));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationTagMode));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSTagProperty));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSTPID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSCosAction));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSVID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCTPID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCCosAction));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationCVID));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationAppointSCos));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationAppointCCos));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationTagMode));
        prepareSave(getProperty(utsDot3OnuFlexQinQDestinationSTagProperty));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public String toString() {
        return "ONU " + getIndex(0) + "/" + getIndex(2) + "/" + getIndex(3);
    }

}