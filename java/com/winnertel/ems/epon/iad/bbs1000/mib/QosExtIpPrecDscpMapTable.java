package com.winnertel.ems.epon.iad.bbs1000.mib;

import java.util.Vector;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The QosExtIpPrecDscpMapTable class. Created by QuickDVM
 */
public class QosExtIpPrecDscpMapTable extends SnmpMibBean {
  public static final String utsMLSQosExtIpPrecDscpMapIntfIndex = "utsMLSQosExtIpPrecDscpMapIntfIndex";

  public static final String utsMLSQosExtIpPrecDscpMapModuleId = "utsMLSQosExtIpPrecDscpMapModuleId";

  public static final String utsMLSQosExtIpPrecDscpMapPortId = "utsMLSQosExtIpPrecDscpMapPortId";

  public static final String utsMLSQosExtIpPrecDscpMapLagPortId = "utsMLSQosExtIpPrecDscpMapLagPortId";

  public static final String utsMLSQosExtIpPrecDscpMapIpPrecVal = "utsMLSQosExtIpPrecDscpMapIpPrecVal";

  public static final String utsMLSQosExtIpPrecDscpMapDscpVal = "utsMLSQosExtIpPrecDscpMapDscpVal";

  public QosExtIpPrecDscpMapTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsMLSQosExtIpPrecDscpMapIntfIndex,
        new SnmpMibBeanProperty(utsMLSQosExtIpPrecDscpMapIntfIndex,
            ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.1",
            ISnmpConstant.INTEGER));
    initProperty(utsMLSQosExtIpPrecDscpMapModuleId,
        new SnmpMibBeanProperty(utsMLSQosExtIpPrecDscpMapModuleId,
            ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.2",
            ISnmpConstant.INTEGER));
    initProperty(utsMLSQosExtIpPrecDscpMapPortId, new SnmpMibBeanProperty(
        utsMLSQosExtIpPrecDscpMapPortId,
        ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.3", ISnmpConstant.INTEGER));
    initProperty(utsMLSQosExtIpPrecDscpMapLagPortId,
        new SnmpMibBeanProperty(utsMLSQosExtIpPrecDscpMapLagPortId,
            ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.4",
            ISnmpConstant.INTEGER));
    initProperty(utsMLSQosExtIpPrecDscpMapIpPrecVal,
        new SnmpMibBeanProperty(utsMLSQosExtIpPrecDscpMapIpPrecVal,
            ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.5",
            ISnmpConstant.INTEGER));
    initProperty(utsMLSQosExtIpPrecDscpMapDscpVal, new SnmpMibBeanProperty(
        utsMLSQosExtIpPrecDscpMapDscpVal,
        ".1.3.6.1.4.1.45121.1800.2.4.1.1.5.1.6", ISnmpConstant.INTEGER));

  }

  public Integer getUtsMLSQosExtIpPrecDscpMapIntfIndex() {
    return (Integer) getIndex(0);
  }

  public void setUtsMLSQosExtIpPrecDscpMapIntfIndex(
      Integer aUtsMLSQosExtIpPrecDscpMapIntfIndex) {
    setIndex(0, aUtsMLSQosExtIpPrecDscpMapIntfIndex);
  }

  public Integer getUtsMLSQosExtIpPrecDscpMapIpPrecVal() {
    return (Integer) getIndex(1);
  }

  public void setUtsMLSQosExtIpPrecDscpMapIpPrecVal(
      Integer aUtsMLSQosExtIpPrecDscpMapIpPrecVal) {
    setIndex(1, aUtsMLSQosExtIpPrecDscpMapIpPrecVal);
  }

  public Integer getUtsMLSQosExtIpPrecDscpMapModuleId() {
    return (Integer) getProperty(utsMLSQosExtIpPrecDscpMapModuleId)
        .getValue();
  }

  public void setUtsMLSQosExtIpPrecDscpMapModuleId(
      Integer aUtsMLSQosExtIpPrecDscpMapModuleId) {
    getProperty(utsMLSQosExtIpPrecDscpMapModuleId).setValue(
        aUtsMLSQosExtIpPrecDscpMapModuleId);
  }

  public Integer getUtsMLSQosExtIpPrecDscpMapPortId() {
    return (Integer) getProperty(utsMLSQosExtIpPrecDscpMapPortId)
        .getValue();
  }

  public void setUtsMLSQosExtIpPrecDscpMapPortId(
      Integer aUtsMLSQosExtIpPrecDscpMapPortId) {
    getProperty(utsMLSQosExtIpPrecDscpMapPortId).setValue(
        aUtsMLSQosExtIpPrecDscpMapPortId);
  }

  public Integer getUtsMLSQosExtIpPrecDscpMapLagPortId() {
    return (Integer) getProperty(utsMLSQosExtIpPrecDscpMapLagPortId)
        .getValue();
  }

  public void setUtsMLSQosExtIpPrecDscpMapLagPortId(
      Integer aUtsMLSQosExtIpPrecDscpMapLagPortId) {
    getProperty(utsMLSQosExtIpPrecDscpMapLagPortId).setValue(
        aUtsMLSQosExtIpPrecDscpMapLagPortId);
  }

  public Integer getUtsMLSQosExtIpPrecDscpMapDscpVal() {
    return (Integer) getProperty(utsMLSQosExtIpPrecDscpMapDscpVal)
        .getValue();
  }

  public void setUtsMLSQosExtIpPrecDscpMapDscpVal(
      Integer aUtsMLSQosExtIpPrecDscpMapDscpVal) {
    getProperty(utsMLSQosExtIpPrecDscpMapDscpVal).setValue(
        aUtsMLSQosExtIpPrecDscpMapDscpVal);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapModuleId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapPortId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapLagPortId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapDscpVal));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapModuleId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapPortId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapLagPortId));
    prepareRead(super.getProperty(utsMLSQosExtIpPrecDscpMapDscpVal));

    return loadAll(new int[]
        {1, 1});
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsMLSQosExtIpPrecDscpMapDscpVal));

    return save();
  }

  public boolean delete() throws MibBeanException {
    QosExtIpPrecDscpMapTable bean = new QosExtIpPrecDscpMapTable(fSnmpProxy);

    bean.setIndex(0, ((Integer) getIndex(0)).intValue() / 4 * 4);
    bean.setIndex(1, 7);
    bean.setRowsToFetch(32);

    Vector v = bean.retrieveAll();
    if (v != null) {
      for (int i = 0; i < v.size(); i++) {
        QosExtIpPrecDscpMapTable one = (QosExtIpPrecDscpMapTable) v.get(i);
        one.setUtsMLSQosExtIpPrecDscpMapDscpVal(new Integer((i % 8) * 8));
        one.prepareSave(one.getProperty(utsMLSQosExtIpPrecDscpMapDscpVal));
        one.save();
      }
    }
    return true;
  }
}
