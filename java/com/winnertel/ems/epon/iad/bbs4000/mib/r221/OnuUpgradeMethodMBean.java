package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class OnuUpgradeMethodMBean extends SnmpMibBean {
    public static final String utsDot3OnuUpgradeMethod = "utsDot3OnuUpgradeMethod";

    public OnuUpgradeMethodMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuUpgradeMethod, new SnmpMibBeanProperty(utsDot3OnuUpgradeMethod, ".1.3.6.1.4.1.41355.1800.2.3.1.7.6", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuUpgradeMethod() {
        return (Integer) getProperty(utsDot3OnuUpgradeMethod).getValue();
    }

    public void setUtsDot3OnuUpgradeMethod(Integer aUtsDot3OnuUpgradeMethod) {
        getProperty(utsDot3OnuUpgradeMethod).setValue(aUtsDot3OnuUpgradeMethod);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuUpgradeMethod));

        return load();
    }

  public boolean modify() throws MibBeanException {
      prepareSave(getProperty(utsDot3OnuUpgradeMethod));

      return save();
  }
}
