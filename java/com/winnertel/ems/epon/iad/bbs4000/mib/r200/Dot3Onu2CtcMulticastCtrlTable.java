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
 * The Dot3Onu2CtcMulticastCtrlTable class.
 * Created by QuickDVM
 */
public class Dot3Onu2CtcMulticastCtrlTable extends SnmpMibBean {
  public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
  public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
  public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
  public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
  public static final String utsDot3OnuMCastEntryIndex = "utsDot3OnuMCastEntryIndex";
  public static final String utsDot3OnuMCastEntryUserId = "utsDot3OnuMCastEntryUserId";
  public static final String utsDot3OnuMCastEntryMcVlanId = "utsDot3OnuMCastEntryMcVlanId";
  public static final String utsDot3OnuMCastEntryMcMacAddr = "utsDot3OnuMCastEntryMcMacAddr";
  
  private String onuLabel = null; //added by Zengtian, 2011/9/14


  public Dot3Onu2CtcMulticastCtrlTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.4", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastEntryIndex, new SnmpMibBeanProperty(utsDot3OnuMCastEntryIndex, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.5", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastEntryUserId, new SnmpMibBeanProperty(utsDot3OnuMCastEntryUserId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.6", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastEntryMcVlanId, new SnmpMibBeanProperty(utsDot3OnuMCastEntryMcVlanId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.7", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuMCastEntryMcMacAddr, new SnmpMibBeanProperty(utsDot3OnuMCastEntryMcMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.13.1.8", ISnmpConstant.OCTETS));
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


  public Integer getUtsDot3OnuMCastEntryIndex() {
    return (Integer) getIndex(4);
  }

  public void setUtsDot3OnuMCastEntryIndex(Integer aUtsDot3OnuMCastEntryIndex) {
    setIndex(4, aUtsDot3OnuMCastEntryIndex);
  }


  public Integer getUtsDot3OnuMCastEntryUserId() {
    return (Integer) getProperty(utsDot3OnuMCastEntryUserId).getValue();
  }

  public void setUtsDot3OnuMCastEntryUserId(Integer aUtsDot3OnuMCastEntryUserId) {
    getProperty(utsDot3OnuMCastEntryUserId).setValue(aUtsDot3OnuMCastEntryUserId);
  }

  public Integer getUtsDot3OnuMCastEntryMcVlanId() {
    return (Integer) getProperty(utsDot3OnuMCastEntryMcVlanId).getValue();
  }

  public void setUtsDot3OnuMCastEntryMcVlanId(Integer aUtsDot3OnuMCastEntryMcVlanId) {
    getProperty(utsDot3OnuMCastEntryMcVlanId).setValue(aUtsDot3OnuMCastEntryMcVlanId);
  }

  public byte[] getUtsDot3OnuMCastEntryMcMacAddr() {
    return (byte[]) getProperty(utsDot3OnuMCastEntryMcMacAddr).getValue();
  }

  public void setUtsDot3OnuMCastEntryMcMacAddr(byte[] aUtsDot3OnuMCastEntryMcMacAddr) {
    getProperty(utsDot3OnuMCastEntryMcMacAddr).setValue(aUtsDot3OnuMCastEntryMcMacAddr);
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
    prepareRead(super.getProperty(utsDot3OnuMCastEntryUserId));
    prepareRead(super.getProperty(utsDot3OnuMCastEntryMcVlanId));
    prepareRead(super.getProperty(utsDot3OnuMCastEntryMcMacAddr));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuMCastEntryUserId));
    prepareRead(super.getProperty(utsDot3OnuMCastEntryMcVlanId));
    prepareRead(super.getProperty(utsDot3OnuMCastEntryMcMacAddr));

    Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

//    if (!DebugMode.isDebug()) {
//        try {
//            //added by Zengtian, 2011/9/14
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//            for (int i = 0; i < v.size(); i++) {
//                Dot3Onu2CtcMulticastCtrlTable bean = (Dot3Onu2CtcMulticastCtrlTable) v.get(i);
//                //find the onu by module/port/logicalid
//                String key = new StringBuilder(neName).append(bean.getUtsDot3OnuModuleId()).append("/").append(bean.getUtsDot3OnuPortId()).append("/").append(bean.getUtsDot3OnuLogicalPortId()).toString();
//                if (map.containsKey(key)) {
//                    bean.setOnuLabel((String) map.get(key));
//                }
//            }
//
//            ObjectFactory factory = ClientUtility.getObjectFactory();
//            MibProxyMgr mibMgr = (MibProxyMgr) factory.getSystemMgr(-1, "MibProxyMgr");
//            Vector tftpVector = mibMgr.retrieveAll(neName, "utsDot3Onu2CtcMulticastCtrlTable");
//
//            v = new Vector(tftpVector.size());
//            for (int i = 0; i < tftpVector.size(); i++) {
//                Dot3Onu2CtcMulticastCtrlTable bean = new Dot3Onu2CtcMulticastCtrlTable(fSnmpProxy);
//                Vector vv = (Vector) tftpVector.get(i);
//                bean.setUtsDot3OnuModuleId((Integer) vv.get(0));
//                //skip the utsDot3Onu2MCtrlDeviceId which is not useful.
//                bean.setUtsDot3OnuPortId((Integer) vv.get(2));
//                bean.setUtsDot3OnuLogicalPortId((Integer) vv.get(3));
//                bean.setUtsDot3OnuMCastEntryIndex((Integer) vv.get(4));
//                bean.setUtsDot3OnuMCastEntryUserId((Integer) vv.get(5));
//                bean.setUtsDot3OnuMCastEntryMcVlanId((Integer) vv.get(6));
//                bean.setUtsDot3OnuMCastEntryMcMacAddr((byte[]) vv.get(7));
//                v.add(bean);
//            }
//
//            return v;
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

    return v;
  }
}
    