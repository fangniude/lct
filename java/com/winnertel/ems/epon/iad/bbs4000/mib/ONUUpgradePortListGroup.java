package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class ONUUpgradePortListGroup extends SnmpMibBean {
    public static final String utsDot3OnuUpgradeManualPortListStateBitMap = "utsDot3OnuUpgradeManualPortListStateBitMap";
    public static final String utsDot3OnuUpgradeSchedulePortListStateBitMap = "utsDot3OnuUpgradeSchedulePortListStateBitMap";

    public ONUUpgradePortListGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuUpgradeManualPortListStateBitMap, new SnmpMibBeanProperty(utsDot3OnuUpgradeManualPortListStateBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.7.1.1.1", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap, new SnmpMibBeanProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.7.1.1.2", ISnmpConstant.OCTETS));
    }

    public byte[] getUtsDot3OnuUpgradeManualPortListStateBitMap() {
        return (byte[]) getProperty(utsDot3OnuUpgradeManualPortListStateBitMap).getValue();
    }

    public void setUtsDot3OnuUpgradeManualPortListStateBitMap(byte[] onuPotListBitMap) {
        getProperty(utsDot3OnuUpgradeManualPortListStateBitMap).setValue(onuPotListBitMap);
    }

    public byte[] getUtsDot3OnuUpgradeSchedulePortListStateBitMap() {
        return (byte[]) getProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap).getValue();
    }

    public void setUtsDot3OnuUpgradeSchedulePortListStateBitMap(byte[] onuPotListBitMap) {
        getProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap).setValue(onuPotListBitMap);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuUpgradeManualPortListStateBitMap));
        prepareRead(super.getProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
      prepareRead(super.getProperty(utsDot3OnuUpgradeManualPortListStateBitMap));
      prepareRead(super.getProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap));

        return loadAll(new int[]{});
    }

  public boolean modify() throws MibBeanException {
      prepareSave(getProperty(utsDot3OnuUpgradeManualPortListStateBitMap));
      prepareSave(getProperty(utsDot3OnuUpgradeSchedulePortListStateBitMap));

      return save();
  }

  public boolean enableManualUpgradePortList() throws MibBeanException
  {
    this.setUtsDot3OnuUpgradeManualPortListStateBitMap(generateBitMap());
    return modify();
  }

  public boolean enableScheduleUpgradePortList() throws MibBeanException
  {
    this.setUtsDot3OnuUpgradeSchedulePortListStateBitMap(generateBitMap());
    return modify();
  }

  private byte[] generateBitMap()
  {
    byte[] data = new byte[384];
    for(int i = 0; i < data.length; i++)
    {
      data[i] = (byte)255;
    }

    return data;
  }
}
