package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

import java.util.Vector;

public class ONUManualUpgradeTableMBean extends SnmpMibBean {
    public static final String utsDot3OnuUpgradeForceManualPortListBitMap = "utsDot3OnuUpgradeForceManualPortListBitMap";
    public static final String utsDot3OnuUpgradeNormalManualPortListBitMap = "utsDot3OnuUpgradeNormalManualPortListBitMap";

    public ONUManualUpgradeTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuUpgradeForceManualPortListBitMap, new SnmpMibBeanProperty(utsDot3OnuUpgradeForceManualPortListBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.7.1.1.3", ISnmpConstant.OCTETS));
        initProperty(utsDot3OnuUpgradeNormalManualPortListBitMap, new SnmpMibBeanProperty(utsDot3OnuUpgradeNormalManualPortListBitMap, ".1.3.6.1.4.1.41355.1800.2.3.1.7.1.1.4", ISnmpConstant.OCTETS));
    }

    public byte[] getUtsDot3OnuUpgradeForceManualPortListBitMap() {
        return (byte[]) getProperty(utsDot3OnuUpgradeForceManualPortListBitMap).getValue();
    }

    public void setUtsDot3OnuUpgradeForceManualPortListBitMap(byte[] onuPotListBitMap) {
        getProperty(utsDot3OnuUpgradeForceManualPortListBitMap).setValue(onuPotListBitMap);
    }

    public byte[] getUtsDot3OnuUpgradeNormalManualPortListBitMap() {
        return (byte[]) getProperty(utsDot3OnuUpgradeNormalManualPortListBitMap).getValue();
    }

    public void setUtsDot3OnuUpgradeNormalManualPortListBitMap(byte[] onuPotListBitMap) {
        getProperty(utsDot3OnuUpgradeNormalManualPortListBitMap).setValue(onuPotListBitMap);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuUpgradeForceManualPortListBitMap));
        prepareRead(super.getProperty(utsDot3OnuUpgradeNormalManualPortListBitMap));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
      prepareRead(super.getProperty(utsDot3OnuUpgradeForceManualPortListBitMap));
      prepareRead(super.getProperty(utsDot3OnuUpgradeNormalManualPortListBitMap));

      return loadAll(new int[]{});
    }

  public boolean add() throws MibBeanException {
      prepareSave(getProperty(utsDot3OnuUpgradeForceManualPortListBitMap));
      prepareSave(getProperty(utsDot3OnuUpgradeNormalManualPortListBitMap));

      ONUUpgradePortListGroup group = new ONUUpgradePortListGroup(fSnmpProxy);
      group.enableManualUpgradePortList();

      return save();
  }
}
