/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Olt2VlanStackingTable class.
 * Created by QuickDVM
 */
public class Dot3Olt2VlanStackingTable extends SnmpMibBean {
  public static final String utsDot3OltVlanStackingModuleId = "utsDot3OltVlanStackingModuleId";
  public static final String utsDot3OltVlanStackingDeviceId = "utsDot3OltVlanStackingDeviceId";
  public static final String utsDot3OltVlanStackingPortId = "utsDot3OltVlanStackingPortId";
  public static final String utsDot3Olt2VlanStackingLogicalPortId = "utsDot3Olt2VlanStackingLogicalPortId";
  public static final String utsDot3Olt2VlanStackingCVlanId = "utsDot3Olt2VlanStackingCVlanId";
  public static final String utsDot3Olt2VlanStackingSVlanId = "utsDot3Olt2VlanStackingSVlanId";
  public static final String utsDot3Olt2VlanStackingPriMode = "utsDot3Olt2VlanStackingPriMode";
  public static final String utsDot3Olt2VlanStackingSVlanPri = "utsDot3Olt2VlanStackingSVlanPri";
  
  private String onuLabel = null; //added by Zengtian, 2011/9/14

  public Dot3Olt2VlanStackingTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltVlanStackingModuleId, new SnmpMibBeanProperty(utsDot3OltVlanStackingModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltVlanStackingDeviceId, new SnmpMibBeanProperty(utsDot3OltVlanStackingDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltVlanStackingPortId, new SnmpMibBeanProperty(utsDot3OltVlanStackingPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3Olt2VlanStackingLogicalPortId, new SnmpMibBeanProperty(utsDot3Olt2VlanStackingLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3Olt2VlanStackingCVlanId, new SnmpMibBeanProperty(utsDot3Olt2VlanStackingCVlanId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3Olt2VlanStackingSVlanId, new SnmpMibBeanProperty(utsDot3Olt2VlanStackingSVlanId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3Olt2VlanStackingPriMode, new SnmpMibBeanProperty(utsDot3Olt2VlanStackingPriMode, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3Olt2VlanStackingSVlanPri, new SnmpMibBeanProperty(utsDot3Olt2VlanStackingSVlanPri, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.8", ISnmpConstant.INTEGER));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.8.1.9", ISnmpConstant.INTEGER));
  }

  public Integer getUtsDot3OltVlanStackingModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltVlanStackingModuleId(Integer aUtsDot3OltVlanStackingModuleId) {
    setIndex(0, aUtsDot3OltVlanStackingModuleId);
  }


  public Integer getUtsDot3OltVlanStackingDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltVlanStackingDeviceId(Integer aUtsDot3OltVlanStackingDeviceId) {
    setIndex(1, aUtsDot3OltVlanStackingDeviceId);
  }


  public Integer getUtsDot3OltVlanStackingPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OltVlanStackingPortId(Integer aUtsDot3OltVlanStackingPortId) {
    setIndex(2, aUtsDot3OltVlanStackingPortId);
  }


  public Integer getUtsDot3Olt2VlanStackingLogicalPortId() {
    return (Integer) getIndex(3);
  }

  public void setUtsDot3Olt2VlanStackingLogicalPortId(Integer aUtsDot3Olt2VlanStackingLogicalPortId) {
    setIndex(3, aUtsDot3Olt2VlanStackingLogicalPortId);
  }


  public Integer getUtsDot3Olt2VlanStackingCVlanId() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3Olt2VlanStackingCVlanId(Integer aUtsDot3Olt2VlanStackingCVlanId) {
    setIndex(4, aUtsDot3Olt2VlanStackingCVlanId);
  }

  public Integer getUtsDot3Olt2VlanStackingSVlanId() {
    return (Integer) getProperty(utsDot3Olt2VlanStackingSVlanId).getValue();
  }

  public void setUtsDot3Olt2VlanStackingSVlanId(Integer aUtsDot3Olt2VlanStackingSVlanId) {
    getProperty(utsDot3Olt2VlanStackingSVlanId).setValue(aUtsDot3Olt2VlanStackingSVlanId);
  }

  public Integer getUtsDot3Olt2VlanStackingPriMode() {
    return (Integer) getProperty(utsDot3Olt2VlanStackingPriMode).getValue();
  }

  public void setUtsDot3Olt2VlanStackingPriMode(Integer aUtsDot3Olt2VlanStackingPriMode) {
    getProperty(utsDot3Olt2VlanStackingPriMode).setValue(aUtsDot3Olt2VlanStackingPriMode);
  }

  public Integer getUtsDot3Olt2VlanStackingSVlanPri() {
    return (Integer) getProperty(utsDot3Olt2VlanStackingSVlanPri).getValue();
  }

  public void setUtsDot3Olt2VlanStackingSVlanPri(Integer aUtsDot3Olt2VlanStackingSVlanPri) {
    getProperty(utsDot3Olt2VlanStackingSVlanPri).setValue(aUtsDot3Olt2VlanStackingSVlanPri);
  }
  
  //added by Zengtian, 2011/9/14
  public String getOnuLabel() {
      return onuLabel;
  }

  //added by Zengtian, 2011/9/14
  public void setOnuLabel(String label) {
      onuLabel = label;
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingSVlanId));
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingPriMode));
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingSVlanPri));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingSVlanId));
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingPriMode));
    prepareRead(super.getProperty(utsDot3Olt2VlanStackingSVlanPri));


    Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

    //added by Zengtian, 2011/9/14
//    if (!DebugMode.isDebug()) {
//        try {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//            for (int i = 0; i < v.size(); i++) {
//            	Dot3Olt2VlanStackingTable bean = (Dot3Olt2VlanStackingTable) v.get(i);
//                String key = new StringBuilder(neName).append(bean.getUtsDot3OltVlanStackingModuleId()).append("/").append(bean.getUtsDot3OltVlanStackingPortId()).append("/").append(bean.getUtsDot3Olt2VlanStackingLogicalPortId()).toString();
//                if (map.containsKey(key)) {
//                    bean.setOnuLabel((String) map.get(key));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    return v;
  }

  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsDot3Olt2VlanStackingSVlanId));
    prepareSave(getProperty(utsDot3Olt2VlanStackingPriMode));
    prepareSave(getProperty(utsDot3Olt2VlanStackingSVlanPri));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }
}
