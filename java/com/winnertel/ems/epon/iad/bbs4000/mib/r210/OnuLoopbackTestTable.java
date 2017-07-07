package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Olt2PortTable class.
 * Created by QuickDVM
 */
public class OnuLoopbackTestTable extends SnmpMibBean {
  public static final String utsDot3OltModuleId = "utsDot3OltModuleId";
  public static final String utsDot3OltDeviceId = "utsDot3OltDeviceId";
  public static final String utsDot3OltPortId = "utsDot3OltPortId";
  public static final String utsDot3OltPortLoopbackDetection = "utsDot3OltPortLoopbackDetection";
  public static final String utsDot3OltPortLoopbackDetectionControl = "utsDot3OltPortLoopbackDetectionControl";

  public OnuLoopbackTestTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(utsDot3OltModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltDeviceId, new SnmpMibBeanProperty(utsDot3OltDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.2", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortId, new SnmpMibBeanProperty(utsDot3OltPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.3", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortLoopbackDetection, new SnmpMibBeanProperty(utsDot3OltPortLoopbackDetection, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.24", ISnmpConstant.INTEGER));
    initProperty(utsDot3OltPortLoopbackDetectionControl, new SnmpMibBeanProperty(utsDot3OltPortLoopbackDetectionControl, ".1.3.6.1.4.1.41355.1800.2.3.1.1.3.2.1.26", ISnmpConstant.INTEGER));
  }

  public Integer getUtsDot3OltModuleId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId) {
    setIndex(0, aUtsDot3OltModuleId);
  }


  public Integer getUtsDot3OltDeviceId() {
    return (Integer) getIndex(1);
  }

  public void setUtsDot3OltDeviceId(Integer aUtsDot3OltDeviceId) {
    setIndex(1, aUtsDot3OltDeviceId);
  }


  public Integer getUtsDot3OltPortId() {
    return (Integer) getIndex(2);
  }

  public void setUtsDot3OltPortId(Integer aUtsDot3OltPortId) {
    setIndex(2, aUtsDot3OltPortId);
  }


  public Integer getUtsDot3OltPortLoopbackDetection() {
    return (Integer) getProperty(utsDot3OltPortLoopbackDetection).getValue();
  }

  public void setUtsDot3OltPortLoopbackDetection(Integer autsDot3OltPortLoopbackDetection) {
    getProperty(utsDot3OltPortLoopbackDetection).setValue(autsDot3OltPortLoopbackDetection);
  }

  public Integer getUtsDot3OltPortLoopbackDetectionControl() {
    return (Integer) getProperty(utsDot3OltPortLoopbackDetectionControl).getValue();
  }

  public void setUtsDot3OltPortLoopbackDetectionControl(Integer autsDot3OltPortLoopbackDetectionControl) {
    getProperty(utsDot3OltPortLoopbackDetectionControl).setValue(autsDot3OltPortLoopbackDetectionControl);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltPortLoopbackDetection));
    prepareRead(super.getProperty(utsDot3OltPortLoopbackDetectionControl));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OltPortLoopbackDetection));
    prepareRead(super.getProperty(utsDot3OltPortLoopbackDetectionControl));

    return loadAll(new int[]{1, 1, 1});
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsDot3OltPortLoopbackDetection));
    prepareSave(getProperty(utsDot3OltPortLoopbackDetectionControl));

    return save();
  }
}