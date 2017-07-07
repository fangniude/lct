package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuUpgradeHwTypeTable class.
 * Created by QuickDVM
 */
public class OnuUpgradeHwTypeTable extends SnmpMibBean {
  public static final String onuUpgradeHwTypeHwType = "onuUpgradeHwTypeHwType";
  public static final String onuUpgradeHwTypeHwRevision = "onuUpgradeHwTypeHwRevision";
  public static final String onuUpgradeHwTypeOnuUpgradeTarget = "onuUpgradeHwTypeOnuUpgradeTarget";
  public static final String onuUpgradeHwTypeMethod = "onuUpgradeHwTypeMethod";
  public static final String onuUpgradeHwTypeFwRevision = "onuUpgradeHwTypeFwRevision";
  public static final String onuUpgradeHwTypeImageName = "onuUpgradeHwTypeImageName";

  public OnuUpgradeHwTypeTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(onuUpgradeHwTypeHwType, new SnmpMibBeanProperty(
        onuUpgradeHwTypeHwType, ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.1",
        ISnmpConstant.INTEGER));
    initProperty(onuUpgradeHwTypeOnuUpgradeTarget, new SnmpMibBeanProperty(
        onuUpgradeHwTypeOnuUpgradeTarget,
        ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.2", ISnmpConstant.INTEGER));
    initProperty(onuUpgradeHwTypeMethod, new SnmpMibBeanProperty(
        onuUpgradeHwTypeMethod, ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.3",
        ISnmpConstant.INTEGER));
      initProperty(onuUpgradeHwTypeHwRevision, new SnmpMibBeanProperty(
          onuUpgradeHwTypeHwRevision, ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.4",
          ISnmpConstant.STRING));
    initProperty(onuUpgradeHwTypeFwRevision, new SnmpMibBeanProperty(
        onuUpgradeHwTypeFwRevision, ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.5",
        ISnmpConstant.STRING));
    initProperty(onuUpgradeHwTypeImageName, new SnmpMibBeanProperty(
        onuUpgradeHwTypeImageName, ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.6",
        ISnmpConstant.STRING));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
        ".1.3.6.1.4.1.41355.1.3.10.5.2.23.1.7", ISnmpConstant.INTEGER));

  }

  public Integer getOnuUpgradeHwTypeHwType() {
    return (Integer) getIndex(0);
  }

  public void setOnuUpgradeHwTypeHwType(Integer aOnuUpgradeHwTypeHwType) {
    setIndex(0, aOnuUpgradeHwTypeHwType);
  }

  public Integer getOnuUpgradeHwTypeOnuUpgradeTarget() {
    return (Integer) getIndex(1);
  }

  public void setOnuUpgradeHwTypeOnuUpgradeTarget(
      Integer aOnuUpgradeHwTypeOnuUpgradeTarget) {
    setIndex(1, aOnuUpgradeHwTypeOnuUpgradeTarget);
  }

  public Integer getOnuUpgradeHwTypeMethod() {
    return (Integer) getIndex(2);
  }

  public void setOnuUpgradeHwTypeMethod(Integer aOnuUpgradeHwTypeMethod) {
    setIndex(2, aOnuUpgradeHwTypeMethod);
  }

    public String getOnuUpgradeHwTypeHwRevision() {
      return (String) getProperty(onuUpgradeHwTypeHwRevision).getValue();
    }

    public void setOnuUpgradeHwTypeHwRevision(String aOnuUpgradeHwTypeHwRevision) {
      getProperty(onuUpgradeHwTypeHwRevision).setValue(
          aOnuUpgradeHwTypeHwRevision);
    }

  public String getOnuUpgradeHwTypeFwRevision() {
    return (String) getProperty(onuUpgradeHwTypeFwRevision).getValue();
  }

  public void setOnuUpgradeHwTypeFwRevision(String aOnuUpgradeHwTypeFwRevision) {
    getProperty(onuUpgradeHwTypeFwRevision).setValue(
        aOnuUpgradeHwTypeFwRevision);
  }

  public String getOnuUpgradeHwTypeImageName() {
    return (String) getProperty(onuUpgradeHwTypeImageName).getValue();
  }

  public void setOnuUpgradeHwTypeImageName(String aOnuUpgradeHwTypeImageName) {
    getProperty(onuUpgradeHwTypeImageName).setValue(aOnuUpgradeHwTypeImageName);
  }

  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(onuUpgradeHwTypeHwRevision));
    prepareRead(super.getProperty(onuUpgradeHwTypeFwRevision));
    prepareRead(super.getProperty(onuUpgradeHwTypeImageName));

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(onuUpgradeHwTypeHwRevision));
    prepareRead(super.getProperty(onuUpgradeHwTypeFwRevision));
    prepareRead(super.getProperty(onuUpgradeHwTypeImageName));

    return loadAll(new int[] { 1, 1, 1 });
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(onuUpgradeHwTypeImageName));

    return save();
  }

  public boolean add() throws MibBeanException {
//    prepareSave(getProperty(onuUpgradeHwTypeHwRevision));
    prepareSave(getProperty(onuUpgradeHwTypeImageName));
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}
